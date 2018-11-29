package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import mantenimiento.GestionCuentaBancaria;
import mantenimiento.GestionDistrito;
import model.Abastecimiento;
import model.CuentaBancaria;
import model.Distrito;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class FrmDistrito extends JInternalFrame implements ActionListener, MouseListener {
	private JLabel label;
	private JPanel panel;
	private JLabel label_1;
	private JTextField txtCodigo;
	private JLabel lblNombre;
	private JTextField txtNombre;
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
	private JTable tblDistritos;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDistrito frame = new FrmDistrito();
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
	public FrmDistrito() {
		setIconifiable(true);
		setClosable(true);
		setTitle("Distrito");
		setBounds(100, 100, 694, 518);
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
		txtCodigo.setBounds(97, 20, 80, 20);
		panel.add(txtCodigo);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 48, 91, 14);
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);
		txtNombre.setBounds(97, 48, 210, 20);
		panel.add(txtNombre);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setEnabled(false);
		btnBuscar.setBounds(218, 19, 89, 23);
		panel.add(btnBuscar);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Registros", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 204)));
		panel_1.setBounds(10, 164, 654, 247);
		getContentPane().add(panel_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 28, 634, 208);
		panel_1.add(scrollPane);
		
		tblDistritos = new JTable();
		tblDistritos.addMouseListener(this);
		tblDistritos.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblDistritos);
		
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
		modelo.addColumn("Codigo");
		modelo.addColumn("Nombre");
		tblDistritos.setModel(modelo);
		
		listarTable();

	}

	private void listarTable() {
		// TODO Auto-generated method stub
		GestionDistrito g= new GestionDistrito();
		ArrayList<Distrito> Lista=new ArrayList<>();
		Lista=g.listar();
		modelo.setRowCount(0);
		for(Distrito d:Lista) {
			Object[] obj= {d.getCod_dis(),d.getNom_dis() };
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
		txtNombre.setEditable(b);
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
		GestionDistrito ga=new GestionDistrito();
		int estado=ga.eliminar(cod);
		if(estado>0)
			JOptionPane.showMessageDialog(this, "Se eliminó correctamente");
		listarTable();
	}

	private void modificar() {
		
		String nombre=txtNombre.getText();
		String temp=txtCodigo.getText();
		int cod=Integer.parseInt(temp);
		
		//REGEX PARA VALIDAR DATOS
		if(!temp.matches("[1-9]+[0-9]*")){
			JOptionPane.showMessageDialog(this, "Codigo de Producto invalido");
			return;
		}
		if(!nombre.matches("[a-z_A-Z0-9\\s]{3,50}")){
			JOptionPane.showMessageDialog(this, "Descripción debe ser alfanumérico entre 4 y 50 caracteres");
			return;
		}
		//CREAR OBJETO
		Distrito ab= new Distrito();
		ab.setCod_dis(cod);
		ab.setNom_dis(nombre);
		
		//CREAR GESTION PARA STORED PROCEDURE
		GestionDistrito ga= new GestionDistrito();
		int estado=ga.insertar(ab);
		if(estado>0)
			JOptionPane.showMessageDialog(this, "Se actualizo correctamente");	
		//ACTUALIZAR JTABLE
		listarTable();
		
	}

	private void consultar() {
		// TODO Auto-generated method stub
		
	}

	private void adicionar() {
		
		String nombre=txtNombre.getText();
		String temp=txtCodigo.getText();
		int cod=Integer.parseInt(temp);
		
		//REGEX PARA VALIDAR DATOS
		
		//CREAR OBJETO
		Distrito ab= new Distrito();
		ab.setNom_dis(nombre);
		
		//CREAR GESTION PARA STORED PROCEDURE
		GestionDistrito ga= new GestionDistrito();
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
		if (arg0.getSource() == tblDistritos) {
			mouseClickedTblDistritos(arg0);
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
	protected void mouseClickedTblDistritos(MouseEvent arg0) {
		
		int fila=tblDistritos.getSelectedRow();
		int cod=(int) modelo.getValueAt(fila, 0);
		String nombre=(String) modelo.getValueAt(fila, 1);
		txtCodigo.setText(String.valueOf(cod));
		txtNombre.setText(String.valueOf(nombre));
	}
}
