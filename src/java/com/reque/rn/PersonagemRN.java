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
    
}
