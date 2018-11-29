package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import mantenimiento.GestionCategoria;
import mantenimiento.GestionMarca;
import mantenimiento.GestionProducto;
import model.Categoria;
import model.Marca;
import model.Producto;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class FrmProducto extends JInternalFrame implements ActionListener, MouseListener {
	private JLabel lblMensaje;
	private JPanel panel;
	private JLabel label_1;
	private JTextField txtCodigo;
	private JLabel lblCategora;
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
	private JLabel lblDescripcion;
	private JComboBox cboCategoria;
	private JTextField txtDescripcion;
	private JLabel lblMarca;
	private JComboBox cboMarca;
	private JLabel lblPrecio;
	private JTextField txtPrecio;
	private JLabel lblStockActual;
	private JTextField txtStockActual;
	private JLabel lblStockMnimo;
	private JTextField txtStockMinimo;
	private JLabel lblUnidadMedida;
	private JLabel lblImportado;
	private JComboBox cboImportado;
	private JLabel lblEstado;
	private JComboBox cboEstado;
	private JComboBox cboUnidadMedida;
	private JTable tblTabla;
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
					FrmProducto frame = new FrmProducto();
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
	public FrmProducto() {
		setIconifiable(true);
		setClosable(true);
		setTitle("Producto");
		setBounds(100, 100, 849, 596);
		getContentPane().setLayout(null);
		
		lblMensaje = new JLabel("Seleccione un acci\u00F3n");
		lblMensaje.setOpaque(true);
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensaje.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMensaje.setBackground(new Color(51, 153, 204));
		lblMensaje.setBounds(10, 11, 813, 41);
		getContentPane().add(lblMensaje);
		
		panel = new JPanel();
		panel.setForeground(Color.GRAY);
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 204)));
		panel.setBounds(10, 63, 813, 159);
		getContentPane().add(panel);
		
		label_1 = new JLabel("C\u00F3digo");
		label_1.setBounds(10, 23, 46, 14);
		panel.add(label_1);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(97, 20, 80, 20);
		panel.add(txtCodigo);
		
		lblCategora = new JLabel("Categor\u00EDa");
		lblCategora.setBounds(10, 48, 91, 14);
		panel.add(lblCategora);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setEnabled(false);
		btnBuscar.setBounds(218, 19, 89, 23);
		panel.add(btnBuscar);
		
		lblDescripcion = new JLabel("Descripci\u00F3n");
		lblDescripcion.setBounds(10, 73, 80, 14);
		panel.add(lblDescripcion);
		
		cboCategoria = new JComboBox();
		cboCategoria.setBounds(97, 45, 210, 20);
		panel.add(cboCategoria);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setEditable(false);
		txtDescripcion.setBounds(97, 70, 210, 20);
		panel.add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		lblMarca = new JLabel("Marca");
		lblMarca.setBounds(10, 98, 80, 14);
		panel.add(lblMarca);
		
		cboMarca = new JComboBox();
		cboMarca.setBounds(97, 95, 210, 20);
		panel.add(cboMarca);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(10, 123, 60, 14);
		panel.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(97, 120, 86, 20);
		panel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		lblStockActual = new JLabel("Stock actual");
		lblStockActual.setBounds(367, 23, 80, 14);
		panel.add(lblStockActual);
		
		txtStockActual = new JTextField();
		txtStockActual.setEditable(false);
		txtStockActual.setBounds(463, 20, 86, 20);
		panel.add(txtStockActual);
		txtStockActual.setColumns(10);
		
		lblStockMnimo = new JLabel("Stock m\u00EDnimo");
		lblStockMnimo.setBounds(367, 48, 80, 14);
		panel.add(lblStockMnimo);
		
		txtStockMinimo = new JTextField();
		txtStockMinimo.setEditable(false);
		txtStockMinimo.setBounds(463, 45, 86, 20);
		panel.add(txtStockMinimo);
		txtStockMinimo.setColumns(10);
		
		lblUnidadMedida = new JLabel("Unidad medida");
		lblUnidadMedida.setBounds(367, 73, 91, 14);
		panel.add(lblUnidadMedida);
		
		lblImportado = new JLabel("Importado");
		lblImportado.setBounds(367, 98, 80, 14);
		panel.add(lblImportado);
		
		cboImportado = new JComboBox();
		cboImportado.setBounds(463, 95, 86, 20);
		panel.add(cboImportado);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(367, 123, 67, 14);
		panel.add(lblEstado);
		
		cboEstado = new JComboBox();
		cboEstado.setBounds(463, 120, 86, 20);
		panel.add(cboEstado);
		
		cboUnidadMedida = new JComboBox();
		cboUnidadMedida.setBounds(463, 70, 170, 20);
		panel.add(cboUnidadMedida);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Registros", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 204)));
		panel_1.setBounds(10, 233, 813, 247);
		getContentPane().add(panel_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 28, 793, 208);
		panel_1.add(scrollPane);
		
		tblTabla = new JTable();
		tblTabla.setFillsViewportHeight(true);
		tblTabla.addMouseListener(this);
		scrollPane.setViewportView(tblTabla);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Acciones", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 204)));
		panel_2.setBounds(10, 491, 813, 57);
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
		modelo.addColumn("Cod_Pro");
		modelo.addColumn("Cod_Cat");
		modelo.addColumn("Descripción");
		modelo.addColumn("Cod_mar");
		modelo.addColumn("Precio");
		modelo.addColumn("Stock_act");
		modelo.addColumn("Stock_min");
		modelo.addColumn("Unid_medida");
		modelo.addColumn("Importado");
		modelo.addColumn("Estado");
				
		tblTabla.setModel(modelo);
		listarProductos();
		listarCategorias();
		listarMarcas();
		listarUnidadesMedida();
		listarImportado();
		listarEstados();
	}

	private void listarEstados() {
		cboEstado.addItem("1");
		cboEstado.addItem("2");
		cboEstado.addItem("3");
		
	}

	private void listarImportado() {
		cboImportado.addItem("V");
		cboImportado.addItem("F");
		
	}

	private void listarUnidadesMedida() {
		cboUnidadMedida.addItem("Unidad");
		cboUnidadMedida.addItem("Metro");
		cboUnidadMedida.addItem("Kilo");
		cboUnidadMedida.addItem("Caja");
	}

	private void listarMarcas() {
		ArrayList<Marca> lista=new ArrayList<>();
		GestionMarca gm=new GestionMarca();
		lista=gm.listar();
		cboMarca.addItem("Seleccione marca");
		for (Marca m : lista) {
			cboMarca.addItem(m.getDes_mar());
		}	
		
	}

	private void listarCategorias() {
		ArrayList<Categoria> lista=new ArrayList<>();
		GestionCategoria gc=new GestionCategoria();
		lista=gc.listar();
		cboCategoria.addItem("Seleccione categoría");
		for (Categoria c : lista) {
			cboCategoria.addItem(c.getDes_cat());
		}			
		
	}

	private void listarProductos() {
		ArrayList<Producto> lista=new ArrayList<>();
		GestionProducto gp=new GestionProducto();
		lista=gp.listar();
		modelo.setRowCount(0);
		for (Producto p : lista) {
			Object[] obj={p.getCod_pro(), p.getCod_cat(), p.getDes_pro(), p.getCod_mar(), p.getPre_pro(), p.getSta_pro(), p.getStm_pro(), p.getUnm_pro(), p.getImp_pro(), p.getEst_pro()};
			modelo.addRow(obj);
		}		
		
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(arg0);
		}
		if (arg0.getSource() == btnVolver) {
			actionPerformedBtnVolver(arg0);
		}
		if (arg0.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(arg0);
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
		lblMensaje.setText("Adicionando Producto");		
		habilitarEntradas(true);
		txtCodigo.setText("");		
		txtDescripcion.setText("");
		txtPrecio.setText("");
		txtStockActual.setText("");
		txtStockMinimo.setText("");
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
	protected void actionPerformedBtnConsultar(ActionEvent arg0) {
		tipoOperacion = CONSULTAR;
		lblMensaje.setText("Consultando Producto");
		txtCodigo.setEditable(true);
		habilitarBotones(false);
		txtCodigo.requestFocus();
	}
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		tipoOperacion = MODIFICAR;
		lblMensaje.setText("Modificando Producto");	
		habilitarEntradas(true);
		habilitarBotones(false);
		txtCodigo.setEditable(true);
		txtCodigo.requestFocus();
	}

	private void habilitarEntradas(boolean sino) {
		txtDescripcion.setEditable(sino);
		txtPrecio.setEditable(sino);
		txtStockActual.setEditable(sino);
		txtStockMinimo.setEditable(sino);
		
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		tipoOperacion = ELIMINAR;
		lblMensaje.setText("Eliminando marca");
		txtCodigo.setEditable(true);
		habilitarBotones(false);
		txtCodigo.requestFocus();
	}
	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		switch (tipoOperacion) {
		case ADICIONAR:
		adicionarProducto();
		break;
		case CONSULTAR:
		consultarProducto();
		break;
		case MODIFICAR:
		modificarProducto();
		break;
		case ELIMINAR:
		eliminarProducto();
		}
	}
