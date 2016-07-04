/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reque.bd;

import com.reque.bean.Item;
import com.reque.infra.mysqlBD;
import com.reque.utils.CrudGenerico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author reque
 */
public class ItemBD implements CrudGenerico<Item>{
    private final mysqlBD bd;
            
    public ItemBD() {
        bd = new mysqlBD();
    }
    
    @Override
    public Item consultar(Item obj) {
        Connection c = bd.open();
        Item i = null;
        try{
           
            PreparedStatement p = c.prepareStatement("SELECT * FROM item WHERE id = ?;");
            p.setInt(1, obj.getId());
            
            ResultSet r = p.executeQuery();
            if (r.next()) {
                i = new Item();
                i.setId(r.getInt("id"));
                i.setNome(r.getString("nome"));
                i.setCategoria(r.getString("categoria"));
                i.setTipo(r.getString("tipo"));
                i.setPeso(r.getInt("peso"));
                i.setPreco(r.getDouble("preco"));
                i.setBonus(r.getString("bonus"));
            }
            
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }finally{
            bd.close(c);
        }
        return i;
    }

    @Override
    public boolean excluir(Item obj) {
        Connection c = null;
        
        try {
            c = bd.open();

            PreparedStatement p = c.prepareStatement("DELETE FROM item WHERE id = ? LIMIT 1;");
            p.setInt(1, obj.getId());
            
            p.execute(); 
            
        } catch (Exception e) {
            throw new RuntimeException(e);           
        } finally {
            bd.close(c);
        }
        
        return true;
    }

    @Override
    public List<Item> pesquisar(Item obj) {
        Connection c = null;
        List<Item> lista = new ArrayList<>();
        
        try{
           c = bd.open();
            PreparedStatement p = c.prepareStatement("SELECT * FROM item;");
            
            ResultSet r = p.executeQuery();
            while (r.next()) {
                Item i = new Item();
                i.setId(r.getInt("id"));
                i.setNome(r.getString("nome"));
                i.setCategoria(r.getString("categoria"));
                i.setTipo(r.getString("tipo"));
                i.setPeso(r.getInt("peso"));
                i.setPreco(r.getDouble("preco"));
                i.setBonus(r.getString("bonus"));
                
                lista.add(i);
            }
            
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }finally{
            bd.close(c);
        }
        return lista;
    }

    @Override
    public Item salvar(Item obj) {
        Connection c = null;
        try{
            c = bd.open();
            
            PreparedStatement p = c.prepareStatement("INSERT INTO item (nome,tipo,categoria,peso,preco,bonus) VALUES(?,?,?,?,?,?);");
            p.setString(1,obj.getNome());
            p.setString(2,obj.getTipo());
            p.setString(3, obj.getCategoria());
            p.setInt(4,obj.getPeso());
            p.setDouble(5, obj.getPreco());
            p.setString(6, obj.getBonus());
            
            p.execute();            
            
            ResultSet res = c.createStatement().executeQuery("SELECT LAST_INSERT_ID() FROM item");
            res.next();
            Integer lastID = res.getInt(1);
            obj.setId(lastID);
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }finally{
            bd.close(c);
        }
        return obj;
    }

    public void truncate() {
        Connection c = null;
        try{
            c = bd.open();
            
            PreparedStatement p = c.prepareStatement("TRUNCATE TABLE item;");
            p.execute();
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }finally{
            bd.close(c);
        }
    }
    
}
