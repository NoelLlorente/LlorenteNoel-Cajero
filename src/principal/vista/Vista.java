package principal.vista;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JFrame;

import principal.controlador.GestorBotoneraOpUsr;
import principal.controlador.GestorBtnsSelCuenta;
import principal.controlador.GestorCmbPin;
import principal.controlador.GestorLogin;
import principal.controlador.GestorSelCuentaUsrCorriente;
import principal.controlador.GestorSalirOpCorriente;
import principal.modelo.DTO.UsuarioDTO;


public class Vista extends JFrame{
	private ArrayList<UsuarioDTO> usuarios;
	private MarcoLogin Marcologin;
	private MarcoUsuarioCorriente usrCorriente;
	private MarcoOpUsrCorriente opUsrCorriente;
	private MarcoSelCuenta selCuenta;
	public Vista() {
		super("Cajero Testing");
		Marcologin = new MarcoLogin();
		usrCorriente = new MarcoUsuarioCorriente();
		opUsrCorriente = new MarcoOpUsrCorriente();
		selCuenta = new MarcoSelCuenta();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLocationRelativeTo(null);
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.add(Marcologin);
		this.setVisible(true);
		this.pack();
		this.setResizable(false);
		this.setSize(400,300);
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
