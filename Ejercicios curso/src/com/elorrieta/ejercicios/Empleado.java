package com.elorrieta.ejercicios;

public class Empleado {

	// Empleado tiene nombre Anonimo, booleano becario y sueldo
	// Constructor vacio, nombre inicial becario
	// Sin nombre, becario no Sueldo inical SMI 600€
	// Crear clase para solicitar datos del empleado
	// Nombre del empleado debe ser mayor 5 caracteres
	// Pregunta becario o no (si si sueldo 0)
	// Si no es becario pregunta sueldo (debe ser mayor a SMI
	private String nombre;
	private boolean becario;
	private float sueldo;

	public Empleado() {
		super();
		this.nombre = "";
		this.becario = false;
		this.sueldo = 600;
	}

	public Empleado(String nombre) {
		this();
		this.nombre = nombre;
	}

	public Empleado(String nombre, boolean becario) {
		this();
		this.nombre = nombre;
		this.becario = becario;
	}

	public Empleado(String nombre, boolean becario, float sueldo) {
		this();
		this.nombre = nombre;
		this.becario = becario;
		this.sueldo = sueldo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isBecario() {
		return becario;
	}

	public void setBecario(boolean becario) {
		this.becario = becario;
	}

	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}

	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", becario=" + becario + ", sueldo=" + sueldo + "]";
	}
}
