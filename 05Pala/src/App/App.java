package App;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;



public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
			JFrame  ventana = new JFrame("Pala");
			ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			PanelPala panel = new PanelPala();
			ventana.setContentPane(panel);
			ventana.setSize(700, 400);
			ventana.setLocationRelativeTo(null);
			ventana.setVisible(true);
			panel.requestFocusInWindow();
						}
			});
	}
}
	 class PanelPala extends JPanel implements ActionListener,KeyListener{

		private int xPala = 290;
		private static final int Y_PALA = 330;
		private static final int ANCHO = 110;
		private static final int ALTO = 15;
		private static final int VELOCIDAD = 6;
		private boolean izquierda = false;
		private boolean derecha = false;
		private Timer temporizador;
		public PanelPala() {
			setBackground(Color.BLACK);
			setFocusable(true);
			addKeyListener(this);
			
			temporizador = new Timer (20,this);
			temporizador.start();
			
		}
		
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent evento) {
			// TODO Auto-generated method stub
			if (evento.getKeyCode()== KeyEvent.VK_LEFT) {
				izquierda = true;
			}
			if (evento.getKeyCode()== KeyEvent.VK_RIGHT) {
				derecha = true;
			}
		}

		@Override
		public void keyReleased(KeyEvent evento) {
			// TODO Auto-generated method stub
			if (evento.getKeyCode()== KeyEvent.VK_LEFT) {
				izquierda = false;
			}
			if (evento.getKeyCode()== KeyEvent.VK_RIGHT) {
				derecha = false;
			}
		}

		@Override
		public void actionPerformed(ActionEvent evento) {
			// TODO Auto-generated method stub
			if (izquierda) {
				xPala -= VELOCIDAD;
			}
			if (derecha){
				xPala += VELOCIDAD;
			}
			if (xPala < 0) {
				xPala = 0;
			}
			if (xPala + ANCHO  > getWidth()) {
				xPala = getWidth()-ANCHO;
			}	
			repaint();
		}
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.GREEN);
			g.fillRect(xPala, Y_PALA, ANCHO, ALTO);
			
			
		}
	}