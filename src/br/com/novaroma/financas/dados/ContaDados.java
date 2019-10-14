/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.novaroma.financas.dados;
import br.com.novaroma.financas.entidades.Contas;
import br.com.novaroma.financas.entidades.Atividade;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author toscano
 */
public class ContaDados implements Registro{

    public void Cadastrar(Object conta) throws IOException, ClassNotFoundException {
        File arquivo = new File("arquivos/conta.txt");
        Contas[] colecaoContas;
        
        if(arquivo.exists()){
            
            FileInputStream fis = new FileInputStream(arquivo);
            
            ObjectInputStream ois = new ObjectInputStream (fis);
            
            colecaoContas = (Contas[]) ois.readObject();
            
            ois.close();
            
        } else {
            
            arquivo.createNewFile();
            colecaoContas = new Contas[1];
        }
        
        colecaoContas[colecaoContas.length-1] = (Contas) conta;
        
        Contas[] contaNovo = new Contas[colecaoContas.length+1];
        System.arraycopy(colecaoContas, 0, contaNovo, 0, colecaoContas.length);
        colecaoContas = contaNovo;
        
        for(int i=0; i < colecaoContas.length; i++){
            System.out.println(colecaoContas[i]);
        }
        
        FileOutputStream fos = new FileOutputStream(arquivo);
        
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        
        oos.writeObject(colecaoContas);
        
        oos.close();
    }

    public boolean Editar(Object conta, String value) throws IOException, ClassNotFoundException {
        File arquivo = new File("arquivos/conta.txt");
        Contas[] colecaoContas;
        
        if(arquivo.exists()){
            
            FileInputStream fis = new FileInputStream(arquivo);
            
            ObjectInputStream ois = new ObjectInputStream (fis);
            
            colecaoContas = (Contas[]) ois.readObject();
            
            ois.close();
            
            if(CarregarEntidade(colecaoContas, value) >= 0){
                colecaoContas[CarregarEntidade(colecaoContas, value)] = (Contas) conta;
            }

            FileOutputStream fos = new FileOutputStream(arquivo);

            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(colecaoContas);

            oos.close();
            
            return true;
        }else{
            return false;
        }
    }
    
    public Contas[] buscar(String titular) throws IOException, ClassNotFoundException {
        File arquivo = new File("arquivos/conta.txt");
        Contas[] colecaoContas;
        
        if(arquivo.exists()){
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo));
            
            colecaoContas = (Contas[]) ois.readObject();
            ois.close();
            Contas[] colecaoNovo = new Contas[colecaoContas.length];
            int cont = 0;
            for(int i = 0; i < (colecaoContas.length-1); i++){
                if(colecaoContas[i].getTituloUser().equals(titular)){
                    colecaoNovo[cont] = colecaoContas[i];
                    cont++;
                }
            }      
                    
            return colecaoNovo;
        } else {
            return null;
        }
    }

    public Contas[] Geral() throws IOException, ClassNotFoundException {
        File arquivo = new File("arquivos/conta.txt");
        Contas[] colecaoContas;
        
        if(arquivo.exists()){
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo));
            
            colecaoContas = (Contas[]) ois.readObject();
            ois.close();
            
            return colecaoContas;
        } else {
            return null;
        }
    }

    public Contas Consultar(String value) throws IOException, ClassNotFoundException {
        File arquivo = new File("arquivos/conta.txt");
        Contas[] colecaoContas;
        
        if(arquivo.exists()){
            
            ObjectInputStream ois = new ObjectInputStream (new FileInputStream(arquivo));
            
            colecaoContas = (Contas[]) ois.readObject();
            ois.close();
        }else{
            return null;
        }
        
        if(CarregarEntidade(colecaoContas, value) >= 0){
            return colecaoContas[CarregarEntidade(colecaoContas, value)];
        }else{
            return null;
        }
    }

    public boolean Deletar(String value) throws IOException, ClassNotFoundException {
        File arquivo = new File("arquivos/conta.txt");
        Contas[] colecaoContas;
        int cont = 0;
        
        if(arquivo.exists()){
            
            FileInputStream fis = new FileInputStream(arquivo);
            
            ObjectInputStream ois = new ObjectInputStream (fis);
            
            colecaoContas = (Contas[]) ois.readObject();
            
            ois.close();
            
            colecaoContas[CarregarEntidade(colecaoContas,value)] = null;
            Contas[] contaNovo = new Contas[colecaoContas.length-1];
            
            for(int i=0; i < colecaoContas.length; i++){
                if(colecaoContas[i] != null){
                    contaNovo[cont] = colecaoContas[i];
                    cont++;
                }
            }
            colecaoContas = contaNovo;

            FileOutputStream fos = new FileOutputStream(arquivo);

            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(colecaoContas);

            oos.close();
            
            return true;
        }else{
            return false;
        }
    }
    
    public int CarregarEntidade(Contas[] objs, String value){
        int cont = -1;
        for (int i = 0; i < objs.length; i++) {
            if(objs[i] != null){
                if(objs[i].getNomedaConta().equals(value)){
                    cont = i;
                }
            }
        }
        return cont;
    }
    public int CarregarEntidade(Atividade[] objs, String value){
        int cont = -1;
        for (int i = 0; i < objs.length; i++) {
            if(objs[i] != null){
                if(objs[i].getNomeAtividade().equals(value)){
                    cont = i;
                }
            }
        }
        return cont;
    }
    
}
