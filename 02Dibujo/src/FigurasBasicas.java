import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FigurasBasicas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame ventana = new JFrame ("Figuaras");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setContentPane(new Lienzo());
		ventana.setSize(650, 420);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
		
	}
private static class Lienzo extends JPanel {
	public Lienzo() {
		setBackground(Color.WHITE);
		
	}
	protected void paintComponent (Graphics g) {
	
		super.paintComponent(g);
		g.setColor(new Color(31,103,163));
		g.drawLine(45, 55, 300, 55);
		g.drawRect(45, 90, 150, 80);
		g.fillRect(230, 90, 150, 80);
		
		g.setColor(new Color (220,80,55));
		g.drawOval(45, 210, 110, 110);
		g.fillOval(220, 210, 110, 110);
		
		g.setColor(Color.BLACK);
		g.setFont(new Font ("SansSerif", Font.BOLD,18));
		g.drawString("Dibujo", 405, 135);
		
			
			
		}
		
		
		
		
		
	}
	
}