//ELIMINAR PRODUCTOS---------------------------------------------
	private void eliminarProducto() {
		String cod_tmp=leerCodigo();		
		int cod;
		if(!cod_tmp.matches("[1-9]+[0-9]*")){
			JOptionPane.showMessageDialog(this, "Debe ser numérico mayor que cero");
			return;
		}		
		cod=Integer.parseInt(cod_tmp);						
		GestionProducto gp=new GestionProducto();
		int eliminado=gp.eliminar(cod);
		if(eliminado>0)
			JOptionPane.showMessageDialog(this, "Se eliminó correctamente");
		txtCodigo.setText("");
		txtDescripcion.setText("");
		txtCodigo.requestFocus();
		listarProductos();		
		
	}
//MODIFICAR PRODCUTOS-----------------------------------------------------
	private void modificarProducto() {
		String cod_tmp=leerCodigo();
		int cat=leerCategoria();
		String des=leerDescripcion();
		int mar=cboMarca.getSelectedIndex();
		String pre_tmp=leerPrecio();
		String sta_tmp=leerStockActual();
		String stm_tmp=leerStockMinimo();
		String unm=leerUnidadMedida();
		String imp=leerImportado();
		String est=leerEstado();
		double pre;
		int cod, sta, stm;
		
		if(!cod_tmp.matches("[1-9]+[0-9]*")){
			JOptionPane.showMessageDialog(this, "Código debe ser numérico mayor que cero");
			return;
		}
		if(!des.matches("[a-z_A-Z0-9\\s]{4,50}")){
			JOptionPane.showMessageDialog(this, "Descripción debe ser alfanumérico entre 4 y 50 caracteres");
			return;
		}
		if(!pre_tmp.matches("[0-9]+.*[0-9]*")){
			JOptionPane.showMessageDialog(this, "Precio debe ser válido");
			return;
		}
		if(!sta_tmp.matches("[0-9]+")){
			JOptionPane.showMessageDialog(this, "Stock actual debe ser numérico mayor o igual a cero");
			return;
		}
		if(!stm_tmp.matches("[0-9]+")){
			JOptionPane.showMessageDialog(this, "Stock mínimo debe ser numérico mayor o igual a cero");
			return;
		}
		cod=Integer.parseInt(cod_tmp);
		pre=Double.parseDouble(pre_tmp);
		sta=Integer.parseInt(sta_tmp);
		stm=Integer.parseInt(stm_tmp);
		
		Producto p=new Producto();
		p.setCod_pro(cod);
		p.setCod_cat(cat);
		p.setDes_pro(des);
		p.setCod_mar(mar);
		p.setPre_pro(pre);
		p.setSta_pro(sta);
		p.setStm_pro(stm);
		p.setUnm_pro(unm);
		p.setImp_pro(imp);
		p.setEst_pro(est);
		
		GestionProducto gp=new GestionProducto();
		int actualizado=gp.actualizar(p);
		if(actualizado>0)
			JOptionPane.showMessageDialog(this, "Se actualizó correctamente");
		txtDescripcion.setText("");
		txtDescripcion.requestFocus();		
		listarProductos();		 
		
	}

	private String leerCodigo() {		
		return txtCodigo.getText().trim();
	}

	private void consultarProducto() {
		// TODO Auto-generated method stub
		
	}
	
