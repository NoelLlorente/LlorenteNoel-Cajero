package principal.controlador.UsuarioAdministrador;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import principal.vista.Vista;
import principal.modelo.DAO.CajeroDAO;
/**
 * 
 * @author Noel
 *Controlador botón actualizar del Marco de Administración del cajero
 */
public class GestorBtnAdmActSaldo implements ActionListener{
private Vista v;

/**
 * 
 * @param v es el JFrame
 */
public GestorBtnAdmActSaldo(Vista v) {
	this.v = v;
}

@Override
public void actionPerformed(ActionEvent e) {
	/**
	 * @see principal.modelo.DAO.CajeroDAO
	 * Creo el objeto CajeroDAO para obtener sus métodos
	 */
	CajeroDAO caj = new CajeroDAO();
	/**
	 * @see principal.modelo.DAO.CajeroDAO#actualizarSaldoCajero
	 * Se llama a un método que actualizará el saldo del cajero
	 */
	caj.actualizarSaldoCajero(v.getUsrAdmin().getAdmCajero());
}


}
