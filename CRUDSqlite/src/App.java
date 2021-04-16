import java.util.ArrayList;
import java.util.List;

import modelo.dao.DAOUsuario;
import modelo.pojo.Usuario;

public class App {

	public static void main(String[] args) {
		System.out.println("Listado usuarios");
		try {
			DAOUsuario daoUsuario = new DAOUsuario();
			// Obtener usuario por ID
			Usuario usuario = daoUsuario.getByid(4);
			System.out.println(usuario.toString());

			// Obetener todos los usuarios
			List<Usuario> lista = new ArrayList<>();
			lista = daoUsuario.getAll();
			for (Usuario usuarioLista : lista) {
				System.out.println(usuarioLista.toString());
			}

			// Borrar usuario por ID
			usuario = daoUsuario.delete(4);
			System.out.println(usuario.toString());

			// Actualizar usuario con objeto usuario
			Usuario usuarioModificado = new Usuario();
			usuarioModificado.setId(3);
			usuarioModificado.setNombre("Test cambio");
			usuarioModificado.setPassword("321");
			usuario = daoUsuario.update(usuarioModificado);
			System.out.println(usuario.toString());

			// Crear usuario nuevo con objeto usuario
			Usuario usuarioNuevo = new Usuario();
			usuarioNuevo.setNombre("Test insert mod2");
			usuarioNuevo.setPassword("4321");
			int nuevoID = daoUsuario.insert(usuarioNuevo);
			System.out.printf("El id del nuevo usuario es %d", nuevoID);

			// Login
			Usuario usuarioLogeado = new Usuario();
			usuarioLogeado = daoUsuario.login("Test insert", "4321");
			System.out.printf("El usuario %s esta logeado", usuarioLogeado.toString());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
