/**
 * 
 */
package com.elorrieta.utilities;

import java.io.IOException;
import java.util.ArrayList;

import com.elorrieta.modelo.dao.DAOCurso;
import com.elorrieta.modelo.pojo.Curso;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * @author cursos_externos
 *
 */
public class OperationsCurso {

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
			ArrayList<String> listaHead = new ArrayList<String>();
			listaHead.add("#");
			listaHead.add("Nombre");
			listaHead.add("Horas");
			listaHead.add("Codigo AAFF");
			listaHead.add("Codigo UC");
			listaHead.add("Competencia");
			listaHead.add("Cualificacion");

			ArrayList<ArrayList<String>> listaBody = new ArrayList<ArrayList<String>>();
			for (Curso curso : listaCursosDB) {
				ArrayList<String> listaTemporal = new ArrayList<String>();
				listaTemporal.add(String.valueOf(curso.getId()));
				listaTemporal.add(curso.getNombre());
				listaTemporal.add(String.valueOf(curso.getHorasCurso()));
				listaTemporal.add(curso.getCodigoAaff());
				listaTemporal.add(curso.getCodigoUc());
				listaTemporal.add(curso.getCompetencia());
				listaTemporal.add(curso.getCualificacion());
				listaBody.add(listaTemporal);
			}
			session.setAttribute("title", "Cursos");
			session.setAttribute("clase", 1);
			session.setAttribute("tableHeader", listaHead);
			session.setAttribute("tableBody", listaBody);
		}

		request.getRequestDispatcher("listado.jsp").forward(request, response);
	}

	public static void delete(HttpServletRequest request, HttpServletResponse response, int id, DAOCurso daoCurso) {

		try {

			Curso cursoBorrado = daoCurso.delete(id);
			if (cursoBorrado != null) {
				request.getRequestDispatcher("action?operacion=4&clase=1").forward(request, response);
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

	public static void select(HttpServletRequest request, HttpServletResponse response, int id, DAOCurso daoCurso)
			throws ServletException, IOException {
		Curso curso = null;
		try {
			curso = daoCurso.getByid(id);
		} catch (Exception e) {
			System.err.println("Error recuperando curso");
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		if (curso != null) {
			session.setAttribute("curso", curso);
		}

		request.getRequestDispatcher("detalleCurso.jsp").forward(request, response);

	}

	public static void insertUpdate(HttpServletRequest request, HttpServletResponse response, int id,
			DAOCurso daoCurso) {
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
		if (id > 0)
			curso.setId(id);
		curso.setCualificacion(cualificacion);
		curso.setCodigoUc(codigoUc);
		curso.setCompetencia(competencia);
		curso.setCodigoAaff(codigoAaff);
		curso.setNombre(nombre);
		curso.setHorasCurso(horasCurso);

		// Actualizar base de datos
		DAOCurso dao = new DAOCurso();
		try {
			if (id > 0)
				curso = dao.update(curso);
			if (id == -1)
				curso = dao.getByid(dao.insert(curso));
			if (curso != null) {
				request.getRequestDispatcher("cursos").forward(request, response);
				System.out.println("Curso actualizado");
			} else {
				request.getRequestDispatcher("detalleCurso.jsp").forward(request, response);
				System.err.println("No se ha podido actualizar el curso");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("Error al actualizar curso");
			e.printStackTrace();
		}

	}

	public static void insertAll(HttpServletRequest request, HttpServletResponse response, DAOCurso daoCurso)
			throws ServletException, IOException {

		// TODO Esto correspondera a edicion
		// HttpSession sesion = request.getSession();
		// ArrayList<Curso> listaCursos = (ArrayList<Curso>)
		// sesion.getAttribute("lista");
		// // Insertar datos en la BD
		// DAOCurso cursoDB = new DAOCurso();
		// int numeroInsertados = listaCursos.size();
		// for (Curso curso : listaCursos) {
		// int id = -1;
		// try {
		// if (!curso.isGuardado())
		// id = cursoDB.insert(curso);
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// if (id < 0) {
		// System.out.println("El curso ya existe");
		// numeroInsertados--;
		// }
		// }
		// request.setAttribute("insertados", numeroInsertados);
		// request.getRequestDispatcher("fileUpload.jsp").forward(request, response);

	}

}
