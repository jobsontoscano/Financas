/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.novaroma.financas.negocio;
import br.com.novaroma.financas.entidades.Usuarios;
import br.com.novaroma.financas.entidades.Contas;
import br.com.novaroma.financas.entidades.Categoria;
import br.com.novaroma.financas.negocio.ContasNegocio;
import br.com.novaroma.financas.dados.UsuarioDados;
import br.com.novaroma.financas.negocio.CategoriaNegocio;
import br.com.novaroma.financas.util.Utilidades;
import javax.swing.JOptionPane;
import java.io.IOException;
/**
 *
 * @author aluno
 */
public class UsuarioNegocio {
    private UsuarioDados usuarioDados = new UsuarioDados();
    private Utilidades utilidades = new Utilidades();
    private ContasNegocio contaNegocio = new ContasNegocio();
    private CategoriaNegocio categoriaNegocio = new CategoriaNegocio();
    
    public String cadastrarUsuarios(Usuarios usuario) throws ClassNotFoundException, IOException {
        if(utilidades.validacaoCPF(usuario.getCpf()) != null){
            if(utilidades.validacaoEmail(usuario.getEmail()) != null){
                if (this.usuarioDados.Consultar(usuario.getCpf()) != null) {
                    System.out.println("ERRO[]: Usuário já cadastrado em nosso Sistema");
                    return "Esse Usuário já existe em nosso sistema";
                }else{
                    this.usuarioDados.Cadastrar(usuario);
                    return "Usuáro Cadastrado com Sucesso";
                }
            } else {
                return "Email com problema, por favor";
            }
        } else {
            return "CPF já cadastrado em nosso sistema, por favor verificar com empresa";
        }	
    }
    
    public Usuarios buscarUsuario(String cpf) throws ClassNotFoundException, IOException{
        
        if (this.usuarioDados.Consultar(cpf) != null){
            return this.usuarioDados.Consultar(cpf);
        } else {
            return null;
        }
    }
    
    public void editarUsuario(Usuarios user) throws ClassNotFoundException, IOException{
        
        if (this.usuarioDados.Editar(user,user.getCpf())){
            JOptionPane.showMessageDialog(null, "Atualização realizada com sucesso");
        } else {
            JOptionPane.showMessageDialog(null,"Ocorreu um problema na atualização \n"
                    + "Tente novamente mais tarde");
        }
    }
    
    public void deletarUsuario(Usuarios user) throws ClassNotFoundException, IOException{
        
        if (this.usuarioDados.Deletar(user.getCpf())){
            JOptionPane.showMessageDialog(null, "Usuario Excluido com Sucesso");
        } else {
            JOptionPane.showMessageDialog(null,"Ocorreu um problema no modelo de Exclir \n"
                    + "Tente novamente mais tarde");
        }
    }
    
    public void GeralUsuarios()throws ClassNotFoundException, IOException{
        Usuarios[] usersBusca = this.usuarioDados.Geral();
        
        for (Usuarios user : usersBusca) {
            if(user != null){
                JOptionPane.showMessageDialog(null, "Tabela de Usuarios:"
                    + "Nome: "+user.getNome()+"\n"
                    + "Email: "+user.getEmail()+"\n"
                    + "CPF: "+user.getCpf()+"\n");
            }
        }
    }
    
    public String cadastrarContaUsuario(Usuarios user, Contas conta) throws IOException, ClassNotFoundException{
        if(contaNegocio.buscarConta(conta.getTituloUser()) == null){
            contaNegocio.cadastrarConta(conta);
            return "Conta Cadastrada com sucesso";
        }else{
            return "Conta já existente";
        }
    }
    
    public String cadastrarCategoriaUsuario(Usuarios user, Categoria categ) throws ClassNotFoundException, IOException{
        if(categoriaNegocio.buscarCategoria(categ.getNomeCategoria()) == null){
            categoriaNegocio.cadastrarCategoria(categ);
            return "Categoria Cadastrada com sucesso";
        }else{
            return "Categoria já existente";
        }
    }
    
    public String verificarRiscoConta(){
        return null;
        // Metodo em desenvolvimento por favor falar com jobson antes;
    }
    
}
