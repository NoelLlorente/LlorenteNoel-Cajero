package principal.controlador;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import principal.vista.MarcoOpUsrCorriente;
import principal.vista.MarcoSelCuenta;
import principal.vista.Vista;

public class GestorBtnsSelCuenta implements ActionListener {
	private int acc;
	private Vista vista;
	public GestorBtnsSelCuenta(int i, Vista vista) {
		this.acc = i;
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Component[] components = vista.getContentPane().getComponents();
		switch(acc) {
		case 0:
			if(!vista.getSelCuenta().getListaCuentas().isSelectionEmpty()) {
			vista.getSelCuenta().setVisible(false);
			
            for (Component component : components) {
                if (component instanceof MarcoOpUsrCorriente) {
                    vista.getContentPane().remove(component);
                    break;
                }
            }
			vista.getContentPane().add(vista.getOpUsrCorriente());
			vista.getOpUsrCorriente().setVisible(true);
			}else {
				JOptionPane.showMessageDialog(null, "Seleccione una cuenta");
			}
			break;
		case 1:
			vista.getSelCuenta().setVisible(false);
			vista.getUsrCorriente().setVisible(true);
			break;
		}

	}

}
