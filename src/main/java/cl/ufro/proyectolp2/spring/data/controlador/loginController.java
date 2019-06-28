/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.ufro.proyectolp2.spring.data.controlador;

import cl.ufro.proyectolp2.spring.data.dao.UsuarioBaseDAO;
import cl.ufro.proyectolp2.spring.data.modelo.UsuarioBase;
import java.io.IOException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author pablo
 */
@Controller
@RequestMapping("login")
public class loginController {

    @Autowired
    private UsuarioBaseDAO ubDAO;

    @GetMapping
    public String page(Model model) {
        return "login";
    }

    @PostMapping
    public String login(@ModelAttribute HashMap<String, String> formulario, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String correo = formulario.get("correo");
        String password = formulario.get("password");
        
        System.out.println(formulario);

        UsuarioBase usuarioBD = ubDAO.findByCorreo(correo);

        if (usuarioBD != null && usuarioBD.getContraseña().equals(password)) {
            HttpSession sesion = request.getSession();
            sesion.setAttribute("usuario", usuarioBD);
            response.sendRedirect("pedidos");
            return null;
        }
        return "login";
    }

}
