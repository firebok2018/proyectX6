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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import mantenimiento.GestionCuentaBancaria;
import mantenimiento.GestionProveedor;
import model.CuentaBancaria;
import model.Proveedor;
import reporte.ReporteProveedorMarca;
import reporte.ReporteProveedorRazonSocial;
import reporte.ReporteProveedorRuc;

import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmConsultaProveedor extends JInternalFrame implements KeyListener, ActionListener {
	private JLabel lblConsultaDeProveedores;
	private JPanel panel;
	private JTextField txtFiltro;
	private JComboBox cboCampo;
	private JLabel label_1;
	private JLabel lblFiltro;
	private JPanel panel_1;
	private JScrollPane scrollPane;
	private JTable tblProveedores;
	private DefaultTableModel modelo;
	private JButton btnReporte;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmConsultaProveedor frame = new FrmConsultaProveedor();
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
	public FrmConsultaProveedor() {
		setIconifiable(true);
		setClosable(true);
		setTitle("Consulta proveedor");
		setBounds(100, 100, 692, 480);
		getContentPane().setLayout(null);
		
		lblConsultaDeProveedores = new JLabel("Consulta de Proveedores");
		lblConsultaDeProveedores.setOpaque(true);
		lblConsultaDeProveedores.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaDeProveedores.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConsultaDeProveedores.setBackground(new Color(51, 153, 204));
		lblConsultaDeProveedores.setBounds(10, 11, 654, 41);
		getContentPane().add(lblConsultaDeProveedores);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 204)));
		panel.setBounds(10, 63, 654, 58);
		getContentPane().add(panel);
		
		txtFiltro = new JTextField();
		this.txtFiltro.addKeyListener(this);
		txtFiltro.setColumns(10);
		txtFiltro.setBounds(296, 23, 229, 20);
		panel.add(txtFiltro);
		
		cboCampo = new JComboBox();
		cboCampo.setModel(new DefaultComboBoxModel(new String[] {"Seleccione campo", "RUC", "Raz\u00F3n social", "Marca de producto"}));
		cboCampo.setBounds(66, 23, 144, 20);
		panel.add(cboCampo);
		
		label_1 = new JLabel("Campo");
		label_1.setBounds(10, 26, 46, 14);
		panel.add(label_1);
		
		lblFiltro = new JLabel("Filtro");
		lblFiltro.setBounds(240, 26, 46, 14);
		panel.add(lblFiltro);
		
		btnReporte = new JButton("Reporte");
		btnReporte.addActionListener(this);
		btnReporte.setBounds(535, 22, 89, 23);
		panel.add(btnReporte);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Registros", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 204)));
		panel_1.setBounds(10, 132, 654, 301);
		getContentPane().add(panel_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 28, 634, 262);
		panel_1.add(scrollPane);
		
		tblProveedores = new JTable();
		tblProveedores.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblProveedores);
		modelo = new DefaultTableModel();
		modelo.addColumn("Cod Proveedor");
		modelo.addColumn("Raz. Proveedor");
		modelo.addColumn("Ruc Proveedor");
		modelo.addColumn("Dir. Proveedor");
		modelo.addColumn("Telf. Proveedor");
		modelo.addColumn("Email Proveedor");
		modelo.addColumn("Rep. Proveedor");
		tblProveedores.setModel(modelo);

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
		ArrayList<Proveedor> lista=new ArrayList<>();
		GestionProveedor gp = new GestionProveedor();
		if (indice == 1) {
			lista=gp.listarRUC(filtro);
			modelo.setRowCount(0);
			for (Proveedor p : lista) {
				Object[] obj = {p.getCod_prv(),p.getRso_prv(),p.getRuc_prv(),p.getDir_prv(),p.getTel_prv(),p.getEma_prv(),p.getRep_prv()};
				modelo.addRow(obj);
			}
		}
			else if (indice == 2){
				lista=gp.listarRSO(filtro);
				modelo.setRowCount(0);
				for (Proveedor p : lista) {
					Object[] obj = {p.getCod_prv(),p.getRso_prv(),p.getRuc_prv(),p.getDir_prv(),p.getTel_prv(),p.getEma_prv(),p.getRep_prv()};
					modelo.addRow(obj);
			} 
				
		}
			else {
				lista=gp.listarMAR(filtro);
				modelo.setRowCount(0);
				for (Proveedor p : lista) {
					Object[] obj = {p.getCod_prv(),p.getRso_prv(),p.getRuc_prv(),p.getDir_prv(),p.getTel_prv(),p.getEma_prv(),p.getRep_prv()};
					modelo.addRow(obj);
			}
	}
}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnReporte) {
			actionPerformedBtnReporte(e);
		}
	}
	protected void actionPerformedBtnReporte(ActionEvent e) {
		int indice=cboCampo.getSelectedIndex();
		switch (indice) {
		case 1:
			String ruc = txtFiltro.getText();
			ReporteProveedorRuc.createReport("reps/rep_proveedor_por_ruc.jasper", ruc);
			ReporteProveedorRuc.showViewer();
			break;
		case 2:
			String raz_soc = txtFiltro.getText();
			ReporteProveedorRazonSocial.createReport("reps/rep_proveedor_por_razon_social.jasper", raz_soc);
			ReporteProveedorRazonSocial.showViewer();
			break;
		case 3:
			String marca = txtFiltro.getText();
			ReporteProveedorMarca.createReport("reps/rep_proveedores_por_marca.jasper", marca);
			ReporteProveedorMarca.showViewer();
			break;

		default:
			
			break;
		}
	}
}
