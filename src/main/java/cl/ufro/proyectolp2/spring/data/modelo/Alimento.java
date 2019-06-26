/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.ufro.proyectolp2.spring.data.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author cesar
 */
@Entity
@Table(name = "alimento")
@NamedQueries({
    @NamedQuery(name = "Alimento.findAll", query = "SELECT a FROM Alimento a")
    , @NamedQuery(name = "Alimento.findById", query = "SELECT a FROM Alimento a WHERE a.id = :id")
    , @NamedQuery(name = "Alimento.findByNombre", query = "SELECT a FROM Alimento a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Alimento.findByDescripcion", query = "SELECT a FROM Alimento a WHERE a.descripcion = :descripcion")})
public class Alimento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinTable(name = "menu_alimento", joinColumns = {
        @JoinColumn(name = "alimentoid", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "menuid", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Menu> menuCollection;

    public Alimento() {
    }

    public Alimento(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Collection<Menu> getMenuCollection() {
        return menuCollection;
    }

    public void setMenuCollection(Collection<Menu> menuCollection) {
        this.menuCollection = menuCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alimento)) {
            return false;
        }
        Alimento other = (Alimento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.ufro.proyectolp2.spring.data.modelo.Alimento[ id=" + id + " ]";
    }
    
}
