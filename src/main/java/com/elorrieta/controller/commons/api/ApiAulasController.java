package com.elorrieta.controller.commons.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.elorrieta.modelo.dao.DAOAula;
import com.elorrieta.modelo.pojo.Aula;
import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ApìAulasController
 */
@WebServlet("/api/aulas")
public class ApiAulasController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Devuelve un JSON con las aulas que contengan en su nombre el texto
	 * introducido en el parametro name
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = (String) request.getParameter("name");

		// contentype y charset
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		// escribir respuesta
		PrintWriter out = response.getWriter();
		ArrayList<Aula> aulas;
		try {

			DAOAula dao = new DAOAula();

			if (name == null) {

				aulas = dao.getAll();

			} else {

				aulas = dao.getByPartialName(name);

			}

			// POJO to JSON
			out.print(new Gson().toJson(aulas));
			out.flush();

		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
	}

}
