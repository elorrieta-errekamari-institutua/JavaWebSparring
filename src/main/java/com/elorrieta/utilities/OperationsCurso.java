/**
 * 
 */
package com.elorrieta.utilities;

import java.io.IOException;
import java.util.ArrayList;

import com.elorrieta.controller.commons.BackofficeController;
import com.elorrieta.modelo.dao.DAOCurso;
import com.elorrieta.modelo.pojo.Curso;
import com.elorrieta.modelo.pojo.Edicion;
import com.elorrieta.modelo.pojo.Horario;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Clase OperationsCurso
 * 
 * Contiene todos los metodos necesarios para que el controlador unico manipule
 * cursos
 */
public class OperationsCurso {

	/**
	 * Busca todos los cursos en la base de datos e introduce toda su informacion en
	 * la sesion para ser mostrada en una tabla. Redirige a la lista
	 * 
	 * @param request  HttpServletRequest
	 * @param response HttpServletResponse
	 * @param daoCurso DAOCurso
	 * @throws ServletException
	 * @throws IOException
	 */
	public static void selectAll(HttpServletRequest request, HttpServletResponse response, DAOCurso daoCurso)
			throws ServletException, IOException {

		ArrayList<Curso> listaCursosDB = null;
		try {
			listaCursosDB = daoCurso.getAll();
		} catch (Exception e) {
			System.err.println("Problemas recuperando cursos");
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		if (listaCursosDB != null) {

			ArrayList<ArrayList<String>> listaBody = new ArrayList<ArrayList<String>>();

			for (Curso curso : listaCursosDB) {
				listaBody.add(curso.setDataList());
			}

			session.setAttribute("title", "Cursos");
			session.setAttribute("clase", BackofficeController.CURSO);
			session.setAttribute("tableHeader", Curso.setHeadersList());
			session.setAttribute("tableBody", listaBody);
		}

		request.getRequestDispatcher("listado.jsp").forward(request, response);
	}

	/**
	 * Elimina el curso con el id elegido y redirige a la lista de cursos
	 * 
	 * @param request  HttpServletRequest
	 * @param response HttpServletResponse
	 * @param id       el id del curso que queremos eliminar
	 * @param daoCurso DAOCurso
	 */
	public static void delete(HttpServletRequest request, HttpServletResponse response, int id, DAOCurso daoCurso) {

		try {

			Curso cursoBorrado = daoCurso.delete(id);
			if (cursoBorrado != null) {
				request.getRequestDispatcher(
						"action?operacion=" + BackofficeController.SELECT_ALL + "&clase=" + BackofficeController.CURSO)
						.forward(request, response);
				System.out.println("Curso eliminado");
			} else {
				request.getRequestDispatcher("detalleCurso.jsp").forward(request, response);
				System.err.println("No se ha podido actualizar usuario");
			}
		}

		catch (Exception e) {
			System.err.println("Id vacio");
		}
	}

	/**
	 * Busca el curso con el id elegido, lo mete en sesion y redirige al formulario
	 * para editarlo o al formulario para crear una nueva edicion
	 * 
	 * @param request  HttpServletRequest
	 * @param response HttpServletResponse
	 * @param id       el id del curso que queremos buscar
	 * @param edicion  true si queremos crear una edicion de este curso, false si
	 *                 queremos editar el curso
	 * @param daoCurso DAOCurso
	 * @throws ServletException
	 * @throws IOException
	 */
	public static void select(HttpServletRequest request, HttpServletResponse response, int id, boolean edicion,
			DAOCurso daoCurso) throws ServletException, IOException {

		Curso curso = new Curso();
		try {
			curso = daoCurso.getByid(id);
		} catch (Exception e) {
			System.err.println("Error recuperando curso");
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		if (edicion) {
			Edicion edicionVacia = new Edicion();
			edicionVacia.setCurso(curso);
			Horario horarioVacio = new Horario();
			edicionVacia.setHorario(horarioVacio);
			session.setAttribute("edicion", e);
			request.getRequestDispatcher("detalleEdicion.jsp").forward(request, response);
		} else {
			session.setAttribute("curso", curso);
			request.getRequestDispatcher("detalleCurso.jsp").forward(request, response);
		}

	}

	/**
	 * Actualiza o inserta el curso con los parametros recogidos del request y
	 * redirige a la lista de cursos
	 * 
	 * @param request  HttpServletRequest
	 * @param response HttpServletResponse
	 * @param id       el id del curso que queremos actualizar, si se omite o es
	 *                 negativo se insertara
	 * @param daoCurso DAOCurso
	 */
	public static void insertUpdate(HttpServletRequest request, HttpServletResponse response, int id,
			DAOCurso daoCurso) {

		// Recoger parametros
		int horasCurso;
		String cualificacion = request.getParameter("cualificacion");
		String codigoUc = request.getParameter("codigoUc");
		String competencia = request.getParameter("competencia");
		String codigoAaff = request.getParameter("codigoAaff");
		String nombre = request.getParameter("nombre");
		try {
			horasCurso = Integer.parseInt(request.getParameter("horasCurso"));
			id = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			horasCurso = 0;
			id = -1;
		}

		// Guardar datos en POJO curso
		Curso curso = new Curso();
		curso.setId(id);
		curso.setCualificacion(cualificacion);
		curso.setCodigoUc(codigoUc);
		curso.setCompetencia(competencia);
		curso.setCodigoAaff(codigoAaff);
		curso.setNombre(nombre);
		curso.setHorasCurso(horasCurso);

		try {
			// Si existe actualizamos
			if (id > 0) {
				curso = daoCurso.update(curso);
			} else {
				// Si no existe lo insertamos y recogemos sus datos completos de la base de
				// datos
				curso = daoCurso.getByid(daoCurso.insert(curso));
			}

			if (curso.getId() > 0) {
				request.getRequestDispatcher(
						"action?operacion=" + BackofficeController.SELECT_ALL + "&clase=" + BackofficeController.CURSO)
						.forward(request, response);
				System.out.println("Curso actualizado");
			} else {
				request.getRequestDispatcher("detalleCurso.jsp").forward(request, response);
				System.err.println("No se ha podido actualizar el curso");
			}
		} catch (Exception e) {
			System.err.println("Error al actualizar curso");
			e.printStackTrace();
		}

	}

	/**
	 * Caracteristica sin implementar
	 * 
	 * @param request  HttpServletRequest
	 * @param response HttpServletResponse
	 * @param daoCurso DAOCurso
	 * @throws ServletException
	 * @throws IOException
	 */
	public static void insertAll(HttpServletRequest request, HttpServletResponse response, DAOCurso daoCurso)
			throws ServletException, IOException {
		throw new IOException("Caracteristica sin implementar");
	}

}
