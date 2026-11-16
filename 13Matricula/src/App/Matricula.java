package App;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Matricula extends JFrame{
	private JCheckBox chkBiblioteca;
	private JCheckBox chkGimnasio;
	private JCheckBox chkComedor;
	
		public Matricula() {
			setTitle("Servicios adicionales Matricula");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLayout(new GridLayout(4, 1, 5, 5));
			chkBiblioteca = new JCheckBox("Biblioteca",true);
			chkGimnasio = new JCheckBox("Gimnasio");
			chkComedor = new JCheckBox("Comedor");
			
			JButton btnMostrar = new JButton("Mostrar selección");
			add(chkBiblioteca);
			add(chkGimnasio);
			add(chkComedor);
			add(btnMostrar);
			
			btnMostrar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String selecion ="";
					if(chkBiblioteca.isSelected()) {
						selecion += " Biblioteca\n";
					}
					if(chkGimnasio.isSelected()) {
						selecion += " Gimnasio\n";
					}
					if(chkComedor.isSelected()) {
						selecion += " Comedor\n";
					}
					if(selecion.isEmpty()) {
						selecion += "No has seleccionado ningun servicio";
					}
					JOptionPane.showMessageDialog(Matricula.this, selecion,"Servicios seleccionados",JOptionPane.INFORMATION_MESSAGE);
					
				}
			});
			setSize(350, 250);
			setLocationRelativeTo(null);
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Matricula ventana= new Matricula();
		ventana.setVisible(true);
	}

}
