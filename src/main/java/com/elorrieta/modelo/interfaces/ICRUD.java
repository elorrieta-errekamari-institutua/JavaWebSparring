package com.elorrieta.modelo.interfaces;

import java.util.ArrayList;

public interface ICRUD<P> {
	/**
	 * Busca un objeto en la base de datos por su id
	 * 
	 * @param id El id del objeto a devolver
	 * @return Objeto con el id elegido
	 * @throws Exception
	 */
	P getByid(int id) throws Exception;

	/**
	 * Busca un objeto en la base de datos por su nombre
	 * 
	 * @param id El nombre del objeto a devolver
	 * @return Objeto con el nombre elegido
	 * @throws Exception
	 */
	P getByName(String nombre) throws Exception;

	/**
	 * Busca todos los objetos en la base de datos
	 * 
	 * @return ArrayList<Objeto> Lista con todos los registros de la DB como objetos
	 * @throws Exception
	 */
	ArrayList<P> getAll() throws Exception;

	/**
	 * Elimina el objeto tras buscarlo por su id
	 * 
	 * @param id El id del objeto a borrar
	 * @return El objeto borrado.
	 * @throws Exception
	 */
	P delete(int id) throws Exception;

	/***
	 * Modifica un objeto en la base de datos
	 * 
	 * @param pojoModifciar POJO con los nuevos datos a guardar en la DB
	 * @return El POJO el registro modificado en la DB
	 * @throws Exception
	 */
	P update(P pojoModificar) throws Exception;

	/***
	 * Insera un objeto en la base dedatos
	 * 
	 * @param pojoNuevo POJO del nuevo objeto a insertar
	 * @return id del objeto insertado o el original si ya existia
	 * @throws Exception
	 */
	int insert(P pojoNuevo) throws Exception;

}
