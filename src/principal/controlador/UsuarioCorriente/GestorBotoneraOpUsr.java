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
	private int acc;
	private Vista v;
	
	public GestorBotoneraOpUsr(int acc, Vista v) {
		this.acc = acc;
		this.v = v;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		 int indice = v.getSelCuenta().getListaCuentas().getSelectedIndex();

	        switch (acc) {
	            case 0: // Ingesar Saldo
	                if (!v.getOpUsrCorriente().getIngresar().getSaldo().getText().isEmpty()) {
	                    v.getOpUsrCorriente().getIngresar().getSaldo().setText("");
	                }

	                v.getOpUsrCorriente().getIngresar().setVisible(true);
	                break;
	            case 1:
	                if (!v.getOpUsrCorriente().getRetirar().getSaldo().getText().isEmpty()) {
	                    v.getOpUsrCorriente().getRetirar().getSaldo().setText("");
	                }

	                v.getOpUsrCorriente().getRetirar().setVisible(true);
	                break;

	            case 2:
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
	






