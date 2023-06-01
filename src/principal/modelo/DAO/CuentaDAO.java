package principal.modelo.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import principal.modelo.Conexion;
import principal.modelo.Consultas;
import principal.vista.Excepciones;
import principal.vista.UsuarioAdministrador.JDMarcoAdmCuentas;
import principal.vista.UsuarioAdministrador.JDMarcoAdmTarjetas;
import principal.vista.UsuarioCorriente.JDIngresarSaldo;
import principal.vista.UsuarioCorriente.JDRetirarSaldo;

public class CuentaDAO implements Consultas, Excepciones{
	/**
	 * 
	 * @author Noel
	 *CuentaDAO en el se crearán los métodos para realizar distintas operaciones en la base de datos sobre las cuentas
	 */
	
	 	private PreparedStatement ps = null;
	    private Statement sta = null;
	    private ResultSet resultSet = null;
	    private Conexion con = new Conexion();
	    
	    /**
	     * se encarga de ingresar el saldo a la cuenta
	     * @param numCuenta es el numero de cuenta en la que ingresaremos el saldo
	     * @param saldo es el que se va a ingresar 
	     * @param marcoIngresar es el Dialog JDIngresarSaldo
	     */
	    public void ingresarSaldo(String numCuenta, double saldo, JDIngresarSaldo marcoIngresar) {
	    	try {
	    		if(!validarSaldo(saldo)) {
	    		this.ps = con.getConexion().prepareStatement(INGRESAR_SALDO);
	    		ps.setDouble(1, saldo);
	    		ps.setString(2, numCuenta);
	    		int rowsAffected = ps.executeUpdate();
	    		
	    		 if (rowsAffected > 0) {
		             JOptionPane.showMessageDialog(null, "¡Saldo ingresado correctamente!");
		         } else {
		             JOptionPane.showMessageDialog(null, "Error, No se pudo ingresar el saldo");
		         }
	    		
	    		CajeroDAO cajero = new CajeroDAO();
	    		cajero.actualizarSaldo(1, saldo);
	    		HistorialDAO historial = new HistorialDAO();
	    		historial.anadirOperaciones(numCuenta, 1, saldo);
	    		marcoIngresar.setVisible(false);
	    		}
	    	}catch(Exception e) {
	    		JOptionPane.showMessageDialog(null, "Error al ingresar saldo, contactar con administrador");
	    		System.out.println("Error al ingresar saldo: "+e.getLocalizedMessage());
	    	}
	    	
	    }
	    
	    /**
	     *Se encarga de retirar el saldo de la cuenta
	     * @param numCuenta es el numero de la cuenta a la cual retiraremos el saldo
	     * @param saldo es el saldo a retirar
	     * @param marcoRetirar es el JDialog JDRetirarSaldo
	     */
	    public void retirarSaldo(String numCuenta, double saldo, JDRetirarSaldo marcoRetirar) {
	    	try {
	    		if(!validarSaldo(saldo)) {
	    		this.ps = con.getConexion().prepareStatement(RETIRAR_SALDO);
	    		ps.setDouble(1, saldo);
	    		ps.setString(2, numCuenta);
	    		int rowsAffected = ps.executeUpdate();
	    		
	    		 if (rowsAffected > 0) {
		             JOptionPane.showMessageDialog(null, "¡Saldo retirado correctamente!");
		         } else {
		             JOptionPane.showMessageDialog(null, "Error, No se pudo retirar el saldo");
		         }
	    		
	    		CajeroDAO cajero = new CajeroDAO();
	    		cajero.actualizarSaldo(2, saldo);
	    		HistorialDAO historial = new HistorialDAO();
	    		historial.anadirOperaciones(numCuenta, 2, saldo);
	    		marcoRetirar.setVisible(false);
	    		}
	    	}catch(Exception e) {
	    		JOptionPane.showMessageDialog(null, "Error al ingresar saldo, contactar con administrador");
	    		System.out.println("Error al ingresar saldo: "+e.getLocalizedMessage());
	    	}
	    }
	    
