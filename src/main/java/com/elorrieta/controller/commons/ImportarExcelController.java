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
import com.elorrieta.file.parser.ParserEdiciones;
import com.elorrieta.file.parser.ParserHorarios;
import com.elorrieta.file.parser.ParserParticipantes;
import com.elorrieta.modelo.dao.DAOCurso;
import com.elorrieta.modelo.dao.DAOEdicion;
import com.elorrieta.modelo.dao.DAOParticipante;
import com.elorrieta.modelo.pojo.Curso;
import com.elorrieta.modelo.pojo.Edicion;
import com.elorrieta.modelo.pojo.Horario;
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

	private DAOParticipante daoParticipante;
	private DAOCurso daoCurso;
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
		daoCurso = new DAOCurso();
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

		String uploadPath = getServletContext().getRealPath("") + "/resources/excel/input/";
		String fileName = UploadFile.upload(request, uploadPath, "file");

		String tipoFichero = request.getParameter("fileType");

		if ("participantes".equalsIgnoreCase(tipoFichero)) {

			ArrayList<Participante> listaParticipantes = parseadorParticipantes.parseFile(uploadPath + fileName);

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

		if ("ediciones".equalsIgnoreCase(tipoFichero)) {
			// TODO Parsear excel Curso y guardar

			ArrayList<Curso> listaCursos = parseadorCursos.parseFile(uploadPath + fileName);
			ArrayList<Horario> listaHorarios = parseadorHorarios.parseFile(uploadPath + fileName);
			ArrayList<Edicion> listaEdiciones = parseadorEdiciones.parseFile(uploadPath + fileName);

			for (int i = 0; i < listaEdiciones.size(); i++) {
				try {
					Edicion edicionTemporal = listaEdiciones.get(i);
					Curso cursoTemporal = listaCursos.get(i);
					Horario horarioTemporal = listaHorarios.get(i);

					if (daoEdicion.getByName(edicionTemporal.getCodigoLanbide()) != null) {
						listaCursos.get(i).setGuardado(true);
					}

				} catch (Exception e) {
					System.out.println("Error SQL");
					e.printStackTrace();
				}
			}
			HttpSession session = request.getSession();
			session.setAttribute("listaEdiciones", listaCursos);
		}
		request.getRequestDispatcher("previewDocumentData.jsp").forward(request, response);

	}

}
