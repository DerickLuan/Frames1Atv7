package br.com.jsfinicio.repository;

import br.com.jsfinicio.model.AreaModel;
import br.com.jsfinicio.util.Conexao;
import java.util.ArrayList;
import java.util.List;

public class AreaRepository extends Conexao{
    
    public void salvar(AreaModel areaModel){
        super.inicializa();
        super.getSess().saveOrUpdate(areaModel);
        super.executar();
    }
    
    public List<AreaModel> buscarTodos(){
        List<AreaModel> listaDeAreas = new ArrayList<>();
        super.inicializa();
        listaDeAreas = super.getSess().createQuery("from AreaModel").list();
        super.executar();
        return listaDeAreas;
    }
    
    public AreaModel buscarPorID(long idArea){
        AreaModel area = new AreaModel();
        super.inicializa();
        area = (AreaModel) super.getSess().get(AreaModel.class, idArea);
        super.executar();
        return area;
    }
    
    public void excluirPorID(long idArea){
        super.inicializa();
        AreaModel area = (AreaModel) super.getSess().get(AreaModel.class, idArea);
        super.getSess().delete(area);
        super.executar();
    }
    
    public List<AreaModel> buscarPorNome(String descricao){
        List<AreaModel> listaDeAreas = new ArrayList<>();
        super.inicializa();
        listaDeAreas = super.getSess().createQuery("from AreaModel where UPPER(descricao) like '%" + descricao.toUpperCase() + "%'").list();
        super.executar();
        return listaDeAreas;
    }
}
