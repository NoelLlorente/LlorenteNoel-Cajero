package principal.vista;

import javax.swing.JOptionPane;

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
}
