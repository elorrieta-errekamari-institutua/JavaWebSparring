package modelo.dao;

import modelo.ICrudable;
import modelo.pojo.Usuario;

public interface IDAOUsuario extends ICrudable<Usuario> {

	Usuario login(String nombre, String password);

}
