package com.elorrieta.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.elorrieta.modelo.interfaces.IDAOUsuario;
import com.elorrieta.modelo.pojo.Usuario;

/**
 * Clase DAOUsuario implementa IDAOUsuario
 * 
 * Contiene los metodos para interactuar con usuarios en la base de datos
 * 
 * @see IDAOUsuario
 */
public class DAOUsuario implements IDAOUsuario {

	Connection conn;

	/**
	 * Constructor vacio
	 * 
	 * @throws Exception
	 */
	public DAOUsuario() throws Exception {
		super();
		conn = DAOConectionManager.getConnection();
	}

	@Override
	public Usuario getByid(int id) throws Exception {
		Usuario usuario = new Usuario();
		String sql = "SELECT * from usuario WHERE id= ? ;";

		try (PreparedStatement stmt = conn.prepareStatement(sql);) {

			stmt.setInt(1, id);
			try (ResultSet rs = stmt.executeQuery();) {

				if (rs.next()) {
					usuario.setId(rs.getInt("id"));
					usuario.setNombre(rs.getString("nombre"));
					usuario.setPass(rs.getString("pass"));
					usuario.setEmail(rs.getString("email"));
					getRolUsuario(usuario);
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

	@Override
	public Usuario getByName(String nombre) throws Exception {
		Usuario usuario = new Usuario();
		String sql = "SELECT * from usuario WHERE nombre = ? ";

		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, nombre);
			try (ResultSet rs = stmt.executeQuery();) {

				if (rs.next()) {
					usuario.setId(rs.getInt("id"));
					usuario.setNombre(rs.getString("nombre"));
					usuario.setPass(rs.getString("pass"));
					usuario.setEmail(rs.getString("email"));
					getRolUsuario(usuario);
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

	@Override
	public ArrayList<Usuario> getAll() throws Exception {
		ArrayList<Usuario> lista = new ArrayList<>();
		String sql = "SELECT * from usuario";

		try (PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery();) {

			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setPass(rs.getString("pass"));
				usuario.setEmail(rs.getString("email"));
				getRolUsuario(usuario);
				lista.add(usuario);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public Usuario delete(int id) {
		Usuario usuario = null;

		String sql = "DELETE from usuario WHERE id = ?";

		try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

			usuario = getByid(id);
			if (usuario.getId() > 0) {
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

	@Override
	public Usuario update(Usuario pojoModificar) {
		int id = pojoModificar.getId();
		Usuario usuario = null;
		String nuevoNombre = pojoModificar.getNombre();
		String nuevoPassword = pojoModificar.getPass();

		String sql = "UPDATE usuario SET  nombre = ? , pass = ? WHERE id = ?";

		try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
			usuario = getByid(id);
			if (usuario.getId() > 0) {
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

	@Override
	public int insert(Usuario pojoNuevo) {

		int columnasAfectadas, ultimaId = -1;
		String sqlInsert = "INSERT INTO usuario (nombre, pass, email, rol_usuario) VALUES(?, ?, ?, ?);";

		try (PreparedStatement stmtInsert = conn.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);) {

			stmtInsert.setString(1, pojoNuevo.getNombre());
			stmtInsert.setString(2, pojoNuevo.getPass());
			stmtInsert.setString(3, pojoNuevo.getEmail());
			stmtInsert.setInt(4, 2);
			columnasAfectadas = stmtInsert.executeUpdate();
			try (ResultSet rs = stmtInsert.getGeneratedKeys()) {

				if (columnasAfectadas > 0) {
					ultimaId = rs.getInt(1);

				} else {
					System.err.println("No se ha podido insertar el usuario");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		} catch (

		Exception e) {
			e.printStackTrace();
		}
		return ultimaId;
	}

	@Override
	public Usuario login(String nombre, String password) {

		Usuario usuario = null;
		String sql = "SELECT id FROM usuario WHERE nombre = ? AND pass = ?;";

		int id = 0;

		try (PreparedStatement stmt = conn.prepareStatement(sql);) {

			stmt.setString(1, nombre);
			stmt.setString(2, password);

			try (ResultSet rs = stmt.executeQuery();) {
				if (rs.next()) {
					id = rs.getInt("id");
					if (id > 0) {
						usuario = new Usuario();
						usuario = getByid(id);
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		getRolUsuario(usuario);
		return usuario;
	}

	/**
	 * Actualiza el usuario para asignarle su rol buscandolo en la base de datos
	 * 
	 * @param usuario Usuario que queremos buscar
	 */
	public void getRolUsuario(Usuario usuario) {
		String rol = "";
		String sql = "SELECT r.nombre from rol r, usuario u where r.id = u.rol_usuario AND u.id = ?";

		try (PreparedStatement stmt = conn.prepareStatement(sql);) {

			stmt.setInt(1, usuario.getId());
			try (ResultSet rs = stmt.executeQuery();) {
				if (rs.next()) {
					rol = rs.getString("r.nombre");
					if (!"".equalsIgnoreCase(rol)) {
						usuario.setRolUsuario(rol);
					} else {
						System.err.println("El Usuario no tiene rol");
						usuario = null;
					}
				}

			} catch (Exception e) {
				System.err.println("El usuario no tiene rol");
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
