package com.elorrieta.ejercicios;

public class SumaTemperaturas {
	public static void main(String[] args) {
		int numeroTemperaturasPedidas = 0;
		float totalTemperaturas = 0;
		float temperaturaActual = 0;
		while (temperaturaActual != 888) {
			numeroTemperaturasPedidas++;
			totalTemperaturas += temperaturaActual;
		}
		System.out.printf("La media es %.2f, se han pedido %d temperaturas",
				totalTemperaturas / numeroTemperaturasPedidas, numeroTemperaturasPedidas);
	}
}
