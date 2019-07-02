/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.ufro.proyectolp2.spring.data.controlador;


import cl.ufro.proyectolp2.spring.data.dao.ClienteDAO;
import cl.ufro.proyectolp2.spring.data.modelo.Cliente;
import java.io.IOException;
import java.util.Optional;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author joseph
 */
@Controller
@RequestMapping("clientes")

public class ClienteController {
    @Autowired
    private ClienteDAO clienteDAO;
    
    @GetMapping
    public String page(Model model){
         model.addAttribute("clientes", this.clienteDAO.findAll());
        return "clientes";
    }
    
    @GetMapping("index")
    public String registrarCliente(Model model) {
        
        model.addAttribute("clientenuevo", new Cliente());
        return "index";
    }
    
    @PostMapping("registrarCliente")
    public void registrarClienteNuevo(@ModelAttribute Cliente cliente, HttpServletResponse response) throws IOException {
        this.clienteDAO.save(cliente); 
        response.sendRedirect("/");
    }
    
    @PostMapping("editarcliente/id")
    public void editarCliente(@ModelAttribute Cliente cliente, HttpServletResponse response,@PathVariable("id") Integer id) throws IOException {
        Optional<Cliente> clienteBD = clienteDAO.findById(id.intValue());
        this.clienteDAO.save(cliente); 
        response.sendRedirect("");
    }
    
    @GetMapping("eliminarcasino/{id}")
    public String eliminarCliente(HttpServletResponse response,@PathVariable("id") Integer id) throws IOException {
        this.clienteDAO.deleteById(id); 
        return "redirect:/clientes";
    }
    
    
    @GetMapping("{id}")
    public String show(@PathVariable("id") Integer id,Model model){
        model.addAttribute("clientenuevo", clienteDAO.findById(id).get());
        return "clientes/editarcliente"; 
    }
}
