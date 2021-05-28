package com.elorrieta.modelo.pojo;

import java.time.LocalTime;
import java.util.ArrayList;

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
	private LocalTime sabadoInicio;
	private LocalTime sabadoFin;
	private LocalTime domingoInicio;
	private LocalTime domingoFin;

	public Horario() {
		super();
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
		this.sabadoInicio = LocalTime.MIN;
		this.sabadoFin = LocalTime.MIN;
		this.domingoInicio = LocalTime.MIN;
		this.domingoFin = LocalTime.MIN;
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
	 * @return the sabadoInicio
	 */
	public LocalTime getSabadoInicio() {
		return sabadoInicio;
	}

	/**
	 * @param sabadoInicio the sabadoInicio to set
	 */
	public void setSabadoInicio(LocalTime sabadoInicio) {
		this.sabadoInicio = sabadoInicio;
	}

	/**
	 * @return the sabadoFin
	 */
	public LocalTime getSabadoFin() {
		return sabadoFin;
	}

	/**
	 * @param sabadoFin the sabadoFin to set
	 */
	public void setSabadoFin(LocalTime sabadoFin) {
		this.sabadoFin = sabadoFin;
	}

	/**
	 * @return the domingoInicio
	 */
	public LocalTime getDomingoInicio() {
		return domingoInicio;
	}

	/**
	 * @param domingoInicio the domingoInicio to set
	 */
	public void setDomingoInicio(LocalTime domingoInicio) {
		this.domingoInicio = domingoInicio;
	}

	/**
	 * @return the domingoFin
	 */
	public LocalTime getDomingoFin() {
		return domingoFin;
	}

	/**
	 * @param domingoFin the domingoFin to set
	 */
	public void setDomingoFin(LocalTime domingoFin) {
		this.domingoFin = domingoFin;
	}

	public static void updateHeadersList(ArrayList<String> listaHead) {
		listaHead.add("#");
		listaHead.add("Lunes");
		listaHead.add("Martes");
		listaHead.add("Miercoles");
		listaHead.add("Jueves");
		listaHead.add("Viernes");
	}

	public void updateStringList(ArrayList<String> listaTemporal) {
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
	}
}
