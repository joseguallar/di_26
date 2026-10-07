import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaInicial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame ventana = new JFrame();
		// añadimos titulo a la ventana
		ventana.setTitle("Hola Mundo");
		//establecemos tamaño de la ventana
		ventana.setSize(420, 240);
		//indicamos que queremos hacer al pulsar X, en este caso cerrar el programa
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//se indica que la pantalla la visionamos en el centro de la pantalla
		ventana.setLocationRelativeTo(null);
		// establecemos una posición en la pantalla y un tamaño de ventana
		//ventana.setBounds(600, 400, 400, 200);
		// evitamos que la ventana se redimensione
		//ventana.setResizable(false);
		//tamaño de la pantalla maximizado
		//ventana.setExtendedState(Frame.MAXIMIZED_BOTH);
		ventana.setLayout(null);
		
		//crear una etiqueta 
		JLabel etiqueta = new JLabel("Hola mundo");
		JLabel etiqueta2 = new JLabel();
		//posicion y tamaño de la etiqueta
		etiqueta.setBounds(150, 10, 200, 30);
		//tipo de letra de la etiqueta
		etiqueta.setFont(new Font("Arial",Font.BOLD,16));
		//color de la letra
		etiqueta.setForeground(Color.BLUE);
		//centrar el texto de la etiqueta
	
		//ayuda
		etiqueta.setToolTipText("Esta es la etiqueta principal");
		//establecer texto a la etiqueta
		ventana.add(etiqueta);
		//segunda etiqueta
		etiqueta2.setText("Segunda etiqueta");
		etiqueta2.setBounds(150, 60, 200, 50);
		etiqueta2.setFont(new Font("Serif",Font.ITALIC,14));
		etiqueta2.setForeground(Color.RED);
		//ponemos la etiqueta en opaco para que se pueda ver el color de fondo
		etiqueta2.setOpaque(true);
		etiqueta2.setBackground(Color.YELLOW);
		etiqueta2.setHorizontalAlignment(JLabel.CENTER);
		ventana.add(etiqueta2);
		
				
		
		
		
		ventana.setVisible(true);
	}

}
