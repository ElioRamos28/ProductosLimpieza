package com.edutecno.dto;

import com.edutecno.model.Categoria;
import com.edutecno.model.Producto;

public class ProductoCategoria {

	// objetos como atributos
	private Producto producto;
	private Categoria categoria;

	//constructor vacio
	public ProductoCategoria() {
	}

	// constructor con parametros
	public ProductoCategoria(Producto producto, Categoria categoria) {
		super();
		this.producto = producto;
		this.categoria = categoria;
	}
	
	//getters y setters
	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
