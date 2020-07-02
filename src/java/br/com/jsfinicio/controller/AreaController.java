package br.com.jsfinicio.controller;

import br.com.jsfinicio.model.AreaModel;
import br.com.jsfinicio.model.ProfessorModel;
import br.com.jsfinicio.repository.AreaRepository;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class AreaController {
    private AreaModel area;
    private AreaRepository areaRepository;
    private List<AreaModel> listaDeAreas;
    private List<ProfessorModel> professores;
    
    public AreaController(){
        this.area = new AreaModel();
        this.areaRepository = new AreaRepository();
        this.listaDeAreas = new ArrayList<>();
        this.professores = new ArrayList<>();
    }
    
    public String salvar(){
        this.areaRepository.salvar(area);
        this.area = new AreaModel();
        return "listaDeAreas.xhtml?faces-redirect=true";
    }
    
    public void buscar(){
        this.listaDeAreas = this.areaRepository.buscarTodos();
    }
    
    public String editarPorID(long idarea) throws IOException {
        this.area = this.areaRepository.buscarPorID(idarea);

        return "editarArea.xhtml?faces-redirect=true";
    
    }
    
    public void areas(){
        this.area = this.areaRepository.buscarPorID(this.area.getIdArea());
        this.professores = this.area.getListaDeProfessores();
    }
    
    public void excluirPorID(long idarea) {
        this.areaRepository.excluirPorID(this.area.getIdArea());
    }
    
    public void buscarPorNome() {
        this.listaDeAreas = this.areaRepository.buscarPorNome(this.area.getDescricao());
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

    public List<AreaModel> getListaDeAreas() {
        return listaDeAreas;
    }

    public void setListaDeAreas(List<AreaModel> listaDeAreas) {
        this.listaDeAreas = listaDeAreas;
    }  

    public List<ProfessorModel> getProfessores() {
        return professores;
    }

    public void setProfessores(List<ProfessorModel> professores) {
        this.professores = professores;
    }
    
    
}
