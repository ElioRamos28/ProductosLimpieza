package com.edutecno.dao;

import java.util.ArrayList;
import java.util.List;

import com.edutecno.conexion.AdministradorConexion;
import com.edutecno.dto.ProductoCategoria;
import com.edutecno.interfaces.CategoriaDao;
import com.edutecno.interfaces.ProductoCategoriaDao;
import com.edutecno.interfaces.ProductoDao;
import com.edutecno.model.Categoria;
import com.edutecno.model.Producto;

public class ProductoCategoriaDaoImp extends AdministradorConexion implements ProductoCategoriaDao {
	
	public ProductoCategoriaDaoImp() {
		conn = generaPoolConexion();
	}
	
	@Override //SELECT * FROM PRODUCTO PRO INNER JOIN CATEGORIA CAT ON CAT.ID_CATEGORIA = PRO.ID_CATEGORIA
	public List<ProductoCategoria> findAll() {
		
		ProductoDao productoDao = new ProductoDaoImp();
		CategoriaDao categoriaDao = new CategoriaDaoImp();
		
		List<ProductoCategoria> listaProductoCategoria = new ArrayList<ProductoCategoria>();
		
		for (Producto productoTemp : productoDao.findAll()) {
			
			ProductoCategoria productoCategoria = new ProductoCategoria();//objeto ProductoCagoria que se agregara a la lista
			
			//buscando la categoria del objeto temporal encontrado mediante el metodo findAll() que retorna una lista de Producto
			Categoria categoria = categoriaDao.findById(productoTemp.getIdCategoria()); //mediante el id del productoTemp, se busca la categoria
			
			productoCategoria.setProducto(productoTemp);//se setea el producto en productoCategoria
			productoCategoria.setCategoria(categoria);
			
			listaProductoCategoria.add(productoCategoria);
		}
		
//		try {
//			pstm = conn.prepareStatement("SELECT * FROM PRODUCTO PRO INNER JOIN CATEGORIA CAT ON CAT.ID_CATEGORIA = PRO.ID_CATEGORIA");
//			rs = pstm.executeQuery();
//			
//			while (rs.next()) {
//				ProductoCategoria productoCategoria = new ProductoCategoria();//productoCategoria para agregarlo a la lista
//				Producto producto = new Producto();//producto para agregarlo a productoCategoria
//				Categoria categoria = new Categoria();//categoria para agregarla a productoCategoria
//				
////				productoCategoria.getProducto().setId(rs.getInt("id_producto"));
//				
//				producto.setId(rs.getInt("id_producto"));
//				producto.setNombre(rs.getString("nombre_producto"));
//				producto.setPrecio(rs.getInt("precio_producto"));
//				producto.setDescripcion(rs.getString("descripcion_producto"));
//				producto.setIdCategoria(rs.getInt("id_categoria"));
//				
//				categoria.setId(rs.getInt("id_categoria_1"));
//				categoria.setNombre(rs.getString("nombre_categoria"));
//				
//				productoCategoria.setProducto(producto);
//				productoCategoria.setCategoria(categoria);
//				
//				listaProductoCategoria.add(productoCategoria);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return listaProductoCategoria;
	}
}
