package com.elorrieta.utilities;

import com.elorrieta.modelo.dao.DAOFormador;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Clase OperationsFormador
 * 
 * Contiene todos los metodos necesarios para que el controlador unico
 * (BackofficeController) manipule formadores
 * 
 * @see com.elorrieta.controller.commons.BackofficeController
 */
public class OperationsFormador {

	/**
	 * Actualiza o inserta el formador con los parametros recogidos del request y
	 * redirige a la lista de cursos
	 * 
	 * @param request     HttpServletRequest
	 * @param response    HttpServletResponse
	 * @param id          el id del formador que queremos actualizar, si se omite o
	 *                    es negativo se insertara
	 * @param daoFormador DAOFormador
	 */
	public static void insertUpdate(HttpServletRequest request, HttpServletResponse response, int id,
			DAOFormador daoFormador) {
		// TODO Auto-generated method stub

	}

	/**
	 * Caracteristica sin implementar
	 * 
	 * @param request     HttpServletRequest
	 * @param response    HttpServletResponse
	 * @param daoFormador DAOFormador
	 */
	public static void insertAll(HttpServletRequest request, HttpServletResponse response, DAOFormador daoFormador) {
		// TODO Auto-generated method stub

	}

	/**
	 * Elimina el formador con el id elegido y redirige a la lista de formadores
	 * 
	 * @param request     HttpServletRequest
	 * @param response    HttpServletResponse
	 * @param id          el id del formador que queremos eliminar
	 * @param daoFormador DAOFormador
	 */
	public static void delete(HttpServletRequest request, HttpServletResponse response, int id,
			DAOFormador daoFormador) {
		// TODO Auto-generated method stub

	}

	/**
	 * Busca el formador con el id elegido, lo mete en sesion y redirige al
	 * formulario para editarlo
	 * 
	 * @param request     HttpServletRequest
	 * @param response    HttpServletResponse
	 * @param id          el id del formador que queremos buscar
	 * @param daoFormador DAOFormador
	 */
	public static void select(HttpServletRequest request, HttpServletResponse response, int id,
			DAOFormador daoFormador) {
		// TODO Auto-generated method stub

	}

	/**
	 * Busca todos los formadores en la base de datos e introduce toda su
	 * informacion en la sesion para ser mostrada en una tabla. Redirige a la lista
	 * 
	 * @param request     HttpServletRequest
	 * @param response    HttpServletResponse
	 * @param daoFormador DAOFormador
	 */
	public static void selectAll(HttpServletRequest request, HttpServletResponse response, DAOFormador daoFormador) {
		// TODO Auto-generated method stub

	}

}
