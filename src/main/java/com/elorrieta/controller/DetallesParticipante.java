package com.elorrieta.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.elorrieta.modelo.dao.DAOParticipante;
import com.elorrieta.modelo.pojo.Participante;

/**
 * Servlet implementation class DetallesParticipante
 */
@WebServlet("/detalle")
public class DetallesParticipante extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DetallesParticipante() {
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
		int id = (int) request.getAttribute("id");
		DAOParticipante dao = new DAOParticipante();
		Participante participante = null;
		try {
			participante = dao.getByid(id);
		} catch (Exception e) {
			System.err.println("Error recuperando participante");
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		if (participante != null) {
			session.setAttribute("participante", participante);
		}

		request.getRequestDispatcher("backoffice/detalle.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
