/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.novaroma.financas.util;
import javax.swing.JOptionPane;
import br.com.novaroma.financas.dados.UsuarioDados;
import java.io.IOException;
/**
 *
 * @author Everaldo
 */
public class Utilidades {
    private static UsuarioDados user = new UsuarioDados();
    
    public static String validacaoCPF(String _cpf){
        int tentativas = 0;
        boolean statusFunc = true;
        if (!(_cpf.length() <= 11)){
            while(statusFunc || tentativas < 3){
                _cpf = JOptionPane.showInputDialog("CPF inexistente, por favor digite novamente");
                if(!(_cpf.length() <= 11)){ statusFunc = false; }
                tentativas++;
            }
            if(tentativas >= 3){
                return null;
            }
            return _cpf;
        }else{
            return null;
        }
    }
    
    public static String validacaoEmail(String _email) throws IOException, ClassNotFoundException{
        boolean statusFunc = true;
        int tentativas = 0;
        
        if(_email.indexOf("@") < 0 && _email.indexOf(".") < 0){
            while(statusFunc){
                _email = JOptionPane.showInputDialog("Email incompleto, por favor digite novamente");
                if(_email.indexOf("@") >= 0){ statusFunc = false; }
            }
            if(tentativas >= 3){
                return null;
            }
            return _email;
        }else if(!(user.consultaEmail(_email))){
            tentativas = 0;
            while(statusFunc){
                _email = JOptionPane.showInputDialog("Email Existente, por favor digite outro email");
                if(user.consultaEmail(_email)){ statusFunc = false; }
            }
            if(tentativas >= 3){
                return null;
            }
            return _email;
        }else{
            return null;
        }
    }
}
