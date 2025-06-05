package com.example.NeoTec.repositorio;

import com.example.NeoTec.entidad.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.NeoTec.repositorio.ProductoRepositorio;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Long> {

}
