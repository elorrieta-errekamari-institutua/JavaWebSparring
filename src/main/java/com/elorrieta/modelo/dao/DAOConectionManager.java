package com.elorrieta.modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import com.elorrieta.modelo.IConnectionManager;

public class DAOConectionManager implements IConnectionManager, AutoCloseable {
	Connection conn = null;

	/**
	 * Devuelve la conexion a la base de datos
	 */
	@Override
	public Connection getConnection() throws Exception {
		return this.conn;
	}

	/**
	 * Cierra la conexion
	 */
	@Override
	public void close() throws Exception {
		// Cierra la conexion
		this.conn.close();
		System.out.println("Cerrada la conexion.");

	}

	/**
	 * Abre la conexion
	 */
	@Override
	public Connection open() throws Exception {
		// Parametros de la base de datos
		String url = "jdbc:sqlite:C:/sqlite/db/app.db";
		// Crear conexion a la base de datos
		conn = DriverManager.getConnection(url);

		System.out.println("Conectado a la base de datos");
		return this.conn;
	}

}
