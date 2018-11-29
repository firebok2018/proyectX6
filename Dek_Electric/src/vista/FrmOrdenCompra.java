package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import mantenimiento.GestionDistrito;
import mantenimiento.GestionOrdenCompra;
import model.Abastecimiento;
import model.Distrito;
import model.OrdenCompra;

import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmOrdenCompra extends JInternalFrame implements MouseListener, ActionListener {
	private JLabel label;
	private JPanel panel;
	private JLabel label_1;
	private JTextField txtNumero;
	private JLabel label_2;
	private JButton button;
	private JLabel lblProveedor;
	private JLabel lblEmpleado;
	private JLabel lblTransportista;
	private JComboBox cboTransportista;
	private JDateChooser dtcFecha;
	private JComboBox cboEmpleado;
	private JPanel panel_1;
	private JLabel label_6;
	private JTextField txtProducto;
	private JLabel label_7;
	private JButton btnBuscar;
	private JTextField txtCantidad;
	private JButton btnAgregar;
	private JPanel panel_2;
	private JScrollPane scrollPane;
	private JPanel panel_3;
	private JButton btnAdicionar;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnAceptar;
	private JButton btnVolver;
	private JSeparator separator;
	private JComboBox cboProveedor;
	private JLabel lblPrecio;
	private JTextField txtPrecio;
	private JTable tblDetalleCompra;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmOrdenCompra frame = new FrmOrdenCompra();
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
	public FrmOrdenCompra() {
		setIconifiable(true);
		setClosable(true);
		setTitle("Orden de compra");
		setBounds(100, 100, 849, 579);
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
		
		label_1 = new JLabel("N\u00FAmero");
		label_1.setBounds(10, 23, 46, 14);
		panel.add(label_1);
		
		txtNumero = new JTextField();
		txtNumero.setEditable(false);
		txtNumero.setColumns(10);
		txtNumero.setBounds(75, 20, 73, 20);
		panel.add(txtNumero);
		
		label_2 = new JLabel("Fecha");
		label_2.setBounds(10, 51, 53, 14);
		panel.add(label_2);
		
		button = new JButton("Buscar");
		button.setEnabled(false);
		button.setBounds(158, 19, 30, 23);
		panel.add(button);
		
		lblProveedor = new JLabel("Proveedor");
		lblProveedor.setBounds(216, 23, 80, 14);
		panel.add(lblProveedor);
		
		lblEmpleado = new JLabel("Empleado");
		lblEmpleado.setBounds(522, 23, 53, 14);
		panel.add(lblEmpleado);
		
		lblTransportista = new JLabel("Transportista");
		lblTransportista.setBounds(216, 51, 80, 14);
		panel.add(lblTransportista);
		
		cboTransportista = new JComboBox();
		cboTransportista.setBounds(305, 48, 181, 20);
		panel.add(cboTransportista);
		
		dtcFecha = new JDateChooser();
		dtcFecha.setBounds(75, 48, 95, 20);
		panel.add(dtcFecha);
		
		cboEmpleado = new JComboBox();
		cboEmpleado.setBounds(592, 20, 123, 20);
		panel.add(cboEmpleado);
		
		cboProveedor = new JComboBox();
		cboProveedor.setBounds(306, 20, 180, 20);
		panel.add(cboProveedor);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setForeground(Color.GRAY);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Detalle", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 204)));
		panel_1.setBounds(10, 158, 813, 57);
		getContentPane().add(panel_1);
		
		label_6 = new JLabel("Producto");
		label_6.setBounds(10, 23, 46, 14);
		panel_1.add(label_6);
		
		txtProducto = new JTextField();
		txtProducto.setEditable(false);
		txtProducto.setColumns(10);
		txtProducto.setBounds(75, 20, 173, 20);
		panel_1.add(txtProducto);
		
		label_7 = new JLabel("Cantidad");
		label_7.setBounds(392, 23, 53, 14);
		panel_1.add(label_7);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setEnabled(false);
		btnBuscar.setBounds(258, 19, 86, 23);
		panel_1.add(btnBuscar);
		
		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(459, 20, 46, 20);
		panel_1.add(txtCantidad);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(714, 19, 89, 23);
		panel_1.add(btnAgregar);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(539, 23, 46, 14);
		panel_1.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(598, 20, 86, 20);
		panel_1.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Registros", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 204)));
		panel_2.setBounds(10, 226, 813, 247);
		getContentPane().add(panel_2);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 28, 793, 208);
		panel_2.add(scrollPane);
		
		tblDetalleCompra = new JTable();
		tblDetalleCompra.addMouseListener(this);
		tblDetalleCompra.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblDetalleCompra);
		
		panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Acciones", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 204)));
		panel_3.setBounds(10, 484, 813, 57);
		getContentPane().add(panel_3);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(10, 23, 89, 23);
		panel_3.add(btnAdicionar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(109, 23, 89, 23);
		panel_3.add(btnConsultar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(208, 23, 89, 23);
		panel_3.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(307, 23, 89, 23);
		panel_3.add(btnEliminar);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setEnabled(false);
		btnAceptar.setBounds(456, 23, 89, 23);
		panel_3.add(btnAceptar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setEnabled(false);
		btnVolver.setBounds(555, 23, 89, 23);
		panel_3.add(btnVolver);
		
		separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(427, 23, 2, 23);
		panel_3.add(separator);

		modelo=new DefaultTableModel();
		modelo.addColumn("Numero de Orden");
		modelo.addColumn("Fecha");
		modelo.addColumn("Codigo Proveedor");
		modelo.addColumn("Codigo Transportista");
		modelo.addColumn("Codigo Empleado");
		tblDetalleCompra.setModel(modelo);
		
		listarTable();
	}
	
	private void listarTable() {
		// TODO Auto-generated method stub
		GestionOrdenCompra g= new GestionOrdenCompra();
		ArrayList<OrdenCompra> Lista=new ArrayList<>();
		Lista=g.listar();
		modelo.setRowCount(0);
		for(OrdenCompra d:Lista) {
			Object[] obj= {d.getNum_oco(),d.getFec_oco(),d.getCod_prv(),d.getCod_tra(),d.getCod_emp() };
			modelo.addRow(obj);
		}	
	}
	private int tipoOperacion;
	// Constantes para los tipos de operaciones
	public final static int ADICIONAR = 0;
	public final static int MODIFICAR = 1;
	public final static int ELIMINAR = 2;
	public final static int CONSULTAR = 3;
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(e);
		}
		if (e.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(e);
		}
		if (e.getSource() == btnVolver) {
			actionPerformedBtnVolver(e);
		}
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
	}
	
	private void habilitarBotones(boolean sino) {
		// TODO Auto-generated method stub
		if (tipoOperacion != ADICIONAR)
			btnBuscar.setEnabled(!sino);
		btnAdicionar.setEnabled(sino);
		btnConsultar.setEnabled(sino);
		btnModificar.setEnabled(sino);
		btnEliminar.setEnabled(sino);
		if (tipoOperacion == CONSULTAR)
		btnAceptar.setEnabled(false);
		else
		btnAceptar.setEnabled(!sino);
		btnVolver.setEnabled(!sino);
	}
	
	private void habilitarEntradas(boolean b) {
		// TODO Auto-generated method stub
		txtCantidad.setEditable(b);
		txtNumero.setEditable(b);
		txtPrecio.setEditable(b);
		txtProducto.setEditable(b);
	}
	
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		
		switch (tipoOperacion) {
		case ADICIONAR:
		adicionar();
		break;
		case CONSULTAR:
		consultar();
		break;
		case MODIFICAR:
		modificar();
		break;
		case ELIMINAR:
		eliminar();
		}
	}
	private void eliminar() {
		
		String temp=txtNumero.getText();
		int cod=Integer.parseInt(temp);
		
		//REGEX
		
		//CREAR GESTION PARA STORED PROCEDURE
		GestionOrdenCompra ga=new GestionOrdenCompra();
		int estado=ga.eliminar(cod);
		if(estado>0)
			JOptionPane.showMessageDialog(this, "Se eliminó correctamente");
		listarTable();
	}

	private void modificar() {
		
		int prov=cboProveedor.getSelectedIndex();
		int emp=cboEmpleado.getSelectedIndex();
		int tran=cboTransportista.getSelectedIndex();
		String producto=txtProducto.getText();
		String temp=txtNumero.getText();
		String temp1=txtNumero.getText();
		int cod=Integer.parseInt(temp);
		double decim=Double.parseDouble(temp1);
		
		//REGEX PARA VALIDAR DATOS
		
		//CREAR OBJETO
		OrdenCompra ab= new OrdenCompra();
		ab.setCod_prv(prov);
		ab.setCod_emp(emp);
		ab.setCod_tra(tran);
		ab.setNum_oco(cod);
		
		//CREAR GESTION PARA STORED PROCEDURE
		GestionOrdenCompra ga= new GestionOrdenCompra();
		int estado=ga.actualizar(ab);
		if(estado>0)
			JOptionPane.showMessageDialog(this, "Se actualizo correctamente");	
		//ACTUALIZAR JTABLE
		listarTable();
		
	}

	private void consultar() {
		// TODO Auto-generated method stub
		
	}

	private void adicionar() {
		
		int prov=cboProveedor.getSelectedIndex();
		int emp=cboEmpleado.getSelectedIndex();
		int tran=cboTransportista.getSelectedIndex();
		String producto=txtProducto.getText();
		String temp=txtNumero.getText();
		String temp1=txtNumero.getText();
		int cod=Integer.parseInt(temp);
		double decim=Double.parseDouble(temp1);
		
		//REGEX PARA VALIDAR DATOS
		
		//CREAR OBJETO
		OrdenCompra ab= new OrdenCompra();
		ab.setCod_prv(prov);
		ab.setCod_emp(emp);
		ab.setCod_tra(tran);
		ab.setNum_oco(cod);
		
		//CREAR GESTION PARA STORED PROCEDURE
		GestionOrdenCompra ga= new GestionOrdenCompra();
		int estado=ga.insertar(ab);
		if(estado>0)
			JOptionPane.showMessageDialog(this, "Se inserto correctamente");	
		//ACTUALIZAR JTABLE
		listarTable();
		
	}

	protected void actionPerformedBtnVolver(ActionEvent e) {
		
		habilitarEntradas(false);
		habilitarBotones(true);
		label.setText("Seleccione una acción");
	}
	protected void actionPerformedBtnAdicionar(ActionEvent e) {
		
		tipoOperacion = ADICIONAR;
		label.setText("Adicionando");		
		habilitarEntradas(true);
		habilitarBotones(false);
		
	}
	protected void actionPerformedBtnConsultar(ActionEvent e) {
		
		tipoOperacion = CONSULTAR;
		label.setText("Consultando Producto");
		txtNumero.setEditable(true);
		habilitarBotones(false);
		txtNumero.requestFocus();
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
		
		tipoOperacion = ADICIONAR;
		label.setText("Adicionando");		
		habilitarEntradas(true);
		habilitarBotones(false);
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		
		tipoOperacion = ELIMINAR;
		label.setText("Eliminando");
		habilitarBotones(false);
		
	}
	

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblDetalleCompra) {
			mouseClickedTblDetalleCompra(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseClickedTblDetalleCompra(MouseEvent e) {
	}
}
