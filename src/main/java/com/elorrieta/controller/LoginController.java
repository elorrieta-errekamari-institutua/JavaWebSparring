package com.elorrieta.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.elorrieta.modelo.dao.DAOUsuario;
import com.elorrieta.modelo.pojo.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
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
		Usuario pojoUsuario = new Usuario();
		DAOUsuario usuarioDB = new DAOUsuario();

		String nombre = request.getParameter("nombre");
		String pass = request.getParameter("pass");
		pojoUsuario = usuarioDB.login(nombre, pass);
		if (pojoUsuario != null) {
			request.setAttribute("mensaje", pojoUsuario.getNombre() + " esta logeado");

			// guardar en session
			HttpSession session = request.getSession();
			session.setAttribute("usuarioLogeado", pojoUsuario);

			// logout
			// session.setAttribute("usuarioLogeado", null);
			// session.invalidate();

			request.getRequestDispatcher("index.jsp").forward(request, response);

		} else {
			request.setAttribute("nombre", nombre);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}

}