	    /**
	     * Obtenemos las cuentas de la base de datos
	     * @param admCuenta es el JDialog JDMarcoAdmCuentas
	     */
	    public void cargarCuentas(JDMarcoAdmCuentas admCuenta) {
	    	String[] datos = new String[4];
	    	
	    	String codSQL = null;
	    	
	    	if(admCuenta.getComboBuscar().getSelectedIndex()==0) {
	    		codSQL = LISTAR_CUENTAS;
	    	}else if(admCuenta.getComboBuscar().getSelectedIndex()==1) {
	    		codSQL = FILTRAR_CUENTA_ID+"'"+admCuenta.getTxtBuscar().getText()+"'";
	    	}else if(admCuenta.getComboBuscar().getSelectedIndex()==2) {
	    		codSQL = FILTRAR_CUENTA_NOMBRE+"'"+admCuenta.getTxtBuscar().getText()+"'";
	    	}else if(admCuenta.getComboBuscar().getSelectedIndex()==3) {
	    		codSQL = FILTRAR_CUENTA_SALDO+"'"+admCuenta.getTxtBuscar().getText()+"'";
	    	}else if(admCuenta.getComboBuscar().getSelectedIndex()==4) {
	    		codSQL =FILTRAR_CUENTA_ID_TARJETA+"'"+admCuenta.getTxtBuscar().getText()+"'";
	    	}
	    	
	    	
	    	try {
	    		sta = con.getConexion().createStatement();
	    		resultSet = sta.executeQuery(codSQL);
	    		DefaultTableModel modelo = admCuenta.getModelo();
	    		modelo.setRowCount(0);
	    		while(resultSet.next()) {
	    			datos[0] = resultSet.getString(1);
	    			datos[1] = resultSet.getString(2);
	    			datos[2] = resultSet.getString(3);
	    			datos[3] = resultSet.getString(4);
	  

	    			modelo.addRow(datos);
	    		}
	 
	    		JTable tabla = admCuenta.getTable();
	    		tabla.setModel(modelo);
	    		
	    	}catch(Exception e) {	
	    		JOptionPane.showMessageDialog(null, "Error, no se cargaron los datos a la tabla, contactar con administrador");
	    		System.out.println("Error, no se cargaron las cuentas: "+e.getLocalizedMessage());
	    	}
	     }
	    
	    
	    /**
	     * Modificar los datos de las cuentas
	     * @param admCuenta es el JDialog JDMarcoAdmCuentas
	     */
	    public void modificarCuenta(JDMarcoAdmCuentas admCuenta) {
	    	int fila = admCuenta.getTable().getSelectedRow();
	    	
	    	if (fila == -1) {
	            JOptionPane.showMessageDialog(null, "Seleccione una fila para modificar.");
	            return;
	        }
	    	if (admCuenta.getTable().getCellEditor() != null) {
	            admCuenta.getTable().getCellEditor().stopCellEditing();
	        }

	    	
	    	String ID = admCuenta.getTable().getValueAt(fila, 0).toString();
	    	String nombre = admCuenta.getTable().getValueAt(fila, 1).toString();
	    	String saldo = admCuenta.getTable().getValueAt(fila, 2).toString();
	    	String id_tarjeta = admCuenta.getTable().getValueAt(fila, 3).toString();
	    	
	    	 if(validarCamposCuenta(ID, nombre ,saldo,id_tarjeta, validarIdTarjeta(id_tarjeta))) {
	    	try {
	    		ps = con.getConexion().prepareStatement(MODIFICAR_CUENTA);
	    		ps.setString(1, nombre);
	    		ps.setString(2, saldo);
	    		ps.setString(3, id_tarjeta);
	    		ps.setString(4, ID);
	    		
	    		int rowsAffected = ps.executeUpdate();
	    		
	   		 if (rowsAffected > 0) {
		             JOptionPane.showMessageDialog(null, "¡Datos Actualizados Correctamente!");
		         } else {
		             JOptionPane.showMessageDialog(null, "Error, No se pudo actualizar");
		        }
	   		 
	   		cargarCuentas(admCuenta.getMarcoAdm().getAdmCuentas());
	   		admCuenta.getModelo().fireTableDataChanged();
	   		 
	    	}catch(Exception e) {
	    		JOptionPane.showMessageDialog(null, "Error al modificar los datos de la cuenta, contacte con un administrador");
	    		System.out.println("Error al modificar los datos de la cuenta: "+e.getLocalizedMessage());
	    	}
	    	 }
	    	 }
	    
	    
	    /**
	     * Eliminar la cuenta seleccionada por el usuario
	     * @param admCuenta es el JDialog JDMarcoAdmCuentas
	     */
	    public void eliminarCuenta(JDMarcoAdmCuentas admCuenta) {
	    	
	    	int fila = admCuenta.getTable().getSelectedRow();
	    	
	    	if (fila == -1) {
	            JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar.");
	            return;
	        }
	    	
	    	
	    	String dni = admCuenta.getTable().getValueAt(fila, 0).toString();
	 
	    	
	    	try {
	    		ps = con.getConexion().prepareStatement(ELIMINAR_CUENTA);
	    		ps.setString(1, dni);
	    		int rowsAffected = ps.executeUpdate();
	    		
	   		 if (rowsAffected > 0) {
		             JOptionPane.showMessageDialog(null, "¡Cuenta Eliminada Correctamente!");
		         } else {
		             JOptionPane.showMessageDialog(null, "Error, No se pudo eliminar la cuenta");
		        }
	   		 
	   		cargarCuentas(admCuenta.getMarcoAdm().getAdmCuentas());
	   		admCuenta.getModelo().fireTableDataChanged();
	    	}catch(Exception e) {
	    		JOptionPane.showMessageDialog(null, "Error al eliminar la cuenta, contactar con administrador");
	    		System.out.println("Error al eliminar cuenta: "+e.getLocalizedMessage());
	    	}
	    	
	    }
	  
