package com.elorrieta.modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * Clase DAOConectionManager implementa AutoCloseable
 * 
 * Contiene los metodos para gestionar la conexion a base de datos
 * 
 * @see AutoCloseable
 */
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
	 * 
	 * @return Connection la conexion a la base de datos
	 * @throws Exception
	 */
	static public Connection getConnection() throws Exception {
		if (conn == null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Crear conexion a la base de datos
			InitialContext ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/elorrieta");
			/**
			 * Request a Connection from the pool of connection threads.
			 */
			conn = ds.getConnection();
			conn.setAutoCommit(true);
			if (conn.isValid(0)) {
				System.out.println("Conectado a la base de datos");
			}
		}

		return conn;
	}

	/**
	 * Devuelve la conexion a la base de datos en el path indicado
	 * 
	 * @param path la ruta a la base de datos
	 * @return Connection la conexion a la base de datos
	 * @throws Exception
	 */
	static public Connection getConnection(String path) throws Exception {
		Class.forName("org.sqlite.JDBC");

		// Crear conexion a la base de datos
		conn = DriverManager.getConnection(path);

		System.out.println("Conectado a la base de datos");
		return conn;
	}

	/**
	 * Establece el autoCommit para la conexion unica de la aplicacion
	 * 
	 * @param autoCommit estado al que establecerlo
	 * @throws SQLException
	 */
	static public void setAutoCommit(boolean autoCommit) throws SQLException {
		conn.setAutoCommit(autoCommit);
	}

	/**
	 * Cierra la conexion
	 */
	public void close() throws Exception {
		if (conn != null) {
			conn.close();
		}
		System.out.println("Cerrada la conexion.");

	}

}
