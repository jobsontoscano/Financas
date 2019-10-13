/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.novaroma.financas.apresentacao;
import br.com.novaroma.financas.entidades.Contas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import br.com.novaroma.financas.negocio.UsuarioNegocio;
import br.com.novaroma.financas.entidades.Usuarios;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
/**
 *
 * @author toscano
 */
public class Perfil extends JFrame implements ActionListener{
    
    private Usuarios user;
    private UsuarioNegocio userNegocio = new UsuarioNegocio();
    private JTable tabelaContas;
    private String[]  coluna = {"Nome da Conta","Nome do Titular","Editar Conta","Deletar Conta"};
    private Object [][] dados = new Object[4][4];
    
    private JLabel[] nomeContas = new JLabel[100];
    private JLabel[] nomeTitular = new JLabel[100];
    private JButton[] editarContas = new JButton[100];
    private JButton[] deletarContas = new JButton[100];
    
    private JButton buttonEditarUsuario = new JButton("Editar");
    private JButton buttonSairUsuario = new JButton("Sair");
    private JButton buttonCriarConta = new JButton("Conta +");
    private JButton buttonCriarCategoria = new JButton("Categoria +");
    
    private JLabel nomeLabelUsuario = new JLabel("Nome:");
    private JLabel emailLabelUsuario = new JLabel("Email:");
    private JLabel cpfLabelUsuario = new JLabel("CPF:");
    
    Perfil(Usuarios user) throws IOException, ClassNotFoundException{
        this.user = user;
        this.setTitle("Perfil de "+user.getNome());
        this.setSize(600,500);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
        
        buttonEditarUsuario.addActionListener(this);
        buttonCriarConta.addActionListener(this);
        
        Container telaMain = this.getContentPane();
        telaMain.setLayout(new BorderLayout(8,6));
        telaMain.setBackground(Color.YELLOW);
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.green));
        
        JPanel topPanel = new JPanel();
        topPanel.setBorder(new LineBorder(Color.black,3));
        topPanel.setBackground(Color.orange);
        topPanel.setLayout(new FlowLayout(5));
        topPanel.add(buttonEditarUsuario);
        topPanel.add(buttonCriarConta);
        topPanel.add(buttonCriarCategoria);
        topPanel.add(buttonSairUsuario);
        telaMain.add(topPanel, BorderLayout.NORTH);
        
        JPanel middlePanel = new JPanel();
        middlePanel.setBorder(new LineBorder(Color.black, 3));
        middlePanel.setLayout(new FlowLayout(4,4,4));
        middlePanel.setBackground(Color.CYAN);
        
        JPanel gridPerfil = new JPanel();
        gridPerfil.setLayout(new GridLayout(3,3,4,4));
        gridPerfil.setBorder(new LineBorder(Color.black, 3));
        gridPerfil.setBackground(Color.RED);
        gridPerfil.add(nomeLabelUsuario);
        gridPerfil.add(new JLabel(user.getNome()));
        gridPerfil.add(emailLabelUsuario);
        gridPerfil.add(new JLabel(user.getEmail()));
        gridPerfil.add(cpfLabelUsuario);
        gridPerfil.add(new JLabel(user.getCpf()));
        
        middlePanel.add(gridPerfil);
//        if(user.checkingContas(user.getContas()[0].getTituloUser(), user)){
//            System.out.println("jobson");
//            addTabela(user.getContas());
//            tabelaContas = new JTable(dados,coluna);
//            telaMain.add(tabelaContas);
//        }
        telaMain.add(middlePanel, BorderLayout.WEST);
        
    }
    
    private void addTabela(Contas[] contas){
        for (int i = 0; i < contas.length; i++) {
            for (int j = 0; j < 4; j++) {
                if(j == 0){
                    dados[i][j] = contas[i].getNomedaConta();
                }else if(j == 1){
                    dados[i][j] = contas[i].getTituloUser();
                }else if(j == 2){
                    dados[i][j] = contas[i].getDinheiroLiquido();
                }else if(j == 3){
                    dados[i][j] = contas[i].getRiscoFinancas();
                }
            }
        }
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == buttonEditarUsuario){
            this.setVisible(false);
            new EditarUsuario(user);
        }
        if(ae.getSource() == buttonCriarConta){
            this.setVisible(false);
            new CadastrarConta(user);
        }
    }
    
}
