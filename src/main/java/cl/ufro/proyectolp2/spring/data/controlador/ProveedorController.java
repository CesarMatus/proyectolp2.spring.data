/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.ufro.proyectolp2.spring.data.controlador;


import cl.ufro.proyectolp2.spring.data.dao.ProveedorDAO;
import cl.ufro.proyectolp2.spring.data.modelo.Proveedor;
import java.io.IOException;
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
@RequestMapping("proveedores")

public class ProveedorController {
    @Autowired
    private ProveedorDAO proveedorDAO;
    
    @GetMapping
    public String page(Model model){
         model.addAttribute("proveedores", this.proveedorDAO.findAll());
        return "proveedores/proveedores";
    }
    
     @GetMapping("registrarproveedor")
    public String registrarProveedor(Model model) {
        
        model.addAttribute("proveedornuevo", new Proveedor());
        return "proveedores/registrarproveedor";
    }
    
    @PostMapping("registrarProveedor")
    public void registrarProveedorNuevo(@ModelAttribute Proveedor proveedor, HttpServletResponse response) throws IOException {
        this.proveedorDAO.save(proveedor); 
        response.sendRedirect("");
    }
    
    @PostMapping("editarproveedor/id")
    public void editarProveedor(@ModelAttribute Proveedor proveedor, HttpServletResponse response,@PathVariable("id") Integer id) throws IOException {
        Proveedor provedorBD = proveedorDAO.findById(id.intValue());
        this.proveedorDAO.save(proveedor); 
        response.sendRedirect("");
    }
    
    @GetMapping("eliminarproveedor/{id}")
    public String eliminarProveedor(HttpServletResponse response,@PathVariable("id") Integer id) throws IOException {
        this.proveedorDAO.deleteById(id); 
        return "redirect:/proveedores";
    }
    
    
    @GetMapping("{id}")
    public String show(@PathVariable("id") Integer id,Model model){
        model.addAttribute("proveedornuevo", proveedorDAO.findById(id).get());
        return "proveedores/editarproveedor"; 
    }
    
}
