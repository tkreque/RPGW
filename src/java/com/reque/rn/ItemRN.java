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
    
}
