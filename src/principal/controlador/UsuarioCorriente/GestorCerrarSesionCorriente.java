package principal.controlador.UsuarioCorriente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import principal.vista.Vista;

/**
 * Controlador del botón cerrar sesión de usuario corriente
 * @author Noel
 *
 */
public class GestorCerrarSesionCorriente implements ActionListener{
private Vista v;

/**
 * 
 * @param v es el JFrame
 * Creo el constructor
 */
public GestorCerrarSesionCorriente(Vista v) {
	this.v = v;
}


@Override
public void actionPerformed(ActionEvent e) {
	/**
	 * Se ocultan y cierran ventanas, además se limpian los campos del login, para luego mostrar el marco del login
	 */
	v.getUsrCorriente().setVisible(false);
	
	v.getMarcologin().getDnitxf().setText("");
	v.getMarcologin().getPintxf().setText("");
	
	v.getUsrCorriente().getCmb_pin().dispose();
	v.getOpUsrCorriente().setVisible(false);
	v.getOpUsrCorriente().getIngresar().dispose();
	v.getOpUsrCorriente().getRetirar().dispose();
	v.getOpUsrCorriente().getMovimientos().dispose();
	v.getOpUsrCorriente().getConsultar().dispose();
	v.getMarcologin().setVisible(true);
	
}




}
