package com.example.NeoTec.entidad;

//ECLIPSE
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;

//INTELLIJ
import jakarta.persistence.*;


@Entity
@Table(name = "Producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idproducto;


    @Column(name = "Nombre", nullable = false, length = 45)
    private String Nombre;

    @Column(name = "Marca", nullable = false, length = 45)
    private String Marca;

    @Column(name = "Descripcion", nullable = false, length = 400)
    private String Descripcion;

    @Column(name = "Precio", nullable = false)
    private Double Precio;

    public Producto(){

    }

	public Producto( String nombre, String marca, String descripcion, Double precio) {
		Nombre = nombre;
		Marca = marca;
		Descripcion = descripcion;
		Precio = precio;
	}

	public Producto(Long idproducto, String nombre, String marca, String descripcion, Double precio) {
		this.idproducto = idproducto;
		Nombre = nombre;
		Marca = marca;
		Descripcion = descripcion;
		Precio = precio;
	}

	public Long getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(Long idproducto) {
		this.idproducto = idproducto;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getMarca() {
		return Marca;
	}

	public void setMarca(String marca) {
		Marca = marca;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public Double getPrecio() {
		return Precio;
	}

	public void setPrecio(Double precio) {
		Precio = precio;
	}

	@Override
    public  String toString(){
        return "Producto [idproducto=" + idproducto + ", nombre=" + Nombre +
				",marca =" + Marca + ", descripcion=" + Descripcion + ", precio=" + Precio + "]";

    }
}


