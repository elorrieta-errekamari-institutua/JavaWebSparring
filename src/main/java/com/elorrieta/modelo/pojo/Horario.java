package com.elorrieta.modelo.pojo;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Clase Horario
 * 
 * Contiene los atributos de un horario y metodos para acceder a ellos
 * Contiene metodos para rellenar una tabla
 */
public class Horario {

	private int id;
	private LocalTime lunesInicio;
	private LocalTime lunesFin;
	private LocalTime martesInicio;
	private LocalTime martesFin;
	private LocalTime miercolesInicio;
	private LocalTime miercolesFin;
	private LocalTime juevesInicio;
	private LocalTime juevesFin;
	private LocalTime viernesInicio;
	private LocalTime viernesFin;

	/**
	 * Constructor Horario
	 * 
	 * Inicializa todos los parametros
	 */
	public Horario() {
		super();
		this.id = -1;
		this.lunesInicio = LocalTime.MIN;
		this.lunesFin = LocalTime.MIN;
		this.martesInicio = LocalTime.MIN;
		this.martesFin = LocalTime.MIN;
		this.miercolesInicio = LocalTime.MIN;
		this.miercolesFin = LocalTime.MIN;
		this.juevesInicio = LocalTime.MIN;
		this.juevesFin = LocalTime.MIN;
		this.viernesInicio = LocalTime.MIN;
		this.viernesFin = LocalTime.MIN;
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
	 * @return the lunesInicio
	 */
	public LocalTime getLunesInicio() {
		return lunesInicio;
	}

	/**
	 * @param lunesInicio the lunesInicio to set
	 */
	public void setLunesInicio(LocalTime lunesInicio) {
		this.lunesInicio = lunesInicio;
	}

	/**
	 * @return the lunesFin
	 */
	public LocalTime getLunesFin() {
		return lunesFin;
	}

	/**
	 * @param lunesFin the lunesFin to set
	 */
	public void setLunesFin(LocalTime lunesFin) {
		this.lunesFin = lunesFin;
	}

	/**
	 * @return the martesInicio
	 */
	public LocalTime getMartesInicio() {
		return martesInicio;
	}

	/**
	 * @param martesInicio the martesInicio to set
	 */
	public void setMartesInicio(LocalTime martesInicio) {
		this.martesInicio = martesInicio;
	}

	/**
	 * @return the martesFin
	 */
	public LocalTime getMartesFin() {
		return martesFin;
	}

	/**
	 * @param martesFin the martesFin to set
	 */
	public void setMartesFin(LocalTime martesFin) {
		this.martesFin = martesFin;
	}

	/**
	 * @return the miercolesInicio
	 */
	public LocalTime getMiercolesInicio() {
		return miercolesInicio;
	}

	/**
	 * @param miercolesInicio the miercolesInicio to set
	 */
	public void setMiercolesInicio(LocalTime miercolesInicio) {
		this.miercolesInicio = miercolesInicio;
	}

	/**
	 * @return the miercolesFin
	 */
	public LocalTime getMiercolesFin() {
		return miercolesFin;
	}

	/**
	 * @param miercolesFin the miercolesFin to set
	 */
	public void setMiercolesFin(LocalTime miercolesFin) {
		this.miercolesFin = miercolesFin;
	}

	/**
	 * @return the juevesInicio
	 */
	public LocalTime getJuevesInicio() {
		return juevesInicio;
	}

	/**
	 * @param juevesInicio the juevesInicio to set
	 */
	public void setJuevesInicio(LocalTime juevesInicio) {
		this.juevesInicio = juevesInicio;
	}

	/**
	 * @return the juevesFin
	 */
	public LocalTime getJuevesFin() {
		return juevesFin;
	}

	/**
	 * @param juevesFin the juevesFin to set
	 */
	public void setJuevesFin(LocalTime juevesFin) {
		this.juevesFin = juevesFin;
	}

	/**
	 * @return the viernesInicio
	 */
	public LocalTime getViernesInicio() {
		return viernesInicio;
	}

	/**
	 * @param viernesInicio the viernesInicio to set
	 */
	public void setViernesInicio(LocalTime viernesInicio) {
		this.viernesInicio = viernesInicio;
	}

	/**
	 * @return the viernesFin
	 */
	public LocalTime getViernesFin() {
		return viernesFin;
	}

	/**
	 * @param viernesFin the viernesFin to set
	 */
	public void setViernesFin(LocalTime viernesFin) {
		this.viernesFin = viernesFin;
	}

	/**
	 * @return ArrayList with all the headers needed to display a list of objects in
	 *         a table
	 */
	public static ArrayList<String> setHeadersList() {
		ArrayList<String> listaHead = new ArrayList<String>();
		listaHead.add("#");
		listaHead.add("Lunes");
		listaHead.add("Martes");
		listaHead.add("Miercoles");
		listaHead.add("Jueves");
		listaHead.add("Viernes");
		return listaHead;
	}

	/**
	 * @return Arraylist with all the data needed to display the object in a table
	 *         row
	 */
	public ArrayList<String> setDataList() {
		ArrayList<String> listaTemporal = new ArrayList<String>();
		listaTemporal.add("-1");
		String horario = lunesInicio.toString() + " - " + lunesFin.toString();
		listaTemporal.add(horario);
		horario = martesInicio.toString() + " - " + martesFin.toString();
		listaTemporal.add(horario);
		horario = miercolesInicio.toString() + " - " + miercolesFin.toString();
		listaTemporal.add(horario);
		horario = juevesInicio.toString() + " - " + juevesFin.toString();
		listaTemporal.add(horario);
		horario = viernesInicio.toString() + " - " + viernesFin.toString();
		listaTemporal.add(horario);
		return listaTemporal;
	}

}
