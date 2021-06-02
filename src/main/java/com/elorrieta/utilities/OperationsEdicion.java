package com.elorrieta.utilities;

import java.io.IOException;
import java.util.ArrayList;

import com.elorrieta.controller.commons.BackofficeController;
import com.elorrieta.modelo.dao.DAOAula;
import com.elorrieta.modelo.dao.DAOCurso;
import com.elorrieta.modelo.dao.DAOEdicion;
import com.elorrieta.modelo.dao.DAOHorario;
import com.elorrieta.modelo.pojo.Edicion;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class OperationsEdicion {

	public static void insertUpdate(HttpServletRequest request, HttpServletResponse response, Integer integer,
			DAOEdicion daoEdicion, DAOCurso daoCurso, DAOHorario daoHorario, DAOAula daoAula) {
		// TODO Auto-generated method stub

	}

	public static void insertAll(HttpServletRequest request, HttpServletResponse response, DAOEdicion daoEdicion)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		ArrayList<Edicion> listaEdiciones = (ArrayList<Edicion>) sesion.getAttribute("lista");
		// Insertar datos en la BD
		int edicionesInsertadas = listaEdiciones.size();
		for (Edicion edicion : listaEdiciones) {
			int idEdicion = -1;

			try {
				if (!edicion.isGuardado()) {

					idEdicion = daoEdicion.insert(edicion);

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

	public static void select(HttpServletRequest request, HttpServletResponse response, Integer integer,
			DAOEdicion daoEdicion, DAOCurso daoCurso, DAOHorario daoHorario, DAOAula daoAula) {
		// TODO Auto-generated method stub

	}

	public static void selectAll(HttpServletRequest request, HttpServletResponse response, DAOEdicion daoEdicion, DAOCurso daoCurso, DAOHorario daoHorario, DAOAula daoAula)
			throws ServletException, IOException {
		ArrayList<Edicion> listaEdicionesDB = null;
		try {
			listaEdicionesDB = daoEdicion.getAll(daoCurso, daoHorario, daoAula);
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
