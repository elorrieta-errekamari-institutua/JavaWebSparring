package modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import modelo.pojo.Usuario;

public class DAOUsuario implements IDAOUsuario {

	@Override
	public Usuario getByid(int id) throws Exception {
		DAOConnectionManager connectionManager = new DAOConnectionManager();
		Connection conn = null;
		conn = connectionManager.open();

		Usuario usuario = new Usuario();
		String sql = "SELECT * from usuarios WHERE id=" + id;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		usuario.setId(rs.getInt("id"));
		usuario.setNombre(rs.getString("nombre"));
		usuario.setPassword(rs.getString("pass"));
		connectionManager.close();

		return usuario;
	}

	@Override
	public List<Usuario> getByAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario delete(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario update(Usuario pojoModifciar) throws Exception {
		// TODO Auto-generated method stub
		return null;
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
