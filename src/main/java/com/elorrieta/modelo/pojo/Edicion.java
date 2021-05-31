/**
 * 
 */
package com.elorrieta.modelo.pojo;

import java.sql.Date;
import java.util.ArrayList;

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
	private ArrayList<Aula> aulas;
	private boolean guardado;

	public Edicion() {
		this.id = -1;
		this.codigoLanbide = "";
		this.curso = null;
		this.horario = null;
		this.fechaInicio = Date.valueOf("1977-11-14");
		this.fechaFin = Date.valueOf("1977-11-15");
		this.aulas = new ArrayList<Aula>();
		this.guardado = false;
	}

	public Edicion(Curso curso, Horario horario) {
		this.id = -1;
		this.codigoLanbide = "";
		this.curso = curso;
		this.horario = horario;
		this.fechaInicio = Date.valueOf("1977-11-14");
		this.fechaFin = Date.valueOf("1977-11-15");
		this.aulas = new ArrayList<Aula>();
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
	 * @return the aulas
	 */
	public ArrayList<Aula> getAulas() {
		return aulas;
	}

	/**
	 * @param aulas the aulas to set
	 */
	public void setAulas(ArrayList<Aula> aulas) {
		this.aulas = aulas;
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

	/**
	 * @return ArrayList with all the headers needed to display a list of objects in a table
	 */
	public static ArrayList<String> setHeadersList() {
		ArrayList<String> listaHead = new ArrayList<String>();
		listaHead.add("#");
		listaHead.add("<abbr title='Codigo Lanbide'>Lanbide</abbr>");
		listaHead.add("Nombre");
		listaHead.add("Horas");
		listaHead.add("Codigo AAFF");
		listaHead.add("Codigo UC");
		listaHead.add("Competencia");
		listaHead.add("Cualificacion");
		listaHead.add("<abbr title='Fecha de inicio'>Inicio</abbr>");
		listaHead.add("<abbr title='Fecha de fin'>Fin</abbr>");
		listaHead.add("Lunes");
		listaHead.add("Martes");
		listaHead.add("Miercoles");
		listaHead.add("Jueves");
		listaHead.add("Viernes");
		return listaHead;
	}

	/**
	 * @return Arraylist with all the data needed to display the object in a table row
	 */
	public ArrayList<String> setDataList() {
		ArrayList<String> listaTemporal = new ArrayList<String>();
		if (guardado){
			listaTemporal.add("0");
		} else {
			listaTemporal.add(String.valueOf(id));
		}
		listaTemporal.add(codigoLanbide);
		listaTemporal.add(curso.getNombre());
		listaTemporal.add(String.valueOf(curso.getHorasCurso()));
		listaTemporal.add(curso.getCodigoAaff());
		listaTemporal.add(curso.getCodigoUc());
		listaTemporal.add(curso.getCompetencia());
		listaTemporal.add(curso.getCualificacion());
		listaTemporal.add(fechaInicio.toString());
		listaTemporal.add(fechaFin.toString());
		String horarioDia = horario.getLunesInicio().toString() + " - " + horario.getLunesFin().toString();
		listaTemporal.add(horarioDia);
		horarioDia = horario.getMartesInicio().toString() + " - " + horario.getMartesFin().toString();
		listaTemporal.add(horarioDia);
		horarioDia = horario.getMiercolesInicio().toString() + " - " + horario.getMiercolesFin().toString();
		listaTemporal.add(horarioDia);
		horarioDia = horario.getJuevesInicio().toString() + " - " + horario.getJuevesFin().toString();
		listaTemporal.add(horarioDia);
		horarioDia = horario.getViernesInicio().toString() + " - " + horario.getViernesFin().toString();
		listaTemporal.add(horarioDia);
		return listaTemporal;
	}

}
