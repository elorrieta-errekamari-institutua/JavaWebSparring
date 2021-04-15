package modelo;

import java.sql.Connection;

public interface ConnectionManager {

	Connection open() throws Exception;

	Connection getConnection() throws Exception;

	void close() throws Exception;

}
