/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.ufro.proyectolp2.spring.data.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author cesar
 */
@Entity
@Table(name = "funcionario")
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f")
    , @NamedQuery(name = "Funcionario.findById", query = "SELECT f FROM Funcionario f WHERE f.id = :id")
    , @NamedQuery(name = "Funcionario.findByNombre", query = "SELECT f FROM Funcionario f WHERE f.nombre = :nombre")
    , @NamedQuery(name = "Funcionario.findByCorreo", query = "SELECT f FROM Funcionario f WHERE f.correo = :correo")
    , @NamedQuery(name = "Funcionario.findByContrase\u00f1a", query = "SELECT f FROM Funcionario f WHERE f.contrase\u00f1a = :contrase\u00f1a")
    , @NamedQuery(name = "Funcionario.findByEdad", query = "SELECT f FROM Funcionario f WHERE f.edad = :edad")})
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 255)
    @Column(name = "correo")
    private String correo;
    @Size(max = 255)
    @Column(name = "contrase\u00f1a")
    private String contraseña;
    @Column(name = "edad")
    private Integer edad;
    @JoinColumn(name = "cod_casino", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Casino codCasino;

    public Funcionario() {
    }

    public Funcionario(Integer id) {
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Casino getCodCasino() {
        return codCasino;
    }

    public void setCodCasino(Casino codCasino) {
        this.codCasino = codCasino;
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
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.ufro.proyectolp2.spring.data.modelo.Funcionario[ id=" + id + " ]";
    }
    
}
