package com.example.NeoTec.servicio;

import com.example.NeoTec.entidad.Producto;

import java.util.List;

public interface ProductoServicio {
    public List<Producto> listarProductos();

    public Producto guardarProducto(Producto producto);

    public Producto obtenerProductoPorId(Long idproducto);

    public Producto actualizarProducto(Producto producto);

    public  void eliminarProducto(Long idproducto);
}
