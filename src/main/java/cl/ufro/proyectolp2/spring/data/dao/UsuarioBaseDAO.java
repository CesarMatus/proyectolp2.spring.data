/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.ufro.proyectolp2.spring.data.dao;

import cl.ufro.proyectolp2.spring.data.modelo.Pedido;
import cl.ufro.proyectolp2.spring.data.modelo.UsuarioBase;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author cesar
 */
public interface UsuarioBaseDAO extends CrudRepository<UsuarioBase, Integer> {
    
    public UsuarioBase findByCorreo(String email);     
}
