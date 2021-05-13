package com.elorrieta.modelo.interfaces;

import com.elorrieta.modelo.pojo.Participante;

public interface IDAOParticipante extends ICRUD<Participante> {

	/**
	 * Devuelve un objeto de tipo participante
	 * 
	 * @param nombre El nombre del usuario que se quiere recuperar
	 * @return POJO Usuario
	 */
	Participante getByDni(String dni) throws Exception;

}
