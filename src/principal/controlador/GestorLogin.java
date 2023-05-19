package principal.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import principal.modelo.DAO.UsuarioDAO;
import principal.modelo.DTO.UsuarioDTO;
import principal.vista.Excepciones;
import principal.vista.MarcoLogin;
import principal.vista.Vista;
import principal.vista.UsuarioAdministrador.MarcoUsuarioAdministrador;
import principal.vista.UsuarioCorriente.MarcoUsuarioCorriente;
import principal.modelo.DAO.TarjetaDAO;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Controlador del login, es donde se le añade funcionalidad al boton inciar sesión
 * @author Noel
 *
 */

public class GestorLogin implements ActionListener, Excepciones{
	private MarcoUsuarioCorriente usrCorriente;
	private MarcoLogin Marcologin;
	private Vista vista;
	
	/**
	 * 
	 *@param usrCorriente es el marco de los usuarios corrientes
	 *@param Marcologin es el marco del Login donde se mostrarán los JTextField y el Botón 
	 *@param vista es el JFrame donde se llamarán todos los componentes
	 *
	 * 
	 * Se crea el constructor
	 */
	public GestorLogin(MarcoLogin marcologin, Vista vista, MarcoUsuarioCorriente usrCorriente) {
		this.Marcologin = marcologin;
		this.vista = vista;
		this.usrCorriente = usrCorriente;
		
		/**
		 * Se le añade funcionalidad a la tecla ENTER del teclado, para que cada vez que se presione nos permita hacer el login
		 */
		 Marcologin.getPintxf().addKeyListener(new KeyAdapter() {
	            public void keyPressed(KeyEvent e) {
	                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
	                    iniciarSesion();
	                }
	            }
	        });
		 

		 Marcologin.getDnitxf().addKeyListener(new KeyAdapter() {
	            public void keyPressed(KeyEvent e) {
	                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
	                    iniciarSesion();
	                }
	            }
	        });
	}



	
	/**
	 * Se declará el actionPerformed donde se le dará la funcionalidad al botón
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		/**
		 * Se llama el método iniciarSesion()
		 * @see #iniciarSesion
		 */
		iniciarSesion();	
}
	
	/**
	 * Método iniciar sesión donde se validaran los campos y según el tipo de usuario se hará una cosa u otra
	 */
	public void iniciarSesion() {
		
		if(vista.getMarcologin().getDnitxf().getText().isEmpty()) {
			vista.getMarcologin().getDnitxf().setText("");
		}
		if(vista.getMarcologin().getPintxf().getText().isEmpty()) {
			vista.getMarcologin().getPintxf().setText("");
		}
		
		String dni = Marcologin.getDnitxf().getText();
		String passwd = Marcologin.getPintxf().getText();
		
		UsuarioDAO userDAO = new UsuarioDAO();
		int tipo_usr = userDAO.devolverTipoUsuario(dni);
		
		/**
		 * Se valida que los campos del login no esten vacios y que los datos sean correctos
		 * @see principal.vista.Excepciones
		 * @see principal.vista.Excepciones#loginVacio
		 * @see principal.modelo.DAO.UsuarioDAO#validarUsuario
		 */
	if(!loginVacio(dni, passwd)) {
		if(userDAO.validarUsuario(dni, passwd)) {
			JOptionPane.showMessageDialog(null, "Inicio de sesión correcto");
			
			
	/**
	 * Se verifica el tipo de usuario que es: 1-Usuario Corriente, 2-Usuario Administrador
	 */
			if(tipo_usr==1) {
				userDAO = new UsuarioDAO(dni);
				vista.getContentPane().add(usrCorriente);
				Marcologin.setVisible(false);
				usrCorriente.setVisible(true);
				
				int pos = 0;
				for (int i = 0; i < userDAO.getUsuarios().size(); i++) {
				    if (userDAO.getUsuarios().get(i).getDni().equals(dni)) {
				        pos = i;
				        break;
				    }
				}

				usrCorriente.getTxt_numTarjeta().setText(userDAO.getUsuarios().get(pos).getTarjeta().getNum_tarjeta());
				usrCorriente.getTxt_fechaCad().setText(userDAO.getUsuarios().get(pos).getTarjeta().getFecha_caducidad());
				usrCorriente.getTxt_cvv().setText(userDAO.getUsuarios().get(pos).getTarjeta().getCvv());
				
				
			}else if(tipo_usr==2) {

				Marcologin.setVisible(false);
				vista.getContentPane().add(vista.getUsrAdmin());
				vista.getUsrAdmin().setVisible(true);
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
	
