package App;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.net.URL;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/** Ventana principal de la tienda de informática con cálculo dinámico de extras. */
public final class Antonio extends JFrame {

  private static final int PRECIO_RATON_CENTIMOS = 1990;
  private static final int PRECIO_ENVOLTORIO_CENTIMOS = 200;
  private static final int ANCHO_IMAGEN_PRODUCTO = 70;
  private static final int ALTO_IMAGEN_PRODUCTO = 50;
  private static final int TAMANO_ICONO_BOTON = 20;
  private static final int SEPARACION_ICONO_TEXTO = 8;
  private static final int MARGEN_COMPONENTE = 10;
  private static final Locale LOCALE_ESPANA = Locale.forLanguageTag("es-ES");

  private final JCheckBox chkEnvoltorio;
  private final JLabel lblTotal;

  public Antonio() {
    setTitle("Tienda de informática");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    chkEnvoltorio = new JCheckBox("Envoltorio de regalo (+2,00 €)");
    lblTotal = new JLabel(formatearPrecio(PRECIO_RATON_CENTIMOS));

    setContentPane(crearPanelPrincipal());
    configurarEventos();

    pack();
    setLocationRelativeTo(null);
  }

  private JPanel crearPanelPrincipal() {
    JPanel panel = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets =
        new Insets(MARGEN_COMPONENTE, MARGEN_COMPONENTE, MARGEN_COMPONENTE, MARGEN_COMPONENTE);

    agregarImagenProducto(panel, gbc);
    agregarDetallesProducto(panel, gbc);
    agregarSeccionTotal(panel, gbc);
    agregarBotonCompra(panel, gbc);

    return panel;
  }

  private void agregarImagenProducto(JPanel panel, GridBagConstraints gbc) {
    ImageIcon iconoRaton =
        cargarIconoEscalado("/raton.png", ANCHO_IMAGEN_PRODUCTO, ALTO_IMAGEN_PRODUCTO);
    JLabel lblImagen = new JLabel(iconoRaton);
    lblImagen.setToolTipText("Ratón inalámbrico");

    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridheight = 3;
    gbc.anchor = GridBagConstraints.CENTER;
    gbc.fill = GridBagConstraints.NONE;
    panel.add(lblImagen, gbc);
  }

  private void agregarDetallesProducto(JPanel panel, GridBagConstraints gbc) {
    JLabel lblNombre = new JLabel("Ratón inalámbrico");
    gbc.gridx = 1;
    gbc.gridy = 0;
    gbc.gridheight = 1;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    panel.add(lblNombre, gbc);

    JLabel lblPrecio = new JLabel("Precio = " + formatearPrecio(PRECIO_RATON_CENTIMOS));
    gbc.gridy = 1;
    panel.add(lblPrecio, gbc);

    gbc.gridy = 2;
    panel.add(chkEnvoltorio, gbc);
  }

  private void agregarSeccionTotal(JPanel panel, GridBagConstraints gbc) {
    gbc.gridx = 0;
    gbc.gridy = 3;
    gbc.weightx = 0.0;
    gbc.fill = GridBagConstraints.NONE;
    panel.add(new JLabel("Total:"), gbc);

    gbc.gridx = 1;
    gbc.weightx = 1.0;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    panel.add(lblTotal, gbc);
  }

  private void agregarBotonCompra(JPanel panel, GridBagConstraints gbc) {
    ImageIcon iconoCarrito =
        cargarIconoEscalado("/carrito.png", TAMANO_ICONO_BOTON, TAMANO_ICONO_BOTON);
    JButton btnComprar = new JButton("Comprar", iconoCarrito);
    btnComprar.setHorizontalTextPosition(SwingConstants.RIGHT);
    btnComprar.setVerticalTextPosition(SwingConstants.CENTER);
    btnComprar.setIconTextGap(SEPARACION_ICONO_TEXTO);

    gbc.gridx = 0;
    gbc.gridy = 4;
    gbc.gridwidth = 2;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    panel.add(btnComprar, gbc);

    btnComprar.addActionListener(e -> mostrarResumenPedido());
  }

  private void configurarEventos() {
    chkEnvoltorio.addItemListener(e -> actualizarTotal());
  }

  private void actualizarTotal() {
    lblTotal.setText(formatearPrecio(calcularTotalCentimos()));
  }

  private void mostrarResumenPedido() {
    String textoEnvoltorio = chkEnvoltorio.isSelected() ? "Sí" : "No";
    String mensaje =
        String.format(
            "Producto: Ratón Inalámbrico%nEnvoltorio: %s%nTotal: %s",
            textoEnvoltorio, formatearPrecio(calcularTotalCentimos()));

    JOptionPane.showMessageDialog(
        this, mensaje, "Resumen del pedido", JOptionPane.INFORMATION_MESSAGE);
  }

  private int calcularTotalCentimos() {
    int total = PRECIO_RATON_CENTIMOS;
    if (chkEnvoltorio.isSelected()) {
      total += PRECIO_ENVOLTORIO_CENTIMOS;
    }
    return total;
  }

  private String formatearPrecio(int centimos) {
    return String.format(LOCALE_ESPANA, "%.2f €", centimos / 100.0);
  }

  private ImageIcon cargarIconoEscalado(String rutaRecurso, int ancho, int alto) {
    URL url = getClass().getResource(rutaRecurso);
    if (url == null) {
      System.err.println("No se encontró el recurso de imagen: " + rutaRecurso);
      return new ImageIcon();
    }
    Image imagenOriginal = new ImageIcon(url).getImage();
    Image imagenEscalada = imagenOriginal.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
    return new ImageIcon(imagenEscalada);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> new Antonio().setVisible(true));
  }
}
