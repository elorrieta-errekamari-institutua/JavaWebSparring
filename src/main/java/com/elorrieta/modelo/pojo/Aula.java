package com.elorrieta.modelo.pojo;

public class Aula {

	private int id;
	private String nombre;

	/**
	 * Constructor de Aula nueva
	 */
	public Aula() {
		super();
		this.id = -1;
		this.nombre = "";
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Aula [id=" + id + ", nombre=" + nombre + "]";
	}

}
