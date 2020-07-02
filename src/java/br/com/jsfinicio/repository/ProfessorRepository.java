package br.com.jsfinicio.repository;

import br.com.jsfinicio.model.ProfessorModel;
import br.com.jsfinicio.util.Conexao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProfessorRepository extends Conexao implements Serializable{
    public void salvar(ProfessorModel professor){
        super.inicializa();
        super.getSess().saveOrUpdate(professor);
        super.executar();
    }
    
    public List<ProfessorModel> buscarTodos(){
        List<ProfessorModel> listaDeProfessores = new ArrayList<>();
        super.inicializa();
        listaDeProfessores = super.getSess().createQuery("from ProfessorModel").list();
        super.executar();
        return listaDeProfessores;
    }
    
    public ProfessorModel buscarId(long id){
        ProfessorModel professor = new ProfessorModel();
        super.inicializa();
        professor = (ProfessorModel) super.getSess().get(ProfessorModel.class, id);
        super.executar();
        return professor;
    }
    
    public List<ProfessorModel> buscarPorNome(String nome){
        List<ProfessorModel> listaDeProfessores = new ArrayList<>();
        super.inicializa();
        listaDeProfessores = super.getSess().createQuery("from ProfessorModel where UPPER(nome) like '%" + nome.toUpperCase() + "%'").list();
        super.executar();
        return listaDeProfessores;
    }
    
    public void excluirPorID(long idPessoa){
        super.inicializa();
        ProfessorModel professor = (ProfessorModel) super.getSess().get(ProfessorModel.class, idPessoa);
        super.getSess().delete(professor);
        super.executar();
    }
}