	    /**
	     * Crear cuentas de usuario y asociarla a una tarjeta
	     * @param admCuenta es el JDialog JDMarcoAdmCuentas
	     */
	    public void crearCuenta(JDMarcoAdmCuentas admCuenta) {
	        String ID = admCuenta.getCrearCuenta().getTxtid().getText();
	        String nombre = admCuenta.getCrearCuenta().getTxtnombre().getText();
	        String saldo = admCuenta.getCrearCuenta().getTxtsaldo().getText();
	        String id_tarjeta = admCuenta.getCrearCuenta().getTxtid_tarjeta().getText();
	        if(validarCamposCuenta(ID, nombre ,saldo,id_tarjeta, validarIdTarjeta(id_tarjeta))) {
	        try {
	            ps = con.getConexion().prepareStatement(INSERTAR_CUENTA);
	            ps.setString(1, ID);
	            ps.setString(2, nombre);
	            ps.setString(3, saldo);
	                    
	            int rowsAffected = ps.executeUpdate();

	            if (rowsAffected > 0) {
	            	ps = con.getConexion().prepareStatement(INSERTAR_TARJETA_CUENTA);
	                ps.setString(1, ID);
	                ps.setString(2, id_tarjeta);
	                
	                int rowsAffectedTarjetaCuenta = ps.executeUpdate();

	                if (rowsAffectedTarjetaCuenta > 0) {
	                    JOptionPane.showMessageDialog(null, "¡Cuenta creada correctamente!");
	                } else {
	                    JOptionPane.showMessageDialog(null, "Error, no se pudo crear la cuenta");
	                }
	            }

	            admCuenta.getCrearCuenta().dispose();
	            cargarCuentas(admCuenta.getMarcoAdm().getAdmCuentas());
	            admCuenta.getModelo().fireTableDataChanged();
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null, "Error al crear la Cuenta, contacte un administrador");
	            System.out.println("Error, no se pudo crear la Cuenta: " + e.getLocalizedMessage());
	        }
	        }
	    }
	 
	    /**
	     * Validar que el id de tarjeta que ha introducido el usuario es valido
	     * @param id_tarjeta es el numero de la tarjeta a la cual vincularemos la cuenta
	     * @return true
	     */
	    public boolean validarIdTarjeta(String id_tarjeta) {
		    try {
		        this.ps = con.getConexion().prepareStatement(ID_TARJETA);
		        ps.setString(1, id_tarjeta);

		        ResultSet rs = ps.executeQuery();
		        if (rs.next()) {
		            return true; 
		        }
		    } catch (Exception e) {
		        System.out.println("Error al validar el id_tarjeta para crear cuenta: " + e.getMessage());
		    }
		    return false; 
		}
	    
	    
}
