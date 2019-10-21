/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.novaroma.financas.negocio;
import br.com.novaroma.financas.dados.CategoriaDados;
import br.com.novaroma.financas.entidades.Categoria;
import br.com.novaroma.financas.util.Utilidades;
import javax.swing.JOptionPane;
import java.io.IOException;

/**
 *
 * @author Everaldo
 */

public class CategoriaNegocio {
    private CategoriaDados categoriaDados = new CategoriaDados();
    private Utilidades utilidades = new Utilidades();
    
    public String cadastrarCategoria(Categoria catg) throws ClassNotFoundException, IOException {
        if (this.categoriaDados.Consultar(catg.getNomeCategoria()) != null) {
            System.out.println("ERRO[]:Categoria já cadastrado em nosso Sistema");
            return "Esse categoria já existe em nosso sistema";
        }else{
            this.categoriaDados.Cadastrar(catg);
            return "Categoria Cadastrado com Sucesso";
        }	
    }
    
    public Categoria buscarCategoria(String value) throws ClassNotFoundException, IOException{
        
        if (this.categoriaDados.Consultar(value) != null){
            return this.categoriaDados.Consultar(value);
        } else {
            return null;
        }
    }
    
    public void editarCategoria(Categoria catg) throws ClassNotFoundException, IOException{
        
        if (this.categoriaDados.Editar(catg,catg.getNomeCategoria())){
            JOptionPane.showMessageDialog(null, "Atualização realizada com sucesso");
        } else {
            JOptionPane.showMessageDialog(null,"Ocorreu um problema na atualização \n"
                    + "Tente novamente mais tarde");
        }
    }
    
    public void deletarCategoria(Categoria catg) throws ClassNotFoundException, IOException{
        
        if (this.categoriaDados.Deletar(catg.getNomeCategoria())){
            JOptionPane.showMessageDialog(null, "Categoria Excluida com Sucesso");
        } else {
            JOptionPane.showMessageDialog(null,"Ocorreu um problema no modelo de Exclir \n"
                    + "Tente novamente mais tarde");
        }
    }
    
    public Categoria[] buscarPorCategoriaUsuario()throws ClassNotFoundException, IOException{
        return categoriaDados.buscar();
    }
    
    public void geralCategoria()throws ClassNotFoundException, IOException{
        Categoria[] catagBusca = this.categoriaDados.Geral();
        
        for (Categoria catg : catagBusca) {
            if(catg != null){
                JOptionPane.showMessageDialog(null, "Tabela de Categoria:"
                    + "Nome da Categoria: "+catg.getNomeCategoria()+"\n"
                    + "Prioriadade: "+catg.getstatusPrioridade()+"\n"
                    + "Custo: "+catg.getcustoSalario()+"\n");
            }
        }
    }
}
