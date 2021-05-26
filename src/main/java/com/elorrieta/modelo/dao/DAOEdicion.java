package com.elorrieta.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.elorrieta.modelo.interfaces.IDAOEdicion;
import com.elorrieta.modelo.pojo.Edicion;
import com.elorrieta.modelo.pojo.Participante;

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
	public List<Edicion> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Edicion pojoNuevo, int idCurso, int idHorario) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public Edicion getByCodigoLanbide(String codigoLanbide) {
		Edicion edicion = null;
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
					edicion = new Edicion();
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
