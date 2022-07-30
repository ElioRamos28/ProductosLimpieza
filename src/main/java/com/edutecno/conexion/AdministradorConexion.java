package com.edutecno.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

//clase para administrar la conexion y realizar conexion a la BD con sus metodos
public class AdministradorConexion {

	protected static Connection conn;// variable para la conexión utilizada en los DAO data access object
	protected PreparedStatement pstm = null; // variable para preparar las query antes de ejecutarlas
	protected ResultSet rs = null;// variable para la obtención del resultado o ingreso de valores

	// metodo para conectarse a la base de datos sin SINGLETON
	protected Connection generaConexion() {

		if (conn == null) {

			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "USUARIO", "admin");
				System.out.println("conexion establecida");
			} catch (Exception e) {
				e.printStackTrace();// impresion traza del error
			}
		} else {
			System.out.println("conexion existente");
			return conn;
		}
		return conn;
	}

	// metodo que genera la conexion mediante un singleton, valida que la instancia
	// de Connection exista o genera una nueva
	protected Connection generaPoolConexion() {

		Context initContext; // el contexto es para establecer en que parte se encuentra el DataSource (datos
								// de la base de datos)

		if (conn == null) {// si la conexion es igual a null, no existe una instancia de conexion se genera
							// una nueva

			try {// se intenta la ejecucion y se controlan los errores con el try catch{}
				initContext = new InitialContext();// instanciar un nuevo initialContext
				// especificando en que ruta se encuentra el recurso de conexión
				DataSource ds = (DataSource) initContext.lookup("java:/comp/env/jdbc/ConexionOracle");

				conn = ds.getConnection();// obteniendo la conexion
				System.out.println("Conexión generada con singleton");
			} catch (Exception e) {
				e.printStackTrace();// impresion de la traza de error
			}
		} else {
			System.out.println("Hay una conexion, utilizando el singleton");
			return conn;
		}
		return conn;
	}
}
