package principal.controlador.UsuarioAdministrador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import principal.modelo.DAO.CajeroDAO;
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
			case 1:
				v.getUsrAdmin().getAdmTarjetas().setVisible(true);
				break;
			case 2:
				break;
				
			case 3:
				CajeroDAO caj = new CajeroDAO();
				
				caj.cargarCajero(v.getUsrAdmin().getAdmCajero());
				v.getUsrAdmin().getAdmCajero().setVisible(true);
				break;
			}
			
		}
		
	}


