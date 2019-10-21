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
    private Usuarios user = new Usuarios();
    private Contas conta = new Contas();
    
    private JButton buttonSalvarDados = new JButton("Atualizar Conta");
    private JButton buttonVoltar = new JButton("Voltar Menu");
    
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
    
    EditarConta(Contas conta, Usuarios user){
        layoutTela();
        this.user = user;
        this.conta = conta;
        
        buttonSalvarDados.setBounds(150,280,250,35);
        buttonVoltar.setBounds(150,320,250,35);
        buttonSalvarDados.addActionListener(this);
        buttonVoltar.addActionListener(this);
        
        nomeContaLabel.setBounds(60,60,60,25);
        salarioLiquidoLabel.setBounds(60,100,60,25);
        beneficioALLabel.setBounds(60,140,60,25);
        beneficioTRLabel.setBounds(60,185,60,25);
        titularContaLabel.setBounds(60,230,60,25);
        
        nomeContaTextField.setBounds(120,60,300,25);
        salarioLiquidoTextField.setBounds(120,100,300,25);
        beneficioALTextField.setBounds(120,140,300,25);
        beneficioTRTextField.setBounds(120,185,300,25);
        titularContaTextField.setBounds(120,230,300,25);
        
        add(nomeContaLabel);
        add(salarioLiquidoLabel);
        add(beneficioALLabel);
        add(beneficioTRLabel);
        add(titularContaLabel);
        
        nomeContaTextField.setText(conta.getNomedaConta());
        salarioLiquidoTextField.setText(""+conta.getDinheiroLiquido());
        beneficioALTextField.setText(""+conta.getBeneficioAl());
        beneficioTRTextField.setText(""+conta.getBeneficioTr());
        titularContaTextField.setText(conta.getTituloUser());
        
        add(nomeContaTextField);
        add(salarioLiquidoTextField);
        add(beneficioALTextField);
        add(beneficioTRTextField);
        add(titularContaTextField);
        
        add(buttonSalvarDados);
        add(buttonVoltar);
        
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
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == buttonVoltar) {
            try {
                new Perfil(user);
                this.setVisible(false);
            } catch (IOException ex) {
                Logger.getLogger(EditarConta.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(EditarConta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(ae.getSource() == buttonSalvarDados){
            try {
                JOptionPane.showMessageDialog(null, userNegocio.EditarContaDoUsuario(conta));
                this.setVisible(false);
                new Perfil(user);
            } catch (IOException ex) {
                Logger.getLogger(EditarConta.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(EditarConta.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
}
