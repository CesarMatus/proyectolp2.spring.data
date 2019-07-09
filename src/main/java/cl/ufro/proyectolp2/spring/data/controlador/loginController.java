/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.ufro.proyectolp2.spring.data.controlador;

//import cl.ufro.proyectolp2.spring.data.dao.ClienteDAO;
import cl.ufro.proyectolp2.spring.data.dao.UsuarioBaseDAO;
import cl.ufro.proyectolp2.spring.data.modelo.Cliente;
import cl.ufro.proyectolp2.spring.data.modelo.Funcionario;
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
    //ClienteDAO cDAO;

    @GetMapping
    public String page(Model model) {
        return "login";
    }

    @PostMapping
    public String login(@ModelAttribute("correo") String correo, @ModelAttribute("password") String password, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Model model = null; 

        UsuarioBase usuarioBD = ubDAO.findByCorreo(correo);

        if (usuarioBD != null && usuarioBD.getContraseña().equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuarioBD);
            if(usuarioBD instanceof Funcionario) {
               response.sendRedirect("administradores");
            }else if(usuarioBD instanceof Cliente){
                response.sendRedirect("pedidos");                
            }
            return null;
        }else{
            model.addAttribute("error", true); 
        }
        
        return "login";
    }
    
     @PostMapping("logout")
    public String logout(HttpServletRequest request){
        
        request.getSession().invalidate();
        
        return "logout";
    }
    
    @PostMapping("menu/logout")
    public String logout2(HttpServletRequest request){
        
        request.getSession().invalidate();
        
        return "index";        
    }
    /*
    @PostMapping("login")
    public String login(
            Model model,  
            @ModelAttribute Cliente c,
            HttpServletRequest request
    ){
        
        Cliente usuarioBD = cDAO.findByUsuarioAndPassword(c.getCorreo(),c.getContraseña());
        
        if(usuarioBD!=null){
            request.getSession().setAttribute("usuarioLogueado", usuarioBD);
            return "index";
        }else{
            model.addAttribute("cliente", new Cliente());
            model.addAttribute("error", true);
            return "login";
        } 
        
    }*/
    
}
