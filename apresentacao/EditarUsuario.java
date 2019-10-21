/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.novaroma.financas.apresentacao;
import static br.com.novaroma.financas.apresentacao.Principal.userNegocio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import br.com.novaroma.financas.negocio.UsuarioNegocio;
import br.com.novaroma.financas.entidades.Usuarios;
import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
/**
 *
 * @author toscano
 */
public class EditarUsuario extends JFrame implements ActionListener{
    
    private UsuarioNegocio userNegocio = new UsuarioNegocio();
    private Usuarios user = new Usuarios();
    
    private JButton buttonSalvarDados = new JButton("Atualizar Cadastro");
    private JButton buttonVoltar = new JButton("Voltar");
    
    private JTextField nomeTextField = new JTextField();
    private JTextField emailTextField = new JTextField();
    private JTextField cpfTextField = new JTextField();
    private JTextField senhaTextField = new JTextField();
    
    private JLabel nomeLabel = new JLabel("Nome:");
    private JLabel emailLabel = new JLabel("Email:");
    private JLabel cpfLabel = new JLabel("CPF:");
    private JLabel senhaLabel = new JLabel("Senha:");
    
    EditarUsuario(Usuarios user){
        layoutTela();
        this.user = user;
        
        buttonSalvarDados.setBounds(150,250,250,35);
        buttonVoltar.setBounds(150,280,250,35);
        buttonSalvarDados.addActionListener(this);
        buttonVoltar.addActionListener(this);
        
        nomeLabel.setBounds(60,60,60,25);
        emailLabel.setBounds(60,100,60,25);
        cpfLabel.setBounds(60,140,60,25);
        senhaLabel.setBounds(60,185,60,25);
        
        nomeTextField.setBounds(120,60,300,25);
        emailTextField.setBounds(120,100,300,25);
        cpfTextField.setBounds(120,140,300,25);
        senhaTextField.setBounds(120,185,300,25);
        
        add(nomeLabel);
        add(emailLabel);
        add(cpfLabel);
        add(senhaLabel);
        
        nomeTextField.setText(user.getNome());
        emailTextField.setText(user.getEmail());
        cpfTextField.setText(user.getCpf());
        senhaTextField.setText(user.getSenha());
        
        add(nomeTextField);
        add(emailTextField);
        add(cpfTextField);
        add(senhaTextField);
        
        add(buttonSalvarDados);
        add(buttonVoltar);
        
    }
    
    public void layoutTela(){
        setTitle("Editando Perfil");
        setSize(600,500);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.green));
        
        setLayout(null);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == buttonSalvarDados){
            Usuarios user = new Usuarios(nomeTextField.getText(),cpfTextField.getText(),
                    emailTextField.getText(),senhaTextField.getText());
            try {
                JOptionPane.showMessageDialog(null, userNegocio.editarUsuario(user));
                setVisible(false);
                new Perfil(user);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(ae.getSource() == buttonVoltar){
            this.setVisible(false);
            try {
                new Perfil(user);
            } catch (IOException ex) {
                Logger.getLogger(EditarUsuario.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(EditarUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}

