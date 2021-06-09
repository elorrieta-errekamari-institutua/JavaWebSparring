package com.elorrieta.modelo.interfaces;

import com.elorrieta.modelo.pojo.Participante;

/**
 * Interfaz IDAOParticipante extiende ICRUD
 * 
 * Contiene el metodo para seleccionar un participante por DNI
 * 
 * @see ICRUD
 */
public interface IDAOParticipante extends ICRUD<Participante> {

	/**
	 * Devuelve un objeto de tipo participante
	 * 
	 * @param dni El DNI del participante que se quiere recuperar
	 * @return POJO Participante
	 */
	Participante getByDni(String dni) throws Exception;

}
