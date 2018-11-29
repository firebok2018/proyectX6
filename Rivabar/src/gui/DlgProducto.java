package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import Arreglos.ArregloProducto;
import clases.Producto;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class DlgProducto extends JDialog {
	private JLabel lblCodigo;
	private JTextField txtCodigo;
	private JLabel lblNombre;
	private JTextField txtNombreP;
	private JLabel lblMarcaProducto;
	private JTextField txtTipoP;
	private JLabel lblNewLabel;
	private JTextField txtStock;
	private JLabel lblPrecioVaso;
	private JTextField txtPrecioV;
	private JLabel lblPrecioBotella;
	private JTextField txtPrecioB;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnGrabar;
	private JScrollPane scrollPane;
	private JTable tblTabla;
	private JButton btnBuscar;
	private JButton btnVolver;
	private DefaultTableModel modelo;
	
	private int tipoOperacion;
	
	public final static int ADICIONAR = 0;
	public final static int MODIFICAR = 1;
	public final static int ELIMINAR= 2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgProducto dialog = new DlgProducto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgProducto() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgProducto.class.getResource("/imagen/upload.png")));
		setTitle("Actualizaci\u00F3n / Producto");
		setBounds(100, 100, 746, 598);
		getContentPane().setLayout(null);
		
		lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(10, 21, 76, 14);
		getContentPane().add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(119, 18, 86, 20);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		lblNombre = new JLabel("Nombre  Producto:");
		lblNombre.setBounds(10, 53, 108, 14);
		getContentPane().add(lblNombre);
		
		txtNombreP = new JTextField();
		txtNombreP.setEditable(false);
		txtNombreP.setBounds(119, 49, 86, 20);
		getContentPane().add(txtNombreP);
		txtNombreP.setColumns(10);
		
		lblMarcaProducto = new JLabel("Tipo Producto:");
		lblMarcaProducto.setBounds(228, 53, 104, 14);
		getContentPane().add(lblMarcaProducto);
		
		txtTipoP = new JTextField();
		txtTipoP.setEditable(false);
		txtTipoP.setBounds(329, 50, 86, 20);
		getContentPane().add(txtTipoP);
		txtTipoP.setColumns(10);
		
		lblNewLabel = new JLabel("Stock:");
		lblNewLabel.setBounds(10, 83, 76, 14);
		getContentPane().add(lblNewLabel);
		
		txtStock = new JTextField();
		txtStock.setEditable(false);
		txtStock.setBounds(119, 80, 86, 20);
		getContentPane().add(txtStock);
		txtStock.setColumns(10);
		
		lblPrecioVaso = new JLabel("Precio Vaso:");
		lblPrecioVaso.setBounds(10, 120, 99, 14);
		getContentPane().add(lblPrecioVaso);
		
		txtPrecioV = new JTextField();
		txtPrecioV.setEditable(false);
		txtPrecioV.setBounds(119, 117, 86, 20);
		getContentPane().add(txtPrecioV);
		txtPrecioV.setColumns(10);
		
		lblPrecioBotella = new JLabel("Precio Botella:");
		lblPrecioBotella.setBounds(229, 120, 103, 14);
		getContentPane().add(lblPrecioBotella);
		
		txtPrecioB = new JTextField();
		txtPrecioB.setEditable(false);
		txtPrecioB.setBounds(329, 117, 86, 20);
		getContentPane().add(txtPrecioB);
		txtPrecioB.setColumns(10);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setIcon(new ImageIcon(DlgProducto.class.getResource("/imagen/plus.png")));
		btnAdicionar.setForeground(Color.BLACK);
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedBtnAdicionar(arg0);
			}
		});
		btnAdicionar.setBounds(585, 25, 125, 28);
		getContentPane().add(btnAdicionar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setIcon(new ImageIcon(DlgProducto.class.getResource("/imagen/workflow.png")));
		btnModificar.setForeground(Color.BLACK);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnModificar(e);
			}
		});
		btnModificar.setBounds(585, 74, 125, 28);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(DlgProducto.class.getResource("/imagen/cancel.png")));
		btnEliminar.setForeground(Color.BLACK);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnEliminar(e);
			}
		});
		btnEliminar.setBounds(585, 120, 125, 28);
		getContentPane().add(btnEliminar);
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.setIcon(new ImageIcon(DlgProducto.class.getResource("/imagen/todo_list.png")));
		btnGrabar.setForeground(Color.BLACK);
		btnGrabar.setEnabled(false);
		btnGrabar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnGrabar(e);
			}
		});
		btnGrabar.setBounds(441, 49, 118, 28);
		getContentPane().add(btnGrabar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 171, 700, 377);
		getContentPane().add(scrollPane);
		
		tblTabla = new JTable();
		tblTabla.setFocusable(false);
		tblTabla.setFillsViewportHeight(true);
		tblTabla.setEnabled(false);
		scrollPane.setViewportView(tblTabla);
		
		modelo= new DefaultTableModel();
		modelo.addColumn("Codigo");
		modelo.addColumn("Nombre");
		modelo.addColumn("Tipo");
		modelo.addColumn("Stock");
		modelo.addColumn("Precio vaso");
		modelo.addColumn("precio Botella");
		
		tblTabla.setModel(modelo);
		ajustarAnchoColumnas();
		listar();
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon(DlgProducto.class.getResource("/imagen/search.png")));
		btnBuscar.setForeground(Color.BLACK);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnBuscar(e);
			}
		});
		btnBuscar.setBounds(319, 14, 108, 28);
		getContentPane().add(btnBuscar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setIcon(new ImageIcon(DlgProducto.class.getResource("/imagen/previous.png")));
		btnVolver.setForeground(Color.BLACK);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnVolver(e);
			}
		});
		btnVolver.setEnabled(false);
		btnVolver.setBounds(441, 96, 118, 28);
		getContentPane().add(btnVolver);
		
	}
	//DECLARACION GLOBAL
	ArregloProducto pro = new ArregloProducto();
	
	
	protected void actionPerformedBtnAdicionar(ActionEvent arg0) 
	{
		tipoOperacion=ADICIONAR;
		txtCodigo.setText(""+pro.codigoCorrelativo());
		txtNombreP.setText("");
		txtTipoP.setText("");
		txtStock.setText("");
		txtPrecioV.setText("");
		txtPrecioB.setText("");
		txtCodigo.setEditable(false);
		habilitarEntradas(true);
		habilitarBotones(false);
		txtNombreP.requestFocus();
	}
	protected void actionPerformedBtnModificar(ActionEvent e) 
	{
		tipoOperacion =	MODIFICAR;
		txtCodigo.setText("");
		txtNombreP.setText("");
		txtTipoP.setText("");
		txtStock.setText("");
		txtPrecioV.setText("");
		txtPrecioB.setText("");
		txtCodigo.setEditable(true);
		habilitarEntradas(true);
		habilitarBotones(false);
		txtCodigo.requestFocus();
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) 
	{
		tipoOperacion =ELIMINAR;
		txtCodigo.setText("");
		txtNombreP.setText("");
		txtTipoP.setText("");
		txtStock.setText("");
		txtPrecioV.setText("");
		txtPrecioB.setText("");
		txtCodigo.setEditable(true);
		habilitarEntradas(false);
		habilitarBotones(false);
		txtNombreP.requestFocus();
	}
	protected void actionPerformedBtnGrabar(ActionEvent e) {
		switch (tipoOperacion){
		case ADICIONAR:
			adicionarProducto();
			break;
		case MODIFICAR:
			modificarProducto();
			break;
		case ELIMINAR:
			eliminarProducto();
		}
	}
	protected void actionPerformedBtnVolver(ActionEvent e) 
	{
		txtCodigo.setText("");
		txtNombreP.setText("");
		txtTipoP.setText("");
		txtStock.setText("");
		txtPrecioV.setText("");
		txtPrecioB.setText("");
		txtCodigo.setEditable(false);
		habilitarEntradas(false);
		habilitarBotones(true);
	}
	protected void actionPerformedBtnBuscar(ActionEvent e) 
	{
		txtCodigo.setEditable(true);
		consultarProductos();
	}
	void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblTabla.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(10));  
		tcm.getColumn(1).setPreferredWidth(anchoColumna(20));  
		tcm.getColumn(2).setPreferredWidth(anchoColumna(20));  
		tcm.getColumn(3).setPreferredWidth(anchoColumna(10)); 
		tcm.getColumn(4).setPreferredWidth(anchoColumna(20));
		tcm.getColumn(5).setPreferredWidth(anchoColumna(20));
	}
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	void listar(){
		Producto p;
		modelo.setRowCount(0);
		for(int i=0;i<pro.tamaño();i++)
		{
			p=pro.obtener(i);
			Object[] fila={	p.getCodigo(),
							p.getNombre(),
							p.getTipo(),
							p.getStock(),
							p.getPrecio_vaso(),
							p.getPrecio_botella()};
			modelo.addRow(fila);
		}
	}
	
	int leerCodigo(){
		return Integer.parseInt(txtCodigo.getText().trim());
	}
	String leerNombreP(){
		return txtNombreP.getText().trim();
	}
	String leerTipoP(){
		return txtTipoP.getText().trim();
	}
	int leerStock(){
		return Integer.parseInt(txtStock.getText().trim());
	}
	double leerPrecioV(){
		return Double.parseDouble(txtPrecioV.getText().trim());
	}
	double leerPrecioB(){
		return Double.parseDouble(txtPrecioB.getText().trim());
	}
	void adicionarProducto(){
		int codigo = leerCodigo();
		
		String nombre = leerNombreP();
		if (nombre.length() > 0){
			String tipo=leerTipoP();
			if(tipo.length()>0){
				int stock=leerStock();
				if(stock>0){
					double precioVaso=leerPrecioV();
					if(precioVaso>0){
						try{
							double precioBotella=leerPrecioB();
							if(precioBotella>0)
							{
								Producto nuevo= new Producto(codigo,nombre,tipo,stock,precioVaso,precioBotella);
								pro.adicionar(nuevo);
								pro.grabarProductos();
								listar();
								txtCodigo.setText("" + pro.codigoCorrelativo());
								txtNombreP.setText("");
								txtTipoP.setText("");
								txtStock.setText("");
								txtPrecioV.setText("");
								txtPrecioB.setText("");
								txtNombreP.requestFocus();
							}
							else{
								error("ingrese el precio por botella",txtPrecioB);
							}
						}
						catch(Exception e){
						}
					}
					else{
						error("ingresar el precio de vaso",txtPrecioV);
					}
				}
				else{
					error("ingrese un numero valido",txtStock);
				}
			}
			else{
				error("ingrese Tipo correcto",txtTipoP);
			}
		}
		else{
			error("Ingrese NOMBRE correcto", txtNombreP);
		}
	}
	void modificarProducto(){
		try{
			Producto x=pro.buscar(leerCodigo());
			String nombre=leerNombreP();
			if(nombre.length()>0)
				try{
					String tipo=leerTipoP();
					if(tipo.length()>0)
						try{
							int stock=leerStock();
							if(stock>0)
								try{
									double preciov=leerPrecioV();
									if(preciov>0)
										try{
											double preciob=leerPrecioB();
											x.setNombre(nombre);
											x.setTipo(tipo);
											x.setStock(stock);
											x.setPrecio_vaso(preciov);
											x.setPrecio_botella(preciob);
											pro.grabarProductos();
											listar();
											txtCodigo.requestFocus();
										}
									catch(Exception e){
										error("ingrese el precio de un vaso para el producto",txtPrecioV);
									}
								}
							catch(Exception e){
								error("ingrese un numero para inicializar stock",txtStock);
							}
						}
					catch(Exception e){
						error("Ingrese un tipo de bebida ",txtTipoP);
					}
				}
			catch(Exception e){
				error("Ingrese un nombre ",txtNombreP);
			}
		}
		catch(Exception e){
			error("Ingrese un codigo de producto ",txtCodigo);
		}
		
	}
	void eliminarProducto(){
		try{
			int codigo=leerCodigo();
			Producto p=pro.buscar(leerCodigo());
			if (p != null){
				pro.eliminar(p);
				pro.grabarProductos();
				listar();
				txtCodigo.setText("");
				txtNombreP.setText("");
				txtTipoP.setText("");
				txtStock.setText("");
				txtPrecioV.setText("");
				txtPrecioB.setText("");
				txtCodigo.requestFocus();
			}
			else{
				error("El código " + codigo + " no existe", txtCodigo);
			}
		}
		catch(Exception e){
			error("Ingrese CÓDIGO correcto", txtCodigo);
		}
	}
	void consultarProductos(){
		try{
			Producto p= pro.buscar(leerCodigo());
			if(p != null){
				txtNombreP.setText(p.getNombre());
				txtTipoP.setText(p.getTipo());
				txtStock.setText(""+p.getStock());
				txtPrecioV.setText(""+p.getPrecio_vaso());
				txtPrecioB.setText(""+p.getPrecio_botella());
				txtCodigo.requestFocus();
			}
			else{
				error("el codigo "+leerCodigo()+" no se encuentra en el sistema",txtCodigo);
			}
		}
		catch(Exception e){
			error("Ingrese CÓDIGO correcto", txtCodigo);
		}
	}
	void habilitarEntradas(boolean sino){
		if(tipoOperacion!=ELIMINAR)
		
		txtNombreP.setEditable(sino);
		txtTipoP.setEditable(sino);
		txtStock.setEditable(!sino);
		txtPrecioV.setEditable(sino);
		txtPrecioB.setEditable(sino);
		if(tipoOperacion==ELIMINAR)
		
		txtNombreP.setEditable(sino);
		txtTipoP.setEditable(sino);
		txtStock.setEditable(sino);
		txtPrecioV.setEditable(sino);
		txtPrecioB.setEditable(sino);
	}
	void habilitarBotones(boolean sino){
		if(tipoOperacion==ADICIONAR)
			btnGrabar.setEnabled(!sino);
			btnVolver.setEnabled(!sino);
			btnBuscar.setEnabled(sino);
			btnModificar.setEnabled(sino);
			btnEliminar.setEnabled(sino);
			btnBuscar.setEnabled(sino);
		if(tipoOperacion==MODIFICAR)
			btnGrabar.setEnabled(!sino);
			btnVolver.setEnabled(!sino);
			btnBuscar.setEnabled(sino);
			btnAdicionar.setEnabled(sino);
			btnEliminar.setEnabled(sino);
		if(tipoOperacion==ELIMINAR)
			btnGrabar.setEnabled(!sino);
			btnVolver.setEnabled(!sino);
			btnModificar.setEnabled(sino);
			btnAdicionar.setEnabled(sino);
			btnBuscar.setEnabled(!sino);
		
	}
	void error(String s,JTextField txt){
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
}
