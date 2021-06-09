package com.elorrieta.utilities;

import com.elorrieta.modelo.dao.DAOFormador;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Clase OperationsFormador
 * 
 * Contiene todos los metodos necesarios para que el controlador unico manipule formadores
 */
public class OperationsFormador {

	/**
	 * Actualiza o inserta el formador con los parametros recogidos del request y
	 * redirige a la lista de cursos
	 * 
	 * @param request  HttpServletRequest
	 * @param response HttpServletResponse
	 * @param id       el id del formador que queremos actualizar, si se omite o es
	 *                 negativo se insertara
	 * @param daoFormador DAOFormador
	 */
	public static void insertUpdate(HttpServletRequest request, HttpServletResponse response, Integer integer,
			DAOFormador daoFormador) {
		// TODO Auto-generated method stub

	}

	/**
	 * Caracteristica sin implementar
	 * @param request
	 * @param response
	 * @param daoFormador
	 */
	public static void insertAll(HttpServletRequest request, HttpServletResponse response, DAOFormador daoFormador) {
		// TODO Auto-generated method stub

	}

	public static void delete(HttpServletRequest request, HttpServletResponse response, Integer integer,
			DAOFormador daoFormador) {
		// TODO Auto-generated method stub

	}

	public static void select(HttpServletRequest request, HttpServletResponse response, Integer integer,
			DAOFormador daoFormador) {
		// TODO Auto-generated method stub

	}

	public static void selectAll(HttpServletRequest request, HttpServletResponse response, DAOFormador daoFormador) {
		// TODO Auto-generated method stub

	}

}
