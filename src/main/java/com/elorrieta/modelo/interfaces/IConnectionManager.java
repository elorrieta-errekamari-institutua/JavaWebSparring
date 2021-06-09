package com.elorrieta.modelo.interfaces;

import java.sql.Connection;

/**
 * Interfaz IConnectionManager
 * 
 * Contiene los metodos para abrir cerrar u obtener una conexion a base de datos
 */
public interface IConnectionManager {

	Connection open() throws Exception;

	Connection getConnection() throws Exception;

	void close() throws Exception;

}
