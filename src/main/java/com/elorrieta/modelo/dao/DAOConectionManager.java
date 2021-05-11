package com.elorrieta.modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DAOConectionManager implements AutoCloseable {

	static private Connection conn = null;

	/**
	 * Constructor privado, solo accesible desde la clase
	 */
	private DAOConectionManager() {
		super();
	}

	/**
	 * Devuelve la conexion a la base de datos
	 */

	static public Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		// Crear conexion a la base de datos
		InitialContext ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/elorrieta");
		/**
		 * Request a Connection from the pool of connection threads.
		 */
		Connection conn = ds.getConnection();
		// conn = DriverManager.getConnection(PATH, USUARIO, PASSWORD);
		if (conn.isValid(0)) {
			System.out.println("Conectado a la base de datos");
		}

		return conn;
	}

	/**
	 * Devuelve la conexion a la base de datos en el path indicado
	 */

	static public Connection getConnection(String path) throws Exception {
		Class.forName("org.sqlite.JDBC");
		// Parametros de la base de datos

		// Crear conexion a la base de datos
		conn = DriverManager.getConnection(path);

		System.out.println("Conectado a la base de datos");
		return conn;
	}

	/**
	 * Cierra la conexion
	 */

	public void close() throws Exception, InterruptedException {
		// Cierra la conexion
		if (conn != null) {
			conn.close();
		}
		System.out.println("Cerrada la conexion.");

	}

}
