package principal.vista.UsuarioAdministrador;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JPanel;

public class JDMarcoAdmCajero extends JDialog{
	/**
	 * Es el JDialog donde se podrá modificar el saldo del cajero
	 * @author Noel
	 *
	 */
	private JTextField saldo;
	private JButton actualizar;
	private MarcoUsuarioAdministrador marcoAdm;
	
	public JDMarcoAdmCajero(MarcoUsuarioAdministrador marcoAdm) {
		this.setTitle("Administración Cajero");
		this.marcoAdm=marcoAdm;
		this.setPreferredSize(new Dimension(300,250));
		JPanel p = new JPanel();
		JPanel p1 = new JPanel();
		p.setBorder(new TitledBorder("Saldo del Cajero"));
		p.setLayout(new FlowLayout(FlowLayout.CENTER));
		saldo = new JTextField();
		saldo.setPreferredSize(new Dimension(75,35));
		p.add(saldo);
		p1.setLayout(new FlowLayout(FlowLayout.CENTER));
		actualizar = new JButton("Actualizar");
		p1.add(actualizar);
		this.add(p);
		this.add(p1);
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		

		this.pack();
		
	}

	public JTextField getSaldo() {
		return saldo;
	}

	public void setSaldo(JTextField saldo) {
		this.saldo = saldo;
	}

	public JButton getActualizar() {
		return actualizar;
	}

	public void setActualizar(JButton actualizar) {
		this.actualizar = actualizar;
	}

	public MarcoUsuarioAdministrador getMarcoAdm() {
		return marcoAdm;
	}

	public void setMarcoAdm(MarcoUsuarioAdministrador marcoAdm) {
		this.marcoAdm = marcoAdm;
	}
	
	
	
}
