package modelo;

import java.util.List;

public interface ICrudable<P> {

	P getByid(int id) throws Exception;

	List<P> getByAll();

	P delete(int id) throws Exception;

	P update(P pojoModifciar) throws Exception;

	int insert(P pojoNuevo) throws Exception;

}
