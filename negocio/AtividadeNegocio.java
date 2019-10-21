/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.novaroma.financas.negocio;
import br.com.novaroma.financas.entidades.Atividade;
import br.com.novaroma.financas.dados.AtividadeDados;
import br.com.novaroma.financas.entidades.Categoria;
import br.com.novaroma.financas.util.Utilidades;
import javax.swing.JOptionPane;
import java.io.IOException;
/**
 *
 * @author toscano
 */
public class AtividadeNegocio {
    private AtividadeDados atividadeDados = new AtividadeDados();
    
    public String cadastrarAtividade(Atividade atv) throws ClassNotFoundException, IOException {
        if (this.atividadeDados.Consultar(atv.getNomeAtividade()) != null) {
            System.out.println("ERRO[]:Atividade já cadastrada em nosso Sistema");
            return "Esse Atividade já existe em nosso sistema";
        }else{
            this.atividadeDados.Cadastrar(atv);
            return "Categoria Cadastrado com Sucesso";
        }	
    }
    
    public Atividade buscarAtividade(String value) throws ClassNotFoundException, IOException{
        
        if (this.atividadeDados.Consultar(value) != null){
            return this.atividadeDados.Consultar(value);
        } else {
            return null;
        }
    }
    
    public void editarAtividade(Atividade atv) throws ClassNotFoundException, IOException{
        
        if (this.atividadeDados.Editar(atv,atv.getNomeAtividade())){
            JOptionPane.showMessageDialog(null, "Atualização realizada com sucesso");
        } else {
            JOptionPane.showMessageDialog(null,"Ocorreu um problema na atualização \n"
                    + "Tente novamente mais tarde");
        }
    }
    
    public void deletarAtividade(Atividade atv) throws ClassNotFoundException, IOException{
        
        if (this.atividadeDados.Deletar(atv.getNomeAtividade())){
            JOptionPane.showMessageDialog(null, "Atividade Excluida com Sucesso");
        } else {
            JOptionPane.showMessageDialog(null,"Ocorreu um problema no modelo de Exclir \n"
                    + "Tente novamente mais tarde");
        }
    }
    
    public void geralAtividade()throws ClassNotFoundException, IOException{
        Atividade[] atvBusca = this.atividadeDados.Geral();
        
        for (Atividade atv : atvBusca) {
            if(atv != null){
                JOptionPane.showMessageDialog(null, "Tabela de Atividades:"
                    + "Nome da Atividade: "+atv.getNomeAtividade()+"\n"
                    + "Custo Total: "+atv.getCustoTotal()+"\n"
                    + "Parcelas: "+atv.getParcelas()+"\n"
                    + "Nome da Categoria:"+atv.getCategoria().getNomeCategoria()+"\n"
                    + "Custo do Salario:"+atv.getCategoria().getcustoSalario()+"% \n");
            }
        }
    }
    
}
