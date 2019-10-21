/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.novaroma.financas.apresentacao;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
/**
 *
 * @author toscano
 */
public class Home extends JFrame implements ActionListener{
    JButton buttonCadastrarUsuario = new JButton("Cadastrar");
    JButton buttonLoginUsuario = new JButton("Entrar");
    
    Home(){
        layoutTela();
        
        buttonCadastrarUsuario.setBounds(80,200,200,80);
        buttonLoginUsuario.setBounds(310,200,200,80);
        
        add(buttonCadastrarUsuario);
        add(buttonLoginUsuario);
        
        buttonCadastrarUsuario.addActionListener(this);
        buttonLoginUsuario.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == buttonCadastrarUsuario){
            setVisible(false);
            new CadastrarUsuario();
            
        }else if(ae.getSource() == buttonLoginUsuario){
            setVisible(false);
            new Login();
        }
    }
    
    public void layoutTela(){
        setTitle("Home");
        setSize(600,500);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.green));
        setLayout(null);
    }
    
    public static void main(String[]args){
        new Home();
    }
}
