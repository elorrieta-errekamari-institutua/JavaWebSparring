package com.elorrieta.controller.commons;

import java.io.IOException;
import java.util.ArrayList;

import com.elorrieta.file.parser.ParserEdiciones;
import com.elorrieta.file.parser.ParserParticipantes;
import com.elorrieta.modelo.dao.DAOEdicion;
import com.elorrieta.modelo.dao.DAOParticipante;
import com.elorrieta.modelo.pojo.Edicion;
import com.elorrieta.modelo.pojo.Participante;
import com.elorrieta.utilities.UploadFile;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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

	private DAOParticipante daoParticipante;
	private DAOEdicion daoEdicion;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ImportarExcelController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Todas las funciones se realizaran en Post
		doPost(request, response);

	}

	@Override
	public void init() throws ServletException {
		super.init();
		daoParticipante = new DAOParticipante();
		daoEdicion = new DAOEdicion();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recoger la sesion e incializar las tablas que se rellenaran mas adelante
		HttpSession session = request.getSession();
		ArrayList<String> listaHead = new ArrayList<String>();
		ArrayList<ArrayList<String>> listaBody = new ArrayList<ArrayList<String>>();

		String uploadPath = getServletContext().getRealPath("") + "/resources/excel/input/";
		String fileName = UploadFile.upload(request, uploadPath, "file");

		String tipoFichero = request.getParameter("fileType");

		if ("participantes".equalsIgnoreCase(tipoFichero)) {

			ArrayList<Participante> listaParticipantes = ParserParticipantes.parseFile(uploadPath + fileName);

			listaHead = Participante.setHeadersList();

			for (Participante participante : listaParticipantes) {
				try {
					Participante participanteTemporal = daoParticipante.getByDni(participante.getDni());
					if (participanteTemporal.getId() > 0) {
						participante.setGuardado(true);
					}
					listaBody.add(participante.setDataList());
				} catch (Exception e) {
					System.out.println("Error SQL");
					e.printStackTrace();
				}
			}

			session.setAttribute("lista", listaParticipantes);
			session.setAttribute("clase", BackofficeController.PARTICIPANTE);
		}

		if ("cursos".equalsIgnoreCase(tipoFichero)) {

			ArrayList<Edicion> listaEdiciones = ParserEdiciones.parseFile(uploadPath + fileName);

			listaHead = Edicion.setHeadersList();

			for (Edicion edicion : listaEdiciones) {
				Edicion edicionDB = daoEdicion.getByCodigoLanbide(edicion.getCodigoLanbide());
				if (edicionDB.getId() > 0) {
					edicion.setGuardado(true);
				}
				listaBody.add(edicion.setDataList());
			}
			session.setAttribute("lista", listaEdiciones);
			session.setAttribute("clase", BackofficeController.EDICION);
		}
		session.setAttribute("title", "Confirme los datos");
		session.setAttribute("tableHeader", listaHead);
		session.setAttribute("tableBody", listaBody);
		request.getRequestDispatcher("previewDocumentData.jsp").forward(request, response);

	}

}
