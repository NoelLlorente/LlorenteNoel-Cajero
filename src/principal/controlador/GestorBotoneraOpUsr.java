package principal.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import principal.vista.Vista;

public class GestorBotoneraOpUsr implements ActionListener {
	private int acc;
	private Vista v;
	
	public GestorBotoneraOpUsr(int acc, Vista v) {
		this.acc = acc;
		this.v = v;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		switch(acc) {
			case 0:
				
		}

	}

}
