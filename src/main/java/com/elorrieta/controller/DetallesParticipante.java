package com.elorrieta.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
@WebServlet("/backoffice/detalle")
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
		int id = Integer.parseInt(request.getParameter("id"));
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

		request.getRequestDispatcher("detalle.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Obtener datos formulario
		Participante participante = new Participante();
		String nombreCompleto = request.getParameter("nombreCompleto");
		String dni = request.getParameter("dni");
		String telefono = request.getParameter("telefono");
		Date fechaDeNacimiento = Date.valueOf(request.getParameter("fechaDeNacimiento"));
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String strDateFormat = dateFormat.format(fechaDeNacimiento);
		String direccion = request.getParameter("direccion");
		String codigoPostal = request.getParameter("codigoPostal");
		String municipio = request.getParameter("municipio");
		String provincia = request.getParameter("provincia");
		boolean erte = "on".equalsIgnoreCase(request.getParameter("erte"));
		String situacionLaboral = request.getParameter("situacionLaboral");
		String situacionAdministrativa = request.getParameter("situacionAdministrativa");
		String titulacion = request.getParameter("titulacion");

		// Guardar datos en POJO participante
		participante.setId(Integer.parseInt(request.getParameter("id")));
		participante.setNombreCompleto(nombreCompleto);
		participante.setDni(dni);
		participante.setTelefono(telefono);
		participante.setFechaDeNacimiento(Date.valueOf(strDateFormat));
		participante.setDireccion(direccion);
		participante.setCodigoPostal(codigoPostal);
		participante.setMunicipio(municipio);
		participante.setProvincia(provincia);
		participante.setErte(erte);
		participante.setSituacionLaboral(situacionLaboral);
		participante.setSituacionAdministrativa(situacionAdministrativa);
		participante.setTitulacion(titulacion);

		// Actualizar base de datos
		DAOParticipante dao = new DAOParticipante();
		try {
			participante = dao.update(participante);
			if (participante != null) {
				// TODO refactor el fuckin historial jsp
				request.getRequestDispatcher("participantes").forward(request, response);
				System.out.println("Usuario actualizado");
			} else {
				request.getRequestDispatcher("detalle.jsp").forward(request, response);
				System.err.println("No se ha podido actualizar usuario");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("Error al actualizar usuario");
			e.printStackTrace();
		}

	}

}
