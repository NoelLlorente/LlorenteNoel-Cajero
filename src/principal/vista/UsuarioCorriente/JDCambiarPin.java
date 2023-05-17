package principal.vista.UsuarioCorriente;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * Es el JDialog donde introduciremos los datos del nuevo pin
 * @author Noel
 *
 */
public class JDCambiarPin extends JDialog{
	private JTextField new_pin;
	private JButton btn;
	private MarcoUsuarioCorriente marco;
	
	public JDCambiarPin(MarcoUsuarioCorriente marco) {
		this.marco = marco;
		this.setTitle("Cambiar Pin");
		new_pin = new JTextField();
		new_pin.setPreferredSize(new Dimension(130,25));
		btn = new JButton("Actualizar");
		JLabel jl = new JLabel("Introduzca el nuevo pin: ");
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		p1.add(jl);
		p1.add(new_pin);
		p1.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.add(p1);
		p2.add(btn);
		p2.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.add(p2);
		this.setLocationRelativeTo(null);
		this.setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
		this.pack();
		

	}

	public JTextField getNew_pin() {
		return new_pin;
	}

	public JButton getBtn() {
		return btn;
	}

	public void setNew_pin(JTextField new_pin) {
		this.new_pin = new_pin;
	}

	public void setBtn(JButton btn) {
		this.btn = btn;
	}

	public MarcoUsuarioCorriente getMarco() {
		return marco;
	}

	public void setMarco(MarcoUsuarioCorriente marco) {
		this.marco = marco;
	}
	
	
	
}
