package com.elorrieta.utilities;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalTime;
import java.util.ArrayList;

import com.elorrieta.controller.commons.BackofficeController;
import com.elorrieta.modelo.dao.DAOAula;
import com.elorrieta.modelo.dao.DAOCurso;
import com.elorrieta.modelo.dao.DAOEdicion;
import com.elorrieta.modelo.dao.DAOHorario;
import com.elorrieta.modelo.pojo.Aula;
import com.elorrieta.modelo.pojo.Curso;
import com.elorrieta.modelo.pojo.Edicion;
import com.elorrieta.modelo.pojo.Horario;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Clase OperationsEdicion
 * 
 * Contiene todos los metodos necesarios para que el controlador unico manipule ediciones
 */
public class OperationsEdicion {

	/**
	 * Actualiza o inserta la edicion con los parametros recogidos del request y
	 * redirige a la lista de ediciones
	 * 
	 * @param request    HttpServletRequest
	 * @param response   HttpServletResponse
	 * @param daoEdicion DAOEdicion
	 * @param daoCurso   DAOCurso
	 * @param daoHorario DAOHorario
	 * @param daoAula    DAOAula
	 */
	public static void insertUpdate(HttpServletRequest request, HttpServletResponse response, DAOEdicion daoEdicion,
			DAOCurso daoCurso, DAOHorario daoHorario, DAOAula daoAula) {

		// Recoger parametros
		int idEdicion = -1;
		int idHorario = -1;
		int idCurso = -1;
		String codigoLanbide = request.getParameter("codigoLanbide");
		Date fechaInicio = Date.valueOf(request.getParameter("fechaInicio"));
		Date fechaFin = Date.valueOf(request.getParameter("fechaFin"));
		LocalTime lunesInicio = LocalTime.parse(request.getParameter("lunesInicio"));
		LocalTime lunesFin = LocalTime.parse(request.getParameter("lunesFin"));
		LocalTime martesInicio = LocalTime.parse(request.getParameter("martesInicio"));
		LocalTime martesFin = LocalTime.parse(request.getParameter("martesFin"));
		LocalTime miercolesInicio = LocalTime.parse(request.getParameter("miercolesInicio"));
		LocalTime miercolesFin = LocalTime.parse(request.getParameter("miercolesFin"));
		LocalTime juevesInicio = LocalTime.parse(request.getParameter("juevesInicio"));
		LocalTime juevesFin = LocalTime.parse(request.getParameter("juevesFin"));
		LocalTime viernesInicio = LocalTime.parse(request.getParameter("viernesInicio"));
		LocalTime viernesFin = LocalTime.parse(request.getParameter("viernesFin"));
		int idAula0 = -1;
		String nombreAula0 = request.getParameter("aula0dummy");
		int idAula1 = -1;
		String nombreAula1 = request.getParameter("aula1dummy");
		int idAula2 = -1;
		String nombreAula2 = request.getParameter("aula2dummy");
		int idAula3 = -1;
		String nombreAula3 = request.getParameter("aula3dummy");
		int idAula4 = -1;
		String nombreAula4 = request.getParameter("aula4dummy");
		try {
			idEdicion = Integer.parseInt(request.getParameter("idEdicion"));
			idHorario = Integer.parseInt(request.getParameter("idHorario"));
		} catch (Exception e) {
		}
		try {
			idCurso = Integer.parseInt(request.getParameter("idCurso"));
		} catch (Exception e) {
		}
		try {
			if (!nombreAula0.isBlank()) {
				idAula0 = Integer.parseInt(request.getParameter("aula0"));
			}
			if (!nombreAula1.isBlank()) {
				idAula1 = Integer.parseInt(request.getParameter("aula1"));
			}
			if (!nombreAula2.isBlank()) {
				idAula2 = Integer.parseInt(request.getParameter("aula2"));
			}
			if (!nombreAula3.isBlank()) {
				idAula3 = Integer.parseInt(request.getParameter("aula3"));
			}
			if (!nombreAula4.isBlank()) {
				idAula4 = Integer.parseInt(request.getParameter("aula4"));
			}
		} catch (Exception e) {
		}

		// Guardar datos en POJOs
		Horario horario = new Horario();
		horario.setId(idHorario);
		horario.setLunesInicio(lunesInicio);
		horario.setLunesFin(lunesFin);
		horario.setMartesInicio(martesInicio);
		horario.setMartesFin(martesFin);
		horario.setMiercolesInicio(miercolesInicio);
		horario.setMiercolesFin(miercolesFin);
		horario.setJuevesInicio(juevesInicio);
		horario.setJuevesFin(juevesFin);
		horario.setViernesInicio(viernesInicio);
		horario.setViernesFin(viernesFin);

		ArrayList<Aula> listaAulas = new ArrayList<Aula>();
		Aula aula0;
		if (idAula0 > 0) {
			aula0 = new Aula();
			aula0.setId(idAula0);
			aula0.setNombre(nombreAula0);
			listaAulas.add(aula0);
		}
		Aula aula1;
		if (idAula1 > 0) {
			aula1 = new Aula();
			aula1.setId(idAula1);
			aula1.setNombre(nombreAula1);
			listaAulas.add(aula1);
		}
		Aula aula2;
		if (idAula2 > 0) {
			aula2 = new Aula();
			aula2.setId(idAula2);
			aula2.setNombre(nombreAula2);
			listaAulas.add(aula2);
		}
		Aula aula3;
		if (idAula3 > 0) {
			aula3 = new Aula();
			aula3.setId(idAula3);
			aula3.setNombre(nombreAula3);
			listaAulas.add(aula3);
		}
		Aula aula4;
		if (idAula4 > 0) {
			aula4 = new Aula();
			aula4.setId(idAula4);
			aula4.setNombre(nombreAula4);
			listaAulas.add(aula4);
		}

		// El curso solo endra el id para el foreng key pero no modificaremos sus datos
		Curso curso = new Curso();
		curso.setId(idCurso);

		Edicion edicion = new Edicion();
		edicion.setId(idEdicion);
		edicion.setCodigoLanbide(codigoLanbide);
		edicion.setFechaInicio(fechaInicio);
		edicion.setFechaFin(fechaFin);
		edicion.setHorario(horario);
		edicion.setCurso(curso);
		edicion.setAulas(listaAulas);

		try {
			// Si existe actualizamos
			if (idEdicion > 0) {
				edicion = daoEdicion.update(edicion, daoHorario);
			} else {
				// Si no existe la insertamos y recogemos sus datos completos de la base de
				// datos
				edicion = daoEdicion.getByid(daoEdicion.insert(edicion, daoCurso, daoHorario, daoAula));
			}
			if (edicion.getId() > 0) {
				request.getRequestDispatcher("action?operacion=" + BackofficeController.SELECT_ALL + "&clase="
						+ BackofficeController.EDICION).forward(request, response);
				System.out.println("Curso actualizado");
			} else {
				request.getRequestDispatcher("detalleEdicion.jsp").forward(request, response);
				System.err.println("No se ha podido actualizar el curso");
			}
		} catch (Exception e) {
			System.err.println("Error al actualizar la edicion");
			e.printStackTrace();
		}

	}

