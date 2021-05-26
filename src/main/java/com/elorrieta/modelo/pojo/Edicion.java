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
	private boolean guardado;

	public Edicion() {
		this.id = -1;
		this.codigoLanbide = "";
		this.curso = null;
		this.horario = null;
		this.fechaInicio = Date.valueOf("1977-11-14");
		this.fechaFin = Date.valueOf("1977-11-15");
		this.guardado = false;
	}

	public Edicion(Curso curso, Horario horario) {
		this.id = -1;
		this.codigoLanbide = "";
		this.curso = curso;
		this.horario = horario;
		this.fechaInicio = Date.valueOf("1977-11-14");
		this.fechaFin = Date.valueOf("1977-11-15");
		this.guardado = false;
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
	 * @return the horario
	 */
	public Horario getHorario() {
		return horario;
	}

	/**
	 * @param horario the horario to set
	 */
	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	/**
	 * @return the curso
	 */
	public Curso getCurso() {
		return curso;
	}

	/**
	 * @param curso the curso to set
	 */
	public void setCurso(Curso curso) {
		this.curso = curso;
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

	/**
	 * @return the guardado
	 */
	public boolean isGuardado() {
		return guardado;
	}

	/**
	 * @param guardado the guardado to set
	 */
	public void setGuardado(boolean guardado) {
		this.guardado = guardado;
	}

}
