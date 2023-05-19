package principal.controlador.UsuarioCorriente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import principal.modelo.DAO.TarjetaDAO;
import principal.modelo.DAO.UsuarioDAO;
import principal.vista.Excepciones;
import principal.vista.Vista;
import principal.vista.UsuarioCorriente.JDCambiarPin;
/**
 * 
 * @author Noel
 *Controlador del botón de cambiar Pin del Marco Usuario Corriente
 */
public class GestorCmbPin implements ActionListener, Excepciones {
	private JDCambiarPin cmb_pin;
	
	/**
	 * 
	 * @param cmb_pin es el JDialog Cambiar Pin
	 * Se crea el constructor
	 */
	public GestorCmbPin(JDCambiarPin cmb_pin) {
		this.cmb_pin = cmb_pin;
	}


	/**
	 * Se crea el actionPerformed donde se dará funcionalidad al botón
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		/**
		 * Se hace visible el marco
		 */
		if(!cmb_pin.getNew_pin().getText().isEmpty()) {
			cmb_pin.getNew_pin().setText("");
		}
		cmb_pin.setVisible(true);
	}}

