package modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
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
		// Conectar
		DAOConnectionManager connectionManager = new DAOConnectionManager();
		Connection conn = null;
		conn = connectionManager.open();

		// Obtener resultado
		Usuario usuario = new Usuario();
		String sql = "SELECT * from usuarios WHERE id=" + id;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		// Fetch data
		if (rs.next()) {
			usuario.setId(rs.getInt("id"));
			usuario.setNombre(rs.getString("nombre"));
			usuario.setPassword(rs.getString("pass"));
		}

		else {
			System.out.println("No existe el usuario");
		}
		// Cerrar conexion
		connectionManager.close();

		return usuario;
	}

	/**
	 * Devuelve todos los usuarios en la base de datos
	 * 
	 * @param none
	 * @return Lista de <Usuario>.
	 */
	@Override
	public List<Usuario> getAll() throws Exception {

		List<Usuario> lista = new ArrayList<>();
		// Conectar
		DAOConnectionManager connectionManager = new DAOConnectionManager();
		Connection conn = null;
		conn = connectionManager.open();

		// Obtener resultado
		String sql = "SELECT * from usuarios";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			Usuario usuario = new Usuario();
			usuario.setId(rs.getInt("id"));
			usuario.setNombre(rs.getString("nombre"));
			usuario.setPassword(rs.getString("pass"));
			lista.add(usuario);
		}

		// Cerrar conexion
		connectionManager.close();
		return lista;
	}

	@Override
	public Usuario delete(int id) throws Exception {
		// Conectar
		DAOConnectionManager connectionManager = new DAOConnectionManager();
		Connection conn = null;
		conn = connectionManager.open();

		// Borrar usuario
		Usuario usuario = null;
		usuario = getByid(id);
		if (usuario.getId() != 0) {
			conn = connectionManager.open();
			String sql = "DELETE from usuarios WHERE id=" + id;
			Statement stmt = conn.createStatement();
			stmt.execute(sql);
		} else {
			System.err.println("El usuario que se quiere borrar no existe");
		}

		// Cerrar conexion
		connectionManager.close();

		return usuario;
	}

	@Override
	public Usuario update(Usuario pojoModifciar) throws Exception {
		// Conectar
		DAOConnectionManager connectionManager = new DAOConnectionManager();
		Connection conn = null;
		conn = connectionManager.open();
		int id = pojoModifciar.getId();

		// Actualizar usuario
		Usuario usuario = null;
		usuario = getByid(id);
		if (usuario.getId() != 0) {
			conn = connectionManager.open();
			String sql = "UPDATE usuarios\n" + "SET  nombre = '" + pojoModifciar.getNombre() + "',\n     pass = '"
					+ pojoModifciar.getPassword() + "'\nWHERE\n     id=" + id;
			Statement stmt = conn.createStatement();
			stmt.execute(sql);
		} else {
			System.err.println("El usuario que se quiere actualizar no existe");
		}

		// Cerrar conexion
		connectionManager.close();

		return getByid(id);
	}

	@Override
	public int insert(Usuario pojoNuevo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Usuario login(String nombre, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
