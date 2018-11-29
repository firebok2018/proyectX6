package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import com.toedter.calendar.JDateChooser;

import mantenimiento.GestionDistrito;
import mantenimiento.GestionEmpleado;
import model.Abastecimiento;
import model.Distrito;
import model.Empleado;

import javax.swing.JTable;

public class FrmEmpleado extends JInternalFrame implements ActionListener, MouseListener {
	private JLabel label;
	private JPanel panel;
	private JLabel label_1;
	private JTextField txtCodigo;
	private JLabel lblTipo;
	private JButton btnBuscar;
	private JLabel lblNombre;
	private JComboBox cboTipo;
	private JTextField txtNombres;
	private JLabel lblApellido;
	private JLabel lblDni;
	private JTextField txtDni;
	private JLabel lblFechaNacimiento;
	private JLabel lblTelfono;
	private JTextField txtTelefono;
	private JLabel lblDireccin;
	private JLabel lblFechaDeIngreso;
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
	private JTextField txtApellidos;
	private JTextField txtDireccion;
	private JDateChooser dtcFecNacimiento;
	private JDateChooser dtcFecIngreso;
	private JLabel lblDistrito;
	private JComboBox cboDistrito;
	private JTable tblEmpleados;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmEmpleado frame = new FrmEmpleado();
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
	public FrmEmpleado() {
		setIconifiable(true);
		setClosable(true);
		setTitle("Empleado");
		setBounds(100, 100, 917, 586);
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
		panel.setBounds(10, 63, 881, 159);
		getContentPane().add(panel);
		
		label_1 = new JLabel("C\u00F3digo");
		label_1.setBounds(10, 23, 46, 14);
		panel.add(label_1);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(97, 20, 80, 20);
		panel.add(txtCodigo);
		
		lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(10, 48, 91, 14);
		panel.add(lblTipo);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setEnabled(false);
		btnBuscar.setBounds(218, 19, 89, 23);
		panel.add(btnBuscar);
		
		lblNombre = new JLabel("Nombres");
		lblNombre.setBounds(10, 73, 80, 14);
		panel.add(lblNombre);
		
		cboTipo = new JComboBox();
		cboTipo.setBounds(97, 45, 210, 20);
		panel.add(cboTipo);
		
		txtNombres = new JTextField();
		txtNombres.setEditable(false);
		txtNombres.setColumns(10);
		txtNombres.setBounds(97, 70, 210, 20);
		panel.add(txtNombres);
		
		lblApellido = new JLabel("Apellidos");
		lblApellido.setBounds(10, 98, 80, 14);
		panel.add(lblApellido);
		
		lblDni = new JLabel("Dni");
		lblDni.setBounds(10, 123, 60, 14);
		panel.add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setEditable(false);
		txtDni.setColumns(10);
		txtDni.setBounds(97, 120, 125, 20);
		panel.add(txtDni);
		
		lblFechaNacimiento = new JLabel("Fecha nacimiento");
		lblFechaNacimiento.setBounds(367, 23, 107, 14);
		panel.add(lblFechaNacimiento);
		
		lblTelfono = new JLabel("Tel\u00E9fono");
		lblTelfono.setBounds(367, 48, 80, 14);
		panel.add(lblTelfono);
		
		txtTelefono = new JTextField();
		txtTelefono.setEditable(false);
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(484, 45, 106, 20);
		panel.add(txtTelefono);
		
		lblDireccin = new JLabel("Direcci\u00F3n");
		lblDireccin.setBounds(367, 73, 91, 14);
		panel.add(lblDireccin);
		
		lblFechaDeIngreso = new JLabel("Fecha de ingreso");
		lblFechaDeIngreso.setBounds(367, 123, 107, 14);
		panel.add(lblFechaDeIngreso);
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(97, 95, 210, 20);
		panel.add(txtApellidos);
		txtApellidos.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(484, 70, 257, 20);
		panel.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		dtcFecNacimiento = new JDateChooser();
		dtcFecNacimiento.setBounds(483, 17, 107, 20);
		panel.add(dtcFecNacimiento);
		
		dtcFecIngreso = new JDateChooser();
		dtcFecIngreso.setBounds(484, 120, 106, 20);
		panel.add(dtcFecIngreso);
		
		lblDistrito = new JLabel("Distrito");
		lblDistrito.setBounds(367, 98, 80, 14);
		panel.add(lblDistrito);
		
		cboDistrito = new JComboBox();
		cboDistrito.setBounds(484, 95, 257, 20);
		panel.add(cboDistrito);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Registros", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 204)));
		panel_1.setBounds(10, 233, 881, 247);
		getContentPane().add(panel_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 28, 861, 208);
		panel_1.add(scrollPane);
		
		tblEmpleados = new JTable();
		tblEmpleados.addMouseListener(this);
		tblEmpleados.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblEmpleados);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Acciones", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 204)));
		panel_2.setBounds(10, 491, 881, 57);
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
		modelo.addColumn("Tipo");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido");
		modelo.addColumn("DNI");
		modelo.addColumn("Fecha Nacimiento");
		modelo.addColumn("Telefono");
		modelo.addColumn("Direccion");
		modelo.addColumn("Codigo Distrito");
		modelo.addColumn("Fecha de Inicio");		
		tblEmpleados.setModel(modelo);
		
