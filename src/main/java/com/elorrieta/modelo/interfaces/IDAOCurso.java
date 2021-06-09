package com.elorrieta.modelo.interfaces;

import com.elorrieta.modelo.pojo.Curso;

/**
 * Interfaz IDAOCurso extiende ICRUD
 * 
 * Contiene metodo para seleccionar un curso por sus codigos y su nombre
 * 
 * @see ICRUD
 */
public interface IDAOCurso extends ICRUD<Curso> {

	/**
	 * Busca un curso con los parametros indicados en la base de datos
	 * 
	 * @param nombre     el nombre del curso
	 * @param codigoUc   el codigo UC del curso
	 * @param codigoAaff el codigo AAFF del curso
	 * @return Curso el curso encontrado
	 * @throws Exception
	 */
	Curso getByCodigos(String nombre, String codigoUc, String codigoAaff) throws Exception;

}
