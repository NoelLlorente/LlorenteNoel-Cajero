package principal.controlador.UsuarioAdministrador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import principal.modelo.DAO.UsuarioDAO;
import principal.vista.Vista;

public class GestorAdmFiltrarUsr implements ActionListener{
	private Vista v;

	public GestorAdmFiltrarUsr(Vista v) {
		super();
		this.v = v;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		UsuarioDAO usr = new UsuarioDAO();
		usr.cargarUsuarios(v.getUsrAdmin().getAdmUsr());
	}
	
	
	
}
