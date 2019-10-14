/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.novaroma.financas.negocio;
import br.com.novaroma.financas.entidades.Atividade;
import br.com.novaroma.financas.negocio.AtividadeNegocio;
import br.com.novaroma.financas.dados.ContaDados;
import br.com.novaroma.financas.entidades.Contas;
import br.com.novaroma.financas.entidades.Usuarios;
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
    private AtividadeNegocio atividadeNegocio = new AtividadeNegocio();
    
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
    
    public Contas[] buscarContaPorUsusario(Usuarios usuario) throws ClassNotFoundException, IOException{
        return contaDados.buscar(usuario.getNome());
    }
    
    public String editarConta(Contas conta) throws ClassNotFoundException, IOException{
        
        if (this.contaDados.Editar(conta,conta.getNomedaConta())){
            return "Atualização realizada com sucesso";
        } else {
            return "Ocorreu um problema na atualização \n"
                    + "Tente novamente mais tarde";
        }
    }
    
    public String deletarConta(Contas conta) throws ClassNotFoundException, IOException{
        if (this.contaDados.Deletar(conta.getNomedaConta())){
            return "Conta Excluida com Sucesso";
        } else {
            return "Ocorreu um problema no modelo de Exclir \n"
                    + "Tente novamente mais tarde";
        }
    }

    public Contas[] geralConta()throws ClassNotFoundException, IOException{
        Contas[] contaBusca = this.contaDados.Geral();
        
        return contaBusca;
    }
    
    public String cadastrarContaAtividade(Atividade atv, Contas conta)throws ClassNotFoundException, IOException{
        if(atividadeNegocio.buscarAtividade(atv.getNomeAtividade()) == null){
            atividadeNegocio.cadastrarAtividade(atv);
            System.out.println("Atividade Cadastrada em nosso sistema");
            conta.setAtividade(atv);
            contaDados.Editar(conta,conta.getNomedaConta());
            System.out.println("Atividade implementada na conta");
            return "Atividade Cadastrada";
        }else{
            System.out.println("Atividade já existente");
            if(contaDados.CarregarEntidade(conta.getAtividade(), atv.getNomeAtividade()) < 0){
                conta.setAtividade(atividadeNegocio.buscarAtividade(atv.getNomeAtividade()));
                contaDados.Editar(conta,conta.getNomedaConta());
                System.out.println("Atividade implementada na conta");
            }else{
                System.out.println("Atividade já implementada em sua conta");
            }
            return "Problema ao Cadastrar Atividade";
        }
    }

}
