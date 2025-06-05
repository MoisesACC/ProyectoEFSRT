package com.example.NeoTec.servicio;

import com.example.NeoTec.entidad.Usuario;

public interface UsuarioServicio {
    Usuario validarUsuario(String usuario, String password); // Método existente
    
    String registrarUsuario(String usuario, String password);
}
