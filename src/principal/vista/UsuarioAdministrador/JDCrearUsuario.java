package principal.vista.UsuarioAdministrador;

import java.awt.Dimension;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *Es el JDialog donde se introducirán los datos para crear los usuarios
 */
public class JDCrearUsuario extends JDialog{
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtFechaNac;
	private JTextField txtTelf;
	private JTextField txtDirec;
	private JTextField txtTipo;
	private JButton crear;
	private JDMarcoAdmUsuarios marco;
	public JDCrearUsuario(JDMarcoAdmUsuarios marco) {
		this.setTitle("Crear Usuario");
		this.marco = marco;
		this.setPreferredSize(new Dimension(300,300));
		crear = new JButton("Crear");
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		txtDni = new JTextField();
		txtNombre = new JTextField();
		txtApellidos = new JTextField();
		txtFechaNac = new JTextField();
		txtTelf = new JTextField();
		txtDirec = new JTextField();
		txtTipo = new JTextField();
		jp2.add(crear);
		jp2.setLayout(new FlowLayout(FlowLayout.CENTER));
		jp1.setBorder(new TitledBorder("Datos del Usuario"));
		JLabel jlDni = new JLabel("Dni");
		JLabel jlNombre = new JLabel("Nombre");
		JLabel jlApellidos = new JLabel("Apellidos");
		JLabel jlFechaNac = new JLabel("Fecha Nacimiento");
		JLabel jlTelf = new JLabel("Telefono");
		JLabel jlDirec = new JLabel("Direccion");
		JLabel jlTipo = new JLabel("Tipo Usuario");
		
		jp1.add(jlDni);
		jp1.add(txtDni);
		jp1.add(jlNombre);
		jp1.add(txtNombre);
		jp1.add(jlApellidos);
		jp1.add(txtApellidos);
		jp1.add(jlFechaNac);
		jp1.add(txtFechaNac);
		jp1.add(jlTelf);
		jp1.add(txtTelf);
		jp1.add(jlDirec);
		jp1.add(txtDirec);
		jp1.add(jlTipo);
		jp1.add(txtTipo);
		jp1.setLayout(new GridLayout(7,7));
		this.add(jp1);
		this.add(jp2);
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		this.setLocationRelativeTo(null);
		this.pack();
	}
	public JTextField getTxtDni() {
		return txtDni;
	}
	public void setTxtDni(JTextField txtDni) {
		this.txtDni = txtDni;
	}
	public JTextField getTxtNombre() {
		return txtNombre;
	}
	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}
	public JTextField getTxtApellidos() {
		return txtApellidos;
	}
	public void setTxtApellidos(JTextField txtApellidos) {
		this.txtApellidos = txtApellidos;
	}
	public JTextField getTxtFechaNac() {
		return txtFechaNac;
	}
	public void setTxtFechaNac(JTextField txtFechaNac) {
		this.txtFechaNac = txtFechaNac;
	}
	public JTextField getTxtTelf() {
		return txtTelf;
	}
	public void setTxtTelf(JTextField txtTelf) {
		this.txtTelf = txtTelf;
	}
	public JTextField getTxtDirec() {
		return txtDirec;
	}
	public void setTxtDirec(JTextField txtDirec) {
		this.txtDirec = txtDirec;
	}
	public JTextField getTxtTipo() {
		return txtTipo;
	}
	public void setTxtTipo(JTextField txtTipo) {
		this.txtTipo = txtTipo;
	}
	public JButton getCrear() {
		return crear;
	}
	public void setCrear(JButton crear) {
		this.crear = crear;
	}
	public JDMarcoAdmUsuarios getMarco() {
		return marco;
	}
	public void setMarco(JDMarcoAdmUsuarios marco) {
		this.marco = marco;
	}
	
	
	
}
