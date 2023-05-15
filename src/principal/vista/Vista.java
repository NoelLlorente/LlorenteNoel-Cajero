package principal.vista;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JFrame;

import principal.controlador.GestorLogin;
import principal.controlador.UsuarioAdministrador.GestorBtnMarcoAdmin;
import principal.controlador.UsuarioCorriente.GestorBotoneraOpUsr;
import principal.controlador.UsuarioCorriente.GestorBtnsSelCuenta;
import principal.controlador.UsuarioCorriente.GestorCmbPin;
import principal.controlador.UsuarioCorriente.GestorSalirOpCorriente;
import principal.controlador.UsuarioCorriente.GestorSelCuentaUsrCorriente;
import principal.modelo.DTO.UsuarioDTO;
import principal.vista.UsuarioAdministrador.MarcoUsuarioAdministrador;
import principal.vista.UsuarioCorriente.MarcoLogin;
import principal.vista.UsuarioCorriente.MarcoOpUsrCorriente;
import principal.vista.UsuarioCorriente.MarcoSelCuenta;
import principal.vista.UsuarioCorriente.MarcoUsuarioCorriente;


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
		
		for(int i=0; i<usrAdmin.getBtn_marcoAdm().length; i++) {	
			usrAdmin.getBtn_marcoAdm()[i].addActionListener(new GestorBtnMarcoAdmin(i, this));
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
