import java.util.ArrayList;
import java.util.List;

import modelo.dao.DAOUsuario;
import modelo.pojo.Usuario;

public class App {

	public static void main(String[] args) {
		System.out.println("Listado usuarios");
		try {
			DAOUsuario daoUsuario = new DAOUsuario();
			Usuario usuario = new Usuario();
			// Obtener usuario por ID
			usuario = daoUsuario.getByid(6);
			System.out.println(usuario);

			// Obtener usuario por nombre
			usuario = daoUsuario.getByName("Test cambio");
			System.out.println(usuario);

			// Obtener todos los usuarios
			List<Usuario> lista = new ArrayList<>();
			lista = daoUsuario.getAll();
			for (Usuario usuarioLista : lista) {
				System.out.println(usuarioLista);
			}

			// Borrar usuario por ID
			usuario = daoUsuario.delete(5);
			System.out.println(usuario);

			// Actualizar usuario con objeto usuario
			Usuario usuarioModificado = new Usuario();
			usuarioModificado.setId(3);
			usuarioModificado.setNombre("Test cambio");
			usuarioModificado.setPassword("321");
			usuario = daoUsuario.update(usuarioModificado);
			System.out.println(usuario);

			// Crear usuario nuevo con objeto usuario
			Usuario usuarioNuevo = new Usuario();
			usuarioNuevo.setNombre("Test insert");
			usuarioNuevo.setPassword("4321");
			int nuevoID = daoUsuario.insert(usuarioNuevo);
			if (nuevoID > 0)
				System.out.printf("El id del nuevo usuario es %d%n", nuevoID);

			// Login
			Usuario usuarioLogeado = new Usuario();
			usuarioLogeado = daoUsuario.login("Test insert", "4321");
			if (usuarioLogeado.getId() > 0)
				System.out.printf("El usuario %s esta logeado", usuarioLogeado);
			else
				System.out.printf("No se ha podido logear");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
