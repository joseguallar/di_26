package Border;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EjemploBorderLayout extends JFrame {
	public EjemploBorderLayout() {
		setTitle("Ejemplo BorderLayout");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel botones = new JPanel(new FlowLayout());
		botones.add(new JButton("Añadir"));
		botones.add(new JButton("Eliminar"));
		//Separación horizontal y vertial
		setLayout(new BorderLayout(10,10));
		add(botones,BorderLayout.NORTH);
		add(new JButton("Abajo"),BorderLayout.SOUTH);
		add(new JButton("Izquierda"),BorderLayout.WEST);
		add(new JButton("Derecha"),BorderLayout.EAST);
		add(new JButton("Centro"),BorderLayout.CENTER);
		setSize(500,300);
		setLocationRelativeTo(null);
		
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EjemploBorderLayout ventana = new EjemploBorderLayout();
		ventana.setVisible(true);
	}

}
