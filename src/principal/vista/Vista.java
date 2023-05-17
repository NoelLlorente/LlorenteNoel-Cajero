package principal.vista;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JFrame;

import principal.controlador.GestorLogin;
import principal.controlador.UsuarioAdministrador.GestorAdmBtnOpHistorial;
import principal.controlador.UsuarioAdministrador.GestorAdmBtnOpTarjeta;
import principal.controlador.UsuarioAdministrador.GestorAdmBtnOpUsr;
import principal.controlador.UsuarioAdministrador.GestorAdmFiltrarCuenta;
import principal.controlador.UsuarioAdministrador.GestorAdmFiltrarHistorial;
import principal.controlador.UsuarioAdministrador.GestorAdmFiltrarTarjeta;
import principal.controlador.UsuarioAdministrador.GestorAdmFiltrarUsr;
import principal.controlador.UsuarioAdministrador.GestorBtnAdmActSaldo;
import principal.controlador.UsuarioAdministrador.GestorBtnAdmOpCuenta;
import principal.controlador.UsuarioAdministrador.GestorBtnCrearCuenta;
import principal.controlador.UsuarioAdministrador.GestorBtnCrearTarjeta;
import principal.controlador.UsuarioAdministrador.GestorBtnCrearUsr;
import principal.controlador.UsuarioAdministrador.GestorBtnMarcoAdmin;
import principal.controlador.UsuarioCorriente.GestorBotoneraOpUsr;
import principal.controlador.UsuarioCorriente.GestorBtnCambiarPin;
import principal.controlador.UsuarioCorriente.GestorBtnsSelCuenta;
import principal.controlador.UsuarioCorriente.GestorCmbPin;
import principal.controlador.UsuarioCorriente.GestorIngresarSaldo;
import principal.controlador.UsuarioCorriente.GestorRetirarSaldo;
import principal.controlador.UsuarioCorriente.GestorBtnSalirConsultar;
import principal.controlador.UsuarioCorriente.GestorSalirOpCorriente;
import principal.controlador.UsuarioCorriente.GestorSelCuentaUsrCorriente;
import principal.modelo.DTO.UsuarioDTO;
import principal.vista.UsuarioAdministrador.MarcoUsuarioAdministrador;
import principal.vista.UsuarioCorriente.MarcoLogin;
import principal.vista.UsuarioCorriente.MarcoOpUsrCorriente;
import principal.vista.UsuarioCorriente.MarcoSelCuenta;
import principal.vista.UsuarioCorriente.MarcoUsuarioCorriente;

/** 
 * Es el JFrame donde se añadirán los ActionListener a los botones y donde estarán todos los componentes
 * 
 * @author Noel
 *
 */
public class Vista extends JFrame{
	private ArrayList<UsuarioDTO> usuarios;
	private MarcoLogin Marcologin;
	private MarcoUsuarioCorriente usrCorriente;
	private MarcoOpUsrCorriente opUsrCorriente;
	private MarcoSelCuenta selCuenta;
	private MarcoUsuarioAdministrador usrAdmin;
	public Vista() {
		super("Cajero Testing");
		
		Marcologin = new MarcoLogin();
		usrCorriente = new MarcoUsuarioCorriente();
		opUsrCorriente = new MarcoOpUsrCorriente();
		selCuenta = new MarcoSelCuenta();
		usrAdmin = new MarcoUsuarioAdministrador();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLocationRelativeTo(null);
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.add(Marcologin);
		this.setVisible(true);
		this.pack();
		this.setResizable(false);
		this.setSize(400,300);
		
		//Controladores
		Marcologin.getLogin().addActionListener(new GestorLogin(Marcologin, this, usrCorriente));
		usrCorriente.getOperacion().addActionListener(new GestorSelCuentaUsrCorriente(this));
		usrCorriente.getCambiar_pin().addActionListener(new GestorCmbPin(usrCorriente.getCmb_pin()));
		for(int i=0; i<opUsrCorriente.getBotones().length; i++) {
			opUsrCorriente.getBotones()[i].addActionListener(new GestorBotoneraOpUsr(i, this));
		}
		opUsrCorriente.getSalir().addActionListener(new GestorSalirOpCorriente(this));
		
		for(int i=0; i<selCuenta.getBotones().length; i++) {
			selCuenta.getBotones()[i].addActionListener(new GestorBtnsSelCuenta(i, this));
		}
		
		opUsrCorriente.getIngresar().getBtn().addActionListener(new GestorIngresarSaldo(this));
		opUsrCorriente.getRetirar().getBtn().addActionListener(new GestorRetirarSaldo(this));
		opUsrCorriente.getConsultar().getSalir().addActionListener(new GestorBtnSalirConsultar(this));
		usrCorriente.getCmb_pin().getBtn().addActionListener(new GestorBtnCambiarPin(usrCorriente.getCmb_pin()));
		
		for(int i=0; i<usrAdmin.getBtn_marcoAdm().length; i++) {	
			usrAdmin.getBtn_marcoAdm()[i].addActionListener(new GestorBtnMarcoAdmin(i, this));
		}
		
		usrAdmin.getAdmUsr().getBuscar().addActionListener(new GestorAdmFiltrarUsr(this));
		
		for(int i=0; i<usrAdmin.getAdmUsr().getBtn().length; i++) {
			usrAdmin.getAdmUsr().getBtn()[i].addActionListener(new GestorAdmBtnOpUsr(i, this));
		}
		
		usrAdmin.getAdmUsr().getCrearUsr().getCrear().addActionListener(new GestorBtnCrearUsr(this));	
		
		usrAdmin.getAdmTarjetas().getBuscar().addActionListener(new GestorAdmFiltrarTarjeta(this));
		
		for(int i=0; i<usrAdmin.getAdmTarjetas().getBtn().length; i++) {
			usrAdmin.getAdmTarjetas().getBtn()[i].addActionListener(new GestorAdmBtnOpTarjeta(i, this));
		}
		
		usrAdmin.getAdmTarjetas().getCrearTarjeta().getCrear().addActionListener(new GestorBtnCrearTarjeta(this));
		
		usrAdmin.getAdmCajero().getActualizar().addActionListener(new GestorBtnAdmActSaldo(this));
		
		usrAdmin.getAdmCuentas().getBuscar().addActionListener(new GestorAdmFiltrarCuenta(this));
		
		for(int i=0; i<usrAdmin.getAdmCuentas().getBtn().length; i++) {
			usrAdmin.getAdmCuentas().getBtn()[i].addActionListener(new GestorBtnAdmOpCuenta(i, this));
		}
		
		
		usrAdmin.getAdmCuentas().getCrearCuenta().getCrear().addActionListener(new GestorBtnCrearCuenta(this));
		
		usrAdmin.getAdmCuentas().getAdmMovi().getBuscar().addActionListener(new GestorAdmFiltrarHistorial(this));
		
		for(int i=0; i<usrAdmin.getAdmCuentas().getAdmMovi().getBtn().length; i++) {
			usrAdmin.getAdmCuentas().getAdmMovi().getBtn()[i].addActionListener(new GestorAdmBtnOpHistorial(i, this));
		}
	}
	
	
	
	public MarcoUsuarioAdministrador getUsrAdmin() {
		return usrAdmin;
	}

	public MarcoLogin getMarcologin() {
		return Marcologin;
	}
	public MarcoUsuarioCorriente getUsrCorriente() {
		return usrCorriente;
	}
	public MarcoOpUsrCorriente getOpUsrCorriente() {
		return opUsrCorriente;
	}
	public MarcoSelCuenta getSelCuenta() {
		return selCuenta;
	}
	
	




	
	
	
}
