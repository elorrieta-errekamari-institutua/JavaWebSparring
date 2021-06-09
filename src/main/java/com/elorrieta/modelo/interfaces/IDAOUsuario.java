package com.elorrieta.modelo.interfaces;

import com.elorrieta.modelo.pojo.Usuario;

/**
 * Interfaz IDAOUsuario extiende ICRUD
 * 
 * Contiene el metodo para iniciar sesion
 * 
 * @see ICRUD
 */
public interface IDAOUsuario extends ICRUD<Usuario> {
	/***
	 * Comprueba que el usuario existe en la base de datos con los parametros
	 * indicados y le asigna su rol
	 * 
	 * @param nombre   El nombre del usuario que se va a logear
	 * @param password El password del usuario que se va a logear
	 * @return Un objeto de tipo Usuario que se corresponda con el nombre y el
	 *         password
	 * @throws Exception
	 */
	Usuario login(String nombre, String password) throws Exception;

}