package com.elorrieta.modelo.pojo;

import java.sql.Blob;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Usuario {
	private int id;

	@NotBlank
	@Size(min = 2, max = 45, message = "debe contener entre 2 y 45 caracteres")
	private String nombre;

	@NotBlank
	// @ Pattern
	private String pass;

	@Email
	private String email;
	private Blob image;

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

	/***
	 * Muestra por pantalla los datos del usuario formateado
	 */
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", pass=" + pass + ", email=" + email + ", image=" + image
				+ "]";
	}

}
