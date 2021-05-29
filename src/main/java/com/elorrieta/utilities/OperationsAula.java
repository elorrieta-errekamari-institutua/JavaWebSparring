package com.elorrieta.utilities;

import java.io.IOException;
import java.util.ArrayList;

import com.elorrieta.controller.commons.BackofficeController;
import com.elorrieta.modelo.dao.DAOAula;
import com.elorrieta.modelo.pojo.Aula;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class OperationsAula {

	public static void insertUpdate(HttpServletRequest request, HttpServletResponse response, int id, DAOAula daoAula) {

		String nombre = request.getParameter("nombre");

		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			id = -1;
		}

		// Guardar datos en POJO curso
		Aula aula = new Aula();
		if (id > 0)
			aula.setId(id);
		aula.setNombre(nombre);

		try {
			if (id > 0)
				aula = daoAula.update(aula);
			if (id == -1)
				aula = daoAula.getByid(daoAula.insert(aula));
			if (aula.getId() > 0) {
				request
						.getRequestDispatcher(
								"action?operacion=" + BackofficeController.SELECT_ALL + "&clase=" + BackofficeController.AULA)
						.forward(request, response);
				System.out.println("Aula actualizada");
			} else {
				request.getRequestDispatcher("detalleAula.jsp").forward(request, response);
				System.err.println("No se ha podido actualizar aula");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("Error al actualizar aula");
			e.printStackTrace();
		}

	}

	public static void insertAll(HttpServletRequest request, HttpServletResponse response, DAOAula daoAula)
			throws IOException {
		throw new IOException("Caracteristica sin implementar");
	}

	public static void delete(HttpServletRequest request, HttpServletResponse response, int id, DAOAula daoAula) {

		try {

			Aula aulaBorrada = daoAula.delete(id);
			if (aulaBorrada != null) {
				request
						.getRequestDispatcher(
								"action?operacion=" + BackofficeController.SELECT_ALL + "&clase=" + BackofficeController.AULA)
						.forward(request, response);
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

	public static void select(HttpServletRequest request, HttpServletResponse response, int id, DAOAula daoAula)
			throws ServletException, IOException {

		Aula aula = new Aula();
		try {
			aula = daoAula.getByid(id);
		} catch (Exception e) {
			System.err.println("Error recuperando aula");
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		session.setAttribute("aula", aula);

		request.getRequestDispatcher("detalleAula.jsp").forward(request, response);

	}

	public static void selectAll(HttpServletRequest request, HttpServletResponse response, DAOAula daoAula)
			throws ServletException, IOException {

		ArrayList<Aula> listaAulasDB = null;
		try {
			listaAulasDB = daoAula.getAll();
		} catch (Exception e) {
			System.err.println("Problemas recuperando participantes");
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		if (listaAulasDB != null) {

			ArrayList<ArrayList<String>> listaBody = new ArrayList<ArrayList<String>>();

			for (Aula aula : listaAulasDB) {
				listaBody.add(aula.setDataList());
			}
			session.setAttribute("title", "Aulas");
			session.setAttribute("clase", BackofficeController.AULA);
			session.setAttribute("tableHeader", Aula.setHeadersList());
			session.setAttribute("tableBody", listaBody);
		}

		request.getRequestDispatcher("listado.jsp").forward(request, response);

	}

}
