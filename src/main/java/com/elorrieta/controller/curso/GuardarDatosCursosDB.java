package com.elorrieta.controller.curso;

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
 * Servlet implementation class GuardarDatosCursosDB
 */
@WebServlet("/backoffice/guardarCursos")
public class GuardarDatosCursosDB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GuardarDatosCursosDB() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
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
