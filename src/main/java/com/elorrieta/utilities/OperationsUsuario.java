package com.elorrieta.utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.elorrieta.controller.commons.BackofficeController;
import com.elorrieta.modelo.dao.DAOUsuario;
import com.elorrieta.modelo.pojo.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class OperationsUsuario {
	static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	static Validator validator = factory.getValidator();

	public static void selectAll(HttpServletRequest request, HttpServletResponse response, DAOUsuario daoUsuario)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Usuario> listaUsuariosDB = null;
		try {
			listaUsuariosDB = daoUsuario.getAll();
		} catch (Exception e) {
			System.err.println("Problemas recuperando usuarios");
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		if (listaUsuariosDB != null) {
			ArrayList<ArrayList<String>> listaBody = new ArrayList<ArrayList<String>>();
			for (Usuario usuario : listaUsuariosDB) {
				listaBody.add(usuario.setDataList());
			}
			session.setAttribute("title", "Usuarios");
			session.setAttribute("clase", BackofficeController.USUARIO);
			session.setAttribute("tableHeader", Usuario.setHeadersList());
			session.setAttribute("tableBody", listaBody);
		}

		request.getRequestDispatcher("listado.jsp").forward(request, response);
	}

	public static void delete(HttpServletRequest request, HttpServletResponse response, int id, DAOUsuario daoUsuario) {

		try {

			Usuario usuarioBorrado = daoUsuario.delete(id);
			if (usuarioBorrado != null) {
				request
						.getRequestDispatcher(
								"action?operacion=" + BackofficeController.SELECT_ALL + "&clase=" + BackofficeController.USUARIO)
						.forward(request, response);
				System.out.println("Usuario eliminado");
			} else {
				request.getRequestDispatcher("detalleUsuario.jsp").forward(request, response);
				System.err.println("No se ha podido actualizar usuario");
			}
		}

		catch (Exception e) {
			System.err.println("Id vacio");
		}
	}

	public static void select(HttpServletRequest request, HttpServletResponse response, int id, DAOUsuario daoUsuario)
			throws ServletException, IOException {
		Usuario usuario = new Usuario();
		try {
			usuario = daoUsuario.getByid(id);
		} catch (Exception e) {
			System.err.println("Error recuperando usuario");
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		session.setAttribute("usuario", usuario);

		request.getRequestDispatcher("detalleUsuario.jsp").forward(request, response);

	}

	public static void insertUpdate(HttpServletRequest request, HttpServletResponse response, int id,
			DAOUsuario daoUsuario) throws ServletException, IOException {

		Usuario usuario = new Usuario();
		usuario.setNombre(request.getParameter("nombre"));
		usuario.setPass(request.getParameter("pass"));
		usuario.setEmail(request.getParameter("email"));

		// validar que los datos sean correctos

		Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);

		if (violations.isEmpty()) {
			System.out.println("Todo OK");
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
