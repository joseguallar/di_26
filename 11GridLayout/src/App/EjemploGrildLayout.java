package App;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class EjemploGrildLayout extends JFrame {
	public EjemploGrildLayout() {
		setTitle("Ejemplo GridLayout");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Creamos Layout con DOS filas y TRES columnas
		setLayout(new GridLayout(0, 1,10,10));
		add(new JButton("Uno"));
		add(new JButton("Dos"));
		add(new JButton("Tres"));
		add(new JButton("Cuatro"));
		add(new JButton("Cinco"));
		add(new JButton("Seis"));
		setSize(450, 250);
		setLocationRelativeTo(null);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EjemploGrildLayout ventana = new EjemploGrildLayout();
		ventana.setVisible(true);
	}

}
