package com.elorrieta.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;

import com.elorrieta.modelo.interfaces.IDAOCurso;
import com.elorrieta.modelo.pojo.Curso;

public class DAOCurso implements IDAOCurso {

	Connection conn;

	/**
	 * Constructor vacio
	 * 
	 * @throws Exception
	 */
	public DAOCurso() throws Exception {
		super();
		conn = DAOConectionManager.getConnection();
	}

	@Override
	public Curso getByid(int id) throws Exception {
		Curso curso = new Curso();
		String sql = "SELECT * from curso WHERE id= ? ;";

		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setInt(1, id);
			try (ResultSet rs = stmt.executeQuery();) {

				if (rs.next()) {
					curso.setId(rs.getInt("id"));
					curso.setCualificacion(rs.getString("cualificacion"));
					curso.setCodigoUc(rs.getString("codigo_uc"));
					curso.setCompetencia(rs.getString("competencia"));
					curso.setCodigoAaff(rs.getString("codigo_aaff"));
					curso.setNombre(rs.getString("nombre"));
					curso.setHorasCurso(rs.getInt("horas_curso"));
				}

				else {
					System.out.println("No existe el participante");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return curso;
	}

	@Override
	public Curso getByName(String nombre) throws Exception {
		Curso curso = new Curso();
		String sql = "SELECT * from curso WHERE nombre = ? ";

		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, nombre);
			try (ResultSet rs = stmt.executeQuery();) {

				if (rs.next()) {
					curso.setId(rs.getInt("id"));
					curso.setCualificacion(rs.getString("cualificacion"));
					curso.setCodigoUc(rs.getString("codigo_uc"));
					curso.setCompetencia(rs.getString("competencia"));
					curso.setCodigoAaff(rs.getString("codigo_aaff"));
					curso.setNombre(rs.getString("nombre"));
					curso.setHorasCurso(rs.getInt("horas_curso"));
				}

				else {
					System.out.println("No hay ningun curso con ese nombre");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return curso;
	}

	@Override
	public ArrayList<Curso> getAll() throws Exception {
		ArrayList<Curso> listaCurso = new ArrayList<>();
		String sql = "SELECT * from curso";

		try (PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery();) {

			while (rs.next()) {
				Curso curso = new Curso();
				curso.setId(rs.getInt("id"));
				curso.setCualificacion(rs.getString("cualificacion"));
				curso.setCodigoUc(rs.getString("codigo_uc"));
				curso.setCompetencia(rs.getString("competencia"));
				curso.setCodigoAaff(rs.getString("codigo_aaff"));
				curso.setNombre(rs.getString("nombre"));
				curso.setHorasCurso(rs.getInt("horas_curso"));
				listaCurso.add(curso);
			}
		} catch (Exception e) {
			System.out.println("Error en la consulta");
			e.printStackTrace();
		}
		return listaCurso;
	}

	@Override
	public Curso delete(int id) throws Exception {
		Curso curso = null;

		String sql = "DELETE from curso WHERE id = ?";

		try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

			curso = getByid(id);

			if (curso.getId() > 0) {
				stmt.setInt(1, id);
				stmt.executeUpdate();
			} else {
				System.err.println("El curso que se quiere borrar no existe");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return curso;
	}

	@Override
	public Curso update(Curso pojoModificar) throws Exception {
		int id = pojoModificar.getId();
		Curso curso = null;

		String sql = "UPDATE curso SET cualificacion = ? , codigo_uc = ?, competencia = ?,"
				+ "codigo_aaff = ?, nombre = ?, horas_curso = ? WHERE id = ?";

		try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

			curso = getByid(id);

			if (curso.getId() > 0) {

				stmt.setString(1, pojoModificar.getCualificacion());
				stmt.setString(2, pojoModificar.getCodigoUc());
				stmt.setString(3, pojoModificar.getCompetencia());
				stmt.setString(4, pojoModificar.getCodigoAaff());
				stmt.setString(5, pojoModificar.getNombre());
				stmt.setInt(6, pojoModificar.getHorasCurso());
				stmt.setInt(7, id);
				int columnasAfectadas = stmt.executeUpdate();
				if (columnasAfectadas > 0)
					curso = getByid(id);
			} else {
				System.err.println("El curso que se quiere actualizar no existe");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return curso;
	}

	@Override
	public int insert(Curso pojoNuevo) throws Exception {
		int columnasAfectadas = -1;
		int ultimaId = -1;
		String sqlInsert = "INSERT INTO curso (cualificacion, codigo_uc, competencia,"
				+ "codigo_aaff, nombre, horas_curso) VALUES(?, ?, ?, ?, ?, ?);";

		try (PreparedStatement stmtInsert = conn.prepareStatement(sqlInsert,
				PreparedStatement.RETURN_GENERATED_KEYS);) {

			stmtInsert.setString(1, pojoNuevo.getCualificacion());
			stmtInsert.setString(2, pojoNuevo.getCodigoUc());
			stmtInsert.setString(3, pojoNuevo.getCompetencia());
			stmtInsert.setString(4, pojoNuevo.getCodigoAaff());
			stmtInsert.setString(5, pojoNuevo.getNombre());
			stmtInsert.setInt(6, pojoNuevo.getHorasCurso());

			columnasAfectadas = stmtInsert.executeUpdate();

			try (ResultSet rs = stmtInsert.getGeneratedKeys()) {
				// Si se ha insertado el curso
				if (columnasAfectadas > 0 && rs.next()) {
					// Obterner linea de la base de datos
					ultimaId = rs.getInt(1);
					pojoNuevo.setId(ultimaId);

				} else {
					System.err.println("No se ha podido insertar el curso");
				}
			}

		} catch (SQLIntegrityConstraintViolationException e) {
			ultimaId = getByCodigos(pojoNuevo.getNombre(), pojoNuevo.getCodigoUc(), pojoNuevo.getCodigoAaff()).getId();
		}
		return ultimaId;
	}

	@Override
	public Curso getByCodigos(String nombre, String codigoUc, String codigoAaff) throws Exception {
		Curso curso = new Curso();
		String sql = "SELECT * from curso WHERE codigo_aaff = ? AND codigo_uc = ? AND nombre = ? ";

		// Obtener resultado
		try ( // Inicializar resultados con autoclosable
				// Inicializar resultados con autoclosable
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, codigoAaff);
			stmt.setString(2, codigoUc);
			stmt.setString(3, nombre);
			try (ResultSet rs = stmt.executeQuery();) {
				// Fetch data

				if (rs.next()) {
					curso.setId(rs.getInt("id"));
					curso.setCualificacion(rs.getString("cualificacion"));
					curso.setCodigoUc(rs.getString("codigo_uc"));
					curso.setCompetencia(rs.getString("competencia"));
					curso.setCodigoAaff(rs.getString("codigo_aaff"));
					curso.setNombre(rs.getString("nombre"));
					curso.setHorasCurso(rs.getInt("horas_curso"));
				}

				else {
					System.out.println("No hay ningun curso con ese nombre");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return curso;
	}

}
