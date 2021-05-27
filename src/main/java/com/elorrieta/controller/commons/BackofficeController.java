package com.elorrieta.controller.commons;

import java.io.IOException;
import java.util.HashMap;

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
import com.elorrieta.utilities.OperationsFormador;
import com.elorrieta.utilities.OperationsHorario;
import com.elorrieta.utilities.OperationsParticipante;
import com.elorrieta.utilities.OperationsRol;
import com.elorrieta.utilities.OperationsUsuario;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BackofficeController
 */
@WebServlet("/backoffice/action")
public class BackofficeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HashMap<String, Integer> map = new HashMap<String, Integer>();

	/**
	 * Posibles operaciones
	 */
	public static final int INSERT_UPDATE = 1;
	public static final int SELECT = 2;
	public static final int DELETE = 3;
	public static final int SELECT_ALL = 4;
	public static final int INSERT_ALL = 5;

	/**
	 * Posibles clases
	 */
	public static final int CURSO = 1;
	public static final int USUARIO = 2;
	public static final int PARTICIPANTE = 3;
	public static final int AULA = 4;
	public static final int HORARIO = 5;
	public static final int FORMADOR = 6;
	public static final int ROL = 7;
	public static final int EDICION = 8;

	/**
	 * DAOs
	 */
	private DAOCurso daoCurso;
	private DAOUsuario daoUsuario;
	private DAOParticipante daoParticipante;
	private DAOAula daoAula;
	private DAOHorario daoHorario;
	private DAOFormador daoFormador;
	private DAORol daoRol;
	private DAOEdicion daoEdicion;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		daoCurso = new DAOCurso();
		daoUsuario = new DAOUsuario();
		daoParticipante = new DAOParticipante();
		daoAula = new DAOAula();
		daoHorario = new DAOHorario();
		daoFormador = new DAOFormador();
		daoRol = new DAORol();
		daoEdicion = new DAOEdicion();
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
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
	 * @see HttpServlet#HttpServlet()
	 */
	public BackofficeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @throws IOException
	 * @throws ServletException
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		getParameters(request);

		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		getParameters(request);

		if (map.get("clase") != -1) {

			switch (map.get("clase")) {
			case CURSO:
				// TODO elegir operacion con Curso
				switch (map.get("operacion")) {

				case INSERT_UPDATE:
					// Operacion Insert (id == -1) / Update (id>0)
					OperationsCurso.insertUpdate(request, response, map.get("id"), daoCurso);
					break;
				case INSERT_ALL:
					// Operacion insertar una lista
					OperationsCurso.insertAll(request, response, daoCurso);
					break;
				case DELETE:
					// Operacion Delete
					OperationsCurso.delete(request, response, map.get("id"), daoCurso);
					break;
				case SELECT:
					// Operacion Select
					OperationsCurso.select(request, response, map.get("id"), daoCurso);
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
				// TODO elegir operacion con Usuario
				switch (map.get("operacion")) {

				case INSERT_UPDATE:
					// Operacion Insert (id == -1) / Update (id>0)
					OperationsUsuario.insertUpdate(request, response, map.get("id"), daoUsuario);
					break;
				case INSERT_ALL:
					// Operacion insertar una lista
					throw new IOException(
							"Operacion no permitida " + map.get("operacion") + " para " + map.get("clase"));

				case DELETE:
					// Operacion Delete
					OperationsUsuario.delete(request, response, map.get("id"), daoUsuario);
					break;
				case SELECT:
					// Operacion Select
					OperationsUsuario.select(request, response, map.get("id"), daoUsuario);
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
				// TODO elegir operacion con Participante
				switch (map.get("operacion")) {

				case INSERT_UPDATE:
					// Operacion Insert (id == -1) / Update (id>0)
					OperationsParticipante.insertUpdate(request, response, map.get("id"), daoParticipante);
					break;
				case INSERT_ALL:
					// Operacion insertar una lista
					OperationsParticipante.insertAll(request, response, daoParticipante);
					break;
				case DELETE:
					// Operacion Delete
					OperationsParticipante.delete(request, response, map.get("id"), daoParticipante);
					break;
				case SELECT:
					// Operacion Select
					OperationsParticipante.select(request, response, map.get("id"), daoParticipante);
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
				// TODO elegir operacion con Aula
				switch (map.get("operacion")) {

				case INSERT_UPDATE:
					// Operacion Insert (id == -1) / Update (id>0)
					OperationsAula.insertUpdate(request, response, map.get("id"), daoAula);
					break;
				case INSERT_ALL:
					// Operacion insertar una lista
					OperationsAula.insertAll(request, response, daoAula);
					break;
				case DELETE:
					// Operacion Delete
					OperationsAula.delete(request, response, map.get("id"), daoAula);
					break;
				case SELECT:
					// Operacion Select
					OperationsAula.select(request, response, map.get("id"), daoAula);
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
				// TODO elegir operacion con Horario
				switch (map.get("operacion")) {

				case INSERT_UPDATE:
					// Operacion Insert (id == -1) / Update (id>0)
					OperationsHorario.insertUpdate(request, response, map.get("id"), daoHorario);
					break;
				case INSERT_ALL:
					// Operacion insertar una lista
					OperationsHorario.insertAll(request, response, daoHorario);
					break;
				case DELETE:
					// Operacion Delete
					OperationsHorario.delete(request, response, map.get("id"), daoHorario);
					break;
				case SELECT:
					// Operacion Select
					OperationsHorario.select(request, response, map.get("id"), daoHorario);
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
				// TODO elegir operacion con Formador
				switch (map.get("operacion")) {

				case INSERT_UPDATE:
					// Operacion Insert (id == -1) / Update (id>0)
					OperationsFormador.insertUpdate(request, response, map.get("id"), daoFormador);
					break;
				case INSERT_ALL:
					// Operacion insertar una lista
					OperationsFormador.insertAll(request, response, daoFormador);
					break;
				case DELETE:
					// Operacion Delete
					OperationsFormador.delete(request, response, map.get("id"), daoFormador);
					break;
				case SELECT:
					// Operacion Select
					OperationsFormador.select(request, response, map.get("id"), daoFormador);
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
				// TODO elegir operacion con Rol
				switch (map.get("operacion")) {

				case INSERT_UPDATE:
					// Operacion Insert (id == -1) / Update (id>0)
					OperationsRol.insertUpdate(request, response, map.get("id"), daoRol);
					break;
				case INSERT_ALL:
					// Operacion insertar una lista
					OperationsRol.insertAll(request, response, daoRol);
					break;
				case DELETE:
					// Operacion Delete
					OperationsRol.delete(request, response, map.get("id"), daoRol);
					break;
				case SELECT:
					// Operacion Select
					OperationsRol.select(request, response, map.get("id"), daoRol);
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
				// TODO elegir operacion con Edicion
				switch (map.get("operacion")) {

				case INSERT_UPDATE:
					// Operacion Insert (id == -1) / Update (id>0)
					OperationsEdicion.insertUpdate(request, response, map.get("id"), daoEdicion);
					break;
				case INSERT_ALL:
					// Operacion insertar una lista
					OperationsEdicion.insertAll(request, response, daoEdicion, daoCurso, daoHorario);
					break;
				case DELETE:
					// Operacion Delete
					OperationsEdicion.delete(request, response, map.get("id"), daoEdicion);
					break;
				case SELECT:
					// Operacion Select
					OperationsEdicion.select(request, response, map.get("id"), daoEdicion);
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
	 */
	private void getParameters(HttpServletRequest request) {

		try {
			map.put("id", Integer.parseInt(request.getParameter("id")));
		} catch (Exception e) {
			map.put("id", -1);
			e.printStackTrace();
		}

		try {
			map.put("operacion", Integer.parseInt(request.getParameter("operacion")));
		} catch (Exception e) {
			map.put("operacion", -1);
			e.printStackTrace();
		}

		try {
			map.put("clase", Integer.parseInt(request.getParameter("clase")));
		} catch (Exception e) {
			map.put("clase", -1);
			e.printStackTrace();
		}
	}
}
