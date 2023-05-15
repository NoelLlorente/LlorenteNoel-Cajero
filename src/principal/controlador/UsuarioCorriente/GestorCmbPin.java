package principal.controlador.UsuarioCorriente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import principal.modelo.DAO.TarjetaDAO;
import principal.modelo.DAO.UsuarioDAO;
import principal.vista.Excepciones;
import principal.vista.Vista;
import principal.vista.UsuarioCorriente.MarcoCambiarPin;

public class GestorCmbPin implements ActionListener, Excepciones {
	private MarcoCambiarPin cmb_pin;
	
	public GestorCmbPin(MarcoCambiarPin cmb_pin) {
		this.cmb_pin = cmb_pin;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		cmb_pin.setVisible(true);
		
		cmb_pin.getBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TarjetaDAO tarjeta = new TarjetaDAO();
				String nuevoPin = cmb_pin.getNew_pin().getText();
				if(!longitudNewPin(nuevoPin)) {
					tarjeta.actualizarPin(nuevoPin, cmb_pin);
					
				}
				
			}
			
		});
	}}

