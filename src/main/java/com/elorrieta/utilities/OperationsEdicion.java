package com.elorrieta.utilities;

import java.io.IOException;
import java.util.ArrayList;

import com.elorrieta.modelo.dao.DAOEdicion;
import com.elorrieta.modelo.pojo.Edicion;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class OperationsEdicion {

	public static void insertUpdate(HttpServletRequest request, HttpServletResponse response, Integer integer,
			DAOEdicion daoEdicion) {
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
				// TODO Auto-generated catch block
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
			DAOEdicion daoEdicion) {
		// TODO Auto-generated method stub

	}

	public static void select(HttpServletRequest request, HttpServletResponse response, Integer integer,
			DAOEdicion daoEdicion) {
		// TODO Auto-generated method stub

	}

	public static void selectAll(HttpServletRequest request, HttpServletResponse response, DAOEdicion daoEdicion) {
		// TODO Auto-generated method stub

	}

}
