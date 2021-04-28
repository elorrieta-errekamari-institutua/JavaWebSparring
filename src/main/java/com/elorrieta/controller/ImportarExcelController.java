package com.elorrieta.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.elorrieta.file.parser.ParserParticipantes;
import com.elorrieta.modelo.pojo.Participante;

/**
 * Servlet implementation class ImportarExcelController
 */
@WebServlet("/importar")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		maxFileSize = 1024 * 1024 * 10, // 10 MB
		maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class ImportarExcelController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ImportarExcelController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//
		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Part filePart = request.getPart("file");
		InputStream patata = filePart.getInputStream();
		String fileName = filePart.getSubmittedFileName();
		String relativeWebPath = "/scr/main/resources/excel/input/";
		for (Part part : request.getParts()) {
			part.write(fileName);
		}
		ParserParticipantes parseador = new ParserParticipantes();
		ArrayList<Participante> listaParticipantes = parseador.parseFile(fileName);
		request.setAttribute("listaParticipantes", listaParticipantes);
		request.getRequestDispatcher("historial.jsp").forward(request, response);
	}

}
