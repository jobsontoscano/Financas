/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.novaroma.financas.dados;
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
/**
 *
 * @author aluno
 */
public class UsuarioDados implements Registro{
    
    
    //public void Cadastrar(Usuarios user)throws IOException, ClassNotFoundException{}
    
    public void Cadastrar(Object user) throws IOException, ClassNotFoundException {
        
        File arquivo = new File("arquivos/usuarios.txt");
        Usuarios[] colecaoUsuarios;
        
        if(arquivo.exists()){
            
            FileInputStream fis = new FileInputStream(arquivo);
            
            ObjectInputStream ois = new ObjectInputStream (fis);
            
            colecaoUsuarios = (Usuarios[]) ois.readObject();
            
            ois.close();
        } else {
            
            arquivo.createNewFile();
            colecaoUsuarios = new Usuarios[1];
        }
        
        colecaoUsuarios[colecaoUsuarios.length-1] = (Usuarios)user;
        
        Usuarios[] usersNovo = new Usuarios[colecaoUsuarios.length+1];
        System.arraycopy(colecaoUsuarios, 0, usersNovo, 0, colecaoUsuarios.length);
        colecaoUsuarios = usersNovo;
        
        for(int i=0; i < colecaoUsuarios.length; i++){
            System.out.println(colecaoUsuarios[i]);
        }
        
        FileOutputStream fos = new FileOutputStream(arquivo);
        
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        
        oos.writeObject(colecaoUsuarios);
        
        oos.close();
    }
    
    //public boolean Editar(Usuarios user) throws FileNotFoundException, IOException, ClassNotFoundException {}
    public boolean Editar(Object user, String cpf) throws IOException, ClassNotFoundException {
        File arquivo = new File("arquivos/usuarios.txt");
        Usuarios[] colecaoUsuarios;
        
        if(arquivo.exists()){
            
            FileInputStream fis = new FileInputStream(arquivo);
            
            ObjectInputStream ois = new ObjectInputStream (fis);
            
            colecaoUsuarios = (Usuarios[]) ois.readObject();
            
            ois.close();
            
            if(carregarUsuarios(colecaoUsuarios, cpf) >= 0){
                colecaoUsuarios[carregarUsuarios(colecaoUsuarios, cpf)] = (Usuarios) user;
            }

            FileOutputStream fos = new FileOutputStream(arquivo);

            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(colecaoUsuarios);

            oos.close();
            
            return true;
        }else{
            return false;
        }
    }
    
    public Usuarios[] Geral() throws FileNotFoundException, IOException, ClassNotFoundException {
        File arquivo = new File("arquivos/usuarios.txt");
        Usuarios[] colecaoUsuarios;
        
        if(arquivo.exists()){
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo));
            
            colecaoUsuarios = (Usuarios[]) ois.readObject();
            ois.close();
            
            return colecaoUsuarios;
        } else {
            return null;
        }
    }
    
    public Usuarios Consultar(String cpf) throws FileNotFoundException, IOException, ClassNotFoundException {
        File arquivo = new File("arquivos/usuarios.txt");
        Usuarios[] colecaoUsuarios;
        
        if(arquivo.exists()){
            
            ObjectInputStream ois = new ObjectInputStream (new FileInputStream(arquivo));
            
            colecaoUsuarios = (Usuarios[]) ois.readObject();
            ois.close();
        }else{
            return null;
        }
        
        if(carregarUsuarios(colecaoUsuarios, cpf) >= 0){
            return colecaoUsuarios[carregarUsuarios(colecaoUsuarios, cpf)];
        }else{
            return null;
        }
    }
    
    //public boolean Deletar(Usuarios user)throws FileNotFoundException, IOException, ClassNotFoundException{}
    
    public boolean Deletar(String cpf) throws IOException, ClassNotFoundException {
        File arquivo = new File("arquivos/usuarios.txt");
        Usuarios[] colecaoUsuarios;
        int cont = 0;
        
        if(arquivo.exists()){
            
            FileInputStream fis = new FileInputStream(arquivo);
            
            ObjectInputStream ois = new ObjectInputStream (fis);
            
            colecaoUsuarios = (Usuarios[]) ois.readObject();
            
            ois.close();
            
            colecaoUsuarios[carregarUsuarios(colecaoUsuarios,cpf)] = null;
            Usuarios[] usersNovo = new Usuarios[colecaoUsuarios.length-1];
            
            for(int i=0; i < colecaoUsuarios.length; i++){
                if(colecaoUsuarios[i] != null){
                    usersNovo[cont] = colecaoUsuarios[i];
                    cont++;
                }
            }
            colecaoUsuarios = usersNovo;

            FileOutputStream fos = new FileOutputStream(arquivo);

            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(colecaoUsuarios);

            oos.close();
            
            return true;
        }else{
            return false;
        }
    }
    
    public int carregarUsuarios(Usuarios[] users, String cpf){
        int cont = -1;
        for (int i = 0; i < users.length; i++) {
            if(users[i] != null){
                if(users[i].getCpf().equals(cpf)){
                    cont = i;
                }
            }
        }
        return cont;
    }
    
    public boolean consultaEmail(String _email) throws IOException, ClassNotFoundException{
        boolean statusConsut = false;
        File arquivo = new File("arquivos/usuarios.txt");
        Usuarios[] colecaoUsuarios;
        
        if(arquivo.exists()){
            
            ObjectInputStream ois = new ObjectInputStream (new FileInputStream(arquivo));
            
            colecaoUsuarios = (Usuarios[]) ois.readObject();
            ois.close();
            
            if(_email != null){
            for (Usuarios user : colecaoUsuarios) {
                    if(user.getEmail().equals(_email))
                        statusConsut = true;
            }
            }else{
                statusConsut = false;
            }
        }else{
            statusConsut = false;
        }
        
        return statusConsut;
    }  
}
