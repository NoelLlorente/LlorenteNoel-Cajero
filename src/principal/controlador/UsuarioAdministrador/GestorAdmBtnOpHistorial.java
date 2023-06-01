package principal.controlador.UsuarioAdministrador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import principal.modelo.DAO.HistorialDAO;
import principal.vista.Vista;


public class GestorAdmBtnOpHistorial implements ActionListener{
/**
* 
* @author Noel
*Controlador de los botones del Marco de Administracion del Historial de movimientoss
*/
	private int acc;
	private Vista v;
	
	/**
	 * 
	 * @param acc como los botones están en un array guardo en acc el botón que ha sido presionado
	 * @param v es el JFrame
	 * Declaro el constructor
	 */
	public GestorAdmBtnOpHistorial(int acc, Vista v) {
		this.acc = acc;
		this.v = v;
	}
	
	/**
	 * Declaro el actionPerfomed para darle funcionalidades a los botones
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		/**
		 * Creo un Objeto HistorialDAO para traerme los métodos que este posee
		 * @see principal.modelo.DAO.HistorialDAO
		 */
		HistorialDAO hist = new HistorialDAO();
		
		/**
		 * Se comprueba el boton que ha sido presionado y según esto se hace una cosa u otra
		 */
		switch(acc) {
		case 0:
			/**
			 * Caso 0: Se elimina la fila seleccionada en la tabla del historial
			 * @see principal.modelo.DAO.HistorialDAO#eliminarFilaHistorial
			 */
			hist.eliminarFilaHistorial(v.getUsrAdmin().getAdmCuentas());
			break;
		case 1:
			/**
			 * Caso 1: Se vacia la tabla del historial
			 * @see principal.modelo.DAO.HistorialDAO#vaciarHistorial
			 */
			hist.vaciarHistorial(v.getUsrAdmin().getAdmCuentas());
			break;
		case 2:
			/**
			 * 
			 * Caso 2: Para cerrar el Marco del historial de movimientos
			 * 
			 */
			v.getUsrAdmin().getAdmCuentas().getAdmMovi().dispose();
			break;
		}
		
	}
}
