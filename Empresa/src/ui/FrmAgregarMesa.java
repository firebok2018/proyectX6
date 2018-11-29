package ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Arreglos.ArregloMesa;
import ConexionDatabase.ConexionMesa;
import model.Mesa;
import model.Usuarios;
import utils.Conexion;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.FocusListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class FrmAgregarMesa extends JInternalFrame implements FocusListener, ActionListener {
	private JScrollPane scrollPane;
	private JLabel lblNDeMesa;
	private JTextField txtNumMesa;
	private JButton btnAgregar;
	private JLabel label_4;
	private JTextField txtNumSillas;
	private JTable tblMesa;
	private DefaultTableModel default_table;
	
	ConexionMesa conMesa = new ConexionMesa();
	private JButton btnSalir;
	private JTextField txtCodigoMesa;
	private JLabel lblCodigo;
	private JComboBox cboEstado;
	private JLabel lblEstado;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnVolver;
	private JButton btnBuscar;
	private JButton btnAceptar;
	
	private int tipOperacion;
	
	public final static int ADICIONAR = 0;
	public final static int MODIFICAR = 1;
	public final static int ELIMINAR= 2;
	public final static int VOLVER=3;
	public final static int BUSCAR=4;
	public final static int ACEPTAR=5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAgregarMesa frame = new FrmAgregarMesa();
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
	public FrmAgregarMesa() {
		setTitle("Actualizar | Mesa");
		setBounds(100, 100, 485, 356);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 148, 312, 167);
		getContentPane().add(scrollPane);
		
		tblMesa = new JTable();
		scrollPane.setViewportView(tblMesa);
		//Mesa xs= new Mesa();
		
		
		
		lblNDeMesa = new JLabel("N\u00B0 de Mesa:");
		lblNDeMesa.setBounds(21, 48, 59, 14);
		getContentPane().add(lblNDeMesa);
		
		txtNumMesa = new JTextField();
		txtNumMesa.setEnabled(false);
		txtNumMesa.setColumns(10);
		txtNumMesa.setBounds(90, 45, 38, 20);
		getContentPane().add(txtNumMesa);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setIcon(new ImageIcon(FrmAgregarMesa.class.getResource("/imagen/plus.png")));
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(337, 8, 116, 33);
		getContentPane().add(btnAgregar);
		
		label_4 = new JLabel("Sillas:");
		label_4.setBounds(138, 48, 46, 14);
		getContentPane().add(label_4);
		
		txtNumSillas = new JTextField();
		txtNumSillas.setEnabled(false);
		txtNumSillas.setText("4");
		txtNumSillas.setColumns(10);
		txtNumSillas.setBounds(173, 45, 32, 20);
		getContentPane().add(txtNumSillas);
		
		btnSalir = new JButton("Salir");
		btnSalir.setIcon(new ImageIcon(FrmAgregarMesa.class.getResource("/imagen/cerrar.png")));
		btnSalir.addActionListener(this);
		btnSalir.setBounds(337, 201, 116, 33);
		getContentPane().add(btnSalir);
		
		txtCodigoMesa = new JTextField();
		txtCodigoMesa.setEnabled(false);
		txtCodigoMesa.setBounds(90, 14, 115, 20);
		getContentPane().add(txtCodigoMesa);
		txtCodigoMesa.setColumns(10);
		

		
		lblCodigo = new JLabel("CODIGO:");
		lblCodigo.setBounds(20, 20, 46, 14);
		getContentPane().add(lblCodigo);
		
		cboEstado = new JComboBox();
		cboEstado.setEnabled(false);
		cboEstado.addActionListener(this);
		cboEstado.addFocusListener(this);
		cboEstado.setBounds(90, 76, 115, 20);
		getContentPane().add(cboEstado);
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(20, 73, 50, 14);
		getContentPane().add(lblEstado);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setIcon(new ImageIcon(FrmAgregarMesa.class.getResource("/imagen/engineering.png")));
		btnModificar.setBounds(337, 92, 116, 33);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setIcon(new ImageIcon(FrmAgregarMesa.class.getResource("/imagen/delete_database.png")));
		btnEliminar.setBounds(337, 140, 116, 33);
		getContentPane().add(btnEliminar);
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(this);
		btnVolver.setVisible(false);
		btnVolver.setIcon(new ImageIcon(FrmAgregarMesa.class.getResource("/imagen/previous.png")));
		btnVolver.setBounds(215, 92, 116, 33);
		getContentPane().add(btnVolver);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setVisible(false);
		btnBuscar.setIcon(new ImageIcon(FrmAgregarMesa.class.getResource("/imagen/search.png")));
		btnBuscar.setBounds(215, 8, 116, 33);
		getContentPane().add(btnBuscar);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setVisible(false);
		btnAceptar.setIcon(new ImageIcon(FrmAgregarMesa.class.getResource("/imagen/ok.png")));
		btnAceptar.setBounds(337, 48, 116, 33);
		getContentPane().add(btnAceptar);
		
		//Conectiun();
		listar();

	}
	public void focusGained(FocusEvent arg0) {
		if (arg0.getSource() == cboEstado) {
			focusGainedCboEstado(arg0);
		}
	}
	public void focusLost(FocusEvent arg0) {
	}
	String CodeMesa(){return txtCodigoMesa.getText();}
	int NumeroMesa(){ return Integer.parseInt(txtNumMesa.getText()); }
	int NumeroSilla(){ return Integer.parseInt(txtNumSillas.getText()); }
	void mensaje(String s){	JOptionPane.showMessageDialog(this,  s); }
	void error(String x,JTextField j){
		mensaje(x);
		j.setText(null);
		j.requestFocus();
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(arg0);
		}
		if (arg0.getSource() == btnVolver) {
			actionPerformedBtnVolver(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(arg0);
		}
		if (arg0.getSource() == cboEstado) {
			actionPerformedCboEstado(arg0);
		}
		if (arg0.getSource() == btnSalir) {
			actionPerformedBtnSalir(arg0);
		}
		if (arg0.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(arg0);
		}
	}
	protected void actionPerformedBtnAgregar(ActionEvent arg0) {
		tipOperacion=ADICIONAR;
		habilitarBoton(false);
		habilitarEntrada(true);
		
	}
	protected void actionPerformedBtnSalir(ActionEvent arg0) {
		dispose();
	}
	void limpiar(){
		
	}
	
	String CodigoMesa(){
		return txtCodigoMesa.getText().trim();
	}
	int Estado(){return cboEstado.getSelectedIndex();}
	protected void focusGainedCboEstado(FocusEvent arg0) {
		
	}
	protected void actionPerformedCboEstado(ActionEvent arg0) {
		System.out.println(cboEstado.getSelectedItem());
	}
	public void Conectiun(){
		//public static int x;
		Timer t= new Timer();
		TimerTask conex= new  TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				//x++;
				System.out.println("Coneccion");
				//
			}
		};
		t.schedule(conex, 0,1000);
			
	}
	public void listar(){
		conMesa.Listar( tblMesa);
		conMesa.EstadoMesa(cboEstado);
	}
	void habilitarBoton(Boolean not){
		if(tipOperacion==ADICIONAR){
			btnAceptar.setVisible(!not);
			
			
			btnAgregar.setEnabled(not);
			btnModificar.setEnabled(not);
			btnEliminar.setEnabled(not);
			btnVolver.setVisible(!not);
		}
		if(tipOperacion==VOLVER){
			btnAceptar.setVisible(!not);
			btnVolver.setVisible(!not);
			btnBuscar.setVisible(!not);
			btnAgregar.setEnabled(not);
			btnModificar.setEnabled(not);
			btnEliminar.setEnabled(not);
			
		}if(tipOperacion==MODIFICAR){
			btnModificar.setEnabled(not);
			btnEliminar.setEnabled(not);
			btnAgregar.setEnabled(not);
			btnAceptar.setVisible(!not);
			btnVolver.setVisible(!not);
			btnBuscar.setVisible(!not);
		}if(tipOperacion==ELIMINAR){
			btnEliminar.setEnabled(!not);
			btnModificar.setEnabled(!not);
			btnAgregar.setEnabled(!not);
			btnVolver.setVisible(not);
			btnBuscar.setVisible(not);
			btnAceptar.setVisible(not);
		}
	}
	void habilitarEntrada(Boolean yes){
		if(tipOperacion==ADICIONAR){
			txtCodigoMesa.setEnabled(yes);
			txtNumMesa.setEnabled(yes);
			txtNumSillas.setEnabled(yes);
			cboEstado.setEnabled(yes);
			txtNumMesa.requestFocus();
		}
		if(tipOperacion==MODIFICAR){
			txtCodigoMesa.setEnabled(yes);
			txtNumMesa.setEnabled(yes);
			txtNumSillas.setEnabled(yes);
			cboEstado.setEnabled(yes);
			txtNumMesa.requestFocus();
		}
		if(tipOperacion==VOLVER){
			txtCodigoMesa.setEnabled(!yes);
			txtNumMesa.setEnabled(!yes);
			txtNumSillas.setEnabled(!yes);
			cboEstado.setEnabled(!yes);
			limpiar();
		}
		if(tipOperacion==ELIMINAR){
			txtNumMesa.setEnabled(yes);
			txtNumMesa.requestFocus();
		}
	}
	protected void actionPerformedBtnBuscar(ActionEvent arg0) {
		tipOperacion=BUSCAR;
	}
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		tipOperacion=MODIFICAR;
		habilitarBoton(false);
		habilitarEntrada(true);
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		tipOperacion=ELIMINAR;
		habilitarBoton(true);
		habilitarEntrada(true);
	}
	protected void actionPerformedBtnVolver(ActionEvent arg0) {
		tipOperacion=VOLVER;
		habilitarBoton(true);
		habilitarEntrada(true);
	}
	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		switch (tipOperacion){
		case ADICIONAR:
			agregarMesa();
			break;
		case MODIFICAR:
			modificarMesa();
			break;
		case ELIMINAR:
			eliminarMesa();
			break;
		
		case BUSCAR:
			buscar();
			break;
		}	
			
	}
	void buscar(){
		
	}
	void agregarMesa(){
		System.out.println("Agregando mesa");
		String c=CodigoMesa();
		if (c.length()==0||c.length()>5||c.length()<5) {
			mensaje("Ingrese un codigo de 5 caracteres.");
		}else{
			
		
			try {
				 int m = NumeroMesa();
				 String s=txtNumMesa.getText();
				 if (s.length()==0|| m<=0 || m>=26 || s.length()>=3||m==0) {
					 error("ingrese un numero valido", txtNumMesa);
					}else{
						int n= NumeroSilla();
						String t=txtNumSillas.getText();
						if (n!=0||t.length()!=0) {
							Mesa xMesa = new Mesa(CodeMesa(), NumeroMesa(), NumeroSilla(), Estado());

							if(conMesa.add_mesa(xMesa)){
								limpiar();
								System.out.println("Agregado");	
								listar();
								txtCodigoMesa.setText("M"+CodigoMesa());
								
							}else{
								//limpiar();
								System.out.println("no se Agregado");	
							}
							
												
						}else{
							error("ingrese un numero valido", txtNumSillas);
						}
				}
				
			} catch (NumberFormatException e) {
				// TODO: handle exception
				error("Ingrese un numero de mesa", txtNumMesa);
			}
		}
	}
	void modificarMesa(){
		System.out.println("modificando mesa");
		String c=CodigoMesa();
		if (c.length()==0||c.length()>5||c.length()<5) {
			mensaje("Ingrese un codigo de 5 caracteres.");
		}else{
			
		
			try {
				 int m = NumeroMesa();
				 String s=txtNumMesa.getText();
				 if (s.length()==0|| m<=0 || m>=26 || s.length()>=3||m==0) {
					 error("ingrese un numero valido", txtNumMesa);
					}else{
						int n= NumeroSilla();
						String t=txtNumSillas.getText();
						if (n!=0||t.length()!=0) {
							Mesa yMesa = new Mesa(CodeMesa(), NumeroMesa(), NumeroSilla(), Estado());

							if(conMesa.update_Mesa(yMesa)){
								limpiar();
								System.out.println("Modificado");	
								listar();
								txtCodigoMesa.setText("M"+CodigoMesa());
								
							}else{
								//limpiar();
								System.out.println("no se Agregado");	
							}
							
												
						}else{
							error("ingrese un numero valido", txtNumSillas);
						}
				}
				
			} catch (NumberFormatException e) {
				// TODO: handle exception
				error("Ingrese un numero de mesa", txtNumMesa);
			}
		}
	}
	void eliminarMesa(){
		System.out.println("eliminado mesa");
		try {
			int x=NumeroMesa();
			if (x!=0) {
				Mesa z=new Mesa(x);
				if (conMesa.delete_Mesa(z)) {
					mensaje("Numero de Mesa "+x+" Se ha Eliminado");
					limpiar();
					listar();
				}else{
					mensaje("sdasd");
				}
			}else{
				error("Ingrese un numero Valido !", txtNumMesa);
			}
		} catch (Exception e) {
			// TODO: handle exception
			mensaje(e.getMessage());
		}
	}
}
