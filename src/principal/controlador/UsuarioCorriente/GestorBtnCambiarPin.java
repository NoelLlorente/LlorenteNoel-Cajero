package principal.controlador.UsuarioCorriente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import principal.modelo.DAO.TarjetaDAO;
import principal.vista.Excepciones;
import principal.vista.Vista;
import principal.vista.UsuarioCorriente.JDCambiarPin;

public class GestorBtnCambiarPin implements ActionListener, Excepciones{
	private JDCambiarPin cmb_pin;

	

	public GestorBtnCambiarPin(JDCambiarPin cmb_pin) {
		this.cmb_pin = cmb_pin;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		TarjetaDAO tarjeta = new TarjetaDAO();
		String nuevoPin = cmb_pin.getNew_pin().getText();
		if(!longitudNewPin(nuevoPin)) {
			tarjeta.actualizarPin(nuevoPin, cmb_pin);
			
		}
		
	}
	
}
