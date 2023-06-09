package principal.vista.UsuarioCorriente;

import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import principal.modelo.DTO.HistorialDTO;

public class JDHistorialMov extends JDialog {
	/**
	 * JDialog donde se mostrará el historial de movimientos
	 * @author Noel
	 *
	 */
	
    private JTable tabla;
    private MarcoOpUsrCorriente marco;
    private DefaultTableModel model;
    public JDHistorialMov(MarcoOpUsrCorriente marco) {
    	this.marco = marco;
        this.setTitle("Historial de movimientos");
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("ID Operación");
        model.addColumn("Fecha");
        model.addColumn("Hora");
        model.addColumn("Descripción");
        tabla = new JTable(model);
        tabla.setEnabled(false);
        tabla.getTableHeader().setReorderingAllowed(false);
        JScrollPane scrollPane = new JScrollPane(tabla);
        this.add(scrollPane);
        this.pack();
    }


    public DefaultTableModel getModel() {
        return model;
    }

    public void setModel(DefaultTableModel model) {
        this.model = model;
    }

    public JTable getTabla() {
		return tabla;
	}
	public void setTabla(JTable tabla) {
		this.tabla = tabla;
	}
	public MarcoOpUsrCorriente getMarco() {
		return marco;
	}
	public void setMarco(MarcoOpUsrCorriente marco) {
		this.marco = marco;
	}

    
    
    
}
