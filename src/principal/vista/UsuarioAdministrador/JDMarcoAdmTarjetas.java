package principal.vista.UsuarioAdministrador;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class JDMarcoAdmTarjetas extends JDialog{
	private DefaultTableModel  modelo;
	private JButton[] btn;
	private JComboBox<String> comboBuscar;
	private JButton buscar;
	private JButton guardar;
	private JTextField txtBuscar;
	private MarcoUsuarioAdministrador marcoAdm;
	private JDCrearTarjeta crearTarjeta;
	private JTable table;

	
	public JDMarcoAdmTarjetas(MarcoUsuarioAdministrador marcoAdm) {
		this.setTitle("Gestion Usuarios");
		crearTarjeta=new JDCrearTarjeta(this);
		this.marcoAdm = marcoAdm;
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		jp1.setBorder(new TitledBorder("Buscar Por:"));
		
		String[] titu = {"Id", "Pin", "Cvv", "Fecha Caducidad", "Dni Usuario"};
		String[] txtcombo = {"Mostrar Todos","Id", "Cvv", "Fecha Caducidad", "Dni Usuario"};
		comboBuscar = new JComboBox<String>();
		for(int i=0; i<txtcombo.length; i++) {
			comboBuscar.addItem(txtcombo[i]);
		}	
		guardar= new JButton("Guardar");
		buscar = new JButton("Buscar");
		txtBuscar = new JTextField();
		jp1.add(comboBuscar);
		jp1.add(txtBuscar);
		jp1.add(buscar);
		jp1.setLayout(new BoxLayout(jp1, BoxLayout.X_AXIS));
		
		modelo = new DefaultTableModel(null, titu){
	        @Override
	        public boolean isCellEditable(int row, int column) {
	            return column != 0; 
	        }
	    };
		table = new JTable();
		table.setModel(modelo);
		JScrollPane scrollPane = new JScrollPane(table);
		jp2.add(scrollPane);
		
		String[] op = {"Nuevo", "Modificar", "Eliminar", "Salir"};
		btn = new JButton[op.length];
		
		for(int i=0; i<btn.length; i++) {
			btn[i] = new JButton(op[i]);
			jp3.add(btn[i]);
		}
		
		jp3.setLayout(new FlowLayout(FlowLayout.CENTER));
		jp3.add(guardar);
		guardar.setVisible(false);
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
}


	public DefaultTableModel getModelo() {
		return modelo;
	}


	public void setModelo(DefaultTableModel modelo) {
		this.modelo = modelo;
	}


	public JButton[] getBtn() {
		return btn;
	}


	public void setBtn(JButton[] btn) {
		this.btn = btn;
	}


	public JComboBox<String> getComboBuscar() {
		return comboBuscar;
	}


	public void setComboBuscar(JComboBox<String> comboBuscar) {
		this.comboBuscar = comboBuscar;
	}


	public JButton getBuscar() {
		return buscar;
	}


	public void setBuscar(JButton buscar) {
		this.buscar = buscar;
	}


	public JButton getGuardar() {
		return guardar;
	}


	public void setGuardar(JButton guardar) {
		this.guardar = guardar;
	}


	public JTextField getTxtBuscar() {
		return txtBuscar;
	}


	public void setTxtBuscar(JTextField txtBuscar) {
		this.txtBuscar = txtBuscar;
	}


	public MarcoUsuarioAdministrador getMarcoAdm() {
		return marcoAdm;
	}


	public void setMarcoAdm(MarcoUsuarioAdministrador marcoAdm) {
		this.marcoAdm = marcoAdm;
	}


	public JTable getTable() {
		return table;
	}


	public void setTable(JTable table) {
		this.table = table;
	}


	public JDCrearTarjeta getCrearTarjeta() {
		return crearTarjeta;
	}


	public void setCrearTarjeta(JDCrearTarjeta crearTarjeta) {
		this.crearTarjeta = crearTarjeta;
	}
	
	
	
	
}



