/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reque.bd;

import com.reque.bean.Missao;
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
public class MissaoBD implements CrudGenerico<Missao>{
    private final mysqlBD bd;
            
    public MissaoBD() {
        bd = new mysqlBD();
    }
    
    @Override
    public Missao consultar(Missao obj) {
        Connection c = bd.open();
        Missao m = null;
        try{
           
            PreparedStatement p = c.prepareStatement("SELECT * FROM missao WHERE id = ?;");
            p.setInt(1, obj.getId());
            
            ResultSet r = p.executeQuery();
            if (r.next()) {
                m = new Missao();
                m.setId(r.getInt("id"));
                m.setNome(r.getString("nome"));
                m.setMonstros(r.getString("monstros"));
                m.setChefe(r.getString("chefe"));
                m.setNd(r.getInt("nd"));
                m.setXp(r.getInt("xp"));                
            }
            
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }finally{
            bd.close(c);
        }
        return m;
    }

    @Override
    public boolean excluir(Missao obj) {
        Connection c = null;
        
        try {
            c = bd.open();

            PreparedStatement p = c.prepareStatement("DELETE FROM missao WHERE id = ? LIMIT 1;");
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
    public List<Missao> pesquisar(Missao obj) {
        Connection c = null;
        List<Missao> lista = new ArrayList<>();
        
        try{
           c = bd.open();
            PreparedStatement p = c.prepareStatement("SELECT * FROM missao;");
            
            ResultSet r = p.executeQuery();
            while (r.next()) {
                Missao m = new Missao();
                m.setId(r.getInt("id"));
                m.setNome(r.getString("nome"));
                m.setMonstros(r.getString("monstros"));
                m.setChefe(r.getString("chefe"));
                m.setNd(r.getInt("nd"));
                m.setXp(r.getInt("xp")); 
                
                lista.add(m);
            }
            
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }finally{
            bd.close(c);
        }
        return lista;
    }

    @Override
    public Missao salvar(Missao obj) {
         Connection c = null;
        try{
            c = bd.open();
            
            PreparedStatement p = c.prepareStatement("INSERT INTO missao (nome,monstros,chefe,nd,xp) VALUES(?,?,?,?,?);");
            p.setString(1,obj.getNome());
            p.setString(2, obj.getMonstros());
            p.setString(3, obj.getChefe());
            p.setInt(4, obj.getNd());
            p.setInt(5, obj.getXp());
            
            p.execute();            
            
            ResultSet res = c.createStatement().executeQuery("SELECT LAST_INSERT_ID() FROM missao");
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
            
            PreparedStatement p = c.prepareStatement("TRUNCATE TABLE missao;");
            p.execute();
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }finally{
            bd.close(c);
        }
    }
}
