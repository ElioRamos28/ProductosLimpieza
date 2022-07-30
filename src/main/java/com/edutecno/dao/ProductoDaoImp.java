package com.edutecno.dao;

import java.util.ArrayList;
import java.util.List;

import com.edutecno.conexion.AdministradorConexion;
import com.edutecno.interfaces.ProductoDao;
import com.edutecno.model.Producto;
//hereda desde AdministradorConexion e implementa la interfaz ProductoDao
public class ProductoDaoImp extends AdministradorConexion implements ProductoDao {
	
	//en el constructor vacio se inicializa la conexion
	public ProductoDaoImp() {
		conn = generaPoolConexion();
	}
	
	//metodo para consultar a la base de datos por un Producto por su id
	@Override
	public Producto findById(int id) {
		
		Producto producto = new Producto();//instancia para armar el producto recibido de la consulta mediante ResultSet

		try {
			pstm = conn.prepareStatement("SELECT * FROM producto WHERE id_producto=?");
			//los indices para perarar la query comienzan desde 1
			pstm.setInt(1, id);//setear el id recibido como parametro de entrada en la query, mediante el prepareStatement()
			
			rs = pstm.executeQuery();//ejecutando la query previamente preparada
			
			if (rs.next()) {//si rs (ResultSet) tiene valores
//				id_producto int primary key,
//				nombre_producto varchar(75),
//				precio_producto int,
//				descripcion_producto varchar(200),
//				id_categoria int,
				producto.setId(rs.getInt("id_producto"));
				producto.setNombre(rs.getString("nombre_producto"));
				producto.setDescripcion(rs.getString("descripcion_producto"));
				producto.setPrecio(rs.getInt("precio_producto"));
				producto.setIdCategoria(rs.getInt("id_categoria"));
				
			}
			
			return producto;//retornando el producto
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//metodo para consultar y obtener todos los productos existentes en la base de datos
	@Override
	public List<Producto> findAll() {
		
		List<Producto> listaProductos = new ArrayList<Producto>();//lista para almacenar todos los productos consultados
		
		try {
			
			pstm = conn.prepareStatement("SELECT * FROM producto");//se prepara la query para la ejecucion con PreparedStatement
			rs = pstm.executeQuery(); //se ejecuta la query SELECT
			
			while (rs.next()) {//mientras rs (ResultSet) contenga datos, el cilo seguira creando objetos Producto
				Producto producto = new Producto();
				producto.setId(rs.getInt("id_producto"));
				producto.setNombre(rs.getString("nombre_producto"));
				producto.setDescripcion(rs.getString("descripcion_producto"));
				producto.setPrecio(rs.getInt("precio_producto"));
				producto.setIdCategoria(rs.getInt("id_categoria"));
				
				listaProductos.add(producto);//agregar el producto a la lista para que se retorne en el metodo
			}
			
			return listaProductos;//retorna la lista con todos los productos encontrados en la base de datos
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Producto>();//retorna una lista vacia si sucede un error
		}
	}

	@Override
	public Producto add(Producto producto) {
		
		try {
//			producto(id_producto,nombre_producto, precio_producto, descripcion_producto, id_categoria)
			pstm = conn.prepareStatement("INSERT INTO producto VALUES (PRODUCTO_SEC.NEXTVAL,?,?,?,?)");
			//MYSQL -> pstm = conn.prepareStatement("INSERT INTO producto VALUES (NULL,?,?,?,?)");
			
			//seteando los valores necesarios para cada signo de interrogacion y poder realizar la query
			//por orden de inserccion comienza por el indice 1, y se establecen los (?,?,?,?)
			pstm.setString(1,producto.getNombre());
			pstm.setInt(2,producto.getPrecio());
			pstm.setString(3, producto.getDescripcion());
			pstm.setInt(4, producto.getIdCategoria());
			
			if (pstm.executeUpdate() == 1) {
				//si se realizo la query de insertar un producto o guardar un registro, se retorna el producto guardado
				return producto;
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Producto();//se retorna un producto vacio si no se realizo la query
	}

	@Override
	public Producto update(Producto producto) {
		
		try {
			pstm = conn.prepareStatement(
		"UPDATE producto SET nombre_producto=?, precio_producto=?,descripcion_producto=?, id_categoria=? WHERE id_producto=?");
			
			pstm.setString(1, producto.getNombre());
			pstm.setInt(2, producto.getPrecio());
			pstm.setString(3, producto.getDescripcion());
			pstm.setInt(4, producto.getIdCategoria());
			pstm.setInt(5, producto.getId());
			
			if (pstm.executeUpdate() == 1) { //executeUpdate() INSERT, UPDATE or DELETE
				return producto;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new Producto();
	}

	@Override
	public boolean delete(int id) {

		try {
			pstm = conn.prepareStatement("DELETE FROM producto WHERE id_producto=?");
			pstm.setInt(1, id);
			
			if (pstm.executeUpdate() == 1) {
				return true;
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public int findLastId() {
		
		int maxId = -1;
		
		try {
			pstm = conn.prepareStatement("SELECT MAX(id_producto) AS max_id FROM producto");
			rs = pstm.executeQuery();
			
			if (rs.next()) {
				return maxId = rs.getInt("max_id");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return maxId;
	}
}
