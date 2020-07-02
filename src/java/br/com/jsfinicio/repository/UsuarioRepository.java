package br.com.jsfinicio.repository;

import br.com.jsfinicio.model.PessoaModel;
import br.com.jsfinicio.util.Conexao;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository extends Conexao{
  
    public List<PessoaModel> buscar(String login){
        List<PessoaModel> listaDePessoas = new ArrayList<PessoaModel>();
        super.inicializa();
        listaDePessoas = super.getSess().createQuery("from PessoaModel where login = '"+login+"'").list();
        super.executar();
        return listaDePessoas;
    }
}
