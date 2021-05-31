package com.elorrieta.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.util.List;

import com.elorrieta.modelo.interfaces.IDAOHorario;
import com.elorrieta.modelo.pojo.Horario;

public class DAOHorario implements IDAOHorario {

	@Override
	public Horario getByid(int id) throws Exception {
		Horario horario = new Horario();
		String sql = "SELECT * from horario WHERE id= ? ;";

		// Obtener resultado
		try ( // Inicializar resultados con autoclosable
				Connection conn = DAOConectionManager.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setInt(1, id);
			try (ResultSet rs = stmt.executeQuery();) {
				// Fetch data
				if (rs.next()) {
					horario.setId(rs.getInt("id"));
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

		return horario;
	}

	@Override
	public Horario getByName(String nombre) throws Exception {
		// TODO Auto-generated method stub
		throw new Exception("Metodo sin implementar");
	}

	@Override
	public List<Horario> getAll() throws Exception {
		// TODO Auto-generated method stub
		throw new Exception("Metodo sin implementar");
	}

	@Override
	public Horario delete(int id) throws Exception {
		Horario horario = null;

		String sql = "DELETE from horario WHERE id = ?";

		try ( // Inicializar resultados con autoclosable
				Connection conn = DAOConectionManager.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
			horario = getByid(id);
			if (horario.getId() > 0) {
				// Borrar usuario
				stmt.setInt(1, id);
				stmt.executeUpdate();
			} else {
				System.err.println("El horario que se quiere borrar no existe");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return horario;
	}

	@Override
	public Horario update(Horario pojoModificar) throws Exception {
		// TODO Auto-generated method stub
		throw new Exception("Metodo sin implementar");
	}

	@Override
	public int insert(Horario pojoNuevo) throws Exception {
		int columnasAfectadas = -1, ultimaId = -1;
		String sqlHorario = "INSERT INTO horario (lunes_inicio," + "lunes_fin," + "martes_inicio," + "martes_fin,"
				+ "miercoles_inicio," + "miercoles_fin," + "jueves_inicio," + "jueves_fin," + "viernes_inicio,"
				+ "viernes_fin," + "sabado_inicio," + "sabado_fin," + "domingo_inicio," + "domingo_fin) " + "VALUES "
				+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		try ( // Inicializar resultados con autoclosable
				Connection conn = DAOConectionManager.getConnection();
				PreparedStatement stmtInsert = conn.prepareStatement(sqlHorario,
						PreparedStatement.RETURN_GENERATED_KEYS);) {
			stmtInsert.setTime(1, Time.valueOf(pojoNuevo.getLunesInicio()));
			stmtInsert.setTime(2, Time.valueOf(pojoNuevo.getLunesFin()));
			stmtInsert.setTime(3, Time.valueOf(pojoNuevo.getMartesInicio()));
			stmtInsert.setTime(4, Time.valueOf(pojoNuevo.getMartesFin()));
			stmtInsert.setTime(5, Time.valueOf(pojoNuevo.getMiercolesInicio()));
			stmtInsert.setTime(6, Time.valueOf(pojoNuevo.getMiercolesFin()));
			stmtInsert.setTime(7, Time.valueOf(pojoNuevo.getJuevesInicio()));
			stmtInsert.setTime(8, Time.valueOf(pojoNuevo.getJuevesFin()));
			stmtInsert.setTime(9, Time.valueOf(pojoNuevo.getViernesInicio()));
			stmtInsert.setTime(10, Time.valueOf(pojoNuevo.getViernesFin()));
			stmtInsert.setTime(11, Time.valueOf(pojoNuevo.getSabadoInicio()));
			stmtInsert.setTime(12, Time.valueOf(pojoNuevo.getSabadoFin()));
			stmtInsert.setTime(13, Time.valueOf(pojoNuevo.getDomingoInicio()));
			stmtInsert.setTime(14, Time.valueOf(pojoNuevo.getDomingoFin()));
			columnasAfectadas = stmtInsert.executeUpdate();
			try (ResultSet rs = stmtInsert.getGeneratedKeys()) {
				// Si se ha insertado el curso
				if (columnasAfectadas > 0 && rs.next()) {
					// Obterner linea de la base de datos
					ultimaId = rs.getInt(1);
					pojoNuevo.setId(ultimaId);

				} else {
					System.err.println("No se ha podido insertar el horario");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ultimaId;
	}
}
