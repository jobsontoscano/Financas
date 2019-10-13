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
import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
/**
 *
 * @author toscano
 */
public class Login extends JFrame implements ActionListener{
    
    private UsuarioNegocio userNegocio = new UsuarioNegocio();
    
    private JLabel cpfLabel = new JLabel("CPF:");
    
    private JTextField cpfTextField = new JTextField();
    
    private JButton buttonLogin = new JButton("Entrar");
    
    Login(){
        layoutTela();
        
        buttonLogin.setBounds(150,250,250,35);
        buttonLogin.addActionListener(this);
        
        cpfLabel.setBounds(60,130,60,25);
        
        cpfTextField.setBounds(120,130,300,25);
        
        add(cpfLabel);
        add(cpfTextField);
        add(buttonLogin);
        
    }
    public void layoutTela(){
        setTitle("Login");
        setSize(600,500);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.green));
        
        setLayout(null);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == buttonLogin){
            try {
                Usuarios user = userNegocio.buscarUsuario(cpfTextField.getText());
                
                if(user != null){
                    JOptionPane.showMessageDialog(null, "Dados confirmados com sucesso");
                    setVisible(false);
                    new Perfil(user);
                }else{
                    JOptionPane.showMessageDialog(null, "Usuario não encontrado, Tente novamente.");
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
