package com.elorrieta.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elorrieta.modelo.dao.DAOUsuario;
import com.elorrieta.modelo.pojo.Usuario;

/**
 * Servlet implementation class RegistroController
 */
@WebServlet("/registro")
public class RegistroController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistroController() {
		super();

	}

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
		// Registra un usuario en la base de datos
		DAOUsuario usuarioDB = new DAOUsuario();
		Usuario usuario = new Usuario();
		usuario.setNombre(request.getParameter("nombre"));
		usuario.setPass(request.getParameter("pass"));
		usuario.setEmail(request.getParameter("email"));
		int id = usuarioDB.insert(usuario);
		if (id < 0) {
			request.setAttribute("mensaje", "Nombre de usuario o email repetido");
			request.setAttribute("registrado", false);

		} else {
			request.setAttribute("mensaje", "El " + usuario.getNombre() + " ha sido registrado");
			request.setAttribute("nombre", usuario.getNombre());
			request.setAttribute("registrado", true);
		}
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

}
