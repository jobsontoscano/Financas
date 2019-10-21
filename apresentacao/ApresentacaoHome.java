/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.novaroma.financas.apresentacao;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author toscano
 */
public class ApresentacaoHome extends JFrame implements ActionListener{
    
    JLabel tituloApp = new JLabel("Finanças");
    JLabel subTituloOne = new JLabel("Sistema Desenvolvido por:");
    JLabel subTituloTwo = new JLabel("Jobson José");
    JLabel subTituloThree = new JLabel("Everaldo Junior");
    JLabel subTituloFour = new JLabel("Andre Felipe");
    JLabel tituloLogin = new JLabel("Login");
    
    ImageIcon bonecoOne = new ImageIcon(getClass().getResource("roboDancaOne.png"));
    ImageIcon bonecoTwo = new ImageIcon(getClass().getResource("roboDancaTwo.png"));
    ImageIcon bonecoThree = new ImageIcon(getClass().getResource("roboDancaThree.png"));
    
    JLabel bonecoLabel = new JLabel(bonecoOne);
    JLabel bonecoTwoLabel = new JLabel(new ImageIcon(getClass().getResource("ScreenOne.png")));
    JLabel bonecoThreeLabel = new JLabel(new ImageIcon(getClass().getResource("ScreenFour.png")));
    JLabel bonecoFourLabel = new JLabel(new ImageIcon(getClass().getResource("ScreenSeven.png")));
    
    JButton buttonCadastrarUsuario = new JButton("Não possui Cadastro ?");
    JButton buttonLoginUsuario = new JButton("Entrar");
    
    ApresentacaoHome(){
        layoutTela();
        
        buttonCadastrarUsuario.addActionListener(this);
        buttonLoginUsuario.addActionListener(this);
        
        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.cyan);
        topPanel.setBounds(0, 0, 400, 50);
        
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.cyan);
        headerPanel.setBounds(0, 50, 400, 50);
        
        JPanel bodyPanel = new JPanel();
        bodyPanel.setLayout(null);
        bodyPanel.setBackground(Color.cyan);
        bodyPanel.setBounds(0, 100, 400, 400);
        
        tituloApp.setFont(new Font("Calibri", Font.BOLD, 25));
        tituloApp.setForeground(Color.WHITE);
        
        tituloLogin.setBounds(550,30,300,30);
        tituloLogin.setFont(new Font("Calibri", Font.BOLD,25));
        tituloLogin.setForeground(Color.BLACK);
        
        subTituloOne.setBounds(190,300,10,10);
        subTituloOne.setFont(new Font("Calibri",Font.ITALIC,12));
        subTituloOne.setForeground(Color.WHITE);
        
        subTituloTwo.setBounds(190,250,10,10);
        subTituloTwo.setFont(new Font("Calibri",Font.ITALIC,12));
        subTituloTwo.setForeground(Color.WHITE);
        
        subTituloThree.setBounds(190,250,10,10);
        subTituloThree.setFont(new Font("Calibri",Font.ITALIC,12));
        subTituloThree.setForeground(Color.WHITE);
        
        subTituloFour.setBounds(190,250,10,10);
        subTituloFour.setFont(new Font("Calibri",Font.ITALIC,12));
        subTituloFour.setForeground(Color.WHITE);
        
        bonecoLabel.setBounds(100,0,200,300);
        buttonCadastrarUsuario.setBounds(50,250,300,30);
        
        bonecoTwoLabel.setBounds(400,-150,200,300);
        bonecoThreeLabel.setBounds(490,-150,200,300);
        bonecoFourLabel.setBounds(580,-150,200,300);
        buttonLoginUsuario.setBounds(450,350,300,30);
        
        topPanel.add(tituloApp);
        headerPanel.add(subTituloOne);
        headerPanel.add(subTituloTwo);
        headerPanel.add(subTituloThree);
        headerPanel.add(subTituloFour);
        
        bodyPanel.add(bonecoLabel);
        bodyPanel.add(buttonCadastrarUsuario);
        
        add(topPanel);
        add(headerPanel);
        add(bodyPanel);
        add(buttonLoginUsuario);
        add(bonecoTwoLabel);
        add(bonecoFourLabel);
        add(bonecoThreeLabel);
        add(tituloLogin);
        
        new animate().start();
        
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
    
    public class animate extends Thread{
        public int seg = 0;
        public int cont = 0;
        public int segThree = 0;
        public void run(){
            while(true){
                try{sleep(20);}catch(Exception e){}
                if(seg <= 40 && cont <= 2){
                    bonecoLabel.setIcon(bonecoTwo);
                    seg++;
                }else if(seg <= 80 && cont <= 2){
                    bonecoLabel.setIcon(bonecoThree);
                    bonecoLabel.setBounds(100,bonecoLabel.getY()-1,200,300);
                    seg++;
                }else if(seg <= 120 && cont <= 2){
                    bonecoLabel.setIcon(bonecoThree);
                    bonecoLabel.setBounds(100,bonecoLabel.getY()+1,200,300);
                    seg++;
                }else if(seg <= 160 && cont <= 2){
                    bonecoLabel.setIcon(bonecoTwo);
                    seg++;
                }else{
                    if(cont >= 3){
                        seg = 0;
                    }else{
                        seg = 0;
                        cont++;
                        bonecoLabel.setIcon(new ImageIcon(getClass().getResource("roboDancaOne.png")));
                        
                    }
                }
                if(bonecoTwoLabel.getY() <= 100){
                    bonecoTwoLabel.setBounds(bonecoTwoLabel.getX(), bonecoTwoLabel.getY()+3,200,300);
                    bonecoThreeLabel.setBounds(bonecoThreeLabel.getX(), bonecoThreeLabel.getY()+3,200,300);
                    bonecoFourLabel.setBounds(bonecoFourLabel.getX(), bonecoFourLabel.getY()+3,200,300);
                    
                }else if(segThree <= 40){
                    bonecoTwoLabel.setIcon(new ImageIcon(getClass().getResource("ScreenTwo.png")));
                    bonecoThreeLabel.setIcon(new ImageIcon(getClass().getResource("ScreenFive.png")));
                    bonecoFourLabel.setIcon(new ImageIcon(getClass().getResource("ScreenEight.png")));
                    segThree++;
                }else if(segThree <= 80){
                    bonecoTwoLabel.setIcon(new ImageIcon(getClass().getResource("ScreenThree.png")));
                    bonecoThreeLabel.setIcon(new ImageIcon(getClass().getResource("ScreenSix.png")));
                    bonecoFourLabel.setIcon(new ImageIcon(getClass().getResource("ScreenNine.png")));
                    segThree++;
                }
            }
        }
    } 
    public void layoutTela(){
        setTitle("Home");
        setSize(800,500);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.green));
        setLayout(null);
    }
    
    public static void main(String[]args){
        new ApresentacaoHome();
    }
}
