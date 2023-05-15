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

public class GestorRetirarSaldo implements ActionListener, Excepciones{
	private Vista v;

	public GestorRetirarSaldo(Vista v) {
		this.v = v;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
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
