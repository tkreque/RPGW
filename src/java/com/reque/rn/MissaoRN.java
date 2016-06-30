/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reque.rn;

import com.reque.bd.MissaoBD;
import com.reque.bean.Missao;
import com.reque.utils.CrudGenericoRN;
import java.util.List;

/**
 *
 * @author reque
 */
public class MissaoRN extends CrudGenericoRN<Missao>{
    private final MissaoBD mbd;
    
    public MissaoRN() {
        mbd = new MissaoBD();
    }
    
    @Override
    public Missao consultar(Missao obj) {
        return mbd.consultar(obj);
    }

    @Override
    public boolean excluir(Missao obj) {
        return mbd.excluir(obj);
    }

    @Override
    public List<Missao> pesquisar(Missao obj) {
        return mbd.pesquisar(obj);
    }

    @Override
    public Missao salvar(Missao obj) {
        return mbd.salvar(obj);
    }
    
}
