package principal.controlador.UsuarioAdministrador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import principal.vista.Vista;
import principal.modelo.DAO.UsuarioDAO;
public class GestorBtnMarcoAdmin implements ActionListener{
	private int acc;
	private Vista v;
	
	public GestorBtnMarcoAdmin(int acc, Vista v) {
		this.acc = acc;
		this.v = v;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
			switch(acc) {
			case 0:
					v.getUsrAdmin().getAdmUsr().setVisible(true);
				
				
				
				break;
			}
			
		}
		
	}


