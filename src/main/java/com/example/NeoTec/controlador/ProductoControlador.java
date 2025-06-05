package com.example.NeoTec.controlador;


import com.example.NeoTec.entidad.Producto;
import com.example.NeoTec.servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ProductoControlador {

    @Autowired
    private ProductoServicio servicio;

    // Página de inicio
    @GetMapping({ "inicio", "/" })
    public String inicio(Model modelo) {
        return "index"; // La vista debe llamarse "index.html" en /templates/
    }

    // Página para listar productos
    @GetMapping("/productos")
    public String listarProductos(Model modelo) {
        modelo.addAttribute("productos", servicio.listarProductos());
        return "productos"; // La vista debe llamarse "productos.html" en /templates/
    }

    // Página "Nosotros"
    @GetMapping("/nosotros")
    public String nosotros(Model modelo) {
        return "nosotros"; // La vista debe llamarse "nosotros.html" en /templates/
    }

    // Página para crear un producto
    @GetMapping("/productos/nuevo")
    public String crearProducto(Model modelo) {
        Producto producto = new Producto();
        modelo.addAttribute("producto", producto);
        return "crear_productos"; // La vista debe llamarse "crear_productos.html" en /templates/
    }

    // Guardar un producto
    @PostMapping("/productos")
    public String guardarProducto(@ModelAttribute("producto") Producto producto) {
        servicio.guardarProducto(producto);
        return "redirect:/productos";
    }

    // Página para editar un producto
    @GetMapping("/productos/editar/{idProducto}")
    public String mostrarFormularioDeEditar(@PathVariable("idProducto") Long idProducto, Model modelo) {
        Producto producto = servicio.obtenerProductoPorId(idProducto);
        if (producto == null) {
            throw new RuntimeException("Producto no encontrado: " + idProducto);
        }
        modelo.addAttribute("producto", producto);
        return "editar_producto";
    }

    // Actualizar un producto
    @PostMapping("/productos/{idProducto}")
    public String actualizarProducto(@PathVariable("idProducto") Long idProducto,
                                     @ModelAttribute("producto") Producto producto) {
        Producto productoExistente = servicio.obtenerProductoPorId(idProducto);
        if (productoExistente == null) {
            throw new RuntimeException("Producto no encontrado: " + idProducto);
        }
        productoExistente.setNombre(producto.getNombre());
        productoExistente.setMarca(producto.getMarca());
        productoExistente.setDescripcion(producto.getDescripcion());
        productoExistente.setPrecio(producto.getPrecio());
        servicio.actualizarProducto(productoExistente);
        return "redirect:/productos";
    }

    @PostMapping("/productos/eliminar/{idProducto}")
    public String eliminarProducto(@PathVariable("idProducto") Long idProducto) {
        servicio.eliminarProducto(idProducto);
        return "redirect:/productos";
    }

}