	/**
	 * Inserta en la base de datos todas las ediciones que se encuentren en el
	 * atributo lista de la sesion, escribe en sesion el numero de ediciones que se
	 * han insertado y redirige a la pagina de subir documentos
	 * 
	 * @param request    HttpServletRequest
	 * @param response   HttpServletResponse
	 * @param daoEdicion DAOEdicion
	 * @param daoCurso   DAOCurso
	 * @param daoHorario DAOHorario
	 * @param daoAula    DAOAula
	 * @throws ServletException
	 * @throws IOException
	 */
	public static void insertAll(HttpServletRequest request, HttpServletResponse response, DAOEdicion daoEdicion,
			DAOCurso daoCurso, DAOHorario daoHorario, DAOAula daoAula) throws ServletException, IOException {

		HttpSession sesion = request.getSession();

		@SuppressWarnings("unchecked")
		ArrayList<Edicion> listaEdiciones = (ArrayList<Edicion>) sesion.getAttribute("lista");
		// Insertar datos en la BD
		int edicionesInsertadas = listaEdiciones.size();
		for (Edicion edicion : listaEdiciones) {
			int idEdicion = -1;

			try {
				if (!edicion.isGuardado()) {

					idEdicion = daoEdicion.insert(edicion, daoCurso, daoHorario, daoAula);

					if (idEdicion > 0) {
						System.out.println("Insertada edicion");
					} else {
						System.err.println("No se ha podido insertar la edicion");
					}

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (idEdicion < 0) {
				System.out.println("La edicion ya existe");
				edicionesInsertadas--;
			}
		}
		request.setAttribute("insertados", edicionesInsertadas);
		request.getRequestDispatcher("fileUpload.jsp").forward(request, response);

	}

	/**
	 * Elimina la edicion con el id elegido y redirige a la lista de ediciones
	 * 
	 * @param request    HttpServletRequest
	 * @param response   HttpServletResponse
	 * @param id         el id del aula que queremos eliminar
	 * @param daoEdicion DAOEdicion
	 * @param daoHorario DAOHorario
	 */
	public static void delete(HttpServletRequest request, HttpServletResponse response, int id, DAOEdicion daoEdicion,
			DAOHorario daoHorario) {

		try {

			Edicion edicionBorrada = daoEdicion.delete(id, daoHorario);
			if (edicionBorrada != null) {
				request.getRequestDispatcher("action?operacion=" + BackofficeController.SELECT_ALL + "&clase="
						+ BackofficeController.EDICION).forward(request, response);
				System.out.println("Edicion eliminada");
			} else {
				request.getRequestDispatcher("detalleEdicion.jsp").forward(request, response);
				System.err.println("No se ha podido actualizar usuario");
			}
		}

		catch (Exception e) {
			System.err.println("Id vacio");
		}

	}

	/**
	 * Busca la edicion con el id elegido, la mete en sesion y redirige al
	 * formulario para editarla
	 * 
	 * @param request    HttpServletRequest
	 * @param response   HttpServletResponse
	 * @param id         el id del aula que queremos buscar
	 * @param daoEdicion DAOEdicion
	 * @throws ServletException
	 * @throws IOException
	 */
	public static void select(HttpServletRequest request, HttpServletResponse response, int id, DAOEdicion daoEdicion)
			throws ServletException, IOException {

		Edicion edicion = new Edicion();
		ArrayList<Aula> aulas = new ArrayList<Aula>();
		try {
			edicion = daoEdicion.getByid(id);
		} catch (Exception e) {
			System.err.println("Error recuperando edicion");
			e.printStackTrace();
		}

		HttpSession session = request.getSession();
		session.setAttribute("edicion", edicion);
		aulas = edicion.getAulas();
		for (int i = 0; i < aulas.size(); i++) {
			request.setAttribute("aula" + i, aulas.get(i));
		}

		request.getRequestDispatcher("detalleEdicion.jsp").forward(request, response);
	}

	/**
	 * Busca todas las ediciones en la base de datos e introduce toda su informacion
	 * en la sesion para ser mostrada en una tabla. Redirige a la lista
	 * 
	 * @param request    HttpServletRequest
	 * @param response   HttpServletResponse
	 * @param daoEdicion DAOEdicion
	 * @throws ServletException
	 * @throws IOException
	 */
	public static void selectAll(HttpServletRequest request, HttpServletResponse response, DAOEdicion daoEdicion)
			throws ServletException, IOException {

		ArrayList<Edicion> listaEdicionesDB = null;
		try {
			listaEdicionesDB = daoEdicion.getAll();
		} catch (Exception e) {
			System.err.println("Problemas recuperando ediciones");
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		if (listaEdicionesDB != null) {

			ArrayList<ArrayList<String>> listaBody = new ArrayList<ArrayList<String>>();

			for (Edicion edicion : listaEdicionesDB) {
				listaBody.add(edicion.setDataList());
			}

			session.setAttribute("title", "Ediciones");
			session.setAttribute("clase", BackofficeController.EDICION);
			session.setAttribute("tableHeader", Edicion.setHeadersList());
			session.setAttribute("tableBody", listaBody);
		}

		request.getRequestDispatcher("listado.jsp").forward(request, response);
	}

}
