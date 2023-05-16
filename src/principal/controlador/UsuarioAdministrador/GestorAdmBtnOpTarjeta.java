package principal.controlador.UsuarioAdministrador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import principal.vista.Vista;
import principal.modelo.DAO.TarjetaDAO;
public class GestorAdmBtnOpTarjeta implements ActionListener{
	private int acc;
	private Vista v;
	public GestorAdmBtnOpTarjeta(int acc, Vista v) {
		this.acc = acc;
		this.v = v;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		TarjetaDAO tarjeta = new TarjetaDAO();
		switch(acc) {
		case 0:
			v.getUsrAdmin().getAdmTarjetas().getCrearTarjeta().setVisible(true);
			break;
		case 1:
			tarjeta.modificarTarjeta(v.getUsrAdmin().getAdmTarjetas());
			break;
		case 2:
			tarjeta.eliminarTarjeta(v.getUsrAdmin().getAdmTarjetas());
			break;
		case 3:
			v.getUsrAdmin().getAdmTarjetas().dispose();
			break;
		}
		
	}
	
	
	
	
}
