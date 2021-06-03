package com.elorrieta.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
		aula.setNombre("nombre_aula");
		edicion.addAula(aula);
		return edicion;
	}

	@Override
	public Edicion getByid(int id) throws Exception {
		// TODO probar
		Edicion edicion = new Edicion();
		String sql = "SELECT * FROM v_edicion WHERE e.id = ?;";

		// // Obtener resultado
		// try ( // Inicializar resultados con autoclosable
		// PreparedStatement stmt = conn.prepareStatement(sql);) {
		// stmt.setInt(1, id);
		// try (ResultSet rs = stmt.executeQuery();) {
		// // Fetch data
		// if (rs.next()) {
		// edicion.setId(rs.getInt("id"));
		// edicion.setCualificacion(rs.getString("cualificacion"));
		// edicion.setCodigoUc(rs.getString("codigo_uc"));
		// edicion.setCompetencia(rs.getString("competencia"));
		// edicion.setCodigoAaff(rs.getString("codigo_aaff"));
		// edicion.setNombre(rs.getString("nombre"));
		// edicion.setHorasCurso(rs.getInt("horas_curso"));
		// }

		// else {
		// System.out.println("No existe el participante");
		// }

		// } catch (Exception e) {
		// e.printStackTrace();
		// }

		// } catch (Exception e) {
		// e.printStackTrace();
		// }

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
		try ( // Inicializar resultados con autoclosable
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();) {
			// Obtener resultado
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

	// public ArrayList<Edicion> getAll(DAOCurso daoCurso, DAOHorario daoHorario,
	// DAOAula daoAula) throws Exception {
	// ArrayList<Edicion> listaEdiciones = new ArrayList<Edicion>();
	// String sql = "SELECT * from edicion";
	// try ( // Inicializar resultados con autoclosable
	// PreparedStatement stmt = conn.prepareStatement(sql);
	// ResultSet rs = stmt.executeQuery();) {
	// // Obtener resultado
	// while (rs.next()) {
	// Edicion edicion = new Edicion();
	// edicion.setId(rs.getInt("id"));
	// edicion.setCodigoLanbide(rs.getString("codigo_lanbide"));
	// Curso curso = daoCurso.getByid(rs.getInt("id_curso"));
	// edicion.setCurso(curso);
	// Horario horario = daoHorario.getByid(rs.getInt("id_horario"));
	// edicion.setHorario(horario);
	// edicion.setFechaInicio(rs.getDate("fecha_inicio"));
	// edicion.setFechaFin(rs.getDate("fecha_fin"));
	// ArrayList<Aula> aulas = daoAula.getAll(edicion.getId());
	// edicion.setAulas(aulas);
	// listaEdiciones.add(edicion);
	// }
	// } catch (Exception e) {
	// System.out.println("Error en la consulta");
	// e.printStackTrace();
	// }
	// return listaEdiciones;
	// }

	@Override
	public Edicion delete(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Edicion update(Edicion pojoModificar) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public int insert(Edicion pojoNuevo, DAOCurso daoCurso, DAOHorario daoHorario, DAOAula daoAula) throws Exception {
		// TODO agregar aulas
		int columnasAfectadas = -1;
		int ultimaId = -1;
		DAOConectionManager.setAutoCommit(false);
		int idHorario = daoHorario.insert(pojoNuevo.getHorario());
		int idCurso = daoCurso.insert(pojoNuevo.getCurso());
		ArrayList<Integer> idsAulas = new ArrayList<Integer>();
		for (Aula aula : pojoNuevo.getAulas()) {
			idsAulas.add(daoAula.insert(aula));
		}

		String sqlHorario = "INSERT INTO edicion (codigo_lanbide," + "id_curso," + "id_horario," + "fecha_inicio,"
				+ "fecha_fin) " + "VALUES " + "(?, ?, ?, ?, ?);";
		try ( // Inicializar resultados con autoclosable
				PreparedStatement stmtInsert = conn.prepareStatement(sqlHorario,
						PreparedStatement.RETURN_GENERATED_KEYS);) {
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
						for (Integer idAula : idsAulas) {
							insertAulasEdicion(idAula, ultimaId);
						}

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

	private void insertAulasEdicion(int idAula, int idEdicion) throws Exception {
		String sqlAulasEdicion = "INSERT INTO edicion_aulas (id_aula," + "id_edicion) " + "VALUES " + "(?, ?);";
		try ( // Inicializar resultados con autoclosable
				PreparedStatement stmtInsert = conn.prepareStatement(sqlAulasEdicion);) {
			stmtInsert.setInt(1, idAula);
			stmtInsert.setInt(2, idEdicion);
			stmtInsert.executeUpdate();
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

}
