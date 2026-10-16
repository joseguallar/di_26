package App;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class BolaHorizontal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
			JFrame  ventana = new JFrame("Pelotita horizontal");
			ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ventana.setContentPane(new PanelBola());
			ventana.setSize(700, 400);
			ventana.setLocationRelativeTo(null);
			ventana.setVisible(true);
						}
			});
	}
	private static class PanelBola extends JPanel implements ActionListener{
		private Timer temporizador;
		private int xBola = 0;
		private static final int  Y_BOLA = 100;
		private static final int TAMANO  = 25;
		
		public PanelBola() {
			setBackground(new Color(15,30,70));
			temporizador = new Timer(30,this);
			temporizador.start();
		}

		@Override
		public void actionPerformed(ActionEvent evento) {
			// TODO Auto-generated method stub
		xBola += 4;
		
		if (xBola > getWidth()) {
			xBola = 0;
			}
		repaint();
		}
		protected void paintComponent (Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.YELLOW);
			g.fillOval(xBola, Y_BOLA, TAMANO, TAMANO);
			
		}
		
	}
}
