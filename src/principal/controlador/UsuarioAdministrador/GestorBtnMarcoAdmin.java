package principal.controlador.UsuarioAdministrador;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import principal.modelo.DAO.CajeroDAO;
import principal.vista.Vista;
import principal.modelo.DAO.UsuarioDAO;


public class GestorBtnMarcoAdmin implements ActionListener{
	/**
	 * 
	 * @author Noel
	 *Controlador de los botones del marco de administración
	 */
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
			 */	if(v.getUsrAdmin().getAdmUsr().getTable().getRowCount()>0) {
				 for(int i=0; i<v.getUsrAdmin().getAdmUsr().getTable().getRowCount(); i++) {
					 v.getUsrAdmin().getAdmUsr().getModelo().removeRow(i);
					 i-=1;
				 }
			 }
			 	if(!v.getUsrAdmin().getAdmUsr().getTxtBuscar().getText().isEmpty()) {
			 		v.getUsrAdmin().getAdmUsr().getTxtBuscar().setText("");
			 	}
			 	
			 	
					v.getUsrAdmin().getAdmUsr().setVisible(true);
				break;
			case 1:
				/**
				 * Caso 1: Se hace visible el marco de Administración de Tarjetas
				 */
				
				if(v.getUsrAdmin().getAdmTarjetas().getTable().getRowCount()>0) {
					 for(int i=0; i<v.getUsrAdmin().getAdmTarjetas().getTable().getRowCount(); i++) {
						 v.getUsrAdmin().getAdmTarjetas().getModelo().removeRow(i);
						 i-=1;
					 }
				 }
				 	if(!v.getUsrAdmin().getAdmTarjetas().getTxtBuscar().getText().isEmpty()) {
				 		v.getUsrAdmin().getAdmTarjetas().getTxtBuscar().setText("");
				 	}
				
				v.getUsrAdmin().getAdmTarjetas().setVisible(true);
				break;
			case 2:
				/**
				 *Caso 2: Se hace visible el marco de Administración de Cuentas
				 */
				
				if(v.getUsrAdmin().getAdmCuentas().getTable().getRowCount()>0) {
					 for(int i=0; i<v.getUsrAdmin().getAdmCuentas().getTable().getRowCount(); i++) {
						 v.getUsrAdmin().getAdmCuentas().getModelo().removeRow(i);
						 i-=1;
					 }
				 }
				 	if(!v.getUsrAdmin().getAdmCuentas().getTxtBuscar().getText().isEmpty()) {
				 		v.getUsrAdmin().getAdmCuentas().getTxtBuscar().setText("");
				 	}
				
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


