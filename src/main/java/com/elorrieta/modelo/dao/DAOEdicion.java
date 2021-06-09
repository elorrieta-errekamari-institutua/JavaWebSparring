package com.elorrieta.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.elorrieta.modelo.interfaces.IDAOEdicion;
import com.elorrieta.modelo.pojo.Aula;
import com.elorrieta.modelo.pojo.Curso;
import com.elorrieta.modelo.pojo.Edicion;
import com.elorrieta.modelo.pojo.Horario;

public class DAOEdicion implements IDAOEdicion {

	Connection conn;

	/**
	 * Constructor vacio
	 * 
	 * @throws Exception
	 */
	public DAOEdicion() throws Exception {
		super();
		conn = DAOConectionManager.getConnection();
	}

	/**
	 * Devuelve un objeto Edicion con los valores recogidos del Resultset
	 * 
	 * @param rs resultSet de un SELECT * FROM v_ediciones
	 * @return Edicion con todos los parametros obtenidos en la consulta
	 * @throws SQLException
	 */
	private Edicion mapper(ResultSet rs) throws SQLException {
		Edicion edicion = new Edicion();
		Curso curso = new Curso();
		Horario horario = new Horario();
		Aula aula = new Aula();
		edicion.setId(rs.getInt("id_edicion"));
		edicion.setCodigoLanbide(rs.getString("codigo_lanbide"));
		edicion.setFechaInicio(rs.getDate("fecha_inicio"));
		edicion.setFechaFin(rs.getDate("fecha_fin"));
		curso.setId(rs.getInt("id_curso"));
		curso.setCualificacion(rs.getString("cualificacion"));
		curso.setCodigoUc(rs.getString("codigo_uc"));
		curso.setCompetencia(rs.getString("competencia"));
		curso.setCodigoAaff(rs.getString("codigo_aaff"));
		curso.setNombre(rs.getString("nombre_curso"));
		curso.setHorasCurso(rs.getInt("horas_curso"));
		edicion.setCurso(curso);
		horario.setId(rs.getInt("id_horario"));
		horario.setLunesInicio(rs.getTime("lunes_inicio").toLocalTime());
		horario.setLunesFin(rs.getTime("lunes_fin").toLocalTime());
		horario.setMartesInicio(rs.getTime("martes_inicio").toLocalTime());
		horario.setMartesFin(rs.getTime("martes_fin").toLocalTime());
		horario.setMiercolesInicio(rs.getTime("miercoles_inicio").toLocalTime());
		horario.setMiercolesFin(rs.getTime("miercoles_fin").toLocalTime());
		horario.setJuevesInicio(rs.getTime("jueves_inicio").toLocalTime());
		horario.setJuevesFin(rs.getTime("jueves_fin").toLocalTime());
		horario.setViernesInicio(rs.getTime("viernes_inicio").toLocalTime());
		horario.setViernesFin(rs.getTime("viernes_fin").toLocalTime());
		edicion.setHorario(horario);
		aula.setId(rs.getInt("id_aula"));
		aula.setNombre(rs.getString("nombre_aula"));
		edicion.addAula(aula);
		return edicion;
	}

	@Override
	public Edicion getByid(int id) throws Exception {
		Edicion edicion = new Edicion();
		String sql = "SELECT * FROM v_ediciones WHERE id_edicion = ?;";

		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setInt(1, id);

			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					if (edicion.getId() < 0) {
						edicion = mapper(rs);
					} else {
						Edicion edicionTemporal = mapper(rs);
						ArrayList<Aula> aulasTemporal = edicionTemporal.getAulas();
						edicion.addAulas(aulasTemporal);
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Error en la consulta");
			e.printStackTrace();
		}
		return edicion;
	}

	@Override
	public ArrayList<Edicion> getAll() throws Exception {
		// Utilizamos un hashmap para comprobar facilmente si la consulta muestra varios
		// resultados de la misma edicion y actualizar solo los valores relevantes
		HashMap<Integer, Edicion> hmEdiciones = new HashMap<Integer, Edicion>();
		Edicion edicion;
		String sql = "SELECT * from v_ediciones;";

		try (PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery();) {

			while (rs.next()) {
				edicion = mapper(rs);

				int idEdicion = edicion.getId();
				// Si una misma edicion aparece varias veces solo es necesario agregar nuevas
				// aulas
				if (hmEdiciones.containsKey(idEdicion)) {
					Edicion edicionTemporal = hmEdiciones.get(idEdicion);
					ArrayList<Aula> aulasTemporal = edicionTemporal.getAulas();
					edicion.addAulas(aulasTemporal);
				}
				hmEdiciones.put(idEdicion, edicion);
			}
		} catch (Exception e) {
			System.out.println("Error en la consulta");
			e.printStackTrace();
		}
		ArrayList<Edicion> listaEdiciones = new ArrayList<Edicion>(hmEdiciones.values());
		return listaEdiciones;
	}

