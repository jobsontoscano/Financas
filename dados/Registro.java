/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.novaroma.financas.dados;

import java.io.IOException;

/**
 *
 * @author aluno
 */
public interface Registro {
    
    void Cadastrar(Object obj) throws IOException, ClassNotFoundException;
    
    boolean Editar(Object obj, String value) throws IOException, ClassNotFoundException;
    
    Object[] Geral() throws IOException, ClassNotFoundException; 
    
    Object Consultar(String value) throws IOException, ClassNotFoundException;
    
    boolean Deletar(String value) throws IOException, ClassNotFoundException;

}
