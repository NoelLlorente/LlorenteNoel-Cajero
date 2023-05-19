package principal.controlador.UsuarioAdministrador;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import principal.vista.Vista;
import principal.modelo.DAO.CuentaDAO;
/**
 * 
 * @author Noel
 *Controlador de botones del marco de administración de Cuentas
 */
public class GestorAdmBtnOpCuenta implements ActionListener{
private Vista v;
private int acc;

/**
 * 
 * @param acc es el indice del botón seleccionado
 * @param v es el JFrame
 */
public GestorAdmBtnOpCuenta(int acc, Vista v) {
	this.acc = acc;
	this.v = v;
}

/**
 * Se crea el actionPerfomed donde se añadirán las funcionalidades al botón
 */
@Override
public void actionPerformed(ActionEvent e) {
	/**
	 * @see principal.modelo.DAO.CuentaDAO
	 * Se crea un objeto CuentaDAO para obtener sus métodos
	 */
	CuentaDAO cuenta = new CuentaDAO();
	switch(acc) {
	case 0:
		/**
		 * Caso 0: Se hace visible el JDialog de crear cuentas
		 * 
		 */
		
		v.getUsrAdmin().getAdmCuentas().getCrearCuenta().getTxtid().setText("");
		v.getUsrAdmin().getAdmCuentas().getCrearCuenta().getTxtnombre().setText("");
		v.getUsrAdmin().getAdmCuentas().getCrearCuenta().getTxtsaldo().setText("");
		v.getUsrAdmin().getAdmCuentas().getCrearCuenta().getTxtid_tarjeta().setText("");
		
		v.getUsrAdmin().getAdmCuentas().getCrearCuenta().setVisible(true);
		break;
	case 1:
		/**
		 * Caso 1: Se llama al método modificar cuenta
		 * @see principal.modelo.DAO.CuentaDAO#modificarCuenta
		 */
		cuenta.modificarCuenta(v.getUsrAdmin().getAdmCuentas());
		break;
	case 2:
		/**
		 * Caso 2: Se llama al método eliminar cuenta
		 * @see principal.modelo.DAO.CuentaDAO#eliminarCuenta
		 */
		cuenta.eliminarCuenta(v.getUsrAdmin().getAdmCuentas());
		break;
	case 3:
		int fila = v.getUsrAdmin().getAdmCuentas().getTable().getSelectedRow();
    	/**
    	 * Se verifica que hay una fila seleccionada
    	 */
    	if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila para acceder al historial.");
            return;
        }
    	/**
    	 * Caso 3: Se hace visible el marco de administración del historial
    	 */
    	if(v.getUsrAdmin().getAdmCuentas().getAdmMovi().getTable().getRowCount()>0) {
			 for(int i=0; i<v.getUsrAdmin().getAdmCuentas().getAdmMovi().getTable().getRowCount(); i++) {
				 v.getUsrAdmin().getAdmCuentas().getAdmMovi().getModelo().removeRow(i);
				 i-=1;
			 }
		 }
		 	if(!v.getUsrAdmin().getAdmCuentas().getAdmMovi().getTxtBuscar().getText().isEmpty()) {
		 		v.getUsrAdmin().getAdmCuentas().getAdmMovi().getTxtBuscar().setText("");
		 	}
		v.getUsrAdmin().getAdmCuentas().getAdmMovi().setVisible(true);
		break;
	case 4:
		/**
		 * Caso 4: Se cierra el marco de administración de cuentas
		 */
		v.getUsrAdmin().getAdmCuentas().dispose();
		break;
	}
}



}
