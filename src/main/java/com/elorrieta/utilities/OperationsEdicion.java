package com.elorrieta.utilities;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.elorrieta.modelo.dao.DAOCurso;
import com.elorrieta.modelo.dao.DAOEdicion;
import com.elorrieta.modelo.dao.DAOHorario;
import com.elorrieta.modelo.pojo.Curso;
import com.elorrieta.modelo.pojo.Edicion;

public class OperationsEdicion {

	public static void insertUpdate(HttpServletRequest request, HttpServletResponse response, Integer integer,
			DAOEdicion daoEdicion) {
		// TODO Auto-generated method stub

	}

	public static void insertAll(HttpServletRequest request, HttpServletResponse response, DAOEdicion daoEdicion)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		ArrayList<Curso> listaCursos = (ArrayList<Curso>) sesion.getAttribute("listaCursos");
		// Insertar datos en la BD
		DAOCurso cursoDB = new DAOCurso();
		DAOHorario horarioDB = new DAOHorario();
		int numeroInsertados = listaCursos.size();
		for (Curso curso : listaCursos) {
			int idCurso = -1;
			int idHorario = -1;
			try {
				if (!curso.isGuardado()) {
					idCurso = cursoDB.insert(curso);
					idHorario = horarioDB.insert(curso.getHorario());
					Edicion edicionNueva = new Edicion(idCurso, idHorario);
					daoEdicion.insert(edicionNueva);
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (idCurso < 0) {
				System.out.println("El usuario ya existe");
				numeroInsertados--;
			}
		}
		request.setAttribute("insertados", numeroInsertados);
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
