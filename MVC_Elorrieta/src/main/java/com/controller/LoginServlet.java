package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.modelo.CRUD;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");

		CRUD conn = new CRUD();
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conn.connect();

		if (nombre.isEmpty())
			throw new IOException("El nombre esta vacio");
		if (password.isEmpty())
			throw new IOException("El password esta vacio");

		// TODO login contra bbdd

		if ("admin".equalsIgnoreCase(nombre)) {

			request.setAttribute("mensaje", "Bienvenido");
			request.getRequestDispatcher("backoffice.jsp").forward(request, response);

		} else {

			request.setAttribute("mensaje", "Datos incorrectos");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

	}

}
