/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.ufro.proyectolp2.spring.data.controlador;

import cl.ufro.proyectolp2.spring.data.dao.CasinoDAO;
import cl.ufro.proyectolp2.spring.data.dao.FuncionarioDAO;
import cl.ufro.proyectolp2.spring.data.modelo.Funcionario;
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
@RequestMapping("funcionarios")
public class FuncionarioController {
    
    @Autowired
    private FuncionarioDAO funcionarioDAO; 
    
    @Autowired
    private CasinoDAO casinoDAO; 
    
    @GetMapping
    public String page(Model model) {
        
        model.addAttribute("funcionarios", this.funcionarioDAO.findAll());
        return "funcionarios/funcionarios";
    }
    
    @GetMapping("registrarfuncionario")
    public String registrarFuncionario(Model model) {
        model.addAttribute("casinos", this.casinoDAO.findAll());
        model.addAttribute("funcionarionuevo", new Funcionario());
        return "funcionarios/registrarfuncionario";
    }

    @PostMapping("registrarFuncionario")
    public void registrarFuncionarioNuevo(@ModelAttribute Funcionario funcionario, HttpServletResponse response) throws IOException {
        this.funcionarioDAO.save(funcionario); 
        response.sendRedirect("");
    }
    
    @PostMapping("editarfuncionario/id")
    public void editarFuncionario(@ModelAttribute Funcionario funcionario, HttpServletResponse response,@PathVariable("id") Integer id) throws IOException {
        Funcionario funcionarioBD = funcionarioDAO.findById(id.intValue());
        this.funcionarioDAO.save(funcionario); 
        response.sendRedirect("");
    }
    
    @GetMapping("eliminarfuncionario/{id}")
    public String eliminarFuncionario(HttpServletResponse response,@PathVariable("id") Integer id) throws IOException {
        this.funcionarioDAO.deleteById(id); 
        return "redirect:/funcionarios";
    }
    
    
    @GetMapping("{id}")
    public String show(@PathVariable("id") Integer id,Model model){
        model.addAttribute("funcionarionuevo", funcionarioDAO.findById(id).get());
        return "funcionarios/editarfuncionario"; 
    }
}