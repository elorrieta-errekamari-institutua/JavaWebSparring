package com.elorrieta.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.elorrieta.modelo.IDAOUsuario;
import com.elorrieta.modelo.pojo.POJOUsuario;

public class DAOUsuario implements IDAOUsuario {

	/**
	 * Devuelve un objeto de tipo usuario
	 * 
	 * @param id El id del usuario que se quiere recuperar
	 * @return POJO POJOUsuario
	 */
	@Override
	public POJOUsuario getByid(int id) throws Exception {
		POJOUsuario usuario = new POJOUsuario();
		String sql = "SELECT * from usuarios WHERE id= ? ;";

		// Obtener resultado
		try ( // Inicializar resultados con autoclosable
				Connection conn = DAOConectionManager.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setInt(1, id);
			try (ResultSet rs = stmt.executeQuery();) {
				// Fetch data
				if (rs.next()) {
					usuario.setId(rs.getInt("id"));
					usuario.setNombre(rs.getString("nombre"));
					usuario.setpass(rs.getString("pass"));
					usuario.setEmail("email");
				}

				else {
					System.out.println("No existe el usuario");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return usuario;
	}

	/**
	 * Devuelve un objeto de tipo usuario
	 * 
	 * @param nombre El nombre del usuario que se quiere recuperar
	 * @return POJO POJOUsuario
	 */
	@Override
	public POJOUsuario getByName(String nombre) throws Exception {
		POJOUsuario usuario = new POJOUsuario();
		String sql = "SELECT * from usuarios WHERE nombre = ? ";

		// Obtener resultado
		try ( // Inicializar resultados con autoclosable
				Connection conn = DAOConectionManager.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, nombre);
			try (ResultSet rs = stmt.executeQuery();) {
				// Fetch data
				if (rs.next()) {
					usuario.setId(rs.getInt("id"));
					usuario.setNombre(rs.getString("nombre"));
					usuario.setpass(rs.getString("pass"));
				}

				else {
					System.out.println("No existe el usuario");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return usuario;
	}

	/**
	 * Devuelve todos los usuarios en la base de datos
	 * 
	 * @return Lista de Usuarios.
	 */
	@Override
	public List<POJOUsuario> getAll() throws Exception {
		List<POJOUsuario> lista = new ArrayList<>();
		String sql = "SELECT * from usuarios";
		try ( // Inicializar resultados con autoclosable
				Connection conn = DAOConectionManager.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();) {
			// Obtener resultado
			while (rs.next()) {
				POJOUsuario usuario = new POJOUsuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setpass(rs.getString("pass"));
				lista.add(usuario);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	/**
	 * Borra un usuario tras buscarlo por id
	 * 
	 * @param id La id del usuario que se quiere borrar
	 * @return El usuario borrado.
	 */
	@Override
	public POJOUsuario delete(int id) {
		POJOUsuario usuario = null;

		String sql = "DELETE from usuarios WHERE id = ?";

		try ( // Inicializar resultados con autoclosable
				Connection conn = DAOConectionManager.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
			usuario = getByid(id);
			if (usuario.getId() > 0) {
				// Borrar usuario
				stmt.setInt(1, id);
				stmt.executeUpdate();
			} else {
				System.err.println("El usuario que se quiere borrar no existe");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}

	/**
	 * Actualiza un usuario con los datos de del POJO que recibe por parametro
	 * 
	 * @param POJOUsuario pojoModificar El usuario al que se quiere actualizar
	 * @return POJOUsuario El usuario actualizado.
	 */
	@Override
	public POJOUsuario update(POJOUsuario pojoModificar) {
		int id = pojoModificar.getId();
		POJOUsuario usuario = null;
		String nuevoNombre = pojoModificar.getNombre();
		String nuevoPassword = pojoModificar.getpass();

		String sql = "UPDATE usuarios SET  nombre = ? , pass = ? WHERE id = ?";
		try ( // Inicializar resultados con autoclosable
				Connection conn = DAOConectionManager.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
			usuario = getByid(id);
			if (usuario.getId() > 0) {
				// Actualizar usuario
				stmt.setString(1, nuevoNombre);
				stmt.setString(2, nuevoPassword);
				stmt.setInt(3, id);
				stmt.executeUpdate();
				usuario = getByid(id);
			} else {
				System.err.println("El usuario que se quiere actualizar no existe");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}

	/**
	 * Inserta un nuevo usuario con los datos de del POJO que recibe por parametro
	 * 
	 * @param pojoNuevo El usuario que se quiere insertar
	 * @return El id del nuevo usuario.
	 */

	public int insert(POJOUsuario pojoNuevo) {

		int columnasAfectadas, ultimaId = 0;
		String sqlInsert = "INSERT INTO usuarios (nombre,pass) VALUES(?, ?);";

		try ( // Inicializar resultados con autoclosable
				Connection conn = DAOConectionManager.getConnection();
				PreparedStatement stmtInsert = conn.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);) {
			stmtInsert.setString(1, pojoNuevo.getNombre());
			stmtInsert.setString(2, pojoNuevo.getpass());
			columnasAfectadas = stmtInsert.executeUpdate();
			try (ResultSet rs = stmtInsert.getGeneratedKeys()) {
				// Si se ha insertado el usuario
				if (columnasAfectadas > 0) {
					// Obterner linea de la base de datos
					ultimaId = rs.getInt(1);

				} else {
					System.err.println("No se ha podido insertar el usuario");
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		} catch (

		Exception e) {
			e.printStackTrace();
		}
		return ultimaId;
	}

	/**
	 * Logea un usuario en el sistema
	 * 
	 * @param String nombre El nombre del usuario que se quiere logear
	 * @param String password El password del usuario que se quiere logear
	 * @return POJOUsuario el POJO del usuario logeado
	 */
	public POJOUsuario login(String nombre, String password) {

		POJOUsuario usuario = null;
		String sql = "SELECT id FROM usuarios WHERE nombre = ? AND pass = ?;";
		int id = 0;

		try ( // Inicializar resultados con autoclosable
				Connection conn = DAOConectionManager.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);) {

			stmt.setString(1, nombre);
			stmt.setString(2, password);

			try (ResultSet rs = stmt.executeQuery();) {
				if (rs.next()) {
					id = rs.getInt("id");
					if (id > 0) {
						usuario = new POJOUsuario();
						usuario = getByid(id);
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}

}
