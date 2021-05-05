package com.elorrieta.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
					participante.setNombreCompleto(rs.getString("nombre_completo"));
					participante.setDni(rs.getString("dni"));
					participante.setTelefono(rs.getString("telefono"));
					participante.setFechaDeNacimiento(rs.getDate("fecha_de_nacimiento"));
					participante.setDireccion(rs.getString("direccion"));
					participante.setCodigoPostal(rs.getString("codigo_postal"));
					participante.setMunicipio(rs.getString("municipio"));
					participante.setProvincia(rs.getString("provincia"));
					participante.setErte(rs.getBoolean("erte"));
					participante.setSituacionLaboral(rs.getString("situacion_laboral"));
					participante.setSituacionAdministrativa(rs.getString("situacion_administrativa"));
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

	/**
	 * Devuelve un objeto de tipo usuario
	 * 
	 * @param nombre El nombre del usuario que se quiere recuperar
	 * @return POJO Usuario
	 */
	@Override
	public Participante getByDni(String dni) throws Exception {
		Participante participante = null;
		String sql = "SELECT * from participantes WHERE dni = ? ";

		// Obtener resultado
		try ( // Inicializar resultados con autoclosable
				// Inicializar resultados con autoclosable
				Connection conn = DAOConectionManager.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, dni);
			try (ResultSet rs = stmt.executeQuery();) {
				// Fetch data

				if (rs.next()) {
					participante = new Participante();
					participante.setId(rs.getInt("id"));
					participante.setNombreCompleto(rs.getString("nombre_completo"));
					participante.setDni(rs.getString("dni"));
					participante.setTelefono(rs.getString("telefono"));
					participante.setFechaDeNacimiento(rs.getDate("fecha_de_nacimiento"));
					participante.setDireccion(rs.getString("direccion"));
					participante.setCodigoPostal(rs.getString("codigo_postal"));
					participante.setMunicipio(rs.getString("municipio"));
					participante.setProvincia(rs.getString("provincia"));
					participante.setErte(rs.getBoolean("erte"));
					participante.setSituacionLaboral(rs.getString("situacion_laboral"));
					participante.setSituacionAdministrativa(rs.getString("situacion_administrativa"));
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

		return participante;
	}

	@Override
	public Participante delete(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Participante update(Participante pojoModificar) throws Exception {
		int id = pojoModificar.getId();
		Participante participante = null;

		String sql = "UPDATE participantes SET  nombre_completo = ? , dni = ? , telefono = ?, fecha_de_nacimiento = ?,"
				+ "direccion = ?, codigo_postal = ?, municipio = ?, provincia = ?, erte = ?, "
				+ "situacion_laboral = ?, situacion_administrativa = ? WHERE id = ?";
		try ( // Inicializar resultados con autoclosable
				Connection conn = DAOConectionManager.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
			participante = getByid(id);
			if (participante.getId() > 0) {
				// Actualizar usuario
				stmt.setString(1, pojoModificar.getNombreCompleto());
				stmt.setString(2, pojoModificar.getDni());
				stmt.setString(3, pojoModificar.getTelefono());
				stmt.setDate(4, pojoModificar.getFechaDeNacimiento());
				stmt.setString(5, pojoModificar.getDireccion());
				stmt.setString(6, pojoModificar.getCodigoPostal());
				stmt.setString(7, pojoModificar.getMunicipio());
				stmt.setString(8, pojoModificar.getProvincia());
				stmt.setBoolean(9, pojoModificar.isErte());
				stmt.setString(10, pojoModificar.getSituacionLaboral());
				stmt.setString(11, pojoModificar.getSituacionAdministrativa());
				stmt.setInt(12, id);
				int columnasAfectadas = stmt.executeUpdate();
				participante = getByid(id);
			} else {
				System.err.println("El participante que se quiere actualizar no existe");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return participante;
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
	public ArrayList<Participante> getAll() throws Exception {
		ArrayList<Participante> lista = new ArrayList<>();
		String sql = "SELECT * from participantes";
		try ( // Inicializar resultados con autoclosable
				Connection conn = DAOConectionManager.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();) {
			// Obtener resultado
			while (rs.next()) {
				Participante participante = new Participante();
				participante.setId(rs.getInt("id"));
				participante.setNombreCompleto(rs.getString("nombre_completo"));
				participante.setDni(rs.getString("dni"));
				participante.setTelefono(rs.getString("telefono"));
				participante.setFechaDeNacimiento(rs.getDate("fecha_de_nacimiento"));
				participante.setDireccion(rs.getString("direccion"));
				participante.setCodigoPostal(rs.getString("codigo_postal"));
				participante.setMunicipio(rs.getString("municipio"));
				participante.setProvincia(rs.getString("provincia"));
				participante.setErte(rs.getBoolean("erte"));
				participante.setSituacionLaboral(rs.getString("situacion_laboral"));
				participante.setSituacionAdministrativa(rs.getString("situacion_administrativa"));
				lista.add(participante);
			}
		} catch (Exception e) {
			System.out.println("Error en la consulta");
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public Participante getByName(String nombre) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
