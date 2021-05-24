/**
 * 
 */
package com.elorrieta.utilities;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.elorrieta.modelo.dao.DAOCurso;
import com.elorrieta.modelo.pojo.Curso;

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
			session.removeAttribute("listaCursos");
			session.setAttribute("listaCursos", listaCursosDB);
		}

		request.getRequestDispatcher("cursos.jsp").forward(request, response);
	}

	public static void delete(HttpServletRequest request, HttpServletResponse response, int id, DAOCurso daoCurso) {

		try {

			Curso cursoBorrado = daoCurso.delete(id);
			if (cursoBorrado != null) {
				request.getRequestDispatcher("cursos").forward(request, response);
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

		HttpSession sesion = request.getSession();
		ArrayList<Curso> listaCursos = (ArrayList<Curso>) sesion.getAttribute("listaCursos");
		// Insertar datos en la BD
		DAOCurso usuarioDB = new DAOCurso();
		int numeroInsertados = listaCursos.size();
		for (Curso curso : listaCursos) {
			int id = -1;
			try {
				if (!curso.isGuardado())
					id = usuarioDB.insert(curso);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (id < 0) {
				System.out.println("El usuario ya existe");
				numeroInsertados--;
			}
		}
		request.setAttribute("insertados", numeroInsertados);
		request.getRequestDispatcher("fileUpload.jsp").forward(request, response);

	}

}