	/**
	 * Elimina la edicion y su horario asociado
	 * 
	 * @param id         El id del objeto a borrar
	 * @param daoHorario DAOHorario
	 * @return El objeto borrado.
	 * @throws Exception
	 */
	public Edicion delete(int id, DAOHorario daoHorario) throws Exception {
		Edicion edicion = null;

		String sql = "DELETE from edicion WHERE id = ?";

		try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

			edicion = getByid(id);
			if (edicion.getId() > 0) {
				stmt.setInt(1, id);
				stmt.executeUpdate();
				// Tras eliminar la edicion eliminamos tambien el horario asociado
				daoHorario.delete(edicion.getHorario().getId());
			} else {
				System.err.println("El curso que se quiere borrar no existe");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return edicion;
	}

	/***
	 * Modifica un objeto en la base de datos
	 * 
	 * @param pojoModifciar POJO con los nuevos datos a guardar en la DB
	 * @param daoHorario    DAOHorario
	 * @return El POJO el registro modificado en la DB
	 * @throws Exception
	 */
	public Edicion update(Edicion pojoModificar, DAOHorario daoHorario) throws Exception {
		Edicion edicion = null;
		// Desactivamos autoCommit para poder hacer rollback si alguna de las
		// modificaciones falla
		DAOConectionManager.setAutoCommit(false);
		int id = pojoModificar.getId();
		// Actualizamos el horario y la relacion con aulas
		try {
			daoHorario.update(pojoModificar.getHorario());
			ArrayList<Integer> idsAulas = new ArrayList<Integer>();
			for (Aula aula : pojoModificar.getAulas()) {
				idsAulas.add(aula.getId());
			}
			deleteAulasEdicion(id);
			insertAulasEdicion(id, idsAulas);
		} catch (Exception e) {
			conn.rollback();
			throw e;
		}

		// Actualizamos la edicion
		String sql = "UPDATE edicion SET codigo_lanbide = ? , fecha_inicio = ?, fecha_fin = ?, id_curso = ?, id_horario = ? WHERE id = ?";

		try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
			edicion = getByid(id);

			if (edicion.getId() > 0) {
				stmt.setString(1, pojoModificar.getCodigoLanbide());
				stmt.setDate(2, pojoModificar.getFechaInicio());
				stmt.setDate(3, pojoModificar.getFechaFin());
				stmt.setInt(4, pojoModificar.getCurso().getId());
				stmt.setInt(5, pojoModificar.getHorario().getId());
				stmt.setInt(6, id);
				int columnasAfectadas = stmt.executeUpdate();
				if (columnasAfectadas > 0) {
					edicion = getByid(id);
				}
				// Si todo ha ido bien actualizamos en la base de datos
				conn.commit();
			} else {
				System.err.println("La edicion que se quiere actualizar no existe");
			}
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		} finally {
			// Nos aseguramos de reactivar autoCommit
			DAOConectionManager.setAutoCommit(true);
		}
		return edicion;
	}

	/***
	 * Insera un objeto en la base dedatos
	 * 
	 * @param pojoNuevo  POJO del nuevo objeto a insertar
	 * @param daoCurso   DAOCurso
	 * @param daoHorario DAOHorario
	 * @param daoAula    DAOAula
	 * @return id del objeto insertado o el original si ya existia
	 * @throws Exception
	 */
	public int insert(Edicion pojoNuevo, DAOCurso daoCurso, DAOHorario daoHorario, DAOAula daoAula) throws Exception {
		int columnasAfectadas = -1;
		int ultimaId = -1;
		// Desactivamos autoCommit para poder hacer rollback si alguna de las
		// modificaciones falla
		DAOConectionManager.setAutoCommit(false);

		// Insertamos el horario y si es necesario el curso y las aulas
		int idCurso = pojoNuevo.getCurso().getId();
		// Si el curso que llega no tiene id lo insertamos
		if (idCurso < 0) {
			idCurso = daoCurso.insert(pojoNuevo.getCurso());
		}
		int idHorario = daoHorario.insert(pojoNuevo.getHorario());
		ArrayList<Integer> idsAulas = new ArrayList<Integer>();

		for (Aula aula : pojoNuevo.getAulas()) {
			int idAula = aula.getId();
			if (idAula < 0) {
				idAula = daoAula.insert(aula);
			}
			idsAulas.add(idAula);
		}

		// Insertamos la edicion
		String sql = "INSERT INTO edicion (codigo_lanbide, id_curso, id_horario, fecha_inicio, fecha_fin) "
				+ "VALUES (?, ?, ?, ?, ?);";
		try (PreparedStatement stmtInsert = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);) {

			stmtInsert.setString(1, pojoNuevo.getCodigoLanbide());
			stmtInsert.setInt(2, idCurso);
			stmtInsert.setInt(3, idHorario);
			stmtInsert.setDate(4, pojoNuevo.getFechaInicio());
			stmtInsert.setDate(5, pojoNuevo.getFechaFin());

			if (idHorario != -1 && idCurso != -1) {
				columnasAfectadas = stmtInsert.executeUpdate();
				try (ResultSet rs = stmtInsert.getGeneratedKeys()) {

					if (columnasAfectadas > 0 && rs.next()) {
						ultimaId = rs.getInt(1);
						pojoNuevo.setId(ultimaId);
						// insertamos las relaciones entre la edicion y sus aulas
						insertAulasEdicion(ultimaId, idsAulas);

					} else {
						System.err.println("No se ha podido insertar la edicion");
					}
				} catch (Exception e) {
					conn.rollback();
					throw e;
				}
			} else {
				System.err.printf("ERROR\n idHorario=%d \n idCurso=%d ", idHorario, idCurso);
				conn.rollback();
			}
			// Si todo ha ido bien actualizamos en la base de datos
			conn.commit();

		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		} finally {
			// Nos aseguramos de reactivar autoCommit
			DAOConectionManager.setAutoCommit(true);
		}

