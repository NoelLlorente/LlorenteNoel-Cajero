package principal.vista;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import principal.vista.UsuarioAdministrador.JDCrearCuenta;
import principal.vista.UsuarioAdministrador.JDCrearTarjeta;
import principal.vista.UsuarioAdministrador.JDCrearUsuario;


public interface Excepciones {
	/**
	 * Interfaz en la cuál se crean métodos para válidar los datos de la aplicación
	 * @author Noel
	 *
	 */
	
	
	/**
	 * Validar que el login no esté vacio
	 * @param usr es el dni de usuario
	 * @param passwd es el pin de la tarjeta
	 * @return true o false
	 */
	public default boolean loginVacio(String usr, String passwd) {
		if(usr.isEmpty()||passwd.isEmpty()) {
			JOptionPane.showMessageDialog(null, "¡Verifique que los campos no estén vacios!");
			return true;
		}
		return false;
	}
	
	/**
	 * Validar que la longitud del nuevo pin es válida
	 * @param pin es el nuevo pin
	 * @return true o false
	 */
	public default boolean longitudNewPin(String pin) {
		if(pin.length()<3 || pin.length()>6) {
			JOptionPane.showMessageDialog(null, "El pin no puede ser inferior a 3 caracteres o mayor a 6 caracteres");
			return true;
		}
		return false;
	}
	
	/**
	 * Valida que el saldo se un número y que no este vacio
	 * @param saldo es el saldo
	 * @return true o false
	 */

	public default boolean validarSaldo(double saldo) {
		if(saldo<0) {
			JOptionPane.showMessageDialog(null,"Error, verifique que ha introducido una cantidad valida, o que el campo este no este vacio");
			return true;
		}
		return false;
	}
	
	/**
	 * Valida que el saldo en tipo String no este vacio
	 * @param saldo es el saldo
	 * @return true o false
	 */
	public default boolean validarStringSaldo(String saldo) {
		if(saldo.isEmpty()) {
			JOptionPane.showMessageDialog(null,"Error, rellene los campos");
			return true;
		}
		
		 try {
		        double tipoNumero = Double.parseDouble(saldo);
		    } catch (NumberFormatException e) {
		        JOptionPane.showMessageDialog(null, "Error, el saldo debe ser un número");
		        return true;
		    }
		
		return false;
	}
	
	/**
	 * Validar los campos para crear o modificar usuarios
	 * @param dni es el dni del usuario
	 * @param nombre es el nombre
	 * @param apellidos los apellidos
	 * @param fecha la fecha de nacimientos
	 * @param telf el teléfono
	 * @param direccion la dirección
	 * @param tipo el tipo de usuario, usuario corriente o administrador
	 * @return true o false
	 */
	public default boolean validarCamposUsuarios(String dni, String nombre, String apellidos, String fecha, String telf, String direccion, String tipo) {
		if (dni.length() < 8 || dni.length() > 9) {
	        JOptionPane.showMessageDialog(null, "El DNI introducido no cumple con las longitudes del sistema o está vacío");
	        return false;
	    }

	    if (!dni.matches("[a-zA-Z0-9]+")) {
	        JOptionPane.showMessageDialog(null, "Error, el DNI no puede contener caracteres especiales");
	        return false;
	    }

	    if (nombre.isEmpty() || !nombre.matches("[a-zA-Z\\s]+")) {
	        JOptionPane.showMessageDialog(null, "Error, el nombre no puede estar vacío y solo puede contener letras");
	        return false;
	    }

	    if (apellidos.isEmpty() || !apellidos.matches("[a-zA-Z\\s]+")) {
	        JOptionPane.showMessageDialog(null, "Error, los apellidos no pueden estar vacíos y solo pueden contener letras");
	        return false;
	    }

	    if (fecha.length() != 10 || (!fecha.matches("\\d{4}/\\d{2}/\\d{2}") && !fecha.matches("\\d{4}-\\d{2}-\\d{2}"))) {
	        JOptionPane.showMessageDialog(null, "Error, la fecha es inválida o no cumple con el formato yyyy/mm/dd");
	        return false;
	    }

	    if (telf.length() != 9 || !telf.matches("\\d{9}")) {
	        JOptionPane.showMessageDialog(null, "Error, el teléfono es inválido o no contiene 9 dígitos");
	        return false;
	    }

	    if (!direccion.matches("[a-zA-Z0-9\\s]+")) {
	        JOptionPane.showMessageDialog(null, "Error, la dirección contiene caracteres inválidos");
	        return false;
	    }

	    try {
	        int tipoNumero = Integer.parseInt(tipo);
	        if (tipoNumero != 1 && tipoNumero != 2) {
	            JOptionPane.showMessageDialog(null, "Error, el tipo de usuario solo puede ser 1 (Corriente) o 2 (Admin)");
	            return false;
	        }
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(null, "Error, el tipo de usuario debe ser un número");
	        return false;
	    }
	    
	return true;
	}
	
