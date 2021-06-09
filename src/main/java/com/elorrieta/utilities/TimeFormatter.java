package com.elorrieta.utilities;

import java.time.LocalTime;

public class TimeFormatter {

	/**
	 * Transforma un string a localtime tiendo en cuenta los errores tipicos
	 * encontrados en los documentos
	 * 
	 * @param hora String con la hora
	 * @return LocalTime con la hora correcta o 00:00 si el string estaba vacio
	 */
	public static LocalTime normalizar(String hora) {
		hora = hora.trim();
		if (hora.isEmpty()) {
			return LocalTime.MIN;
		} else if (hora.length() < 5) {
			hora = "0".concat(hora);
		}
		return LocalTime.parse(hora);
	}
}
