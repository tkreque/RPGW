/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reque.rest;

import com.google.gson.Gson;
import com.reque.bean.Missao;
import com.reque.infra.RNException;
import com.reque.rn.MissaoRN;
import com.reque.utils.CrudGenericoRest;
import java.net.URI;
import java.util.List;
import javax.ws.rs.Path;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

/**
 *
 * @author reque
 */
@Path("/Missao")
public class MissaoREST extends CrudGenericoRest<Missao>{
    private final MissaoRN mrn;

    public MissaoREST() {
        mrn = new MissaoRN();
    }
    
    @Override
    public Response consultarPK(String pk) {
        try {
            Missao m = mrn.consultar(new Missao(Integer.parseInt(pk)));
            return Response.ok(new Gson().toJson(m)).build();
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }
    }

    @Override
    public Response pesquisar(String json) {
        try {
            Gson g = new Gson();
            Missao m = g.fromJson(json, Missao.class);

            List<Missao> ret = mrn.pesquisar(m);

            return gerarResponseParaCollection(ret);    
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }
    }

    @Override
    public Response listar(Integer offset, Integer limit) {
        try {
            List<Missao> ret = mrn.pesquisar(null);        
            return gerarResponseParaCollection(ret);
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }
    }

    @Override
    public Response excluirPK(String pk) {
        try {
            mrn.excluir(new Missao(Integer.parseInt(pk)));
            return Response.ok().build();
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }
    }

    @Override
    public Response salvar(String obj) {
        try {
            Missao m = mrn.salvar(new Gson().fromJson(obj, Missao.class));
            URI uri = uriInfo.getAbsolutePathBuilder().path(Integer.toString(m.getId())).build();
            return Response.created(uri).build();      
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }
    }

    @Override
    protected Response gerarResponseParaCollection(List<Missao> obj) {
        if (obj == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        
        return Response.ok(new Gson().toJson(obj)).build();    
    }
    
}
