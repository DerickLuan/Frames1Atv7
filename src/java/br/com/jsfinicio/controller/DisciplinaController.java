package br.com.jsfinicio.controller;

import br.com.jsfinicio.model.AlunoModel;
import br.com.jsfinicio.model.AreaModel;
import br.com.jsfinicio.model.DisciplinaModel;
import br.com.jsfinicio.model.ProfessorModel;
import br.com.jsfinicio.repository.AlunoRepository;
import br.com.jsfinicio.repository.AreaRepository;
import br.com.jsfinicio.repository.DisciplinaRepository;
import br.com.jsfinicio.repository.ProfessorRepository;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class DisciplinaController {
    
    private DisciplinaModel disciplina;
    private DisciplinaRepository disciplinaRepository;
    private List<DisciplinaModel> listaDeDisciplina;
    private ProfessorModel professor;
    private ProfessorRepository professorRepository;
    private AreaModel area;
    private AreaRepository areaRepository;
    private AlunoModel aluno;
    private AlunoRepository alunoRepository;
    private List<ProfessorModel> professores;
    private List<AlunoModel> alunos;
    
    public DisciplinaController(){
        this.disciplina = new DisciplinaModel();
        this.disciplinaRepository = new DisciplinaRepository();
        this.listaDeDisciplina = new ArrayList<>();
        this.professor = new ProfessorModel();
        this.professorRepository = new ProfessorRepository();
        this.area = new AreaModel();
        this.areaRepository = new AreaRepository();
        this.aluno = new AlunoModel();
        this.alunoRepository = new AlunoRepository();
        this.professores = new ArrayList<>();
        this.alunos = new ArrayList<>();
    }
    
    public String salvar(){
        this.professor = this.professorRepository.buscarId(this.professor.getIdpessoa());
        this.disciplina.setProfessor(this.professor);
        this.area = this.professor.getArea();
        this.disciplina.setArea(this.area);
        this.disciplinaRepository.salvar(disciplina);
        this.disciplina = new DisciplinaModel();
        
        return "listaDeDisciplina.xhtml?faces-redirect=true";
    }
    
    public String inscricao(){
        this.disciplina = this.disciplinaRepository.buscarId(this.disciplina.getIdDisciplina());
        this.alunos = this.disciplina.getListaDeAlunos();
        this.aluno = this.alunoRepository.buscarPorID(this.aluno.getIdpessoa());
        this.alunos.add(aluno);
        this.disciplina.setListaDeAlunos(this.alunos);
        this.disciplinaRepository.salvar(disciplina);
        this.disciplina = new DisciplinaModel();
        
        return "listaDeDisciplina.xhtml?faces-redirect=true";
    }
    
    public void remover(long id){
        this.aluno = this.alunoRepository.buscarPorID(id);
        this.alunos = this.disciplina.getListaDeAlunos();
        
        for(AlunoModel a : this.alunos) {
            if(a.getIdpessoa() == this.aluno.getIdpessoa())
            this.alunos.remove(this.alunos.indexOf(a));
        }
        this.disciplina.setListaDeAlunos(this.alunos);
        this.disciplinaRepository.salvar(this.disciplina);
                
    }
    
    public void buscar(){
        this.listaDeDisciplina = this.disciplinaRepository.buscarTodos();
    }
    
    public String editarPorID(long iddisciplina) throws IOException {
        this.disciplina = this.disciplinaRepository.buscarId(iddisciplina);

        return "editarDisciplina.xhtml?faces-redirect=true";
    }
    
    public String insPorID(long iddisciplina){
        this.disciplina = this.disciplinaRepository.buscarId(iddisciplina);
        
        return "inscricaoDisciplina.xhtml?faces-redirect=true";
    }
    
    public void buscarPorID(){
        this.disciplina = this.disciplinaRepository.buscarId(this.disciplina.getIdDisciplina());
        this.alunos = this.disciplina.getListaDeAlunos();
    }
    
    public void excluirPorID(long iddisciplina) {
        this.disciplinaRepository.excluirPorID(iddisciplina);
    }
    
    public void buscarPorNome() {
        this.listaDeDisciplina = this.disciplinaRepository.buscarPorNome(this.disciplina.getNome());
    }

    public DisciplinaModel getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(DisciplinaModel disciplina) {
        this.disciplina = disciplina;
    }

    public DisciplinaRepository getDisciplinaRepository() {
        return disciplinaRepository;
    }

    public void setDisciplinaRepository(DisciplinaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }

    public List<DisciplinaModel> getListaDeDisciplina() {
        return listaDeDisciplina;
    }

    public void setListaDeDisciplina(List<DisciplinaModel> listaDeDisciplina) {
        this.listaDeDisciplina = listaDeDisciplina;
    }

    public ProfessorModel getProfessor() {
        return professor;
    }

    public void setProfessor(ProfessorModel professor) {
        this.professor = professor;
    }

    public ProfessorRepository getProfessorRepository() {
        return professorRepository;
    }

    public void setProfessorRepository(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public AreaModel getArea() {
        return area;
    }

    public void setArea(AreaModel area) {
        this.area = area;
    }

    public AreaRepository getAreaRepository() {
        return areaRepository;
    }

    public void setAreaRepository(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    public AlunoModel getAluno() {
        return aluno;
    }

    public void setAluno(AlunoModel aluno) {
        this.aluno = aluno;
    }

    public AlunoRepository getAlunoRepository() {
        return alunoRepository;
    }

    public void setAlunoRepository(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<ProfessorModel> getProfessores() {
        return professores;
    }

    public void setProfessores(List<ProfessorModel> professores) {
        this.professores = professores;
    }

    public List<AlunoModel> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<AlunoModel> alunos) {
        this.alunos = alunos;
    }
    
    
     
}
