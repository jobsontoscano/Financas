/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.novaroma.financas.negocio;
import br.com.novaroma.financas.entidades.Atividade;
import br.com.novaroma.financas.dados.AtividadeDados;
import br.com.novaroma.financas.dados.ContaDados;
import br.com.novaroma.financas.entidades.Contas;
import br.com.novaroma.financas.entidades.Categoria;
import br.com.novaroma.financas.util.Utilidades;
import javax.swing.JOptionPane;
import java.io.IOException;

/**
 *
 * @author toscano
 */
public class ContasNegocio {
    private ContaDados contaDados = new ContaDados();
    private AtividadeDados atvDados = new AtividadeDados();
    
    public String cadastrarConta(Contas conta) throws ClassNotFoundException, IOException {
        if (this.contaDados.Consultar(conta.getNomedaConta()) != null) {
            System.out.println("ERRO[]:Conta já cadastrada em nosso Sistema");
            return "Esse Conta já existe em nosso sistema";
        }else{
            this.contaDados.Cadastrar(conta);
            return "Conta Cadastrada com Sucesso";
        }	
    }

    public Contas buscarConta(String value) throws ClassNotFoundException, IOException{
        
        if (this.contaDados.Consultar(value) != null){
            return this.contaDados.Consultar(value);
        } else {
            return null;
        }
    }
    
    public void editarConta(Contas conta) throws ClassNotFoundException, IOException{
        
        if (this.contaDados.Editar(conta,conta.getNomedaConta())){
            JOptionPane.showMessageDialog(null, "Atualização realizada com sucesso");
        } else {
            JOptionPane.showMessageDialog(null,"Ocorreu um problema na atualização \n"
                    + "Tente novamente mais tarde");
        }
    }
    
    public void deletarConta(Contas conta) throws ClassNotFoundException, IOException{
        if (this.contaDados.Deletar(conta.getNomedaConta())){
            JOptionPane.showMessageDialog(null, "Conta Excluida com Sucesso");
        } else {
            JOptionPane.showMessageDialog(null,"Ocorreu um problema no modelo de Exclir \n"
                    + "Tente novamente mais tarde");
        }
    }

    public void geralConta()throws ClassNotFoundException, IOException{
        Contas[] contaBusca = this.contaDados.Geral();
        
        for (Contas conta : contaBusca) {
            if(conta != null){
                JOptionPane.showMessageDialog(null, "Tabela de Contas:"
                    + "Nome da Conta: "+conta.getNomedaConta()+"\n"
                    + "Dinheiro Liquido: "+conta.getDinheiroLiquido()+"\n"
                    + "Beneficio Alimentação: "+conta.getBeneficioAl()+"\n"
                    + "Beneficio Transporte:"+conta.getBeneficioTr()+"\n"
                    + "Atividades vem a seguir =:> \n");
                for(Atividade atv : conta.getAtividade()){
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
    
    public void cadastrarContaAtividade(Atividade atv, Contas conta)throws ClassNotFoundException, IOException{
        if(atvDados.Consultar(atv.getNomeAtividade()) == null){
            atvDados.Cadastrar(atv);
            System.out.println("Atividade Cadastrada em nosso sistema");
            conta.setAtividade(atv);
            System.out.println("Atividade implementada na conta");
        }else{
            System.out.println("Atividade já existente");
            if(contaDados.CarregarEntidade(conta.getAtividade(), atv.getNomeAtividade()) < 0){
                conta.setAtividade(atvDados.Consultar(atv.getNomeAtividade()));
                System.out.println("Atividade implementada na conta");
            }else{
                System.out.println("Atividade já implementada em sua conta");
            }
            
        }
    }

}
