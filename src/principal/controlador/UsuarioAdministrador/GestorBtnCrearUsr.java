package principal.controlador.UsuarioAdministrador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import principal.modelo.DAO.UsuarioDAO;
import principal.vista.Excepciones;
import principal.vista.Vista;

public class GestorBtnCrearUsr implements ActionListener, Excepciones{
	private Vista v;

	public GestorBtnCrearUsr(Vista v) {
		this.v = v;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		UsuarioDAO usr = new UsuarioDAO();
		if (validarCamposVacios(v.getUsrAdmin().getAdmUsr().getCrearUsr())) {
            usr.crearUsuario(v.getUsrAdmin().getAdmUsr());
        } else {
            JOptionPane.showMessageDialog(null, "Error, hay campos vacíos");
        }
		
	}
		
	
}
