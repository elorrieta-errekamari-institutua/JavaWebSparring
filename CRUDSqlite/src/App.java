import modelo.dao.DAOUsuario;
import modelo.pojo.Usuario;

public class App {

	public static void main(String[] args) {
		System.out.println("Listado usuarios");
		try {
			DAOUsuario daoUsuario = new DAOUsuario();
//			// Obtener usuario por ID
//			Usuario usuario = daoUsuario.getByid(4);
//			System.out.println(usuario);
//
//			// Obetener todos los usuarios
//			List<Usuario> lista = new ArrayList<>();
//			lista = daoUsuario.getAll();
//			for (Usuario usuarioLista : lista) {
//				System.out.println(usuarioLista);
//			}
//
//			// Borrar usuario por ID
//			usuario = daoUsuario.delete(4);
//			System.out.println(usuario);
//
//			// Actualizar usuario con objeto usuario
//			Usuario usuarioModificado = new Usuario();
//			usuarioModificado.setId(3);
//			usuarioModificado.setNombre("Test cambio");
//			usuarioModificado.setPassword("321");
//			usuario = daoUsuario.update(usuarioModificado);
//			System.out.println(usuario);

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
