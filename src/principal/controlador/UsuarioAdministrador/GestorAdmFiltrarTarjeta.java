package principal.controlador.UsuarioAdministrador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import principal.modelo.DAO.TarjetaDAO;
import principal.vista.Vista;

public class GestorAdmFiltrarTarjeta implements ActionListener{
	private Vista v;

	public GestorAdmFiltrarTarjeta(Vista v) {
		this.v = v;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		TarjetaDAO tarjeta = new TarjetaDAO();
		tarjeta.cargarTarjetas(v.getUsrAdmin().getAdmTarjetas());
	}
	
	
}
