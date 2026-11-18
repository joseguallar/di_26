package App;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TiendaImagenes extends JFrame{
	private JCheckBox chkEnvoltorio;
	private JLabel lblTotal;
	
	private static final int PRECIO_RATON = 1990;
	private static final int PRECIO_ENVOLTORIO = 200;
	
	public TiendaImagenes() {
		
		setTitle("Tienda de informatica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel(new GridBagLayout());
		setContentPane(panel);
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(10, 10, 10, 10);
		
		//cargar las imagenes
		ImageIcon imagenRaton1 = new ImageIcon(getClass().getResource("/raton.png"));		
		Image imagenRatonEscalada = imagenRaton1.getImage().getScaledInstance(70, 50, Image.SCALE_SMOOTH);
		ImageIcon imagenRaton = new ImageIcon(imagenRatonEscalada);
		
		ImageIcon iconoCarrito = new ImageIcon(getClass().getResource("/carrito.png"));
		
		//ImageIcon imagenCarrito1 = new ImageIcon(getClass().getResource("/carrito.png"));
		//Image imagenCarritoEscalada = imagenCarrito1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		//ImageIcon imagenCarrito = new ImageIcon("imagenCarritoEscalada");
		//imagen en etiqueta
		JLabel lblImagen = new JLabel(imagenRaton);
		lblImagen.setToolTipText("Ratón inalambrico");
		c.gridx=0;
		c.gridy=0;
		c.gridheight = 3;
		c.anchor = GridBagConstraints.CENTER;
		panel.add(lblImagen,c);
		
		//nombre
		JLabel lblNombre = new JLabel("Ratón inalambrico");
		c.gridx =1;
		c.gridy = 0;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor= GridBagConstraints.CENTER;
		panel.add(lblNombre,c);
		
		//precio
		JLabel lblPrecio = new JLabel("Precio = 19,90 €");
		c.gridy=1;
		panel.add(lblPrecio,c);
		
		//envoltorio
		chkEnvoltorio = new JCheckBox("Envoltorio de regalo ( +2,00 € ");
		c.gridy=2;
		panel.add(chkEnvoltorio);
		
		//etiqueta con el total
		c.gridx = 0;
		c.gridy = 3;
		c.weightx = 0.0;
		c.fill = GridBagConstraints.NONE;
		panel.add(new JLabel("Total: "),c);
		
		//Importe
		lblTotal = new JLabel(formatearPrecio(PRECIO_RATON));
		c.gridx = 1;
		c.weightx = 1.0;
		c.fill = GridBagConstraints.HORIZONTAL;
		panel.add(lblPrecio,c);
		
		//boton con icono y texto
		
		JButton btnComprar = new JButton("Comprar",iconoCarrito);
		btnComprar.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnComprar.setVerticalTextPosition(SwingConstants.CENTER);
		btnComprar.setIconTextGap(8);
		c.gridx=0;
		c.gridy=4;
		c.gridwidth=2;
		c.fill = GridBagConstraints.HORIZONTAL;
		panel.add(btnComprar,c);
		
		chkEnvoltorio.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				lblTotal.setText(formatearPrecio(calcularTotal()));
			}
		});
		
		btnComprar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String envoltorio = "No";
				if (chkEnvoltorio.isSelected()){ 
					envoltorio="Si";
				}
				JOptionPane.showMessageDialog(TiendaImagenes.this,"Producto: Raton Inalámbrico "
						+ "\nEnvoltorio: " + envoltorio
								+ "\nTotal:  " + formatearPrecio(calcularTotal()),
								"Resumen del pedido", JOptionPane.INFORMATION_MESSAGE);
			}
		});		
		pack();
		setLocationRelativeTo(null);
	}

	private int calcularTotal() {
		int total = PRECIO_RATON;
		if (chkEnvoltorio.isSelected()){
			total += PRECIO_ENVOLTORIO;
		}
		return total;
	}
	
	private String formatearPrecio (int centimos) {
	
		//String resultado = String.format ("%2f%n", centimos/100.0);
		return String.format(new Locale("es","ES "), "%.2f €",centimos /100.0);
		
	}
		public static void main(String[] args) {
		// TODO Auto-generated method stub
			new TiendaImagenes().setVisible(true);
			

	}

}
