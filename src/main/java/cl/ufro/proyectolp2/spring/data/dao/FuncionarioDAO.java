/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.ufro.proyectolp2.spring.data.dao;

import cl.ufro.proyectolp2.spring.data.modelo.Funcionario;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author pablo
 */
public interface FuncionarioDAO extends CrudRepository<Funcionario, Integer> {
    
    public Funcionario findById(int id);           
}
