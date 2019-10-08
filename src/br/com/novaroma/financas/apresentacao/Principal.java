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
        //String nome = JOptionPane.showInputDialog("Digite seu nome:");
        //String cpf = JOptionPane.showInputDialog("Digite seu CPF:");
        //String email = JOptionPane.showInputDialog("Digite seu email:");
        //String senha = JOptionPane.showInputDialog("Digite sua senha:");
        //Usuarios user = new Usuarios(nome, cpf, email, senha);
        
        //JOptionPane.showMessageDialog(null, userNegocio.cadastrarUsuarios(user));
        userNegocio.GeralUsuarios();
        String busca = JOptionPane.showInputDialog("Digite um cpf para buscar usuario: ");
        Usuarios  user = userNegocio.buscarUsuario(busca);
        
        //userNegocio.cadastrarCategoriaUsuario(user, telaCategoria());
        
        if(userNegocio.buscarUsuario(busca) != null){
            user = userNegocio.buscarUsuario(busca);
            JOptionPane.showMessageDialog(null, "Tabela de Usuarios:"
                    + "Nome: "+user.getNome()+"\n"
                    + "Email: "+user.getEmail()+"\n"
                    + "CPF: "+user.getCpf()+"\n");
        }else{
            JOptionPane.showMessageDialog(null, "Seu Usuario Não foi encontrado");
        }
    }
}
