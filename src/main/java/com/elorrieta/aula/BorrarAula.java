package com.elorrieta.aula;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elorrieta.modelo.dao.DAOAula;
import com.elorrieta.modelo.pojo.Aula;

/**
 * Servlet implementation class BorrarCurso
 */
@WebServlet("/backoffice/borrarAula")
public class BorrarAula extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BorrarAula() {
		super();
		// TODO Auto-generated constructor stub
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
		int id;
		DAOAula dao = new DAOAula();

		try {
			id = Integer.parseInt(request.getParameter("id"));
			Aula aulaBorrada = dao.delete(id);
			if (aulaBorrada != null) {
				request.getRequestDispatcher("aulas").forward(request, response);
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

}
