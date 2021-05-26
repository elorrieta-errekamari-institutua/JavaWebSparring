package com.elorrieta.utilities;

import java.time.LocalTime;

public class TimeFormatter {

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
