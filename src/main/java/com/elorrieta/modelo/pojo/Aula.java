package com.elorrieta.modelo.pojo;

import java.util.ArrayList;

/**
 * Clase Aula
 * 
 * Contiene los atributos de una aula y metodos para acceder a ellos
 * Contiene metodos para rellenar una tabla
 */
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

	/**
	 * @return ArrayList with all the headers needed to display a list of objects in
	 *         a table
	 */
	public static ArrayList<String> setHeadersList() {
		ArrayList<String> listaHead = new ArrayList<String>();
		listaHead.add("#");
		listaHead.add("Nombre");
		return listaHead;
	}

	/**
	 * @return Arraylist with all the data needed to display the object in a table
	 *         row
	 */
	public ArrayList<String> setDataList() {
		ArrayList<String> listaTemporal = new ArrayList<String>();
		listaTemporal.add(String.valueOf(id));
		listaTemporal.add(nombre);
		return listaTemporal;
	}

}
