package principal.modelo.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import principal.modelo.Conexion;
import principal.modelo.Consultas;
import principal.modelo.DTO.CajeroDTO;
import principal.vista.Excepciones;
import principal.vista.UsuarioAdministrador.JDMarcoAdmCajero;

/**
 * 
 * @author Noel
 *CajeroDAO en el se harán las operaciones sobre la base de datos que tengan que ver con el cajero
 */
public class CajeroDAO implements Consultas, Excepciones{
	CajeroDTO cajero = null;
    private PreparedStatement ps = null;
    private Statement sta = null;
    private ResultSet resultSet = null;
    private Conexion con = new Conexion();
    

    /**
     * Para cargar los datos del cajero
     * @return CajeroDTO 
     */
    public CajeroDTO obtenerCajero() {
        CajeroDTO cajero = null;
        
        try {
            sta = con.getConexion().createStatement();
            resultSet = sta.executeQuery(CARGAR_CAJERO);
            if (resultSet.next()) {
                cajero = new CajeroDTO();
                cajero.setNum_cajero(resultSet.getInt("id"));
                cajero.setSaldo(resultSet.getDouble("saldo"));
            }
            
        } catch (Exception e) {
            System.out.println("Error al cargar cajero: " + e.getLocalizedMessage());
        }
        
        return cajero;
    }
    
    /**
     * 
     * @param op es la operación a realizar si es 1 es ingresar, si es 2 es retirar
     * @param saldo es el saldo a ingresar en el cajero
     * método para actualizar el saldo del cajero
     */
    public void actualizarSaldo(int op, double saldo) {
    	try {
    		cajero = obtenerCajero();
    		double saldo_actual = cajero.getSaldo();
    		this.ps = con.getConexion().prepareStatement(ACTUALIZAR_SALDO_CAJERO);
    		if(op==1) {
    			this.ps.setDouble(1, (saldo_actual+saldo));
    		}else if(op==2) {
    			this.ps.setDouble(1, (saldo_actual-saldo));
    		}
    		int rowsAffected = ps.executeUpdate();
    		
   		 if (rowsAffected > 0) {
	             System.out.println("Saldo ingresado correctamente");
	         } else {
	        	 System.out.println("No se pudo ingresar el saldo");
	         }
    	}catch(Exception e) {
    		System.out.println("Error al actualizar saldo del cajero: "+e.getLocalizedMessage());
    	}
    	
    }
    
    /**
     * 
     * @param marco es el JDMarcoAdmCajero
     * Se encarga de cargar el cajero para las opciones de administración
     */
    public void cargarCajero(JDMarcoAdmCajero marco) {
    	try {
    		sta = con.getConexion().createStatement();
        	resultSet = sta.executeQuery(SALDO_CAJERO);
        	
        	if(resultSet.next()) {
        		marco.getSaldo().setText(resultSet.getString("saldo"));
        	}
    	}catch(Exception e) {
    		JOptionPane.showMessageDialog(null, "Error al cargar saldo del cajero, contactar con un administrador");
    		System.out.println("Error al cargar saldo del cajero:"+e.getLocalizedMessage());
    	}
    	
    }
    
    /**
     * Se encarga de actualizar el saldo del cajero desde las opciones de administrador
     * @param marco es el JDMarcoAdmCajero
     */
    public void actualizarSaldoCajero(JDMarcoAdmCajero marco) {
    	if(validarSaldoCajero(marco.getSaldo().getText())) {
    	try {
    		this.ps = con.getConexion().prepareStatement(ACTUALIZAR_SALDO_CAJERO);
    		ps.setString(1, marco.getSaldo().getText());
    		int rowsAffected = ps.executeUpdate();
    		
   		 if (rowsAffected > 0) {
	             JOptionPane.showMessageDialog(null, "Saldo actualizado correctamente");
	         } else {
	        	 JOptionPane.showMessageDialog(null, "No se pudo actualizar el saldo");
	         }
   		cargarCajero(marco);
    	}catch(Exception e) {
    		System.out.println("Error al actualizar saldo del cajero: "+e.getLocalizedMessage());
    	}
    	}
    }
}
