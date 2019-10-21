/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.novaroma.financas.entidades;
import br.com.novaroma.financas.entidades.Contas;
import br.com.novaroma.financas.negocio.UsuarioNegocio;
import java.io.IOException;
import java.io.Serializable;
/**
 *
 * @author aluno
 */
public class Usuarios implements Serializable{
    
    private String nome;
    private String email;
    private Contas[] conta;
    private String senha;
    private String cpf;
    
    public Usuarios(){}
    
    public Usuarios(String nome, String cpf, String email, String senha){
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.conta = new Contas[1];
    }
    
    
    public String getNome(){ 
        return this.nome; 
    }
    public String getCpf(){ 
        return this.cpf; 
    }
    public String getEmail(){ 
        return this.email; 
    }
    public String getSenha(){ 
        return this.senha; 
    }
    public Contas[] getContas(){ 
        return this.conta; 
    }
    
    public void setContas(Contas conta){ 
        this.conta[this.conta.length-1] = conta;
        this.conta = geradorContas(this.conta);
    }
    public void setNome(String nome){ 
        this.nome = nome; 
    }
    public void setCpf(String cpf){
        this.cpf = cpf; 
    }
    public void setEmail(String email){
        this.email = email; 
    }
    
    public void setSenha(String senha){ 
        this.senha = senha;
    }
    
    private Contas[] geradorContas(Contas[] conta){
        Contas[] contaNova = new Contas[conta.length+1];
        System.arraycopy(conta, 0, contaNova, 0, conta.length);
        contaNova = conta;
        return contaNova;
    }
    
//    public boolean checkingContas(String value, Usuarios user) throws IOException, ClassNotFoundException{
//        Contas[] contasNovo = userNegocio.geralContaUsuario();
//        boolean status = false;
//        for(Contas _conta : contasNovo) {
//            if(_conta.getTituloUser().equals(value)){
//                user.setContas(_conta);
//                status = true;
//            }
//        }
//        return status;
//    }
    
}
