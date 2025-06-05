package com.example.NeoTec.repositorio;

import com.example.NeoTec.entidad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
    Usuario findByUsuario(String usuario);
    
    @Procedure(procedureName = "registrarUsuario")
    String registrarUsuario(@Param("usuario") String usuario, @Param("password") String password);
}
