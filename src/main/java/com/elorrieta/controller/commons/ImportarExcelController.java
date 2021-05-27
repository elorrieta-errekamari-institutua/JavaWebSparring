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

			listaHead.add("#");
			listaHead.add("Nombre");
			listaHead.add("DNI");
			listaHead.add("Telefono");
			listaHead.add("<abbr title='Fecha de nacimiento'>Fecha</abbr>");
			listaHead.add("Direccion");
			listaHead.add("<abbr title='Codigo postal'>CP</abbr>");
			listaHead.add("Municipio");
			listaHead.add("Provincia");
			listaHead.add("ERTE");
			listaHead.add("<abbr title='Situacion laboral'>Laboral</abbr>");
			listaHead.add("<abbr title='Situacion administrativa'>Administrativa</abbr>");

			for (Participante participante : listaParticipantes) {
				try {
					Participante participanteTemporal = daoParticipante.getByDni(participante.getDni());
					ArrayList<String> listaTemporal = new ArrayList<String>();
					if (participanteTemporal != null) {
						participante.setGuardado(true);
						listaTemporal.add("0");
					} else {
						listaTemporal.add("-1");
					}
					listaTemporal.add(participante.getNombreCompleto());
					listaTemporal.add(participante.getDni());
					listaTemporal.add(participante.getTelefono());
					listaTemporal.add(participante.getFechaDeNacimiento().toString());
					listaTemporal.add(participante.getDireccion());
					listaTemporal.add(participante.getCodigoPostal());
					listaTemporal.add(participante.getMunicipio());
					listaTemporal.add(participante.getProvincia());
					if (participante.isErte()) {
						listaTemporal.add("Si");
					} else {
						listaTemporal.add("No");
					}
					listaTemporal.add(participante.getSituacionLaboral());
					listaTemporal.add(participante.getSituacionAdministrativa());
					listaBody.add(listaTemporal);
				} catch (Exception e) {
					System.out.println("Error SQL");
					e.printStackTrace();
				}
			}

			session.setAttribute("lista", listaParticipantes);
		}

		if ("cursos".equalsIgnoreCase(tipoFichero)) {
			// TODO Parsear excel Curso y guardar

			ArrayList<Curso> listaCursos = parseadorCursos.parseFile(uploadPath + fileName);
			ArrayList<Horario> listaHorarios = parseadorHorarios.parseFile(uploadPath + fileName);
			ArrayList<Edicion> listaEdiciones = parseadorEdiciones.parseFile(uploadPath + fileName);

			listaHead.add("#");
			listaHead.add("Codigo Lanbide");
			listaHead.add("Nombre");
			listaHead.add("Horas");
			listaHead.add("Codigo AAFF");
			listaHead.add("Codigo UC");
			listaHead.add("Competencia");
			listaHead.add("Cualificacion");
			listaHead.add("Fecha inicio");
			listaHead.add("Fecha fin");
			listaHead.add("Lunes");
			listaHead.add("Martes");
			listaHead.add("Miercoles");
			listaHead.add("Jueves");
			listaHead.add("Viernes");

			for (int i = 0; i < listaEdiciones.size(); i++) {
				try {
					Edicion edicionTemporal = listaEdiciones.get(i);
					Edicion edicionDB = daoEdicion.getByCodigoLanbide(edicionTemporal.getCodigoLanbide());
					Curso cursoTemporal = listaCursos.get(i);
					Horario horarioTemporal = listaHorarios.get(i);
					ArrayList<String> listaTemporal = new ArrayList<String>();
					ArrayList<String> listaHorario = horarioTemporal.toStringList();
					if (edicionDB != null) {
						edicionTemporal.setGuardado(true);
						listaTemporal.add("0");
					} else {
						listaTemporal.add("-1");
					}
					listaTemporal.add(edicionTemporal.getCodigoLanbide());
					listaTemporal.add(cursoTemporal.getNombre());
					listaTemporal.add(String.valueOf(cursoTemporal.getHorasCurso()));
					listaTemporal.add(cursoTemporal.getCodigoAaff());
					listaTemporal.add(cursoTemporal.getCodigoUc());
					listaTemporal.add(cursoTemporal.getCompetencia());
					listaTemporal.add(cursoTemporal.getCualificacion());
					listaTemporal.add(edicionTemporal.getFechaInicio().toString());
					listaTemporal.add(edicionTemporal.getFechaFin().toString());

					if (listaTemporal.addAll(listaHorario)) {
						listaBody.add(listaTemporal);
					}

				} catch (Exception e) {
					System.out.println("Error SQL");
					e.printStackTrace();
				}
			}

			session.setAttribute("lista", listaCursos);
		}
		session.setAttribute("title", "Confirme los datos");
		session.setAttribute("tableHeader", listaHead);
		session.setAttribute("tableBody", listaBody);
		request.getRequestDispatcher("previewDocumentData.jsp").forward(request, response);

	}

}
