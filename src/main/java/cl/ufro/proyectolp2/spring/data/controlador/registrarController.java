/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.ufro.proyectolp2.spring.data.controlador;

import cl.ufro.proyectolp2.spring.data.dao.ClienteDAO;
import cl.ufro.proyectolp2.spring.data.modelo.Cliente;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author joseph
 */
@Controller
@RequestMapping
public class registrarController {
    
    @Autowired
    private ClienteDAO clienteDAO;
    
   @GetMapping("registrar")
    public String page(Model model) {
        model.addAttribute("clientenuevo", new Cliente());
        return "registrar";
    }
    
    @PostMapping("nuevoRegistro")
    public void registrarClienteNuevo(@ModelAttribute Cliente cliente, HttpServletResponse response) throws IOException {
        this.clienteDAO.save(cliente); 
        response.sendRedirect("/");
    }
}
