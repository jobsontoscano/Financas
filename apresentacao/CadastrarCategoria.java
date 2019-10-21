/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.novaroma.financas.apresentacao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import br.com.novaroma.financas.negocio.UsuarioNegocio;
import br.com.novaroma.financas.entidades.Usuarios;
import br.com.novaroma.financas.entidades.Categoria;
import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
/**
 *
 * @author jbrito
 */
public class CadastrarCategoria extends JFrame implements ActionListener{
    
    String[] choices = { "ALTO","MEDIANO", "BAIXA"};
    Usuarios user;
    UsuarioNegocio usuarioNegocio = new UsuarioNegocio();
    
    final JComboBox<String> prioridade = new JComboBox<String>(choices);
    private JButton buttonSalvarDados = new JButton("Cadastrar Categoria");
    private JButton buttonVoltar = new JButton("Voltar");
    
    private JTextField nomeTextField = new JTextField();
    //private JTextField requisitoTextField = new JTextField();
    
    private JLabel nomeLabel = new JLabel("Nome Categoria:");
    private JLabel requisitoLabel = new JLabel("Necessidade:");
    private JLabel prioridadeLabel = new JLabel("Prioriadade:");
    
    CadastrarCategoria(Usuarios user){
        layoutTela();
        this.user = user;
        
        buttonSalvarDados.setBounds(150,250,250,35);
        buttonVoltar.setBounds(150,280,250,35);
        buttonSalvarDados.addActionListener(this);
        buttonVoltar.addActionListener(this);
        
        nomeLabel.setBounds(10,60,110,25);
        prioridadeLabel.setBounds(10,100,110,25);
        //requisitoLabel.setBounds(10,140,60,25);
        
        nomeTextField.setBounds(130,60,300,25);
        prioridade.setBounds(130,100,300,25);
        //requisitoTextField.setBounds(120,140,300,25);
        
        add(nomeLabel);
        add(requisitoLabel);
        add(prioridadeLabel);
        
        add(nomeTextField);
        //add(requisitoTextField);
        add(prioridade);
        
        add(buttonSalvarDados);
        add(buttonVoltar);
    }
    
    public void layoutTela(){
        setTitle("Nova Categoria");
        setSize(600,500);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.green));
        
        setLayout(null);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == buttonSalvarDados) {
            try {
                Categoria categoriaNova = new Categoria(nomeTextField.getText(),true,1);
                JOptionPane.showMessageDialog(null, usuarioNegocio.cadastrarCategoriaUsuario(user, categoriaNova));
                this.setVisible(false);
                new Perfil(user);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CadastrarCategoria.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(CadastrarCategoria.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(ae.getSource() == buttonVoltar){
            this.setVisible(false);
            try {
                new Perfil(user);
            } catch (IOException ex) {
                Logger.getLogger(CadastrarCategoria.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CadastrarCategoria.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
