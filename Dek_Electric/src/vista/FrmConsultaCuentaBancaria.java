package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import mantenimiento.GestionCuentaBancaria;
import model.CuentaBancaria;
import reporte.ReporteCuentaBancariaRazonSocial;
import reporte.ReporteCuentaBancariaRuc;

import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmConsultaCuentaBancaria extends JInternalFrame implements KeyListener, ActionListener {
	private JLabel lblConsultaDeCuentas;
	private JPanel panel;
	private JTextField txtFiltro;
	private JComboBox cboCampo;
	private JLabel label_1;
	private JLabel lblFiltro;
	private JPanel panel_1;
	private JScrollPane scrollPane;
	private JTable tblCuentas;
	private DefaultTableModel modelo;
	private JButton btnReporte;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmConsultaCuentaBancaria frame = new FrmConsultaCuentaBancaria();
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
	public FrmConsultaCuentaBancaria() {
		setIconifiable(true);
		setClosable(true);
		setTitle("Consulta cuenta bancaria");
		setBounds(100, 100, 691, 472);
		getContentPane().setLayout(null);
		
		lblConsultaDeCuentas = new JLabel("Consulta de cuentas bancarias de proveedores");
		lblConsultaDeCuentas.setOpaque(true);
		lblConsultaDeCuentas.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaDeCuentas.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConsultaDeCuentas.setBackground(new Color(51, 153, 204));
		lblConsultaDeCuentas.setBounds(10, 11, 654, 41);
		getContentPane().add(lblConsultaDeCuentas);
		
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
		cboCampo.setModel(new DefaultComboBoxModel(new String[] {"Seleccione campo", "RUC", "Raz\u00F3n social"}));
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
		
		tblCuentas = new JTable();
		tblCuentas.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblCuentas);
		modelo = new DefaultTableModel();
		modelo.addColumn("Codigo");
		modelo.addColumn("Cod Proveedor");
		modelo.addColumn("Num Cuenta");
		modelo.addColumn("Cod Banco");
		modelo.addColumn("Tipo Cuenta");
		tblCuentas.setModel(modelo);

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
		// TODO Auto-generated method stub
		ArrayList<CuentaBancaria> lista=new ArrayList<>();
		GestionCuentaBancaria gcb = new GestionCuentaBancaria();
		if (indice == 1) {
			lista=gcb.listar1(filtro);
			modelo.setRowCount(0);
			for (CuentaBancaria cb : lista) {
				Object[] obj = {cb.getCod_cue(),cb.getCod_prv(),cb.getNro_cue(),cb.getBan_cue(),cb.getTip_cue()};
				modelo.addRow(obj);
			}
		}
			else{
				lista=gcb.listar2(filtro);
				modelo.setRowCount(0);
				for (CuentaBancaria cb : lista) {
					Object[] obj = {cb.getCod_cue(),cb.getCod_prv(),cb.getNro_cue(),cb.getBan_cue(),cb.getTip_cue()};
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
			ReporteCuentaBancariaRuc.createReport("reps/rep_cuenta_bancaria_por_ruc.jasper", ruc);
			ReporteCuentaBancariaRuc.showViewer();
			break;
		case 2:
			String raz_soc = txtFiltro.getText();
			ReporteCuentaBancariaRazonSocial.createReport("reps/rep_cuenta_bancaria_por_rsp.jasper", raz_soc);
			ReporteCuentaBancariaRazonSocial.showViewer();
			break;

		default:
			
			break;
		}
	}
}
