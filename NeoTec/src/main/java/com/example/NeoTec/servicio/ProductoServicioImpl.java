package com.example.NeoTec.servicio;


import com.example.NeoTec.entidad.Producto;
import com.example.NeoTec.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicioImpl  implements  ProductoServicio{

    @Autowired
    private ProductoRepositorio repositorio;

    @Override
    public List<Producto> listarProductos() {
        return repositorio.findAll();
    }

    @Override
    public Producto guardarProducto(Producto producto){
        return repositorio.save(producto);
    }

    @Override
    public Producto obtenerProductoPorId(Long idproducto){
        return repositorio.findById(idproducto).get();
    }

    @Override
    public Producto actualizarProducto(Producto producto) {
        return repositorio.save(producto);
    }

    @Override
    public void eliminarProducto(Long idproducto) {
        repositorio.deleteById(idproducto);
    }

}
