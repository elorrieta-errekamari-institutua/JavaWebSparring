package com.elorrieta.utilities;

import com.elorrieta.modelo.dao.DAOHorario;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Clase OperationsHorario
 * 
 * Contiene todos los metodos necesarios para que el controlador unico manipule
 * horarios
 */
public class OperationsHorario {

	/**
	 * Actualiza o inserta el horario con los parametros recogidos del request y
	 * redirige a la lista de cursos
	 * 
	 * @param request     HttpServletRequest
	 * @param response    HttpServletResponse
	 * @param id          el id del horario que queremos actualizar, si se omite o
	 *                    es negativo se insertara
	 * @param daoHorario DAOHorario
	 */
	public static void insertUpdate(HttpServletRequest request, HttpServletResponse response, int id,
			DAOHorario daoHorario) {
		// TODO Auto-generated method stub

	}

	/**
	 * Caracteristica sin implementar
	 * 
	 * @param request     HttpServletRequest
	 * @param response    HttpServletResponse
	 * @param daoHorario DAOHorario
	 */
	public static void insertAll(HttpServletRequest request, HttpServletResponse response, DAOHorario daoHorario) {
		// TODO Auto-generated method stub

	}

	/**
	 * Elimina el horario con el id elegido y redirige a la lista de horarios
	 * 
	 * @param request     HttpServletRequest
	 * @param response    HttpServletResponse
	 * @param id          el id del horario que queremos eliminar
	 * @param daoHorario DAOHorario
	 */
	public static void delete(HttpServletRequest request, HttpServletResponse response, int id, DAOHorario daoHorario) {
		// TODO Auto-generated method stub

	}

	/**
	 * Busca el horario con el id elegido, lo mete en sesion y redirige al
	 * formulario para editarlo
	 * 
	 * @param request     HttpServletRequest
	 * @param response    HttpServletResponse
	 * @param id          el id del horario que queremos buscar
	 * @param daoHorario DAOHorario
	 */
	public static void select(HttpServletRequest request, HttpServletResponse response, int id, DAOHorario daoHorario) {
		// TODO Auto-generated method stub

	}

	/**
	 * Busca todos los horarios en la base de datos e introduce toda su informacion
	 * en la sesion para ser mostrada en una tabla. Redirige a la lista
	 * 
	 * @param request    HttpServletRequest
	 * @param response   HttpServletResponse
	 * @param daoHorario DAOHorario
	 */
	public static void selectAll(HttpServletRequest request, HttpServletResponse response, DAOHorario daoHorario) {
		// TODO Auto-generated method stub

	}

}
