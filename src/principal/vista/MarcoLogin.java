package principal.vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class MarcoLogin extends JPanel{
	/**
	 * Es el primer marco donde se pedirán al usuario los datos para hacer login
	 * @author Noel
	 *
	 */
	
	private JLabel dni;
	private JLabel pin;
	private JTextField dnitxf;
	private JPasswordField pintxf;
	private JButton login;
	
	public MarcoLogin() {
		JPanel j = new JPanel();
		JPanel j1 = new JPanel();
		JPanel j2 = new JPanel();
		JLabel texto = new JLabel("Cajero Automático");
		Font font = new Font(texto.getFont().getName(), Font.PLAIN, 30);
		texto.setFont(font);
		j2.add(texto);
		
		dni = new JLabel("Introduzca el DNI:");
		pin = new JLabel("Introduzca el PIN:");
		dnitxf = new JTextField();
		pintxf = new JPasswordField();
		login = new JButton("Login");

		
		j.add(dni);j.add(dnitxf);j.add(pin);j.add(pintxf);
		
		j.setLayout(new GridLayout(2,2));
		
		this.add(j2);
		this.add(Box.createRigidArea(new Dimension(0, 30)));
		this.add(j);
		
		j1.add(login);
		this.add(Box.createRigidArea(new Dimension(0, 20)));
		
		this.add(j1);
		
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
	}


	public JTextField getDnitxf() {
		return dnitxf;
	}

	public void setDnitxf(JTextField dnitxf) {
		this.dnitxf = dnitxf;
	}

	public JPasswordField getPintxf() {
		return pintxf;
	}

	public void setPintxf(JPasswordField pintxf) {
		this.pintxf = pintxf;
	}

	public JButton getLogin() {
		return login;
	}

	public void setLogin(JButton login) {
		this.login = login;
	}
	
	
}
