package principal.controlador.UsuarioAdministrador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import principal.vista.Vista;

public class GestorCerrarSesionAdmin implements ActionListener{
private Vista v;

public GestorCerrarSesionAdmin(Vista v) {
	this.v = v;
}

@Override
public void actionPerformed(ActionEvent e) {
	v.getMarcologin().getDnitxf().setText("");
	v.getMarcologin().getPintxf().setText("");
	v.getUsrAdmin().setVisible(false);
	v.getMarcologin().setVisible(true);
	
	
}



}
