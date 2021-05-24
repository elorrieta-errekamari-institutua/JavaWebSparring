package com.elorrieta.utilities;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

	public static void insertAll(HttpServletRequest request, HttpServletResponse response, DAOAula daoAula) {
		// TODO Auto-generated method stub

	}

	public static void delete(HttpServletRequest request, HttpServletResponse response, Integer integer,
			DAOAula daoAula) {
		// TODO Auto-generated method stub

	}

	public static void select(HttpServletRequest request, HttpServletResponse response, Integer integer,
			DAOAula daoAula) {
		// TODO Auto-generated method stub

	}

	public static void selectAll(HttpServletRequest request, HttpServletResponse response, DAOAula daoAula) {
		// TODO Auto-generated method stub

	}

}
