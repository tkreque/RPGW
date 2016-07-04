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
public class Personagem {
    private int id, nivel;
    private String nome, classe, raca, pj, sexo;
    private int str, modStr, cons, modCons, dex, modDex,
            wis, modWis, inte, modInte, cha, modCha;

    public Personagem() {
    }

    public Personagem(int id, String nome, String pj) {
        this.id = id;
        this.nome = nome;
        this.pj = pj;
    }

    public Personagem(int nivel, String nome, String classe, String raca, String pj, String sexo, int str, int modStr, int cons, int modCons, int dex, int modDex, int wis, int modWis, int inte, int modInte, int cha, int modCha) {
        this.nivel = nivel;
        this.nome = nome;
        this.classe = classe;
        this.raca = raca;
        this.pj = pj;
        this.sexo = sexo;
        this.str = str;
        this.modStr = modStr;
        this.cons = cons;
        this.modCons = modCons;
        this.dex = dex;
        this.modDex = modDex;
        this.wis = wis;
        this.modWis = modWis;
        this.inte = inte;
        this.modInte = modInte;
        this.cha = cha;
        this.modCha = modCha;
    }

    public Personagem(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getPj() {
        return pj;
    }

    public void setPj(String pj) {
        this.pj = pj;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getStr() {
        return str;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public int getModStr() {
        return modStr;
    }

    public void setModStr(int modStr) {
        this.modStr = modStr;
    }

    public int getCons() {
        return cons;
    }

    public void setCons(int cons) {
        this.cons = cons;
    }

    public int getModCons() {
        return modCons;
    }

    public void setModCons(int modCons) {
        this.modCons = modCons;
    }

    public int getDex() {
        return dex;
    }

    public void setDex(int dex) {
        this.dex = dex;
    }

    public int getModDex() {
        return modDex;
    }

    public void setModDex(int modDex) {
        this.modDex = modDex;
    }

    public int getWis() {
        return wis;
    }

    public void setWis(int wis) {
        this.wis = wis;
    }

    public int getModWis() {
        return modWis;
    }

    public void setModWis(int modWis) {
        this.modWis = modWis;
    }

    public int getInte() {
        return inte;
    }

    public void setInte(int inte) {
        this.inte = inte;
    }

    public int getModInte() {
        return modInte;
    }

    public void setModInte(int modInte) {
        this.modInte = modInte;
    }

    public int getCha() {
        return cha;
    }

    public void setCha(int cha) {
        this.cha = cha;
    }

    public int getModCha() {
        return modCha;
    }

    public void setModCha(int modCha) {
        this.modCha = modCha;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.id;
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
        final Personagem other = (Personagem) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Personagem{" + "id=" + id + ", nivel=" + nivel + ", nome=" + nome + ", classe=" + classe + ", raca=" + raca + ", pj=" + pj + ", sexo=" + sexo + ", str=" + str + ", modStr=" + modStr + ", cons=" + cons + ", modCons=" + modCons + ", dex=" + dex + ", modDex=" + modDex + ", wis=" + wis + ", modWis=" + modWis + ", inte=" + inte + ", modInte=" + modInte + ", cha=" + cha + ", modCha=" + modCha + '}';
    }
    
    
    
}
