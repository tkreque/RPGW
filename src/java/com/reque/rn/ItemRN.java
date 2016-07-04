/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reque.rn;

import com.reque.bd.ItemBD;
import com.reque.bean.Item;
import com.reque.utils.CrudGenericoRN;
import java.util.List;

/**
 *
 * @author reque
 */
public class ItemRN extends CrudGenericoRN<Item>{
    private final ItemBD ibd;
    
    public ItemRN() {
        ibd = new ItemBD();
    }

    @Override
    public Item consultar(Item obj) {
        return ibd.consultar(obj);
    }

    @Override
    public boolean excluir(Item obj) {
        return ibd.excluir(obj);
    }

    @Override
    public List<Item> pesquisar(Item obj) {
        return ibd.pesquisar(obj);
    }

    @Override
    public Item salvar(Item obj) {
        return ibd.salvar(obj);
    }
    
    public void reinitializeDB(){
        try{
            ibd.truncate();
            Item i = new Item(10, "Espada curta", "Cortante", "Arma", "Dano: 1d6, Critico: x2", 15);
            salvar(i);
            i = new Item(6, "Lança curta", "Perfurante", "Arma", "Dano: 1d6, Critico: x3", 10);
            salvar(i);
            i = new Item(28, "Espada Bastarda", "Cortante", "Arma", "Dano: 2d6, Critico: x2", 60);
            salvar(i);
            i = new Item(13, "Armadura de couro", "Leve", "Armadura", "CA: 2, Penalidade: 5%", 12);
            salvar(i);
            i = new Item(30, "Cota de malha", "Pesada", "Armadura", "CA: 4, Penalidade: 15%", 42);
            salvar(i);
            i = new Item(14, "Escudo pequeno de metal", "Escudo", "Armadura", "CA: 1, Penalidade: 2%", 8);
            salvar(i);
        }catch(Exception ex){
            throw new RuntimeException("Erro no BD: "+ex);
        }
        
    }
}
