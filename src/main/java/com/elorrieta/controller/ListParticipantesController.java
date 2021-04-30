package com.elorrieta.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.elorrieta.modelo.dao.DAOParticipante;
import com.elorrieta.modelo.pojo.Participante;

/**
 * Servlet implementation class ListParticipantesController
 */
@WebServlet("/participantes")
public class ListParticipantesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListParticipantesController() {
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
		DAOParticipante dao = new DAOParticipante();
		ArrayList<Participante> listaParticipantesDB = null;
		try {
			listaParticipantesDB = dao.getAll();
		} catch (Exception e) {
			System.err.println("Problemas recuperando usuarios");
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		if (listaParticipantesDB != null) {
			session.removeAttribute("listaParticipantes");
			session.setAttribute("listaParticipantes", listaParticipantesDB);
		}

		request.getRequestDispatcher("participantes.jsp").forward(request, response);
	}

}
