package com.elorrieta.controller.commons;

import java.io.IOException;
import java.util.Set;

import com.elorrieta.modelo.dao.DAOUsuario;
import com.elorrieta.modelo.pojo.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

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
		Usuario usuario = new Usuario();
		usuario.setNombre(request.getParameter("nombre"));
		usuario.setPass(request.getParameter("pass"));
		usuario.setEmail(request.getParameter("email"));
		String pass2 = request.getParameter("pass2");

		// validar que los datos sean correctos

		Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);

		if (violations.isEmpty() && pass2.equals(usuario.getPass())) {
			System.out.println("Todo OK");
			int id = -1;
			try {
				DAOUsuario usuarioDB = new DAOUsuario();
				id = usuarioDB.insert(usuario);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
			request.setAttribute("nombre", usuario.getNombre());
			request.setAttribute("email", usuario.getEmail());
		}

		request.getRequestDispatcher("registro.jsp").forward(request, response);
	}

}
