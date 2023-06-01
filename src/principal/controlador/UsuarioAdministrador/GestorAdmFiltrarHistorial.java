package principal.controlador.UsuarioAdministrador;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import principal.vista.Vista;
import principal.modelo.DAO.HistorialDAO;


public class GestorAdmFiltrarHistorial implements ActionListener{
	/**
	 * 
	 * @author Noel
	 *Controlador del botón Buscar del marco de Administración del Historial de Movimientos
	 */
private Vista v;

/**
 * 
 * @param v es el JFrame
 */
public GestorAdmFiltrarHistorial(Vista v) {
	this.v = v;
}

/**
 * Se crea el ActionPerformed donde se le añadirá funcionalidad al botón
 */
@Override
public void actionPerformed(ActionEvent e) {
	/**
	 * Creo un objeto HistorialDAO para obtener sus métodos 
	 * @see principal.modelo.DAO.HistorialDAO
	 */
	HistorialDAO historial = new HistorialDAO();
	
	/**
	 * Llamo al metodo obtenerHistorial que carga el historial de movimientos a la tabla
	 * @see principal.modelo.DAO.HistorialDAO#obtenerHistorial
	 */
	historial.obtenerHistorial(v.getUsrAdmin().getAdmCuentas());
//	v.getUsrAdmin().getAdmCuentas().getAdmMovi().getTxtBuscar().setText("");
}


}
