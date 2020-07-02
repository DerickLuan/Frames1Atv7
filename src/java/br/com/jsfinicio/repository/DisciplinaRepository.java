package br.com.jsfinicio.repository;

import br.com.jsfinicio.model.DisciplinaModel;
import br.com.jsfinicio.util.Conexao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaRepository extends Conexao implements Serializable{
    public void salvar(DisciplinaModel disciplina){
        super.inicializa();
        super.getSess().saveOrUpdate(disciplina);
        super.executar();
    }
    
    public List<DisciplinaModel> buscarTodos(){
        List<DisciplinaModel> listaDeDisciplina = new ArrayList<>();
        super.inicializa();
        listaDeDisciplina = super.getSess().createQuery("from DisciplinaModel").list();
        super.executar();
        return listaDeDisciplina;
    }
    
    public DisciplinaModel buscarId(long id){
        DisciplinaModel disciplina = new DisciplinaModel();
        super.inicializa();
        disciplina = (DisciplinaModel) super.getSess().get(DisciplinaModel.class, id);
        super.executar();
        return disciplina;
    }
    
    public List<DisciplinaModel> buscarPorNome(String nome){
        List<DisciplinaModel> listaDeDisciplina = new ArrayList<>();
        super.inicializa();
        listaDeDisciplina = super.getSess().createQuery("from DisciplinaModel where UPPER(nome) like '%" + nome.toUpperCase() + "%'").list();
        super.executar();
        return listaDeDisciplina;
    }
    
    public void excluirPorID(long idDisciplina){
        super.inicializa();
        DisciplinaModel disciplina = (DisciplinaModel) super.getSess().get(DisciplinaModel.class, idDisciplina);
        super.getSess().delete(disciplina);
        super.executar();
    }
}
