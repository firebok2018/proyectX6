package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

import mantenimiento.GestionDistrito;
import mantenimiento.GestionProveedor;
import model.Abastecimiento;
import model.Distrito;
import model.Proveedor;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmProveedor extends JInternalFrame implements MouseListener,ActionListener {
	private JLabel label;
	private JPanel panel;
	private JLabel label_1;
	private JTextField txtCodigo;
	private JLabel lblRaznSocial;
	private JButton btnBuscar;
	private JLabel lblRuc;
	private JTextField txtRuc;
	private JLabel label_4;
	private JLabel label_6;
	private JLabel label_7;
	private JTextField txtEmail;
	private JLabel lblRepresentante;
	private JTextField txtDireccion;
	private JTextField txtRazonSocial;
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
	private JTextField txtTelefono;
	private JTextField txtRepVentas;
	private JTable tblProveedor;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmProveedor frame = new FrmProveedor();
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
	public FrmProveedor() {
		setIconifiable(true);
		setClosable(true);
		setTitle("Proveedor");
		setBounds(100, 100, 919, 566);
		getContentPane().setLayout(null);
		
		label = new JLabel("Seleccione un acci\u00F3n");
		label.setOpaque(true);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBackground(new Color(51, 153, 204));
		label.setBounds(10, 11, 881, 41);
		getContentPane().add(label);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 204)));
		panel.setBounds(10, 63, 881, 134);
		getContentPane().add(panel);
		
		label_1 = new JLabel("C\u00F3digo");
		label_1.setBounds(10, 23, 46, 14);
		panel.add(label_1);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(97, 20, 121, 20);
		panel.add(txtCodigo);
		
		lblRaznSocial = new JLabel("Raz\u00F3n social");
		lblRaznSocial.setBounds(10, 48, 91, 14);
		panel.add(lblRaznSocial);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setEnabled(false);
		btnBuscar.setBounds(257, 19, 89, 23);
		panel.add(btnBuscar);
		
		lblRuc = new JLabel("RUC");
		lblRuc.setBounds(10, 73, 80, 14);
		panel.add(lblRuc);
		
		txtRuc = new JTextField();
		txtRuc.setEditable(false);
		txtRuc.setColumns(10);
		txtRuc.setBounds(97, 70, 121, 20);
		panel.add(txtRuc);
		
		label_4 = new JLabel("Direcci\u00F3n");
		label_4.setBounds(10, 98, 80, 14);
		panel.add(label_4);
		
		label_6 = new JLabel("Tel\u00E9fono");
		label_6.setBounds(413, 23, 60, 14);
		panel.add(label_6);
		
		label_7 = new JLabel("E-mail");
		label_7.setBounds(413, 48, 60, 14);
		panel.add(label_7);
		
		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setColumns(10);
		txtEmail.setBounds(503, 45, 203, 20);
		panel.add(txtEmail);
		
		lblRepresentante = new JLabel("Rep. ventas");
		lblRepresentante.setBounds(413, 73, 80, 14);
		panel.add(lblRepresentante);
		
		txtDireccion = new JTextField();
		txtDireccion.setEditable(false);
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(97, 95, 249, 20);
		panel.add(txtDireccion);
		
		txtRazonSocial = new JTextField();
		txtRazonSocial.setEditable(false);
		txtRazonSocial.setColumns(10);
		txtRazonSocial.setBounds(97, 45, 249, 20);
		panel.add(txtRazonSocial);
		
		txtTelefono = new JTextField();
		txtTelefono.setEditable(false);
		txtTelefono.setBounds(503, 20, 106, 20);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtRepVentas = new JTextField();
		txtRepVentas.setEditable(false);
		txtRepVentas.setBounds(503, 70, 203, 20);
		panel.add(txtRepVentas);
		txtRepVentas.setColumns(10);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Registros", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 204)));
		panel_1.setBounds(10, 208, 881, 247);
		getContentPane().add(panel_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 28, 861, 208);
		panel_1.add(scrollPane);
		
		tblProveedor = new JTable();
		tblProveedor.addMouseListener(this);
		tblProveedor.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblProveedor);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Acciones", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 204)));
		panel_2.setBounds(10, 466, 881, 57);
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
		separator.setBounds(425, 23, 2, 23);
		panel_2.add(separator);
		
		modelo=new DefaultTableModel();
		modelo.addColumn("Codigo");
		modelo.addColumn("Razon Social");
		modelo.addColumn("RUC");
		modelo.addColumn("Direccion");
		modelo.addColumn("Telefono");
		modelo.addColumn("Email");
		modelo.addColumn("Representante");
		tblProveedor.setModel(modelo);
		
		listarTable();

	}
	
	private void listarTable() {
		// TODO Auto-generated method stub
		GestionProveedor g= new GestionProveedor();
		ArrayList<Proveedor> Lista=new ArrayList<>();
		Lista=g.listar();
		modelo.setRowCount(0);
		for(Proveedor d:Lista) {
			Object[] obj= {d.getCod_prv(),d.getRso_prv(),d.getRuc_prv(),d.getDir_prv(),d.getTel_prv(),d.getEma_prv(),d.getRep_prv() };
			modelo.addRow(obj);
		}	
	}
	private int tipoOperacion;
	// Constantes para los tipos de operaciones
	public final static int ADICIONAR = 0;
	public final static int MODIFICAR = 1;
	public final static int ELIMINAR = 2;
	public final static int CONSULTAR = 3;
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
		
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
		txtRazonSocial.setEditable(b);
		txtRuc.setEditable(b);
		txtDireccion.setEditable(b);
		txtTelefono.setEditable(b);
		txtEmail.setEditable(b);
		txtRepVentas.setEditable(b);
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
		
		
		//REGEX
		if(!temp.matches("[0-9]{1,3}")){
			JOptionPane.showMessageDialog(this, "Codigo Debe ser numérico mayor que cero");
			return;
		}
		int cod=Integer.parseInt(temp);
		//CREAR GESTION PARA STORED PROCEDURE
		GestionProveedor ga=new GestionProveedor();
		int estado=ga.eliminar(cod);
		if(estado>0)
			JOptionPane.showMessageDialog(this, "Se eliminó correctamente");
		listarTable();
	}

	private void modificar() {
			
		String raz=txtRazonSocial.getText();
		String temp=txtCodigo.getText();
		
		String ruc=txtRuc.getText();
		String dir=txtDireccion.getText();
		String tel=txtTelefono.getText();
		String mail=txtEmail.getText();
		String rep=txtRepVentas.getText();
		
		//REGEX PARA VALIDAR DATOS
		
		if(!temp.matches("[0-9]{1,3}")){
			JOptionPane.showMessageDialog(this, "Codigo Debe ser numérico mayor que cero");
			return;
		}
		if(!raz.matches("[a-z_A-Z0-9\\s]{3,50}")){
			JOptionPane.showMessageDialog(this, "Nombre debe tener entre 3 y 50 caracteres");
			return;
		}
		if(!dir.matches("[a-z_A-Z0-9\\s]{3,50}")){
			JOptionPane.showMessageDialog(this, "Nombre debe tener entre 3 y 50 caracteres");
			return;
		}
		if(!rep.matches("[a-z_A-Z0-9\\s]{3,50}")){
			JOptionPane.showMessageDialog(this, "Nombre debe tener entre 3 y 50 caracteres");
			return;
		}
		if(!tel.matches("[0-9]{11}||[0-9]{8}")){
			JOptionPane.showMessageDialog(this, "RUC o DNI debe ser válido");
			return;
		}
		if(!mail.matches("[0-9]+")){
			JOptionPane.showMessageDialog(this, "Stock actual debe ser numérico mayor o igual a cero");
			return;
		}
		
		int cod=Integer.parseInt(temp);
		//CREAR OBJETO
		Proveedor ab= new Proveedor();
		ab.setCod_prv(cod);
		ab.setRso_prv(raz);
		ab.setRuc_prv(ruc);
		ab.setDir_prv(dir);
		ab.setTel_prv(tel);
		ab.setEma_prv(mail);
		ab.setRep_prv(rep);
		
		//CREAR GESTION PARA STORED PROCEDURE
		GestionProveedor ga= new GestionProveedor();
		int estado=ga.actualizar(ab);
		if(estado>0)
			JOptionPane.showMessageDialog(this, "Se actualizo correctamente");	
		//ACTUALIZAR JTABLE
		listarTable();
		
	}

	private void consultar() {
		// TODO Auto-generated method stub
		
	}

	private void adicionar() {
		
		String raz=txtRazonSocial.getText();
		String temp=txtCodigo.getText();
		int cod=Integer.parseInt(temp);
		String ruc=txtRuc.getText();
		String dir=txtDireccion.getText();
		String tel=txtTelefono.getText();
		String mail=txtEmail.getText();
		String rep=txtRepVentas.getText();
		
		//REGEX PARA VALIDAR DATOS
		
		if(!raz.matches("[a-z_A-Z0-9\\s]{3,50}")){
			JOptionPane.showMessageDialog(this, "Nombre debe tener entre 3 y 50 caracteres");
			return;
		}
		if(!dir.matches("[a-z_A-Z0-9\\s]{3,50}")){
			JOptionPane.showMessageDialog(this, "Nombre debe tener entre 3 y 50 caracteres");
			return;
		}
		if(!rep.matches("[a-z_A-Z0-9\\s]{3,50}")){
			JOptionPane.showMessageDialog(this, "Nombre debe tener entre 3 y 50 caracteres");
			return;
		}
		if(!tel.matches("[0-9]{11}||[0-9]{8}")){
			JOptionPane.showMessageDialog(this, "RUC o DNI debe ser válido");
			return;
		}
		if(!mail.matches("[0-9]+")){
			JOptionPane.showMessageDialog(this, "Stock actual debe ser numérico mayor o igual a cero");
			return;
		}
		//CREAR OBJETO
		Proveedor ab= new Proveedor();
		ab.setCod_prv(cod);
		ab.setRso_prv(raz);
		ab.setRuc_prv(ruc);
		ab.setDir_prv(dir);
		ab.setTel_prv(tel);
		ab.setEma_prv(mail);
		ab.setRep_prv(rep);
		
		//CREAR GESTION PARA STORED PROCEDURE
		GestionProveedor ga= new GestionProveedor();
		int estado=ga.insertar(ab);
		if(estado>0)
			JOptionPane.showMessageDialog(this, "Se inserto correctamente");	
		//ACTUALIZAR JTABLE
		listarTable();
		
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
		if (e.getSource() == tblProveedor) {
			mouseClickedTblProveedor(e);
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
	protected void mouseClickedTblProveedor(MouseEvent e) {
		
		int fila=tblProveedor.getSelectedRow();
		int cod=(int) modelo.getValueAt(fila, 0);
		String rsn=(String) modelo.getValueAt(fila, 1);
		String ruc=(String) modelo.getValueAt(fila, 2);
		String dir=(String) modelo.getValueAt(fila, 3);
		String tel=(String) modelo.getValueAt(fila, 4);
		String email=(String) modelo.getValueAt(fila, 5);
		String rep=(String) modelo.getValueAt(fila, 6);
		
		txtCodigo.setText(String.valueOf(cod));
		txtRazonSocial.setText((rsn));
		txtRuc.setText((ruc));
		txtDireccion.setText(dir);
		txtTelefono.setText(tel);
		txtEmail.setText(email);
		txtRepVentas.setText(rep);
		
	}
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		
		FrmConsultaProveedor fp= new FrmConsultaProveedor();
		FrmPrincipal.desktopPane.add(fp);
		Dimension desktopSize = FrmPrincipal.desktopPane.getSize();
		Dimension FrameSize = fp.getSize();
		fp.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
		fp.setVisible(true);
	}
}
