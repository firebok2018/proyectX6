package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import mantenimiento.GestionDistrito;
import mantenimiento.GestionEmpleado;
import mantenimiento.GestionUsuario;
import model.Abastecimiento;
import model.Distrito;
import model.Empleado;
import model.Usuario;

import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmUsuario extends JInternalFrame implements MouseListener, ActionListener {
	private JLabel label;
	private JPanel panel;
	private JLabel label_1;
	private JTextField txtCodigo;
	private JLabel lblEmpleado;
	private JButton btnBuscar;
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
	private JComboBox cboEmpleado;
	private JLabel lblLogin;
	private JTextField txtUsuario;
	private JLabel lblContrasea;
	private JTextField txtContrasena;
	private JTable tblUsuarios;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmUsuario frame = new FrmUsuario();
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
	public FrmUsuario() {
		setIconifiable(true);
		setClosable(true);
		setTitle("Usuario");
		setBounds(100, 100, 693, 515);
		getContentPane().setLayout(null);
		
		label = new JLabel("Seleccione un acci\u00F3n");
		label.setOpaque(true);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBackground(new Color(51, 153, 204));
		label.setBounds(10, 11, 654, 41);
		getContentPane().add(label);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 204)));
		panel.setBounds(10, 63, 654, 90);
		getContentPane().add(panel);
		
		label_1 = new JLabel("C\u00F3digo");
		label_1.setBounds(10, 23, 46, 14);
		panel.add(label_1);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(81, 20, 80, 20);
		panel.add(txtCodigo);
		
		lblEmpleado = new JLabel("Empleado");
		lblEmpleado.setBounds(10, 48, 91, 14);
		panel.add(lblEmpleado);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setEnabled(false);
		btnBuscar.setBounds(182, 19, 89, 23);
		panel.add(btnBuscar);
		
		cboEmpleado = new JComboBox();
		cboEmpleado.setBounds(81, 45, 190, 20);
		panel.add(cboEmpleado);
		
		lblLogin = new JLabel("Usuario");
		lblLogin.setBounds(326, 23, 46, 14);
		panel.add(lblLogin);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(411, 20, 86, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(326, 48, 63, 14);
		panel.add(lblContrasea);
		
		txtContrasena = new JTextField();
		txtContrasena.setBounds(411, 45, 86, 20);
		panel.add(txtContrasena);
		txtContrasena.setColumns(10);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Registros", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 204)));
		panel_1.setBounds(10, 164, 654, 247);
		getContentPane().add(panel_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 28, 634, 208);
		panel_1.add(scrollPane);
		
		tblUsuarios = new JTable();
		tblUsuarios.addMouseListener(this);
		tblUsuarios.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblUsuarios);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Acciones", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 204)));
		panel_2.setBounds(10, 419, 654, 57);
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

		modelo=new DefaultTableModel();
		modelo.addColumn("Codigo Usuario");
		modelo.addColumn("Codigo empleado");
		modelo.addColumn("Usuario");
		modelo.addColumn("Password");
		
		tblUsuarios.setModel(modelo);
		
		listarTable();
		listarEmpleado();
	}
	
	private void listarEmpleado() {
		// TODO Auto-generated method stub
		GestionEmpleado gd= new GestionEmpleado();
		ArrayList<Empleado> Lista=new ArrayList<>();
		Lista=gd.listar();
		cboEmpleado.addItem("Seleccione Empleado");
		for(Empleado d:Lista) {
			cboEmpleado.addItem(d.getCod_emp());
		}
	}

	private void listarTable() {
		// TODO Auto-generated method stub
		GestionUsuario g= new GestionUsuario();
		ArrayList<Usuario> Lista=new ArrayList<>();
		Lista=g.listar();
		modelo.setRowCount(0);
		for(Usuario d:Lista) {
			Object[] obj= {d.getCod_usu(),d.getCod_emp(),d.getLog_usu(),d.getPas_usu() };
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
		txtContrasena.setEditable(b);
		txtUsuario.setEditable(b);
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
		if(!temp.matches("[1-9]+[0-9]*")){
			JOptionPane.showMessageDialog(this, "Codigo de Producto invalido");
			return;
		}
		int cod=Integer.parseInt(temp);
		//CREAR GESTION PARA STORED PROCEDURE
		GestionUsuario ga=new GestionUsuario();
		int estado=ga.eliminar(cod);
		if(estado>0)
			JOptionPane.showMessageDialog(this, "Se eliminó correctamente");
		listarTable();
	}

	private void modificar() {
		
		int cod_emp=cboEmpleado.getSelectedIndex();
		String user=txtUsuario.getText();
		String temp=txtCodigo.getText();
		String pass=txtContrasena.getText();
		
		
		//REGEX PARA VALIDAR DATOS
		if(!temp.matches("[1-9]+[0-9]*")){
			JOptionPane.showMessageDialog(this, "Codigo de Producto invalido");
			return;
		}
		if(!user.matches("[a-z_A-Z0-9\\s]{3,50}")){
			JOptionPane.showMessageDialog(this, "Descripción debe ser alfanumérico entre 4 y 50 caracteres");
			return;
		}
		if(!pass.matches("[a-z_A-Z0-9\\s]{3,50}")){
			JOptionPane.showMessageDialog(this, "Descripción debe ser alfanumérico entre 4 y 50 caracteres");
			return;
		}
		int cod=Integer.parseInt(temp);
		
		//CREAR OBJETO
		Usuario ab= new Usuario();
		ab.setCod_emp(cod_emp);
		ab.setCod_usu(cod);
		ab.setLog_usu(user);
		ab.setPas_usu(pass);
		
		//CREAR GESTION PARA STORED PROCEDURE
		GestionUsuario ga= new GestionUsuario();
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
		
		int cod_emp=cboEmpleado.getSelectedIndex();
		String user=txtUsuario.getText();
		String temp=txtCodigo.getText();
		String pass=txtContrasena.getText();
		
		
		//REGEX PARA VALIDAR DATOS
		if(!user.matches("[a-z_A-Z0-9\\s]{3,50}")){
			JOptionPane.showMessageDialog(this, "Descripción debe ser alfanumérico entre 4 y 50 caracteres");
			return;
		}
		if(!pass.matches("[a-z_A-Z0-9\\s]{3,50}")){
			JOptionPane.showMessageDialog(this, "Descripción debe ser alfanumérico entre 4 y 50 caracteres");
			return;
		}
		int cod=Integer.parseInt(temp);
		//CREAR OBJETO
		Usuario ab= new Usuario();
		ab.setCod_emp(cod_emp);
		ab.setCod_usu(cod);
		ab.setLog_usu(user);
		ab.setPas_usu(pass);
		
		//CREAR GESTION PARA STORED PROCEDURE
		GestionUsuario ga= new GestionUsuario();
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
		if (e.getSource() == tblUsuarios) {
			mouseClickedTblUsuarios(e);
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
	protected void mouseClickedTblUsuarios(MouseEvent e) {
		int fila=tblUsuarios.getSelectedRow();
		int cod=(int) modelo.getValueAt(fila, 0);
		int emp=(int) modelo.getValueAt(fila, 1);
		String user=(String) modelo.getValueAt(fila, 2);
		String pass=(String) modelo.getValueAt(fila, 3);
		txtCodigo.setText(String.valueOf(cod));
		cboEmpleado.setSelectedItem(emp);
		txtUsuario.setText(user);
		txtContrasena.setText(pass);
	}
	protected void actionPerformedBtnBuscar(ActionEvent e) {
	}
}
