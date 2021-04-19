package com.elorrieta.ejercicios;

public class Contador {
	public static void main(String[] args) {
		Boolean vuelta = false;
		int i = 0;
		while (i <= 10 && !vuelta) {
			System.out.println(i);
			i++;
		}
		vuelta = true;
		while (i >= 0 && vuelta) {
			if (i < 10)
				System.out.println(i);
			i--;
		}
	}
}
