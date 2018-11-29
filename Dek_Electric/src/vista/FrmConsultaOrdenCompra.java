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
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import javax.swing.table.DefaultTableModel;

import mantenimiento.GestionConsultaOrdenCompra;
import mantenimiento.GestionCuentaBancaria;
import model.ConsultaOrdenCompra;
import model.CuentaBancaria;
import reporte.ReporteOrdenCompraNombreProducto;
import reporte.ReporteOrdenCompraNumeroOrCom;
import reporte.ReporteOrdenCompraRazonSocialProv;
import reporte.ReporteOrdenCompraRucProv;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

public class FrmConsultaOrdenCompra extends JInternalFrame implements KeyListener, ItemListener, ActionListener {
	private JLabel lblConsultaDerdenes;
	private JPanel panel;
	private JTextField txtFiltro;
	private JComboBox cboCampo;
	private JLabel label_1;
	private JLabel label_2;
	private JButton btnConsultar;
	private JPanel panel_1;
	private JScrollPane scrollPane;
	private JTable tblOrdenesCompra;
	private DefaultTableModel modelo1;
	private DefaultTableModel modelo2;
	private DefaultTableModel modelo3;
	private JButton btnReporte;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmConsultaOrdenCompra frame = new FrmConsultaOrdenCompra();
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
	public FrmConsultaOrdenCompra() {
		setIconifiable(true);
		setClosable(true);
		setTitle("Consulta \u00F3rdenes de compra");
		setBounds(100, 100, 792, 469);
		getContentPane().setLayout(null);
		
		lblConsultaDerdenes = new JLabel("Consulta de \u00D3rdenes de Compra");
		lblConsultaDerdenes.setOpaque(true);
		lblConsultaDerdenes.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaDerdenes.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConsultaDerdenes.setBackground(new Color(51, 153, 204));
		lblConsultaDerdenes.setBounds(10, 11, 756, 41);
		getContentPane().add(lblConsultaDerdenes);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 204)));
		panel.setBounds(10, 63, 756, 58);
		getContentPane().add(panel);
		
		txtFiltro = new JTextField();
		this.txtFiltro.addKeyListener(this);
		txtFiltro.setColumns(10);
		txtFiltro.setBounds(296, 23, 229, 20);
		panel.add(txtFiltro);
		
		cboCampo = new JComboBox();
		this.cboCampo.addItemListener(this);
		cboCampo.setModel(new DefaultComboBoxModel(new String[] {"Seleccione campo", "N\u00FAmero orden de compra", "RUC Proveedor", "Ras\u00F3n social Proveedor", "Nombre de producto"}));
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
		panel_1.setBounds(10, 132, 756, 301);
		getContentPane().add(panel_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 28, 736, 262);
		panel_1.add(scrollPane);
		
		tblOrdenesCompra = new JTable();
		tblOrdenesCompra.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblOrdenesCompra);
		
		modelo1 = new DefaultTableModel();
		modelo1.addColumn("Num Orden Compra");
		modelo1.addColumn("Fecha Orden Compra");
		modelo1.addColumn("Ruc. Proveedor");
		modelo1.addColumn("Raz. Proveedor");
		
		
		modelo2 = new DefaultTableModel();
		modelo2.addColumn("Num Orden Compra");
		modelo2.addColumn("Fecha Orden Compra");
		modelo2.addColumn("Desc. Producto");
		modelo2.addColumn("Cant. Pedida");
	
		
		modelo3 = new DefaultTableModel();
		modelo3.addColumn("Num Orden Compra");
		modelo3.addColumn("Fecha Orden Compra");
		modelo3.addColumn("Cod. Proveedor");
		modelo3.addColumn("Cod. Transportista");
		modelo3.addColumn("Cod. Empleado");
		
		
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
		ArrayList<ConsultaOrdenCompra> lista=new ArrayList<>();
		GestionConsultaOrdenCompra gcb = new GestionConsultaOrdenCompra();
	
		if (indice ==2){
			tblOrdenesCompra.setModel(modelo1);
				lista=gcb.listarRUC(filtro);
				modelo1.setRowCount(0);
				for (ConsultaOrdenCompra cb : lista) {
					Object[] obj = {cb.getNum_oco(),cb.getFec_oco(),cb.getRuc_prv(),cb.getRso_prv()};
					modelo1.addRow(obj);
					
					
					
			} 
			
		}
			else if (indice ==3){
				tblOrdenesCompra.setModel(modelo1);
				lista=gcb.listarRSO(filtro);
				modelo1.setRowCount(0);
				for (ConsultaOrdenCompra cb : lista) {
					Object[] obj = {cb.getNum_oco(),cb.getFec_oco(),cb.getRuc_prv(),cb.getRso_prv()};
					modelo1.addRow(obj);	
					
				
			}
		}
			else
				tblOrdenesCompra.setModel(modelo2);
				lista=gcb.listarNOM(filtro);
			modelo2.setRowCount(0);
			for (ConsultaOrdenCompra cb : lista) {
				Object[] obj = {cb.getNum_oco(),cb.getFec_oco(),cb.getRuc_prv(),cb.getRso_prv()};
				modelo2.addRow(obj);
				
			
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
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnReporte) {
			actionPerformedBtnReporte(arg0);
		}
		if (arg0.getSource() == this.btnConsultar) {
			actionPerformedBtnConsultar(arg0);
		}
	}
	protected void actionPerformedBtnConsultar(ActionEvent arg0 ) {
		int num = Integer.parseInt(txtFiltro.getText());
		
		ArrayList<ConsultaOrdenCompra> lista=new ArrayList<>();
		GestionConsultaOrdenCompra gcb = new GestionConsultaOrdenCompra();
		 
			lista=gcb.listarNUM(num);
			modelo3.setRowCount(0);
			for (ConsultaOrdenCompra cb : lista) {
				Object[] obj = {cb.getNum_oco(),cb.getFec_oco(),cb.getRuc_prv(),cb.getRso_prv(),cb.getCod_emp()};
				modelo3.addRow(obj);
				
				tblOrdenesCompra.setModel(modelo3);
			}
		 
	}
	
	protected void actionPerformedBtnReporte(ActionEvent arg0) {
		int indice=cboCampo.getSelectedIndex();
		switch (indice) {
		case 1:
			int num_compra = Integer.parseInt(txtFiltro.getText());
			ReporteOrdenCompraNumeroOrCom.createReport("reps/rep_orden_compra_por_numero.jasper", num_compra);
			ReporteOrdenCompraNumeroOrCom.showViewer();
			break;
		case 2:
			String ruc_prov = txtFiltro.getText();
			ReporteOrdenCompraRucProv.createReport("reps/rep_orden_compra_por_ruc.jasper", ruc_prov);
			ReporteOrdenCompraRucProv.showViewer();
			break;
		case 3:
			String raz_soc_prov = txtFiltro.getText();
			ReporteOrdenCompraRazonSocialProv.createReport("reps/rep_orden_compra_por_rso.jasper", raz_soc_prov);
			ReporteOrdenCompraRazonSocialProv.showViewer();
			break;
		case 4:
			String nom_prod = txtFiltro.getText();
			ReporteOrdenCompraNombreProducto.createReport("reps/rep_orden_compra_por_producto.jasper", nom_prod);
			ReporteOrdenCompraNombreProducto.showViewer();
			break;

		default:
			
			break;
		}		
	}
}
