package com.elorrieta.controller.commons;

import java.io.IOException;
import java.util.ArrayList;

import com.elorrieta.file.parser.ParserCursos;
import com.elorrieta.file.parser.ParserEdiciones;
import com.elorrieta.file.parser.ParserHorarios;
import com.elorrieta.file.parser.ParserParticipantes;
import com.elorrieta.modelo.dao.DAOEdicion;
import com.elorrieta.modelo.dao.DAOParticipante;
import com.elorrieta.modelo.pojo.Curso;
import com.elorrieta.modelo.pojo.Edicion;
import com.elorrieta.modelo.pojo.Horario;
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
	private ParserParticipantes parseadorParticipantes;
	private ParserCursos parseadorCursos;
	private ParserHorarios parseadorHorarios;
	private ParserEdiciones parseadorEdiciones;

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

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		daoParticipante = new DAOParticipante();
		daoEdicion = new DAOEdicion();
		parseadorParticipantes = new ParserParticipantes();
		parseadorCursos = new ParserCursos();
		parseadorHorarios = new ParserHorarios();
		parseadorEdiciones = new ParserEdiciones();
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

			ArrayList<Participante> listaParticipantes = parseadorParticipantes.parseFile(uploadPath + fileName);

			listaHead = Participante.setHeadersList();

			for (Participante participante : listaParticipantes) {
				try {
					Participante participanteTemporal = daoParticipante.getByDni(participante.getDni());
					if (participanteTemporal != null) {
						participante.setGuardado(true);
					}
					listaBody.add(participanteTemporal.setDataList());
				} catch (Exception e) {
					System.out.println("Error SQL");
					e.printStackTrace();
				}
			}

			session.setAttribute("lista", listaParticipantes);
			session.setAttribute("clase", BackofficeController.PARTICIPANTE);
		}

		if ("cursos".equalsIgnoreCase(tipoFichero)) {
			
			ArrayList<Curso> listaCursos = parseadorCursos.parseFile(uploadPath + fileName);
			ArrayList<Horario> listaHorarios = parseadorHorarios.parseFile(uploadPath + fileName);
			ArrayList<Edicion> listaEdiciones = parseadorEdiciones.parseFile(uploadPath + fileName);

			listaHead = Edicion.setHeadersList();

			for (int i = 0; i < listaEdiciones.size(); i++) {
				try {

					Edicion edicionTemporal = listaEdiciones.get(i);
					Edicion edicionDB = daoEdicion.getByCodigoLanbide(edicionTemporal.getCodigoLanbide());
					Curso cursoTemporal = listaCursos.get(i);
					Horario horarioTemporal = listaHorarios.get(i);

					edicionTemporal.setCurso(cursoTemporal);
					edicionTemporal.setHorario(horarioTemporal);
					listaEdiciones.set(i, edicionTemporal);

					if (edicionDB != null) {
						edicionTemporal.setGuardado(true);
					}
					listaBody.add(edicionTemporal.setDataList());

				} catch (Exception e) {
					System.out.println("Error SQL");
					e.printStackTrace();
				}
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
