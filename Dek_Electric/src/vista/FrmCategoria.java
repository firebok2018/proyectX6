package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.table.DefaultTableModel;

import mantenimiento.GestionCategoria;
import model.Categoria;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class FrmCategoria extends JInternalFrame implements ActionListener, MouseListener {
	private JLabel lblMensaje;
	private JPanel panel;
	private JLabel lblCdigo;
	private JTextField txtCodigo;
	private JLabel lblDescripcin;
	private JTextField txtDescripcion;
	private JPanel panel_1;
	private JScrollPane scrollPane;
	private JTable tblCategorias;
	private JPanel panel_2;
	private JButton btnAdicionar;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnAceptar;
	private JButton btnVolver;
	private JSeparator separator;
	private JButton btnBuscar;
	private DefaultTableModel modelo;

	// Tipo de operación a procesar:
	// Adicionar, Modificar, Eliminar o Consultar
	private int tipoOperacion;
	// Constantes para los tipos de operaciones
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
					FrmCategoria frame = new FrmCategoria();
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
	public FrmCategoria() {
		setIconifiable(true);
		setTitle("Categor\u00EDa");
		setClosable(true);
		setBounds(100, 100, 690, 517);
		getContentPane().setLayout(null);
		
		lblMensaje = new JLabel("Seleccione un acci\u00F3n");
		lblMensaje.setBackground(new Color(51, 153, 204));
		lblMensaje.setOpaque(true);
		lblMensaje.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensaje.setBounds(10, 11, 654, 41);
		getContentPane().add(lblMensaje);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 204)));
		panel.setBounds(10, 63, 654, 90);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setBounds(10, 23, 46, 14);
		panel.add(lblCdigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(97, 20, 80, 20);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		lblDescripcin = new JLabel("Descripci\u00F3n");
		lblDescripcin.setBounds(10, 48, 91, 14);
		panel.add(lblDescripcin);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setEditable(false);
		txtDescripcion.setBounds(97, 48, 210, 20);
		panel.add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setEnabled(false);
		btnBuscar.setBounds(218, 19, 89, 23);
		panel.add(btnBuscar);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Registros", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 204)));
		panel_1.setBounds(10, 164, 654, 247);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 28, 634, 208);
		panel_1.add(scrollPane);
		
		tblCategorias = new JTable();
		tblCategorias.addMouseListener(this);
		tblCategorias.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblCategorias);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Acciones", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 204)));
		panel_2.setBounds(10, 419, 654, 57);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
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
		btnAceptar.setEnabled(false);
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(456, 23, 89, 23);
		panel_2.add(btnAceptar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setEnabled(false);
		btnVolver.addActionListener(this);
		btnVolver.setBounds(555, 23, 89, 23);
		panel_2.add(btnVolver);
		
		separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(427, 23, 2, 23);
		panel_2.add(separator);
		
		modelo=new DefaultTableModel();
		modelo.addColumn("Código");
		modelo.addColumn("Descripción");
		tblCategorias.setModel(modelo);
		
		listarCategorias();
	}

	private void listarCategorias() {
		ArrayList<Categoria> lista=new ArrayList<>();
		GestionCategoria gc=new GestionCategoria();
		lista=gc.listar();
		modelo.setRowCount(0);
		for (Categoria c : lista) {
			Object[] obj={c.getCod_cat(), c.getDes_cat()};
			modelo.addRow(obj);
		}
		
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(arg0);
		}
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
		if (arg0.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(arg0);
		}
	}
	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		tipoOperacion = ADICIONAR;
		lblMensaje.setText("Adicionando categoría");
		txtCodigo.setText("");
		txtDescripcion.setEditable(true);
		txtDescripcion.setText("");		
		habilitarBotones(false);
		txtDescripcion.requestFocus();
	}

	private void habilitarBotones(boolean sino) {
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

	private void habilitarEntradas(boolean sino) {
		txtDescripcion.setEditable(sino);
		txtCodigo.setEditable(sino);
	}
	protected void actionPerformedBtnConsultar(ActionEvent arg0) {
		tipoOperacion = CONSULTAR;
		lblMensaje.setText("Consultando categoría");
		txtCodigo.setEditable(true);
		habilitarBotones(false);
		txtCodigo.requestFocus();
	}
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		tipoOperacion = MODIFICAR;
		lblMensaje.setText("Modificando categoría");	
		habilitarEntradas(true);
		habilitarBotones(false);
		txtCodigo.requestFocus();
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		tipoOperacion = ELIMINAR;
		lblMensaje.setText("Eliminando categoría");
		txtCodigo.setEditable(true);
		habilitarBotones(false);
		txtCodigo.requestFocus();
	}
	protected void actionPerformedBtnVolver(ActionEvent arg0) {
		txtCodigo.setText("");
		txtDescripcion.setText("");				
		//txtCodigo.setEditable(false);
		habilitarEntradas(false);
		habilitarBotones(true);
		lblMensaje.setText("Seleccione una acción");
	}
	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		switch (tipoOperacion) {
		case ADICIONAR:
		adicionarCategoria();
		break;
		case CONSULTAR:
		consultarCategoria();
		break;
		case MODIFICAR:
		modificarCategoria();
		break;
		case ELIMINAR:
		eliminarCategoria();
		}
	}

	private void eliminarCategoria() {
		String cod_tmp=leerCodigo();		
		int cod;
		if(!cod_tmp.matches("[0-9]+")){
			JOptionPane.showMessageDialog(this, "Debe ser numérico mayor que cero");
			return;
		}		
		cod=Integer.parseInt(cod_tmp);						
		GestionCategoria gc=new GestionCategoria();
		int eliminado=gc.eliminar(cod);
		if(eliminado>0)
			JOptionPane.showMessageDialog(this, "Se eliminó correctamente");
		txtCodigo.setText("");
		txtDescripcion.setText("");
		txtCodigo.requestFocus();
		listarCategorias();
		
	}

	private void modificarCategoria() {
		String cod_tmp=leerCodigo();
		String des=leerDescripcion();
		int cod;
		if(!cod_tmp.matches("[0-9]+")){
			JOptionPane.showMessageDialog(this, "Debe ser numérico mayor que cero");
			return;
		}
		if(!des.matches("[a-z_A-Z0-9\\s]{4,50}")){
			JOptionPane.showMessageDialog(this, "Debe ser alfanumérico entre 4 y 40 caracteres");
			return;
		}
		cod=Integer.parseInt(cod_tmp);
		Categoria c=new Categoria();
		c.setCod_cat(cod);
		c.setDes_cat(des);
		GestionCategoria gc=new GestionCategoria();
		int actualizado=gc.actualizar(c);
		if(actualizado>0)
			JOptionPane.showMessageDialog(this, "Se actualizó correctamente");
		txtCodigo.setText("");
		txtDescripcion.setText("");
		txtDescripcion.requestFocus();		
		listarCategorias();
		
	}

	private String leerCodigo() { 
		return txtCodigo.getText().trim();
	}

	private void consultarCategoria() {
		// TODO Auto-generated method stub
		
	}

	private void adicionarCategoria() {
		String des=leerDescripcion();
		if(!des.matches("[a-z_A-Z0-9\\s]{4,50}")){
			JOptionPane.showMessageDialog(this, "Debe ser alfanumérico entre 4 y 40 caracteres");
			return;
		}
		Categoria c=new Categoria();		
		c.setDes_cat(des);
		GestionCategoria gc=new GestionCategoria();
		int insetardo=gc.insertar(c);
		if(insetardo>0)
			JOptionPane.showMessageDialog(this, "Se insertó correctamente");
		txtDescripcion.setText("");
		txtDescripcion.requestFocus();		
		listarCategorias();
	}

	private String leerDescripcion() {		
		return txtDescripcion.getText().trim();
	}
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == tblCategorias) {
			mouseClickedTblTabla(arg0);
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
	protected void mouseClickedTblTabla(MouseEvent arg0) {
		int fila=tblCategorias.getSelectedRow();
		int cod=(int) modelo.getValueAt(fila, 0);
		String des=(String) modelo.getValueAt(fila, 1);
		txtCodigo.setText(String.valueOf(cod));
		txtDescripcion.setText(des);
	}
	protected void actionPerformedBtnBuscar(ActionEvent arg0) {
		
		FrmConsultaProducto fp= new FrmConsultaProducto();
		FrmPrincipal.desktopPane.add(fp);
		Dimension desktopSize = FrmPrincipal.desktopPane.getSize();
		Dimension FrameSize = fp.getSize();
		fp.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
		fp.setVisible(true);
	}
}
