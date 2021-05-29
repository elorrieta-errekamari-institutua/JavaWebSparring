package com.elorrieta.modelo.pojo;

import java.util.ArrayList;

public class Curso {

	private int id;
	private String cualificacion;
	private String codigoUc;
	private String competencia;
	private String codigoAaff;
	private String nombre;
	private int horasCurso;

	public Curso() {
		super();
		this.id = -1;
		this.cualificacion = "";
		this.codigoUc = "";
		this.competencia = "";
		this.codigoAaff = "";
		this.nombre = "";
		this.horasCurso = 0;
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
	 * @return the cualificacion
	 */
	public String getCualificacion() {
		return cualificacion;
	}

	/**
	 * @param cualificacion the cualificacion to set
	 */
	public void setCualificacion(String cualificacion) {
		this.cualificacion = cualificacion;
	}

	/**
	 * @return the codigoUc
	 */
	public String getCodigoUc() {
		return codigoUc;
	}

	/**
	 * @param codigoUc the codigoUc to set
	 */
	public void setCodigoUc(String codigoUc) {
		this.codigoUc = codigoUc;
	}

	/**
	 * @return the competencia
	 */
	public String getCompetencia() {
		return competencia;
	}

	/**
	 * @param competencia the competencia to set
	 */
	public void setCompetencia(String competencia) {
		this.competencia = competencia;
	}

	/**
	 * @return the codigoAaff
	 */
	public String getCodigoAaff() {
		return codigoAaff;
	}

	/**
	 * @param codigoAaff the codigoAaff to set
	 */
	public void setCodigoAaff(String codigoAaff) {
		this.codigoAaff = codigoAaff;
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

	/**
	 * @return the horasCurso
	 */
	public int getHorasCurso() {
		return horasCurso;
	}

	/**
	 * @param horasCurso the horasCurso to set
	 */
	public void setHorasCurso(int horasCurso) {
		this.horasCurso = horasCurso;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", cualificacion=" + cualificacion + ", codigoUc=" + codigoUc + ", competencia="
				+ competencia + ", codigoAaff=" + codigoAaff + ", nombre=" + nombre + ", horasCurso=" + horasCurso
				+ "]";
	}
	
	/**
	 * @return ArrayList with all the headers needed to display a list of objects in a table
	 */
	public static ArrayList<String> setHeadersList() {
		//TODO
		ArrayList<String> listaHead = new ArrayList<String>();
		listaHead.add("#");
		listaHead.add("Nombre");
		listaHead.add("Horas");
		listaHead.add("Codigo AAFF");
		listaHead.add("Codigo UC");
		listaHead.add("Competencia");
		listaHead.add("Cualificacion");
		return listaHead;
	}
	
	/**
	 * @return Arraylist with all the data needed to display the object in a table row
	 */
	public ArrayList<String> setDataList() {
		//TODO
		ArrayList<String> listaTemporal = new ArrayList<String>();
		listaTemporal.add(String.valueOf(id));
		listaTemporal.add(nombre);
		listaTemporal.add(String.valueOf(horasCurso));
		listaTemporal.add(codigoAaff);
		listaTemporal.add(codigoUc);
		listaTemporal.add(competencia);
		listaTemporal.add(cualificacion);
		return listaTemporal;
	}

}
