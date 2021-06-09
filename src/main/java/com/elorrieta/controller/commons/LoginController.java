package com.elorrieta.controller.commons;

import java.io.IOException;

import com.elorrieta.modelo.dao.DAOUsuario;
import com.elorrieta.modelo.pojo.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
	 * Controlador de inicio de sesion
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String pass = request.getParameter("pass");
		String check = request.getParameter("keep");
		Usuario pojoUsuario = new Usuario();
		DAOUsuario usuarioDB;
		try {
			usuarioDB = new DAOUsuario();
			pojoUsuario = usuarioDB.login(nombre, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (pojoUsuario != null) {
			request.setAttribute("mensaje", pojoUsuario.getNombre() + " esta logeado");

			// guardar en session
			HttpSession session = request.getSession();

			if ("on".equalsIgnoreCase(check)) {
				session.setMaxInactiveInterval(0);
			}
			session.setAttribute("usuarioLogeado", pojoUsuario);

			request.getRequestDispatcher("index.jsp").forward(request, response);

		} else {
			request.setAttribute("nombre", nombre);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}

}
