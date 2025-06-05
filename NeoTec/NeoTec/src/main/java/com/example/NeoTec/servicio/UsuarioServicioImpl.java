package com.example.NeoTec.servicio;

import com.example.NeoTec.entidad.Usuario;
import com.example.NeoTec.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {

    @Autowired
    private UsuarioRepositorio repositorio;

    @Override
    public Usuario validarUsuario(String usuario, String password) {
        Usuario usuarioEncontrado = repositorio.findByUsuario(usuario);
        if (usuarioEncontrado != null && usuarioEncontrado.getPassword().equals(password)) {
            return usuarioEncontrado;
        }
        return null;
    }
    
    
    @Override
    public String registrarUsuario(String usuario, String password) {
        return repositorio.registrarUsuario(usuario, password);
    }
}
