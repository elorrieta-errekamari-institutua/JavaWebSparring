package com.elorrieta.modelo.interfaces;

import com.elorrieta.modelo.pojo.Curso;

public interface IDAOCurso extends ICRUD<Curso> {

	/**
	 * Devuelve un objeto de tipo Curso
	 * 
	 * @param nombre El codigo lanbide del curso que se quiere recuperar
	 * @return POJO Curso
	 */
	Curso getByCodigoLanbide(String codigoLanbide) throws Exception;

	/**
	 * Devuelve un objeto de tipo Curso
	 * 
	 * @param nombre El codigo UC del curso que se quiere recuperar
	 * @return POJO Curso
	 */
	Curso getByCodigoUc(String codigoUc) throws Exception;

	/**
	 * Devuelve un objeto de tipo Curso
	 * 
	 * @param nombre El codigo AAFF del curso que se quiere recuperar
	 * @return POJO Curso
	 */
	Curso getByCodigoAaff(String codigoAaff) throws Exception;
}
