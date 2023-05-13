package principal.modelo.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import principal.modelo.Conexion;
import principal.modelo.Consultas;
import principal.modelo.DTO.CajeroDTO;

public class CajeroDAO implements Consultas{
	CajeroDTO cajero = null;
    private PreparedStatement ps = null;
    private Statement sta = null;
    private ResultSet resultSet = null;
    private Conexion con = new Conexion();
    

    
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
}
