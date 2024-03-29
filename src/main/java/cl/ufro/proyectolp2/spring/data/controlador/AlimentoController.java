/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.ufro.proyectolp2.spring.data.controlador;

import cl.ufro.proyectolp2.spring.data.dao.AlimentoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *
 * @author joseph
 */
@Controller
@RequestMapping("alimentos")
public class AlimentoController {
    @Autowired
    private AlimentoDAO alimentoDAO;
    
    @GetMapping
    public String page(Model model){
         model.addAttribute("alimentos", this.alimentoDAO.findAll());
        return "alimentos/alimentos";
    }
}
