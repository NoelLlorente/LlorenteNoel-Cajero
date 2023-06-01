package principal.vista.UsuarioAdministrador;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MarcoUsuarioAdministrador extends JPanel{
	/**
	 * Es el marco donde se mostrarán las 4 opciones de administración sobre cuentas, usuarios, tarjeta y cuentas
	 * @author Noel
	 *
	 */
	
	private JButton[] btn_marcoAdm;
	private JDMarcoAdmUsuarios admUsr;
	private JDMarcoAdmTarjetas admTarjetas;
	private JDMarcoAdmCajero admCajero;
	private JDMarcoAdmCuentas admCuentas;
	private JButton cerrar_sesion;
	public MarcoUsuarioAdministrador() {
		admUsr = new JDMarcoAdmUsuarios(this);
		admTarjetas = new JDMarcoAdmTarjetas(this);
		admCajero = new JDMarcoAdmCajero(this);
		admCuentas=new JDMarcoAdmCuentas(this);
		cerrar_sesion = new JButton("Cerrar Sesión");
		JLabel texto = new JLabel("Panel Administrador");
		Font font = new Font(texto.getFont().getName(), Font.PLAIN, 30);
		texto.setFont(font);
		JPanel jp1 = new JPanel();
		jp1.add(texto);
		jp1.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.add(jp1);
		JPanel jp2 = new JPanel();
		jp2.setLayout(new GridLayout(2,2));
		String[] nombres = {"Administrar Usuarios", "Administrar Tarjetas","Administrar Cuentas", "Administrar Cajero"};
		btn_marcoAdm = new JButton[nombres.length];
		
		for(int i=0; i<btn_marcoAdm.length; i++) {
			btn_marcoAdm[i] = new JButton(nombres[i]);
			jp2.add(btn_marcoAdm[i]);
		}
		
		JPanel jp3 = new JPanel();
		jp3.setLayout(new FlowLayout(FlowLayout.CENTER));
		jp3.add(cerrar_sesion);
		
		this.add(Box.createRigidArea(new Dimension(0, 60)));
		this.add(jp2);
		this.add(Box.createRigidArea(new Dimension(0, 40)));
		this.add(jp3);
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
	}

	
	
	public JButton getCerrar_sesion() {
		return cerrar_sesion;
	}



	public void setCerrar_sesion(JButton cerrar_sesion) {
		this.cerrar_sesion = cerrar_sesion;
	}


	public JButton[] getBtn_marcoAdm() {
		return btn_marcoAdm;
	}

	public JDMarcoAdmUsuarios getAdmUsr() {
		return admUsr;
	}

	public void setBtn_marcoAdm(JButton[] btn_marcoAdm) {
		this.btn_marcoAdm = btn_marcoAdm;
	}

	public void setAdmUsr(JDMarcoAdmUsuarios admUsr) {
		this.admUsr = admUsr;
	}

	public JDMarcoAdmTarjetas getAdmTarjetas() {
		return admTarjetas;
	}

	public void setAdmTarjetas(JDMarcoAdmTarjetas admTarjetas) {
		this.admTarjetas = admTarjetas;
	}

	public JDMarcoAdmCajero getAdmCajero() {
		return admCajero;
	}

	public void setAdmCajero(JDMarcoAdmCajero admCajero) {
		this.admCajero = admCajero;
	}

	public JDMarcoAdmCuentas getAdmCuentas() {
		return admCuentas;
	}

	public void setAdmCuentas(JDMarcoAdmCuentas admCuentas) {
		this.admCuentas = admCuentas;
	}

	
	


	
	
	
}
