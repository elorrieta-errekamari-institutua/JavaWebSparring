package com.elorrieta.modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import com.elorrieta.modelo.IConnectionManager;

public class DAOConectionManager implements IConnectionManager, AutoCloseable {

	private static DAOConectionManager INSTANCE = null;

	/**
	 * Constructor privado, solo accesible desde la clase
	 */
	private DAOConectionManager() {

	}

	/**
	 * Creacion de la instancia solo si no existe de antes
	 */
	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new DAOConectionManager();
		}
	}

	/**
	 * Obtener la instancia
	 */
	public static DAOConectionManager getInstance() {
		if (INSTANCE == null)
			createInstance();
		return INSTANCE;
	}

	Connection conn = null;

	/**
	 * Devuelve la conexion a la base de datos
	 */
	@Override
	public Connection getConnection() throws Exception {
		return INSTANCE.conn;
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
		String url = "jdbc:sqlite:src\\main\\resources\\db\\app.db";
		// Crear conexion a la base de datos
		conn = DriverManager.getConnection(url);

		System.out.println("Conectado a la base de datos");
		return this.conn;
	}

}
