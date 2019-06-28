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
public class Funcionario extends UsuarioBase implements Serializable {

    private static final long serialVersionUID = 1L;
        
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "edad")
    private Integer edad;
    
    @JoinColumn(name = "cod_casino", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Casino codCasino;

    public Funcionario() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    public String toString() {
        return "cl.ufro.proyectolp2.spring.data.modelo.Funcionario[ id=" + this.getId() + " ]";
    }
    
}
