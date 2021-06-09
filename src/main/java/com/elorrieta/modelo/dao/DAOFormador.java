package com.elorrieta.modelo.dao;

import java.util.ArrayList;

import com.elorrieta.modelo.interfaces.IDAOFormador;
import com.elorrieta.modelo.pojo.Formador;

/**
 * Clase DAOFormador implementa IDAOFormador
 * 
 * Contiene los metodos para interactuar con formadores en la base de datos
 * 
 * @see IDAOFormador
 */
public class DAOFormador implements IDAOFormador {

	/**
	 * Constructor vacio
	 */
	public DAOFormador() {
		super();
	}

	@Override
	public Formador getByid(int id) throws Exception {
		// TODO Auto-generated method stub
		throw new Exception("Metodo sin implementar");
	}

	@Override
	public Formador getByName(String nombre) throws Exception {
		// TODO Auto-generated method stub
		throw new Exception("Metodo sin implementar");
	}

	@Override
	public ArrayList<Formador> getAll() throws Exception {
		// TODO Auto-generated method stub
		throw new Exception("Metodo sin implementar");
	}

	@Override
	public Formador delete(int id) throws Exception {
		// TODO Auto-generated method stub
		throw new Exception("Metodo sin implementar");
	}

	@Override
	public Formador update(Formador pojoModificar) throws Exception {
		// TODO Auto-generated method stub
		throw new Exception("Metodo sin implementar");
	}

	@Override
	public int insert(Formador pojoNuevo) throws Exception {
		// TODO Auto-generated method stub
		throw new Exception("Metodo sin implementar");
	}

}