//INSERTAR PRODUCTOS----------------------------------------------------
	private void adicionarProducto() {		
		int cat=leerCategoria();
		String des=leerDescripcion();
		int mar=cboMarca.getSelectedIndex();
		String pre_tmp=leerPrecio();
		String sta_tmp=leerStockActual();
		String stm_tmp=leerStockMinimo();
		String unm=leerUnidadMedida();
		String imp=leerImportado();
		String est=leerEstado();
		double pre;
		int sta, stm;
		
		if(!des.matches("[a-z_A-Z0-9\\s]{4,50}")){
			JOptionPane.showMessageDialog(this, "Debe ser alfanumérico entre 4 y 50 caracteres");
			return;
		}
		if(!pre_tmp.matches("[0-9]+.*[0-9]*")){
			JOptionPane.showMessageDialog(this, "Debe ser precio válido");
			return;
		}
		if(!sta_tmp.matches("[0-9]+")){
			JOptionPane.showMessageDialog(this, "Debe ser numérico mayor o igual a cero");
			return;
		}
		if(!stm_tmp.matches("[0-9]+")){
			JOptionPane.showMessageDialog(this, "Debe ser numérico mayor o igual a cero");
			return;
		}
		pre=Double.parseDouble(pre_tmp);
		sta=Integer.parseInt(sta_tmp);
		stm=Integer.parseInt(stm_tmp);
		
		Producto p=new Producto();
		p.setCod_cat(cat);
		p.setDes_pro(des);
		p.setCod_mar(mar);
		p.setPre_pro(pre);
		p.setSta_pro(sta);
		p.setStm_pro(stm);
		p.setUnm_pro(unm);
		p.setImp_pro(imp);
		p.setEst_pro(est);
		
		GestionProducto gp=new GestionProducto();
		int insertado=gp.insertar(p);
		if(insertado>0)
			JOptionPane.showMessageDialog(this, "Se insertó correctamente");
		txtDescripcion.setText("");
		txtDescripcion.requestFocus();		
		listarProductos();		
		
	}
