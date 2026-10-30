import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame ventana = new JFrame("Encuesta de clase");
		ventana.setSize(430, 300);
		ventana.setLayout(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNombre = new JLabel("Nombre : ");
		lblNombre.setBounds(25, 25, 80, 25);
		ventana.add(lblNombre);
		
		JTextField txtNombre = new JTextField();
		txtNombre.setBounds(110, 25, 200, 25);
		ventana.add(txtNombre);
		//creacion de los radio_button
		JRadioButton rbBien = new JRadioButton("Bien");
		JRadioButton rbRegular = new JRadioButton("Regular");
		JRadioButton rbMal = new JRadioButton("Mal");
		rbBien.setBounds(110, 70, 100, 25);
		rbRegular.setBounds(110, 100, 100, 25);
		rbMal.setBounds(110, 130, 100, 25);
		//Creamos un grupo
		ButtonGroup grupo = new ButtonGroup();
		//introducimos cada elemento en el grupo
		grupo.add(rbBien);
		grupo.add(rbRegular);
		grupo.add(rbMal);
		
		ventana.add(rbBien);
		ventana.add(rbRegular);
		ventana.add(rbMal);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(110, 170, 100, 30);
		ventana.add(btnEnviar);
		
		
		
		btnEnviar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String valoracion = rbBien.isSelected() ? "Bien" :
					rbRegular.isSelected() ? "Regular" :
						rbMal.isSelected() ? "Mal" : "";
				if(txtNombre.getText().trim().isEmpty() || valoracion.isEmpty()) {
					JOptionPane.showMessageDialog(ventana,"Escribe el nombre y elige una valoración" ,"Confirmación",JOptionPane.INFORMATION_MESSAGE);
					
				}else {
					JOptionPane.showMessageDialog(ventana,txtNombre.getText() + " ha valorado : " + valoracion ,"Confirmación",JOptionPane.INFORMATION_MESSAGE);
					
				}
				}
			
		});
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
		
		
	}

}
