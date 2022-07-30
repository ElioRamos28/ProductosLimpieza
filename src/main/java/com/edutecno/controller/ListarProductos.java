package com.edutecno.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edutecno.dto.ProductoCategoria;
import com.edutecno.service.Facade;

/**
 * Servlet implementation class ListarProductos
 * responsabilidad de consultar por los productos y sus categorias
 */
@WebServlet("/listarProductos")//ruta para acceder al servlet
public class ListarProductos extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//mediante la instancia del Facade se acceden a los metodos para consultar por los Productos y sus Categorias
		Facade facade = new Facade();
		
		List<ProductoCategoria> listaProductoCategoria= facade.findAllProductoCategoria();
		
		request.setAttribute("productos", listaProductoCategoria);
		
		request.getRequestDispatcher("listarProductos.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
