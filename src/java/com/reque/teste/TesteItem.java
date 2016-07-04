/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reque.teste;

import com.reque.bean.Item;
import com.reque.rn.ItemRN;

/**
 *
 * @author reque
 */
public class TesteItem {
    public static void main(String[] args) {
        ItemRN irn = new ItemRN();
        
        /*
        //Teste de inserção e remoção
        Item i = new Item();
        i.setNome("Espada Longa");
        i.setPeso(26);
        i.setPreco(24);
        i.setTipo("Cortante");
        i.setCategoria("Arma");
        i.setBonus("dano:1d8, critico: x2");
        
        System.out.println(irn.salvar(i));
        System.out.println("Excluido: "+irn.excluir(i));
        */       
        
        // Reiniciar tabela de item
        irn.reinitializeDB();
    
    }
}
