package com.elorrieta.aula;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.elorrieta.modelo.dao.DAOAula;
import com.elorrieta.modelo.pojo.Aula;

/**
 * Servlet implementation class DetallesCurso
 */
@WebServlet("/backoffice/insertAulaForm")
public class DetallesAula extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DetallesAula() {
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
		DAOAula dao = new DAOAula();
		Aula aula = null;
		try {
			aula = dao.getByid(id);
		} catch (Exception e) {
			System.err.println("Error recuperando aula");
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		if (aula != null) {
			session.setAttribute("aula", aula);
		}

		request.getRequestDispatcher("detalleAula.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