		listarTable();
	}
	private void listarTable() {
		// TODO Auto-generated method stub
		GestionEmpleado g= new GestionEmpleado();
		ArrayList<Empleado> Lista=new ArrayList<>();
		Lista=g.listar();
		modelo.setRowCount(0);
		for(Empleado d:Lista) {
			Object[] obj= {d.getCod_emp(),d.getTip_emp(), d.getNom_emp(),d.getApe_emp(),d.getDni_emp(),d.getFna_emp(),d.getTel_emp(),d.getDir_emp(),d.getCod_dis(),d.getFin_emp()};
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
		txtNombres.setEditable(b);
		txtApellidos.setEditable(b);
		txtDni.setEditable(b);
		txtDni.setEditable(b);
		txtTelefono.setEditable(b);
		txtDireccion.setEditable(b);
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
			JOptionPane.showMessageDialog(this, "Código debe ser numérico mayor que cero");
			return;
		}
		//CREAR GESTION PARA STORED PROCEDURE
		GestionEmpleado ga=new GestionEmpleado();
		int estado=ga.eliminar(cod);
		if(estado>0)
			JOptionPane.showMessageDialog(this, "Se eliminó correctamente");
		listarTable();
	}

	private void modificar() {
		
		String tipo=cboTipo.getSelectedItem().toString();
		int cod_dis=cboDistrito.getSelectedIndex();
		String nombre=txtNombres.getText();
		String apel=txtApellidos.getText();
		String dir=txtDireccion.getText();
		String tel=txtTelefono.getText();
		String temp=txtCodigo.getText();
		int cod=Integer.parseInt(temp);
		String dni=txtDni.getText();
		String fn=dtcFecNacimiento.getDateFormatString();
		String fi=dtcFecIngreso.getDateFormatString();
		
		//REGEX PARA VALIDAR DATOS
		if(!temp.matches("[1-9]+[0-9]*")){
			JOptionPane.showMessageDialog(this, "Código debe ser numérico mayor que cero");
			return;
		}
		if(!nombre.matches("[a-z_A-Z0-9\\s]{4,50}")){
			JOptionPane.showMessageDialog(this, "Descripción debe ser alfanumérico entre 4 y 50 caracteres");
			return;
		}
		if(!apel.matches("[a-z_A-Z0-9\\s]{4,50}")){
			JOptionPane.showMessageDialog(this, "Descripción debe ser alfanumérico entre 4 y 50 caracteres");
			return;
		}
		if(!dir.matches("[a-z_A-Z0-9\\s]{4,50}")){
			JOptionPane.showMessageDialog(this, "Descripción debe ser alfanumérico entre 4 y 50 caracteres");
			return;
		}
		
		if(!tel.matches("[0-9]{9}")){
			JOptionPane.showMessageDialog(this, "Stock actual debe ser numérico mayor o igual a cero");
			return;
		}
		if(!dni.matches("[0-9]{8}")){
			JOptionPane.showMessageDialog(this, "Stock actual debe ser numérico mayor o igual a cero");
			return;
		}
		
		
		//CREAR OBJETO
		Empleado ab= new Empleado();
		ab.setCod_emp(cod);
		ab.setTip_emp(tipo);
		ab.setDni_emp(dni);
		ab.setNom_emp(nombre);
		ab.setApe_emp(apel);
		ab.setTel_emp(tel);
		ab.setDir_emp(dir);
		ab.setCod_dis(cod_dis);
		ab.setFin_emp(fi);
		ab.setFna_emp(fn);
		
		//CREAR GESTION PARA STORED PROCEDURE
		GestionEmpleado ga= new GestionEmpleado();
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
		String tipo=cboTipo.getSelectedItem().toString();
		int cod_dis=cboDistrito.getSelectedIndex();
		String nombre=txtNombres.getText();
		String apel=txtApellidos.getText();
		String dir=txtDireccion.getText();
		String tel=txtTelefono.getText();
		String dni=txtDni.getText();
		String fn=dtcFecNacimiento.getDateFormatString().toString();
		String fi=dtcFecIngreso.getDateFormatString().toString();
		
		//REGEX PARA VALIDAR DATOS
		
		
		if(!nombre.matches("[a-z_A-Z0-9\\s]{4,50}")){
			JOptionPane.showMessageDialog(this, "Descripción debe ser alfanumérico entre 4 y 50 caracteres");
			return;
		}
		if(!apel.matches("[a-z_A-Z0-9\\s]{4,50}")){
			JOptionPane.showMessageDialog(this, "Descripción debe ser alfanumérico entre 4 y 50 caracteres");
			return;
		}
		if(!dir.matches("[a-z_A-Z0-9\\s]{4,50}")){
			JOptionPane.showMessageDialog(this, "Descripción debe ser alfanumérico entre 4 y 50 caracteres");
			return;
		}
		
		if(!tel.matches("[0-9]{9}")){
			JOptionPane.showMessageDialog(this, "Stock actual debe ser numérico mayor o igual a cero");
			return;
		}
		if(!dni.matches("[0-9]{8}")){
			JOptionPane.showMessageDialog(this, "Stock actual debe ser numérico mayor o igual a cero");
			return;
		}
		//CREAR OBJETO
		Empleado ab= new Empleado();
	
		ab.setTip_emp(tipo);
		ab.setDni_emp(dni);
		ab.setNom_emp(nombre);
		ab.setApe_emp(apel);
		ab.setTel_emp(tel);
		ab.setDir_emp(dir);
		ab.setCod_dis(cod_dis);
		ab.setFin_emp(fi);
		ab.setFna_emp(fn);
		
		//CREAR GESTION PARA STORED PROCEDURE
		GestionEmpleado ga= new GestionEmpleado();
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
	
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == tblEmpleados) {
			mouseClickedTblEmpleados(arg0);
		}
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	protected void mouseClickedTblEmpleados(MouseEvent arg0) {
		
		
		
	}
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		FrmConsultaCliente fp= new FrmConsultaCliente();
		FrmPrincipal.desktopPane.add(fp);
		Dimension desktopSize = FrmPrincipal.desktopPane.getSize();
		Dimension FrameSize = fp.getSize();
		fp.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
		fp.setVisible(true);
	}
}
