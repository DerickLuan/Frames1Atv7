package br.com.jsfinicio.controller;

import br.com.jsfinicio.model.AlunoModel;
import br.com.jsfinicio.model.CidadeModel;
import br.com.jsfinicio.model.DisciplinaModel;
import br.com.jsfinicio.model.EstadoModel;
import br.com.jsfinicio.repository.AlunoRepository;
import br.com.jsfinicio.repository.CidadeRepository;
import br.com.jsfinicio.repository.DisciplinaRepository;
import br.com.jsfinicio.repository.EstadoRepository;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class AlunoController {

    private AlunoModel alunoModel;
    private EstadoModel estadoModel;
    private EstadoRepository estadoRepository;
    private AlunoRepository alunoRepository;
    private List<AlunoModel> listaDeAlunos;
    private CidadeModel cidade;
    private CidadeRepository cidadeRepository;
    private List<DisciplinaModel> listaDeDisciplina;
    private DisciplinaModel disiplina;
    private DisciplinaRepository disciplinaRepository;

    public AlunoController() {
        this.estadoRepository = new EstadoRepository();
        this.alunoModel = new AlunoModel();
        this.estadoModel = new EstadoModel();
        this.alunoRepository = new AlunoRepository();
        this.listaDeAlunos = new ArrayList<>();
        this.cidade = new CidadeModel();
        this.cidadeRepository = new CidadeRepository();
        this.listaDeDisciplina = new ArrayList<>();
        this.disiplina = new DisciplinaModel();
        this.disciplinaRepository = new DisciplinaRepository();
    }

    public void salvar() {
        try {
            this.cidade = this.cidadeRepository.buscarPorID(this.cidade.getIdCidade());
            this.alunoModel.setCidade(cidade);
            this.estadoModel = this.cidade.getEstado();
            this.alunoModel.setEstado(this.estadoModel);
            this.alunoRepository.salvar(this.alunoModel);
            this.alunoModel = new AlunoModel();
        } catch (Exception e) {
        }
    }

    public String disciplinas(long id){
        this.alunoModel = this.alunoRepository.buscarPorID(id);
        this.listaDeDisciplina = this.alunoModel.getListaDeDisciplinas();
        return "disciplinasMatriculadas.xhtml?faces-redirect=true";
    }
    
    public void cancelarMatricula(long id){
        this.disiplina = this.disciplinaRepository.buscarId(id);
        this.listaDeDisciplina.remove(this.disiplina);
        this.alunoModel.setListaDeDisciplinas(listaDeDisciplina);
        this.alunoRepository.salvar(this.alunoModel);
    }
    
    public void buscarTodos() {
        this.listaDeAlunos = this.alunoRepository.buscarTodos();
    }

    public void buscarPorNome() {
        this.listaDeAlunos = this.alunoRepository.buscarPorNome(this.alunoModel.getNome());
    }

    public void excluirPorID(long idpessoa) {
        this.alunoRepository.excluirPorID(idpessoa);
    }

    public String editarPorID(long idpessoa) throws IOException {
        this.alunoModel = this.alunoRepository.buscarPorID(idpessoa);

        return "editarAluno.xhtml?faces-redirect=true";
    }

    public EstadoRepository getEstadoRepository() {
        return estadoRepository;
    }

    public void setEstadoRepository(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    public EstadoModel getEstadoModel() {
        return estadoModel;
    }

    public void setEstadoModel(EstadoModel estadoModel) {
        this.estadoModel = estadoModel;
    }

    public AlunoModel getAlunoModel() {
        return alunoModel;
    }

    public void setAlunoModel(AlunoModel alunoModel) {
        this.alunoModel = alunoModel;
    }

    public AlunoRepository getAlunoRepository() {
        return alunoRepository;
    }

    public void setAlunoRepository(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<AlunoModel> getListaDeAlunos() {
        return listaDeAlunos;
    }

    public void setListaDeAlunos(List<AlunoModel> listaDeAlunos) {
        this.listaDeAlunos = listaDeAlunos;
    }

    public CidadeModel getCidade() {
        return cidade;
    }

    public void setCidade(CidadeModel cidade) {
        this.cidade = cidade;
    }

    public CidadeRepository getCidadeRepository() {
        return cidadeRepository;
    }

    public void setCidadeRepository(CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }

    public List<DisciplinaModel> getListaDeDisciplina() {
        return listaDeDisciplina;
    }

    public void setListaDeDisciplina(List<DisciplinaModel> listaDeDisciplina) {
        this.listaDeDisciplina = listaDeDisciplina;
    }

    public DisciplinaModel getDisiplina() {
        return disiplina;
    }

    public void setDisiplina(DisciplinaModel disiplina) {
        this.disiplina = disiplina;
    }

    public DisciplinaRepository getDisciplinaRepository() {
        return disciplinaRepository;
    }

    public void setDisciplinaRepository(DisciplinaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }

    
}
