package principal.vista;

import java.awt.FlowLayout;


import javax.swing.JFrame;

import principal.controlador.GestorLogin;

public class Vista extends JFrame{
	private MarcoLogin Marcologin;
	
	public Vista() {
		super("Cajero Testing");
		Marcologin = new MarcoLogin();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLocationRelativeTo(null);
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.add(Marcologin);
		this.pack();
		this.setVisible(true);
		this.setSize(400,300);
		this.setResizable(false);
		Marcologin.getLogin().addActionListener(new GestorLogin(Marcologin, this));
		
	}
	
	
	public MarcoLogin getMarcoLogin() {
		return Marcologin;
	}

	
	
	
}
