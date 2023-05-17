package principal.modelo.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import principal.modelo.Conexion;
import principal.modelo.Consultas;
import principal.modelo.DTO.TarjetaDTO;
import principal.modelo.DTO.UsuarioDTO;
import principal.vista.Excepciones;
import principal.vista.UsuarioAdministrador.JDMarcoAdmTarjetas;
import principal.vista.UsuarioAdministrador.JDMarcoAdmUsuarios;
import principal.vista.UsuarioCorriente.JDCambiarPin;

public class TarjetaDAO implements Consultas, Excepciones{
	private TarjetaDTO tarjeta;
	private PreparedStatement ps = null;
	private Statement sta = null;
	private ResultSet resultSet = null;
	private Conexion con = new Conexion();

/**
 * Método para actualizar el pin de la tarjeta
 * @param pin es el nuevo pin 
 * @param cmb_pin es el JDialog JDCambiarPin
 */
	public void actualizarPin(String pin, JDCambiarPin cmb_pin) {
	     try {
	         this.ps = con.getConexion().prepareStatement(ACTUALIZAR_PIN);
	         this.ps.setString(1, pin);
	         this.ps.setString(2, cmb_pin.getMarco().getTxt_numTarjeta().getText());
	         
	         int rowsAffected = ps.executeUpdate(); // Ejecutar la actualización y obtener el número de filas afectadas

	         if (rowsAffected > 0) {
	             JOptionPane.showMessageDialog(null, "¡Pin actualizado correctamente!");
	         } else {
	             JOptionPane.showMessageDialog(null, "No se pudo actualizar el PIN");
	         }
	         
	         cmb_pin.setVisible(false);
	     } catch (Exception e) {
	         JOptionPane.showMessageDialog(null, "Error al actualizar PIN, contacta con un administrador");
	         System.out.println("Error al actualizar PIN: " + e.getLocalizedMessage());
	     }
	}
	
	
	
	/**
	 * Se cargarán los datos de una tarjeta indicada
	 * @param admTarjeta es el JDialog JDMarcoAdmTarjetas
	 */
	 public void cargarTarjetas(JDMarcoAdmTarjetas admTarjeta) {
	    	String[] datos = new String[5];
	    	
	    	String codSQL = null;
	    	
	    	if(admTarjeta.getComboBuscar().getSelectedIndex()==0) {
	    		codSQL = LISTAR_TARJETAS;
	    	}else if(admTarjeta.getComboBuscar().getSelectedIndex()==1) {
	    		codSQL = FILTRAR_TARJETA_ID+"'"+admTarjeta.getTxtBuscar().getText()+"'";
	    	}else if(admTarjeta.getComboBuscar().getSelectedIndex()==2) {
	    		codSQL = FILTRAR_TARJETA_CVV+"'"+admTarjeta.getTxtBuscar().getText()+"'";
	    	}else if(admTarjeta.getComboBuscar().getSelectedIndex()==3) {
	    		codSQL = FILTRAR_TARJETA_FECHA+"'"+admTarjeta.getTxtBuscar().getText()+"'";
	    	}else if(admTarjeta.getComboBuscar().getSelectedIndex()==4) {
	    		codSQL =FILTRAR_TARJETA_DNI+"'"+admTarjeta.getTxtBuscar().getText()+"'";
	    	}
	    	
	    	
	    	try {
	    		sta = con.getConexion().createStatement();
	    		resultSet = sta.executeQuery(codSQL);
	    		DefaultTableModel modelo = admTarjeta.getModelo();
	    		modelo.setRowCount(0);
	    		while(resultSet.next()) {
	    			datos[0] = resultSet.getString(1);
	    			datos[1] = resultSet.getString(2);
	    			datos[2] = resultSet.getString(3);
	    			datos[3] = resultSet.getString(4);
	    			datos[4] = resultSet.getString(5);

	    			modelo.addRow(datos);
	    		}
	 
	    		JTable tabla = admTarjeta.getTable();
	    		tabla.setModel(modelo);
	    		
	    	}catch(Exception e) {	
	    		JOptionPane.showMessageDialog(null, "Error, no se cargaron los datos a la tabla, contactar con administrador");
	    		System.out.println("Error, no se cargaron las tarjetas: "+e.getLocalizedMessage());
	    	}
	     }
	 
	 
	 /**
	  * Se modificarán los datos de la tarjeta deseada
	  * @param admTarjeta es el JDialog JDMarcoAdmTarjetas
	  */
	 public void modificarTarjeta(JDMarcoAdmTarjetas admTarjeta) {
	    	int fila = admTarjeta.getTable().getSelectedRow();
	    	
	    	if (fila == -1) {
	            JOptionPane.showMessageDialog(null, "Seleccione una fila para modificar.");
	            return;
	        }
	    	if (admTarjeta.getTable().getCellEditor() != null) {
	            admTarjeta.getTable().getCellEditor().stopCellEditing();
	        }

	    	
	    	String ID = admTarjeta.getTable().getValueAt(fila, 0).toString();
	    	String pin = admTarjeta.getTable().getValueAt(fila, 1).toString();
	    	String cvv = admTarjeta.getTable().getValueAt(fila, 2).toString();
	    	String fecha_cad = admTarjeta.getTable().getValueAt(fila, 3).toString();
	    	String dni_usr = admTarjeta.getTable().getValueAt(fila, 4).toString();
	    	
	    	
	    	 if(validarCamposTarjetas(ID, pin,cvv,fecha_cad, dni_usr, validarDniUsr(dni_usr))) {
	    	
	    	try {
	    		ps = con.getConexion().prepareStatement(MODIFICAR_TARJETA);
	    		ps.setString(1, pin);
	    		ps.setString(2, cvv);
	    		ps.setString(3, fecha_cad);
	    		ps.setString(4, dni_usr);
	    		ps.setString(5, ID);
	    		
	    		int rowsAffected = ps.executeUpdate();
	    		
	   		 if (rowsAffected > 0) {
		             JOptionPane.showMessageDialog(null, "¡Datos Actualizados Correctamente!");
		         } else {
		             JOptionPane.showMessageDialog(null, "Error, No se pudo actualizar");
		        }
	   		 
	   		cargarTarjetas(admTarjeta.getMarcoAdm().getAdmTarjetas());
	   		admTarjeta.getModelo().fireTableDataChanged();
	   		 
	    	}catch(Exception e) {
	    		JOptionPane.showMessageDialog(null, "Error al modificar los datos de la tarjeta, contacte con un administrador");
	    		System.out.println("Error al modificar los datos de la tarjeta"+e.getLocalizedMessage());
	    	}
	    	 }
	    }
	 
