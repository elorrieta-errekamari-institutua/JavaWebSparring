package com.elorrieta.modelo.pojo;

import java.sql.Date;
import java.util.ArrayList;

/**
 * Clase Participante
 * 
 * Contiene los atributos de un participante y metodos para acceder a ellos
 * Contiene metodos para rellenar una tabla
 */
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

	/**
	 * Constructor Participante
	 * 
	 * Inicializa todos los parametros
	 */
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

	/**
	 * Constructor Participante con todos los parametros
	 * 
	 * @param nombreCompleto          el nombre completo
	 * @param dni                     el DNI
	 * @param telefono                el telefono
	 * @param fechaDeNacimiento       la fecha de nacimiento
	 * @param direccion               la direccion
	 * @param codigoPostal            el codigo postal
	 * @param municipio               el municipio
	 * @param provincia               la provincia
	 * @param erte                    true si esta en ERTE y false si no
	 * @param situacionLaboral        la situacion laboral
	 * @param situacionAdministrativa la situacion administrativa
	 * @param titulacion              la titulacion
	 */
	public Participante(String nombreCompleto, String dni, String telefono, Date fechaDeNacimiento, String direccion,
			String codigoPostal, String municipio, String provincia, boolean erte, String situacionLaboral,
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
		this.erte = erte;
		this.situacionLaboral = situacionLaboral;
		this.situacionAdministrativa = situacionAdministrativa;
		this.titulacion = titulacion;
	}

	/**
	 * @return the nombreCompleto
	 */
	public String getNombreCompleto() {
		return nombreCompleto;
	}

	/**
	 * @param nombreCompleto the nombreCompleto to set
	 */
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the fechaDeNacimiento
	 */
	public Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	/**
	 * @param fechaDeNacimiento the fechaDeNacimiento to set
	 */
	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the codigoPostal
	 */
	public String getCodigoPostal() {
		return codigoPostal;
	}

	/**
	 * @param codigoPostal the codigoPostal to set
	 */
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	/**
	 * @return the municipio
	 */
	public String getMunicipio() {
		return municipio;
	}

	/**
	 * @param municipio the municipio to set
	 */
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	/**
	 * @return the provincia
	 */
	public String getProvincia() {
		return provincia;
	}

	/**
	 * @param provincia the provincia to set
	 */
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	/**
	 * @return the erte
	 */
	public boolean isErte() {
		return erte;
	}

	/**
	 * @param erte the erte to set
	 */
	public void setErte(boolean erte) {
		this.erte = erte;
	}

	/**
	 * @return the situacionLaboral
	 */
	public String getSituacionLaboral() {
		return situacionLaboral;
	}

	/**
	 * @param situacionLaboral the situacionLaboral to set
	 */
	public void setSituacionLaboral(String situacionLaboral) {
		this.situacionLaboral = situacionLaboral;
	}

	/**
	 * @return the situacionAdministrativa
	 */
	public String getSituacionAdministrativa() {
		return situacionAdministrativa;
	}

	/**
	 * @param situacionAdministrativa the situacionAdministrativa to set
	 */
	public void setSituacionAdministrativa(String situacionAdministrativa) {
		this.situacionAdministrativa = situacionAdministrativa;
	}

	/**
	 * @return the titulacion
	 */
	public String getTitulacion() {
		return titulacion;
	}

	/**
	 * @param titulacion the titulacion to set
	 */
	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
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

	@Override
	public String toString() {
		return "Participante [nombreCompleto=" + nombreCompleto + ", dni=" + dni + ", telefono=" + telefono
				+ ", fechaDeNacimiento=" + fechaDeNacimiento + ", direccion=" + direccion + ", codigoPostal="
				+ codigoPostal + ", municipio=" + municipio + ", provincia=" + provincia + ", erte=" + erte
				+ ", situacionLaboral=" + situacionLaboral + ", situacionAdministrativa=" + situacionAdministrativa
				+ ", titulacion=" + titulacion + ", guardado=" + guardado + "]";
	}

	/**
	 * @return ArrayList with all the headers needed to display a list of objects in
	 *         a table
	 */
	public static ArrayList<String> setHeadersList() {
		ArrayList<String> listaHead = new ArrayList<String>();
		listaHead.add("#");
		listaHead.add("Nombre");
		listaHead.add("DNI");
		listaHead.add("Telefono");
		listaHead.add("<abbr title='Fecha de nacimiento'>Fecha</abbr>");
		listaHead.add("Direccion");
		listaHead.add("<abbr title='Codigo postal'>CP</abbr>");
		listaHead.add("Municipio");
		listaHead.add("Provincia");
		listaHead.add("ERTE");
		listaHead.add("<abbr title='Situacion laboral'>Laboral</abbr>");
		listaHead.add("<abbr title='Situacion administrativa'>Administrativa</abbr>");
		return listaHead;
	}

	/**
	 * @return Arraylist with all the data needed to display the object in a table
	 *         row
	 */
	public ArrayList<String> setDataList() {
		ArrayList<String> listaTemporal = new ArrayList<String>();
		if (guardado) {
			listaTemporal.add("0");
		} else {
			listaTemporal.add(String.valueOf(this.getId()));
		}
		listaTemporal.add(nombreCompleto);
		listaTemporal.add(dni);
		listaTemporal.add(telefono);
		listaTemporal.add(fechaDeNacimiento.toString());
		listaTemporal.add(direccion);
		listaTemporal.add(codigoPostal);
		listaTemporal.add(municipio);
		listaTemporal.add(provincia);
		if (erte) {
			listaTemporal.add("Si");
		} else {
			listaTemporal.add("No");
		}
		listaTemporal.add(situacionLaboral);
		listaTemporal.add(situacionAdministrativa);
		return listaTemporal;
	}

}
