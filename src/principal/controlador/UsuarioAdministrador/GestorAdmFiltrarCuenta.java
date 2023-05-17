package principal.controlador.UsuarioAdministrador;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import principal.vista.Vista;
import principal.modelo.DAO.CuentaDAO;
/**
 * 
 * @author Noel
 *Controlador del botón Buscar dentro del marco de Administración de Cuentas
 */
public class GestorAdmFiltrarCuenta implements ActionListener{
private Vista v;

/**
 * 
 * @param v es el JFrame 
 */
public GestorAdmFiltrarCuenta(Vista v) {
	this.v = v;
}

@Override
/**
 * Se crea el actionPerfomed donde se le dará funcionalidad al botón
 */
public void actionPerformed(ActionEvent e) {
	/**
	 * Creo un objeto CuentaDAO para obtener sus métodos
	 * @see principal.modelo.DAO.CuentaDAO
	 */
	CuentaDAO cuenta = new CuentaDAO();
	
	/**
	 * Llamo al metodo cargarCuentas que carga las cuentas a la tabla
	 * @see principal.modelo.DAO.CuentaDAO#cargarCuentas
	 */
	cuenta.cargarCuentas(v.getUsrAdmin().getAdmCuentas());
}



}
