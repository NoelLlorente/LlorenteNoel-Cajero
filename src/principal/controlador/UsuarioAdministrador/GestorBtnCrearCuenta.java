package principal.controlador.UsuarioAdministrador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import principal.modelo.DAO.CuentaDAO;
import principal.vista.Excepciones;
import principal.vista.Vista;

public class GestorBtnCrearCuenta implements ActionListener, Excepciones{
	/**
	 * 
	 * @author Noel
	 *Controlador del botón Crear del marco crear cuenta
	 */
	private Vista v;

	/**
	 * 
	 * @param v es el JFrame
	 */
	public GestorBtnCrearCuenta(Vista v) {
		this.v = v;
	}

	/**
	 * Se crea el actionPerfomed donde se añadirán las funcionalidades al botón
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		/**
		 * Se crea un objeto CuentaDAO para obtener sus métodos
		 * @see principal.modelo.DAO.CuentaDAO
		 */
		CuentaDAO cuenta = new CuentaDAO();
		/**
		 * Se valida que los campos no estén vacios
		 * @see principal.vista.Excepciones#validarCamposVaciosCuenta
		 */
		if(validarCamposVaciosCuenta(v.getUsrAdmin().getAdmCuentas().getCrearCuenta())) {
			/**
			 * Se llama al método crearCuenta
			 * @see principal.modelo.DAO.CuentaDAO#crearCuenta
			 */
			cuenta.crearCuenta(v.getUsrAdmin().getAdmCuentas());
		}else {
            JOptionPane.showMessageDialog(null, "Error, hay campos vacíos");
        }
		
	}

}
