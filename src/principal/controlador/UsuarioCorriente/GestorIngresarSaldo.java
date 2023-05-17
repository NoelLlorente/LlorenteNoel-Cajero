package principal.controlador.UsuarioCorriente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import principal.modelo.DTO.CuentaDTO;
import principal.modelo.DTO.UsuarioDTO;
import principal.modelo.DAO.CuentaDAO;
import principal.modelo.DAO.UsuarioDAO;
import java.util.ArrayList;
import principal.vista.Excepciones;
import principal.vista.Vista;

/**
 * 
 * @author Noel
 *Controlador del botón de ingresar saldo del botón ingresar saldo del JDialog Ingresar Saldo
 */
public class GestorIngresarSaldo implements ActionListener, Excepciones{
	private Vista v;
	
	/**
	 * 
	 * @param v es el JFrame
	 * Se crea el constructor
	 */
	public GestorIngresarSaldo(Vista v) {
		this.v =v;
	}
	/**
	 * Se crea el actionPerformed donde se dará funcionalidad al botón
	 */
	 	    public void actionPerformed(ActionEvent e) {
	 	    	/**
	 	    	 * Se crea un objeto CuentaDTO para almacenar las cuentas y pasarlas a un array de cuentas 
	 	    	 * Se crea un objeto UsuarioDAO para cargar los usuarios y obtener de ellos las cuentas
	 	    	 * Se verifica que el saldo es válido y llama al metodo ingresar Saldo
	 	    	 * Se crea un objeto CuentaDAO para llamar a uno de sus métodos
	 	    	 * 
	 	    	 *  @see principal.modelo.DTO.CuentaDTO
	 	    	 *  @see principal.modelo.DAO.UsuarioDAO
	 	    	 *  @see principal.vista.Excepciones#validarStringSaldo
	 	    	 *  @see principal.modelo.DAO.CuentaDAO#ingresarSaldo
	 	    	 */
	 	    	int indice = v.getSelCuenta().getListaCuentas().getSelectedIndex();
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

	 	        String cad = v.getOpUsrCorriente().getIngresar().getSaldo().getText();
	 	        
	 	        if (!validarStringSaldo(cad)) {
	 	            double saldo = Double.parseDouble(cad);
	 	            cuentaDAO.ingresarSaldo(cuentaSel.getNum_cuenta(), saldo, v.getOpUsrCorriente().getIngresar());
	 	        }
	 	    }
	 	
	
	
}
