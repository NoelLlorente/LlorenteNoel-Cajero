package principal.vista.UsuarioAdministrador;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class JDCrearCuenta extends JDialog{
	/**
	 * Es el JDialog donde se introducirán los datos para crear cuentas
	 * @author Noel
	 */
	private JTextField txtid;
	private JTextField txtnombre;
	private JTextField txtsaldo;
	private JTextField txtid_tarjeta;
	private JButton crear;
	private JDMarcoAdmCuentas marco;
	
	public JDCrearCuenta(JDMarcoAdmCuentas marco) {
		this.marco = marco;
		this.setTitle("Crear Cuenta");
		this.setPreferredSize(new Dimension(300,300));
		crear = new JButton("Crear");
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		txtid = new JTextField();
		txtnombre = new JTextField();
		txtsaldo = new JTextField();
		txtid_tarjeta = new JTextField();
		
		
		jp2.add(crear);
		jp2.setLayout(new FlowLayout(FlowLayout.CENTER));
		jp1.setBorder(new TitledBorder("Datos de la Cuenta"));
		JLabel jlID = new JLabel("Id");
		JLabel jlnombre = new JLabel("Nombre");
		JLabel jlsaldo = new JLabel("Saldo");
		JLabel jlid_tarjeta = new JLabel("Id Tarjeta");
		
	
		
		jp1.add(jlID);
		jp1.add(txtid);
		jp1.add(jlnombre);
		jp1.add(txtnombre);
		jp1.add(jlsaldo);
		jp1.add(txtsaldo);
		jp1.add(jlid_tarjeta);
		jp1.add(txtid_tarjeta);
		
		
		jp1.setLayout(new GridLayout(4,4));
		this.add(jp1);
		this.add(jp2);
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		this.setLocationRelativeTo(null);
		this.pack();
}

	public JTextField getTxtid() {
		return txtid;
	}

	public void setTxtid(JTextField txtid) {
		this.txtid = txtid;
	}

	public JTextField getTxtnombre() {
		return txtnombre;
	}

	public void setTxtnombre(JTextField txtnombre) {
		this.txtnombre = txtnombre;
	}

	public JTextField getTxtsaldo() {
		return txtsaldo;
	}

	public void setTxtsaldo(JTextField txtsaldo) {
		this.txtsaldo = txtsaldo;
	}

	public JTextField getTxtid_tarjeta() {
		return txtid_tarjeta;
	}

	public void setTxtid_tarjeta(JTextField txtid_tarjeta) {
		this.txtid_tarjeta = txtid_tarjeta;
	}

	public JButton getCrear() {
		return crear;
	}

	public void setCrear(JButton crear) {
		this.crear = crear;
	}

	public JDMarcoAdmCuentas getMarco() {
		return marco;
	}

	public void setMarco(JDMarcoAdmCuentas marco) {
		this.marco = marco;
	}
	
	
	
}
