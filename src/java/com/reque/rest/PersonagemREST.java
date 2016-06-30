/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reque.rest;

import com.google.gson.Gson;
import java.net.URI;
import com.reque.bean.Personagem;
import com.reque.infra.RNException;
import com.reque.rn.PersonagemRN;
import com.reque.utils.CrudGenericoRest;
import java.util.List;
import javax.ws.rs.Path;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

/**
 *
 * @author reque
 */
@Path("/Personagem")
public class PersonagemREST extends CrudGenericoRest<Personagem>{
    private final PersonagemRN prn;

    public PersonagemREST() {
        prn = new PersonagemRN();
    }    

    @Override
    public Response consultarPK(String pk) {
        try {
            Personagem p = prn.consultar(new Personagem(Integer.parseInt(pk)));
            return Response.ok(p).build();
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }
    }

    @Override
    public Response pesquisar(String json) {
        try {
            Gson g = new Gson();
            Personagem p = g.fromJson(json, Personagem.class);

            List<Personagem> ret = prn.pesquisar(p);

            return gerarResponseParaCollection(ret);    
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }
    }

    @Override
    public Response listar(Integer offset, Integer limit) {
        try {
            List<Personagem> ret = prn.pesquisar(null);        
            return gerarResponseParaCollection(ret);
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }
    }

    @Override
    public Response excluirPK(String pk) {
        try {
            prn.excluir(new Personagem(Integer.parseInt(pk)));
            return Response.ok().build();
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }
    }

    @Override
    public Response salvar(Personagem obj) {
        try {
            Personagem p = prn.salvar(obj);
            URI uri = uriInfo.getAbsolutePathBuilder().path(Integer.toString(p.getId())).build();
            return Response.created(uri).build();      
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }
    }

    @Override
    protected Response gerarResponseParaCollection(List<Personagem> obj) {
        if (obj == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        
        GenericEntity<List<Personagem>> lista = new GenericEntity<List<Personagem>>(obj) {
        };
        return Response.ok(lista).build();    
    }
    
}
