/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.novaroma.financas.entidades;
import br.com.novaroma.financas.entidades.Contas;
import java.io.Serializable;
/**
 *
 * @author aluno
 */
public class Usuarios implements Serializable{
    private String email;
    private Contas[] conta;
    private String senha;
    private String nome;
    private String cpf;
    
    public Usuarios(){}
    
    public Usuarios(String nome, String cpf, String email, String senha){
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.conta = new Contas[1];
    }
    
    
    public String getNome(){ return this.nome; }
    public String getCpf(){ return this.cpf; }
    public String getEmail(){ return this.email; }
    public void setContas(Contas conta){ this.conta[this.conta.length-1] = conta; this.conta = this.geradorContas(this.conta); }
    public String getSenha(){ return this.senha; }
    
    public void setNome(String nome){ this.nome = nome; }
    public void setCpf(String cpf){ this.cpf = cpf; }
    public void setEmail(String email){ this.email = email; }
    public void setSenha(String senha){ this.senha = senha; }
    
    private Contas[] geradorContas(Contas[] conta){
        Contas[] contaNova = new Contas[conta.length+1];
        System.arraycopy(conta, 0, contaNova, 0, conta.length);
        return contaNova;
    }
    
}
