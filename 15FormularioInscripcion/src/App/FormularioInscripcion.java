package App;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FormularioInscripcion extends JFrame{
	private JTextField txtNombre;
	private JTextField txtCorreo;
	private JCheckBox chkAviso;
	
	
	
	public FormularioInscripcion() {
		setTitle("Formulario de inscripción");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel(new GridBagLayout());
		setContentPane(panel);
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5, 5, 5, 5);
		c.anchor = GridBagConstraints.WEST;
		
	//fila 0 columna 0
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0.0;
		c.fill = GridBagConstraints.NONE;
		panel.add(new JLabel("Nombre :"),c);
		
	//fila 0 columna 1
		txtNombre = new JTextField(20);
		c.gridx = 1;
		c.weightx= 1.0;
		panel.add(txtNombre,c);
	//fila 1 columna 0
		c.gridx = 0;
		c.gridy = 1;
		c.weightx = 0.0;
		c.fill = GridBagConstraints.NONE;
		panel.add(new JLabel("Correo :"),c);
	//fila 1 columna 1 	
		txtCorreo = new JTextField(20);
		c.gridx = 1;
		c.weightx= 1.0;
		panel.add(txtCorreo,c);
	//fila 2 columna 0
		c.gridx = 0;
		c.gridy = 2;
		c.weightx = 0.0;
		c.fill = GridBagConstraints.NONE;
		panel.add(new JLabel("Avisos :"),c);
		
	//fila 2 columna 1
		chkAviso = new JCheckBox("Recibir novedades");
		c.gridx =1;
		panel.add(chkAviso,c);
	//fila 3 
		JButton btnGuardar = new  JButton("Guardar");
		c.gridx=3;
		c.gridy=0;
		c.gridwidth =2;
		c.fill = GridBagConstraints.HORIZONTAL;
		panel.add(btnGuardar,c);
		
		btnGuardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String avisos;
				if (chkAviso.isSelected()) {
					avisos = "Si";
				}else {
					avisos = "No";
				}
				String mensaje = "Nombre: "+ txtNombre.getText()
				+ "\nCorreo: "+ txtCorreo.getText()
				+ "\nRecibir novedades: "+ avisos;
				JOptionPane.showMessageDialog(FormularioInscripcion.this,  mensaje);
				
			}
		});
		pack();
		setLocationRelativeTo(null);
			
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FormularioInscripcion().setVisible(true);
	}

}
