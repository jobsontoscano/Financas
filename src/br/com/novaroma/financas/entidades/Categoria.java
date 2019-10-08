/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.novaroma.financas.entidades;

import java.io.Serializable;

/**
 *
 * @author Everaldo
 */
public class Categoria implements Serializable {
    private String nomeCategoria;
    private boolean statusPrioridade;
    private int niveldePrioridade;
    private double custodoSalario;
    
    public Categoria(){}
    
    public Categoria(String nomeCategoria, boolean statusPrioridade, int niveldePrioridade, double custodoSalario){
        this.nomeCategoria = nomeCategoria;
        this.statusPrioridade = statusPrioridade;
        this.niveldePrioridade = niveldePrioridade;
        this.custodoSalario = custodoSalario;
    }
    
  
    
    public String getNomeCategoria(){ return this.nomeCategoria; }
    public boolean getstatusPrioridade(){ return this.statusPrioridade; }
    public int getniveldePrioridade(){ return this.niveldePrioridade; }
    public double getcustoSalario(){ return this.custodoSalario; }
    
    public void setnomeCategoria(String nomeCategoria){ this.nomeCategoria = nomeCategoria; }
    public void setstatusPrioridade(boolean statusPrioridade){ this.statusPrioridade = statusPrioridade;} 
    public void setniveldePrioridade(int niveldePrioridade){this.niveldePrioridade = niveldePrioridade;} 
    public void setcustoSalario(double custoSalario){ this.custodoSalario = custodoSalario; }
    
    
}
       
    
    

