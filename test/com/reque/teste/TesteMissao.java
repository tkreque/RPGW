/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reque.teste;

import com.reque.bean.Missao;
import com.reque.rn.MissaoRN;

/**
 *
 * @author reque
 */
public class TesteMissao {
    public static void main(String[] args) {
       MissaoRN mrn = new MissaoRN();
        
        /*
        //Teste de inserção e remoção
        Missao m = new Missao();
        m.setNome("A longa caminhada");
        m.setNd(10);
        m.setXp(23000);
        m.setChefe("O andarilho da areia");
        m.setMonstros("Elemental de pedra, Golem de lama, Dragão vermelho");
        
        System.out.println(mrn.salvar(m));
        System.out.println("Excluido: "+mrn.excluir(m));
        */       
        
        // Reiniciar tabela de missao
        mrn.reinitializeDB(); 
    }
    
}
