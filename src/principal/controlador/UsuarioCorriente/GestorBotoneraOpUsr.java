package principal.controlador.UsuarioCorriente;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import principal.modelo.DAO.UsuarioDAO;
import principal.modelo.DTO.CajeroDTO;
import principal.modelo.DTO.CuentaDTO;
import principal.modelo.DTO.HistorialDTO;
import principal.modelo.DTO.UsuarioDTO;
import principal.vista.Excepciones;
import principal.vista.Vista;
import java.util.ArrayList;
import principal.modelo.DAO.CuentaDAO;
import principal.modelo.DAO.TarjetaDAO;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import principal.modelo.DAO.CajeroDAO;

public class GestorBotoneraOpUsr implements ActionListener, Excepciones {
	/**
	 * 
	 * @author Noel
	 *Controlador botones Menu operaciones Usuario
	 */
	
	private int acc;
	private Vista v;
	
	/**
	 * 
	 * @param acc es el índice del botón seleccionado
	 * @param v es el JFrame
	 * Se crea el constructor
	 */
	public GestorBotoneraOpUsr(int acc, Vista v) {
		this.acc = acc;
		this.v = v;
	}


/**
 * Se crea el actionPerformed donde se añadirán las funcionalidades a los botones
 */
	@Override
	public void actionPerformed(ActionEvent e) {
		/**
		 * Se obtiene la fila seleccionada
		 */
		 int indice = v.getSelCuenta().getListaCuentas().getSelectedIndex();


	        switch (acc) {
	            case 0: 
	            	/**
	            	 * Caso 0: Se verifica si el saldo no esta vacio, entonces si no lo está lo vacia, y hace visible el JDialog ingresar Saldo
	            	 */
	                if (!v.getOpUsrCorriente().getIngresar().getSaldo().getText().isEmpty()) {
	                    v.getOpUsrCorriente().getIngresar().getSaldo().setText("");
	                }

	                v.getOpUsrCorriente().getIngresar().setVisible(true);
	                break;
	            case 1:
	            	/**
	            	 * El caso 1: Se verifica si el saldo no esta vacio, entonces si no lo está lo vacia, hace visible el JDialog Retirar Saldo
	            	 */
	            
	                if (!v.getOpUsrCorriente().getRetirar().getSaldo().getText().isEmpty()) {
	                    v.getOpUsrCorriente().getRetirar().getSaldo().setText("");
	                }

	                v.getOpUsrCorriente().getRetirar().setVisible(true);
	                break;

	            case 2:
	            	/**
	            	 * @see principal.modelo.DAO.UsuarioDAO
	            	 * @see principal.modelo.DTO.CuentaDTO
	            	 * 
	            	 * Caso 2: Se creará el objeto UsuarioDAO  y rellenar un array, luego se insertará el saldo en el JTextField 
	            	 * 
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
	                double saldo = cuentaSel.getSaldo();
	                String txtsaldo = String.valueOf(saldo);
	                v.getOpUsrCorriente().getConsultar().getSaldoDisp().setText(txtsaldo + "€");
	                v.getOpUsrCorriente().getConsultar().setVisible(true);
	                break;
	            case 3:
	            	/**
	            	 * Caso 3: Se hace visible el JDHistorial donde están los movimientos, y se rellenará la tabla con los datos del array
	            	 * @see principal.modelo.DTO.CuentaDTO
	            	 * @see principal.modelo.DAO.UsuarioDAO
	            	 * @see principal.modelo.DTO.HistorialDTO
	            	 */
					if(v.getOpUsrCorriente().getMovimientos().getTabla().getModel().getRowCount()>0){
						for(int i=0; i<v.getOpUsrCorriente().getMovimientos().getTabla().getRowCount(); i++){
							v.getOpUsrCorriente().getMovimientos().getModel().removeRow(i);
							i-=1;
						}
					}
	                v.getOpUsrCorriente().getMovimientos().setVisible(true);
	                CuentaDTO cuentaMov = null;
	                if (indice != -1) {
	                    UsuarioDAO cuen = new UsuarioDAO(v.getMarcologin().getDnitxf().getText());
	                    ArrayList<CuentaDTO> cuentas = new ArrayList<CuentaDTO>();

	                    for (UsuarioDTO usr : cuen.getUsuarios()) {
	                        cuentas = usr.getTarjeta().getCuenta();
	                    }
	                    cuentaMov = cuentas.get(indice);
	                    ArrayList<HistorialDTO> historial = cuentaMov.getOperaciones();
	                    int id = 1;
	                    DefaultTableModel model = (DefaultTableModel) v.getOpUsrCorriente().getMovimientos().getTabla().getModel();
	                    for (HistorialDTO historialDTO : historial) {
	                        Object[] rowData = { id, historialDTO.getId_operacion(), historialDTO.getFecha(),
	                                historialDTO.getHora(), historialDTO.getDescripcion() };
	                        model.addRow(rowData);
	                        id++;
	                    }

	                }
	                break;
	         	
	               
	            		
			}
	       

        	

        	
	}
	
}
	






