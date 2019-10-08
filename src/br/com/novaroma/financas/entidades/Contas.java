/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.novaroma.financas.entidades;

import java.io.Serializable;

/**
 *
 * @author André Felipe
 */
public class Contas implements Serializable{
    private String nomedaConta;
    private double dinheiroLiquido;
    private double beneficioAl;
    private double beneficioTr;
    private String riscoFinancas;
    private Atividade[] atividades;
    private String titularUser;
    
    public Contas(){}
    
    public Contas(String nomedaConta, double dinheiroLiguido, double beneficioAl, double beneficioTr, String titularUser ){
       this.nomedaConta = nomedaConta;
       this.dinheiroLiquido = dinheiroLiguido;
       this.beneficioAl = beneficioAl;
       this.beneficioTr = beneficioTr;
       this.atividades = new Atividade[1];
       this.titularUser = titularUser;
    }   

    public void setNomedaConta(String nomedaConta){ this.nomedaConta = nomedaConta; }
    public void setDinheiroLiquido(double dinheiroLiquido){ this.dinheiroLiquido = dinheiroLiquido; }
    public void setBeneficioAl(double beneficioAl){ this.beneficioAl = beneficioAl; }
    public void setBeneficioTr(double beneficioTr){ this.beneficioTr = beneficioTr; }
    public void setAtividade(Atividade atv){ this.atividades[this.atividades.length-1] = atv; this.atividades = this.geradorAtividades(this.atividades); }
    public void setTituloUser(String tituloUser){ this.titularUser = tituloUser; }
    public void setRiscoFinancas(String risco) { this.riscoFinancas = risco; }
    
    public String getNomedaConta(){ return this.nomedaConta; }
    public double getDinheiroLiquido(){ return this.dinheiroLiquido; }
    public double getBeneficioAl(){ return this.beneficioAl; }
    public double getBeneficioTr(){ return this.beneficioTr; }
    public Atividade[] getAtividade(){ return this.atividades; }
    public String getTituloUser(){ return this.titularUser; }
    public String getRiscoFinancas() { return this.riscoFinancas; }
    
    private Atividade[] geradorAtividades(Atividade[] atv){
        Atividade[] atvNova = new Atividade[atv.length+1];
        System.arraycopy(atv, 0, atvNova, 0, atv.length);
        return atvNova;
    }
}

 
    