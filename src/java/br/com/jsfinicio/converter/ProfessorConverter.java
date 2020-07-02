package br.com.jsfinicio.converter;

import br.com.jsfinicio.model.ProfessorModel;
import br.com.jsfinicio.repository.ProfessorRepository;
import javax.faces.component.UIComponent;  
import javax.faces.context.FacesContext;  
import javax.faces.convert.Converter;  
import javax.faces.convert.FacesConverter;  
  
@FacesConverter(forClass = ProfessorModel.class, value = "profConverter")  
public class ProfessorConverter implements Converter {  
  
    @Override  
    public Object getAsObject(FacesContext context, UIComponent component, String value) {  
        if (value != null && !value.equals("")) {
            ProfessorModel a = new ProfessorRepository().buscarId(Long.valueOf(value));
            System.out.println(a);
            return a;
        }
        return null;
    }  
  
    @Override  
    public String getAsString(FacesContext context, UIComponent component, Object value) {  
       
       if (value instanceof ProfessorModel) {
            ProfessorModel professor = (ProfessorModel) value;
            return String.valueOf(professor.getIdpessoa());
        }
        return "";
    }
  
}