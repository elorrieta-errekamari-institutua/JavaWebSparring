package com.elorrieta.controller.commons;

import java.io.IOException;

import com.elorrieta.modelo.dao.DAOAula;
import com.elorrieta.modelo.dao.DAOCurso;
import com.elorrieta.modelo.dao.DAOEdicion;
import com.elorrieta.modelo.dao.DAOFormador;
import com.elorrieta.modelo.dao.DAOHorario;
import com.elorrieta.modelo.dao.DAOParticipante;
import com.elorrieta.modelo.dao.DAORol;
import com.elorrieta.modelo.dao.DAOUsuario;
import com.elorrieta.utilities.OperationsAula;
import com.elorrieta.utilities.OperationsCurso;
import com.elorrieta.utilities.OperationsEdicion;
import com.elorrieta.utilities.OperationsExcel;
import com.elorrieta.utilities.OperationsFormador;
import com.elorrieta.utilities.OperationsHorario;
import com.elorrieta.utilities.OperationsParticipante;
import com.elorrieta.utilities.OperationsRol;
import com.elorrieta.utilities.OperationsUsuario;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet unico para el backoffice, recogera los parametros clase, operacion,
 * id y edicion y llamara a las clases del paquete utilities para realizar las
 * operaciones necesarias, en caso de no existir parametro clase u operacion
 * redirigira a index
 */
