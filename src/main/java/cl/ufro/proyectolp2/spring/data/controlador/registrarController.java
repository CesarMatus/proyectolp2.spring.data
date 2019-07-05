/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.ufro.proyectolp2.spring.data.controlador;

import cl.ufro.proyectolp2.spring.data.modelo.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author joseph
 */
@Controller
@RequestMapping
public class registrarController {
    
   @GetMapping("registrar")
    public String page(Model model) {
        model.addAttribute("clientenuevo", new Cliente());
        return "registrar";
    }
    
}
