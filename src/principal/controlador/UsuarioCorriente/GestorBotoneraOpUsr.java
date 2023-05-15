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
		
			switch(acc) {
				case 0://Ingesar Saldo
					if(!v.getOpUsrCorriente().getIngresar().getSaldo().getText().isEmpty()) {
						v.getOpUsrCorriente().getIngresar().getSaldo().setText("");
					}
					
					v.getOpUsrCorriente().getIngresar().setVisible(true);
									
					v.getOpUsrCorriente().getIngresar().getBtn().addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							
							CuentaDTO cuentaSel = null;
							  if (indice != -1) {
								  UsuarioDAO cuenta = new UsuarioDAO(v.getMarcologin().getDnitxf().getText());
								  ArrayList<CuentaDTO>cuentas = new ArrayList<CuentaDTO>();	 
								  for(UsuarioDTO usr : cuenta.getUsuarios()) {
									  cuentas = usr.getTarjeta().getCuenta();
								  }
								 cuentaSel = cuentas.get(indice);	
								 
							  }
							CuentaDAO cuenta = new CuentaDAO();
							
							String cad = v.getOpUsrCorriente().getIngresar().getSaldo().getText();
						
							
							if(!validarStringSaldo(cad)) {
								double saldo = Double.parseDouble(cad);	
								cuenta.ingresarSaldo(cuentaSel.getNum_cuenta(), saldo, v.getOpUsrCorriente().getIngresar());
							}
							
						}
					});
					
				break;	
				case 1:
					if(!v.getOpUsrCorriente().getRetirar().getSaldo().getText().isEmpty()) {
						v.getOpUsrCorriente().getRetirar().getSaldo().setText("");
					}
						
						v.getOpUsrCorriente().getRetirar().setVisible(true);
						
						v.getOpUsrCorriente().getRetirar().getBtn().addActionListener(new ActionListener() {						
						@Override
						public void actionPerformed(ActionEvent e) {
							CuentaDTO cuentaSel = null;
							  if (indice != -1) {
								  UsuarioDAO cuenta = new UsuarioDAO(v.getMarcologin().getDnitxf().getText());
								  ArrayList<CuentaDTO>cuentas = new ArrayList<CuentaDTO>();	 
								  for(UsuarioDTO usr : cuenta.getUsuarios()) {
									  cuentas = usr.getTarjeta().getCuenta();
								  }
								 cuentaSel = cuentas.get(indice);	
								 
							  }
							CuentaDAO cuenta = new CuentaDAO();
							
							String cade = v.getOpUsrCorriente().getRetirar().getSaldo().getText();
							
									
							CajeroDAO cajero = new CajeroDAO();
							CajeroDTO cajerodto = cajero.obtenerCajero();
							
							if(!validarStringSaldo(cade)) {
								double saldo = Double.parseDouble(cade);						
							if(saldo<cajerodto.getSaldo()) {
								if(saldo<cuentaSel.getSaldo()) {
									cuenta.retirarSaldo(cuentaSel.getNum_cuenta(), saldo, v.getOpUsrCorriente().getRetirar());	
								}else {
									JOptionPane.showMessageDialog(null, "Error, la cantidad ingresada supera el saldo de la cuenta");
								}
							}else {
									JOptionPane.showMessageDialog(null, "Error, la cantidad ingresada supera el saldo del cajero");
								}
								
							}
							
						}
					});
					
					
					
					
//					CuentaDTO cuentaSele = null;
//					v.getOpUsrCorriente().getRetirar().getSaldo().setText("");
//					  if (indice != -1) {
//						  UsuarioDAO cuenta = new UsuarioDAO(v.getMarcologin().getDnitxf().getText());
//						  ArrayList<CuentaDTO>cuentas = new ArrayList<CuentaDTO>();	 
//						  for(UsuarioDTO usr : cuenta.getUsuarios()) {
//							  cuentas = usr.getTarjeta().getCuenta();
//						  }
//						 cuentaSele = cuentas.get(indice);	
//						 
//					  }
//					  CajeroDAO cajero = new CajeroDAO();
//					  CajeroDTO cajerodto = cajero.obtenerCajero();
					  
 
					break;
				
					
				case 2:
					CuentaDTO cuentaSel = null;
					  if (indice != -1) {
						  UsuarioDAO cuenta = new UsuarioDAO(v.getMarcologin().getDnitxf().getText());
						  ArrayList<CuentaDTO>cuentas = new ArrayList<CuentaDTO>();	 
						  for(UsuarioDTO usr : cuenta.getUsuarios()) {
							  cuentas = usr.getTarjeta().getCuenta();
						  }
						 cuentaSel = cuentas.get(indice);	
						 
					  }
					  double saldo = cuentaSel.getSaldo();
					  String txtsaldo = String.valueOf(saldo);
					 v.getOpUsrCorriente().getConsultar().getSaldoDisp().setText(txtsaldo+"€");
					 v.getOpUsrCorriente().getConsultar().setVisible(true);
					v.getOpUsrCorriente().getConsultar().getSalir().addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							v.getOpUsrCorriente().getConsultar().dispose();
							
						}
						
						
					});
					break;
				case 3:
					 v.getOpUsrCorriente().getMovimientos().setVisible(true);
					CuentaDTO cuenta = null;
					  if (indice != -1) {
						  UsuarioDAO cuen = new UsuarioDAO(v.getMarcologin().getDnitxf().getText());
						  ArrayList<CuentaDTO>cuentas = new ArrayList<CuentaDTO>();	 
						  for(UsuarioDTO usr : cuen.getUsuarios()) {
							  cuentas = usr.getTarjeta().getCuenta();
						  }
						  cuenta = cuentas.get(indice);	
						  ArrayList<HistorialDTO>historial = cuenta.getOperaciones();
						  int id=1;
						  DefaultTableModel model = (DefaultTableModel) v.getOpUsrCorriente().getMovimientos().getTabla().getModel();
					        for (HistorialDTO historialDTO : historial) {
					            Object[] rowData = {id, historialDTO.getId_operacion(), historialDTO.getFecha(),
					                    historialDTO.getHora(), historialDTO.getDescripcion()};
					            model.addRow(rowData);
					            id++; // Incrementar el ID para el siguiente registro
					        }
					       
				  }
					break;
					
					
			}
					
			
	}
	            
		

	
}


