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
	private JButton[] btn_marcoAdm;
	private JDMarcoAdmUsuarios admUsr;
	
	public MarcoUsuarioAdministrador() {
		admUsr = new JDMarcoAdmUsuarios(this);
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
		
		this.add(Box.createRigidArea(new Dimension(0, 60)));
		this.add(jp2);
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
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
	


	
	
}
