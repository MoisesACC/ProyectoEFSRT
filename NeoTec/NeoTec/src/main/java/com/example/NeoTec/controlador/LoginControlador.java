package com.example.NeoTec.controlador;

import com.example.NeoTec.entidad.Usuario;
import com.example.NeoTec.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping("/login")
    public String mostrarLogin() {
        return "login"; // Vista login.html
    }

    @PostMapping("/login")
    public String procesarLogin(@RequestParam("usuario") String usuario,
                                 @RequestParam("password") String password,
                                 HttpSession session,
                                 Model model) {
        Usuario usuarioValidado = usuarioServicio.validarUsuario(usuario, password);
        if (usuarioValidado != null) {
            session.setAttribute("usuarioLogueado", usuarioValidado);
            return "redirect:/inicio"; // Redirigir al index
        } else {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "login"; // Regresar al login con mensaje de error
        }
    }

    @GetMapping("/logout")
    public String cerrarSesion(HttpSession session) {
        session.invalidate();
        return "redirect:/inicio";
    }
    
    

}
