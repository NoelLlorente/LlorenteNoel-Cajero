package principal.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import principal.modelo.DAO.UsuarioDAO;
import principal.modelo.DTO.UsuarioDTO;
import principal.vista.Excepciones;
import principal.vista.MarcoLogin;
import principal.vista.MarcoUsuarioAdministrador;
import principal.vista.MarcoUsuarioCorriente;
import principal.vista.Vista;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GestorLogin implements ActionListener, Excepciones{
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
		
		
	if(!loginVacio(dni, passwd)) {
		if(userDAO.validarUsuario(dni, passwd)) {
			JOptionPane.showMessageDialog(null, "Inicio de sesión correcto");
			userDAO.cargarDatos();
			if(tipo_usr==1) {
				MarcoUsuarioCorriente muc = null;
				vista.getContentPane().add(muc = new  MarcoUsuarioCorriente());
				Marcologin.setVisible(false);
				muc.setVisible(true);
			
					System.out.println(userDAO.getUsuarios().toString());
			
				
//				int pos = 0;
//				for (int i = 0; i < userDAO.getUsuarios().size(); i++) {
//				    if (userDAO.getUsuarios().get(i).getDni().equals(dni)) {
//				        pos = i;
//				        break;
//				    }
//				}
//
//				muc.getTxt_numTarjeta().setText(userDAO.getUsuarios().get(pos).getTarjeta().getNum_tarjeta());
//				muc.getTxt_fechaCad().setText(userDAO.getUsuarios().get(pos).getTarjeta().getFecha_caducidad());
//				muc.getTxt_cvv().setText(userDAO.getUsuarios().get(pos).getTarjeta().getCvv());
				
				
			}else if(tipo_usr==2) {
				MarcoUsuarioAdministrador mua = null;
				vista.getContentPane().add(mua = new  MarcoUsuarioAdministrador());
				Marcologin.setVisible(false);
				mua.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(null, "Error, al tratar el tipo de usuario");
			}
		}else{
			try {
				boolean error = userDAO.getCon().getConexion().isValid(0);
				JOptionPane.showMessageDialog(null, "¡Error, datos incorrectos, vuelva a intentarlo!");
			}catch(Exception e1) {
				JOptionPane.showMessageDialog(null, "¡Error, contactar con un administrador");
			}
			
			
			
		}
	}
	}
	
	
}
