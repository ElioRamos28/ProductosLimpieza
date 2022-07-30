package com.edutecno.interfaces;

import java.util.List;

import com.edutecno.dto.ProductoCategoria;

//repositorio para ProductoCategoria
public interface ProductoCategoriaDao {
	
	public List<ProductoCategoria> findAll();//listarProductoCategoria()
}
