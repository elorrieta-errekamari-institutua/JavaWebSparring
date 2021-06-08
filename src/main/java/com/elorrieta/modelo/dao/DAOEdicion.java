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
	 * Crea el dao con la opcion de autocommit
	 * 
	 * @param autoCommit
	 * @throws Exception
	 */
	public DAOEdicion(boolean autoCommit) throws Exception {
		this();
		conn.setAutoCommit(autoCommit);
	}

	/**
	 * Devuelve un objeto Edicion con los valores recogidos del Resultset
	 * 
	 * @param rs
	 * @return
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
		// TODO probar
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
	public Edicion getByName(String nombre) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Edicion> getAll() throws Exception {
		HashMap<Integer, Edicion> hmEdiciones = new HashMap<Integer, Edicion>();
		Edicion edicion;
		String sql = "SELECT * from v_ediciones;";
		try (PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery();) {
			while (rs.next()) {
				edicion = mapper(rs);
				int idEdicion = edicion.getId();
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

	public Edicion delete(int id, DAOHorario daoHorario) throws Exception {
		Edicion edicion = null;

		String sql = "DELETE from edicion WHERE id = ?";

		try ( // Inicializar resultados con autoclosable
				PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
			edicion = getByid(id);
			if (edicion.getId() > 0) {
				stmt.setInt(1, id);
				stmt.executeUpdate();
				daoHorario.delete(edicion.getHorario().getId());
			} else {
				System.err.println("El curso que se quiere borrar no existe");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return edicion;
	}

	public Edicion update(Edicion pojoModificar, DAOHorario daoHorario) throws Exception {
		// TODO probar
		Edicion edicion = null;
		DAOConectionManager.setAutoCommit(false);
		int id = pojoModificar.getId();
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

		String sql = "UPDATE edicion SET codigo_lanbide = ? , fecha_inicio = ?, fecha_fin = ?, id_curso = ?, id_horario = ? WHERE id = ?";
		try ( // Inicializar resultados con autoclosable
				PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
			edicion = getByid(id);
			if (edicion.getId() > 0) {
				// Actualizar curso
				stmt.setString(1, pojoModificar.getCodigoLanbide());
				stmt.setDate(2, pojoModificar.getFechaInicio());
				stmt.setDate(3, pojoModificar.getFechaFin());
				stmt.setInt(4, pojoModificar.getCurso().getId());
				stmt.setInt(5, pojoModificar.getHorario().getId());
				stmt.setInt(6, id);
				int columnasAfectadas = stmt.executeUpdate();
				if (columnasAfectadas > 0)
					edicion = getByid(id);
			} else {
				System.err.println("La edicion que se quiere actualizar no existe");
				return null;
			}
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
			conn.commit();
		} finally {
			DAOConectionManager.setAutoCommit(true);
		}
		return edicion;
	}

	public int insert(Edicion pojoNuevo, DAOCurso daoCurso, DAOHorario daoHorario, DAOAula daoAula) throws Exception {
		int columnasAfectadas = -1;
		int ultimaId = -1;
		DAOConectionManager.setAutoCommit(false);
		int idHorario = daoHorario.insert(pojoNuevo.getHorario());
		int idCurso = pojoNuevo.getCurso().getId();
		// Si el curso que llega no tiene id lo insertamos
		if (idCurso < 0) {
			idCurso = daoCurso.insert(pojoNuevo.getCurso());
		}
		ArrayList<Integer> idsAulas = new ArrayList<Integer>();
		for (Aula aula : pojoNuevo.getAulas()) {
			idsAulas.add(daoAula.insert(aula));
		}

		String sql = "INSERT INTO edicion (codigo_lanbide," + "id_curso," + "id_horario," + "fecha_inicio,"
				+ "fecha_fin) " + "VALUES " + "(?, ?, ?, ?, ?);";
		try ( // Inicializar resultados con autoclosable
				PreparedStatement stmtInsert = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);) {
			stmtInsert.setString(1, pojoNuevo.getCodigoLanbide());
			stmtInsert.setInt(2, idCurso);
			stmtInsert.setInt(3, idHorario);
			stmtInsert.setDate(4, pojoNuevo.getFechaInicio());
			stmtInsert.setDate(5, pojoNuevo.getFechaFin());

			if (idHorario != -1 && idCurso != -1) {
				columnasAfectadas = stmtInsert.executeUpdate();
				try (ResultSet rs = stmtInsert.getGeneratedKeys()) {
					// Si se ha insertado el curso
					if (columnasAfectadas > 0 && rs.next()) {
						// Obterner linea de la base de datos
						ultimaId = rs.getInt(1);
						pojoNuevo.setId(ultimaId);
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
			conn.commit();

		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		} finally {
			DAOConectionManager.setAutoCommit(true);
		}

		return ultimaId;
	}

	private void insertAulasEdicion(int idEdicion, ArrayList<Integer> idsAulas) throws Exception {
		for (Integer idAula : idsAulas) {
			String sqlAulasEdicion = "INSERT INTO edicion_aulas (id_edicion, id_aula) " + "VALUES " + "(?, ?);";
			try ( // Inicializar resultados con autoclosable
					PreparedStatement stmtInsert = conn.prepareStatement(sqlAulasEdicion);) {
				stmtInsert.setInt(1, idEdicion);
				stmtInsert.setInt(2, idAula);
				stmtInsert.executeUpdate();
			}
		}
	}

	private void deleteAulasEdicion(int idEdicion) throws SQLException {
		String sql = "DELETE FROM edicion_aulas WHERE id_edicion = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setInt(1, idEdicion);
			stmt.executeUpdate();
		}
	}

	public Edicion getByCodigoLanbide(String codigoLanbide) {
		// TODO agregar curso, horario y aulas
		Edicion edicion = new Edicion();
		String sql = "SELECT * from edicion WHERE codigo_lanbide = ? ";

		// Obtener resultado
		try ( // Inicializar resultados con autoclosable
				// Inicializar resultados con autoclosable
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, codigoLanbide);
			try (ResultSet rs = stmt.executeQuery();) {
				// Fetch data

				if (rs.next()) {
					edicion.setId(rs.getInt("id"));
					edicion.setCodigoLanbide(rs.getString("codigo_lanbide"));
					edicion.setFechaInicio(rs.getDate("fecha_inicio"));
					edicion.setFechaFin(rs.getDate("fecha_fin"));
				}

				else {
					System.out.println("Mensaje que no se lee");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return edicion;
	}

	@Override
	public int insert(Edicion pojoNuevo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Edicion update(Edicion pojoModificar) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Edicion delete(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
