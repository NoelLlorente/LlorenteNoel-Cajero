package principal.controlador.UsuarioAdministrador;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import principal.vista.Vista;
import principal.modelo.DAO.TarjetaDAO;

/**
 * 
 * @author Noel
 *Controlador de los botones del Marco de administración de tarjetas
 */
public class GestorAdmBtnOpTarjeta implements ActionListener{
	private int acc;
	private Vista v;
	
	/**
	 * 
	 * @param acc es el indice del botón que ha sido presionado
	 * @param v es el JFrame
	 * Se declara el constructor
	 */
	public GestorAdmBtnOpTarjeta(int acc, Vista v) {
		this.acc = acc;
		this.v = v;
	}
	
	/**
	 * Se declara el actionPerformed donde se le dará funcionalidad a los botones
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		/**
		 * Se crea un objeto TarjetaDAO para traerme sus métodos
		 * @see principal.modelo.DAO.TarjetaDAO
		 */
		TarjetaDAO tarjeta = new TarjetaDAO();
		
		/**
		 * Según el botón presionado se hace una cosa u otra
		 */
		switch(acc) {
		case 0:
			/**
			 * Caso 0: Se hace visible el JDialog de Crear Tarjetas
			 */
			v.getUsrAdmin().getAdmTarjetas().getCrearTarjeta().setVisible(true);
			break;
		case 1:
			/**
			 * Caso 1: Se llama al método para modificar tarjetas
			 * @see principal.modelo.DAO.TarjetaDAO#modificarTarjeta
			 */
			tarjeta.modificarTarjeta(v.getUsrAdmin().getAdmTarjetas());
			break;
		case 2:
			/**
			 * Caso 2: Se llama al método eliminar, para eliminar la tarjeta seleccionada
			 * @see principal.modelo.DAO.TarjetaDAO#eliminarTarjeta
			 */
			tarjeta.eliminarTarjeta(v.getUsrAdmin().getAdmTarjetas());
			break;
		case 3:
			/**
			 * Caso 3: Se cierra el JDialog de Administración de tarjetas
			 * 
			 */
			v.getUsrAdmin().getAdmTarjetas().dispose();
			break;
		}
		
	}
	
	
	
	
}
