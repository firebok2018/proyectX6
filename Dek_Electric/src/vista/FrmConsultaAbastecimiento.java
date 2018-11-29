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
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import javax.swing.table.DefaultTableModel;

import mantenimiento.GestionAbastecimiento;
import mantenimiento.GestionConsultaAbastecimiento;
import mantenimiento.GestionCuentaBancaria;
import model.Abastecimiento;
import model.Consulta_Abastecimiento;
import model.CuentaBancaria;
import reporte.ReporteAbastecimientoNombreProducto;
import reporte.ReporteAbastecimientoRazonSocialProv;
import reporte.ReporteAbastecimientoRucProv;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmConsultaAbastecimiento extends JInternalFrame implements KeyListener, ActionListener {
	private JLabel lblConsultaDeAbastecimiento;
	private JPanel panel;
	private JTextField txtFiltro;
	private JComboBox cboCampo;
	private JLabel label_1;
	private JLabel label_2;
	private JPanel panel_1;
	private JScrollPane scrollPane;
	private JTable tblAbastecimientos;
	private DefaultTableModel modelo;
	private JButton btnReporte;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmConsultaAbastecimiento frame = new FrmConsultaAbastecimiento();
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
	public FrmConsultaAbastecimiento() {
		setIconifiable(true);
		setClosable(true);
		setTitle("Consulta abastecimiento");
		setBounds(100, 100, 692, 469);
		getContentPane().setLayout(null);
		
		lblConsultaDeAbastecimiento = new JLabel("Consulta de Abastecimiento");
		lblConsultaDeAbastecimiento.setOpaque(true);
		lblConsultaDeAbastecimiento.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaDeAbastecimiento.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConsultaDeAbastecimiento.setBackground(new Color(51, 153, 204));
		lblConsultaDeAbastecimiento.setBounds(10, 11, 654, 41);
		getContentPane().add(lblConsultaDeAbastecimiento);
		
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
		cboCampo.setModel(new DefaultComboBoxModel(new String[] {"Seleccione campo", "RUC Proveedor", "Ras\u00F3n social Proveedor", "Nombre de producto"}));
		cboCampo.setBounds(66, 23, 144, 20);
		panel.add(cboCampo);
		
		label_1 = new JLabel("Campo");
		label_1.setBounds(10, 26, 46, 14);
		panel.add(label_1);
		
		label_2 = new JLabel("Filtro");
		label_2.setBounds(240, 26, 46, 14);
		panel.add(label_2);
		
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
		
		tblAbastecimientos = new JTable();
		tblAbastecimientos.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblAbastecimientos);
		modelo = new DefaultTableModel();
		modelo.addColumn("RUC Proveedor");
		modelo.addColumn("Raz. Proveedor");
		modelo.addColumn("Des. Producto");
		modelo.addColumn("Pre. Abastecimientos");
		tblAbastecimientos.setModel(modelo);

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
		ArrayList<Consulta_Abastecimiento> lista=new ArrayList<>();
		GestionConsultaAbastecimiento ab = new GestionConsultaAbastecimiento();
		if (indice == 1) {
				lista=ab.listarRUC(filtro);
				modelo.setRowCount(0);
				for (Consulta_Abastecimiento cb : lista) {
					Object[] obj = {cb.getRuc_prv(),cb.getRso_prv(),cb.getDes_pro(),cb.getPre_aba()};
					modelo.addRow(obj);
			}
		}
			else if (indice == 2){
				lista=ab.listarRSO(filtro);
				modelo.setRowCount(0);
				for (Consulta_Abastecimiento cb : lista) {
					Object[] obj = {cb.getRuc_prv(),cb.getRso_prv(),cb.getDes_pro(),cb.getPre_aba()};
					modelo.addRow(obj);
			} 
			
		}
			else{
				lista=ab.listarNOM(filtro);
				modelo.setRowCount(0);
				for (Consulta_Abastecimiento cb : lista) {
					Object[] obj = {cb.getRuc_prv(),cb.getRso_prv(),cb.getDes_pro(),cb.getPre_aba()};
					modelo.addRow(obj);
			}
		}
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnReporte) {
			actionPerformedBtnReporte(arg0);
		}
	}
	protected void actionPerformedBtnReporte(ActionEvent arg0) {
		int indice=cboCampo.getSelectedIndex();
		switch (indice) {
		case 1:
			String ruc_prov = txtFiltro.getText();
			ReporteAbastecimientoRucProv.createReport("reps/rep_abastecimiento_por_ruc.jasper", ruc_prov);
			ReporteAbastecimientoRucProv.showViewer();
			break;
		case 2:
			String raz_soc_prov = txtFiltro.getText();
			ReporteAbastecimientoRazonSocialProv.createReport("reps/rep_abastecimiento_por_rso.jasper", raz_soc_prov);
			ReporteAbastecimientoRazonSocialProv.showViewer();
			break;
		case 3:
			String nom_prod = txtFiltro.getText();
			ReporteAbastecimientoNombreProducto.createReport("reps/rep_abastecimiento_por_producto.jasper", nom_prod);
			ReporteAbastecimientoNombreProducto.showViewer();
			break;

		default:
			
			break;
		}		
	}
}
