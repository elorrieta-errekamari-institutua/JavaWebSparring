package com.elorrieta.modelo.pojo;

import java.sql.Blob;
import java.util.ArrayList;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Usuario {
	private int id;

	@NotBlank(message = "El nombre no puede estar vacio")
	@Size(min = 2, max = 45, message = "El nombre debe contener entre 2 y 45 caracteres")
	private String nombre;

	@NotBlank(message = "El password no puede estar vacio")
	@Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,128}$", message = "Minimo 8 caracteres incluyendo un caracter especial, un numero y mayusculas y minusculas")
	private String pass;

	@NotBlank(message = "El email no puede estar vacio")
	@Email(message = "El formato del email es incorrecto")
	private String email;
	private Blob image;
	private String rolUsuario;

	/***
	 * Constructor Usuario
	 */
	public Usuario() {
		super();
		this.id = -1;
		this.nombre = "";
		this.pass = "";
		this.email = "";
		this.image = null;
		this.rolUsuario = "";
	}

	/***
	 * Constructor usuario con el parametro nombre
	 * 
	 * @param nombre Nombre del usuario
	 */
	public Usuario(String nombre) {
		this();
		this.nombre = nombre;
	}

	/***
	 * Constructor usuario con el parametro nombre y pass
	 * 
	 * @param nombre Nombre del usuario
	 * @param pass   pass del usuario
	 */
	public Usuario(String nombre, String pass) {
		this();
		this.nombre = nombre;
		this.pass = pass;
	}

	/***
	 * 
	 * @return Id del usuario
	 */
	public int getId() {
		return id;
	}

	/***
	 * Actualiza el id del usuario
	 * 
	 * @param id El nuevo id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/***
	 * 
	 * @return nombre del usuario
	 */
	public String getNombre() {
		return nombre;
	}

	/***
	 * Actualiza el nombre del usuario
	 * 
	 * @param nombre El nuevo nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/***
	 * 
	 * @return pass del usuario
	 */
	public String getPass() {
		return pass;
	}

	/***
	 * Actualiza el pass del usuario
	 * 
	 * @param pass El nuevo pass
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}

	/***
	 * 
	 * @return email del usuario
	 */
	public String getEmail() {
		return email;
	}

	/***
	 * Actualiza el email del usuario
	 * 
	 * @param email El nuevo email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/***
	 * 
	 * @return la imagen del usuario
	 */
	public Blob getImage() {
		return image;
	}

	/***
	 * Actualiza la imagen del usuario
	 * 
	 * @param image La nueva imagen
	 */
	public void setImage(Blob image) {
		this.image = image;
	}

	/**
	 * @return the rolUsuario
	 */
	public String getRolUsuario() {
		return rolUsuario;
	}

	/**
	 * @param rolUsuario the rolUsuario to set
	 */
	public void setRolUsuario(String rolUsuario) {
		this.rolUsuario = rolUsuario;
	}

	/***
	 * Muestra por pantalla los datos del usuario formateado
	 */
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", pass=" + pass + ", email=" + email + ", image=" + image
				+ ", rol usuario=" + rolUsuario + "]";
	}
	
	/**
	 * @return ArrayList with all the headers needed to display a list of objects in a table
	 */
	public static ArrayList<String> setHeadersList() {
		ArrayList<String> listaHead = new ArrayList<String>();
		listaHead.add("#");
		listaHead.add("Avatar");
		listaHead.add("Nombre");
		listaHead.add("Email");
		listaHead.add("Rol");
		return listaHead;
  }
	
	/**
	 * @return Arraylist with all the data needed to display the object in a table row
	 */
	public ArrayList<String> setDataList() {
		ArrayList<String> listaTemporal = new ArrayList<String>();
		listaTemporal.add(String.valueOf(id));
		listaTemporal.add("<img src='" + image.toString() + "' width='2rem' height='2rem'>"); // TODO modificar esto para poder insertar la imagen
		listaTemporal.add(nombre);
		listaTemporal.add(email);
		listaTemporal.add(rolUsuario);
		return listaTemporal;
	}

}
