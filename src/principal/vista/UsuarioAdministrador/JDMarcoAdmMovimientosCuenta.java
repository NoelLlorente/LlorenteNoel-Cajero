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
/**
 * Es el JDialog donde se mostrarán los movimientos de una cuenta seleccionada anteriormente y habrá botones para realizar operaciones sobre estos datos
 * @author Noel
 *
 */
public class JDMarcoAdmMovimientosCuenta extends JDialog{
	private DefaultTableModel  modelo;
	private JButton[] btn;
	private JComboBox<String> comboBuscar;
	private JButton buscar;
	private JTextField txtBuscar;
	private JDMarcoAdmCuentas marcoAdm;
	private JTable table;

	
	public JDMarcoAdmMovimientosCuenta(JDMarcoAdmCuentas marcoAdm) {
		this.setTitle("Gestion Historial Movimientos");
		this.marcoAdm = marcoAdm;
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		jp1.setBorder(new TitledBorder("Buscar Por:"));
		
		String[] titu = {"Id", "Fecha", "Hora", "Descripcion"};
		String[] txtcombo = {"Mostrar Todos","Id", "Fecha", "Hora", "Descripcion"};
		comboBuscar = new JComboBox<String>();
		for(int i=0; i<txtcombo.length; i++) {
			comboBuscar.addItem(txtcombo[i]);
		}	
		
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
		
		String[] op = {"Eliminar", "Vaciar", "Salir"};
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


	public JTextField getTxtBuscar() {
		return txtBuscar;
	}


	public void setTxtBuscar(JTextField txtBuscar) {
		this.txtBuscar = txtBuscar;
	}


	public JDMarcoAdmCuentas getMarcoAdm() {
		return marcoAdm;
	}


	public void setMarcoAdm(JDMarcoAdmCuentas marcoAdm) {
		this.marcoAdm = marcoAdm;
	}


	public JTable getTable() {
		return table;
	}


	public void setTable(JTable table) {
		this.table = table;
	}


	
}
