package principal.vista;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MarcoOpUsrCorriente extends JPanel{
	private JButton[] botones;
	private JButton salir;
	public MarcoOpUsrCorriente() {
		JLabel texto = new JLabel("Seleccione una cuenta");
		Font font = new Font(texto.getFont().getName(), Font.PLAIN, 30);
		texto.setFont(font);
		JPanel text = new JPanel();
		text.add(texto);
		String[] nombres = {"Ingresar Saldo", "Retirar Saldo", "Consultar Saldo", "Movimientos"};
		botones = new JButton[nombres.length];
		salir = new JButton("Atrás");
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		jp2.add(salir);
		jp2.setLayout(new FlowLayout(FlowLayout.CENTER));
		for(int i=0; i<botones.length; i++) {
			botones[i]=new JButton(nombres[i]);
			jp1.add(botones[i]);
		}
		jp1.setLayout(new GridLayout(2,2));
		this.add(text);
		this.add(Box.createRigidArea(new Dimension(0, 60)));
		
		this.add(jp1);
		this.add(Box.createRigidArea(new Dimension(0, 40)));
		this.add(jp2);
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
	}
	

	public JButton[] getBotones() {
		return botones;
	}

	public void setBotones(JButton[] botones) {
		this.botones = botones;
	}

	public JButton getSalir() {
		return salir;
	}

	public void setSalir(JButton salir) {
		this.salir = salir;
	}
	
}
