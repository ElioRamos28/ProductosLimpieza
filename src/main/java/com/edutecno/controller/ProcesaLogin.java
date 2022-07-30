package com.edutecno.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/procesaLogin")
public class ProcesaLogin extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private final String LOGIN = "usuario";
	private final String PASS = "admin";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String requestLogin = "";
		String requestPass = "";

		PrintWriter out = response.getWriter();

		requestLogin = request.getParameter("login");
		requestPass = request.getParameter("pass");

		if (!LOGIN.contentEquals(requestLogin) || !PASS.contentEquals(requestPass)) {// si los datos ingresados no son
																						// iguales
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Usuario o password incorrecto');");
			out.println("location='index.jsp';");
			out.println("</script>");
//			   request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {// si los datos son correctos
				// creamos la sesion si el usuario existe
			HttpSession sesionUsuario = request.getSession(true);
			sesionUsuario.setAttribute("requestLogin", requestLogin);

			// (nombre,valor)
			Cookie cookie = new Cookie(requestLogin, "2022");// instancia mediante el constructor

			cookie.setMaxAge(8000);// seteando el tiempo de vida de la cookie
			cookie.setComment("Cookie Genera Factura");// seteando comentarios de la cookie, about
			cookie.setDomain("www.fullstackjava.com");// dominio o sitio que representa a la cookie
			cookie.setHttpOnly(true);// método de comunicación

			response.addCookie(cookie); // añadiendo la cookie a la respuesta

			request.getRequestDispatcher("listarProductos").forward(request, response);
		}
	}
}
