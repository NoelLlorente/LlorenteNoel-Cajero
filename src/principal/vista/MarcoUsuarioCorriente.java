package principal.vista;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MarcoUsuarioCorriente extends JPanel{
	private JLabel jl_numTarjeta;
	private JLabel jl_fechaCad;
	private JLabel jl_cvv;
	private JTextField txt_numTarjeta;
	private JTextField txt_fechaCad;
	private JTextField txt_cvv;
	private MarcoCambiarPin cmb_pin;
	private JButton operacion;
	private JButton cambiar_pin;
	
	
	public MarcoUsuarioCorriente() {
		JLabel texto = new JLabel("Datos Tarjeta");
		Font font = new Font(texto.getFont().getName(), Font.PLAIN, 30);
		texto.setFont(font);
		
		JPanel jp = new JPanel();
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		
		cmb_pin = new MarcoCambiarPin(this);
		jl_numTarjeta = new JLabel("Número Tarjeta:");
		jl_fechaCad = new JLabel("Fecha caducidad:");
		jl_cvv = new JLabel("CVV:");
		operacion = new JButton("Cuentas");
		cambiar_pin = new JButton("Cambiar Pin");
		txt_numTarjeta = new JTextField();
		txt_numTarjeta.setEditable(false);
		txt_fechaCad = new JTextField();
		txt_fechaCad.setEditable(false);
		txt_cvv = new JTextField();
		txt_cvv.setEditable(false);
		
		jp.add(texto);
		
		jp1.add(jl_numTarjeta);
		jp1.add(txt_numTarjeta);
		jp1.add(jl_fechaCad);
		jp1.add(txt_fechaCad);
		jp1.add(jl_cvv);
		jp1.add(txt_cvv);
	
		jp1.setLayout(new BoxLayout(jp1, BoxLayout.Y_AXIS));
	
		jp2.add(operacion);
		jp2.add(cambiar_pin);
		this.add(jp);
		this.add(Box.createRigidArea(new Dimension(0, 30)));
		this.add(jp1);
		this.add(Box.createRigidArea(new Dimension(0, 20)));
		this.add(Box.createRigidArea(new Dimension(0, 10)));
		this.add(jp2);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	
	}




	public MarcoCambiarPin getCmb_pin() {
		return cmb_pin;
	}


	public void setCmb_pin(MarcoCambiarPin cmb_pin) {
		this.cmb_pin = cmb_pin;
	}




	public JTextField getTxt_numTarjeta() {
		return txt_numTarjeta;
	}


	public JTextField getTxt_fechaCad() {
		return txt_fechaCad;
	}


	public JTextField getTxt_cvv() {
		return txt_cvv;
	}


	public JButton getOperacion() {
		return operacion;
	}


	public JButton getCambiar_pin() {
		return cambiar_pin;
	}




	public void setTxt_numTarjeta(JTextField txt_numTarjeta) {
		this.txt_numTarjeta = txt_numTarjeta;
	}


	public void setTxt_fechaCad(JTextField txt_fechaCad) {
		this.txt_fechaCad = txt_fechaCad;
	}


	public void setTxt_cvv(JTextField txt_cvv) {
		this.txt_cvv = txt_cvv;
	}


	public void setOperacion(JButton operacion) {
		this.operacion = operacion;
	}


	public void setCambiar_pin(JButton cambiar_pin) {
		this.cambiar_pin = cambiar_pin;
	}

	
	


}
