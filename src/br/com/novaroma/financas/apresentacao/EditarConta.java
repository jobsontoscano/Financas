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
 * @author jbrito
 */
public class EditarConta extends JFrame implements ActionListener{
    private UsuarioNegocio userNegocio = new UsuarioNegocio();
    
    private JButton buttonSalvarDados = new JButton("Atualizar Cadastro");
    
    private JTextField nomeContaTextField = new JTextField();
    private JTextField salarioLiquidoTextField = new JTextField();
    private JTextField beneficioALTextField = new JTextField();
    private JTextField beneficioTRTextField = new JTextField();
    private JTextField titularContaTextField = new JTextField();
    
    private JLabel nomeContaLabel = new JLabel("Nome:");
    private JLabel salarioLiquidoLabel = new JLabel("Salario Liquido:");
    private JLabel beneficioALLabel = new JLabel("Beneficio AL:");
    private JLabel beneficioTRLabel = new JLabel("Beneficio TR:");
    private JLabel titularContaLabel = new JLabel("Titular da Conta:");
    
    EditarConta(Contas conta){
        layoutTela();
        
        buttonSalvarDados.setBounds(150,250,250,35);
        buttonSalvarDados.addActionListener(this);
        
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
        
        nomeTextField.setText(conta.getNomedaConta());
        emailTextField.setText(""+conta.getDinheiroLiquido());
        cpfTextField.setText(""+conta.getBeneficioAl());
        senhaTextField.setText(""+conta.getBeneficioTr());
        senhaTextField.setText(conta.getTituloUser());
        
        add(nomeTextField);
        add(emailTextField);
        add(cpfTextField);
        add(senhaTextField);
        
        add(buttonSalvarDados);
        
    }
    
    public void layoutTela(){
        setTitle("Editando Conta");
        setSize(600,500);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.green));
        
        setLayout(null);
    }
    
    public void actionPerformed(ActionEvent ae) {}
    
}
