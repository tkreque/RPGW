/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reque.bean;

/**
 *
 * @author reque
 */
public class Missao {
    private int id, nd, xp;
    private String nome, chefe, monstros;

    public Missao() {
    }

    public Missao(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Missao(int id, int nd, int xp, String nome, String chefe, String monstros) {
        this.id = id;
        this.nd = nd;
        this.xp = xp;
        this.nome = nome;
        this.chefe = chefe;
        this.monstros = monstros;
    }

    public Missao(int id) {
        this.id = id;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNd() {
        return nd;
    }

    public void setNd(int nd) {
        this.nd = nd;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getChefe() {
        return chefe;
    }

    public void setChefe(String chefe) {
        this.chefe = chefe;
    }

    public String getMonstros() {
        return monstros;
    }

    public void setMonstros(String monstros) {
        this.monstros = monstros;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Missao other = (Missao) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Missao{" + "id=" + id + ", nd=" + nd + ", xp=" + xp + ", nome=" + nome + ", chefe=" + chefe + ", monstros=" + monstros + '}';
    }
    
    
}