@WebServlet("/backoffice/action")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		maxFileSize = 1024 * 1024 * 10, // 10 MB
		maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class BackofficeController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Valor para cuando no se pasa como parametro "clase"
	 */
	private static final int NO_CLASE = -1;
	/**
	 * Valor para cuando no se pasa como parametro "operacion"
	 */
	private static final int NO_OPERACION = -1;
	/**
	 * Valor para cuando no se pasa como parametro "id"
	 */
	private static final int NO_ID = -1;

	/**
	 * Contendra el parametro id del request
	 */
	int id;
	/**
	 * Contendra el parametro operacion del request
	 */
	int operacion;
	/**
	 * Contendra el parametro clase del request
	 */
	int clase;
	/**
	 * Se utilizara para hacer un select de curso pero redirigir al formulario
	 * de edicion
	 */
	boolean edicion;

	/**
	 * Codigo de la accion insertUpdate
	 */
	public static final int INSERT_UPDATE = 1;
	/**
	 * Codigo de la accion select
	 */
	public static final int SELECT = 2;
	/**
	 * Codigo de la accion delete
	 */
	public static final int DELETE = 3;
	/**
	 * Codigo de la accion selectAll
	 */
	public static final int SELECT_ALL = 4;
	/**
	 * Codigo de la accion insertAll
	 */
	public static final int INSERT_ALL = 5;

	/**
	 * Codigo de la clase curso
	 */
	public static final int CURSO = 1;
	/**
	 * Codigo de la clase usuario
	 */
	public static final int USUARIO = 2;
	/**
	 * Codigo de la clase participante
	 */
	public static final int PARTICIPANTE = 3;
	/**
	 * Codigo de la clase aula
	 */
	public static final int AULA = 4;
	/**
	 * Codigo de la clase horario
	 */
	public static final int HORARIO = 5;
	/**
	 * Codigo de la clase formador
	 */
	public static final int FORMADOR = 6;
	/**
	 * Codigo de la clase rol
	 */
	public static final int ROL = 7;
	/**
	 * Codigo de la clase edicion
	 */
	public static final int EDICION = 8;
	/**
	 * Codigo de la clase excel
	 */
	public static final int EXCEL = 9;

	/**
	 * DAO de curso
	 */
	private DAOCurso daoCurso;
	/**
	 * DAO de usuario
	 */
	private DAOUsuario daoUsuario;
	/**
	 * DAO de participante
	 */
	private DAOParticipante daoParticipante;
	/**
	 * DAO de aula
	 */
	private DAOAula daoAula;
	/**
	 * DAO de horario
	 */
	private DAOHorario daoHorario;
	/**
	 * DAO de formador
	 */
	private DAOFormador daoFormador;
	/**
	 * DAO de rol
	 */
	private DAORol daoRol;
	/**
	 * DAO de edicion
	 */
	private DAOEdicion daoEdicion;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try {
			daoCurso = new DAOCurso();
			daoUsuario = new DAOUsuario();
			daoParticipante = new DAOParticipante();
			daoAula = new DAOAula();
			daoHorario = new DAOHorario();
			daoFormador = new DAOFormador();
			daoRol = new DAORol();
			daoEdicion = new DAOEdicion();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void destroy() {
		super.destroy();
		daoCurso = null;
		daoUsuario = null;
		daoParticipante = null;
		daoAula = null;
		daoHorario = null;
		daoFormador = null;
		daoRol = null;
		daoEdicion = null;
	}

	/**
	 * Llama al metodo doAction
	 * 
	 * @param request  HttpServletRequest
	 * @param response HttpServletResponse
	 * @throws ServletException
	 * @throws IOException
	 * @see #doAction(HttpServletRequest, HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doAction(request, response);
	}

	/**
	 * Llama al metodo doAction
	 * 
	 * @param request  HttpServletRequest
	 * @param response HttpServletResponse
	 * @throws ServletException
	 * @throws IOException
	 * @see #doAction(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doAction(request, response);
	}

	/**
	 * Recoger los parametros clase, operacion, id y edicion y llama a las clases
	 * del paquete utilities para realizar las operaciones necesarias, en caso de no
	 * existir parametro clase u operacion redirigira a index
	 * 
	 * @param request  HttpServletRequest
	 * @param response HttpServletResponse
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		getParameters(request);

		if (clase == NO_CLASE || operacion == NO_OPERACION) {
			// TODO logger
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {

			switch (clase) {
				case EXCEL:
					String uploadPath = getServletContext().getRealPath("") + "/resources/excel/input/";
					OperationsExcel.parseExcel(request, response, uploadPath, daoParticipante, daoEdicion);
					break;
				case CURSO:
					// Elegir operacion con Curso
					switch (operacion) {

						case INSERT_UPDATE:
							// Operacion Insert (id == -1) / Update (id>0)
							OperationsCurso.insertUpdate(request, response, id, daoCurso);
							break;
						case INSERT_ALL:
							// Operacion insertar una lista
							OperationsCurso.insertAll(request, response, daoCurso);
							break;
						case DELETE:
							// Operacion Delete
							OperationsCurso.delete(request, response, id, daoCurso);
							break;
						case SELECT:
							// Operacion Select
							OperationsCurso.select(request, response, id, edicion, daoCurso);
							break;
						case SELECT_ALL:
							// Operacion Select
							OperationsCurso.selectAll(request, response, daoCurso);
							break;

						default:
							break;
					}
					break;
				case USUARIO:
					// Elegir operacion con Usuario
					switch (operacion) {

						case INSERT_UPDATE:
							// Operacion Insert (id == -1) / Update (id>0)
							OperationsUsuario.insertUpdate(request, response, id, daoUsuario);
							break;
						case INSERT_ALL:
							// Operacion insertar una lista
							throw new IOException("Operacion no permitida " + operacion + " para " + clase);

						case DELETE:
							// Operacion Delete
							OperationsUsuario.delete(request, response, id, daoUsuario);
							break;
						case SELECT:
							// Operacion Select
							OperationsUsuario.select(request, response, id, daoUsuario);
							break;
						case SELECT_ALL:
							// Operacion Select
							OperationsUsuario.selectAll(request, response, daoUsuario);
							break;

						default:
							break;
					}
					break;
				case PARTICIPANTE:
					// Elegir operacion con Participante
					switch (operacion) {

						case INSERT_UPDATE:
							// Operacion Insert (id == -1) / Update (id>0)
							OperationsParticipante.insertUpdate(request, response, id, daoParticipante);
							break;
						case INSERT_ALL:
							// Operacion insertar una lista
							OperationsParticipante.insertAll(request, response, daoParticipante);
							break;
						case DELETE:
							// Operacion Delete
							OperationsParticipante.delete(request, response, id, daoParticipante);
							break;
						case SELECT:
							// Operacion Select
							OperationsParticipante.select(request, response, id, daoParticipante);
							break;
						case SELECT_ALL:
							// Operacion Select
							OperationsParticipante.selectAll(request, response, daoParticipante);
							break;

						default:
							break;
					}
					break;
				case AULA:
					// Elegir operacion con Aula
					switch (operacion) {

						case INSERT_UPDATE:
							// Operacion Insert (id == -1) / Update (id>0)
							OperationsAula.insertUpdate(request, response, id, daoAula);
							break;
						case INSERT_ALL:
							// Operacion insertar una lista
							OperationsAula.insertAll(request, response, daoAula);
							break;
						case DELETE:
							// Operacion Delete
							OperationsAula.delete(request, response, id, daoAula);
							break;
						case SELECT:
							// Operacion Select
							OperationsAula.select(request, response, id, daoAula);
							break;
						case SELECT_ALL:
							// Operacion Select
							OperationsAula.selectAll(request, response, daoAula);
							break;

						default:
							break;
					}
					break;
				case HORARIO:
					// Elegir operacion con Horario
					switch (operacion) {

						case INSERT_UPDATE:
							// Operacion Insert (id == -1) / Update (id>0)
							OperationsHorario.insertUpdate(request, response, id, daoHorario);
							break;
						case INSERT_ALL:
							// Operacion insertar una lista
							OperationsHorario.insertAll(request, response, daoHorario);
							break;
						case DELETE:
							// Operacion Delete
							OperationsHorario.delete(request, response, id, daoHorario);
							break;
						case SELECT:
							// Operacion Select
							OperationsHorario.select(request, response, id, daoHorario);
							break;
						case SELECT_ALL:
							// Operacion Select
							OperationsHorario.selectAll(request, response, daoHorario);
							break;

						default:
							break;
					}
					break;
				case FORMADOR:
					// Elegir operacion con Formador
					switch (operacion) {

						case INSERT_UPDATE:
							// Operacion Insert (id == -1) / Update (id>0)
							OperationsFormador.insertUpdate(request, response, id, daoFormador);
							break;
						case INSERT_ALL:
							// Operacion insertar una lista
							OperationsFormador.insertAll(request, response, daoFormador);
							break;
						case DELETE:
							// Operacion Delete
							OperationsFormador.delete(request, response, id, daoFormador);
							break;
						case SELECT:
							// Operacion Select
							OperationsFormador.select(request, response, id, daoFormador);
							break;
						case SELECT_ALL:
							// Operacion Select
							OperationsFormador.selectAll(request, response, daoFormador);
							break;

						default:
							break;
					}
					break;
				case ROL:
					// Elegir operacion con Rol
					switch (operacion) {

						case INSERT_UPDATE:
							// Operacion Insert (id == -1) / Update (id>0)
							OperationsRol.insertUpdate(request, response, id, daoRol);
							break;
						case INSERT_ALL:
							// Operacion insertar una lista
							OperationsRol.insertAll(request, response, daoRol);
							break;
						case DELETE:
							// Operacion Delete
							OperationsRol.delete(request, response, id, daoRol);
							break;
						case SELECT:
							// Operacion Select
							OperationsRol.select(request, response, id, daoRol);
							break;
						case SELECT_ALL:
							// Operacion Select
							OperationsRol.selectAll(request, response, daoRol);
							break;

						default:
							break;
					}
					break;
				case EDICION:
					// Elegir operacion con Edicion
					switch (operacion) {

						case INSERT_UPDATE:
							// Operacion Insert (id == -1) / Update (id>0)
							OperationsEdicion.insertUpdate(request, response, daoEdicion, daoCurso, daoHorario,
									daoAula);
							break;
						case INSERT_ALL:
							// Operacion insertar una lista
							OperationsEdicion.insertAll(request, response, daoEdicion, daoCurso, daoHorario, daoAula);
							break;
						case DELETE:
							// Operacion Delete
							OperationsEdicion.delete(request, response, id, daoEdicion, daoHorario);
							break;
						case SELECT:
							// Operacion Select
							OperationsEdicion.select(request, response, id, daoEdicion);
							break;
						case SELECT_ALL:
							// Operacion Select
							OperationsEdicion.selectAll(request, response, daoEdicion);
							break;

						default:
							break;
					}
					break;
				default:
					break;
			}
		}
	}

	/**
	 * Obtiene los parametros del request uWu
	 * 
	 * @param request HttpServletRequest
	 */
	private void getParameters(HttpServletRequest request) {

		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			id = NO_ID;
		}

		try {
			operacion = Integer.parseInt(request.getParameter("operacion"));
		} catch (Exception e) {
			operacion = NO_OPERACION;
		}

		try {
			clase = Integer.parseInt(request.getParameter("clase"));
		} catch (Exception e) {
			clase = NO_CLASE;
		}

		edicion = Boolean.parseBoolean(request.getParameter("edicion"));

	}
}
