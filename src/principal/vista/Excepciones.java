package principal.vista;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

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

	    if (nombre.isEmpty() || !nombre.matches("[a-zA-Z]+")) {
	        JOptionPane.showMessageDialog(null, "Error, el nombre no puede estar vacío y solo puede contener letras");
	        return false;
	    }

	    if (apellidos.isEmpty() || !apellidos.matches("[a-zA-Z]+")) {
	        JOptionPane.showMessageDialog(null, "Error, los apellidos no pueden estar vacíos y solo pueden contener letras");
	        return false;
	    }

	    if (fecha.length() != 10 || !fecha.matches("\\d{4}/\\d{2}/\\d{2}")) {
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
	
	
}
