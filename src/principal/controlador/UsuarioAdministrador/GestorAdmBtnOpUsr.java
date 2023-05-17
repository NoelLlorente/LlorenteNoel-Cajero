package principal.controlador.UsuarioAdministrador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import principal.modelo.DAO.TarjetaDAO;
import principal.modelo.DAO.UsuarioDAO;
import principal.vista.Excepciones;
import principal.vista.Vista;
import principal.vista.UsuarioAdministrador.JDCrearUsuario;
/**
 * 
 * @author Noel
 *Controlador de los botones del Marco de Administración de usuarios
 */
public class GestorAdmBtnOpUsr implements ActionListener{
	private int acc;
	private Vista v;
	
	/**
	 * 
	 * @param acc es el indice del botón seleccionado
	 * @param v es el JFrame
	 * Se crea el constructor
	 */
	public GestorAdmBtnOpUsr(int acc, Vista v) {
		this.acc = acc;
		this.v = v;
	}
	

	/**
	 * Se crea el actionPerformed donde se le dará funcionalidades a los botones
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		/**
		 * Se crea un objeto UsuarioDAO para obtener sus métodos
		 * @see principal.modelo.DAO.UsuarioDAO
		 */
		UsuarioDAO usr = new UsuarioDAO();
		switch(acc) {
		case 0:
			/**
			 * Caso 0: se hace visible el marco donde se crearán los usuarios
			 * 
			 */
			v.getUsrAdmin().getAdmUsr().getCrearUsr().setVisible(true);
			break;
		case 1:
			/**
			 * Caso 1: Se llama al método para modificar los usuarios
			 *@see principal.modelo.DAO.UsuarioDAO#modificarUsuario
			 */
			usr.modificarUsuario(v.getUsrAdmin().getAdmUsr());
			break;
		case 2:
			/**
			 * Caso 2: Se llama al método para eliminar al usuario seleccionado
			 * @see principal.modelo.DAO.UsuarioDAO#eliminarUsuario
			 */
			usr.eliminarUsuario(v.getUsrAdmin().getAdmUsr());
			break;
		case 3:
			/**
			 * Caso 3: Se cierra el panel de Administración de Usuarios
			 * 
			 */
			v.getUsrAdmin().getAdmUsr().dispose();
			break;
		}
	}

	
	
	
}
