package principal.controlador.UsuarioAdministrador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import principal.modelo.DAO.UsuarioDAO;
import principal.vista.Vista;
/**
 * 
 * @author Noel
 *Controlador del botón Buscar del marco de Administración de Usuario
 */
public class GestorAdmFiltrarUsr implements ActionListener{
	private Vista v;

	/**
	 * 
	 * @param v es el JFrame
	 * Se crea el constructor
	 */
	public GestorAdmFiltrarUsr(Vista v) {
		super();
		this.v = v;
	}

	/**
	 * Se crea el actionPerformed donde se le añade funcionalidad al botón
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		/**
		 * Creo un objeto UsuarioDAO para obtener sus métodos
		 * @see principal.modelo.DAO.UsuarioDAO
		 */
		UsuarioDAO usr = new UsuarioDAO();
		/**
		 *
		 * Llamo al método cargar usuario, que carga los usuario a la tabla
		 * @see principal.modelo.DAO.UsuarioDAO#cargarUsuarios
		 */
		usr.cargarUsuarios(v.getUsrAdmin().getAdmUsr());
	}
	
	
	
}
