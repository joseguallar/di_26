import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame frame = new JFrame("Etiqueta con Botón");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 200);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		
		JLabel etiqueta = new JLabel("Presiona el botón");
		etiqueta.setBounds(50, 20, 300, 30);
		etiqueta.setFont(new Font("SansSerif",Font.BOLD,18));
		etiqueta.setForeground(Color.MAGENTA);
		etiqueta.setHorizontalAlignment(JLabel.CENTER);
		etiqueta.setToolTipText("Etiqueta para cambiar el texto");
		etiqueta.setOpaque(true);
		etiqueta.setBackground(Color.LIGHT_GRAY);
		frame.add(etiqueta);
		
		JButton boton = new JButton("Haz click");
		boton.setBounds(150, 70, 100, 30);
		boton.setToolTipText("Botón para cambiar el texto");
		boton.setFont(new Font("SansSerif",Font.BOLD,14));
		frame.add(boton);
		
		boton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				etiqueta.setText("!Texto actualizado!");
				etiqueta.setOpaque(true);
				etiqueta.setForeground(Color.RED);
				//desactivamos el boton
				boton.setEnabled(false);
			}
		});
				
		frame.setVisible(true);
	}

}
