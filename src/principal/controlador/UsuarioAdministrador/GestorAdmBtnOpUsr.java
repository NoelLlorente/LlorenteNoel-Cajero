package principal.controlador.UsuarioAdministrador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import principal.modelo.DAO.TarjetaDAO;
import principal.modelo.DAO.UsuarioDAO;
import principal.vista.Excepciones;
import principal.vista.Vista;
import principal.vista.UsuarioAdministrador.JDCrearUsuario;

public class GestorAdmBtnOpUsr implements ActionListener{
	private int acc;
	private Vista v;
	
	
	public GestorAdmBtnOpUsr(int acc, Vista v) {
		this.acc = acc;
		this.v = v;
	}
	


	@Override
	public void actionPerformed(ActionEvent e) {
		UsuarioDAO usr = new UsuarioDAO();
		switch(acc) {
		case 0:
			v.getUsrAdmin().getAdmUsr().getCrearUsr().setVisible(true);
			v.getUsrAdmin().getAdmUsr().getCrearUsr().getCrear().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					  if (validarCamposVacios(v.getUsrAdmin().getAdmUsr().getCrearUsr())) {
	                        usr.crearUsuario(v.getUsrAdmin().getAdmUsr());
	                    } else {
	                        JOptionPane.showMessageDialog(null, "Error, hay campos vacíos");
	                    }
				}
				
			});
			break;
		case 1:
			usr.modificarUsuario(v.getUsrAdmin().getAdmUsr());
			break;
		case 2:
			usr.eliminarUsuario(v.getUsrAdmin().getAdmUsr());
			break;
		case 3:
			v.getUsrAdmin().getAdmUsr().dispose();
			break;
		}
	}

	
	
	private boolean validarCamposVacios(JDCrearUsuario crearUsuarioDialog) {
	    String dni = crearUsuarioDialog.getTxtDni().getText();
	    String nombre = crearUsuarioDialog.getTxtNombre().getText();
	    String apellidos = crearUsuarioDialog.getTxtApellidos().getText();
	    String fecha = crearUsuarioDialog.getTxtFechaNac().getText();
	    String telf = crearUsuarioDialog.getTxtTelf().getText();
	    String direccion = crearUsuarioDialog.getTxtDirec().getText();
	    String tipo = crearUsuarioDialog.getTxtTipo().getText();

	    return !dni.isEmpty() && !nombre.isEmpty() && !apellidos.isEmpty() &&
	            !fecha.isEmpty() && !telf.isEmpty() && !direccion.isEmpty() && !tipo.isEmpty();
	}
}
