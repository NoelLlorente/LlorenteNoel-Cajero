package principal.controlador.UsuarioAdministrador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import principal.vista.Vista;
import principal.modelo.DAO.CajeroDAO;
public class GestorBtnAdmActSaldo implements ActionListener{
private Vista v;

public GestorBtnAdmActSaldo(Vista v) {
	this.v = v;
}

@Override
public void actionPerformed(ActionEvent e) {
	CajeroDAO caj = new CajeroDAO();
	caj.actualizarSaldoCajero(v.getUsrAdmin().getAdmCajero());
}


}
