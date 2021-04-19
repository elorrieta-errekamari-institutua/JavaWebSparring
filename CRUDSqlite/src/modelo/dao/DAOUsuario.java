package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.pojo.Usuario;

public class DAOUsuario implements IDAOUsuario {

	/**
	 * Devuelve un objeto de tipo usuario
	 * 
	 * @param id El id del usuario que se quiere recuperar
	 * @return POJO Usuario
	 */
	@Override
	public Usuario getByid(int id) throws Exception {
		Usuario usuario = new Usuario();
		String sql = "SELECT * from usuarios WHERE id=" + id;

		// Obtener resultado
		try ( // Inicializar resultados con autoclosable
				DAOConnectionManager connectionManager = new DAOConnectionManager();
				Connection conn = connectionManager.open();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			// Fetch data
			if (rs.next()) {
				usuario.setId(rs.getInt("id"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setPassword(rs.getString("pass"));
			}

			else {
				System.out.println("No existe el usuario");
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
	public List<Usuario> getAll() throws Exception {
		List<Usuario> lista = new ArrayList<>();
		String sql = "SELECT * from usuarios";
		try ( // Inicializar resultados con autoclosable
				DAOConnectionManager connectionManager = new DAOConnectionManager();
				Connection conn = connectionManager.open();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			// Obtener resultado
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setPassword(rs.getString("pass"));
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
	public Usuario delete(int id) {
		Usuario usuario = null;

		String sql = "DELETE from usuarios WHERE id=" + id;

		try ( // Inicializar resultados con autoclosable
				DAOConnectionManager connectionManager = new DAOConnectionManager();
				Connection conn = connectionManager.open();
				Statement stmt = conn.createStatement();) {
			usuario = getByid(id);
			if (usuario.getId() > 0) {
				// Borrar usuario
				stmt.execute(sql);
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
	 * @param Usuario pojoModificar El usuario al que se quiere actualizar
	 * @return Usuario El usuario actualizado.
	 */
	@Override
	public Usuario update(Usuario pojoModificar) {
		int id = pojoModificar.getId();
		Usuario usuario = null;

		String sql = "UPDATE usuarios\n" + "SET  nombre = '" + pojoModificar.getNombre() + "',\n     pass = '"
				+ pojoModificar.getPassword() + "'\nWHERE\n     id=" + id;
		try ( // Inicializar resultados con autoclosable
				DAOConnectionManager connectionManager = new DAOConnectionManager();
				Connection conn = connectionManager.open();
				Statement stmt = conn.createStatement();) {
			usuario = getByid(id);
			if (usuario.getId() > 0) {
				// Actualizar usuario
				stmt.execute(sql);
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
	@Override
	public int insert(Usuario pojoNuevo) {

		int columnasAfectadas, ultimaId = 0;
		String sqlInsert = "INSERT INTO usuarios (nombre,pass) VALUES(?, ?);";

		try ( // Inicializar resultados con autoclosable
				DAOConnectionManager connectionManager = new DAOConnectionManager();
				Connection conn = connectionManager.open();
				PreparedStatement stmtInsert = conn.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);) {
			stmtInsert.setString(1, pojoNuevo.getNombre());
			stmtInsert.setString(2, pojoNuevo.getPassword());
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
	 * @return Usuario el POJO del usuario logeado
	 */
	@Override
	public Usuario login(String nombre, String password) {

		Usuario usuario = new Usuario();
		String sql = "SELECT id FROM usuarios WHERE nombre = ? AND pass = ?;";
		int id = 0;

		try ( // Inicializar resultados con autoclosable
				DAOConnectionManager connectionManager = new DAOConnectionManager();
				Connection conn = connectionManager.open();
				PreparedStatement stmt = conn.prepareStatement(sql);) {

			stmt.setString(1, nombre);
			stmt.setString(2, password);

			try (ResultSet rs = stmt.executeQuery();) {
				if (rs.next()) {
					id = rs.getInt("id");
					if (id > 0) {
						usuario = getByid(id);
					} else {
						System.out.println("El usuario no existe");
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
