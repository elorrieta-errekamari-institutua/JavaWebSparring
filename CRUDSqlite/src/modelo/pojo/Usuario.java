package modelo.pojo;

public class Usuario {

	private int id;
	private String nombre;
	private String password;

	/***
	 * Constructor Usuario
	 */
	public Usuario() {
		super();
		this.id = 0;
		this.nombre = "";
		this.password = "";
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
	 * Constructor usuario con el parametro nombre y password
	 * 
	 * @param nombre   Nombre del usuario
	 * @param password Password del usuario
	 */
	public Usuario(String nombre, String password) {
		this();
		this.nombre = nombre;
		this.password = password;
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
	 * @return password del usuario
	 */
	public String getPassword() {
		return password;
	}

	/***
	 * Actualiza el password del usuario
	 * 
	 * @param password El nuevo password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/***
	 * Muestra por pantalla los datos del usuario formateado
	 */
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", password=" + password + "]";
	}

}
