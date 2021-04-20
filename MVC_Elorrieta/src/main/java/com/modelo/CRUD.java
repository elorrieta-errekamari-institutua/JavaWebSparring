package com.modelo;

/**
 * 
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Mikel Aitor Ocejo Zamacona
 *
 */
public class CRUD {

	static Connection conn = null;

	public CRUD() {
		// TODO Auto-generated constructor stub
	}

	public void connect() {

		try {
			// Parametros de la base de datos
			String url = "jdbc:sqlite::db/app.db";
			// Crear conexion a la base de datos
			conn = DriverManager.getConnection(url);

			System.out.println("Conectado a la base de datos");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	private void createTable(String nombreTabla) throws SQLException {

		if (conn != null) {
			String sql = "CREATE TABLE IF NOT EXISTS " + nombreTabla + " (\n"
					+ " id integer PRIMARY KEY AUTOINCREMENT,\n " + " nombre text NOT NULL, \n "
					+ " pass text NOT NULL, \n " + " email text, \n " + " telefono text \n " + ");";

			try {
				Statement stmt = conn.createStatement();
				stmt.execute(sql);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			System.out.printf("Creada la tabla %s%n", nombreTabla);
		} else {
			System.out.println("Error de conexion");
		}

	}

	private void crearUsuario(String tabla, String nombre, String pass, String email, String telefono) {
		if (conn != null) {
			String sql = "INSERT INTO " + tabla + " (\n" + " nombre, \n " + " pass, \n " + " email, \n "
					+ " telefono \n " + ") \n" + "VALUES " + "('" + nombre + "', '" + pass + "', '" + email + "', '"
					+ telefono + "')" + ";";

			try {
				Statement stmt = conn.createStatement();
				stmt.execute(sql);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			System.out.printf("Creado el usuario %s%n", nombre);
		} else {
			System.out.println("Error de conexion");
		}
	}

	public static void main(String[] args) throws SQLException {
		CRUD crud = new CRUD();
		crud.connect();
		crud.createTable("usuario");
		crud.crearUsuario("usuario", "TestNull", "1234", null, null);
		conn.close();

	}
}
