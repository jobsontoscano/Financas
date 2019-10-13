/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.novaroma.financas.negocio;
import br.com.novaroma.financas.entidades.Usuarios;
import br.com.novaroma.financas.entidades.Contas;
import br.com.novaroma.financas.entidades.Categoria;
import br.com.novaroma.financas.entidades.Atividade;
import br.com.novaroma.financas.negocio.AtividadeNegocio;
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
    private AtividadeNegocio atividadeNegocio = new AtividadeNegocio();
    
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
        
        if(utilidades.validacaoCPF(cpf) != null){
            if (this.usuarioDados.Consultar(cpf) != null){
                return this.usuarioDados.Consultar(cpf);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
    
    public String editarUsuario(Usuarios user) throws ClassNotFoundException, IOException{
        
        if (this.usuarioDados.Editar(user,user.getCpf())){
            return "Atualização realizada com sucesso";
        } else {
            return "Ocorreu um problema na atualização \n"
                    + "Tente novamente mais tarde";
        }
    }
    
    public String deletarUsuario(Usuarios user) throws ClassNotFoundException, IOException{
        
        if (this.usuarioDados.Deletar(user.getCpf())){
            return "Usuario Excluido com Sucesso";
        } else {
            return "Ocorreu um problema no modelo de Exclir \n"
                    + "Tente novamente mais tarde";
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
            user.setContas(conta);
            return "Conta Cadastrada com sucesso";
        }else{
            return "Conta já existente";
        }
    }
    
    public Contas[] geralContaUsuario() throws IOException, ClassNotFoundException{
        return contaNegocio.geralConta();
    }
    
    public String cadastrarCategoriaUsuario(Usuarios user, Categoria categ) throws ClassNotFoundException, IOException{
        if(categoriaNegocio.buscarCategoria(categ.getNomeCategoria()) == null){
            categoriaNegocio.cadastrarCategoria(categ);
            return "Categoria Cadastrada com sucesso";
        }else{
            return "Categoria já existente";
        }
    }
    
    public String verificarRiscoConta(Usuarios user, String tituloConta) throws ClassNotFoundException, IOException{
        float custoTotalMes = 0;
        String situacao = "DESCONHECIDO";
        
        if(contaNegocio.buscarConta(tituloConta) != null){
            // Criar metodo para checar se a conta chamada está gravada em arquivo 
            // e se está indicada no perfil do usuario
            Contas contas = contaNegocio.buscarConta(tituloConta);
            for (Atividade atividade : contas.getAtividade()) {
                // Criar um metodo para gerar total de custo das atividades que essa conta
                if(atividadeNegocio.buscarAtividade(atividade.getNomeAtividade()) != null){
                    if(atividade.getParcelas() > 0){
                        custoTotalMes += (atividade.getCustoTotal() / atividade.getParcelas());
                    }else{
                        custoTotalMes += atividade.getCustoTotal();
                    }
                }else{
                    System.out.println("Teste debug");
                }
            }
            float resultado = (float)contas.getDinheiroLiquido() - custoTotalMes;
            if(resultado <= (contas.getDinheiroLiquido() * 20)/100){
                situacao = "ALTO";
            }else if(resultado <= (contas.getDinheiroLiquido() * 50)/100){
                situacao = "MEDIANO";
            }else if(resultado <= (contas.getDinheiroLiquido() * 80)/100){
                situacao = "BAIXO";
            }
            contas.setRiscoFinancas(situacao);
            return situacao;
        }else{
            return null;
        }
        // Metodo em desenvolvimento por favor falar com jobson antes;
    }
    
}
