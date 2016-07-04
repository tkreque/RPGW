/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reque.rn;

import com.reque.bd.PersonagemBD;
import com.reque.bean.Personagem;
import com.reque.utils.CrudGenericoRN;
import java.util.List;

/**
 *
 * @author reque
 */
public class PersonagemRN extends CrudGenericoRN<Personagem> {
    private final PersonagemBD pbd;

    public PersonagemRN() {
        pbd = new PersonagemBD();
    }    
    
    @Override
    public Personagem consultar(Personagem obj) {
        return pbd.consultar(obj);
    }

    @Override
    public boolean excluir(Personagem obj) {
        return pbd.excluir(obj);
    }

    @Override
    public List<Personagem> pesquisar(Personagem obj) {
        return pbd.pesquisar(obj);
    }

    @Override
    public Personagem salvar(Personagem obj) {
        return pbd.salvar(obj);
    }
    
    public void reinitializeDB(){
        try{
            pbd.truncate();
            Personagem p = new Personagem(7, "Kirof", "Ranger", "Elfo", "Reque", "M", 12, 1, 12, 1, 18, 4, 16, 3, 10, 0, 12, 1);
            salvar(p);
            p = new Personagem(10, "Sibele", "Mago", "Humano", "Bruna", "F", 10, 0, 14, 2, 12, 1, 12, 1, 18, 4, 16, 3);
            salvar(p);
            p = new Personagem(1, "Ylf", "Ladino", "Anao", "JP", "O", 12, 1, 14, 2, 16, 3, 13, 1, 10, 0, 8, -1);
            salvar(p);
            
        }catch(Exception ex){
            throw new RuntimeException("Erro no BD: "+ex);
        }
        
    }
    
}
