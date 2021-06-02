package com.elorrieta.modelo.dao;

import java.util.List;

import com.elorrieta.modelo.interfaces.IDAOFormador;
import com.elorrieta.modelo.pojo.Formador;

public class DAOFormador implements IDAOFormador {

	private boolean autoCommit = true;

	/**
	 * Constructor vacio
	 */
	public DAOFormador(){
		super();
	}

	/**
	 * Crea el dao con la opcion de autocommit
	 * @param autoCommit
	 */
	public DAOFormador(boolean autoCommit) {
		super();
		this.autoCommit = autoCommit;
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
	public List<Formador> getAll() throws Exception {
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
