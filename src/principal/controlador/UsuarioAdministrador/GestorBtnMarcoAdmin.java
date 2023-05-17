package principal.controlador.UsuarioAdministrador;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import principal.modelo.DAO.CajeroDAO;
import principal.vista.Vista;
import principal.modelo.DAO.UsuarioDAO;

/**
 * 
 * @author Noel
 *Controlador de los botones del marco de administración
 */
public class GestorBtnMarcoAdmin implements ActionListener{
	private int acc;
	private Vista v;
	
	/**
	 * 
	 * @param acc es el índice del botón seleccionado
	 * @param v es el JFrame
	 */
	public GestorBtnMarcoAdmin(int acc, Vista v) {
		this.acc = acc;
		this.v = v;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
			switch(acc) {
			case 0:
			/**
			 * Caso 0: Se hace visible el marco de Administración de Usuarios
			 */
					v.getUsrAdmin().getAdmUsr().setVisible(true);
				break;
			case 1:
				/**
				 * Caso 1: Se hace visible el marco de Administración de Tarjetas
				 */
				v.getUsrAdmin().getAdmTarjetas().setVisible(true);
				break;
			case 2:
				/**
				 *Caso 2: Se hace visible el marco de Administración de Cuentas
				 */
				v.getUsrAdmin().getAdmCuentas().setVisible(true);
				break;
				
			case 3:
				/**
				 * Caso 3: Se crea un objeto CajeroDAO para obtener sus métodos
				 * @see principal.modelo.DAO.CajeroDAO
				 */
				CajeroDAO caj = new CajeroDAO();
				
				/**
				 * Se llama al método cargar cajero
				 * @see principal.modelo.DAO.CajeroDAO#cargarCajero
				 */
				caj.cargarCajero(v.getUsrAdmin().getAdmCajero());
				/**
				 * Se hace visible el marco de Administración del Cajero
				 */
				v.getUsrAdmin().getAdmCajero().setVisible(true);
				break;
			}
			
		}
		
	}


