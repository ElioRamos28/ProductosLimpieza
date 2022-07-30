package com.edutecno.interfaces;

import java.util.List;

import com.edutecno.model.Categoria;

//funcinamiento como repositorio de Categoria
public interface CategoriaDao {

	public Categoria findById(int id);//buscarCategoria(int id)
	public List<Categoria> findAll();//listarCategorias()
}
