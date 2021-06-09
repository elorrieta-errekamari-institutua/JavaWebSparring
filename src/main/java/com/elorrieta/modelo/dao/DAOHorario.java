package com.elorrieta.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

import com.elorrieta.modelo.interfaces.IDAOHorario;
import com.elorrieta.modelo.pojo.Horario;

/**
 * Clase DAOHorario implementa IDAOHorario
 * 
 * Contiene los metodos para interactuar con horarios en la base de datos
 * 
 * @see IDAOHorario
 */
public class DAOHorario implements IDAOHorario {

	Connection conn;

	/**
	 * Constructor vacio
	 * 
	 * @throws Exception
	 */
	public DAOHorario() throws Exception {
		super();
		conn = DAOConectionManager.getConnection();
	}

	@Override
	public Horario getByid(int id) throws Exception {
		Horario horario = new Horario();
		String sql = "SELECT * from horario WHERE id= ? ;";

		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setInt(1, id);
			try (ResultSet rs = stmt.executeQuery();) {

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
	public Horario delete(int id) throws Exception {
		Horario horario = null;

		String sql = "DELETE from horario WHERE id = ?";

		try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

			horario = getByid(id);
			if (horario.getId() > 0) {
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
		int id = pojoModificar.getId();
		Horario horario = null;

		String sql = "UPDATE horario SET lunes_inicio = ?, lunes_fin = ?, martes_inicio = ?, martes_fin = ?,"
				+ " miercoles_inicio = ?, miercoles_fin = ?, jueves_inicio = ?, jueves_fin = ?,"
				+ " viernes_inicio = ?, viernes_fin = ? WHERE id = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

			horario = getByid(id);
			if (horario.getId() > 0) {

				stmt.setTime(1, Time.valueOf(pojoModificar.getLunesInicio()));
				stmt.setTime(2, Time.valueOf(pojoModificar.getLunesFin()));
				stmt.setTime(3, Time.valueOf(pojoModificar.getMartesInicio()));
				stmt.setTime(4, Time.valueOf(pojoModificar.getMartesFin()));
				stmt.setTime(5, Time.valueOf(pojoModificar.getMiercolesInicio()));
				stmt.setTime(6, Time.valueOf(pojoModificar.getMiercolesFin()));
				stmt.setTime(7, Time.valueOf(pojoModificar.getJuevesInicio()));
				stmt.setTime(8, Time.valueOf(pojoModificar.getJuevesFin()));
				stmt.setTime(9, Time.valueOf(pojoModificar.getViernesInicio()));
				stmt.setTime(10, Time.valueOf(pojoModificar.getViernesFin()));
				stmt.setInt(11, id);
				int columnasAfectadas = stmt.executeUpdate();
				if (columnasAfectadas > 0)
					horario = getByid(id);
			} else {
				System.err.println("El horario que se quiere actualizar no existe");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return horario;
	}

	@Override
	public int insert(Horario pojoNuevo) throws Exception {
		int columnasAfectadas = -1;
		int ultimaId = -1;
		String sqlHorario = "INSERT INTO horario (lunes_inicio, lunes_fin, martes_inicio, martes_fin,"
				+ "miercoles_inicio, miercoles_fin, jueves_inicio, jueves_fin, viernes_inicio,"
				+ "viernes_fin) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

		try (PreparedStatement stmtInsert = conn.prepareStatement(sqlHorario,
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
			columnasAfectadas = stmtInsert.executeUpdate();
			try (ResultSet rs = stmtInsert.getGeneratedKeys()) {

				if (columnasAfectadas > 0 && rs.next()) {

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
			throw new Exception("Horario mal formateado");
		}
		return ultimaId;
	}

	/**
	 * Los horarios no son reconocibles por nombre
	 */
	@Override
	public Horario getByName(String nombre) throws Exception {
		throw new Exception("Los horarios no son reconocibles por nombre");
	}

	@Override
	public ArrayList<Horario> getAll() throws Exception {
		// TODO Auto-generated method stub
		throw new Exception("Metodo sin implementar");
	}

}
