/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.novaroma.financas.apresentacao;
import br.com.novaroma.financas.entidades.Usuarios;
import br.com.novaroma.financas.negocio.UsuarioNegocio;
import java.io.IOException;
import javax.swing.JOptionPane;
/**
 *
 * @author toscano
 */
public class Principal {
    public static UsuarioNegocio userNegocio = new UsuarioNegocio();
    
    public static void main(String[] args) throws ClassNotFoundException, IOException{
       new Home();
        
    }
}
