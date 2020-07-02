package br.com.jsfinicio.controller;

import br.com.jsfinicio.model.AlunoModel;
import br.com.jsfinicio.model.CidadeModel;
import br.com.jsfinicio.model.EstadoModel;
import br.com.jsfinicio.repository.CidadeRepository;
import br.com.jsfinicio.repository.EstadoRepository;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class CidadeController {
    
    private CidadeModel cidadeModel;
    private CidadeRepository cidadeRepository;
    private EstadoController estadoController;
    private EstadoModel estadoModel;
    private EstadoRepository estadoRepository;
    private List<CidadeModel> listaDeCidades;
    
    public CidadeController(){
        this.cidadeModel = new CidadeModel();
        this.cidadeRepository = new CidadeRepository();
        this.estadoController = new EstadoController();
        this.estadoModel = new EstadoModel();
        this.estadoRepository = new EstadoRepository();
        this.listaDeCidades =  new ArrayList<>();
    }
  
    public void buscarTodos(){
        this.listaDeCidades = this.cidadeRepository.buscarTodos();
    }

    public void editarPorID(long idCidade) throws IOException {
        this.cidadeModel = this.cidadeRepository.buscarPorID(idCidade);
    }
    
    public CidadeModel getCidadeModel() {
        return cidadeModel;
    }

    public void setCidadeModel(CidadeModel cidadeModel) {
        this.cidadeModel = cidadeModel;
    }

    public CidadeRepository getCidadeRepository() {
        return cidadeRepository;
    }

    public void setCidadeRepository(CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }

    public List<CidadeModel> getListaDeCidades() {
        return listaDeCidades;
    }

    public void setListaDeCidades(List<CidadeModel> listaDeCidades) {
        this.listaDeCidades = listaDeCidades;
    }

    public EstadoController getEstadoController() {
        return estadoController;
    }

    public void setEstadoController(EstadoController estadoController) {
        this.estadoController = estadoController;
    }

    public EstadoModel getEstadoModel() {
        return estadoModel;
    }

    public void setEstadoModel(EstadoModel estadoModel) {
        this.estadoModel = estadoModel;
    }
    
}

