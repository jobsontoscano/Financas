/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.novaroma.financas.entidades;

import java.io.Serializable;

/**
 *
 * @author toscano
 */
public class Atividade implements Serializable{
    private String nomeAtividade;
    private float custoTotal;
    private int parcelas;
    private Categoria categoria;
    
    Atividade(){}
    
    Atividade(String nomeAtividade, float custoTotal, int parcelas, Categoria categoria){
        this.nomeAtividade = nomeAtividade;
        this.custoTotal = custoTotal;
        this.parcelas = parcelas;
        this.categoria = categoria;
    }
    
    public void setNomeAtividade(String nomeAtividade){ this.nomeAtividade = nomeAtividade; }
    public void setCustoTotal(float custoTotal){ this.custoTotal = custoTotal; }
    public void setParcelas(int parcelas){ this.parcelas = parcelas; }
    public void setCategoria(Categoria categoria){ this.categoria = categoria; }
    
    public String getNomeAtividade(){ return this.nomeAtividade; }
    public float getCustoTotal(){ return this.custoTotal; }
    public int getParcelas(){ return this.parcelas; }
    public Categoria getCategoria(){ return this.categoria; }
    
}
