package principal.controlador.UsuarioAdministrador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import principal.modelo.DAO.TarjetaDAO;
import principal.vista.Vista;

public class GestorAdmFiltrarTarjeta implements ActionListener{
	/**
	 * 
	 * @author Noel
	 *Controlador del botón de Buscar del panel de Administración de Tarjetas
	 */
	private Vista v;

	/**
	 * 
	 * @param v es el JFrame
	 * Se crea el constructor
	 */
	public GestorAdmFiltrarTarjeta(Vista v) {
		this.v = v;
	}

	/**
	 * Se crea el actionPerformed donde se le dará funcionalidad al botón
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		/**
		 * Creo un objeto TarjetaDAO para obtener sus métodos
		 * @see principal.modelo.DAO.TarjetaDAO
		 */
		TarjetaDAO tarjeta = new TarjetaDAO();
		/**
		 * Llamo al método cargarTarjeta que carga las tarjetas a la tabla
		 * @see principal.modelo.DAO.TarjetaDAO#cargarTarjetas
		 */
		tarjeta.cargarTarjetas(v.getUsrAdmin().getAdmTarjetas());
//		v.getUsrAdmin().getAdmTarjetas().getTxtBuscar().setText("");
//		v.getUsrAdmin().getAdmTarjetas().getComboBuscar().setSelectedIndex(0);
	}
	
	
}
