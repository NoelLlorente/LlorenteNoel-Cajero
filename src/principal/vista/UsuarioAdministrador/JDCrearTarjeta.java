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
/**
 * Es el JDialog donde se introducirán los datos para crear las cuentas
 * @author Noel
 *
 */
public class JDCrearTarjeta extends JDialog{
	private JTextField txtid;
	private JTextField txtpin;
	private JTextField txtcvv;
	private JTextField txtfechaCad;
	private JTextField txtdni_usr;
	private JButton crear;
	private JDMarcoAdmTarjetas marco;
	
	public JDCrearTarjeta(JDMarcoAdmTarjetas marco) {
		this.setTitle("Crear Tarjeta");
		this.marco = marco;
		this.setPreferredSize(new Dimension(300,300));
		crear = new JButton("Crear");
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		txtid = new JTextField();
		txtpin = new JTextField();
		txtcvv = new JTextField();
		txtfechaCad = new JTextField();
		txtdni_usr = new JTextField();
		
		jp2.add(crear);
		jp2.setLayout(new FlowLayout(FlowLayout.CENTER));
		jp1.setBorder(new TitledBorder("Datos de la Tarjeta"));
		JLabel jlID = new JLabel("ID");
		JLabel jlpin = new JLabel("PIN");
		JLabel jlcvv = new JLabel("CVV");
		JLabel jlfecha = new JLabel("Fecha Caducidad");
		JLabel jldni = new JLabel("Dni Usuario");
	
		
		jp1.add(jlID);
		jp1.add(txtid);
		jp1.add(jlpin);
		jp1.add(txtpin);
		jp1.add(jlcvv);
		jp1.add(txtcvv);
		jp1.add(jlfecha);
		jp1.add(txtfechaCad);
		jp1.add(jldni);
		jp1.add(txtdni_usr);
		
		jp1.setLayout(new GridLayout(5,5));
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

	public JTextField getTxtpin() {
		return txtpin;
	}

	public void setTxtpin(JTextField txtpin) {
		this.txtpin = txtpin;
	}

	public JTextField getTxtcvv() {
		return txtcvv;
	}

	public void setTxtcvv(JTextField txtcvv) {
		this.txtcvv = txtcvv;
	}

	public JTextField getTxtfechaCad() {
		return txtfechaCad;
	}

	public void setTxtfechaCad(JTextField txtfechaCad) {
		this.txtfechaCad = txtfechaCad;
	}

	public JTextField getTxtdni_usr() {
		return txtdni_usr;
	}

	public void setTxtdni_usr(JTextField txtdni_usr) {
		this.txtdni_usr = txtdni_usr;
	}

	public JButton getCrear() {
		return crear;
	}

	public void setCrear(JButton crear) {
		this.crear = crear;
	}

	public JDMarcoAdmTarjetas getMarco() {
		return marco;
	}

	public void setMarco(JDMarcoAdmTarjetas marco) {
		this.marco = marco;
	}
	
	
	
}
