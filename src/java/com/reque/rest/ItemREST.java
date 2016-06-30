/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reque.rest;

import com.google.gson.Gson;
import com.reque.bean.Item;
import com.reque.infra.RNException;
import com.reque.rn.ItemRN;
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
@Path("/Item")
public class ItemREST extends CrudGenericoRest<Item>{
    private final ItemRN irn;

    public ItemREST() {
        irn = new ItemRN();    
    }    
    
   @Override
    public Response consultarPK(String pk) {
        try {
            Item i = irn.consultar(new Item(Integer.parseInt(pk)));
            return Response.ok(i).build();
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }
    }

    @Override
    public Response pesquisar(String json) {
        try {
            Gson g = new Gson();
            Item i = g.fromJson(json, Item.class);

            List<Item> ret = irn.pesquisar(i);

            return gerarResponseParaCollection(ret);    
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }
    }

    @Override
    public Response listar(Integer offset, Integer limit) {
        try {
            List<Item> ret = irn.pesquisar(null);        
            return gerarResponseParaCollection(ret);
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }
    }

    @Override
    public Response excluirPK(String pk) {
        try {
            irn.excluir(new Item(Integer.parseInt(pk)));
            return Response.ok().build();
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }
    }

    @Override
    public Response salvar(Item obj) {
        try {
            Item p = irn.salvar(obj);
            URI uri = uriInfo.getAbsolutePathBuilder().path(Integer.toString(p.getId())).build();
            return Response.created(uri).build();      
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }
    }

    @Override
    protected Response gerarResponseParaCollection(List<Item> obj) {
        if (obj == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        
        GenericEntity<List<Item>> lista = new GenericEntity<List<Item>>(obj) {
        };
        return Response.ok(lista).build();    
    }
    
}
