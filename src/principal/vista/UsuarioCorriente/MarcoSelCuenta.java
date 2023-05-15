package principal.vista.UsuarioCorriente;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.DefaultListModel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class MarcoSelCuenta extends JPanel {
    private JList<String> listaCuentas;
    private JButton[] botones;
    private DefaultListModel<String> modeloLista;
    public MarcoSelCuenta() {
        JLabel texto = new JLabel("Seleccione una cuenta");
        Font font = new Font(texto.getFont().getName(), Font.PLAIN, 30);
        texto.setFont(font);
        JPanel jp = new JPanel();
        jp.add(texto);

        // Crear la lista de cuentas con un modelo por defecto
        modeloLista = new DefaultListModel<>();
        listaCuentas = new JList<>(modeloLista);
        listaCuentas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Crear el JScrollPane y agregar la lista de cuentas
        JScrollPane scp = new JScrollPane(listaCuentas);
        JPanel p1 = new JPanel();
        p1.add(scp);
        p1.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel p2 = new JPanel();
        String[] nombres = { "Operaciones", "Salir" };
        botones = new JButton[nombres.length];
        for (int i = 0; i < botones.length; i++) {
            botones[i] = new JButton(nombres[i]);
            p2.add(botones[i]);
        }
        p2.setLayout(new FlowLayout(FlowLayout.CENTER));

        this.add(jp);
        this.add(p1);
        this.add(p2);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    public JList<String> getListaCuentas() {
        return listaCuentas;
    }

    public void setListaCuentas(JList<String> listaCuentas) {
        this.listaCuentas = listaCuentas;
    }

    public JButton[] getBotones() {
        return botones;
    }

    public void setBotones(JButton[] botones) {
        this.botones = botones;
    }

	public DefaultListModel<String> getModeloLista() {
		return modeloLista;
	}

	public void setModeloLista(DefaultListModel<String> modeloLista) {
		this.modeloLista = modeloLista;
	}
    
    
}
