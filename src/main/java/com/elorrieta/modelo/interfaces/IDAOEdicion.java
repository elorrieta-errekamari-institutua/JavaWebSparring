package com.elorrieta.modelo.interfaces;

import com.elorrieta.modelo.pojo.Edicion;

public interface IDAOEdicion extends ICRUD<Edicion> {

    public int insert(Edicion pojoNuevo, int idCurso, int idHorario) throws Exception;

}
