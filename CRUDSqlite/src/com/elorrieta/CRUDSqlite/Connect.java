package com.elorrieta.CRUDSqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Mikel Aitor Ocejo
 */
public class Connect {
	/**
	 * Conexion a base de datos Sqlite
	 */
	public static void connect() {
		Connection conn = null;
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

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		connect();
	}
}