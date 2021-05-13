package com.elorrieta.controller.participante;

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
 * Servlet implementation class GuardarDatosDB
 */
@WebServlet("/backoffice/guardarParticipantes")
public class GuardarDatosParticipantesDB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GuardarDatosParticipantesDB() {
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
		// TODO Auto-generated method stub
		HttpSession sesion = request.getSession();
		ArrayList<Participante> listaParticipantes = (ArrayList<Participante>) sesion
				.getAttribute("listaParticipantes");
		// TODO Insertar datos en la BD
		DAOParticipante usuarioDB = new DAOParticipante();
		int numeroInsertados = listaParticipantes.size();
		for (Participante participante : listaParticipantes) {
			int id = -1;
			try {
				if (!participante.isGuardado())
					id = usuarioDB.insert(participante);
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
