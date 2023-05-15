package principal.modelo.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import principal.modelo.Conexion;
import principal.modelo.Consultas;
import principal.modelo.DTO.TarjetaDTO;
import principal.modelo.DTO.UsuarioDTO;
import principal.vista.UsuarioCorriente.MarcoCambiarPin;

public class TarjetaDAO implements Consultas{
	private TarjetaDTO tarjeta;
	private PreparedStatement ps = null;
	private Statement sta = null;
	private ResultSet resultSet = null;
	private Conexion con = new Conexion();


	public void actualizarPin(String pin, MarcoCambiarPin cmb_pin) {
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
}
