package com.elorrieta.modelo.dao;

import java.util.ArrayList;

import com.elorrieta.modelo.interfaces.IDAORol;
import com.elorrieta.modelo.pojo.Rol;

/**
 * Clase DAORol implementa IDAORol
 * 
 * Contiene los metodos para interactuar con roles en la base de datos
 * 
 * @see IDAORol
 */
public class DAORol implements IDAORol {

	@Override
	public Rol getByid(int id) throws Exception {
		// TODO Auto-generated method stub
		throw new Exception("Metodo sin implementar");
	}

	@Override
	public Rol getByName(String nombre) throws Exception {
		// TODO Auto-generated method stub
		throw new Exception("Metodo sin implementar");
	}

	@Override
	public ArrayList<Rol> getAll() throws Exception {
		// TODO Auto-generated method stub
		throw new Exception("Metodo sin implementar");
	}

	@Override
	public Rol delete(int id) throws Exception {
		// TODO Auto-generated method stub
		throw new Exception("Metodo sin implementar");
	}

	@Override
	public Rol update(Rol pojoModificar) throws Exception {
		// TODO Auto-generated method stub
		throw new Exception("Metodo sin implementar");
	}

	@Override
	public int insert(Rol pojoNuevo) throws Exception {
		// TODO Auto-generated method stub
		throw new Exception("Metodo sin implementar");
	}

}
