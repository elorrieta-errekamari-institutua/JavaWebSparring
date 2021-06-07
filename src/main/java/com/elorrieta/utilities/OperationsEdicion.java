package com.elorrieta.utilities;

import java.io.IOException;
import java.util.ArrayList;

import com.elorrieta.controller.commons.BackofficeController;
import com.elorrieta.modelo.dao.DAOAula;
import com.elorrieta.modelo.dao.DAOCurso;
import com.elorrieta.modelo.dao.DAOEdicion;
import com.elorrieta.modelo.dao.DAOHorario;
import com.elorrieta.modelo.pojo.Aula;
import com.elorrieta.modelo.pojo.Edicion;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class OperationsEdicion {

	public static void insertUpdate(HttpServletRequest request, HttpServletResponse response, Integer integer,
			DAOEdicion daoEdicion, DAOCurso daoCurso, DAOHorario daoHorario, DAOAula daoAula) {
				System.out.println(request.getParameter("aula0"));
				System.out.println(request.getParameter("aula1"));
				System.out.println(request.getParameter("aula2"));
				System.out.println(request.getParameter("aula3"));
				System.out.println(request.getParameter("aula4"));
		// TODO Auto-generated method stub

	}

	public static void insertAll(HttpServletRequest request, HttpServletResponse response, DAOEdicion daoEdicion,
			DAOCurso daoCurso, DAOHorario daoHorario, DAOAula daoAula) throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		@SuppressWarnings("unchecked")
		ArrayList<Edicion> listaEdiciones = (ArrayList<Edicion>) sesion.getAttribute("lista");
		// Insertar datos en la BD
		int edicionesInsertadas = listaEdiciones.size();
		for (Edicion edicion : listaEdiciones) {
			int idEdicion = -1;

			try {
				if (!edicion.isGuardado()) {

					idEdicion = daoEdicion.insert(edicion, daoCurso, daoHorario, daoAula);

					if (idEdicion > 0) {
						System.out.println("Insertada edicion");
					} else {
						System.err.println("No se ha podido insertar la edicion");
					}

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (idEdicion < 0) {
				System.out.println("La edicion ya existe");
				edicionesInsertadas--;
			}
		}
		request.setAttribute("insertados", edicionesInsertadas);
		request.getRequestDispatcher("fileUpload.jsp").forward(request, response);

	}

	public static void delete(HttpServletRequest request, HttpServletResponse response, Integer integer,
			DAOEdicion daoEdicion, DAOCurso daoCurso, DAOHorario daoHorario, DAOAula daoAula) {
		// TODO Auto-generated method stub

	}

	public static void select(HttpServletRequest request, HttpServletResponse response, int id,
			DAOEdicion daoEdicion, DAOAula daoAula) throws ServletException, IOException {
		// TODO probar
		Edicion edicion = new Edicion();
		ArrayList<Aula> aulas = new ArrayList<Aula>();
		try {
			edicion = daoEdicion.getByid(id);
			aulas = daoAula.getAll();
		} catch (Exception e) {
			System.err.println("Error recuperando edicion");
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		session.setAttribute("edicion", edicion);
		session.setAttribute("aulas", aulas);

		request.getRequestDispatcher("detalleEdicion.jsp").forward(request, response);
	}

	public static void selectAll(HttpServletRequest request, HttpServletResponse response, DAOEdicion daoEdicion) throws ServletException, IOException {
		ArrayList<Edicion> listaEdicionesDB = null;
		try {
			listaEdicionesDB = daoEdicion.getAll();
		} catch (Exception e) {
			System.err.println("Problemas recuperando ediciones");
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		if (listaEdicionesDB != null) {

			ArrayList<ArrayList<String>> listaBody = new ArrayList<ArrayList<String>>();

			for (Edicion edicion : listaEdicionesDB) {
				listaBody.add(edicion.setDataList());
			}

			session.setAttribute("title", "Ediciones");
			session.setAttribute("clase", BackofficeController.EDICION);
			session.setAttribute("tableHeader", Edicion.setHeadersList());
			session.setAttribute("tableBody", listaBody);
		}

		request.getRequestDispatcher("listado.jsp").forward(request, response);
	}

}
