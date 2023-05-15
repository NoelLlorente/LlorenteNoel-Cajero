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


public class GestorIngresarSaldo implements ActionListener, Excepciones{
	private Vista v;
	
	public GestorIngresarSaldo(Vista v) {
		this.v =v;
	}
	
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

	 	        String cad = v.getOpUsrCorriente().getIngresar().getSaldo().getText();

	 	        if (!validarStringSaldo(cad)) {
	 	            double saldo = Double.parseDouble(cad);
	 	            cuentaDAO.ingresarSaldo(cuentaSel.getNum_cuenta(), saldo, v.getOpUsrCorriente().getIngresar());
	 	        }
	 	    }
	 	
	
	
}
