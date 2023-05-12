package principal.modelo.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import principal.modelo.Conexion;
import principal.modelo.Consultas;
import principal.modelo.DTO.TarjetaDTO;

public class TarjetaDAO implements Consultas{
	private TarjetaDTO tarjeta;
	private PreparedStatement ps = null;
	private Statement sta = null;
	private ResultSet resultSet = null;
	private Conexion con = new Conexion();
	
	
	public void actualizarPin(String pin) {
		 try {
					
			 this.ps = con.getConexion().prepareStatement(ACTUALIZAR_PIN);
			 this.ps.setString(1, pin);
			 this.ps.setString(2, dni);
			 resultSet = ps.executeQuery();
			 ps.executeUpdate();
			 JOptionPane.showMessageDialog(null, "¡Pin actualizado correctamente!");
		 }catch(Exception e) {
			 JOptionPane.showMessageDialog(null, "Error al actualizar PIN");
			 System.out.println(e.getLocalizedMessage());
		 }
		 
		
	}
}
