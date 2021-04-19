package com.elorrieta.ejercicios;

import java.util.Scanner;

public class AgendaEmpleados {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Empleado nuevoEmpleado = new Empleado();
		Scanner teclado = new Scanner(System.in);
		String linea = "";
		String nombre = "";
		final float SMI = 600;
		boolean esBecario = false;
		float salario = 0;
		boolean repetir = false;
		do {
			System.out.println("Bienvenidx, inserta el nombre del empleado");
			nombre = teclado.nextLine();
			repetir = !(nombre.length() >= 5);
			if (repetir)
				System.out.println("El nombre debe tener 5 caracteres");
		} while (repetir);
		do {
			System.out.printf("%s, ¿es becario? (S/N)", nombre);
			linea = teclado.nextLine();
			boolean esS = "s".equalsIgnoreCase(linea);
			boolean esN = "n".equalsIgnoreCase(linea);
			if (esS || esN) {
				repetir = false;
				if (esS) {
					salario = 0;
					esBecario = true;
					System.out.printf("%s no tiene salario, es becario%n", nombre);
				}
				if (esN)
					do {
						System.out.printf("Indica el salario de %s:", nombre);
						linea = teclado.nextLine();
						salario = Float.parseFloat(linea);
						repetir = salario < SMI;
						if (repetir)
							System.out.println("El salario debe ser mayor de 600");
					} while (repetir);
			} else
				repetir = true;

		} while (repetir);
		nuevoEmpleado.setNombre(nombre);
		nuevoEmpleado.setBecario(esBecario);
		nuevoEmpleado.setSueldo(salario);
		System.out.println(nuevoEmpleado);
		teclado.close();
	}

}
