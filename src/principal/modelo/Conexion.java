package principal.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexion {
	final private String driver = "com.mysql.cj.jdbc.Driver";
	final private String host = "localhost";
	final private String user = "root";
	final private String passwd_casa = "root";
	final private String passwd_cole = "admin";
	private Connection conexion;
	private Statement statement;
	

	public Conexion() {
		try {
			//Cargamos el driver
			Class.forName(driver);
			
			//Configuramos la conexion
			conexion = DriverManager.getConnection("jdbc:mysql://"+host+"/cajero?"+"user="+user+"&password="+passwd_cole);
			
			//Statement
			statement = conexion.createStatement();
			
		}catch(Exception e){
			System.out.println("Error al crear la conexion: "+ e.getLocalizedMessage());
		}
	}
	
	public void cerrarConexion(Connection conexion, Statement statement, ResultSet resultset) {
		try {
			if(conexion!=null) {
				conexion.close();
			}
			if(statement!=null) {
				statement.close();
			}
			if(resultset!=null) {
				resultset.close();
			}
		}catch(Exception e) {
			System.out.println("Error al cerrar: "+e.getLocalizedMessage());
		}
	}
	
	public void cerrarConexion(ResultSet resultSet, Connection connect, PreparedStatement ps) {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (connect != null) {
				connect.close();
			}
	    } catch (Exception e) {
	    	System.out.println("Error al cerrar las conexiones: "+e.getLocalizedMessage());
	    }
	}
	
	
	public  Connection getConexion() {
		return conexion;
	}

	public  void setConexion(Connection conexion) {
		this.conexion = conexion;
	}

	public  Statement getStatement() {
		return statement;
	}

	public  void setStatement(Statement statement) {
		this.statement = statement;
	}

	
}