package com.elorrieta.utilities;

import com.elorrieta.modelo.dao.DAORol;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Clase OperationsRol
 * 
 * Contiene todos los metodos necesarios para que el controlador unico manipule
 * roles
 */
public class OperationsRol {

	/**
	 * Actualiza o inserta el rol con los parametros recogidos del request y
	 * redirige a la lista de cursos
	 * 
	 * @param request  HttpServletRequest
	 * @param response HttpServletResponse
	 * @param id       el id del rol que queremos actualizar, si se omite o es
	 *                 negativo se insertara
	 * @param daoRol   DAORol
	 */
	public static void insertUpdate(HttpServletRequest request, HttpServletResponse response, int id, DAORol daoRol) {
		// TODO Auto-generated method stub

	}

	/**
	 * Caracteristica sin implementar
	 * 
	 * @param request  HttpServletRequest
	 * @param response HttpServletResponse
	 * @param daoRol   DAORol
	 */
	public static void insertAll(HttpServletRequest request, HttpServletResponse response, DAORol daoRol) {
		// TODO Auto-generated method stub

	}

	/**
	 * Elimina el rol con el id elegido y redirige a la lista de roles
	 * 
	 * @param request  HttpServletRequest
	 * @param response HttpServletResponse
	 * @param id       el id del rol que queremos eliminar
	 * @param daoRol   DAORol
	 */
	public static void delete(HttpServletRequest request, HttpServletResponse response, int id, DAORol daoRol) {
		// TODO Auto-generated method stub

	}

	/**
	 * Busca el rol con el id elegido, lo mete en sesion y redirige al formulario
	 * para editarlo
	 * 
	 * @param request  HttpServletRequest
	 * @param response HttpServletResponse
	 * @param id       el id del rol que queremos buscar
	 * @param daoRol   DAORol
	 */
	public static void select(HttpServletRequest request, HttpServletResponse response, int id, DAORol daoRol) {
		// TODO Auto-generated method stub

	}

	/**
	 * Busca todos los roles en la base de datos e introduce toda su informacion en
	 * la sesion para ser mostrada en una tabla. Redirige a la lista
	 * 
	 * @param request  HttpServletRequest
	 * @param response HttpServletResponse
	 * @param daoRol   DAORol
	 */
	public static void selectAll(HttpServletRequest request, HttpServletResponse response, DAORol daoRol) {
		// TODO Auto-generated method stub

	}

}
