package principal.controlador.UsuarioAdministrador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import principal.vista.Vista;

public class GestorCerrarSesionAdmin implements ActionListener{
	/**
	 * Controlador botón cerrar sesión del administrador
	 * @author Noel
	 *
	 */
private Vista v;

/**
 * 
 * @param v es el JFrame
 * Se crea el Constructor
 */
public GestorCerrarSesionAdmin(Vista v) {
	this.v = v;
}

@Override
public void actionPerformed(ActionEvent e) {
/**
 * Se ocultan y cierran ventanas, además se limpian los campos del login, para luego mostrar el marco del login
 */
	v.getMarcologin().getDnitxf().setText("");
	v.getMarcologin().getPintxf().setText("");
	v.getUsrAdmin().setVisible(false);
	v.getUsrAdmin().getAdmUsr().dispose();
	v.getUsrAdmin().getAdmUsr().getCrearUsr().dispose();
	v.getUsrAdmin().getAdmTarjetas().getCrearTarjeta().dispose();
	v.getUsrAdmin().getAdmCuentas().getCrearCuenta().dispose();
	v.getUsrAdmin().getAdmCuentas().getAdmMovi().dispose();
	v.getUsrAdmin().getAdmTarjetas().dispose();
	v.getUsrAdmin().getAdmCuentas().dispose();
	v.getUsrAdmin().getAdmCajero().dispose();
	
	v.getMarcologin().setVisible(true);
	
	
}



}
