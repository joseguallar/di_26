import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame ventana = new JFrame("Suma de 2 numeros");
		ventana.setSize(430, 270);
		ventana.setLayout(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JLabel lblNumero1 = new JLabel("Primer numero");
		lblNumero1.setBounds(25	,30,110,25);
		ventana.add(lblNumero1);
		
		JTextField txtNumero1 = new JTextField();
		txtNumero1.setBounds(145, 30, 180, 25);
		ventana.add(txtNumero1);
		
		JLabel lblNumero2 = new JLabel("Segundo numero");
		lblNumero2.setBounds(25	,70,110,25);
		ventana.add(lblNumero2);
		
		JTextField txtNumero2 = new JTextField();
		txtNumero2.setBounds(145, 70, 180, 25);
		ventana.add(txtNumero2);
		
		JLabel lblResultado = new JLabel("", SwingConstants.CENTER);
		lblResultado.setBounds(25,165,350,30);
		ventana.add(lblResultado);
		
		JButton btnSumar = new JButton("Sumar");
		btnSumar.setBounds(145,110,100,30);
		ventana.add(btnSumar);
		
		btnSumar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
				int numero1 = Integer.parseInt(txtNumero1.getText().trim());
				int numero2 = Integer.parseInt(txtNumero2.getText().trim());
				lblResultado.setText("Resultado: " + (numero1+ numero2));
				} catch (NumberFormatException ex) {
					lblResultado.setText("Introduce dos numeros enteros");
				}
				
			}
		});
	
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
					
	}

}
