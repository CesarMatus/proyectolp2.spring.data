/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.ufro.proyectolp2.spring.data.controlador;

import cl.ufro.proyectolp2.spring.data.dao.CasinoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author cesar
 */
@Controller
@RequestMapping("casinos")
public class CasinoController {
    
    @Autowired
    private CasinoDAO casinoDAO; 
    
    @GetMapping
    public String page(Model model) {
        
        model.addAttribute("casinos", this.casinoDAO.findAll());
        return "casinos/casinos";
    }
    
    @GetMapping("registrarcasino")
    public String Crear(Model model) {
        
        model.addAttribute("registrarcasino", this.casinoDAO.findAll());
        return "casinos/registrarcasino";
    }
}
