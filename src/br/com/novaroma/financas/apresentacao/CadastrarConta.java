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
import br.com.novaroma.financas.entidades.Contas;
import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;

/**
 *
 * @author toscano
 */
public class CadastrarConta extends JFrame implements ActionListener{
    private UsuarioNegocio userNegocio = new UsuarioNegocio();
    private Usuarios userConta;
    
    private JButton buttonSalvarConta = new JButton("Finalizar Cadastro");
    
    private JTextField nomeTextField = new JTextField();
    private JTextField liquidoTextField = new JTextField();
    private JTextField beneficioALTextField = new JTextField();
    private JTextField beneficioTRTextField = new JTextField();
    private JTextField titularTextField = new JTextField();
    
    private JLabel nomeLabel = new JLabel("Nome para Conta:");
    private JLabel liquidoLabel = new JLabel("Salario Liquido:");
    private JLabel beneficioALLabel = new JLabel("Beneficio Alimentacao:");
    private JLabel beneficioTRLabel = new JLabel("Beneficio Transporte:");
    private JLabel titularLabel = new JLabel("Nome do Titular:");
    
    CadastrarConta(Usuarios user){
        this.userConta = user;
        layoutTela(user.getNome());
        
        buttonSalvarConta.setBounds(150,275,250,35);
        buttonSalvarConta.addActionListener(this);
        
        nomeLabel.setBounds(30,60,140,25);
        liquidoLabel.setBounds(30,100,140,25);
        beneficioALLabel.setBounds(30,140,140,25);
        beneficioTRLabel.setBounds(30,185,140,25);
        titularLabel.setBounds(30,225,140,25);
        
        nomeTextField.setBounds(180,60,300,25);
        liquidoTextField.setBounds(180,100,300,25);
        beneficioALTextField.setBounds(180,140,300,25);
        beneficioTRTextField.setBounds(180,185,300,25);
        titularTextField.setBounds(180,225,300,25);
        
        titularTextField.setText(user.getNome());
        add(nomeLabel);
        add(liquidoLabel);
        add(beneficioALLabel);
        add(beneficioTRLabel);
        add(titularLabel);
        
        add(nomeTextField);
        add(liquidoTextField);
        add(beneficioALTextField);
        add(beneficioTRTextField);
        add(titularTextField);
        
        add(buttonSalvarConta);
        
    }
    
    public void layoutTela(String nome){
        setTitle("Criando Conta de "+nome);
        setSize(600,500);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.green));
        
        setLayout(null);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == buttonSalvarConta){
            try {
                double liquido = Double.parseDouble(liquidoTextField.getText());
                double beneficioAL = Double.parseDouble(beneficioALTextField.getText());
                double beneficioTR = Double.parseDouble(beneficioTRTextField.getText());
                Contas conta = new Contas(nomeTextField.getText(),liquido,beneficioAL
                        ,beneficioTR,titularTextField.getText());
                JOptionPane.showMessageDialog(null,userNegocio.cadastrarContaUsuario(userConta, conta));
                this.setVisible(false);
                new Perfil(userConta);
            } catch (IOException ex) {
                Logger.getLogger(CadastrarConta.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CadastrarConta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
