package br.com.jsfinicio.controller;

import br.com.jsfinicio.model.AreaModel;
import br.com.jsfinicio.model.CidadeModel;
import br.com.jsfinicio.model.EstadoModel;
import br.com.jsfinicio.model.ProfessorModel;
import br.com.jsfinicio.repository.AreaRepository;
import br.com.jsfinicio.repository.CidadeRepository;
import br.com.jsfinicio.repository.EstadoRepository;
import br.com.jsfinicio.repository.ProfessorRepository;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ProfessorController {
    
     
    private ProfessorModel professorModel;
    private EstadoModel estadoModel;
    private AreaModel area;
    private AreaRepository areaRepository;
    private EstadoRepository estadoRepository;
    private ProfessorRepository professorRepository;
    private List<ProfessorModel> listaDeProfessores;
    private List<AreaModel> areas;
    private CidadeModel cidade;
    private CidadeRepository cidadeRepository;
    
    public ProfessorController(){
        this.professorModel = new ProfessorModel();
        this.professorRepository = new ProfessorRepository();
        this.listaDeProfessores =  new ArrayList<>();
        this.estadoModel = new EstadoModel();
        this.estadoRepository = new EstadoRepository();
        this.area = new AreaModel();
        this.areaRepository = new AreaRepository();
        this.cidade = new CidadeModel();
        this.cidadeRepository = new CidadeRepository();
    }
    
    public String salvar(){
        this.cidade = this.cidadeRepository.buscarPorID(this.cidade.getIdCidade());
        this.professorModel.setCidade(cidade);
        this.estadoModel = this.cidade.getEstado();
        this.professorModel.setEstado(this.estadoModel);
        this.area = this.areaRepository.buscarPorID(this.area.getIdArea());
        this.professorModel.setArea(this.area);
        this.professorRepository.salvar(this.professorModel);
        this.professorModel = new ProfessorModel();
        
        return "listaDeProfessores.xhtml?faces-redirect=true";
    }

    public void buscar(){
        this.listaDeProfessores = this.professorRepository.buscarTodos();
    }
    
     public void buscarPorNome() {
        this.listaDeProfessores = this.professorRepository.buscarPorNome(this.professorModel.getNome());
    }

    public String excluirPorID(long idpessoa) {
        this.professorRepository.excluirPorID(idpessoa);
        return "listaDeProfessores.xhtml?faces-redirect=true";
    }

    public String editarPorID(long idpessoa) throws IOException {
        this.professorModel = this.professorRepository.buscarId(idpessoa);

        return "editarProfessor.xhtml?faces-redirect=true";
    }

    public ProfessorModel getProfessorModel() {
        return professorModel;
    }

    public void setProfessorModel(ProfessorModel professorModel) {
        this.professorModel = professorModel;
    }

    public List<AreaModel> getAreas() {
        areas = new AreaRepository().buscarTodos();
        return areas;
    }

    public void setAreas(List<AreaModel> areas) {
        this.areas = areas;
    }

    public ProfessorRepository getProfessorRepository() {
        return professorRepository;
    }

    public void setProfessorRepository(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public List<ProfessorModel> getListaDeProfessores() {
        return listaDeProfessores;
    }

    public void setListaDeProfessores(List<ProfessorModel> listaDeProfessores) {
        this.listaDeProfessores = listaDeProfessores;
    }

    public EstadoModel getEstadoModel() {
        return estadoModel;
    }

    public void setEstadoModel(EstadoModel estadoModel) {
        this.estadoModel = estadoModel;
    }

    public EstadoRepository getEstadoRepository() {
        return estadoRepository;
    }

    public void setEstadoRepository(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
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
    
}
