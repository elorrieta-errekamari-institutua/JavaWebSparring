package com.elorrieta.utilities;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.elorrieta.controller.commons.BackofficeController;
import com.elorrieta.modelo.dao.DAOParticipante;
import com.elorrieta.modelo.pojo.Participante;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class OperationsParticipante {

	public static void insertUpdate(HttpServletRequest request, HttpServletResponse response, int id,
			DAOParticipante daoParticipante) {

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
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			id = -1;
		}

		// Guardar datos en POJO curso
		Participante participante = new Participante();
		if (id > 0)
			participante.setId(id);
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
		try {
			if (id > 0)
				participante = daoParticipante.update(participante);
			if (id == -1)
				participante = daoParticipante.getByid(daoParticipante.insert(participante));
			if (participante.getId() > 0) {
				request
						.getRequestDispatcher(
								"action?operacion=" + BackofficeController.SELECT_ALL + "&clase=" + BackofficeController.PARTICIPANTE)
						.forward(request, response);
				System.out.println("Usuario actualizado");
			} else {
				request.getRequestDispatcher("detalleParticipante.jsp").forward(request, response);
				System.err.println("No se ha podido actualizar participante");
			}
		} catch (Exception e) {
			System.err.println("Error al actualizar participante");
			e.printStackTrace();
		}

	}

	public static void insertAll(HttpServletRequest request, HttpServletResponse response,
			DAOParticipante daoParticipante) throws ServletException, IOException {

		HttpSession sesion = request.getSession();
		@SuppressWarnings("unchecked")
		ArrayList<Participante> listaParticipantes = (ArrayList<Participante>) sesion.getAttribute("lista");
		// Insertar datos en la BD
		int numeroInsertados = listaParticipantes.size();
		for (Participante participante : listaParticipantes) {
			int id = -1;
			try {
				if (!participante.isGuardado())
					id = daoParticipante.insert(participante);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (id < 0) {
				System.out.println("El participante ya existe");
				numeroInsertados--;
			}
		}
		request.setAttribute("insertados", numeroInsertados);
		request.getRequestDispatcher("fileUpload.jsp").forward(request, response);

	}

	public static void delete(HttpServletRequest request, HttpServletResponse response, int id,
			DAOParticipante daoParticipante) {

		try {

			Participante participanteBorrado = daoParticipante.delete(id);
			if (participanteBorrado != null) {
				request
						.getRequestDispatcher(
								"action?operacion=" + BackofficeController.SELECT_ALL + "&clase=" + BackofficeController.PARTICIPANTE)
						.forward(request, response);
				System.out.println("Participante eliminado");
			} else {
				request.getRequestDispatcher("detalleParticipante.jsp").forward(request, response);
				System.err.println("No se ha podido actualizar participante");
			}
		}

		catch (Exception e) {
			System.err.println("Id vacio");
		}

	}

	public static void select(HttpServletRequest request, HttpServletResponse response, int id,
			DAOParticipante daoParticipante) throws ServletException, IOException {

		Participante participante = new Participante();
		try {
			participante = daoParticipante.getByid(id);
		} catch (Exception e) {
			System.err.println("Error recuperando participante");
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		session.setAttribute("participante", participante);

		request.getRequestDispatcher("detalleParticipante.jsp").forward(request, response);

	}

	public static void selectAll(HttpServletRequest request, HttpServletResponse response,
			DAOParticipante daoParticipante) throws ServletException, IOException {

		ArrayList<Participante> listaParticipantesDB = null;
		try {
			listaParticipantesDB = daoParticipante.getAll();
		} catch (Exception e) {
			System.err.println("Problemas recuperando participantes");
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		if (listaParticipantesDB != null) {

			ArrayList<ArrayList<String>> listaBody = new ArrayList<ArrayList<String>>();
			for (Participante participante : listaParticipantesDB) {
				listaBody.add(participante.setDataList());
			}
			session.setAttribute("title", "Participantes");
			session.setAttribute("clase", BackofficeController.PARTICIPANTE);
			session.setAttribute("tableHeader", Participante.setHeadersList());
			session.setAttribute("tableBody", listaBody);
		}

		request.getRequestDispatcher("listado.jsp").forward(request, response);

	}

}
