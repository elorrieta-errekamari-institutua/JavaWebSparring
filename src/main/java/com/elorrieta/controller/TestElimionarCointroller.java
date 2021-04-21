package com.elorrieta.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elorrieta.modelo.dao.DAOConectionManager;

/**
 * Servlet implementation class TestElimionarCointroller
 */
@WebServlet("/login")
public class TestElimionarCointroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DAOConectionManager connManager = new DAOConectionManager();
		try (Connection conn = connManager.open();) {
			System.out.println("Conectado");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String nombre = request.getParameter("nombre");

		request.setAttribute("nombre", nombre + " ha pasado pore el servlet");

		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

}
