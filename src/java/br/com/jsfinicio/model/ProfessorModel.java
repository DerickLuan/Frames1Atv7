package br.com.jsfinicio.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "professor")
@PrimaryKeyJoinColumn(name = "idpessoa")
public class ProfessorModel extends PessoaModel implements Serializable{
    
    @Column(nullable = false)
    private long siape;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idArea", insertable=true, updatable=true)
    @Fetch(FetchMode.JOIN)
    @Cascade(CascadeType.SAVE_UPDATE)
    private AreaModel area;

    public AreaModel getArea() {
        return area;
    }

    public void setArea(AreaModel area) {
        this.area = area;
    }
    
    public long getSiape() {
        return siape;
    }

    public void setSiape(long siape) {
        this.siape = siape;
    }
    
    /*@Override
    public boolean equals(Object obj) {
        System.out.println("Entrou");
        if (obj == null) {
            return false;
        }
        if (!Objects.equals(getClass(), obj.getClass())) {
            return false;
        }
        final ProfessorModel other = (ProfessorModel) obj;
        return !(!Objects.equals(this.getIdpessoa(), other.getIdpessoa()) && (this.getIdpessoa() == null || !this.getIdpessoa().equals(other.getIdpessoa())));
    }*/

    /*@Override
        public int hashCode() {
            int hash = 5;
            hash = 41 * hash + (getIdpessoa() != null ? getIdpessoa().hashCode() : 0);
            return hash;
    }*/
}
