package principal.controlador.UsuarioCorriente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import principal.vista.Vista;

public class GestorBtnSalirConsultar implements ActionListener{
	private Vista v;

	public GestorBtnSalirConsultar(Vista v) {
		this.v = v;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 v.getOpUsrCorriente().getConsultar().dispose();
		
	}
	

}
