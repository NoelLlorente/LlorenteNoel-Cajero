package principal.controlador.UsuarioCorriente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import principal.modelo.DAO.CajeroDAO;
import principal.modelo.DAO.CuentaDAO;
import principal.modelo.DAO.UsuarioDAO;
import principal.modelo.DTO.CajeroDTO;
import principal.modelo.DTO.CuentaDTO;
import principal.modelo.DTO.UsuarioDTO;
import principal.vista.Excepciones;
import principal.vista.Vista;

/**
 * 
 * @author Noel
 *Controlador del botón retira saldo
 */
public class GestorRetirarSaldo implements ActionListener, Excepciones{
	private Vista v;

	/**
	 * 
	 * @param v es el JFrame
	 * Se crea el constructor
	 */
	public GestorRetirarSaldo(Vista v) {
		this.v = v;
	}

	/**
	 * Se crea el actionPerformed donde se añadirá funcionalidad al botón
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		int indice = v.getSelCuenta().getListaCuentas().getSelectedIndex();
		
		/**
		 * Se crea un objeto CuentaDTO para rellenarlo con las cuentas que se obtienen del objeto UsuarioDAO, y se rellena un array de CuentaDTO
		 * Se valida el saldo
		 * Se crea un objeto CuentaDAO para llamar al método retirar saldo
		 * @see principal.vista.Excepciones#validarStringSaldo
		 * @see principal.modelo.DAO.UsuarioDAO
		 * @see principal.modelo.DAO.CuentaDAO
		 * @see principal.modelo.DTO.CuentaDTO
		 */
		 CuentaDTO cuentaSel = null;
	        if (indice != -1) {
	            UsuarioDAO cuenta = new UsuarioDAO(v.getMarcologin().getDnitxf().getText());
	            ArrayList<CuentaDTO> cuentas = new ArrayList<CuentaDTO>();
	            for (UsuarioDTO usr : cuenta.getUsuarios()) {
	                cuentas = usr.getTarjeta().getCuenta();
	            }
	            cuentaSel = cuentas.get(indice);
	        }
	        CuentaDAO cuentaDAO = new CuentaDAO();

	        String cade = v.getOpUsrCorriente().getRetirar().getSaldo().getText();

	        CajeroDAO cajero = new CajeroDAO();
	        CajeroDTO cajeroDTO = cajero.obtenerCajero();

	        if (!validarStringSaldo(cade)) {
	            double saldo = Double.parseDouble(cade);
	            if (saldo <= cuentaSel.getSaldo()) {
	                if (saldo <= cajeroDTO.getSaldo()) {
	                    cuentaDAO.retirarSaldo(cuentaSel.getNum_cuenta(), saldo, v.getOpUsrCorriente().getRetirar());
	                } else {
	                    JOptionPane.showMessageDialog(null, "Error, la cantidad ingresada supera el saldo del cajero");
	                }
	            } else {
	                JOptionPane.showMessageDialog(null, "Error, la cantidad ingresada supera el saldo de la cuenta");
	            }
	        }
		
	}
	
	
}
