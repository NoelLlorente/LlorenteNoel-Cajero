package principal.controlador.UsuarioAdministrador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import principal.vista.Excepciones;
import principal.vista.Vista;
import principal.modelo.DAO.TarjetaDAO;
public class GestorBtnCrearTarjeta implements ActionListener, Excepciones{
	private Vista v;

	public GestorBtnCrearTarjeta(Vista v) {
		this.v = v;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		TarjetaDAO tarjeta = new TarjetaDAO();
		if(validarCamposVaciosTarjeta(v.getUsrAdmin().getAdmTarjetas().getCrearTarjeta())) {
			tarjeta.crearTarjeta(v.getUsrAdmin().getAdmTarjetas());
		}else {
            JOptionPane.showMessageDialog(null, "Error, hay campos vacíos");
        }
		
	}
	
	
	
	
}
