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
import com.toedter.calendar.JDateChooser;

import mantenimiento.GestionConsultaOrdenCompra;
import mantenimiento.GestionVenta;
import model.ConsultaOrdenCompra;
import model.CuentaBancaria;
import model.Venta;
import reporte.ReporteVentaEstadoDeVenta;
import reporte.ReporteVentaMarcaDeProducto;
import reporte.ReporteVentaNombreDeCliente;
import reporte.ReporteVentaNombreDeEmpleado;
import reporte.ReporteVentaNombreDeProducto;
import reporte.ReporteVentaNumeroDeVenta;
import reporte.ReporteVentaRangoDeFechas;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class FrmConsultaVenta extends JInternalFrame implements KeyListener, ActionListener, ItemListener {
	private JLabel lblConsultaDeVentas;
	private JPanel panel;
	private JTextField txtFiltro;
	private JComboBox cboCampo;
	private JLabel label_1;
	private JLabel label_2;
	private JButton btnConsultar;
	private JPanel panel_1;
	private JScrollPane scrollPane;
	private JLabel lblInicio;
	private JLabel lblTrmino;
	private JDateChooser dtcTermino;
	private JDateChooser dtcInicio;
	private JTable tblVentas;
	private DefaultTableModel modelo1;
	private DefaultTableModel modelo2;
	private DefaultTableModel modelo3;
	private DefaultTableModel modelo4;
	private DefaultTableModel modelo5;
	private DefaultTableModel modelo6;
	private JButton btnReporte;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmConsultaVenta frame = new FrmConsultaVenta();
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
	public FrmConsultaVenta() {
		setIconifiable(true);
		setClosable(true);
		setTitle("Consulta venta");
		setBounds(100, 100, 691, 516);
		getContentPane().setLayout(null);
		
		lblConsultaDeVentas = new JLabel("Consulta de Ventas");
		lblConsultaDeVentas.setOpaque(true);
		lblConsultaDeVentas.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaDeVentas.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConsultaDeVentas.setBackground(new Color(51, 153, 204));
		lblConsultaDeVentas.setBounds(10, 11, 654, 41);
		getContentPane().add(lblConsultaDeVentas);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 204)));
		panel.setBounds(10, 63, 654, 91);
		getContentPane().add(panel);
		
		txtFiltro = new JTextField();
		this.txtFiltro.addKeyListener(this);
		txtFiltro.setColumns(10);
		txtFiltro.setBounds(296, 23, 229, 20);
		panel.add(txtFiltro);
		
		cboCampo = new JComboBox();
		this.cboCampo.addItemListener(this);
		cboCampo.setModel(new DefaultComboBoxModel(new String[] {"Seleccione campo", "N\u00FAmero de venta", "Marca de producto", "Nombre de producto", "Nombre de cliente", "Nombre de empleado", "Estado de venta", "Rango de fechas"}));
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
		btnConsultar.setBounds(535, 22, 95, 23);
		panel.add(btnConsultar);
		
		lblInicio = new JLabel("Inicio");
		
		lblInicio.setBounds(10, 60, 46, 14);
		panel.add(lblInicio);
		
		lblTrmino = new JLabel("T\u00E9rmino");
		lblTrmino.setBounds(240, 60, 46, 14);
		panel.add(lblTrmino);
		
		dtcTermino = new JDateChooser();
		dtcTermino.setDateFormatString("dd-MM-yyyy");
		dtcTermino.setEnabled(false);
		dtcTermino.setBounds(296, 54, 95, 20);
		panel.add(dtcTermino);
		
		dtcInicio = new JDateChooser();
		dtcInicio.setEnabled(false);
		dtcInicio.setDateFormatString("dd-MM-yyyy");
		dtcInicio.setBounds(66, 54, 95, 20);
		panel.add(dtcInicio);
		
		btnReporte = new JButton("Reporte");
		btnReporte.addActionListener(this);
		btnReporte.setBounds(535, 51, 95, 23);
		panel.add(btnReporte);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Registros", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 204)));
		panel_1.setBounds(10, 165, 654, 311);
		getContentPane().add(panel_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 28, 634, 262);
		panel_1.add(scrollPane);
		
		tblVentas = new JTable();
		tblVentas.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblVentas);
		
		modelo1 = new DefaultTableModel();
		modelo1.addColumn("Desc. Marca");
		modelo1.addColumn("Cantidad");
		modelo1.addColumn("Total");
		
		modelo2 = new DefaultTableModel();
		modelo2.addColumn("Desc. Producto");
		modelo2.addColumn("Cantidad");
		modelo2.addColumn("Total");
		
		modelo3 = new DefaultTableModel();
		modelo3.addColumn("Num. Ventas");
		modelo3.addColumn("Cantidad");
		modelo3.addColumn("Total");
		
		modelo4 = new DefaultTableModel();
		modelo4.addColumn("Num. Ventas");
		modelo4.addColumn("Est. Ventas");
		modelo4.addColumn("Cantidad");
		modelo4.addColumn("Total");
		
		modelo5 = new DefaultTableModel();
		modelo5.addColumn("Num. Ventas");
		modelo5.addColumn("Raz. Cliente");
		modelo5.addColumn("Cantidad");
		modelo5.addColumn("Total");
		
		modelo6 = new DefaultTableModel();
		modelo6.addColumn("Num. Ventas");
		modelo6.addColumn("Ape. Empleado");
		modelo6.addColumn("Nom. Empleado");
		modelo6.addColumn("Cantidad");
		modelo6.addColumn("Total");
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
		ArrayList<Venta> lista=new ArrayList<>();
		GestionVenta gcb = new GestionVenta();
		
		if (indice == 2) {
			tblVentas.setModel(modelo1);
			lista=gcb.listarMAR(filtro);
			modelo1.setRowCount(0);
			for (Venta cb : lista) {
				Object[] obj = {cb.getDes_mar(),cb.getCantidad(),cb.getTotal()};
				modelo1.addRow(obj);
			}
		}
			else if (indice == 3){
				tblVentas.setModel(modelo2);
				lista=gcb.listarNOMP(filtro);
				modelo2.setRowCount(0);
				for (Venta cb : lista) {
					Object[] obj = {cb.getDes_pro(),cb.getCantidad(),cb.getTotal()};
					modelo2.addRow(obj);
			} 
			
		}
			else if (indice == 4){
				tblVentas.setModel(modelo5);
				lista=gcb.listarNOMC(filtro);
				modelo5.setRowCount(0);
				for (Venta cb : lista) {
					Object[] obj = {cb.getNum_ven(),cb.getRso_cli(),cb.getCantidad(),cb.getTotal()};
					modelo5.addRow(obj);
				}
			}
			else if (indice == 5){
				tblVentas.setModel(modelo6);
				lista=gcb.listarNOME(filtro);
				modelo6.setRowCount(0);
				for (Venta cb : lista) {
					Object[] obj = {cb.getNum_ven(),cb.getApe_emp(),cb.getNom_emp(),cb.getCantidad(),cb.getTotal()};
					modelo6.addRow(obj);
				}
			}
			else if (indice == 6){
				tblVentas.setModel(modelo4);
				lista=gcb.listarEST(filtro);
				modelo4.setRowCount(0);
				for (Venta cb : lista) {
					Object[] obj = {cb.getNum_ven(),cb.getEst_ven(),cb.getCantidad(),cb.getTotal()};
					modelo4.addRow(obj);
				}
			}
}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnReporte) {
			actionPerformedBtnReporte(e);
		}
		if (e.getSource() == this.btnConsultar) {
			actionPerformedBtnConsultar(e);
		}
	}
	protected void actionPerformedBtnConsultar(ActionEvent e) {
		
		String Inicio,Fin;
		int indice = cboCampo.getSelectedIndex();;
		ArrayList<Venta> lista=new ArrayList<>();
		GestionVenta gcb = new GestionVenta();
		
			
			if (indice == 1) {
				int num = Integer.parseInt(txtFiltro.getText());
				tblVentas.setModel(modelo3);
				lista=gcb.listarNUM(num);
				modelo3.setRowCount(0);
				for (Venta cb : lista) {
					Object[] obj = {cb.getNum_ven(),cb.getCantidad(),cb.getTotal()};
					modelo3.addRow(obj);
				}
			}
				else if (indice == 7){
					DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
					Inicio = fmt.format(dtcInicio.getDate());
					Fin = fmt.format(dtcTermino.getDate());
					
					
					
					tblVentas.setModel(modelo3);
					lista=gcb.listarFEC(Inicio,Fin);
					modelo3.setRowCount(0);
					for (Venta cb : lista) {
						Object[] obj = {cb.getNum_ven(),cb.getCantidad(),cb.getTotal()};
						modelo3.addRow(obj);
				} 
				
			}
			
	}
	public void itemStateChanged(ItemEvent arg0) {
		if (arg0.getSource() == this.cboCampo) {
			itemStateChangedCboCampo(arg0);
		}
	}
	protected void itemStateChangedCboCampo(ItemEvent arg0) {
		int indice = cboCampo.getSelectedIndex();
		
		if (indice == 1 || indice==7){
			btnConsultar.setEnabled(true);
		}
		else
			btnConsultar.setEnabled(false);
		if (indice == 7){
			dtcInicio.setEnabled(true);
			dtcTermino.setEnabled(true);
			
		}
		else{
			dtcInicio.setEnabled(false);
			dtcTermino.setEnabled(false);
		}
	}
	protected void actionPerformedBtnReporte(ActionEvent e) {
		int indice=cboCampo.getSelectedIndex();
		switch (indice) {
		case 1:
			int numero = Integer.parseInt(txtFiltro.getText());
			ReporteVentaNumeroDeVenta.createReport("reps/rep_venta_por_numero.jasper",numero);
			ReporteVentaNumeroDeVenta.showViewer();
			break;
		case 2:
			String marca_producto = txtFiltro.getText();
			ReporteVentaMarcaDeProducto.createReport("reps/rep_consulta_venta_producto_por_marca.jasper",marca_producto);
			ReporteVentaMarcaDeProducto.showViewer();
			break;
		case 3:
			String nom_producto = txtFiltro.getText();
			ReporteVentaNombreDeProducto.createReport("reps/rep_venta_producto_por_nombre.jasper",nom_producto);
			ReporteVentaNombreDeProducto.showViewer();
			break;
		case 4:
			String nom_cliente = txtFiltro.getText();
			ReporteVentaNombreDeCliente.createReport("reps/rep_venta_por_cliente.jasper",nom_cliente);
			ReporteVentaNombreDeCliente.showViewer();
			break;
		case 5:
			String nom_empleado = txtFiltro.getText();
			ReporteVentaNombreDeEmpleado.createReport("reps/rep_venta_por_empleado.jasper",nom_empleado);
			ReporteVentaNombreDeEmpleado.showViewer();
			break;
		case 6:
			String estado_venta = txtFiltro.getText();
			ReporteVentaEstadoDeVenta.createReport("reps/rep_venta_por_estado.jasper",estado_venta);
			ReporteVentaEstadoDeVenta.showViewer();
			break;
		case 7:
		
			Date ini = dtcInicio.getDate();
			Date fin = dtcTermino.getDate();
			ReporteVentaRangoDeFechas.createReport("reps/rep_venta_por_rango_fechas.jasper",ini,fin);
			ReporteVentaRangoDeFechas.showViewer();
			break;

		default:
			
			break;
		}
	}
}
