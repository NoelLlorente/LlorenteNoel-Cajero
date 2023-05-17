package principal.vista.UsuarioCorriente;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * Es el marco donde se mostrará al usuario la operaciones que puede realizar ingresar, retirar, consultar, movimientos
 * @author Noel
 *
 */
public class MarcoOpUsrCorriente extends JPanel{
	private JButton[] botones;
	private JButton salir;
	private JDIngresarSaldo ingresar;
	private JDConsultarSaldo consultar;
	private JDHistorialMov movimientos;
	private JDRetirarSaldo retirar;
	public MarcoOpUsrCorriente() {
		JLabel texto = new JLabel("Seleccione una cuenta");
		Font font = new Font(texto.getFont().getName(), Font.PLAIN, 30);
		texto.setFont(font);
		JPanel text = new JPanel();
		text.add(texto);
		ingresar = new JDIngresarSaldo(this);
		consultar = new JDConsultarSaldo(this);
		movimientos = new JDHistorialMov(this);
		retirar = new JDRetirarSaldo(this);
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
	

	
	
	
	public JDRetirarSaldo getRetirar() {
		return retirar;
	}





	public void setRetirar(JDRetirarSaldo retirar) {
		this.retirar = retirar;
	}





	public JDHistorialMov getMovimientos() {
		return movimientos;
	}



	public void setMovimientos(JDHistorialMov movimientos) {
		this.movimientos = movimientos;
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


	public JDIngresarSaldo getIngresar() {
		return ingresar;
	}


	public void setIngresar(JDIngresarSaldo ingresar) {
		this.ingresar = ingresar;
	}


	public JDConsultarSaldo getConsultar() {
		return consultar;
	}


	public void setConsultar(JDConsultarSaldo consultar) {
		this.consultar = consultar;
	}
	
	
	
}
