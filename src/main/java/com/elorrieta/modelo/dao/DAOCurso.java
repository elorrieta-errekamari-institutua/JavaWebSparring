package com.elorrieta.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.elorrieta.modelo.IDAOCurso;
import com.elorrieta.modelo.pojo.Curso;

public class DAOCurso implements IDAOCurso {

	@Override
	public Curso getByid(int id) throws Exception {
		Curso curso = new Curso();
		String sql = "SELECT * from curso WHERE id= ? ;";

		// Obtener resultado
		try ( // Inicializar resultados con autoclosable
				Connection conn = DAOConectionManager.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setInt(1, id);
			try (ResultSet rs = stmt.executeQuery();) {
				// Fetch data
				if (rs.next()) {
					curso.setId(rs.getInt("id"));
					curso.setCodigoLanbide(rs.getString("codigo_lanbide"));
					curso.setCualificacion(rs.getString("cualificacion"));
					curso.setCodigoUc(rs.getString("codigo_uc"));
					curso.setCompetencia(rs.getString("fecha_nacimiento"));
					curso.setCodigoAaff(rs.getString("direccion"));
					curso.setNombre(rs.getString("codigo_postal"));
					curso.setHorasCurso(rs.getInt("municipio"));
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Curso> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Curso delete(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Curso update(Curso pojoModificar) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Curso pojoNuevo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Curso getByCodigoLanbide(String codigoLanbide) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Curso getByCodigoUc(String codigoUc) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Curso getByCodigoAaff(String codigoAaff) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
