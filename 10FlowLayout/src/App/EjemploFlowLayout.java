package App;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class EjemploFlowLayout extends JFrame {

	public EjemploFlowLayout() {
	setTitle("Ejemplo FlowLayout");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	// setLayout(new FlowLayout(FlowLayout.CENTER,100,10));
	add(new JButton("Añadir"));
	add(new JButton("Modificar"));
	add(new JButton("Eliminar"));
	add(new JButton("Volver"));
	add(new JButton("Salir"));
	setSize(300,150);
	setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	EjemploFlowLayout ventana = new EjemploFlowLayout();
	ventana.setVisible(true);
	
		
	}

}
