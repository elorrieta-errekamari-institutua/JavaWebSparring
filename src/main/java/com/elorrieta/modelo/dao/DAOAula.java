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

public class DAOAula implements IDAOAula {

	private boolean autoCommit = true;

	/**
	 * Constructor vacio
	 */
	public DAOAula(){
		super();
	}

	/**
	 * Crea el dao con la opcion de autocommit
	 * @param autoCommit
	 */
	public DAOAula(boolean autoCommit) {
		super();
		this.autoCommit = autoCommit;
	}

	/**
	 * Devuelve un objeto de tipo Aula
	 * 
	 * @param id El id del aula que se quiere recuperar
	 * @return POJO Aula
	 */
	@Override
	public Aula getByid(int id) throws Exception {
		Aula aula = new Aula();
		String sql = "SELECT * from aula WHERE id= ? ;";

		// Obtener resultado
		try ( // Inicializar resultados con autoclosable
				Connection conn = DAOConectionManager.getConnection(autoCommit);
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setInt(1, id);
			try (ResultSet rs = stmt.executeQuery();) {
				// Fetch data
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

	/**
	 * Devuelve un objeto de tipo Aula
	 * 
	 * @param nombre El nombre del aula que se quiere recuperar
	 * @return POJO Aula
	 */
	@Override
	public Aula getByName(String nombre) throws Exception {
		Aula aula = new Aula();
		String sql = "SELECT * from aula WHERE nombre = ? ";

		// Obtener resultado
		try ( // Inicializar resultados con autoclosable
				Connection conn = DAOConectionManager.getConnection(autoCommit);
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, nombre);
			try (ResultSet rs = stmt.executeQuery();) {
				// Fetch data
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

	/**
	 * Devuelve todos las aulas en la base de datos
	 * 
	 * @return Lista de Aulas.
	 */
	@Override
	public ArrayList<Aula> getAll() throws Exception {
		ArrayList<Aula> lista = new ArrayList<>();
		String sql = "SELECT * from aula";
		try ( // Inicializar resultados con autoclosable
				Connection conn = DAOConectionManager.getConnection(autoCommit);
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

	/**
	 * Borra un aula tras buscarla por id
	 * 
	 * @param id La id del aula que se quiere borrar
	 * @return El aula borrada.
	 */
	@Override
	public Aula delete(int id) throws Exception {
		Aula aula = null;

		String sql = "DELETE from aula WHERE id = ?";

		try ( // Inicializar resultados con autoclosable
				Connection conn = DAOConectionManager.getConnection(autoCommit);
				PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
			aula = getByid(id);
			if (aula.getId() > 0) {
				// Borrar aula
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

	/**
	 * Actualiza un aula con los datos de del POJO que recibe por parametro
	 * 
	 * @param Usuario pojoModificar El usuario al que se quiere actualizar
	 * @return Usuario El usuario actualizado.
	 */
	@Override
	public Aula update(Aula pojoModificar) throws Exception {
		int id = pojoModificar.getId();
		Aula aula = null;
		String nuevoNombre = pojoModificar.getNombre();

		String sql = "UPDATE aula SET  nombre = ? WHERE id = ?";
		try ( // Inicializar resultados con autoclosable
				Connection conn = DAOConectionManager.getConnection(autoCommit);
				PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
			aula = getByid(id);
			if (aula.getId() > 0) {
				// Actualizar usuario
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

	/**
	 * Inserta un nuevo aula con los datos de del POJO que recibe por parametro
	 * 
	 * @param pojoNuevo El aula que se quiere insertar
	 * @return El id del nuevo aula.
	 */
	@Override
	public int insert(Aula pojoNuevo) throws Exception {
		int columnasAfectadas = -1;
		int ultimaId = -1;
		String sqlInsert = "INSERT INTO aula (nombre) VALUES(?);";

		try ( // Inicializar resultados con autoclosable
				Connection conn = DAOConectionManager.getConnection(autoCommit);
				PreparedStatement stmtInsert = conn.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);) {
			stmtInsert.setString(1, pojoNuevo.getNombre());
			columnasAfectadas = stmtInsert.executeUpdate();
			try (ResultSet rs = stmtInsert.getGeneratedKeys()) {
				// Si se ha insertado el usuario
				if (columnasAfectadas > 0 && rs.next()) {
					// Obterner linea de la base de datos
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
	 * @return Todas las aulas de la edicion
	 */
	public ArrayList<Aula> getAll(int id) {
		// TODO probar
		ArrayList<Aula> lista = new ArrayList<>();
		String sql = "SELECT id_aula from edicion_aulas WHERE id_edicion = ?;";
		try ( // Inicializar resultados con autoclosable
				Connection conn = DAOConectionManager.getConnection(autoCommit);
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setInt(1, id);
			try (ResultSet rs = stmt.executeQuery();) {
				// Obtener resultado
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

}
