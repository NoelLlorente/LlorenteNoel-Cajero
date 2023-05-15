package principal.controlador.UsuarioCorriente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import principal.modelo.DAO.UsuarioDAO;
import principal.modelo.DTO.UsuarioDTO;
import principal.vista.Vista;
import principal.vista.UsuarioCorriente.MarcoSelCuenta;
import principal.vista.UsuarioCorriente.MarcoUsuarioCorriente;
import principal.modelo.DTO.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class GestorSelCuentaUsrCorriente implements ActionListener{
	private Vista vista;


	public GestorSelCuentaUsrCorriente(Vista vista) {
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		vista.getUsrCorriente().setVisible(false);
		String dni = vista.getMarcologin().getDnitxf().getText();
		vista.getContentPane().add(vista.getSelCuenta());
		UsuarioDAO usr = new UsuarioDAO(dni);
		
		TarjetaDTO tarjeta = null;
        for (UsuarioDTO user : usr.getUsuarios()) {
            tarjeta = user.getTarjeta();
            break;
        }

        if (tarjeta != null) {
            ArrayList<CuentaDTO> cuentas = tarjeta.getCuenta();
            vista.getSelCuenta().getModeloLista().clear(); // Limpiar el modelo antes de agregar nuevos elementos

            if (cuentas.isEmpty()) {
                vista.getSelCuenta().getModeloLista().addElement("No tienes cuentas");
            } else {
                for (CuentaDTO cuenta : cuentas) {
                    vista.getSelCuenta().getModeloLista().addElement("num_cuenta: " + cuenta.getNum_cuenta() + " | nombre: " + cuenta.getNombre());
                }
            }
        }
       
       vista.getSelCuenta().setVisible(true);
    }

}
