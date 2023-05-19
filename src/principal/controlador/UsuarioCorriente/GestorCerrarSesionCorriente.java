package principal.controlador.UsuarioCorriente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import principal.vista.Vista;

public class GestorCerrarSesionCorriente implements ActionListener{
private Vista v;

public GestorCerrarSesionCorriente(Vista v) {
	this.v = v;
}

@Override
public void actionPerformed(ActionEvent e) {
	v.getUsrCorriente().setVisible(false);
	
	v.getMarcologin().getDnitxf().setText("");
	v.getMarcologin().getPintxf().setText("");
	v.getMarcologin().setVisible(true);
	
}




}
