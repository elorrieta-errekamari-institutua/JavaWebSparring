package com.elorrieta.utilities;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.elorrieta.modelo.dao.DAOAula;
import com.elorrieta.modelo.pojo.Aula;

public class OperationsAula {

	public static void insertUpdate(HttpServletRequest request, HttpServletResponse response, int id, DAOAula daoAula) {

		String nombre = request.getParameter("nombreCompleto");

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
			if (aula != null) {
				// TODO refactor el fuckin historial jsp
				request.getRequestDispatcher("aulas").forward(request, response);
				System.out.println("Aula actualizada");
			} else {
				request.getRequestDispatcher("detalleParticipante.jsp").forward(request, response);
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
				request.getRequestDispatcher("aula").forward(request, response);
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

		Aula aula = null;
		try {
			aula = daoAula.getByid(id);
		} catch (Exception e) {
			System.err.println("Error recuperando aula");
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		if (aula != null) {
			session.setAttribute("participante", aula);
		}

		request.getRequestDispatcher("detalleParticipante.jsp").forward(request, response);

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
			session.removeAttribute("listaAulas");
			session.setAttribute("listaAulas", listaAulasDB);
		}

		request.getRequestDispatcher("cursos.jsp").forward(request, response);

	}

}
