package com.elorrieta.utilities;

import java.io.IOException;
import java.util.ArrayList;

import com.elorrieta.controller.commons.BackofficeController;
import com.elorrieta.modelo.dao.DAOAula;
import com.elorrieta.modelo.pojo.Aula;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class OperationsAula {

	/**
	 * Actualiza o inserta el aula con los parametros recogidos del request y
	 * redirige a la lista de aulas
	 * 
	 * @param request  HttpServletRequest
	 * @param response HttpServletResponse
	 * @param id       el id del aula que queremos actualizar, si se omite o es
	 *                 negativo se insertara
	 * @param daoAula  DAOAula
	 */
	public static void insertUpdate(HttpServletRequest request, HttpServletResponse response, int id, DAOAula daoAula) {

		// Recoger parametros
		String nombre = request.getParameter("nombre");
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			id = -1;
		}

		// Guardar datos en POJO
		Aula aula = new Aula();
		aula.setId(id);
		aula.setNombre(nombre);

		try {
			// Si existe actualizamos
			if (id > 0) {
				aula = daoAula.update(aula);
			} else {
				// Si no existe la insertamos y recogemos sus datos completos de la base de
				// datos
				aula = daoAula.getByid(daoAula.insert(aula));
			}
			if (aula.getId() > 0) {
				request.getRequestDispatcher(
						"action?operacion=" + BackofficeController.SELECT_ALL + "&clase=" + BackofficeController.AULA)
						.forward(request, response);
				System.out.println("Aula actualizada");
			} else {
				request.getRequestDispatcher("detalleAula.jsp").forward(request, response);
				System.err.println("No se ha podido actualizar aula");
			}
		} catch (Exception e) {
			System.err.println("Error al actualizar aula");
			e.printStackTrace();
		}

	}

	/**
	 * Caracteristica sin implementar
	 */
	public static void insertAll(HttpServletRequest request, HttpServletResponse response, DAOAula daoAula)
			throws IOException {
		throw new IOException("Caracteristica sin implementar");
	}

	/**
	 * Elimina el aula con el id elegido y redirige a la lista de aulas
	 * 
	 * @param request  HttpServletRequest
	 * @param response HttpServletResponse
	 * @param id       el id del aula que queremos eliminar
	 * @param daoAula  DAOAula
	 */
	public static void delete(HttpServletRequest request, HttpServletResponse response, int id, DAOAula daoAula) {

		try {

			Aula aulaBorrada = daoAula.delete(id);

			if (aulaBorrada != null) {
				request.getRequestDispatcher(
						"action?operacion=" + BackofficeController.SELECT_ALL + "&clase=" + BackofficeController.AULA)
						.forward(request, response);
				System.out.println("Aula eliminado");
			} else {
				request.getRequestDispatcher("detalleAula.jsp").forward(request, response);
				System.err.println("No se ha podido actualizar aula");
			}
		}

		catch (Exception e) {
			System.err.println("Id vacio");
		}

	}

	/**
	 * Busca el aula con el id elegido, la mete en sesion y redirige al formulario
	 * para editarla
	 * 
	 * @param request  HttpServletRequest
	 * @param response HttpServletResponse
	 * @param id       el id del aula que queremos buscar
	 * @param daoAula  DAOAula
	 * @throws ServletException
	 * @throws IOException
	 */
	public static void select(HttpServletRequest request, HttpServletResponse response, int id, DAOAula daoAula)
			throws ServletException, IOException {

		Aula aula = new Aula();
		try {
			aula = daoAula.getByid(id);
		} catch (Exception e) {
			System.err.println("Error recuperando aula");
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		session.setAttribute("aula", aula);

		request.getRequestDispatcher("detalleAula.jsp").forward(request, response);

	}

	/**
	 * Busca todas las aulas en la base de datos e introduce toda su informacion en
	 * la sesion para ser mostrada en una tabla. Redirige a la lista
	 * 
	 * @param request  HttpServletRequest
	 * @param response HttpServletResponse
	 * @param daoAula  DAOAula
	 * @throws ServletException
	 * @throws IOException
	 */
	public static void selectAll(HttpServletRequest request, HttpServletResponse response, DAOAula daoAula)
			throws ServletException, IOException {

		ArrayList<Aula> listaAulasDB = null;

		try {
			listaAulasDB = daoAula.getAll();
		} catch (Exception e) {
			System.err.println("Problemas recuperando participantes");
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		if (listaAulasDB != null) {

			ArrayList<ArrayList<String>> listaBody = new ArrayList<ArrayList<String>>();

			for (Aula aula : listaAulasDB) {
				listaBody.add(aula.setDataList());
			}
			session.setAttribute("title", "Aulas");
			session.setAttribute("clase", BackofficeController.AULA);
			session.setAttribute("tableHeader", Aula.setHeadersList());
			session.setAttribute("tableBody", listaBody);
		}

		request.getRequestDispatcher("listado.jsp").forward(request, response);

	}

}