//entrada de datos
	private String leerEstado() {		
		return (String) cboEstado.getSelectedItem();
	}

	private String leerImportado() {		
		return (String) cboImportado.getSelectedItem();
	}

	private String leerUnidadMedida() {
		return (String) cboUnidadMedida.getSelectedItem();
	}

	private String leerStockMinimo() {		
		return txtStockMinimo.getText().trim();
	}

	private String leerStockActual() {		
		return txtStockActual.getText().trim();
	}

	private String leerPrecio() {		
		return txtPrecio.getText().trim();
	}

	private int leerCategoria() {
		return cboCategoria.getSelectedIndex();
	}

	private String leerDescripcion() {
		return txtDescripcion.getText().trim();
	}
	protected void actionPerformedBtnVolver(ActionEvent arg0) {
		txtCodigo.setText("");
		txtDescripcion.setText("");
		txtPrecio.setText("");
		txtStockActual.setText("");
		txtStockMinimo.setText("");
		txtCodigo.setEditable(false);
		habilitarEntradas(false);
		habilitarBotones(true);
		lblMensaje.setText("Seleccione una acción");
	}
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == tblTabla) {
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
		
		int fila=tblTabla.getSelectedRow();
		int cod=(int) modelo.getValueAt(fila, 0);
		int cat=(int) modelo.getValueAt(fila, 1);
		String des=(String) modelo.getValueAt(fila, 2);
		int mar=(int) modelo.getValueAt(fila, 3);
		double pre=(double) modelo.getValueAt(fila, 4);
		int sta=(int) modelo.getValueAt(fila, 5);
		int stm=(int) modelo.getValueAt(fila, 6);
		String unm=(String) modelo.getValueAt(fila, 7);
		String imp=(String) modelo.getValueAt(fila, 8);
		String est=(String) modelo.getValueAt(fila, 9);
		
		txtCodigo.setText(String.valueOf(cod));
		cboCategoria.setSelectedIndex(cat);
		txtDescripcion.setText(des);
		cboMarca.setSelectedIndex(mar);
		txtPrecio.setText(String.valueOf(pre));
		txtStockActual.setText(String.valueOf(sta));
		txtStockMinimo.setText(String.valueOf(stm));
		cboUnidadMedida.setSelectedItem(unm);
		cboImportado.setSelectedItem(imp);
		cboEstado.setSelectedItem(est);
	}
	protected void actionPerformedBtnBuscar(ActionEvent arg0) {
		
		FrmConsultaProducto fp= new FrmConsultaProducto();
		FrmPrincipal.desktopPane.add(fp);
		Dimension desktopSize = FrmPrincipal.desktopPane.getSize();
		Dimension FrameSize = fp.getSize();
		fp.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
		fp.setVisible(true);
	}

	private void buscarProducto() {
		// TODO Auto-generated method stub
		
	}
}
