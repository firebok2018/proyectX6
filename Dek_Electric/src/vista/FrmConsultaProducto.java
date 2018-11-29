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
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import javax.swing.table.DefaultTableModel;

import mantenimiento.GestionConsultaOrdenCompra;
import mantenimiento.GestionCuentaBancaria;
import mantenimiento.GestionProducto;
import model.ConsultaOrdenCompra;
import model.CuentaBancaria;
import model.Producto;
import reporte.ReporteProductoCategoria;
import reporte.ReporteProductoCodigo;
import reporte.ReporteProductoNombre;

import java.awt.event.ItemListener;

public class FrmConsultaProducto extends JInternalFrame implements ActionListener, KeyListener, ItemListener {
	private JLabel lblConsultaDeProductos;
	private JPanel panel;
	private JTextField txtFiltro;
	private JComboBox cboCampo;
	private JLabel label_1;
	private JLabel label_2;
	private JPanel panel_1;
	private JScrollPane scrollPane;
	private JTable tblProductos;
	private JButton btnConsultar;
	private DefaultTableModel modelo;
	private JButton btnReporte;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmConsultaProducto frame = new FrmConsultaProducto();
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
	public FrmConsultaProducto() {
		setIconifiable(true);
		setClosable(true);
		setTitle("Consulta producto");
		setBounds(100, 100, 804, 472);
		getContentPane().setLayout(null);
		
		lblConsultaDeProductos = new JLabel("Consulta de Productos");
		lblConsultaDeProductos.setOpaque(true);
		lblConsultaDeProductos.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaDeProductos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConsultaDeProductos.setBackground(new Color(51, 153, 204));
		lblConsultaDeProductos.setBounds(10, 11, 768, 41);
		getContentPane().add(lblConsultaDeProductos);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 204)));
		panel.setBounds(10, 63, 768, 58);
		getContentPane().add(panel);
		
		txtFiltro = new JTextField();
		this.txtFiltro.addKeyListener(this);
		txtFiltro.setColumns(10);
		txtFiltro.setBounds(296, 23, 229, 20);
		panel.add(txtFiltro);
		
		cboCampo = new JComboBox();
		this.cboCampo.addItemListener(this);
		cboCampo.setModel(new DefaultComboBoxModel(new String[] {"Seleccione campo", "C\u00F3digo", "Nombre", "Categor\u00EDa"}));
		cboCampo.setBounds(66, 23, 144, 20);
		panel.add(cboCampo);
		
		label_1 = new JLabel("Campo");
		label_1.setBounds(10, 26, 46, 14);
		panel.add(label_1);
		
		label_2 = new JLabel("Filtro");
		label_2.setBounds(240, 26, 46, 14);
		panel.add(label_2);
		
		btnConsultar = new JButton("Consultar");
		this.btnConsultar.setEnabled(false);
		this.btnConsultar.addActionListener(this);
		btnConsultar.setBounds(535, 22, 109, 23);
		panel.add(btnConsultar);
		
		btnReporte = new JButton("Reporte");
		btnReporte.addActionListener(this);
		btnReporte.setBounds(656, 22, 89, 23);
		panel.add(btnReporte);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Registros", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 204)));
		panel_1.setBounds(10, 132, 768, 301);
		getContentPane().add(panel_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 28, 748, 262);
		panel_1.add(scrollPane);
		
		tblProductos = new JTable();
		tblProductos.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblProductos);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Cod. Producto");
		modelo.addColumn("Cod. Categoria");
		modelo.addColumn("Desc. Producto");
		modelo.addColumn("Cod. Marca");
		modelo.addColumn("Pre. Producto");
		modelo.addColumn("Stock Actual");
		modelo.addColumn("Stock Minimo");
		modelo.addColumn("Unidad de Medida");
		modelo.addColumn("Imp. Producto");
		modelo.addColumn("Est. Producto");
		tblProductos.setModel(modelo);

	}
	


	
	
	
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
		if (arg0.getSource() == this.txtFiltro) {
			keyReleasedTxtFiltro(arg0);
		}
	}
	public void keyTyped(KeyEvent arg0) {
	}
	protected void keyReleasedTxtFiltro(KeyEvent arg0) {
		int indice =  cboCampo.getSelectedIndex();
		String filtro = txtFiltro.getText();
		listarcuenta(indice,filtro);
	}

	private void listarcuenta(int indice, String filtro) {
		ArrayList<Producto> lista=new ArrayList<>();
		GestionProducto pr = new GestionProducto();
		if (indice == 2) {
			lista=pr.listarNOM(filtro);
			modelo.setRowCount(0);
			for (Producto cb : lista) {
				Object[] obj = {cb.getCod_pro(),cb.getCod_cat(),cb.getDes_pro(),cb.getCod_mar(),cb.getPre_pro(),cb.getSta_pro(),cb.getStm_pro(),cb.getUnm_pro(),cb.getImp_pro(),cb.getEst_pro()};
				modelo.addRow(obj);
			}
		}
			else{
				lista=pr.listarCAT(filtro);
				modelo.setRowCount(0);
				for (Producto cb : lista) {
					Object[] obj = {cb.getCod_pro(),cb.getCod_cat(),cb.getDes_pro(),cb.getCod_mar(),cb.getPre_pro(),cb.getSta_pro(),cb.getStm_pro(),cb.getUnm_pro(),cb.getImp_pro(),cb.getEst_pro()};
					modelo.addRow(obj);
			} 
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnReporte) {
			actionPerformedBtnReporte(arg0);
		}
		int cod = Integer.parseInt(txtFiltro.getText());
		ArrayList<Producto> lista=new ArrayList<>();
		GestionProducto gcb = new GestionProducto();

		lista=gcb.listarCOD(cod);
		modelo.setRowCount(0);
		for (Producto cb : lista) {
			Object[] obj = {cb.getCod_pro(),cb.getCod_cat(),cb.getDes_pro(),cb.getCod_mar(),cb.getPre_pro(),cb.getSta_pro(),cb.getStm_pro(),cb.getUnm_pro(),cb.getImp_pro(),cb.getEst_pro()};
			modelo.addRow(obj);
			
			tblProductos.setModel(modelo);
		}
		
		
	}
	public void itemStateChanged(ItemEvent arg0) {
		if (arg0.getSource() == this.cboCampo) {
			itemStateChangedCboCampo(arg0);
		}
	}
	protected void itemStateChangedCboCampo(ItemEvent arg0) {
		int indice = cboCampo.getSelectedIndex();
		if (indice == 1){
			btnConsultar.setEnabled(true);
		}
		else
			btnConsultar.setEnabled(false);
	}
	protected void actionPerformedBtnReporte(ActionEvent arg0) {
		int indice=cboCampo.getSelectedIndex();
		switch (indice) {
		case 1:
			int codigo = Integer.parseInt(txtFiltro.getText());
			ReporteProductoCodigo.createReport("reps/rep_producto_por_codigo.jasper",codigo);
			ReporteProductoCodigo.showViewer();
			break;
		case 2:
			String nombre = txtFiltro.getText();
			ReporteProductoNombre.createReport("reps/rep_consulta_producto_por_nombre.jasper",nombre);
			ReporteProductoNombre.showViewer();
			break;
		case 3:
			String categoria = txtFiltro.getText();
			ReporteProductoCategoria.createReport("reps/rep_consulta_producto_por_categoria.jasper",categoria);
			ReporteProductoCategoria.showViewer();
			break;

		default:
			
			break;
		}
	}
}
