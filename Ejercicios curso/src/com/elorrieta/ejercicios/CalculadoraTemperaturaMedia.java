package com.elorrieta.ejercicios;

import java.util.Scanner;

public class CalculadoraTemperaturaMedia {

	private float temperaturaLunes;
	private float temperaturaMartes;
	private float temperaturaMiercoles;
	private float temperaturaJueves;
	private float temperaturaViernes;
	private float temperaturaSabado;
	private float temperaturaDomingo;
	private float temperaturaTotalSemana;
	final static int DIAS_SEMANA = 7;

	public CalculadoraTemperaturaMedia() {
	}

	public float getTemperaturaTotalSemana() {
		return temperaturaTotalSemana;
	}

	public void setTemperaturaTotalSemana(float temperatura) {
		this.temperaturaTotalSemana += temperatura;
	}

	public float getTemperaturaLunes() {
		return temperaturaLunes;
	}

	public void setTemperaturaLunes(float temperaturaLunes) {
		this.temperaturaLunes = temperaturaLunes;
	}

	public float getTemperaturaMartes() {
		return temperaturaMartes;
	}

	public void setTemperaturaMartes(float temperaturaMartes) {
		this.temperaturaMartes = temperaturaMartes;
	}

	public float getTemperaturaMiercoles() {
		return temperaturaMiercoles;
	}

	public void setTemperaturaMiercoles(float temperaturaMiercoles) {
		this.temperaturaMiercoles = temperaturaMiercoles;
	}

	public float getTemperaturaJueves() {
		return temperaturaJueves;
	}

	public void setTemperaturaJueves(float temperaturaJueves) {
		this.temperaturaJueves = temperaturaJueves;
	}

	public float getTemperaturaViernes() {
		return temperaturaViernes;
	}

	public void setTemperaturaViernes(float temperaturaViernes) {
		this.temperaturaViernes = temperaturaViernes;
	}

	public float getTemperaturaSabado() {
		return temperaturaSabado;
	}

	public void setTemperaturaSabado(float temperaturaSabado) {
		this.temperaturaSabado = temperaturaSabado;
	}

	public float getTemperaturaDomingo() {
		return temperaturaDomingo;
	}

	public void setTemperaturaDomingo(float temperaturaDomingo) {
		this.temperaturaDomingo = temperaturaDomingo;
	}

	public float pedirTemperatura(String dia) {
		float temperatura;
		System.out.printf("Introduce la temperatura del %s%n", dia);
		Scanner teclado = new Scanner(System.in);
		temperatura = teclado.nextFloat();
		teclado.close();
		return temperatura;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CalculadoraTemperaturaMedia calculadora = new CalculadoraTemperaturaMedia();
		calculadora.setTemperaturaTotalSemana(calculadora.pedirTemperatura("Lunes"));
		calculadora.setTemperaturaTotalSemana(calculadora.pedirTemperatura("Martes"));
		calculadora.setTemperaturaTotalSemana(calculadora.pedirTemperatura("Miercoles"));
		calculadora.setTemperaturaTotalSemana(calculadora.pedirTemperatura("Jueves"));
		calculadora.setTemperaturaTotalSemana(calculadora.pedirTemperatura("Viernes"));
		calculadora.setTemperaturaTotalSemana(calculadora.pedirTemperatura("Sabado"));
		calculadora.setTemperaturaTotalSemana(calculadora.pedirTemperatura("Domingo"));

		float media = calculadora.getTemperaturaTotalSemana() / DIAS_SEMANA;

		if (media < 20) {
			System.out.printf("Temperatura media: %.2f. Hace frio", media);
		}

		else {
			System.out.printf("Temperatura media: %.2f. Hace calor", media);
		}

	}

}
