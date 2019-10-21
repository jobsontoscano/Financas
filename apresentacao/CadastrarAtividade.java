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
import br.com.novaroma.financas.entidades.Atividade;
import br.com.novaroma.financas.entidades.Contas;
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
public class CadastrarAtividade extends JFrame implements ActionListener{
    UsuarioNegocio usuarioNegocio = new UsuarioNegocio();
    Usuarios usuario = new Usuarios();
    Contas conta;
    String[] categorias;
    private JButton buttonSalvarDados = new JButton("Cadastrar Atividade");
    private JButton buttonVoltar = new JButton("Voltar");
    
    private JTextField nomeTextField = new JTextField();
    private JTextField custoTotalTextField = new JTextField();
    private JTextField parcelasTextField = new JTextField();
    
    private JLabel nomeLabel = new JLabel("Nome Atividade:");
    private JLabel custoTotalLabel = new JLabel("Custo:");
    private JLabel parcelasLabel = new JLabel("Parcelas:");
    
    JComboBox<String> categoria;
    
    CadastrarAtividade(Usuarios usuario, Contas conta) throws ClassNotFoundException, IOException{
        this.usuario = usuario;
        this.conta = conta;
        layoutTela(conta.getNomedaConta());
        this.buscarCategoriasDropdown();
        categoria = new JComboBox<String>(categorias);
        
        buttonSalvarDados.setBounds(150,250,250,35);
        buttonVoltar.setBounds(150,280,250,35);
        buttonSalvarDados.addActionListener(this);
        buttonVoltar.addActionListener(this);
        
        nomeLabel.setBounds(10,60,110,25);
        custoTotalLabel.setBounds(10,100,110,25);
        parcelasLabel.setBounds(10,140,60,25);
        
        nomeTextField.setBounds(130,60,300,25);
        custoTotalTextField.setBounds(130,100,300,25);
        parcelasTextField.setBounds(130,140,300,25);
        categoria.setBounds(130,180,300,25);
        
        add(nomeLabel);
        add(custoTotalLabel);
        add(parcelasLabel);
        
        add(nomeTextField);
        add(custoTotalTextField);
        add(parcelasTextField);
        add(categoria);
        
        add(buttonSalvarDados);
    }
    
    public void layoutTela(String nomeConta){
        setTitle("Nova Atividade para"+nomeConta);
        setSize(600,500);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.green));
        
        setLayout(null);
    }
    
    public void buscarCategoriasDropdown() throws ClassNotFoundException, IOException{
        categorias = new String[usuarioNegocio.buscarPorCategoriaUsuario().length];
        for (int i = 0; i < (usuarioNegocio.buscarPorCategoriaUsuario().length-1); i++) {
            categorias[i] = usuarioNegocio.buscarPorCategoriaUsuario()[i].getNomeCategoria();
        }
    }
    
    public Categoria buscarPerfilCategoriaDropdown(String value)throws ClassNotFoundException, IOException{
        Categoria categ = new Categoria();
        for (int i = 0; i < (usuarioNegocio.buscarPorCategoriaUsuario().length-1); i++) {
            if(usuarioNegocio.buscarPorCategoriaUsuario()[i].getNomeCategoria().equals(value)){
                categ = usuarioNegocio.buscarPorCategoriaUsuario()[i];
            }
        }
        return categ;
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == buttonSalvarDados){
            int parcela = Integer.parseInt(parcelasTextField.getText());
            float custoTotal = Float.parseFloat(custoTotalTextField.getText());
            try {
                Categoria categ = this.buscarPerfilCategoriaDropdown((String)categoria.getSelectedItem());
                Atividade atividadeNova = new Atividade(nomeTextField.getText(),custoTotal,parcela,categ);
                JOptionPane.showMessageDialog(null, usuarioNegocio.cadastrarContaAtividade(atividadeNova, conta));
                System.out.println(conta.getAtividade()[0].getNomeAtividade());
                this.setVisible(false);
                new Perfil(usuario);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CadastrarAtividade.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(CadastrarAtividade.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        if(ae.getSource() == buttonVoltar){
            this.setVisible(false);
            try {
                new Perfil(usuario);
            } catch (IOException ex) {
                Logger.getLogger(CadastrarAtividade.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CadastrarAtividade.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
