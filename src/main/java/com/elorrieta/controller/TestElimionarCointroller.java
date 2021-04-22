package com.elorrieta.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elorrieta.modelo.dao.DAOUsuario;
import com.elorrieta.modelo.pojo.POJOUsuario;

/**
 * Servlet implementation class TestElimionarCointroller
 */
@WebServlet("/login")
public class TestElimionarCointroller extends HttpServlet {
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
		String nombre2 = "";
		POJOUsuario pojoUsuario = new POJOUsuario();
		DAOUsuario usuarioDB = new DAOUsuario();
		try {

			pojoUsuario = usuarioDB.getByid(1);
			nombre2 = pojoUsuario.getNombre();

		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String nombre = request.getParameter("nombre");
		String pass = request.getParameter("pass");
		pojoUsuario = usuarioDB.login(nombre, pass);
		if (pojoUsuario.getId() >= 0) {
			request.setAttribute("mensaje", pojoUsuario.getNombre() + " esta logeado");
			request.getRequestDispatcher("index.jsp").forward(request, response);

		} else {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

		request.setAttribute("nombre", nombre + " ha pasado pore el servlet y " + nombre2 + " de la DB");

	}

}
