package com.elorrieta.modelo;

import com.elorrieta.modelo.pojo.POJOUsuario;

public interface IDAOUsuario extends ICRUD<POJOUsuario> {
	/***
	 * 
	 * @param nombre   El nombre del usuario que se va a logear
	 * @param password El password del usuario que se va a logear
	 * @return Un objeto de tipo Usuario que se corresponda con el nombre y el
	 *         password
	 */
	POJOUsuario login(String nombre, String password);

}