/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reque.bd;

import com.reque.bean.Personagem;
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
public class PersonagemBD implements CrudGenerico<Personagem>{
    private final mysqlBD bd;
            
    public PersonagemBD() {
        bd = new mysqlBD();
    }
    
    @Override
    public Personagem consultar(Personagem obj) {
        Connection c = bd.open();
        Personagem ps = null;
        try{
           
            PreparedStatement p = c.prepareStatement("SELECT * FROM personagem WHERE id = ?;");
            p.setInt(1, obj.getId());
            
            ResultSet r = p.executeQuery();
            if (r.next()) {
                ps = new Personagem();
                ps.setId(r.getInt("id"));
                ps.setNome(r.getString("nome"));
                ps.setClasse(r.getString("classe"));
                ps.setRaca(r.getString("raca"));
                ps.setPj(r.getString("pj"));
                ps.setNivel(r.getInt("nivel"));
                ps.setSexo(r.getString("sexo"));
                ps.setStr(r.getInt("str"));
                ps.setCons(r.getInt("cons"));
                ps.setDex(r.getInt("dex"));
                ps.setWis(r.getInt("wis"));
                ps.setInte(r.getInt("inte"));
                ps.setCha(r.getInt("cha"));
                ps.setModStr(r.getInt("modStr"));
                ps.setModCons(r.getInt("modCons"));
                ps.setModDex(r.getInt("modDex"));
                ps.setModWis(r.getInt("modWis"));
                ps.setModInte(r.getInt("modInte"));
                ps.setModCha(r.getInt("modCha"));
            }
            
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }finally{
            bd.close(c);
        }
        return ps;
    }

    @Override
    public boolean excluir(Personagem obj) {
        Connection c = null;
        
        try {
            c = bd.open();

            PreparedStatement p = c.prepareStatement("DELETE FROM personagem WHERE id = ? LIMIT 1;");
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
    public List<Personagem> pesquisar(Personagem obj) {
        Connection c = null;
        List<Personagem> lista = new ArrayList<>();
        
        try{
           c = bd.open();
            PreparedStatement p = c.prepareStatement("SELECT * FROM personagem;");
            
            ResultSet r = p.executeQuery();
            while (r.next()) {
                Personagem ps = new Personagem();
                ps.setId(r.getInt("id"));
                ps.setNome(r.getString("nome"));
                ps.setClasse(r.getString("classe"));
                ps.setRaca(r.getString("raca"));
                ps.setPj(r.getString("pj"));
                ps.setNivel(r.getInt("nivel"));
                ps.setSexo(r.getString("sexo"));
                ps.setStr(r.getInt("str"));
                ps.setCons(r.getInt("cons"));
                ps.setDex(r.getInt("dex"));
                ps.setWis(r.getInt("wis"));
                ps.setInte(r.getInt("inte"));
                ps.setCha(r.getInt("cha"));
                ps.setModStr(r.getInt("modStr"));
                ps.setModCons(r.getInt("modCons"));
                ps.setModDex(r.getInt("modDex"));
                ps.setModWis(r.getInt("modWis"));
                ps.setModInte(r.getInt("modInte"));
                ps.setModCha(r.getInt("modCha"));
                
                lista.add(ps);
            }
            
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }finally{
            bd.close(c);
        }
        return lista;
    }

    @Override
    public Personagem salvar(Personagem obj) {
         Connection c = null;
        try{
            c = bd.open();
            
            PreparedStatement p = c.prepareStatement("INSERT INTO personagem (nome,classe,raca,pj,nivel,sexo,str,cons,dex,wis,inte,cha,modStr,modCons,modDex,modWis,modInte,modCha) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
            p.setString(1,obj.getNome());
            p.setString(2,obj.getClasse());
            p.setString(3,obj.getRaca());
            p.setString(4,obj.getPj());
            p.setInt(5,obj.getNivel());
            p.setString(6,obj.getSexo());
            p.setInt(7,obj.getStr());
            p.setInt(8,obj.getCons());
            p.setInt(9,obj.getDex());
            p.setInt(10,obj.getWis());
            p.setInt(11,obj.getInte());
            p.setInt(12,obj.getCha());
            p.setInt(13,obj.getModStr());
            p.setInt(14,obj.getModCons());
            p.setInt(15,obj.getModDex());
            p.setInt(16,obj.getModWis());
            p.setInt(17,obj.getModInte());
            p.setInt(18,obj.getModCha());
            
            p.execute();            
            
            ResultSet res = c.createStatement().executeQuery("SELECT LAST_INSERT_ID() FROM personagem");
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
            
            PreparedStatement p = c.prepareStatement("TRUNCATE TABLE personagem;");
            p.execute();
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }finally{
            bd.close(c);
        }
    }
}
