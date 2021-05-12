package com.elorrieta.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.elorrieta.modelo.dao.DAOCurso;
import com.elorrieta.modelo.pojo.Curso;

/**
 * Servlet implementation class ListCursosController
 */
@WebServlet("/backoffice/cursos")
public class ListCursosController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListCursosController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Bypass a metodo post
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Obtener lista con usuarios de la DB
		DAOCurso dao = new DAOCurso();
		ArrayList<Curso> listaCursosDB = null;
		try {
			listaCursosDB = dao.getAll();
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

}
