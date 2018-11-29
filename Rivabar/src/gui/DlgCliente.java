package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import Arreglos.ArregloClientes;
import clases.Cliente;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class DlgCliente extends JDialog implements ActionListener {
	private JLabel lblDni;
	private JTextField txtDni;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblApellido;
	private JTextField txtApellido;
	private JLabel lblTelefono;
	private JTextField txtTelefono;
	private JScrollPane scrollPane;
	private JTable tblTabla;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnAceptar;
	
	private DefaultTableModel modelo;

	private int tipoOperacion;
	
	public final static int ADICIONAR = 0;
	public final static int MODIFICAR = 1;
	public final static int ELIMINAR= 2;
	private JButton btnVolver;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgCliente dialog = new DlgCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgCliente() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgCliente.class.getResource("/imagen/manager.png")));
		setTitle("Actualizaci\u00F2n / Cliente");
		setBounds(100, 100, 663, 560);
		getContentPane().setLayout(null);
		
		lblDni = new JLabel("DNI:");
		lblDni.setBounds(20, 24, 46, 14);
		getContentPane().add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setBounds(91, 21, 204, 20);
		getContentPane().add(txtDni);
		txtDni.setColumns(10);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(20, 57, 61, 14);
		getContentPane().add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBounds(91, 54, 204, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(20, 92, 61, 14);
		getContentPane().add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setEditable(false);
		txtApellido.setBounds(91, 89, 204, 20);
		getContentPane().add(txtApellido);
		txtApellido.setColumns(10);
		
		lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(20, 123, 61, 14);
		getContentPane().add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setEditable(false);
		txtTelefono.setBounds(91, 120, 204, 20);
		getContentPane().add(txtTelefono);
		txtTelefono.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 160, 627, 350);
		getContentPane().add(scrollPane);
		
		tblTabla = new JTable();
		tblTabla.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblTabla);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setIcon(new ImageIcon(DlgCliente.class.getResource("/imagen/plus.png")));
		btnAdicionar.setForeground(Color.BLACK);
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnAdicionar(e);
			}
		});
		btnAdicionar.setBounds(496, 14, 127, 34);
		getContentPane().add(btnAdicionar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setIcon(new ImageIcon(DlgCliente.class.getResource("/imagen/services.png")));
		btnModificar.setForeground(Color.BLACK);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnModificar(e);
			}
		});
		btnModificar.setBounds(496, 57, 127, 34);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(DlgCliente.class.getResource("/imagen/delete_database.png")));
		btnEliminar.setForeground(Color.BLACK);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnEliminar(e);
			}
		});
		btnEliminar.setBounds(496, 102, 127, 34);
		getContentPane().add(btnEliminar);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setIcon(new ImageIcon(DlgCliente.class.getResource("/imagen/ok.png")));
		btnAceptar.setForeground(Color.BLACK);
		btnAceptar.setEnabled(false);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedBtnAceptar(arg0);
			}
		});
		btnAceptar.setBounds(315, 57, 116, 34);
		getContentPane().add(btnAceptar);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("DNI");
		modelo.addColumn("NOMBRE");
		modelo.addColumn("APELLIDO");
		modelo.addColumn("TELEFONO");
		
		tblTabla.setModel(modelo);
		
		btnVolver = new JButton("Volver");
		btnVolver.setIcon(new ImageIcon(DlgCliente.class.getResource("/imagen/previous.png")));
		btnVolver.setForeground(Color.BLACK);
		btnVolver.setEnabled(false);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnVolver(e);
			}
		});
		btnVolver.setBounds(315, 108, 116, 34);
		getContentPane().add(btnVolver);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon(DlgCliente.class.getResource("/imagen/search.png")));
		btnBuscar.setForeground(Color.BLACK);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedBtnBuscar(arg0);
			}
		});
		btnBuscar.setBounds(315, 14, 116, 34);
		getContentPane().add(btnBuscar);
		 
		ajustarAnchoColumnas();
		listar();
	}
	//declaracion de variables
		ArregloClientes cli= new ArregloClientes();
		private JButton btnBuscar;
		
	public void actionPerformed(ActionEvent arg0) {
		
	}
	
	void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblTabla.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(25));  // numero de mesa
		tcm.getColumn(1).setPreferredWidth(anchoColumna(25));  // numero de box
		tcm.getColumn(2).setPreferredWidth(anchoColumna(50));  // estado
		tcm.getColumn(3).setPreferredWidth(anchoColumna(25));  // sona
	}
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	
	protected void actionPerformedBtnAceptar(ActionEvent arg0) 
	{
		switch (tipoOperacion){
		case ADICIONAR:
			adicionarCliente();
			break;
		case MODIFICAR:
			modificarCliente();
			break;
		case ELIMINAR:
			eliminarCliente();
		}
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) 
	{
		tipoOperacion =ELIMINAR;
		txtDni.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtTelefono.setText("");
		habilitarEntradas(false);
		habilitarBotones(false);
		txtDni.requestFocus();
	}
	protected void actionPerformedBtnAdicionar(ActionEvent e) 
	{
		tipoOperacion = ADICIONAR;
		txtDni.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtTelefono.setText("");
		habilitarEntradas(true);
		habilitarBotones(false);
		txtDni.requestFocus();
	}
	protected void actionPerformedBtnModificar(ActionEvent e) 
	{
		tipoOperacion =	MODIFICAR;
		txtDni.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtTelefono.setText("");
		habilitarEntradas(true);
		habilitarBotones(false);
		txtDni.requestFocus();
	}
	protected void actionPerformedBtnVolver(ActionEvent e) 
	{
		txtDni.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtTelefono.setText("");
		habilitarEntradas(false);
		habilitarBotones(true);
	}
	protected void actionPerformedBtnBuscar(ActionEvent arg0) 
	{
		consultarClientes();
	}
	void listar(){
		Cliente c;
		modelo.setRowCount(0);
		for(int i=0;i<cli.tamaño();i++)
		{
			c=cli.obtener(i);
			Object[] fila={	c.getDni(),
							c.getNombre(),
							c.getApellido(),
							c.getTelefono()};
			modelo.addRow(fila);
		}
	}
	void adicionarCliente(){
		String dni=leerDNI();
		if(dni.length()>7&&dni.length()<9)
			try{
			String nombre=leerNombre();
			if(nombre.length()>0)
				try{
				String apellido=leerApellido();
				if(apellido.length()>0)
					try{
					String telefono=leerTelefono();
					if(telefono.length()>5&&telefono.length()<11)
						try{
						Cliente nuevo = new Cliente(dni,nombre,apellido,telefono);
						cli.adicionar(nuevo);
						cli.grabarClientes();
						listar();
						txtDni.setText("");
						txtNombre.setText("");
						txtApellido.setText("");
						txtTelefono.setText("");
						txtDni.requestFocus();
						}
					catch(Exception e){
						error("Ingrese un numero valido ",txtTelefono);
					}
					}
				catch(Exception e){
					error("ingrese su apellido",txtApellido);
				}
				}
			catch(Exception e){
				error("Ingrese su nombre correctamente",txtNombre);
			}
			}
		catch(Exception e){
			error("ingrese su DNI correctamente",txtDni);
		}
	}
	void modificarCliente(){
		try{
			Cliente c= cli.buscar(leerDNI());
			String nombre = leerNombre();
			if(nombre.length()>0)
					try{
						String apellido=leerApellido();
						if(apellido.length()>0)
						try{
							String telefono=leerTelefono();
							if(telefono.length()>5&&telefono.length()<11){
								
							c.setNombre(nombre);
							c.setApellido(apellido);
							c.setTelefono(telefono);
							cli.grabarClientes();
							listar();
							txtDni.requestFocus();}
							else{
								error("error al ingresar su numero",txtTelefono);
								}
						}
						catch(Exception e){
						}
						else{
							error("ingrese su apellido",txtApellido);
						}
					}
					catch(Exception e){
					}
				
				else
					error("Ingrese su nombre correctamente",txtNombre);
		}
		catch(Exception e){
			error("ingrese su numero de DNI correctamente",txtDni);
		}
	}
	void eliminarCliente(){
		try{
			String dni=leerDNI();
			Cliente c=cli.buscar(dni);
			if(c!=null){
				cli.eliminar(c);
				cli.grabarClientes();
				listar();
				txtDni.setText("");
				txtNombre.setText("");
				txtApellido.setText("");
				txtTelefono.setText("");
				txtDni.requestFocus();
			}
			else{
				error("el DNI "+dni+" no esta registrado",txtDni);
			}
		}
		catch(Exception e){
			error("ingrese DNI correcto",txtDni);
		}
	}
	void consultarClientes(){
		try{
			Cliente c=cli.buscar(leerDNI());
			if(c != null){
				txtNombre.setText(c.getNombre());
				txtApellido.setText(""+c.getApellido());
				txtTelefono.setText(""+c.getTelefono());
				txtDni.requestFocus();
			}
			else{
				error("el cliente no se encuentra en el sistema",txtDni);
			}
		}
		catch(Exception e){
			error("ingrese su DNI correctamente",txtDni);
		}
	}
	String leerDNI(){
		return txtDni.getText().trim();
	}
	String leerNombre(){
		return txtNombre.getText().trim();
	}
	String leerApellido(){
		return txtApellido.getText().trim();
	}
	String leerTelefono(){
		return txtTelefono.getText().trim();
	}
	void error(String s,JTextField txt){
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	
	void habilitarEntradas(boolean sino){
		if(tipoOperacion!=ELIMINAR)
			txtDni.setEditable(sino);
		txtNombre.setEditable(sino);
		txtApellido.setEditable(sino);
		txtTelefono.setEditable(sino);
		if(tipoOperacion==ELIMINAR)
			txtDni.setEditable(!sino);
		txtNombre.setEditable(sino);
		txtApellido.setEditable(sino);
		txtTelefono.setEditable(sino);
		
	}
	void habilitarBotones(boolean sino){
		if(tipoOperacion==ADICIONAR)
			btnAceptar.setEnabled(!sino);
			btnVolver.setEnabled(!sino);
			btnBuscar.setEnabled(sino);
			btnModificar.setEnabled(sino);
			btnEliminar.setEnabled(sino);
		if(tipoOperacion==MODIFICAR)
			btnAceptar.setEnabled(!sino);
			btnVolver.setEnabled(!sino);
			btnBuscar.setEnabled(sino);
			btnAdicionar.setEnabled(sino);
			btnEliminar.setEnabled(sino);
		if(tipoOperacion==ELIMINAR)
			btnAceptar.setEnabled(!sino);
			btnVolver.setEnabled(!sino);
			btnModificar.setEnabled(sino);
			btnAdicionar.setEnabled(sino);
			btnBuscar.setEnabled(!sino);
	}
}
