package principal.modelo.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import principal.modelo.Conexion;
import principal.modelo.Consultas;
import principal.modelo.DTO.CajeroDTO;
import principal.modelo.DTO.CuentaDTO;
import principal.modelo.DTO.HistorialDTO;
import principal.modelo.DTO.TarjetaDTO;
import principal.modelo.DTO.UsuarioAdministrador;
import principal.modelo.DTO.UsuarioCorriente;
import principal.modelo.DTO.UsuarioDTO;
import principal.vista.Excepciones;
import principal.vista.UsuarioAdministrador.JDMarcoAdmUsuarios;

public class UsuarioDAO implements Consultas, Excepciones {
    private String clave = "admin";
    public ArrayList<UsuarioDTO> usuarios = new ArrayList<UsuarioDTO>();
    private PreparedStatement ps = null;
    private Statement sta = null;
    private ResultSet resultSet = null;
    private Conexion con = new Conexion();
    
    public UsuarioDAO() {
    }
    
    public UsuarioDAO(String usr) {
            try {
            	ps = con.getConexion().prepareStatement(CARGAR_USR);
            	ps.setString(1, usr);
                resultSet = ps.executeQuery();
              

                while (resultSet.next()) {
                    String dni = resultSet.getString("dni");
                    String nombre = resultSet.getString("nombre");
                    String apellidos = resultSet.getString("apellidos");
                    String fecha = resultSet.getDate("fecha_nac").toString();
                    String telf = resultSet.getString("telefono");
                    String direccion = resultSet.getString("direccion");

                    int tipo_usr = devolverTipoUsuario(dni);
                    UsuarioDTO usuario = null;
                    if (tipo_usr == 1) {
                        usuario = new UsuarioCorriente();
                    } else if (tipo_usr == 2) {
                        usuario = new UsuarioAdministrador();
                    }

                    usuario.setDni(dni);
                    usuario.setNombre(nombre);
                    usuario.setApellidos(apellidos);
                    usuario.setFecha_nacimiento(fecha);
                    usuario.setTelefono(telf);
                    usuario.setDireccion(direccion);

                    
                    TarjetaDTO tarjeta = obtenerTarjeta(dni);
                    usuario.setTarjeta(tarjeta);

            
                    usuarios.add(usuario);
                }
                CajeroDAO caj = new CajeroDAO();
                CajeroDTO cajero = caj.obtenerCajero();
            } catch (Exception e) {
                System.out.println("Error al cargar datos: " + e.getLocalizedMessage());
            }finally {
    			con.cerrarConexion(this.resultSet, this.con.getConexion(), this.ps);
    		}
    }


    public boolean validarUsuario(String usuario, String password) {
        try {
            this.ps = this.con.getConexion().prepareStatement(BUSCAR_PIN);
            this.ps.setString(1, usuario);
            this.resultSet = this.ps.executeQuery();
            if (resultSet.next()) {
                String pass = resultSet.getString(1);
                return pass.equals(password);
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error al validar usuario: " + e.getLocalizedMessage());
            return false;
        }
    }

    public int devolverTipoUsuario(String dni) {
        try {
            this.ps = this.con.getConexion().prepareStatement(TIPO_USR);
            this.ps.setString(1, dni);
            this.resultSet = this.ps.executeQuery();
            if (resultSet.next()) {
                int tipo = resultSet.getInt("tipo_usuario");
                return tipo;
            } else {
                return 0;
            }
        } catch (Exception e) {
            System.out.println("Error al identificar tipo usuario: " + e.getLocalizedMessage());
            return 0;
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

                ArrayList<CuentaDTO> cuentas = obtenerCuentas(tarjeta.getNum_tarjeta());
                tarjeta.setCuenta(cuentas);
            }
        

        } catch (Exception e) {
            System.out.println("Error al obtener tarjeta: " + e.getLocalizedMessage());
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

                // Cargar los datos del historial de cuenta
                String idCuenta = resultSet.getString("id");
                HistorialDAO historial = new HistorialDAO();
                ArrayList<HistorialDTO> historialCuenta = historial.obtenerHistorialCuenta(idCuenta);
                cuenta.setOperaciones(historialCuenta);

                cuentas.add(cuenta);
            }
        } catch (Exception e) {
            System.out.println("Error al obtener cuentas: " + e.getLocalizedMessage());
        }