	/**
	 * Validar campos vacios a la hora de crear o modificar usuarios
	 * @param crearUsuarioDialog es el JDialog JDCrearUsuario
	 * @return true o false
	 */
	public default boolean validarCamposVacios(JDCrearUsuario crearUsuarioDialog) {
	    String dni = crearUsuarioDialog.getTxtDni().getText();
	    String nombre = crearUsuarioDialog.getTxtNombre().getText();
	    String apellidos = crearUsuarioDialog.getTxtApellidos().getText();
	    String fecha = crearUsuarioDialog.getTxtFechaNac().getText();
	    String telf = crearUsuarioDialog.getTxtTelf().getText();
	    String direccion = crearUsuarioDialog.getTxtDirec().getText();
	    String tipo = crearUsuarioDialog.getTxtTipo().getText();

	    return !dni.isEmpty() && !nombre.isEmpty() && !apellidos.isEmpty() &&
	            !fecha.isEmpty() && !telf.isEmpty() && !direccion.isEmpty() && !tipo.isEmpty();
	}
	
	/**
	 * Validar que no haya campos vacios a la hora de crear o modificar tarjetas
	 * @param crearTarjeta es el JDialog JDCrearTarjeta
	 * @return true o false
	 */
	public default boolean validarCamposVaciosTarjeta(JDCrearTarjeta crearTarjeta) {
	    String id = crearTarjeta.getTxtid().getText();
	    String pin = crearTarjeta.getTxtpin().getText();
	    String cvv = crearTarjeta.getTxtcvv().getText();
	    String fecha = crearTarjeta.getTxtfechaCad().getText();
	    String dni = crearTarjeta.getTxtdni_usr().getText();
	  

	    return !id.isEmpty() && !pin.isEmpty() && !cvv.isEmpty() &&
	            !fecha.isEmpty() && !dni.isEmpty();
	}
	
	
/**
 * Validar que no haya campos vacios a la hora de crear cuentas o modificarlas
 * @param crearCuenta es el JDialog JDCrearCuenta
 * @return true o false
 */
	public default boolean validarCamposVaciosCuenta(JDCrearCuenta crearCuenta) {
	    String id = crearCuenta.getTxtid().getText();
	    String nombre = crearCuenta.getTxtnombre().getText();
	    String saldo = crearCuenta.getTxtsaldo().getText();
	    String id_tarjeta = crearCuenta.getTxtid_tarjeta().getText();
	    
	  

	    return !id.isEmpty() && !nombre.isEmpty() && !saldo.isEmpty() &&
	            !id_tarjeta.isEmpty(); 
	}
	
	
	/**
	 * Validar campos a la hora de crear o modificar tarjetas
	 * @param id numero de tarjeta
	 * @param pin es el pin o el password
	 * @param cvv es el código de verificación de datos de la tarjeta
	 * @param fecha fecha de caducidad
	 * @param dni es el dni del usuario propietario
	 * @param validadoUsr es un booleano que devuelve true si el dni del usuario existe
	 * @param validarTarjetaUsr es un booleano que devuelve true si el dni esta vinculado con una tarjeta
	 * @return true o false
	 */
	public default boolean validarCamposTarjetas(String id, String pin, String cvv, String fecha, String dni, boolean validadoUsr, boolean validarTarjetaUsr) {
		
		 if(id.length()<6||id.length()>17 ||id.isEmpty()) {
		    	JOptionPane.showMessageDialog(null, "Error, el id no cumple con la longitud del sistema, o esta vacio");
		    	return false;
		    }
		if (!id.matches("[0-9]+")) {
		        JOptionPane.showMessageDialog(null, "Error, el numero de tarjeta (ID) es inválido");
		        return false;
		    }
		    
		if(pin.length()<3 || pin.length()>6) {
				JOptionPane.showMessageDialog(null, "El pin no puede ser inferior a 3 caracteres o mayor a 6 caracteres");
				return false;
			}
	    
		if(!pin.matches("[0-9]+")) {
					JOptionPane.showMessageDialog(null, "El pin es invalido, solo puede contener numeros");
					return false;
				}
		

		 if(cvv.length()<3||cvv.length()>3||cvv.isEmpty()) {
			   JOptionPane.showMessageDialog(null, "Error, el cvv no cumple con la longitud del sistema, o esta vacio");
			   return false;
		   }
		   
		   if(!cvv.matches("[0-9]+")) {
			   JOptionPane.showMessageDialog(null, "Error, el cvv es invalido");
			   return false;
		   }
		   

	    if (fecha.length() != 10 || (!fecha.matches("\\d{4}/\\d{2}/\\d{2}") && !fecha.matches("\\d{4}-\\d{2}-\\d{2}"))) {
	        JOptionPane.showMessageDialog(null, "Error, la fecha es inválida o no cumple con el formato yyyy/mm/dd");
	        return false;
	    }

	   
	   if (dni.length() < 8 || dni.length() > 9) {
	        JOptionPane.showMessageDialog(null, "El DNI introducido no cumple con las longitudes del sistema o está vacío");
	        return false;
	    }

	    if (!dni.matches("[a-zA-Z0-9]+")) {
	        JOptionPane.showMessageDialog(null, "Error, el DNI no puede contener caracteres especiales");
	        return false;
	    }
	    
	  if(!validadoUsr) {
		  JOptionPane.showMessageDialog(null, "Error, ese dni no existe");
		  return false;
	  }
	   
	  
	  if(!validarTarjetaUsr) {
		  JOptionPane.showMessageDialog(null, "Error, no puedes asociar mas de una tarjeta a un usuario");
		  return false;
	  }
	return true;
	}
	
	
	
