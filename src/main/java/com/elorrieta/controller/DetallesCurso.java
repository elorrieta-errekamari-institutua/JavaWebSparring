package com.elorrieta.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.elorrieta.modelo.dao.DAOCurso;
import com.elorrieta.modelo.pojo.Curso;

/**
 * Servlet implementation class DetallesCurso
 */
@WebServlet("/backoffice/insertCursoForm")
public class DetallesCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DetallesCurso() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Obtener datos de un participante a partir de la id enviada en el request
		int id = Integer.parseInt(request.getParameter("id"));
		DAOCurso dao = new DAOCurso();
		Curso curso = null;
		try {
			curso = dao.getByid(id);
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Obtener datos formulario
		int id;
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

}