        return cuentas;
    }

    
    
    public void cargarUsuarios(JDMarcoAdmUsuarios admUsr) {
    	String[] datos = new String[7];
    	
    	String codSQL = null;
    	
    	if(admUsr.getComboBuscar().getSelectedIndex()==0) {
    		codSQL = LISTAR_USUARIOS;
    	}else if(admUsr.getComboBuscar().getSelectedIndex()==1) {
    		codSQL = FILTRAR_USR_DNI+"'"+admUsr.getTxtBuscar().getText()+"'";
    	}else if(admUsr.getComboBuscar().getSelectedIndex()==2) {
    		codSQL = FILTRAR_USR_NOMBRE+"'"+admUsr.getTxtBuscar().getText()+"'";
    	}else if(admUsr.getComboBuscar().getSelectedIndex()==3) {
    		codSQL = FILTRAR_USR_APELLIDOS+"'"+admUsr.getTxtBuscar().getText()+"'";
    	}else if(admUsr.getComboBuscar().getSelectedIndex()==4) {
    		codSQL = FILTRAR_USR_FECHA+"'"+admUsr.getTxtBuscar().getText()+"'";
    	}else if(admUsr.getComboBuscar().getSelectedIndex()==5) {
    		codSQL =FILTRAR_USR_TELF+"'"+admUsr.getTxtBuscar().getText()+"'";
    	}else if(admUsr.getComboBuscar().getSelectedIndex()==6) {
    		codSQL = FILTRAR_USR_DIR+"'"+admUsr.getTxtBuscar().getText()+"'";
    	}else if(admUsr.getComboBuscar().getSelectedIndex()==7) {
    		codSQL = FILTRAR_USR_TIPO+"'"+admUsr.getTxtBuscar().getText()+"'";
    	}
    	
    	
    	try {
    		sta = con.getConexion().createStatement();
    		resultSet = sta.executeQuery(codSQL);
    		DefaultTableModel modelo = admUsr.getModelo();
    		modelo.setRowCount(0);
    		while(resultSet.next()) {
    			datos[0] = resultSet.getString(1);
    			datos[1] = resultSet.getString(2);
    			datos[2] = resultSet.getString(3);
    			datos[3] = resultSet.getString(4);
    			datos[4] = resultSet.getString(5);
    			datos[5] = resultSet.getString(6);
    			datos[6] = resultSet.getString(7);
    			
    			
    			
    			modelo.addRow(datos);
    		}
 
    		JTable tabla = admUsr.getTable();
    		tabla.setModel(modelo);
    		
    	}catch(Exception e) {	
    		JOptionPane.showMessageDialog(null, "Error, no se cargaron los datos a la tabla, contactar con administrador");
    		System.out.println("Error, no se cargaron los usuarios: "+e.getLocalizedMessage());
    	}
     }
    
   
    public void modificarUsuario(JDMarcoAdmUsuarios admUsr) {
    	int fila = admUsr.getTable().getSelectedRow();
    	
    	if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila para modificar.");
            return;
        }
    	if (admUsr.getTable().getCellEditor() != null) {
            admUsr.getTable().getCellEditor().stopCellEditing();
        }

    	
    	String dni = admUsr.getTable().getValueAt(fila, 0).toString();
    	String nombre = admUsr.getTable().getValueAt(fila, 1).toString();
    	String apellidos = admUsr.getTable().getValueAt(fila, 2).toString();
    	String fecha_nac = admUsr.getTable().getValueAt(fila, 3).toString();
    	String telf = admUsr.getTable().getValueAt(fila, 4).toString();
    	String direccion = admUsr.getTable().getValueAt(fila, 5).toString();
    	String tipo_usr = admUsr.getTable().getValueAt(fila, 6).toString();
    	
    	if(validarCamposUsuarios(dni, nombre, apellidos, fecha_nac, telf, direccion, tipo_usr)) {
    	
    	try {
    		ps = con.getConexion().prepareStatement(MODIFICAR_USR);
    		ps.setString(1, nombre);
    		ps.setString(2, apellidos);
    		ps.setString(3, fecha_nac);
    		ps.setString(4, telf);
    		ps.setString(5, direccion);
    		ps.setInt(6, Integer.parseInt(tipo_usr));
    		ps.setString(7, dni);
    		int rowsAffected = ps.executeUpdate();
    		
   		 if (rowsAffected > 0) {
	             JOptionPane.showMessageDialog(null, "¡Datos Actualizados Correctamente!");
	         } else {
	             JOptionPane.showMessageDialog(null, "Error, No se pudo actualizar");
	        }
   		 
   		cargarUsuarios(admUsr.getMarcoAdm().getAdmUsr());
   		admUsr.getModelo().fireTableDataChanged();
   		 
    	}catch(Exception e) {
    		JOptionPane.showMessageDialog(null, "Error al modificar los datos del usuario");
    		System.out.println("Error al modificar los datos del usuario"+e.getLocalizedMessage());
    	}
    	
    	}
    	
    }
    
    
    public void eliminarUsuario(JDMarcoAdmUsuarios admUsr) {
    	int fila = admUsr.getTable().getSelectedRow();
    	
    	if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar.");
            return;
        }
    	
    	
    	String dni = admUsr.getTable().getValueAt(fila, 0).toString();
 
    	
    	try {
    		ps = con.getConexion().prepareStatement(ELIMINAR_USR);
    		ps.setString(1, dni);
    		int rowsAffected = ps.executeUpdate();
    		
   		 if (rowsAffected > 0) {
	             JOptionPane.showMessageDialog(null, "¡Usuario Eliminado Correctamente!");
	         } else {
	             JOptionPane.showMessageDialog(null, "Error, No se pudo eliminar el usuario");
	        }
   		 
   		cargarUsuarios(admUsr.getMarcoAdm().getAdmUsr());
   		admUsr.getModelo().fireTableDataChanged();
    	}catch(Exception e) {
    		JOptionPane.showMessageDialog(null, "Error al eliminar el usuario, contactar con administrador");
    		System.out.println("Error al eliminar usuario"+e.getLocalizedMessage());
    	}
    	
    }
    
    
    public void crearUsuario(JDMarcoAdmUsuarios admUsr) {
        String dni = admUsr.getCrearUsr().getTxtDni().getText();
        String nombre = admUsr.getCrearUsr().getTxtNombre().getText();
        String apellidos = admUsr.getCrearUsr().getTxtApellidos().getText();
        String fecha = admUsr.getCrearUsr().getTxtFechaNac().getText();
        String telf = admUsr.getCrearUsr().getTxtTelf().getText();
        String direccion = admUsr.getCrearUsr().getTxtDirec().getText();
        String tipo = admUsr.getCrearUsr().getTxtTipo().getText();

        if (validarCamposUsuarios(dni, nombre, apellidos, fecha, telf, direccion, tipo)) {
            try {
                ps = con.getConexion().prepareStatement(INSERTAR_USR);
                ps.setString(1, dni);
                ps.setString(2, nombre);
                ps.setString(3, apellidos);
                ps.setString(4, fecha);
                ps.setString(5, telf);
                ps.setString(6, direccion);
                ps.setInt(7, Integer.parseInt(tipo));
                int rowsAffected = ps.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "¡Usuario creado correctamente!");
                } else {
                    JOptionPane.showMessageDialog(null, "Error, no se pudo crear el usuario");
                }

                admUsr.getCrearUsr().dispose();
                cargarUsuarios(admUsr.getMarcoAdm().getAdmUsr());
                admUsr.getModelo().fireTableDataChanged();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al crear el usuario, contacte un administrador");
                System.out.println("Error, no se pudo crear el usuario: " + e.getLocalizedMessage());
            }
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


