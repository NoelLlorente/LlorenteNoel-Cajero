package principal.controlador.UsuarioAdministrador;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import principal.vista.Excepciones;
import principal.vista.Vista;
import principal.modelo.DAO.TarjetaDAO;

public class GestorBtnCrearTarjeta implements ActionListener, Excepciones{
	/**
	 * 
	 * @author Noel
	 *Controlador del botón Crear del marco Crear Tarjetas
	 */
	private Vista v;

	/**
	 * 
	 * @param v es el JFrame
	 */
	public GestorBtnCrearTarjeta(Vista v) {
		this.v = v;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/**
		 * @see principal.modelo.DAO.TarjetaDAO
		 * Se crea un objeto TarjetaDAO para obtener sus métodos
		 */
		TarjetaDAO tarjeta = new TarjetaDAO();
		/**
		 * @see principal.vista.Excepciones#validarCamposVaciosTarjeta
		 * Se valida que no hayan campos vacios
		 */
		if(validarCamposVaciosTarjeta(v.getUsrAdmin().getAdmTarjetas().getCrearTarjeta())) {
			/**
			 * Se llama al método para crear tarjetas
			 *@see principal.modelo.DAO.TarjetaDAO#crearTarjeta
			 */
			tarjeta.crearTarjeta(v.getUsrAdmin().getAdmTarjetas());
		}else {
            JOptionPane.showMessageDialog(null, "Error, hay campos vacíos");
        }
		
	}
	
	
	
	
}
