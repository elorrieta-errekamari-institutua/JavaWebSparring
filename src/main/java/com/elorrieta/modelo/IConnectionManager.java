package com.elorrieta.modelo;

import java.sql.Connection;

public interface IConnectionManager {

	Connection open() throws Exception;

	Connection getConnection() throws Exception;

	void close() throws Exception;

}
