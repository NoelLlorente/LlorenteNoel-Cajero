package principal.controlador.UsuarioCorriente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import principal.modelo.DAO.TarjetaDAO;
import principal.vista.Excepciones;
import principal.vista.Vista;
import principal.vista.UsuarioCorriente.JDCambiarPin;

public class GestorBtnCambiarPin implements ActionListener, Excepciones{
	/**
	 * 
	 * @author Noel
	 *Controlador botón cambiar pin
	 */
	private JDCambiarPin cmb_pin;

	
	/**
	 * 
	 * @param cmb_pin es el JDialog donde se encuentra el botón Cambiar Pin
	 * Se crea el constructor
	 */
	public GestorBtnCambiarPin(JDCambiarPin cmb_pin) {
		this.cmb_pin = cmb_pin;
	}

	
	/**
	 * Se crea el actionPerformed donde se dará funcionalidad al botón
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		/**
		 * @see principal.modelo.DAO.TarjetaDAO
		 * Se crea el objeto TarjetaDAO para luego llamar uno de sus métodos
		 */
		TarjetaDAO tarjeta = new TarjetaDAO();
		/**
		 * @param nuevoPin almacenará el pin que ha escrito el usuario en el JTextField
		 */
		String nuevoPin = cmb_pin.getNew_pin().getText();
		/**
		 * Se valida la longitud de pin
		 * @see principal.vista.Excepciones#longitudNewPin
		 */
		if(!longitudNewPin(nuevoPin)) {
			/**
			 * Se llama al método para actualizar el pin
			 * @see principal.modelo.DAO.TarjetaDAO#actualizarPin
			 */
			tarjeta.actualizarPin(nuevoPin, cmb_pin);
			
		}
		
	}
	
}