	 /**
	  * Método para eliminar la tarjeta seleccionada
	  * @param admTarjeta es el JDialog JDMarcoAdmTarjetas
	  */
	 public void eliminarTarjeta(JDMarcoAdmTarjetas admTarjeta) {
	    	int fila = admTarjeta.getTable().getSelectedRow();
	    	
	    	if (fila == -1) {
	            JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar.");
	            return;
	        }
	    	
	    	
	    	String dni = admTarjeta.getTable().getValueAt(fila, 0).toString();
	 
	    	
	    	try {
	    		ps = con.getConexion().prepareStatement(ELIMINAR_TARJETA);
	    		ps.setString(1, dni);
	    		int rowsAffected = ps.executeUpdate();
	    		
	   		 if (rowsAffected > 0) {
		             JOptionPane.showMessageDialog(null, "¡Tarjeta Eliminada Correctamente!");
		         } else {
		             JOptionPane.showMessageDialog(null, "Error, No se pudo eliminar la tarjeta");
		        }
	   		 
	   		cargarTarjetas(admTarjeta.getMarcoAdm().getAdmTarjetas());
	   		admTarjeta.getModelo().fireTableDataChanged();
	    	}catch(Exception e) {
	    		JOptionPane.showMessageDialog(null, "Error al eliminar la tarjeta, contactar con administrador");
	    		System.out.println("Error al eliminar tarjeta: "+e.getLocalizedMessage());
	    	}
	    	
	    }
	 
	 
	 /**
	  * Método para crear tarjetas 
	  * @param admTarjeta es el JDialog JDMarcoAdmTarjetas
	  */
	 public void crearTarjeta(JDMarcoAdmTarjetas admTarjeta) {
		 	String ID = admTarjeta.getCrearTarjeta().getTxtid().getText();
	    	String pin = admTarjeta.getCrearTarjeta().getTxtpin().getText();
	    	String cvv = admTarjeta.getCrearTarjeta().getTxtcvv().getText();
	    	String fecha_cad = admTarjeta.getCrearTarjeta().getTxtfechaCad().getText();
	    	String dni_usr = admTarjeta.getCrearTarjeta().getTxtdni_usr().getText();

	       if(validarCamposTarjetas(ID, pin,cvv,fecha_cad, dni_usr, validarDniUsr(dni_usr))) {
	            try {
	                ps = con.getConexion().prepareStatement(INSERTAR_TARJETA);
	                ps.setString(1, ID);
	                ps.setString(2, pin);
	                ps.setString(3, cvv);
	                ps.setString(4, fecha_cad);
	                ps.setString(5, dni_usr);
	               ;
	                int rowsAffected = ps.executeUpdate();

	                if (rowsAffected > 0) {
	                    JOptionPane.showMessageDialog(null, "¡Tarjeta creada correctamente!");
	                } else {
	                    JOptionPane.showMessageDialog(null, "Error, no se pudo crear la tarjeta");
	                }

	                admTarjeta.getCrearTarjeta().dispose();
	                cargarTarjetas(admTarjeta.getMarcoAdm().getAdmTarjetas());
	                admTarjeta.getModelo().fireTableDataChanged();
	            } catch (Exception e) {
	                JOptionPane.showMessageDialog(null, "Error al crear la tarjeta, contacte un administrador");
	                System.out.println("Error, no se pudo crear la tarjeta: " + e.getLocalizedMessage());
	            }
	        }
	 }
	 
	 /**
	  * Se validará que el dni que se ha introducido existe
	  * @param dni_usr es el dni del usuario
	  * @return true 
	  */
	 public boolean validarDniUsr(String dni_usr) {
		    try {
		        this.ps = con.getConexion().prepareStatement(CARGAR_USR);
		        this.ps.setString(1, dni_usr);

		        ResultSet rs = ps.executeQuery();
		        if (rs.next()) {
		            return true; 
		        }
		    } catch (Exception e) {
		        System.out.println("Error al validar el usuario para crear tarjeta: " + e.getMessage());
		    }
		    return false; 
		}
}
