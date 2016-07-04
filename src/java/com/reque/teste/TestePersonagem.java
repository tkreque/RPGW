/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reque.teste;

import com.reque.bean.Personagem;
import com.reque.rn.PersonagemRN;

/**
 *
 * @author reque
 */
public class TestePersonagem {
    public static void main(String[] args) {
        PersonagemRN prn = new PersonagemRN();
        
        /*
        //Teste de inserção e remoção
        Personagem p = new Personagem();
        p.setNome("Eluk");
        p.setClasse("Bardo");
        p.setRaca("Halfling");
        p.setPj("RMartin");
        p.setSexo("M");
        p.setNivel(12);
        p.setStr(12);
        p.setCons(14);
        p.setDex(16);
        p.setWis(13);
        p.setInte(10);
        p.setCha(15);
        p.setModStr(1);
        p.setModCons(2);
        p.setModDex(3);
        p.setModWis(1);
        p.setModInte(0);
        p.setModCha(2);
        
        System.out.println(prn.salvar(p));
        System.out.println("Excluido: "+prn.excluir(p));
        */       
        
        // Reiniciar tabela de persoangem
        prn.reinitializeDB();
       
    }
    
}
