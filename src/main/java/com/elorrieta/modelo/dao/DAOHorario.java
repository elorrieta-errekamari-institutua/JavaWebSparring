package com.elorrieta.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.List;

import com.elorrieta.modelo.interfaces.IDAOHorario;
import com.elorrieta.modelo.pojo.Horario;

public class DAOHorario implements IDAOHorario {

	@Override
	public Horario getByid(int id) throws Exception {
		// TODO Auto-generated method stub
		throw new Exception("Metodo sin implementar");
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
		// TODO Auto-generated method stub
		throw new Exception("Metodo sin implementar");
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
