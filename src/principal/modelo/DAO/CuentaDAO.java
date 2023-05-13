package principal.modelo.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import principal.modelo.Conexion;
import principal.modelo.Consultas;
import principal.vista.Excepciones;
import principal.vista.JDIngresarSaldo;
import principal.vista.JDRetirarSaldo;

public class CuentaDAO implements Consultas, Excepciones{
	 	private PreparedStatement ps = null;
	    private Statement sta = null;
	    private ResultSet resultSet = null;
	    private Conexion con = new Conexion();
	    
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
	    		historial.añadirOperaciones(numCuenta, 1, saldo);
	    		marcoIngresar.setVisible(false);
	    		}
	    	}catch(Exception e) {
	    		JOptionPane.showMessageDialog(null, "Error al ingresar saldo, contactar con administrador");
	    		System.out.println("Error al ingresar saldo: "+e.getLocalizedMessage());
	    	}
	    	
	    }
	    
	    
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
	    		historial.añadirOperaciones(numCuenta, 2, saldo);
	    		marcoRetirar.setVisible(false);
	    		}
	    	}catch(Exception e) {
	    		JOptionPane.showMessageDialog(null, "Error al ingresar saldo, contactar con administrador");
	    		System.out.println("Error al ingresar saldo: "+e.getLocalizedMessage());
	    	}
	    }
	    
	    
	  
	    
}
