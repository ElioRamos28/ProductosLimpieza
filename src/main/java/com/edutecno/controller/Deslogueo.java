package com.edutecno.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class Deslogueo extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		   // Se crea variable de sesion y se recibe desde el request	
		   HttpSession session = request.getSession();
		   PrintWriter out = response.getWriter();
		   //generacion de alerta que indica el cierre de sesion
		   out.println("<script type=\"text/javascript\">");
		   out.println("alert('A cerrado sesion correctamente');");
		   out.println("</script>");
		   //el metodo invalidate destruye la sesion
		   session.invalidate();
		   //el metodo sendRedirect redirije al formulario de ingreso
		   response.sendRedirect("index.jsp");
		   
		   Cookie[] cookies = request.getCookies();//obtenemos la cookie y se asigna a una variable o arreglo
		
			for(int i = 0; i < cookies.length; i++) {//ciclo para iterar la cookie
				
				System.out.println(cookies[i].getValue());
//				cookies[i].getValue();//se obtienen los valores mediante el indice
				System.out.println(cookies[i].getName());
//				cookies[i].getName();
			}
	}
}
