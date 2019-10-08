package br.com.novaroma.financas.dados;

import br.com.novaroma.financas.entidades.Categoria;
import br.com.novaroma.financas.entidades.Usuarios;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Everaldo
 */

public class CategoriaDados implements Registro{
    
    //public void Cadastrar(Categoria catg)throws IOException, ClassNotFoundException{}
    
    public void Cadastrar(Object catg) throws IOException, ClassNotFoundException {
        File arquivo = new File("arquivos/categoria.txt");
        Categoria[] colecaoCategoria;
        
        if(arquivo.exists()){
            
            FileInputStream fis = new FileInputStream(arquivo);
            
            ObjectInputStream ois = new ObjectInputStream (fis);
            
            colecaoCategoria = (Categoria[]) ois.readObject();
            
            ois.close();
            
        } else {
            
            arquivo.createNewFile();
            colecaoCategoria = new Categoria[1];
        }
        
        colecaoCategoria[colecaoCategoria.length-1] = (Categoria) catg;
        
        Categoria[] catgNovo = new Categoria[colecaoCategoria.length+1];
        System.arraycopy(colecaoCategoria, 0, catgNovo, 0, colecaoCategoria.length);
        colecaoCategoria = catgNovo;
        
        for(int i=0; i < colecaoCategoria.length; i++){
            System.out.println(colecaoCategoria[i]);
        }
        
        FileOutputStream fos = new FileOutputStream(arquivo);
        
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        
        oos.writeObject(colecaoCategoria);
        
        oos.close();
    }
    
    public Categoria Consultar(String nomeCategoria) throws FileNotFoundException, IOException, ClassNotFoundException {
        File arquivo = new File("arquivos/categoria.txt");
        Categoria[] colecaoCategoria;
        
        if(arquivo.exists()){
            
            ObjectInputStream ois = new ObjectInputStream (new FileInputStream(arquivo));
            
            colecaoCategoria = (Categoria[]) ois.readObject();
            ois.close();
        }else{
            return null;
        }
        
        if(CarregarEntidade(colecaoCategoria, nomeCategoria) >= 0){
            return colecaoCategoria[CarregarEntidade(colecaoCategoria, nomeCategoria)];
        }else{
            return null;
        }
    }
    
    public Categoria[] Geral() throws IOException, ClassNotFoundException {
        File arquivo = new File("arquivos/categoria.txt");
        Categoria[] colecaoCategoria;
        
        if(arquivo.exists()){
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo));
            
            colecaoCategoria = (Categoria[]) ois.readObject();
            ois.close();
            
            return colecaoCategoria;
        } else {
            return null;
        }
    }
    
    public boolean Editar(Object catg, String value) throws IOException, ClassNotFoundException {
        File arquivo = new File("arquivos/categoria.txt");
        Categoria[] colecaoCategoria;
        
        if(arquivo.exists()){
            
            FileInputStream fis = new FileInputStream(arquivo);
            
            ObjectInputStream ois = new ObjectInputStream (fis);
            
            colecaoCategoria = (Categoria[]) ois.readObject();
            
            ois.close();
            
            if(CarregarEntidade(colecaoCategoria, value) >= 0){
                colecaoCategoria[CarregarEntidade(colecaoCategoria, value)] = (Categoria) catg;
            }

            FileOutputStream fos = new FileOutputStream(arquivo);

            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(colecaoCategoria);

            oos.close();
            
            return true;
        }else{
            return false;
        }
    }
    
    public boolean Deletar(String value) throws IOException, ClassNotFoundException {
        File arquivo = new File("arquivos/categoria.txt");
        Categoria[] colecaoCategoria;
        int cont = 0;
        
        if(arquivo.exists()){
            
            FileInputStream fis = new FileInputStream(arquivo);
            
            ObjectInputStream ois = new ObjectInputStream (fis);
            
            colecaoCategoria = (Categoria[]) ois.readObject();
            
            ois.close();
            
            colecaoCategoria[CarregarEntidade(colecaoCategoria,value)] = null;
            Categoria[] catgNovo = new Categoria[colecaoCategoria.length-1];
            
            for(int i=0; i < colecaoCategoria.length; i++){
                if(colecaoCategoria[i] != null){
                    catgNovo[cont] = colecaoCategoria[i];
                    cont++;
                }
            }
            colecaoCategoria = catgNovo;

            FileOutputStream fos = new FileOutputStream(arquivo);

            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(colecaoCategoria);

            oos.close();
            
            return true;
        }else{
            return false;
        }
    }
    
    public int CarregarEntidade(Categoria[] objs, String value){
        int cont = -1;
        for (int i = 0; i < objs.length; i++) {
            if(objs[i] != null){
                if(objs[i].getNomeCategoria().equals(value)){
                    cont = i;
                }
            }
        }
        return cont;
    }
    
}
