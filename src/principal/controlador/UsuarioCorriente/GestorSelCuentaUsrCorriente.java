package principal.controlador.UsuarioCorriente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import principal.modelo.DAO.UsuarioDAO;
import principal.modelo.DTO.UsuarioDTO;
import principal.vista.Vista;
import principal.vista.UsuarioCorriente.MarcoSelCuenta;
import principal.vista.UsuarioCorriente.MarcoUsuarioCorriente;
import principal.modelo.DTO.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * 
 * @author Noel
 *Controlador del Marco de selección de cuenta
 */
public class GestorSelCuentaUsrCorriente implements ActionListener{
	private Vista vista;

/**
 * 
 * @param vista es el JFrame
 * Se crea el constructor
 */
	public GestorSelCuentaUsrCorriente(Vista vista) {
		this.vista = vista;
	}

	/**
	 * Se crea el actionPerformed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		/**
		 * Se oculta el panel de Usuarios Corrientes donde se muestra los datos de la tarjeta
		 * Se crea un objeto UsuarioDAO para obtener los usuario y rellenar un array con los datos de la tarjeta 
		 * Si el array de tarjetas no esta vacio entonces se rellena un array de cuentas con las cuentas que tiene ese array
		 * Si el array de cuentas esta vacio se muestra un mensaje 
		 * Si el array de cuentas no esta vacio se llena el JList con los datos
		 * @see principal.modelo.DTO.TarjetaDTO
		 * @see principal.modelo.DTO.CuentaDTO
		 * @see principal.modelo.DAO.UsuarioDAO
		 */
		vista.getUsrCorriente().setVisible(false);
		String dni = vista.getMarcologin().getDnitxf().getText();
		vista.getContentPane().add(vista.getSelCuenta());
		UsuarioDAO usr = new UsuarioDAO(dni);
		
		TarjetaDTO tarjeta = null;
        for (UsuarioDTO user : usr.getUsuarios()) {
            tarjeta = user.getTarjeta();
            break;
        }

        if (tarjeta != null) {
            ArrayList<CuentaDTO> cuentas = tarjeta.getCuenta();
            vista.getSelCuenta().getModeloLista().clear(); // Limpiar el modelo antes de agregar nuevos elementos
            if(!vista.getSelCuenta().getListaCuentas().isSelectionEmpty()) {
            	vista.getSelCuenta().getListaCuentas().clearSelection();
            }
            if (cuentas.isEmpty()) {
                vista.getSelCuenta().getModeloLista().addElement("No tienes cuentas");
            } else {
                for (CuentaDTO cuenta : cuentas) {
                    vista.getSelCuenta().getModeloLista().addElement("num_cuenta: " + cuenta.getNum_cuenta() + " | nombre: " + cuenta.getNombre());
                }
            }
        }
       
       vista.getSelCuenta().setVisible(true);
    }

}
