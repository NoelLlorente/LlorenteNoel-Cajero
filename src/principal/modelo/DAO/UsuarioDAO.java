package principal.modelo.DAO;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;

import principal.modelo.Conexion;
import principal.modelo.Consultas;
import principal.modelo.DTO.CajeroDTO;
import principal.modelo.DTO.CuentaDTO;
import principal.modelo.DTO.TarjetaDTO;
import principal.modelo.DTO.UsuarioAdministrador;
import principal.modelo.DTO.UsuarioCorriente;
import principal.modelo.DTO.UsuarioDTO;


public class UsuarioDAO implements Consultas{
	private String clave = "admin";
	private ArrayList<UsuarioDTO> usuarios = new ArrayList<UsuarioDTO>();
	private PreparedStatement ps = null;
	private Statement sta = null;
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
	
	public int devolverTipoUsuario(String dni) {
		try {
			this.ps = this.con.getConexion().prepareStatement(TIPO_USR);
			this.ps.setString(1, dni);
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
	
	public void cargarDatos() {
		try {
			sta = con.getConexion().createStatement();
			resultSet = sta.executeQuery(CARGAR_USR);
			 
			 while (resultSet.next()) {
				 String dni = resultSet.getString("dni");
				 String nombre = resultSet.getString("nombre");
				 String apellidos = resultSet.getString("apellidos");
				 String fecha = resultSet.getDate("fecha_nac").toString();
				 String telf = resultSet.getString("telefono");
				 String direccion = resultSet.getString("direccion");
				 int tipo_usr = devolverTipoUsuario(dni);
				 
				 UsuarioDTO usuario = null;
				 if(tipo_usr==1) {
					 usuario = new UsuarioCorriente();
				 }else if(tipo_usr==2) {
					 usuario = new UsuarioAdministrador();
				 }
				 	
	                usuario.setDni(dni);
	                usuario.setNombre(nombre);
	                usuario.setApellidos(apellidos);
	                usuario.setFecha_nacimiento(fecha);
	                usuario.setTelefono(telf);
	                usuario.setDireccion(direccion);
	     

	                // Obtener tarjeta asociada al usuario
	                TarjetaDTO tarjeta = obtenerTarjeta(usuario.getDni());
	                usuario.setTarjeta(tarjeta);

	                // Agregar usuario a la lista
	               usuarios.add(usuario);
			 }
			 CajeroDTO cajero = obtenerCajero();
			 
			 
			 
		}catch(Exception e) {
	            	System.out.println("Error al cargar datos: "+ e.getLocalizedMessage());
			
		}
	}
	
	 private TarjetaDTO obtenerTarjeta(String dniUsuario) {
	        TarjetaDTO tarjeta = null;

	        try {
	        	this.ps = con.getConexion().prepareStatement(CARGAR_TARJETA);
	        	this.ps.setString(1, dniUsuario);
	        	resultSet = ps.executeQuery(); 
	        	
	            if (resultSet.next()) {
	                tarjeta = new TarjetaDTO();
	                tarjeta.setNum_tarjeta(resultSet.getString("id"));	         
	                tarjeta.setPin(resultSet.getString("pin"));
	                tarjeta.setCvv(resultSet.getString("cvv"));
	                tarjeta.setFecha_caducidad(resultSet.getDate("fecha_caducidad").toString());

	                // Obtener cuentas asociadas a la tarjeta
	                ArrayList<CuentaDTO> cuentas = obtenerCuentas(tarjeta.getNum_tarjeta());
	                tarjeta.setCuenta(cuentas);
	            }
	            
	        	}catch (Exception e) {
	        	System.out.println("Error al obtenerTarjeta: "+ e.getLocalizedMessage());
	    }

	        return tarjeta;
	     } 
	     
	    private ArrayList<CuentaDTO> obtenerCuentas(String idTarjeta) {
	        ArrayList<CuentaDTO> cuentas = new ArrayList<>();

	        try {
	        		this.ps = con.getConexion().prepareStatement(CARGAR_CUENTA);
	        		this.ps.setString(1, idTarjeta);
	        		resultSet = ps.executeQuery();

	            while (resultSet.next()) {
	                CuentaDTO cuenta = new CuentaDTO();
	                cuenta.setNum_cuenta(resultSet.getString("id"));
	                cuenta.setNombre(resultSet.getString("nombre"));
	                cuenta.setSaldo(resultSet.getDouble("saldo"));

	                cuentas.add(cuenta);
	            }
	           
	        } catch (Exception e) {
	        	System.out.println("Error al obtener cuentas: "+ e.getLocalizedMessage());
	        }

	        return cuentas;
	    }
	    
	    private CajeroDTO obtenerCajero() {
	    	try {
	    		resultSet = sta.executeQuery(CARGAR_CAJERO);
	    		CajeroDTO cajero = new CajeroDTO();
	    		while(resultSet.next()) {
	    			cajero.setNum_cajero(resultSet.getInt("id"));
	    			cajero.setSaldo(resultSet.getDouble("saldo"));
	    		}
	    		
	    		return cajero;
	    	}catch(Exception e) {
	    		System.out.println("Error al cargar cajero: "+e.getLocalizedMessage());
	    		return null;
	    	}
			
	    }

		public Conexion getCon() {
			return con;
		}

		public ArrayList<UsuarioDTO> getUsuarios() {
			return usuarios;
		}

		public void setUsuarios(ArrayList<UsuarioDTO> usuarios) {
			this.usuarios = usuarios;
		}

	
	    
	    
}


