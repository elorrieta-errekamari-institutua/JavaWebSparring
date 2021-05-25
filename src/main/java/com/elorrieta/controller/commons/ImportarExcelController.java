package com.elorrieta.controller.commons;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.elorrieta.file.parser.ParserCursos;
import com.elorrieta.file.parser.ParserParticipantes;
import com.elorrieta.modelo.dao.DAOCurso;
import com.elorrieta.modelo.dao.DAOParticipante;
import com.elorrieta.modelo.pojo.Curso;
import com.elorrieta.modelo.pojo.Participante;
import com.elorrieta.utilities.UploadFile;

/**
 * Servlet implementation class ImportarExcelController
 */
@WebServlet("/backoffice/importar")
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
		DAOParticipante daoParticipante = new DAOParticipante();
		DAOCurso daoCurso = new DAOCurso();

		String uploadPath = getServletContext().getRealPath("") + "/resources/excel/input/";
		String fileName = UploadFile.upload(request, uploadPath, "file");

		String tipoFichero = request.getParameter("fileType");

		if ("participantes".equalsIgnoreCase(tipoFichero)) {
			ParserParticipantes parseador = new ParserParticipantes();
			ArrayList<Participante> listaParticipantes = parseador.parseFile(uploadPath + fileName);

			for (Participante participante : listaParticipantes) {
				try {
					Participante participanteTemporal = daoParticipante.getByDni(participante.getDni());
					if (participanteTemporal != null) {
						participante.setGuardado(true);
					}
				} catch (Exception e) {
					System.out.println("Error SQL");
					e.printStackTrace();
				}
			}
			HttpSession session = request.getSession();
			session.setAttribute("listaParticipantes", listaParticipantes);
		}

		if ("cursos".equalsIgnoreCase(tipoFichero)) {
			// TODO Parsear excel Curso y guardar
			ParserCursos parseador = new ParserCursos();
			ArrayList<Curso> listaCursos = parseador.parseFile(uploadPath + fileName);

			for (Curso curso : listaCursos) {
				try {
					Curso cursoTemporal = daoCurso.getByCodigos(curso.getNombre(), curso.getCodigoUc(), curso.getCodigoAaff());
					if (cursoTemporal != null) {
						curso.setGuardado(true);
					}
				} catch (Exception e) {
					System.out.println("Error SQL");
					e.printStackTrace();
				}
			}
			HttpSession session = request.getSession();
			session.setAttribute("listaCursos", listaCursos);
		}
		request.getRequestDispatcher("previewDocumentData.jsp").forward(request, response);

	}

}
