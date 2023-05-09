package principal.vista;

import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MarcoUsuarioCorriente extends JPanel{
	
	
	public MarcoUsuarioCorriente() {
		JLabel texto = new JLabel("Usuario Corriente");
		Font font = new Font(texto.getFont().getName(), Font.PLAIN, 30);
		texto.setFont(font);
		this.add(texto);
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
	}
}
