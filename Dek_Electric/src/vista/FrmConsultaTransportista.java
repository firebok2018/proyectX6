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
import javax.swing.table.DefaultTableModel;

import mantenimiento.GestionCuentaBancaria;
import mantenimiento.GestionTransportista;
import model.CuentaBancaria;
import model.Transportista;
import reporte.ReporteTransportistaRazonSocial;
import reporte.ReporteTransportistaRuc;

import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmConsultaTransportista extends JInternalFrame implements KeyListener, ActionListener {
	private JLabel lblConsultaDeTransportistas;
	private JPanel panel;
	private JTextField txtFiltro;
	private JComboBox cboCampo;
	private JLabel label_1;
	private JLabel label_2;
	private JPanel panel_1;
	private JScrollPane scrollPane;
	private JTable tblTransportistas;
	private DefaultTableModel modelo;
	private JButton btnReporte;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmConsultaTransportista frame = new FrmConsultaTransportista();
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
	public FrmConsultaTransportista() {
		setIconifiable(true);
		setClosable(true);
		setTitle("Consulta transportista");
		setBounds(100, 100, 691, 480);
		getContentPane().setLayout(null);
		
		lblConsultaDeTransportistas = new JLabel("Consulta de Transportistas");
		lblConsultaDeTransportistas.setOpaque(true);
		lblConsultaDeTransportistas.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaDeTransportistas.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConsultaDeTransportistas.setBackground(new Color(51, 153, 204));
		lblConsultaDeTransportistas.setBounds(10, 11, 654, 41);
		getContentPane().add(lblConsultaDeTransportistas);
		
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
		
		tblTransportistas = new JTable();
		tblTransportistas.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblTransportistas);
		modelo = new DefaultTableModel();
		modelo.addColumn("Cod Transportista");
		modelo.addColumn("Raz. Transportista");
		modelo.addColumn("RUC Transportista");
		modelo.addColumn("Con. Transportista");
		modelo.addColumn("Telef. Transportista");
		tblTransportistas.setModel(modelo);
		

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
		ArrayList<Transportista> lista=new ArrayList<>();
		GestionTransportista gcb = new GestionTransportista();
		if (indice == 1) {
			lista=gcb.listarRUC(filtro);
			modelo.setRowCount(0);
			for (Transportista cb : lista) {
				Object[] obj = {cb.getCod_tra(),cb.getRso_tra(),cb.getRuc_tra(),cb.getCon_tra(),cb.getTel_tra()};
				modelo.addRow(obj);
			}
		}
			else{
				lista=gcb.listarRSO(filtro);
				modelo.setRowCount(0);
				for (Transportista cb : lista) {
					Object[] obj = {cb.getCod_tra(),cb.getRso_tra(),cb.getRuc_tra(),cb.getCon_tra(),cb.getTel_tra()};
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
			ReporteTransportistaRuc.createReport("reps/rep_transportista_por_ruc.jasper", ruc);
			ReporteTransportistaRuc.showViewer();
			break;
		case 2:
			String raz_soc = txtFiltro.getText();
			ReporteTransportistaRazonSocial.createReport("reps/rep_transportista_por_rso.jasper", raz_soc);
			ReporteTransportistaRazonSocial.showViewer();
			break;
		}
	}
}
