package com.elorrieta.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.elorrieta.modelo.interfaces.IDAOEdicion;
import com.elorrieta.modelo.pojo.Curso;
import com.elorrieta.modelo.pojo.Edicion;
import com.elorrieta.modelo.pojo.Horario;

public class DAOEdicion implements IDAOEdicion {

	@Override
	public Edicion getByid(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Edicion getByName(String nombre) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Edicion> getAll() throws Exception {
		DAOCurso daoCurso = new DAOCurso();
		DAOHorario daoHorario =new DAOHorario();
		ArrayList<Edicion> listaEdiciones = new ArrayList<Edicion>();
		String sql = "SELECT * from edicion";
		try ( // Inicializar resultados con autoclosable
				Connection conn = DAOConectionManager.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();) {
			// Obtener resultado
			while (rs.next()) {
				Edicion edicion = new Edicion();
				edicion.setId(rs.getInt("id"));
				edicion.setCodigoLanbide(rs.getString("codigo_lanbide"));
				Curso curso = daoCurso.getByid(rs.getInt("id_curso"));
				edicion.setCurso(curso);
				Horario horario = daoHorario.getByid(rs.getInt("id_horario"));
				edicion.setHorario(horario);
				edicion.setFechaInicio(rs.getDate("fecha_inicio"));
				edicion.setFechaFin(rs.getDate("fecha_fin"));

				listaEdiciones.add(edicion);
			}
		} catch (Exception e) {
			System.out.println("Error en la consulta");
			e.printStackTrace();
		}
		return listaEdiciones;
	}

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

	@Override
	public int insert(Edicion pojoNuevo) throws Exception {
		int columnasAfectadas = -1, ultimaId = -1;
		DAOHorario daoHorario = new DAOHorario();
		DAOCurso daoCurso = new DAOCurso();
		int idHorario = daoHorario.insert(pojoNuevo.getHorario());
		int idCurso = daoCurso.insert(pojoNuevo.getCurso());

		String sqlHorario = "INSERT INTO edicion (codigo_lanbide," + "id_curso," + "id_horario," + "fecha_inicio,"
				+ "fecha_fin) " + "VALUES " + "(?, ?, ?, ?, ?);";
		try ( // Inicializar resultados con autoclosable
				Connection conn = DAOConectionManager.getConnection();
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

					} else {
						System.err.println("No se ha podido insertar la edicion");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			else {
				daoHorario.delete(idHorario);
				System.err.printf("ERROR\n idHorario=%d \n idCurso=%d ", idHorario, idCurso);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ultimaId;
	}

	public Edicion getByCodigoLanbide(String codigoLanbide) {
		Edicion edicion = new Edicion();
		String sql = "SELECT * from edicion WHERE codigo_lanbide = ? ";

		// Obtener resultado
		try ( // Inicializar resultados con autoclosable
				// Inicializar resultados con autoclosable
				Connection conn = DAOConectionManager.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, codigoLanbide);
			try (ResultSet rs = stmt.executeQuery();) {
				// Fetch data

				if (rs.next()) {
					edicion.setId(rs.getInt("id"));
					edicion.setCodigoLanbide(rs.getString("codigo_lanbide"));
					edicion.setFechaInicio(rs.getDate("fecha_inicio"));
					edicion.setFechaInicio(rs.getDate("fin"));
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

}
