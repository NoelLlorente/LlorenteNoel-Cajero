package principal.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import principal.vista.MarcoSelCuenta;
import principal.vista.MarcoUsuarioCorriente;
import principal.vista.Vista;

public class GestorOpUsrCorriente implements ActionListener{
	private Vista vista;


	public GestorOpUsrCorriente(Vista vista) {
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		vista.getUsrCorriente().setVisible(false);
		vista.getContentPane().add(vista.getSelCuenta());
		vista.getSelCuenta().setVisible(true);
		
	}

}
