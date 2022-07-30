package com.edutecno.interfaces;

import java.util.List;

import com.edutecno.model.Producto;
//funcionamiento como repositorio para Producto
public interface ProductoDao {
	
	public Producto findById(int id);// buscarProducto(int id)
	public List<Producto> findAll();//listarProductos()
	public Producto add(Producto producto);//agregarProducto(Producto producto)
	public Producto update(Producto producto);//modificarProducto(Producto producto)
	public boolean delete(int id);//eliminarProducto(ind id)
	public int findLastId();//obtenerUltimoid()

}
