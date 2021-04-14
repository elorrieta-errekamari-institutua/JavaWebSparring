/**
 * 
 */
package com.elorrieta.CRUDSqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Mikel Aitor Ocejo Zamacona
 *
 */
public class CRUD {

	static Connection conn = null;

	public CRUD() {
		// TODO Auto-generated constructor stub
	}

	private void connect() {

		try {
			// Parametros de la base de datos
			String url = "jdbc:sqlite:C:/sqlite/db/usuarios.db";
			// Crear conexion a la base de datos
			conn = DriverManager.getConnection(url);

			System.out.println("Conectado a la base de datos");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

	private void createTable(String nombreTabla) throws SQLException {

		if (conn != null) {
			System.out.printf("Creada la tabla %s", nombreTabla);
		} else {
			System.out.println("Conexion interrumpida");
		}

	}

	public static void main(String[] args) throws SQLException {
		CRUD crud = new CRUD();
		crud.connect();
		crud.createTable("Usuario");

	}
}
