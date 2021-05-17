package com.elorrieta.controller.commons;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.elorrieta.modelo.dao.DAOUsuario;
import com.elorrieta.modelo.pojo.Usuario;

/**
 * Servlet implementation class RegistroController
 */
@WebServlet("/registro")
public class RegistroController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	Validator validator = factory.getValidator();

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

		// validar que los datos sean correctos

		Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);

		if (violations.isEmpty()) {
			System.out.println("Todo OK");
			int id = usuarioDB.insert(usuario);
			if (id < 0) {
				request.setAttribute("errores", "Nombre o email de usuario ya registrado");

			} else {
				request.setAttribute("mensaje", "El " + usuario.getNombre() + " ha sido registrado");
				request.setAttribute("nombre", usuario.getNombre());
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		} else {
			System.out.println("Errores en los datos enviados");
			for (ConstraintViolation<Usuario> constraintViolation : violations) {
				request.setAttribute("error_" + constraintViolation.getPropertyPath().toString(),
						constraintViolation.getMessage());
			}
		}

		request.getRequestDispatcher("registro.jsp").forward(request, response);
	}

}
