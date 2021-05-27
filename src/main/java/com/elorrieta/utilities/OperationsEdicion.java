package com.elorrieta.utilities;

import java.io.IOException;
import java.util.ArrayList;

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
			DAOEdicion daoEdicion) {
		// TODO Auto-generated method stub

	}

	public static void insertAll(HttpServletRequest request, HttpServletResponse response, DAOEdicion daoEdicion,
			DAOCurso daoCurso, DAOHorario daoHorario) throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		ArrayList<Edicion> listaEdiciones = (ArrayList<Edicion>) sesion.getAttribute("lista");
		// Insertar datos en la BD
		int edicionesInsertadas = listaEdiciones.size();
		int cursosInsertados = edicionesInsertadas;
		for (Edicion edicion : listaEdiciones) {
			int idEdicion = -1;
			int idCurso = -1;
			int idHorario = -1;
			try {
				if (!edicion.isGuardado()) {
					idCurso = daoCurso.insert(edicion.getCurso());
					if (idCurso < 0) {
						System.out.println("El curso ya existe");
						cursosInsertados--;
						idCurso = daoCurso.getByCodigos(edicion.getCurso().getNombre(),
								edicion.getCurso().getCodigoUc(), edicion.getCurso().getCodigoAaff()).getId();
					}
					idHorario = daoHorario.insert(edicion.getHorario());
					idEdicion = daoEdicion.insert(edicion, idCurso, idHorario);
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
		request.setAttribute("cursos", cursosInsertados);
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
