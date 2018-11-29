package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import mantenimiento.GestionCliente;
import mantenimiento.GestionCuentaBancaria;
import model.Cliente;
import model.CuentaBancaria;
import reporte.ReporteClienteDniRuc;
import reporte.ReporteClienteRazNom;

import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class FrmConsultaCliente extends JInternalFrame implements KeyListener, ActionListener {
	private JLabel lblClientes;
	private JPanel panel;
	private JPanel panel_1;
	private JScrollPane scrollPane;
	private JTextField txtFiltro;
	private JComboBox cboCampo;
	private JLabel lblFiltrar;
	private JLabel lblFiltrar_1;
	private JTable tblClientes;
	private DefaultTableModel modelo;
	private JButton btnReporte;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmConsultaCliente frame = new FrmConsultaCliente();
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
	public FrmConsultaCliente() {
		setIconifiable(true);
		setClosable(true);
		setTitle("Consulta cliente");
		setBounds(100, 100, 689, 473);
		getContentPane().setLayout(null);
		
		lblClientes = new JLabel("Consulta de Clientes");
		lblClientes.setOpaque(true);
		lblClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientes.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblClientes.setBackground(new Color(51, 153, 204));
		lblClientes.setBounds(10, 11, 654, 41);
		getContentPane().add(lblClientes);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 204)));
		panel.setBounds(10, 63, 654, 58);
		getContentPane().add(panel);
		
		txtFiltro = new JTextField();
		this.txtFiltro.addKeyListener(this);
		txtFiltro.setBounds(296, 23, 229, 20);
		panel.add(txtFiltro);
		txtFiltro.setColumns(10);
		
		cboCampo = new JComboBox();
		cboCampo.setModel(new DefaultComboBoxModel(new String[] {"Seleccione campo", "RUC o DNI", "Raz\u00F3n social o Nombre"}));
		cboCampo.setBounds(66, 23, 144, 20);
		panel.add(cboCampo);
		
		lblFiltrar = new JLabel("Campo");
		lblFiltrar.setBounds(10, 26, 46, 14);
		panel.add(lblFiltrar);
		
		lblFiltrar_1 = new JLabel("Filtro");
		lblFiltrar_1.setBounds(240, 26, 46, 14);
		panel.add(lblFiltrar_1);
		
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
		
		tblClientes = new JTable();
		tblClientes.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblClientes);
		modelo=new DefaultTableModel();
		modelo.addColumn("Cod Cliente");
		modelo.addColumn("Cod Distrito");
		modelo.addColumn("Razón S.");
		modelo.addColumn("RUC / DNI");
		modelo.addColumn("Email Cli");
		modelo.addColumn("Telef");
		tblClientes.setModel(modelo);

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
		int indice = cboCampo.getSelectedIndex();
		String filtro = txtFiltro.getText();
		listarcliente(indice,filtro);
	}

	private void listarcliente(int indice, String filtro) {
		// TODO Auto-generated method stub
		ArrayList<Cliente> lista=new ArrayList<>();
		GestionCliente gc = new GestionCliente();
		if (indice == 1) {
			lista=gc.listardni(filtro);
			modelo.setRowCount(0);
			for (Cliente cb : lista) {
				Object[] obj = {cb.getCod_cli(),cb.getCod_dis(),cb.getRsn_cli(),cb.getRdn_cli(),cb.getEma_cli(),cb.getTel_cli()};
				modelo.addRow(obj);
			}
		}
			else{
				lista=gc.listarrso(filtro);
				modelo.setRowCount(0);
				for (Cliente cb : lista) {
					Object[] obj = {cb.getCod_cli(),cb.getCod_dis(),cb.getRsn_cli(),cb.getRdn_cli(),cb.getEma_cli(),cb.getTel_cli()};
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
			String ruc_dni = txtFiltro.getText();
			ReporteClienteDniRuc.createReport("reps/rep_cliente_por_ruc_dni.jasper", ruc_dni);
			ReporteClienteDniRuc.showViewer();
			break;
		case 2:
			String raz_nom = txtFiltro.getText();
			ReporteClienteRazNom.createReport("reps/rep_cliente_por_razon_social_nombre.jasper", raz_nom);
			ReporteClienteRazNom.showViewer();
			break;

		default:
			
			break;
		}
	}
}