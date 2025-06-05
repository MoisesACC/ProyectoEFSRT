package com.example.NeoTec.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.NeoTec.entidad.Usuario;
import com.example.NeoTec.servicio.UsuarioServicio;

@Controller
public class UsuarioControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping("/registro")
    public String mostrarFormularioDeRegistro(Model modelo) {
        modelo.addAttribute("usuario", new Usuario());
        return "registro";
    }

    @PostMapping("/registro")
    public String registrarUsuario(@RequestParam("usuario") String usuario,
                                   @RequestParam ("password")String password,
                                   Model modelo) {
        String resultado = usuarioServicio.registrarUsuario(usuario, password);

        if (resultado.equals("Usuario registrado exitosamente")) {
            return "redirect:/login";
        } else {
            modelo.addAttribute("error", resultado);
            return "registro";
        }
    }
}


