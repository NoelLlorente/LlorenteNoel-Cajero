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
}
