package principal.vista.UsuarioCorriente;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JPanel;
/** 
 * JDialog donde se mostrará el saldo disponible en la cuenta
 * @author Noel
 *
 */
public class JDConsultarSaldo extends JDialog{
	private JTextField saldoDisp;
	private JButton salir;
	private MarcoOpUsrCorriente marco;
	
	public JDConsultarSaldo(MarcoOpUsrCorriente marco) {
		this.setPreferredSize(new Dimension(200,200));
		this.marco = marco;
		saldoDisp = new JTextField();
		Font fuenteActual = saldoDisp.getFont();
		Font nuevaFuente = new Font(fuenteActual.getName(), fuenteActual.getStyle(), 30);
		saldoDisp.setFont(nuevaFuente);
		saldoDisp.setEditable(false);
		salir = new JButton("Salir");
		this.setTitle("Saldo Disponible");
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		jp1.add(saldoDisp);
		jp1.setLayout(new FlowLayout(FlowLayout.CENTER));
		jp2.add(salir);
		jp2.setLayout(new FlowLayout(FlowLayout.CENTER));
		 this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.add(jp1);
		this.add(jp2);
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		this.setLocationRelativeTo(null);
		this.pack();
	}


	public JTextField getSaldoDisp() {
		return saldoDisp;
	}


	public void setSaldoDisp(JTextField saldoDisp) {
		this.saldoDisp = saldoDisp;
	}


	public JButton getSalir() {
		return salir;
	}


	public void setSalir(JButton salir) {
		this.salir = salir;
	}


	public MarcoOpUsrCorriente getMarco() {
		return marco;
	}


	public void setMarco(MarcoOpUsrCorriente marco) {
		this.marco = marco;
	}
	
	
	
}
