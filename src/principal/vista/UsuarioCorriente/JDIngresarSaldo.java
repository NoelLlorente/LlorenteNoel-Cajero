package principal.vista.UsuarioCorriente;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JDIngresarSaldo extends JDialog{
	/**
	 * Es el JDialog donde se introducirá la cantidad de saldo a ingresar en la cuenta
	 * @author Noel
	 *
	 */
	
	private JTextField saldo;
	private JButton btn;
	private MarcoOpUsrCorriente marco;
	
	public JDIngresarSaldo(MarcoOpUsrCorriente marco) {
		this.marco = marco;
		this.setTitle("Ingresar Saldo");
		saldo = new JTextField();
		saldo.setPreferredSize(new Dimension(130,25));
		btn = new JButton("Ingresar");
		JLabel jl = new JLabel("Introduzca la cantidad a ingresar: ");
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		p1.add(jl);
		p1.add(saldo);
		p1.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.add(p1);
		p2.add(btn);
		p2.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.add(p2);
		this.setLocationRelativeTo(null);
		this.setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
		this.pack();
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

	}

	public JTextField getSaldo() {
		return saldo;
	}

	public void setSaldo(JTextField saldo) {
		this.saldo = saldo;
	}

	public JButton getBtn() {
		return btn;
	}

	public void setBtn(JButton btn) {
		this.btn = btn;
	}

	public MarcoOpUsrCorriente getMarco() {
		return marco;
	}

	public void setMarco(MarcoOpUsrCorriente marco) {
		this.marco = marco;
	}

	
}
