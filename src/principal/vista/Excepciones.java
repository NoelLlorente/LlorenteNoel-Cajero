package principal.vista;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import principal.vista.UsuarioAdministrador.JDCrearTarjeta;
import principal.vista.UsuarioAdministrador.JDCrearUsuario;

public interface Excepciones {
	public default boolean loginVacio(String usr, String passwd) {
		if(usr.isEmpty()||passwd.isEmpty()) {
			JOptionPane.showMessageDialog(null, "¡Verifique que los campos no estén vacios!");
			return true;
		}
		return false;
	}
	
	public default boolean longitudNewPin(String pin) {
		if(pin.length()<3 || pin.length()>6) {
			JOptionPane.showMessageDialog(null, "El pin no puede ser inferior a 3 caracteres o mayor a 6 caracteres");
			return true;
		}
		return false;
	}

	public default boolean validarSaldo(double saldo) {
		if(saldo<=0) {
			JOptionPane.showMessageDialog(null,"Error, verifique que ha introducido una cantidad valida, o que el campo este no este vacio");
			return true;
		}
		return false;
	}
	
	
	public default boolean validarStringSaldo(String saldo) {
		if(saldo.isEmpty()) {
			JOptionPane.showMessageDialog(null,"Error, rellene los campos");
			return true;
		}
		return false;
	}
	
	
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
	
	public default boolean validarCamposVaciosTarjeta(JDCrearTarjeta crearTarjeta) {
	    String id = crearTarjeta.getTxtid().getText();
	    String pin = crearTarjeta.getTxtpin().getText();
	    String cvv = crearTarjeta.getTxtcvv().getText();
	    String fecha = crearTarjeta.getTxtfechaCad().getText();
	    String dni = crearTarjeta.getTxtdni_usr().getText();
	  

	    return !id.isEmpty() && !pin.isEmpty() && !cvv.isEmpty() &&
	            !fecha.isEmpty() && !dni.isEmpty();
	}
	
	
	
	public default boolean validarCamposTarjetas(String id, String pin, String cvv, String fecha, String dni, boolean validadoUsr) {
		
		 if(id.length()<6||id.length()>17 ||id.isEmpty()) {
		    	JOptionPane.showMessageDialog(null, "Error, el id no cumple con la longitud del sistema, o esta vacio");
		    	return false;
		    }
		if (!id.matches("[0-9]+")) {
		        JOptionPane.showMessageDialog(null, "Error, el numero de cuenta (ID) es inválido");
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
	   
	return true;
	}
	
	
	public default boolean validarSaldoCajero(String saldo) {
		   try {
		        double tipoNumero = Double.parseDouble(saldo);
		        if (tipoNumero==0) {
		            JOptionPane.showMessageDialog(null, "Error, el saldo no puede estar vacio");
		            return false;
		        }
		        if (tipoNumero>10000) {
		            JOptionPane.showMessageDialog(null, "Error, el cajero solo soporta 10.000€");
		            return false;
		        }
		    } catch (NumberFormatException e) {
		        JOptionPane.showMessageDialog(null, "Error, el tipo de usuario debe ser un número");
		        return false;
		    }
		   return true;
	}
	
}
