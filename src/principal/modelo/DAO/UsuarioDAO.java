package principal.modelo.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import principal.modelo.*;

public class UsuarioDAO implements Consultas{
	private String clave = "admin";
	private ArrayList<UsuarioDAO> usuario = new ArrayList<UsuarioDAO>();
	private PreparedStatement ps = null;
	private ResultSet resultSet = null;
	private Conexion con = new Conexion();
	
	//LOGIN
	public boolean validarUsuario(String usuario, String password) {
		try {
			this.ps = this.con.getConexion().prepareStatement(BUSCAR_PIN);
			this.ps.setString(1, usuario);
			this.resultSet = this.ps.executeQuery();
			if(resultSet.next()) {
				String pass = resultSet.getString(1);
				return pass.equals(password);
				
			}else {
				return false;
			}
		}catch(Exception e) {
			System.out.println("Error al validar usuario: "+ e.getLocalizedMessage());
			return false;
		}
	}
	
	public int devolverTipoUsuario(String usuario) {
		try {
			this.ps = this.con.getConexion().prepareStatement(TIPO_USR);
			this.ps.setString(1, usuario);
			this.resultSet = this.ps.executeQuery();
			if(resultSet.next()) {
				int tipo = resultSet.getInt("tipo_usuario");
				return tipo;
				
			}else {
				return 0;
			}
		}catch(Exception e) {
			System.out.println("Error al identificar tipo usuario: "+ e.getLocalizedMessage());
			return 0;
		}
		
	}
}
