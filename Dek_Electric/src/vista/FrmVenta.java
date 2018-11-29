package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTable;

public class FrmVenta extends JInternalFrame {
	private JLabel label;
	private JPanel panel;
	private JLabel lblNmero;
	private JTextField txtNumero;
	private JLabel lblFecha;
	private JButton btnBuscarNumero;
	private JLabel lblCliente;
	private JTextField txtCliente;
	private JLabel lblEstado;
	private JLabel lblEmpledo;
	private JComboBox cboEmpleado;
	private JPanel panel_1;
	private JScrollPane scrollPane;
	private JPanel panel_2;
	private JButton btnAdicionar;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnAceptar;
	private JButton btnVolver;
	private JSeparator separator;
	private JDateChooser dtcFecha;
	private JButton btnBuscarCliente;
	private JComboBox cboEstado;
	private JPanel panel_3;
	private JLabel lblProducto;
	private JTextField txtProducto;
	private JLabel lblCantidad;
	private JButton btnBuscarProducto;
	private JTextField txtCantidad;
	private JButton btnAgregar;
	private JTable tblDetalleVenta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmVenta frame = new FrmVenta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmVenta() {
		setIconifiable(true);
		setClosable(true);
		setTitle("Venta");
		setBounds(100, 100, 853, 577);
		getContentPane().setLayout(null);
		
		label = new JLabel("Seleccione un acci\u00F3n");
		label.setOpaque(true);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBackground(new Color(51, 153, 204));
		label.setBounds(10, 11, 813, 41);
		getContentPane().add(label);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.GRAY);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 204)));
		panel.setBounds(10, 63, 813, 84);
		getContentPane().add(panel);
		
		lblNmero = new JLabel("N\u00FAmero");
		lblNmero.setBounds(10, 23, 46, 14);
		panel.add(lblNmero);
		
		txtNumero = new JTextField();
		txtNumero.setEditable(false);
		txtNumero.setColumns(10);
		txtNumero.setBounds(75, 20, 73, 20);
		panel.add(txtNumero);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(295, 23, 53, 14);
		panel.add(lblFecha);
		
		btnBuscarNumero = new JButton("Buscar");
		btnBuscarNumero.setEnabled(false);
		btnBuscarNumero.setBounds(158, 19, 30, 23);
		panel.add(btnBuscarNumero);
		
		lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(10, 51, 80, 14);
		panel.add(lblCliente);
		
		txtCliente = new JTextField();
		txtCliente.setEditable(false);
		txtCliente.setColumns(10);
		txtCliente.setBounds(75, 48, 154, 20);
		panel.add(txtCliente);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(548, 23, 53, 14);
		panel.add(lblEstado);
		
		lblEmpledo = new JLabel("Empledo");
		lblEmpledo.setBounds(295, 51, 80, 14);
		panel.add(lblEmpledo);
		
		cboEmpleado = new JComboBox();
		cboEmpleado.setBounds(358, 48, 169, 20);
		panel.add(cboEmpleado);
		
		dtcFecha = new JDateChooser();
		dtcFecha.setBounds(358, 20, 95, 20);
		panel.add(dtcFecha);
		
		btnBuscarCliente = new JButton("Buscar");
		btnBuscarCliente.setBounds(239, 47, 30, 23);
		panel.add(btnBuscarCliente);
		
		cboEstado = new JComboBox();
		cboEstado.setBounds(611, 20, 86, 20);
		panel.add(cboEstado);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Registros", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 204)));
		panel_1.setBounds(10, 226, 813, 247);
		getContentPane().add(panel_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 28, 793, 208);
		panel_1.add(scrollPane);
		
		tblDetalleVenta = new JTable();
		tblDetalleVenta.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblDetalleVenta);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Acciones", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 204)));
		panel_2.setBounds(10, 484, 813, 57);
		getContentPane().add(panel_2);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(10, 23, 89, 23);
		panel_2.add(btnAdicionar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(109, 23, 89, 23);
		panel_2.add(btnConsultar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(208, 23, 89, 23);
		panel_2.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(307, 23, 89, 23);
		panel_2.add(btnEliminar);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setEnabled(false);
		btnAceptar.setBounds(439, 23, 89, 23);
		panel_2.add(btnAceptar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setEnabled(false);
		btnVolver.setBounds(538, 23, 89, 23);
		panel_2.add(btnVolver);
		
		separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(427, 23, 2, 23);
		panel_2.add(separator);
		
		JButton btnGenerarComprobante = new JButton("Generar Comprobante ");
		btnGenerarComprobante.setBounds(637, 23, 166, 23);
		panel_2.add(btnGenerarComprobante);
		
		panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setForeground(Color.GRAY);
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Detalle", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 204)));
		panel_3.setBounds(10, 158, 813, 57);
		getContentPane().add(panel_3);
		
		lblProducto = new JLabel("Producto");
		lblProducto.setBounds(10, 23, 73, 14);
		panel_3.add(lblProducto);
		
		txtProducto = new JTextField();
		txtProducto.setEditable(false);
		txtProducto.setColumns(10);
		txtProducto.setBounds(93, 20, 214, 20);
		panel_3.add(txtProducto);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(357, 23, 53, 14);
		panel_3.add(lblCantidad);
		
		btnBuscarProducto = new JButton("Buscar");
		btnBuscarProducto.setEnabled(false);
		btnBuscarProducto.setBounds(317, 19, 30, 23);
		panel_3.add(btnBuscarProducto);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(420, 20, 86, 20);
		panel_3.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(540, 19, 89, 23);
		panel_3.add(btnAgregar);

	}
}
