package com.elorrieta.modelo.interfaces;

import com.elorrieta.modelo.pojo.Curso;

public interface IDAOCurso extends ICRUD<Curso> {

	/**
	 * Devuelve un curso con los parametros indicados
	 * 
	 * @param nombre
	 * @param codigoUc
	 * @param codigoAaff
	 * @return
	 * @throws Exception
	 */
	Curso getByCodigos(String nombre, String codigoUc, String codigoAaff) throws Exception;

}
