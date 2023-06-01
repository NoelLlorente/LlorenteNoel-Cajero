package principal.controlador.UsuarioCorriente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import principal.vista.Vista;


public class GestorBtnSalirConsultar implements ActionListener{
	/**
	 * 
	 * @author Noel
	 *Controlador del botón salir del JDialog Consultar Saldo
	 */
	private Vista v;

	/**
	 * 
	 * @param v es el JFrame
	 * Se crea el constructor
	 */
	public GestorBtnSalirConsultar(Vista v) {
		this.v = v;
	}

	/**
	 * Se crea el actionPerfomed para darle funcionalidad al botón
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		/**
		 * Se cierra el JDialog ConsultarSaldo
		 */
		 v.getOpUsrCorriente().getConsultar().dispose();
		
	}
	

}
