package com.edutecno.service;

import java.util.List;

import com.edutecno.dao.CategoriaDaoImp;
import com.edutecno.dao.ProductoCategoriaDaoImp;
import com.edutecno.dao.ProductoDaoImp;
import com.edutecno.dto.ProductoCategoria;
import com.edutecno.interfaces.CategoriaDao;
import com.edutecno.interfaces.ProductoCategoriaDao;
import com.edutecno.interfaces.ProductoDao;
import com.edutecno.model.Categoria;
import com.edutecno.model.Producto;

public class Facade {
	
	//instancias para acceder a los metodos que existen en los data access object
	private ProductoDao productoDao = new ProductoDaoImp();
	private CategoriaDao categoriaDao = new CategoriaDaoImp();
	private ProductoCategoriaDao productoCategoriaDao = new ProductoCategoriaDaoImp();
	
	//-----------METODOS PARA PRODUCTO------------
	
	//metodo encargado de buscar el id accediendo al ProductoDao, accesador a la base de datos
	public Producto findProductoById(int id){
		return productoDao.findById(id);
	}
	//metodo encargado de listar los productos accediendo al ProductoDao, accesador a la base de datos
	public List<Producto> findAllProducto(){
		return productoDao.findAll();
	}
	//metodo encargado de añadir un producto accediendo al ProductoDao, accesador a la base de datos
	public Producto addProducto(Producto producto) {
		return productoDao.add(producto);
	}
	//metodo encargado de actualizar un producto accediendo al ProductoDao, accesador a la base de datos
	public Producto updateProducto(Producto producto) {
		return productoDao.update(producto);
	}
	//metodo encargado de eliminar un producto accediendo al ProductoDao, accesador a la base de datos
	public boolean deleteProducto(int id) {
		return productoDao.delete(id);
	}
	//metodo encargado de buscar el último id del producto accediendo al ProductoDao, accesador a la base de datos
	public int findLastIdProducto() {
		return productoDao.findLastId();
	}
	
	//-----------METODOS PARA CATEGORIA------------
	//metodo encargado de buscar una categoria por id, accediendo a CategoriaDao
	public Categoria findCategoriaById(int id) {
		return categoriaDao.findById(id);
	}
	//metodo encargado de buscar todas las categorias, accediendo a CategoriaDao
	public List<Categoria> findAllCategoria(){
		return categoriaDao.findAll();
	}
	
	//-----------METODOS PARA PRODUCTOCATEGORIA------------
	//metodo encargado de listar Productos con sus categorias
	public List<ProductoCategoria>  findAllProductoCategoria(){
		return productoCategoriaDao.findAll();
	}
}