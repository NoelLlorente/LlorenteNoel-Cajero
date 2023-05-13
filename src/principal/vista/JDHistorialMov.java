package principal.vista;

import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import principal.modelo.DTO.HistorialDTO;

public class JDHistorialMov extends JDialog {
    private JTable tabla;
    private MarcoOpUsrCorriente marco;
    public JDHistorialMov(MarcoOpUsrCorriente marco) {
    	this.marco = marco;
    
        this.setTitle("Historial de movimientos");
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        DefaultTableModel model = new DefaultTableModel();
        
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
