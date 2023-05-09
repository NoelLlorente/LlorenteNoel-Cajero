package principal.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import principal.modelo.DAO.UsuarioDAO;
import principal.vista.MarcoLogin;
import principal.vista.MarcoUsuarioAdministrador;
import principal.vista.MarcoUsuarioCorriente;
import principal.vista.Vista;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GestorLogin implements ActionListener{
	private MarcoLogin Marcologin;
	private Vista vista;
	public GestorLogin(MarcoLogin marcologin, Vista vista) {
		this.Marcologin = marcologin;
		this.vista = vista;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		UsuarioDAO userDAO = new UsuarioDAO();
		
		String dni = Marcologin.getDnitxf().getText();
		String passwd = Marcologin.getPintxf().getText();
		
		int tipo_usr = userDAO.devolverTipoUsuario(dni);
		if(userDAO.validarUsuario(dni, passwd)) {
			JOptionPane.showMessageDialog(null, "Inicio de sesión correcto");
			if(tipo_usr==1) {
				MarcoUsuarioCorriente muc = null;
				vista.getContentPane().add(muc = new  MarcoUsuarioCorriente());
				Marcologin.setVisible(false);
				muc.setVisible(true);
			}else if(tipo_usr==2) {
				MarcoUsuarioAdministrador mua = null;
				vista.getContentPane().add(mua = new  MarcoUsuarioAdministrador());
				Marcologin.setVisible(false);
				mua.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(null, "Error, al tratar el tipo de usuario");
			}
		}else {
			JOptionPane.showMessageDialog(null, "¡Datos, incorrectos, vuelva a intentarlo!");
		}
		
	}
	
	
}
