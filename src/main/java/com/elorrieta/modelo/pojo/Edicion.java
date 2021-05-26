/**
 * 
 */
package com.elorrieta.modelo.pojo;

import java.sql.Date;

/**
 * @author cursos_externos
 *
 */
public class Edicion {

	private int id;
	private String codigoLanbide;
	private Horario horario;
	private Curso curso;
	private Date fechaInicio;
	private Date fechaFin;

	public Edicion() {
		this.id = -1;
		this.codigoLanbide = "";
		this.curso = null;
		this.horario = null;
		this.fechaInicio = Date.valueOf("1977-11-14");
		this.fechaFin = Date.valueOf("1977-11-15");
	}

	public Edicion(Curso curso, Horario horario) {
		this.id = -1;
		this.codigoLanbide = "";
		this.curso = curso;
		this.horario = horario;
		this.fechaInicio = Date.valueOf("1977-11-14");
		this.fechaFin = Date.valueOf("1977-11-15");
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
	 * @return the codigoLanbide
	 */
	public String getCodigoLanbide() {
		return codigoLanbide;
	}

	/**
	 * @param codigoLanbide the codigoLanbide to set
	 */
	public void setCodigoLanbide(String codigoLanbide) {
		this.codigoLanbide = codigoLanbide;
	}

	/**
	 * @return the idCurso
	 */
	public int getIdCurso() {
		return idCurso;
	}

	/**
	 * @param idCurso the idCurso to set
	 */
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	/**
	 * @return the idHorario
	 */
	public int getIdHorario() {
		return idHorario;
	}

	/**
	 * @param idHorario the idHorario to set
	 */
	public void setIdHorario(int idHorario) {
		this.idHorario = idHorario;
	}

	/**
	 * @return the fechaInicio
	 */
	public Date getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * @return the fechaFin
	 */
	public Date getFechaFin() {
		return fechaFin;
	}

	/**
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

}
