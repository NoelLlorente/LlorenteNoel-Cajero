package principal.modelo.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import principal.modelo.Conexion;
import principal.modelo.Consultas;
import principal.modelo.DTO.HistorialDTO;
import principal.vista.UsuarioAdministrador.JDMarcoAdmCuentas;
import principal.vista.UsuarioAdministrador.JDMarcoAdmMovimientosCuenta;
/**
 * 
 * @author Noel
 *HistorialDAO es donde se crearán los métodos para realizar las operaciones con la base de datos sobre el historial de movimientos
 */
public class HistorialDAO implements Consultas{
	private PreparedStatement ps = null;
    private Statement sta = null;
    private ResultSet resultSet = null;
    private Conexion con = new Conexion();
	
    /**
     * Se obtiene un array con el historial de la cuenta 
     * @param idCuenta es el id de la cuenta de la cual obtendremos el historial
     * @return ArrayList<HistorialDTO> 
     */
	public ArrayList<HistorialDTO> obtenerHistorialCuenta(String idCuenta) {
	    ArrayList<HistorialDTO> historialCuenta = new ArrayList<>();

	    try {
	        this.ps = con.getConexion().prepareStatement(CARGAR_HISTORIAL_CUENTA);
	        ps.setString(1, idCuenta);
	        resultSet = ps.executeQuery();
	        
	        while(resultSet.next()) {
	        	HistorialDTO historial = new HistorialDTO();
	        	historial.setId_operacion(resultSet.getInt("id_operacion"));
	        	historial.setFecha(resultSet.getString("fecha"));
	        	historial.setHora(resultSet.getString("hora"));
	        	historial.setDescripcion(resultSet.getString("descripcion"));
	        	
	        	historialCuenta.add(historial);
	        }
	    } catch (Exception e) {
	        System.out.println("Error al obtener historial de cuenta: " + e.getLocalizedMessage());
	    }

	    return historialCuenta;
	}
	
	
	/**
	 * Insertará en la base de datos los movimientos que realiza el usuario en la cuenta
	 * @param id_cuenta es el id de la cuenta al que el historial esta asociado
	 * @param id_operacion es la operación que se ha realizado por el usuario: ingresar o retirar
	 * @param saldo es el saldo que se ha retirar o ingresado
	 */
	public void añadirOperaciones(String id_cuenta, int id_operacion, double saldo) {
	    try {
	        PreparedStatement ps = con.getConexion().prepareStatement(INSERTAR_HISTORIAL);
	        ps.setString(1, id_cuenta);
	        ps.setInt(2, id_operacion);
	        
	        // Obtener la fecha y hora actual
	        Date fechaActual = new Date();
	        Timestamp timestamp = new Timestamp(fechaActual.getTime());
	        ps.setTimestamp(3, timestamp);
	        ps.setTimestamp(4, timestamp);
	        
	        // Obtener la descripción según el tipo de operación
	        String descripcion = "";
	        if (id_operacion==1) {
	            descripcion = "+"+saldo+" €"; // Ejemplo, ajusta la descripción según tu lógica
	        } else if (id_operacion==2) {
	            descripcion = "-"+saldo+" €"; // Ejemplo, ajusta la descripción según tu lógica
	        }
	        ps.setString(5, descripcion);

	        ps.executeUpdate();
	        ps.close();
	    } catch (Exception e) {
	        System.out.println("Error al añadir operaciones: " + e.getLocalizedMessage());
	    }
	}
	
