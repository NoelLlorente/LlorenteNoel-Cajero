package principal.vista.UsuarioAdministrador;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class MarcoAdmUsuarios extends JDialog{
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtFechaNac;
	private JTextField txtTelf;
	private JTextField txtDirec;
	private JTextField txtTipo;
	private DefaultTableModel  modelo;
	private JButton[] btn;
	private MarcoUsuarioAdministrador marcoAdm;
	
	public MarcoAdmUsuarios(MarcoUsuarioAdministrador marcoAdm) {
		this.setTitle("Gestion Usuarios");
		this.marcoAdm = marcoAdm;
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		
		txtDni = new JTextField();
		txtNombre = new JTextField();
		txtApellidos = new JTextField();
		txtFechaNac = new JTextField();
		txtTelf = new JTextField();
		txtDirec = new JTextField();
		txtTipo = new JTextField();
	
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
		
		String[] titu = {"DNI", "Nombre", "Apellidos", "Fecha Nacimiento", "Telefono", "Direccion", "Tipo"};
		modelo = new DefaultTableModel(null, titu);
		JTable table = new JTable();
		table.setModel(modelo);
		JScrollPane scrollPane = new JScrollPane(table);
		jp2.add(scrollPane);
		
		String[] op = {"Nuevo", "Modificar", "Eliminar", "Guardar", "Salir"};
		btn = new JButton[op.length];
		
		for(int i=0; i<btn.length; i++) {
			btn[i] = new JButton(op[i]);
			jp3.add(btn[i]);
		}
		
		jp3.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
	}

	public JTextField getTxtDni() {
		return txtDni;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public JTextField getTxtApellidos() {
		return txtApellidos;
	}

	public JTextField getTxtFechaNac() {
		return txtFechaNac;
	}

	public JTextField getTxtTelf() {
		return txtTelf;
	}

	public JTextField getTxtDirec() {
		return txtDirec;
	}

	public JTextField getTxtTipo() {
		return txtTipo;
	}

	public DefaultTableModel getModelo() {
		return modelo;
	}

	public JButton[] getBtn() {
		return btn;
	}

	public void setTxtDni(JTextField txtDni) {
		this.txtDni = txtDni;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public void setTxtApellidos(JTextField txtApellidos) {
		this.txtApellidos = txtApellidos;
	}

	public void setTxtFechaNac(JTextField txtFechaNac) {
		this.txtFechaNac = txtFechaNac;
	}

	public void setTxtTelf(JTextField txtTelf) {
		this.txtTelf = txtTelf;
	}

	public void setTxtDirec(JTextField txtDirec) {
		this.txtDirec = txtDirec;
	}

	public void setTxtTipo(JTextField txtTipo) {
		this.txtTipo = txtTipo;
	}

	public void setModelo(DefaultTableModel modelo) {
		this.modelo = modelo;
	}

	public void setBtn(JButton[] btn) {
		this.btn = btn;
	}

	public MarcoUsuarioAdministrador getMarcoAdm() {
		return marcoAdm;
	}

	public void setMarcoAdm(MarcoUsuarioAdministrador marcoAdm) {
		this.marcoAdm = marcoAdm;
	}
	
	
	
}