	/**
	 * Validar campos a la hora de crear o modificar tarjetas
	 * @param id numero de tarjeta
	 * @param pin es el pin o el password
	 * @param cvv es el código de verificación de datos de la tarjeta
	 * @param fecha fecha de caducidad
	 * @param dni es el dni del usuario propietario
	 * @param validadoUsr es un booleano que devuelve true si el dni del usuario existe
	 * @param espinCif es un booleano que devuelve true si el pin esta cifrado
	 * @param validarTarjetaUsr es un booleano que devuelve true si el dni esta vinculado con una tarjeta
	 * @return true o false
	 */
	public default boolean validarCamposTarjetas(String id, String pin, String cvv, String fecha, String dni, boolean validadoUsr, boolean espinCif, boolean validarTarjetaUsr) {
		
		 if(id.length()<6||id.length()>17 ||id.isEmpty()) {
		    	JOptionPane.showMessageDialog(null, "Error, el id no cumple con la longitud del sistema, o esta vacio");
		    	return false;
		    }
		if (!id.matches("[0-9]+")) {
		        JOptionPane.showMessageDialog(null, "Error, el numero de tarjeta (ID) es inválido");
		        return false;
		    }
		    
		if(!espinCif) {
			if(pin.length()<3 || pin.length()>6) {
				JOptionPane.showMessageDialog(null, "El pin no puede ser inferior a 3 caracteres o mayor a 6 caracteres");
				return false;
			}
			if(!pin.matches("[0-9]+")) {
				JOptionPane.showMessageDialog(null, "El pin es invalido, solo puede contener numeros");
				return false;
			}
		}
		
		

		 if(cvv.length()<3||cvv.length()>3||cvv.isEmpty()) {
			   JOptionPane.showMessageDialog(null, "Error, el cvv no cumple con la longitud del sistema, o esta vacio");
			   return false;
		   }
		   
		   if(!cvv.matches("[0-9]+")) {
			   JOptionPane.showMessageDialog(null, "Error, el cvv es invalido");
			   return false;
		   }
		   

	    if (fecha.length() != 10 || (!fecha.matches("\\d{4}/\\d{2}/\\d{2}") && !fecha.matches("\\d{4}-\\d{2}-\\d{2}"))) {
	        JOptionPane.showMessageDialog(null, "Error, la fecha es inválida o no cumple con el formato yyyy/mm/dd");
	        return false;
	    }

	   
	   if (dni.length() < 8 || dni.length() > 9) {
	        JOptionPane.showMessageDialog(null, "El DNI introducido no cumple con las longitudes del sistema o está vacío");
	        return false;
	    }

	    if (!dni.matches("[a-zA-Z0-9]+")) {
	        JOptionPane.showMessageDialog(null, "Error, el DNI no puede contener caracteres especiales");
	        return false;
	    }
	    
	  if(!validadoUsr) {
		  JOptionPane.showMessageDialog(null, "Error, ese dni no existe");
		  return false;
	  }
	  

	  if(!validarTarjetaUsr) {
		  JOptionPane.showMessageDialog(null, "Error, no puedes asociar mas de una tarjeta a un usuario");
		  return false;
	  }
	   
	return true;
	}
	
