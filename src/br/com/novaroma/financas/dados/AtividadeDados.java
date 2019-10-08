/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.novaroma.financas.dados;
import br.com.novaroma.financas.entidades.Atividade;
import br.com.novaroma.financas.entidades.Categoria;
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
public class AtividadeDados implements Registro{

    
    public void Cadastrar(Object atv) throws IOException, ClassNotFoundException {
        File arquivo = new File("arquivos/atividade.txt");
        Atividade[] colecaoAtividade;
        
        if(arquivo.exists()){
            
            FileInputStream fis = new FileInputStream(arquivo);
            
            ObjectInputStream ois = new ObjectInputStream (fis);
            
            colecaoAtividade = (Atividade[]) ois.readObject();
            
            ois.close();
            
        } else {
            
            arquivo.createNewFile();
            colecaoAtividade = new Atividade[1];
        }
        
        colecaoAtividade[colecaoAtividade.length-1] = (Atividade) atv;
        
        Atividade[] atvNovo = new Atividade[colecaoAtividade.length+1];
        System.arraycopy(colecaoAtividade, 0, atvNovo, 0, colecaoAtividade.length);
        colecaoAtividade = atvNovo;
        
        for(int i=0; i < colecaoAtividade.length; i++){
            System.out.println(colecaoAtividade[i]);
        }
        
        FileOutputStream fos = new FileOutputStream(arquivo);
        
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        
        oos.writeObject(colecaoAtividade);
        
        oos.close();
    }

    public boolean Editar(Object atv, String value) throws IOException, ClassNotFoundException {
        File arquivo = new File("arquivos/atividade.txt");
        Atividade[] colecaoAtividade;
        
        if(arquivo.exists()){
            
            FileInputStream fis = new FileInputStream(arquivo);
            
            ObjectInputStream ois = new ObjectInputStream (fis);
            
            colecaoAtividade = (Atividade[]) ois.readObject();
            
            ois.close();
            
            if(CarregarEntidade(colecaoAtividade, value) >= 0){
                colecaoAtividade[CarregarEntidade(colecaoAtividade, value)] = (Atividade) atv;
            }

            FileOutputStream fos = new FileOutputStream(arquivo);

            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(colecaoAtividade);

            oos.close();
            
            return true;
        }else{
            return false;
        }
    }

    public Atividade[] Geral() throws IOException, ClassNotFoundException {
        File arquivo = new File("arquivos/atividade.txt");
        Atividade[] colecaoAtividade;
        
        if(arquivo.exists()){
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo));
            
            colecaoAtividade = (Atividade[]) ois.readObject();
            ois.close();
            
            return colecaoAtividade;
        } else {
            return null;
        }
    }

    public Atividade Consultar(String value) throws IOException, ClassNotFoundException {
        File arquivo = new File("arquivos/atividade.txt");
        Atividade[] colecaoAtividade;
        
        if(arquivo.exists()){
            
            ObjectInputStream ois = new ObjectInputStream (new FileInputStream(arquivo));
            
            colecaoAtividade = (Atividade[]) ois.readObject();
            ois.close();
        }else{
            return null;
        }
        
        if(CarregarEntidade(colecaoAtividade, value) >= 0){
            return colecaoAtividade[CarregarEntidade(colecaoAtividade, value)];
        }else{
            return null;
        }
    }

    public boolean Deletar(String value) throws IOException, ClassNotFoundException {
        File arquivo = new File("arquivos/atividade.txt");
        Atividade[] colecaoAtividade;
        int cont = 0;
        
        if(arquivo.exists()){
            
            FileInputStream fis = new FileInputStream(arquivo);
            
            ObjectInputStream ois = new ObjectInputStream (fis);
            
            colecaoAtividade = (Atividade[]) ois.readObject();
            
            ois.close();
            
            colecaoAtividade[CarregarEntidade(colecaoAtividade,value)] = null;
            Atividade[] atvNovo = new Atividade[colecaoAtividade.length-1];
            
            for(int i=0; i < colecaoAtividade.length; i++){
                if(colecaoAtividade[i] != null){
                    atvNovo[cont] = colecaoAtividade[i];
                    cont++;
                }
            }
            colecaoAtividade = atvNovo;

            FileOutputStream fos = new FileOutputStream(arquivo);

            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(colecaoAtividade);

            oos.close();
            
            return true;
        }else{
            return false;
        }
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
