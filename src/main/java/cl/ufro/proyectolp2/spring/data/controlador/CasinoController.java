/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.ufro.proyectolp2.spring.data.controlador;

import cl.ufro.proyectolp2.spring.data.dao.CasinoDAO;
import cl.ufro.proyectolp2.spring.data.modelo.Casino;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    public String registrarCasino(Model model) {
        
        model.addAttribute("casinonuevo", new Casino());
        return "casinos/registrarcasino";
    }
    
    @PostMapping("registrarCasino")
    public void registrarCasinoNuevo(@ModelAttribute Casino casino, HttpServletResponse response) throws IOException {
        this.casinoDAO.save(casino); 
        response.sendRedirect("");
    }
    
    @PostMapping("editarcasino/id")
    public void editarCasino(@ModelAttribute Casino casino, HttpServletResponse response,@PathVariable("id") Integer id) throws IOException {
        Casino casinoBD = casinoDAO.findById(id.intValue());
        this.casinoDAO.save(casino); 
        response.sendRedirect("");
    }
    
    @DeleteMapping("eliminarcasino/id")
    public void eliminarCasino(@ModelAttribute Casino casino, HttpServletResponse response,@PathVariable("id") Integer id) throws IOException {
        this.casinoDAO.deleteById(id); 
        response.sendRedirect("");
    }
    
    
    @GetMapping("{id}")
    public String show(@PathVariable("id") Integer id,Model model){
        model.addAttribute("casinonuevo", casinoDAO.findById(id).get());
        return "casinos/editarcasino"; 
    }
    
    
}
