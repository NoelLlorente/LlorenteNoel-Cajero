package principal.controlador.UsuarioCorriente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import principal.vista.Vista;

public class GestorSalirOpCorriente implements ActionListener{
	/**
	 * Controlador del botón salir del Marco Operaciones Usuarios Corrientes
	 * @author Noel
	 *
	 */
	private Vista v;
	
	/**
	 * 
	 * @param v es el JFrame
	 * Se crea el constructor
	 */
	public GestorSalirOpCorriente( Vista v) {
		this.v = v;
	}
	
	/**
	 * Se crea el actionPerformed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		/**
		 * Se oculta el MarcoOpUsrCorriente y se hace visible el marco de selección de cuenta
		 * 
		 */
		if(!v.getSelCuenta().getListaCuentas().isSelectionEmpty()) {
			v.getSelCuenta().getListaCuentas().clearSelection();
		}
		v.getOpUsrCorriente().setVisible(false);
		v.getSelCuenta().setVisible(true);
		
	}
}
