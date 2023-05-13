package principal.modelo.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.Date;
import principal.modelo.Conexion;
import principal.modelo.Consultas;
import principal.modelo.DTO.HistorialDTO;

public class HistorialDAO implements Consultas{
	private PreparedStatement ps = null;
    private Statement sta = null;
    private ResultSet resultSet = null;
    private Conexion con = new Conexion();
	
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
}
