package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import mantenimiento.GestionAbastecimiento;
import mantenimiento.GestionCliente;
import mantenimiento.GestionCuentaBancaria;
import mantenimiento.GestionProveedor;
import model.Abastecimiento;
import model.Cliente;
import model.CuentaBancaria;
import model.Proveedor;

import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class FrmCuentaBancaria extends JInternalFrame implements ActionListener, MouseListener {
	private JLabel label;
	private JPanel panel;
	private JLabel label_1;
	private JTextField txtCodigo;
	private JLabel lblProveedor;
	private JButton btnBuscar;
	private JComboBox cboProveedor;
	private JLabel lblBanco;
	private JLabel lblTipo;
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
	private JLabel lblNmero;
	private JTextField txtNumero;
	private JComboBox cboTipo;
	private JComboBox cboBanco;
	private JTable tblCuentas;
	private DefaultTableModel modelo;
	
	// Tipo de operación a procesar:
		// Adicionar, Modificar, Eliminar o Consultar
		private int tipoOperacion;
//		// Constantes para los tipos de operaciones
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
					FrmCuentaBancaria frame = new FrmCuentaBancaria();
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
	public FrmCuentaBancaria() {
		setIconifiable(true);
		setClosable(true);
		setTitle("Cuenta bancaria");
		setBounds(100, 100, 769, 533);
		getContentPane().setLayout(null);
		
		label = new JLabel("Seleccione un acci\u00F3n");
		label.setOpaque(true);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBackground(new Color(51, 153, 204));
		label.setBounds(10, 11, 733, 41);
		getContentPane().add(label);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 204)));
		panel.setBounds(10, 63, 733, 105);
		getContentPane().add(panel);
		
		label_1 = new JLabel("C\u00F3digo");
		label_1.setBounds(10, 23, 46, 14);
		panel.add(label_1);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(81, 20, 99, 20);
		panel.add(txtCodigo);
		
		lblProveedor = new JLabel("Proveedor");
		lblProveedor.setBounds(10, 48, 91, 14);
		panel.add(lblProveedor);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setEnabled(false);
		btnBuscar.setBounds(201, 19, 89, 23);
		panel.add(btnBuscar);
		
		cboProveedor = new JComboBox();
		cboProveedor.setBounds(81, 45, 209, 20);
		panel.add(cboProveedor);
		
		lblBanco = new JLabel("Banco");
		lblBanco.setBounds(326, 23, 46, 14);
		panel.add(lblBanco);
		
		lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(326, 48, 63, 14);
		panel.add(lblTipo);
		
		lblNmero = new JLabel("N\u00FAmero");
		lblNmero.setBounds(10, 73, 63, 14);
		panel.add(lblNmero);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(81, 70, 209, 20);
		panel.add(txtNumero);
		txtNumero.setColumns(10);
		
		cboTipo = new JComboBox();
		cboTipo.setBounds(392, 45, 152, 20);
		panel.add(cboTipo);
		
		cboBanco = new JComboBox();
		cboBanco.setBounds(392, 20, 152, 20);
		panel.add(cboBanco);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Registros", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 204)));
		panel_1.setBounds(10, 179, 733, 247);
		getContentPane().add(panel_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 28, 713, 208);
		panel_1.add(scrollPane);
		
		tblCuentas = new JTable();
		tblCuentas.addMouseListener(this);
		tblCuentas.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblCuentas);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Acciones", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 204)));
		panel_2.setBounds(10, 437, 733, 57);
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
		
		//establecer campos de tabla
		
		modelo=new DefaultTableModel();
		modelo.addColumn("Codigo");
		modelo.addColumn("Codigo Proveedor");
		modelo.addColumn("Nro de Cuenta");
		modelo.addColumn("Banco");
		modelo.addColumn("Tipo");		
		tblCuentas.setModel(modelo);
				
		//metodos que deben cargarse con el constructor
		
		listarProveedor();
		listarTipoCuenta();
		listarCuenta();
		listarBanco();

	}

	private void listarBanco() {
		
		GestionCuentaBancaria gcb= new GestionCuentaBancaria();
		ArrayList<CuentaBancaria> Lista=new ArrayList<>();
		Lista=gcb.listar();
		cboBanco.addItem("Seleccione Banco");
		for(CuentaBancaria cb:Lista) {
			cboBanco.addItem(cb.getBan_cue());
		}
		
	}

	private void listarCuenta() {
		// TODO Auto-generated method stub
		GestionCuentaBancaria gcb= new GestionCuentaBancaria();
		ArrayList<CuentaBancaria> Lista=new ArrayList<>();
		Lista=gcb.listar();
		modelo.setRowCount(0);
		for(CuentaBancaria cb:Lista) {
			Object[] obj= {cb.getCod_cue(),cb.getCod_prv(),cb.getNro_cue(),cb.getBan_cue(),cb.getTip_cue()};
			modelo.addRow(obj);
		}		
	}

	private void listarTipoCuenta() {
		// TODO Auto-generated method stub
		GestionCuentaBancaria gcb= new GestionCuentaBancaria();
		ArrayList<CuentaBancaria> Lista=new ArrayList<>();
		Lista=gcb.listar();
		cboTipo.addItem("Seleccione Tipo de Cuenta");
		for(CuentaBancaria cb:Lista) {
			cboTipo.addItem(cb.getTip_cue());
		}
	}

	private void listarProveedor() {
		// TODO Auto-generated method stub
		GestionProveedor gp= new GestionProveedor();
		ArrayList<Proveedor> Lista=new ArrayList<>();
		Lista=gp.listar();
		cboProveedor.addItem("Seleccione Proveedor");
		for(Proveedor p:Lista) {
			cboProveedor.addItem(p.getRso_prv());
		}	
	}
	
	
	
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
		txtCodigo.setEditable(b);
		txtNumero.setEditable(b);
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
		
		String temp=txtCodigo.getText();
		int cod=Integer.parseInt(temp);
		
		//REGEX
		if(!temp.matches("[1-9]+[0-9]*")){
			JOptionPane.showMessageDialog(this, "Codigo invalido");
			return;
		}
		//CREAR GESTION PARA STORED PROCEDURE
		GestionCuentaBancaria ga=new GestionCuentaBancaria();
		int estado=ga.eliminar(cod);
		if(estado>0)
			JOptionPane.showMessageDialog(this, "Se eliminó correctamente");
		listarCuenta();
	}

	private void modificar() {
		
		String temp=txtCodigo.getText();
		
		String a=cboBanco.getSelectedItem().toString();
		int b=cboProveedor.getSelectedIndex();
		String c=cboTipo.getSelectedItem().toString();
		String temp1=txtNumero.getText();
		
		
		//REGEX PARA VALIDAR DATOS
		if(!temp.matches("[1-9]+[0-9]*")){
			JOptionPane.showMessageDialog(this, "Codigo invalido");
			return;
		}
		if(!temp1.matches("[1-9]+[0-9]*")){
			JOptionPane.showMessageDialog(this, "Numero de Cta invalido");
			return;
		}
		int cod1=Integer.parseInt(temp1);
		int cod=Integer.parseInt(temp);
		//CREAR OBJETO
		CuentaBancaria ab= new CuentaBancaria();
		ab.setCod_cue(cod);
		ab.setCod_prv(b);
		ab.setNro_cue(temp1);
		ab.setBan_cue(a);
		ab.setTip_cue(c);
		
		
		//CREAR GESTION PARA STORED PROCEDURE
		GestionCuentaBancaria ga= new GestionCuentaBancaria();
		int estado=ga.actualizar(ab);
		if(estado>0)
			JOptionPane.showMessageDialog(this, "Se actualizo correctamente");	
		//ACTUALIZAR JTABLE
		listarCuenta();
		
	}

	private void consultar() {
		// TODO Auto-generated method stub
		
	}

	private void adicionar() {
		
		String a=cboBanco.getSelectedItem().toString();
		int b=cboProveedor.getSelectedIndex();
		String c=cboTipo.getSelectedItem().toString();
		String temp1=txtNumero.getText();
		int cod1=Integer.parseInt(temp1);
		
		//REGEX PARA VALIDAR DATOS
		if(!temp1.matches("[1-9]+[0-9]*")){
			JOptionPane.showMessageDialog(this, "Numero de Cta invalido");
			return;
		}
		//CREAR OBJETO
		CuentaBancaria ab= new CuentaBancaria();
		ab.setCod_prv(b);
		ab.setNro_cue(temp1);
		ab.setBan_cue(a);
		ab.setTip_cue(c);
		
		
		//CREAR GESTION PARA STORED PROCEDURE
		GestionCuentaBancaria ga= new GestionCuentaBancaria();
		int estado=ga.insertar(ab);
		if(estado>0)
			JOptionPane.showMessageDialog(this, "Se inserto correctamente");	
		//ACTUALIZAR JTABLE
		listarCuenta();
		
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
		txtCodigo.setEditable(true);
		habilitarBotones(false);
		txtCodigo.requestFocus();
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
		if (e.getSource() == tblCuentas) {
			mouseClickedTblCuentas(e);
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
	protected void mouseClickedTblCuentas(MouseEvent e) {
		
		int fila=tblCuentas.getSelectedRow();
		int cod=(int) modelo.getValueAt(fila, 0);
		int prov=(int) modelo.getValueAt(fila, 1);
		String nro=(String) modelo.getValueAt(fila, 2);
		String ban=(String) modelo.getValueAt(fila, 3);
		String tip=(String) modelo.getValueAt(fila, 4);
		
		txtCodigo.setText(String.valueOf(cod));
		txtNumero.setText(nro);
		cboProveedor.setSelectedIndex(prov);
		cboBanco.setSelectedItem(ban);
		cboTipo.setSelectedItem(tip);

	}
}
