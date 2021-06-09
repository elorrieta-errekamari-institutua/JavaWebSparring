package com.elorrieta.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;

import com.elorrieta.modelo.interfaces.IDAOAula;
import com.elorrieta.modelo.pojo.Aula;

/**
 * Clase DAOAula implementa IDAOAula
 * 
 * Contiene los metodos para interactuar con aulas en la base de datos
 * 
 * @see IDAOAula
 */
public class DAOAula implements IDAOAula {

	Connection conn;

	/**
	 * Constructor vacio
	 * 
	 * @throws Exception
	 */
	public DAOAula() throws Exception {
		super();
		conn = DAOConectionManager.getConnection();
	}

	@Override
	public Aula getByid(int id) throws Exception {
		Aula aula = new Aula();
		String sql = "SELECT * from aula WHERE id= ? ;";

		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setInt(1, id);
			try (ResultSet rs = stmt.executeQuery();) {

				if (rs.next()) {
					aula.setId(rs.getInt("id"));
					aula.setNombre(rs.getString("nombre"));
				}

				else {
					System.out.println("No existe el aula");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return aula;
	}

	@Override
	public Aula getByName(String nombre) throws Exception {
		Aula aula = new Aula();
		String sql = "SELECT * from aula WHERE nombre = ? ";

		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, nombre);
			try (ResultSet rs = stmt.executeQuery();) {

				if (rs.next()) {
					aula.setId(rs.getInt("id"));
					aula.setNombre(rs.getString("nombre"));
				}

				else {
					System.out.println("No existe el aula");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return aula;
	}

	@Override
	public ArrayList<Aula> getAll() throws Exception {
		ArrayList<Aula> lista = new ArrayList<>();
		String sql = "SELECT * from aula";
		try (PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery();) {

			while (rs.next()) {
				Aula aula = new Aula();
				aula.setId(rs.getInt("id"));
				aula.setNombre(rs.getString("nombre"));
				lista.add(aula);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public Aula delete(int id) throws Exception {
		Aula aula = null;

		String sql = "DELETE from aula WHERE id = ?";

		try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

			aula = getByid(id);
			if (aula.getId() > 0) {
				stmt.setInt(1, id);
				stmt.executeUpdate();
			} else {
				System.err.println("El aula que se quiere borrar no existe");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return aula;
	}

	@Override
	public Aula update(Aula pojoModificar) throws Exception {
		int id = pojoModificar.getId();
		Aula aula = null;
		String nuevoNombre = pojoModificar.getNombre();

		String sql = "UPDATE aula SET  nombre = ? WHERE id = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

			aula = getByid(id);

			if (aula.getId() > 0) {
				stmt.setString(1, nuevoNombre);
				stmt.setInt(2, id);
				stmt.executeUpdate();
				aula = getByid(id);
			} else {
				System.err.println("El aula que se quiere actualizar no existe");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return aula;
	}

	@Override
	public int insert(Aula pojoNuevo) throws Exception {
		int columnasAfectadas = -1;
		int ultimaId = -1;
		String sql = "INSERT INTO aula (nombre) VALUES(?);";

		try (PreparedStatement stmtInsert = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

			stmtInsert.setString(1, pojoNuevo.getNombre());
			columnasAfectadas = stmtInsert.executeUpdate();
			try (ResultSet rs = stmtInsert.getGeneratedKeys()) {
				// Si se ha insertado el aula
				if (columnasAfectadas > 0 && rs.next()) {
					// Obterner id de la base de datos
					ultimaId = rs.getInt(1);

				} else {
					System.err.println("No se ha podido insertar el usuario");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (SQLIntegrityConstraintViolationException e) {
			ultimaId = getByName(pojoNuevo.getNombre()).getId();
		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		}
		return ultimaId;
	}

	/**
	 * Devuelve todas las aulas de una edicion
	 * 
	 * @param id de una edicion
	 * @return ArrayList Todas las aulas de la edicion
	 * @throws Exception
	 */
	public ArrayList<Aula> getAll(int id) throws Exception {

		ArrayList<Aula> lista = new ArrayList<>();
		String sql = "SELECT id_aula from edicion_aulas WHERE id_edicion = ?;";

		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setInt(1, id);

			try (ResultSet rs = stmt.executeQuery();) {

				while (rs.next()) {
					int idAula = rs.getInt("id_aula");
					Aula aula = getByid(idAula);
					lista.add(aula);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	/**
	 * Devuelve la lista de aulas que contienen name en su nombre
	 * 
	 * @param name Nombre que buscar
	 * @return ArrayList Aulas encontradas
	 */
	public ArrayList<Aula> getByPartialName(String name) {
		ArrayList<Aula> lista = new ArrayList<>();
		String sql = "SELECT * from aula WHERE nombre LIKE '%" + name + "%'";
		try ( // Inicializar resultados con autoclosable
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();) {
			// Obtener resultado
			while (rs.next()) {
				Aula aula = new Aula();
				aula.setId(rs.getInt("id"));
				aula.setNombre(rs.getString("nombre"));
				lista.add(aula);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

}
