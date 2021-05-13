package com.elorrieta.modelo.interfaces;

import com.elorrieta.modelo.pojo.Usuario;

public interface IDAOUsuario extends ICRUD<Usuario> {
	/***
	 * 
	 * @param nombre   El nombre del usuario que se va a logear
	 * @param password El password del usuario que se va a logear
	 * @return Un objeto de tipo Usuario que se corresponda con el nombre y el
	 *         password
	 */
	Usuario login(String nombre, String password);

}