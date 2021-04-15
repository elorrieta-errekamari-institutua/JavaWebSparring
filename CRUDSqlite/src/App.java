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
			usuario.setId(3);
			usuario = daoUsuario.update(usuario);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
