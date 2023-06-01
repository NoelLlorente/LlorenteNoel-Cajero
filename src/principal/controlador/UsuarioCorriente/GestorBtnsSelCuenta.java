package principal.controlador.UsuarioCorriente;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import principal.vista.Vista;
import principal.vista.UsuarioCorriente.MarcoOpUsrCorriente;
import principal.vista.UsuarioCorriente.MarcoSelCuenta;


public class GestorBtnsSelCuenta implements ActionListener {
	/**
	 * 
	 * @author Noel
	 *Controlador de los botones del JDialog Selección de Cuenta
	 */
	
	private int acc;
	private Vista vista;
	
	/**
	 * 
	 * @param acc es el índice del botón seleccionado
	 * @param vista es el JFrame
	 * Se crea el constructor
	 */
	public GestorBtnsSelCuenta(int acc, Vista vista) {
		this.acc = acc;
		this.vista = vista;
	}

	
	/**
	 * Se crea el actionPerformed para darle funcionalidad a los botones
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Component[] components = vista.getContentPane().getComponents();
		switch(acc) {
		case 0:
			/**
			 * Caso 0: Se ocultará el JPanel de Selección de Cuenta y se mostrará el JPanel de las operaciones que puede realizar el usuario sobre la cuenta seleccionada
			 */
			if(!vista.getSelCuenta().getListaCuentas().isSelectionEmpty()) {
			vista.getSelCuenta().setVisible(false);
			
            for (Component component : components) {
                if (component instanceof MarcoOpUsrCorriente) {
                    vista.getContentPane().remove(component);
                    break;
                }
            }
			vista.getContentPane().add(vista.getOpUsrCorriente());
			vista.getOpUsrCorriente().setVisible(true);
			}else {
				JOptionPane.showMessageDialog(null, "Seleccione una cuenta");
			}
			break;
			
		case 1:
			/**
			 * Caso 1: Se ocultara el JPanel de Selección de cuenta y se mostrará el JPanel del Usuario Corriente donde están los datos de la tarjeta del usuario
			 */
			vista.getSelCuenta().setVisible(false);
			vista.getUsrCorriente().setVisible(true);
			break;
		}

	}

}
