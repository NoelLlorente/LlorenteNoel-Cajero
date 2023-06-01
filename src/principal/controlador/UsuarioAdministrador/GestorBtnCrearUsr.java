package principal.controlador.UsuarioAdministrador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import principal.modelo.DAO.UsuarioDAO;
import principal.vista.Excepciones;
import principal.vista.Vista;

public class GestorBtnCrearUsr implements ActionListener, Excepciones{
	/**
	 * 
	 * @author Noel
	 *Controlador del botón Crear del JDialog Crear Usuarios
	 */
	private Vista v;

	/**
	 * 
	 * @param v es el JFrame
	 */
	public GestorBtnCrearUsr(Vista v) {
		this.v = v;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/**
		 * @see principal.modelo.DAO.UsuarioDAO
		 * Creo un objeto UsuarioDAO para obtener sus métodos
		 */
		UsuarioDAO usr = new UsuarioDAO();
		/**
		 * Se valida que no hayan campos vacios
		 * @see principal.vista.Excepciones#validarCamposVacios
		 */
		if (validarCamposVacios(v.getUsrAdmin().getAdmUsr().getCrearUsr())) {
			/**
			 * @see principal.modelo.DAO.UsuarioDAO#crearUsuario
			 * Se llama al metodo crear usuarios
			 */
            usr.crearUsuario(v.getUsrAdmin().getAdmUsr());
        } else {
            JOptionPane.showMessageDialog(null, "Error, hay campos vacíos");
        }
		
	}
		
	
}
