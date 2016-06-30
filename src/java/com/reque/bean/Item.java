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
public class Item {
    private int id, peso;
    private String nome, tipo, categoria, bonus;
    private double preco;

    public Item() {
    }

    public Item(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Item(int id, int peso, String nome, String tipo, String categoria, String bonus, double preco) {
        this.id = id;
        this.peso = peso;
        this.nome = nome;
        this.tipo = tipo;
        this.categoria = categoria;
        this.bonus = bonus;
        this.preco = preco;
    }

    public Item(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id;
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
        final Item other = (Item) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", peso=" + peso + ", nome=" + nome + ", tipo=" + tipo + ", categoria=" + categoria + ", bonus=" + bonus + ", preco=" + preco + '}';
    }
    
    
    
}
