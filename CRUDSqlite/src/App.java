import modelo.dao.DAOUsuario;
import modelo.pojo.Usuario;

public class App {

	public static void main(String[] args) {
		System.out.println("Listado usuarios");
//		DAOConnectionManager connectionManager = new DAOConnectionManager();
//		Connection conn = null;
		try {
//			conn = connectionManager.open();
//			String url = conn.getMetaData().getURL();
//			System.out.println("Conectado a " + url);
//			connectionManager.close();
//			if (conn.isClosed())
//				System.out.println("Si, esta cerrada");
			DAOUsuario daoUsuario = new DAOUsuario();
			Usuario usuario = daoUsuario.getByid(1);
			System.out.printf("Nombre: %s", usuario.getNombre());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