	/**
	 * Obtenemos el historial para fines administrativos
	 * @param marco es el JDialog JDMarcoAdmCuentas
	 */
	public void obtenerHistorial(JDMarcoAdmCuentas marco) {
		int fila = marco.getTable().getSelectedRow();
		
		String ID = marco.getTable().getValueAt(fila, 0).toString();
		
		String[] datos = new String[4];
    	
    	String codSQL = null;
    	
    	if(marco.getAdmMovi().getComboBuscar().getSelectedIndex()==0) {
    		codSQL = LISTAR_HISTORIAL+"'"+ID+"'";
    	}else if(marco.getAdmMovi().getComboBuscar().getSelectedIndex()==1) {
    		codSQL = FILTRAR_HISTORIAL_ID+"'"+marco.getAdmMovi().getTxtBuscar().getText()+"'";
    	}else if(marco.getAdmMovi().getComboBuscar().getSelectedIndex()==2) {
    		codSQL = FILTRAR_HISTORIAL_FECHA+"'"+marco.getAdmMovi().getTxtBuscar().getText()+"'";
    	}else if(marco.getAdmMovi().getComboBuscar().getSelectedIndex()==3) {
    		codSQL = FILTRAR_HISTORIAL_HORA+"'"+marco.getAdmMovi().getTxtBuscar().getText()+"'";
    	}else if(marco.getAdmMovi().getComboBuscar().getSelectedIndex()==4) {
    		codSQL =FILTRAR_HISTORIAL_DESCRIPCION+"'"+marco.getAdmMovi().getTxtBuscar().getText()+"'";
    	}
    	
    	
    	try {
    		sta = con.getConexion().createStatement();
    		resultSet = sta.executeQuery(codSQL);
    		DefaultTableModel modelo = marco.getAdmMovi().getModelo();
    		modelo.setRowCount(0);
    		while(resultSet.next()) {
    			datos[0] = resultSet.getString(1);
    			datos[1] = resultSet.getString(4);
    			datos[2] = resultSet.getString(5);
    			datos[3] = resultSet.getString(6);
  

    			modelo.addRow(datos);
    		}
 
    		JTable tabla = marco.getAdmMovi().getTable();
    		tabla.setModel(modelo);
    		
    	}catch(Exception e) {	
    		JOptionPane.showMessageDialog(null, "Error, no se cargaron los datos a la tabla, contactar con administrador");
    		System.out.println("Error, no se cargo el historial: "+e.getLocalizedMessage());
    	}
	}
	
	/**
	 * Eliminaremos la fila seleccionada por el usuario del historial 
	 * @param admCuenta es el JDialog JDMarcoAdmCuentas
	 */
	public void eliminarFilaHistorial(JDMarcoAdmCuentas admCuenta) {
    	
    	int fila = admCuenta.getAdmMovi().getTable().getSelectedRow();
    	
    	if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar.");
            return;
        }
    	
    	String id = admCuenta.getAdmMovi().getTable().getValueAt(fila, 0).toString();
    	
    	try {
    		ps = con.getConexion().prepareStatement(ELIMINAR_FILA_HISTORIAL);
    		ps.setString(1, id);
    		int rowsAffected = ps.executeUpdate();
    		
   		 if (rowsAffected > 0) {
	             JOptionPane.showMessageDialog(null, "¡Fila Eliminada Correctamente!");
	         } else {
	             JOptionPane.showMessageDialog(null, "Error, No se pudo eliminar la fila");
	        }
   		 
   		obtenerHistorial(admCuenta.getMarcoAdm().getAdmCuentas());
   		admCuenta.getAdmMovi().getModelo().fireTableDataChanged();
    	}catch(Exception e) {
    		JOptionPane.showMessageDialog(null, "Error al eliminar la fila, contactar con administrador");
    		System.out.println("Error al eliminar la fila del historial: "+e.getLocalizedMessage());
    	}
    	
    }
	
	/**
	 * Se borra el historial completamente
	 * @param admCuenta es el JDialog JDMarcoAdmCuentas
	 */
	public void vaciarHistorial(JDMarcoAdmCuentas admCuenta) {
    	
		try {
			sta = con.getConexion().createStatement();
			int rowAffected = sta.executeUpdate(VACIAR_HISTORIAL);
    	
   		 
			if (rowAffected > 0) {
	            JOptionPane.showMessageDialog(null, "Historial vaciado correctamente.");
	        } else {
	            JOptionPane.showMessageDialog(null, "Error, No se pudo vaciar el historial.");
	        }

			
   		obtenerHistorial(admCuenta.getMarcoAdm().getAdmCuentas());
   		admCuenta.getAdmMovi().getModelo().fireTableDataChanged();
    	}catch(Exception e) {
    		JOptionPane.showMessageDialog(null, "Error al vaciar el historial, contactar con administrador");
    		System.out.println("Error al vaciar historial: "+e.getLocalizedMessage());
    	}
    	
    }
	
	
}
