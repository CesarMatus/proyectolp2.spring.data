/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.ufro.proyectolp2.spring.data.controlador;

import cl.ufro.proyectolp2.spring.data.dao.MenuDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author pablo
 */
@Controller
@RequestMapping("menu")
public class MenuController {

    @Autowired
    private MenuDAO mDAO;

    @GetMapping
    public String page(Model model) {
        model.addAttribute("menu", this.mDAO.findAll());
        return "menu";

    }

    @PostMapping("ejecutivo")
    public String mostrarEjecutivo(Model model) {
        model.addAttribute("menu", this.mDAO.findAll());
        return "/menu/ejecutivo";
    }
    
    @PostMapping("junaeb")
    public String mostrarJunaeb(Model model) {
        model.addAttribute("menu", this.mDAO.findAll());
        return "/menu/junaeb";
    }
    
    @PostMapping("atb")
    public String mostrarATB(Model model) {
        model.addAttribute("menu", this.mDAO.findAll());
        return "/menu/atb";
    }
    
    @PostMapping("hipocalorico")
    public String mostrarHipocalorico(Model model) {
        model.addAttribute("menu", this.mDAO.findAll());
        return "/menu/hipocalorico";
    }
    
    
    
}