		return ultimaId;
	}

	/**
	 * Rellena la tabla intermedia entre Edicion y Aula con las relaciones entre una
	 * edicion y sus aulas
	 * 
	 * @param idEdicion el id de la edicion a la que pertenecen las aulas
	 * @param idsAulas  ArrayList<Integer> con las ids de todas las aulas
	 * @throws Exception
	 */
	private void insertAulasEdicion(int idEdicion, ArrayList<Integer> idsAulas) throws Exception {
		for (Integer idAula : idsAulas) {
			String sqlAulasEdicion = "INSERT INTO edicion_aulas (id_edicion, id_aula) " + "VALUES (?, ?);";

			try (PreparedStatement stmtInsert = conn.prepareStatement(sqlAulasEdicion);) {

				stmtInsert.setInt(1, idEdicion);
				stmtInsert.setInt(2, idAula);
				stmtInsert.executeUpdate();
			}
		}
	}

	/**
	 * Elimina de la tabla intermedia entre Edicion y Aula todas las entradas de una
	 * edicion
	 * 
	 * @param idEdicion el id de la edicion cuyas relaciones queremos eliminar
	 * @throws SQLException
	 */
	private void deleteAulasEdicion(int idEdicion) throws SQLException {
		String sql = "DELETE FROM edicion_aulas WHERE id_edicion = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setInt(1, idEdicion);
			stmt.executeUpdate();
		}
	}

	/**
	 * Busca una edicion en la base de datos por su codigo de Lanbide
	 * 
	 * @param codigoLanbide El codigo de Lanbide de la edicion a devolver
	 * @return Edicion edicion con el codigo de Lanbide
	 * @throws Exception
	 */
	public Edicion getByCodigoLanbide(String codigoLanbide) {

		Edicion edicion = new Edicion();
		String sql = "SELECT * FROM v_ediciones WHERE codigo_lanbide = ?;";

		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, codigoLanbide);

			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					if (edicion.getId() < 0) {
						edicion = mapper(rs);
					} else {
						Edicion edicionTemporal = mapper(rs);
						ArrayList<Aula> aulasTemporal = edicionTemporal.getAulas();
						edicion.addAulas(aulasTemporal);
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Error en la consulta");
			e.printStackTrace();
		}
		return edicion;
	}

	/**
	 * Las ediciones no son reconocibles solo por su nombre
	 */
	@Override
	public Edicion getByName(String nombre) throws Exception {
		throw new Exception("No se pueden consultar ediciones por su nombre");
	}

	/**
	 * Para ediciones debe utilizarse el metodo insert(Edicion pojoNuevo, DAOCurso
	 * daoCurso, DAOHorario daoHorario, DAOAula daoAula)
	 */
	@Override
	public int insert(Edicion pojoNuevo) throws Exception {
		throw new Exception(
				"Debe utilizarse el metodo insert(Edicion pojoNuevo, DAOCurso daoCurso, DAOHorario daoHorario, DAOAula daoAula)");
	}

	/**
	 * Para ediciones debe utilizarse el metodo update(Edicion pojoModificar,
	 * DAOHorario daoHorario)
	 */
	@Override
	public Edicion update(Edicion pojoModificar) throws Exception {
		throw new Exception("Debe utilizarse el metodo update(Edicion pojoModificar, DAOHorario daoHorario)");
	}

	/**
	 * Para ediciones debe utilizarse el metodo delete(int id, DAOHorario
	 * daoHorario)
	 */
	@Override
	public Edicion delete(int id) throws Exception {
		throw new Exception("Debe utilizarse el metodo delete(int id, DAOHorario daoHorario)");
	}

}
