package com.elorrieta.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.elorrieta.modelo.IDAOParticipante;
import com.elorrieta.modelo.pojo.Participante;

public class DAOParticipante implements IDAOParticipante {

	@Override
	public Participante getByid(int id) throws Exception {
		Participante participante = new Participante();
		String sql = "SELECT * from participantes WHERE id= ? ;";

		// Obtener resultado
		try ( // Inicializar resultados con autoclosable
				Connection conn = DAOConectionManager.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setInt(1, id);
			try (ResultSet rs = stmt.executeQuery();) {
				// Fetch data
				if (rs.next()) {
					participante.setId(rs.getInt("id"));
					participante.setNombre(rs.getString("nombre"));
					participante.setDni("dni");
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

		return participante;
	}

	@Override
	public Participante getByName(String nombre) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Participante delete(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Participante update(Participante pojoModificar) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Participante pojoNuevo) throws Exception {
		int columnasAfectadas, ultimaId = -1;
		String sqlInsert = "INSERT INTO participantes (nombre_completo, dni, telefono, fecha_de_nacimiento,"
				+ "direccion, codigo_postal, municipio, provincia, erte, situacion_laboral, "
				+ "situacion_administrativa) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

		try ( // Inicializar resultados con autoclosable
				Connection conn = DAOConectionManager.getConnection();
				PreparedStatement stmtInsert = conn.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);) {
			stmtInsert.setString(1, pojoNuevo.getNombreCompleto());
			stmtInsert.setString(2, pojoNuevo.getDni());
			stmtInsert.setString(3, pojoNuevo.getTelefono());
			stmtInsert.setDate(4, pojoNuevo.getFechaDeNacimiento());
			stmtInsert.setString(5, pojoNuevo.getDireccion());
			stmtInsert.setString(6, pojoNuevo.getCodigoPostal());
			stmtInsert.setString(7, pojoNuevo.getMunicipio());
			stmtInsert.setString(8, pojoNuevo.getProvincia());
			stmtInsert.setBoolean(9, pojoNuevo.isErte());
			stmtInsert.setString(10, pojoNuevo.getSituacionLaboral());
			stmtInsert.setString(11, pojoNuevo.getSituacionAdministrativa());
			columnasAfectadas = stmtInsert.executeUpdate();
			try (ResultSet rs = stmtInsert.getGeneratedKeys()) {
				// Si se ha insertado el usuario
				if (columnasAfectadas > 0) {
					// Obterner linea de la base de datos
					ultimaId = rs.getInt(1);

				} else {
					System.err.println("No se ha podido insertar el usuario");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		} catch (

		Exception e) {
			e.printStackTrace();
		}
		return ultimaId;
	}

	@Override
	public List<Participante> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
