package com.elorrieta.modelo.pojo;

import java.sql.Date;

public class Participante extends Usuario {

	private String nombreCompleto;
	private String dni;
	private String telefono;
	private Date fechaDeNacimiento;
	private String direccion;
	private String codigoPostal;
	private String municipio;
	private String provincia;
	private boolean erte;
	private String situacionLaboral;
	private String situacionAdministrativa;
	private String titulacion;
	private boolean guardado;

	public Participante() {
		super();
		this.nombreCompleto = "";
		this.dni = "";
		this.telefono = "";
		this.fechaDeNacimiento = Date.valueOf("1977-11-14");
		this.direccion = "";
		this.codigoPostal = "";
		this.municipio = "";
		this.provincia = "";
		this.erte = false;
		this.situacionLaboral = "";
		this.situacionAdministrativa = "";
		this.titulacion = "";
		this.guardado = false;
	}

	public Participante(String nombreCompleto, String dni, String telefono, Date fechaDeNacimiento, String direccion,
			String codigoPostal, String municipio, String provincia, boolean eRTE, String situacionLaboral,
			String situacionAdministrativa, String titulacion) {
		this();
		this.nombreCompleto = nombreCompleto;
		this.dni = dni;
		this.telefono = telefono;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.direccion = direccion;
		this.codigoPostal = codigoPostal;
		this.municipio = municipio;
		this.provincia = provincia;
		this.erte = eRTE;
		this.situacionLaboral = situacionLaboral;
		this.situacionAdministrativa = situacionAdministrativa;
		this.titulacion = titulacion;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public boolean isErte() {
		return erte;
	}

	public void setErte(boolean erte) {
		this.erte = erte;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getSituacionLaboral() {
		return situacionLaboral;
	}

	public void setSituacionLaboral(String situacionLaboral) {
		this.situacionLaboral = situacionLaboral;
	}

	public String getSituacionAdministrativa() {
		return situacionAdministrativa;
	}

	public void setSituacionAdministrativa(String situacionAdministrativa) {
		this.situacionAdministrativa = situacionAdministrativa;
	}

	public String getTitulacion() {
		return titulacion;
	}

	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}

	public boolean isGuardado() {
		return guardado;
	}

	public void setGuardado(boolean guardado) {
		this.guardado = guardado;
	}

	@Override
	public String toString() {
		return "Participante [nombreCompleto=" + nombreCompleto + ", dni=" + dni + ", telefono=" + telefono
				+ ", fechaDeNacimiento=" + fechaDeNacimiento + ", direccion=" + direccion + ", codigoPostal="
				+ codigoPostal + ", municipio=" + municipio + ", provincia=" + provincia + ", erte=" + erte
				+ ", situacionLaboral=" + situacionLaboral + ", situacionAdministrativa=" + situacionAdministrativa
				+ ", titulacion=" + titulacion + ", guardado=" + guardado + "]";
	}

}
