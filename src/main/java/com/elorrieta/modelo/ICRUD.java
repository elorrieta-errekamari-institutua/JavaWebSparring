package com.elorrieta.modelo;

import java.util.List;

public interface ICRUD<P> {
	/**
	 * 
	 * 
	 * @param id El id del objeto a devolver
	 * @return Objeto con el id elegido
	 * @throws Exception
	 */
	P getByid(int id) throws Exception;

	/**
	 * 
	 * 
	 * @param id El nombre del objeto a devolver
	 * @return Objeto con el nombre elegido
	 * @throws Exception
	 */
	P getByName(String nombre) throws Exception;

	/**
	 * 
	 * @return Lista con todos los registros de la DB como objetos
	 * @throws Exception
	 */
	List<P> getAll() throws Exception;

	/**
	 * 
	 * @param id El id del objeto a borrar
	 * @return El objeto borrado.
	 * @throws Exception
	 */
	P delete(int id) throws Exception;

	/***
	 * 
	 * @param pojoModifciar POJO con los nuevos datos a guardar en la DB
	 * @return El POJO el registro modificado en la DB
	 * @throws Exception
	 */
	P update(P pojoModificar) throws Exception;

	/***
	 * 
	 * @param pojoNuevo POJO del nuevo objeto a insertar
	 * @return id del nuevo usuario insertado
	 * @throws Exception
	 */
	int insert(P pojoNuevo) throws Exception;
}
