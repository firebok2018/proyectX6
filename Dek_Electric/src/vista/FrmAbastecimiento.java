package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import mantenimiento.GestionAbastecimiento;
import mantenimiento.GestionCliente;
import mantenimiento.GestionDistrito;
import mantenimiento.GestionProducto;
import mantenimiento.GestionProveedor;
import model.Abastecimiento;
import model.Cliente;
import model.Distrito;
import model.Proveedor;

import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class FrmAbastecimiento extends JInternalFrame implements ActionListener, MouseListener {
	private JLabel lblAbastecimiento;
	private JPanel panel;
	private JLabel lblProveedor;
	private JLabel lblProducto;
	private JTextField txtProducto;
	private JButton btnBuscar;
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
	private JComboBox cboProveedor;
	private JLabel lblPrecio;
	private JTextField txtPrecio;
	private JTable tblAbastecimientos;
	private DefaultTableModel modelo;

	// Tipo de operación a procesar:
			// Adicionar, Modificar, Eliminar o Consultar
			private int tipoOperacion;
			// Constantes para los tipos de operaciones
			public final static int ADICIONAR = 0;
			public final static int MODIFICAR = 1;
			public final static int ELIMINAR = 2;
			public final static int CONSULTAR = 3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAbastecimiento frame = new FrmAbastecimiento();
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
	public FrmAbastecimiento() {
		setIconifiable(true);
		setClosable(true);
		setTitle("Abastecimiento");
		setBounds(100, 100, 691, 517);
		getContentPane().setLayout(null);
		
		lblAbastecimiento = new JLabel("Seleccione un acci\u00F3n");
		lblAbastecimiento.setOpaque(true);
		lblAbastecimiento.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbastecimiento.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAbastecimiento.setBackground(new Color(51, 153, 204));
		lblAbastecimiento.setBounds(10, 11, 654, 41);
		getContentPane().add(lblAbastecimiento);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 204)));
		panel.setBounds(10, 63, 654, 90);
		getContentPane().add(panel);
		
		lblProveedor = new JLabel("Proveedor");
		lblProveedor.setBounds(10, 23, 77, 14);
		panel.add(lblProveedor);
		
		lblProducto = new JLabel("Producto");
		lblProducto.setBounds(10, 51, 77, 14);
		panel.add(lblProducto);
		
		txtProducto = new JTextField();
		txtProducto.setEditable(false);
		txtProducto.setColumns(10);
		txtProducto.setBounds(97, 48, 210, 20);
		panel.add(txtProducto);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setEnabled(false);
		btnBuscar.setBounds(319, 47, 86, 23);
		panel.add(btnBuscar);
		
		cboProveedor = new JComboBox();
		cboProveedor.setBounds(97, 20, 210, 20);
		panel.add(cboProveedor);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(453, 51, 46, 14);
		panel.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(504, 48, 86, 20);
		panel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Registros", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 204)));
		panel_1.setBounds(10, 164, 654, 247);
		getContentPane().add(panel_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 28, 634, 208);
		panel_1.add(scrollPane);
		
		tblAbastecimientos = new JTable();
		tblAbastecimientos.addMouseListener(this);
		tblAbastecimientos.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblAbastecimientos);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Acciones", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 204)));
		panel_2.setBounds(10, 419, 654, 57);
		getContentPane().add(panel_2);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(10, 23, 89, 23);
		panel_2.add(btnAdicionar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(109, 23, 89, 23);
		panel_2.add(btnConsultar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(208, 23, 89, 23);
		panel_2.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(307, 23, 89, 23);
		panel_2.add(btnEliminar);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setEnabled(false);
		btnAceptar.setBounds(456, 23, 89, 23);
		panel_2.add(btnAceptar);
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(this);
		btnVolver.setEnabled(false);
		btnVolver.setBounds(555, 23, 89, 23);
		panel_2.add(btnVolver);
		
		separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(427, 23, 2, 23);
		panel_2.add(separator);
		
		modelo=new DefaultTableModel();
		modelo.addColumn("Codigo Proveedor");
		modelo.addColumn("Codigo Producto");
		modelo.addColumn("Precio Abastecimiento");	
		tblAbastecimientos.setModel(modelo);
		
		listarAbastecimiento();
		listarProveedores();
		

	}

	private void listarProveedores() {
		
		GestionProveedor gp= new GestionProveedor();
		ArrayList<Proveedor> Lista=new ArrayList<>();
		Lista=gp.listar();
		cboProveedor.addItem("Seleccione Proveedor");
		for(Proveedor p:Lista) {
			cboProveedor.addItem(p.getRso_prv());
		}	
	}

	private void listarAbastecimiento() {
		// TODO Auto-generated method stub
		GestionAbastecimiento ga= new GestionAbastecimiento();
		ArrayList<Abastecimiento> Lista=new ArrayList<>();
		Lista=ga.listar();
		modelo.setRowCount(0);
		for(Abastecimiento a:Lista) {
			Object[] obj= {a.getCod_prv(),a.getCod_pro(),a.getPre_aba()};
			modelo.addRow(obj);
		}		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
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
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		switch (tipoOperacion) {
		case ADICIONAR:
		adicionarAbastecimiento();
		break;
		case CONSULTAR:
		consultarAbastecimiento();
		break;
		case MODIFICAR:
		modificarAbastecimiento();
		break;
		case ELIMINAR:
		eliminarAbastecimiento();
		}
	}
	private void eliminarAbastecimiento() {
		
		//ENTRADA DE DATOS
		int a=leerProveedor();
		String prod_temp=leerProducto();
		
		
		//REGEX
		
		if(!prod_temp.matches("[1-9]+[0-9]*")){
			JOptionPane.showMessageDialog(this, "Codigo de Producto invalido");
			return;
		}
		int prod=Integer.parseInt(prod_temp);
		
		//CREAR GESTION PARA STORED PROCEDURE
		GestionAbastecimiento ga=new GestionAbastecimiento();
		int eliminado=ga.eliminar(a,prod);
		if(eliminado>0)
			JOptionPane.showMessageDialog(this, "Se eliminó correctamente");
		txtProducto.setText("");
		txtPrecio.setText("");
		txtProducto.requestFocus();
		listarAbastecimiento();
		
	}

	private void modificarAbastecimiento() {
		
		//ENTRADA DE DATOS
		int a=leerProveedor();
		String prod_temp=leerProducto();
		String precio_temp=leerPrecio();
				
		//REGEX PARA VALIDAR DATOS
		if(!prod_temp.matches("[1-9]+[0-9]*")){
			JOptionPane.showMessageDialog(this, "Codigo de Producto invalido");
			return;
		}
		if(!precio_temp.matches("[0-9]+.*[0-9]*")){
			JOptionPane.showMessageDialog(this, "Precio invalido");
			return;
		}
		
		int prod=Integer.parseInt(prod_temp);
		double precio=Double.parseDouble(precio_temp);
		//CREAR OBJETO
		Abastecimiento ab= new Abastecimiento();
		ab.setCod_pro(prod);
		ab.setCod_prv(a);
		ab.setPre_aba(precio);
		
		//CREAR GESTION PARA STORED PROCEDURE
		GestionAbastecimiento ga= new GestionAbastecimiento();
		int estado=ga.actualizar(ab);
		if(estado>0)
			JOptionPane.showMessageDialog(this, "Se actualizo correctamente");	
		//ACTUALIZAR JTABLE
		listarAbastecimiento();
		
	}

	private void consultarAbastecimiento() {
		// TODO Auto-generated method stub
	}

	private void adicionarAbastecimiento() {
		
		//ENTRADA DE DATOS
		int a=leerProveedor();
		String prod_temp=leerProducto();
		String precio_temp=leerPrecio();
		
		
		//REGEX PARA VALIDAR DATOS
		if(!prod_temp.matches("[1-9]+[0-9]*")){
			JOptionPane.showMessageDialog(this, "Codigo de Producto invalido");
			return;
		}
		if(!precio_temp.matches("[0-9]+.*[0-9]*")){
			JOptionPane.showMessageDialog(this, "Precio invalido");
			return;
		}
		
		int prod=Integer.parseInt(prod_temp);
		double precio=Double.parseDouble(precio_temp);
		//CREAR OBJETO
		Abastecimiento ab= new Abastecimiento();
		ab.setCod_pro(prod);
		ab.setCod_prv(a);
		ab.setPre_aba(precio);
		
		//CREAR GESTION PARA STORED PROCEDURE
		GestionAbastecimiento ga= new GestionAbastecimiento();
		int estado=ga.insertar(ab);
		if(estado>0)
			JOptionPane.showMessageDialog(this, "Se inserto correctamente");	
		//ACTUALIZAR JTABLE
		listarAbastecimiento();
		
	}

	private String leerPrecio() {
		
		return txtPrecio.getText();
	}

	private String leerProducto() {
		
		return txtProducto.getText().trim();
	}

	private int leerProveedor() {
		
		return cboProveedor.getSelectedIndex();
	}

	protected void actionPerformedBtnVolver(ActionEvent e) {
		
		txtPrecio.setText("");
		txtProducto.setText("");
		habilitarEntradas(false);
		habilitarBotones(true);
		lblAbastecimiento.setText("Seleccione una acción");
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
		txtPrecio.setEditable(b);
		txtProducto.setEditable(b);
	}

	protected void actionPerformedBtnAdicionar(ActionEvent e) {
		tipoOperacion = ADICIONAR;
		lblAbastecimiento.setText("Adicionando Abastecimiento");		
		habilitarEntradas(true);
		txtProducto.setText("");		
		txtPrecio.setText("");
		habilitarBotones(false);
		txtProducto.requestFocus();
		
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
		tipoOperacion = MODIFICAR;
		lblAbastecimiento.setText("Modificando Abastecimiento");	
		habilitarEntradas(true);
		habilitarBotones(false);
		txtPrecio.setEditable(true);
		txtProducto.requestFocus();
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		
		tipoOperacion = ELIMINAR;
		lblAbastecimiento.setText("Eliminando Cliente");
		txtProducto.setEditable(true);
		habilitarBotones(false);
		txtProducto.requestFocus();
	}
	protected void actionPerformedBtnConsultar(ActionEvent e) {
		
		txtProducto.setEditable(true);
		tipoOperacion = CONSULTAR;
		habilitarBotones(false);

	}
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		
		FrmConsultaProducto fp= new FrmConsultaProducto();
		FrmPrincipal.desktopPane.add(fp);
		Dimension desktopSize = FrmPrincipal.desktopPane.getSize();
		Dimension FrameSize = fp.getSize();
		fp.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
		fp.setVisible(true);

	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblAbastecimientos) {
			mouseClickedTblAbastecimientos(e);
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
	protected void mouseClickedTblAbastecimientos(MouseEvent e) {
		
		int fila=tblAbastecimientos.getSelectedRow();
		int prov=(int) modelo.getValueAt(fila, 0);
		int prod=(int) modelo.getValueAt(fila, 1);
		double pre=(double) modelo.getValueAt(fila, 2);
		txtProducto.setText(String.valueOf(prod));
		cboProveedor.setSelectedIndex(prov);
		txtPrecio.setText(String.valueOf(pre));
		
		
	}
}