	/**
	 * Validar el saldo del cajero
	 * @param saldo es el nuevo saldo
	 * @return true o false
	 */
	public default boolean validarSaldoCajero(String saldo) {
		   try {
		        double tipoNumero = Double.parseDouble(saldo);
		        if (tipoNumero==0) {
		            JOptionPane.showMessageDialog(null, "Error, el saldo no puede estar vacio");
		            return false;
		        }
		      
		    } catch (NumberFormatException e) {
		        JOptionPane.showMessageDialog(null, "Error, el tipo de usuario debe ser un número");
		        return false;
		    }
		   return true;
	}
	
	
	/**
	 * Validar los campos a la hora de crear o modificar cuentas
	 * @param id es el número de cuenta
	 * @param nombre es el nombre de la cuenta
	 * @param saldo es el saldo disponible
	 * @param id_tarjeta es el número de la tarjeta propietaria
	 * @param validadoIdTarjeta es un booleano que devuelve true si la tarjeta existe
	 * @return true o false
	 */
	public default boolean validarCamposCuenta(String id, String nombre, String saldo, String id_tarjeta, boolean validadoIdTarjeta) {
		
		 if(id.length()<7||id.length()>21 ||id.isEmpty()) {
		    	JOptionPane.showMessageDialog(null, "Error, el id no cumple con la longitud del sistema, o esta vacio");
		    	return false;
		    }
		 
		if (!id.matches("[0-9]+")) {
		        JOptionPane.showMessageDialog(null, "Error, el numero de cuenta (ID) es inválido");
		        return false;
		    }
		
		
		if (nombre.isEmpty() || !nombre.matches("[a-zA-Z\\s]+")) {
	        JOptionPane.showMessageDialog(null, "Error, el nombre no puede estar vacío y solo puede contener letras");
	        return false;
	    }		 
		
		 try {
		        double tipoNumero = Double.parseDouble(saldo);
		        if (tipoNumero==0) {
		            JOptionPane.showMessageDialog(null, "Error, el saldo no puede estar vacio");
		            return false;
		        }
		    } catch (NumberFormatException e) {
		        JOptionPane.showMessageDialog(null, "Error, el saldo debe ser un número");
		        return false;
		    }
	
	  if(!validadoIdTarjeta) {
		  JOptionPane.showMessageDialog(null, "Error, ese ID Tarjeta no existe");
		  return false;
	  }
	   
	return true;
	}
	
}
