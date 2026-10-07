import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class App {

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
		g.setColor(new Color (45,120,200));
		g.drawRoundRect(40, 35, 140, 71, 25, 25);
		g.fillRoundRect(210, 35, 140, 70, 25,25);
		
		g.setColor(new Color (220,90,60));
		g.drawArc(40, 145, 100, 100, 30, 260);
		g.fillArc(180, 145, 100, 100, 0, 120);
		
		int [] xLinea = {330,380,430,480};
		int [] yLinea = {225,170,235,180};
		g.setColor(Color.MAGENTA);
		g.drawPolyline(xLinea, yLinea, 4);
		
		Polygon triangulo = new Polygon(
				new int [] {75,145,11},
				new int [] {340,340,270},3);
		g.setColor(Color.ORANGE);
		g.fillPolygon(triangulo);
		g.setColor(Color.DARK_GRAY);
		g.drawPolygon(triangulo);
		
		Polygon flecha = new Polygon(
				new int [] {235,310,310,350,310,310,235},
				new int [] {300,300,275,335,395,370,370},7);
		g.setColor(new Color(80,170,100));
		g.fillPolygon(flecha);
		//g.clearRect(10, 100, 200, 200);
		}
		
		
		
		
		
	}
	
}
