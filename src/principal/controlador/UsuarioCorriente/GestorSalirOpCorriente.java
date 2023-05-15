package principal.controlador.UsuarioCorriente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import principal.vista.Vista;

public class GestorSalirOpCorriente implements ActionListener{
	private Vista v;
	
	public GestorSalirOpCorriente( Vista v) {
		this.v = v;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		v.getOpUsrCorriente().setVisible(false);
		v.getSelCuenta().setVisible(true);
		
	}
}
