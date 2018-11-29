package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import mantenimiento.GestionCategoria;
import mantenimiento.GestionCliente;
import mantenimiento.GestionDistrito;
import mantenimiento.GestionProducto;
import model.Categoria;
import model.Cliente;
import model.Distrito;
import model.Producto;

import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import javax.swing.DefaultComboBoxModel;

public class FrmCliente extends JInternalFrame implements ActionListener, MouseListener {
	private JLabel lblMensaje;
	private JPanel panel;
	private JLabel label_1;
	private JTextField txtCodigo;
	private JLabel lblRasnSocial;
	private JButton btnBuscar;
	private JLabel lblRucDni;
	private JTextField txtRucDni;
	private JLabel lblDireccin;
	private JLabel lblDistrito;
	private JLabel lblTelfono;
	private JLabel lblEmail;
	private JTextField txtEmail;
	private JLabel lblTipo;
	private JTextField txtDireccion;
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
	private JTextField txtRsNombre;
	private JComboBox cboDistrito;
	private JComboBox cboTipo;
	private JTextField txtTelefono;
	private JTable tblClientes;
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
					FrmCliente frame = new FrmCliente();
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
	public FrmCliente() {
		setIconifiable(true);
		setClosable(true);
		setTitle("Cliente");
		setBounds(100, 100, 918, 592);
		getContentPane().setLayout(null);
		
		lblMensaje = new JLabel("Seleccione un acci\u00F3n");
		lblMensaje.setOpaque(true);
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensaje.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMensaje.setBackground(new Color(51, 153, 204));
		lblMensaje.setBounds(10, 11, 881, 41);
		getContentPane().add(lblMensaje);
		
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
		txtCodigo.setBounds(97, 20, 121, 20);
		panel.add(txtCodigo);
		
		lblRasnSocial = new JLabel("R.S. / Nombre");
		lblRasnSocial.setBounds(10, 48, 91, 14);
		panel.add(lblRasnSocial);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setEnabled(false);
		btnBuscar.setBounds(257, 19, 89, 23);
		panel.add(btnBuscar);
		
		lblRucDni = new JLabel("RUC / DNI");
		lblRucDni.setBounds(10, 73, 80, 14);
		panel.add(lblRucDni);
		
		txtRucDni = new JTextField();
		txtRucDni.setEditable(false);
		txtRucDni.setColumns(10);
		txtRucDni.setBounds(97, 70, 121, 20);
		panel.add(txtRucDni);
		
		lblDireccin = new JLabel("Direcci\u00F3n");
		lblDireccin.setBounds(10, 98, 80, 14);
		panel.add(lblDireccin);
		
		lblDistrito = new JLabel("Distrito");
		lblDistrito.setBounds(10, 123, 60, 14);
		panel.add(lblDistrito);
		
		lblTelfono = new JLabel("Tel\u00E9fono");
		lblTelfono.setBounds(413, 23, 60, 14);
		panel.add(lblTelfono);
		
		lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(413, 48, 60, 14);
		panel.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setColumns(10);
		txtEmail.setBounds(483, 45, 203, 20);
		panel.add(txtEmail);
		
		lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(413, 73, 51, 14);
		panel.add(lblTipo);
		
		txtDireccion = new JTextField();
		txtDireccion.setEditable(false);
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(97, 95, 249, 20);
		panel.add(txtDireccion);
		
		txtRsNombre = new JTextField();
		txtRsNombre.setEditable(false);
		txtRsNombre.setBounds(97, 45, 249, 20);
		panel.add(txtRsNombre);
		txtRsNombre.setColumns(10);
		
		cboDistrito = new JComboBox();
		cboDistrito.setBounds(97, 120, 249, 20);
		panel.add(cboDistrito);
		
		cboTipo = new JComboBox();
		cboTipo.setBounds(483, 70, 106, 20);
		panel.add(cboTipo);
		
		txtTelefono = new JTextField();
		txtTelefono.setEditable(false);
		txtTelefono.setBounds(483, 20, 106, 20);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Registros", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 204)));
		panel_1.setBounds(10, 233, 881, 247);
		getContentPane().add(panel_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 28, 861, 208);
		panel_1.add(scrollPane);
		
		tblClientes = new JTable();
		tblClientes.addMouseListener(this);
		tblClientes.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblClientes);
		
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
		
	//establecer campos de tabla
		
		modelo=new DefaultTableModel();
		modelo.addColumn("Codigo");
		modelo.addColumn("Razon o Nombre");
		modelo.addColumn("Ruc o DNI");
		modelo.addColumn("Dirección");
		modelo.addColumn("Codigo Distrito");
		modelo.addColumn("Teléfono");
		modelo.addColumn("email");
		modelo.addColumn("Tipo de Cliente");
		tblClientes.setModel(modelo);
		
	//metodos que deben cargarse con el constructor
		
		listarDistritos();
		listarTipoCliente();
		listarCliente();

	}

	private void listarDistritos() {
		
		GestionDistrito gd= new GestionDistrito();
		ArrayList<Distrito> Lista=new ArrayList<>();
		Lista=gd.listar();
		cboDistrito.addItem("Seleccione Distrito");
		for(Distrito d:Lista) {
			cboDistrito.addItem(d.getNom_dis());
		}	
	}
	private void listarTipoCliente() {
		
		GestionCliente gc=new GestionCliente();
		ArrayList<Cliente> Lista = new ArrayList<>();
		Lista = gc.listar();
		cboTipo.addItem("Seleccione tipo");
		for(Cliente c:Lista) {
			cboTipo.addItem(c.getTip_cli());
		}
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(e);
		}
		if (e.getSource() == btnVolver) {
			actionPerformedBtnVolver(e);
		}
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(e);
		}
	}
	protected void actionPerformedBtnAdicionar(ActionEvent e) {
		tipoOperacion = ADICIONAR;
		lblMensaje.setText("Adicionando Cliente");		
		habilitarEntradas(true);
		txtCodigo.setText("");		
		txtRsNombre.setText("");
		txtRucDni.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
		txtEmail.setText("");
		habilitarBotones(false);
		txtRsNombre.requestFocus();
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
		
		txtRsNombre.setEditable(b);
		txtEmail.setEditable(b);
		txtRucDni.setEditable(b);
		txtDireccion.setEditable(b);
		txtTelefono.setEditable(b);
	}

	protected void actionPerformedBtnModificar(ActionEvent e) {
		tipoOperacion = MODIFICAR;
		lblMensaje.setText("Modificando Cliente");	
		habilitarEntradas(true);
		habilitarBotones(false);
		txtCodigo.setEditable(true);
		txtCodigo.requestFocus();
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		tipoOperacion = ELIMINAR;
		lblMensaje.setText("Eliminando Cliente");
		txtCodigo.setEditable(true);
		habilitarBotones(false);
		txtCodigo.requestFocus();
	}
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		switch (tipoOperacion) {
		case ADICIONAR:
		adicionarCliente();
		break;
		case CONSULTAR:
		consultarCliente();
		break;
		case MODIFICAR:
		modificarCliente();
		break;
		case ELIMINAR:
		eliminarCliente();
		}
	}
	private void eliminarCliente() {
		
		String cod_tmp=leerCodigo();		
		int cod;
		if(!cod_tmp.matches("[0-9]{1,3}")){
			JOptionPane.showMessageDialog(this, "Codigo Debe ser numérico mayor que cero");
			return;
		}		
		cod=Integer.parseInt(cod_tmp);						
		GestionCliente gc=new GestionCliente();
		int eliminado=gc.eliminar(cod);
		if(eliminado>0)
			JOptionPane.showMessageDialog(this, "Se eliminó correctamente");
		txtCodigo.setText("");
		txtRsNombre.setText("");
		txtCodigo.requestFocus();
		listarCliente();	
	}

	private void listarCliente() {
		
		GestionCliente gc=new GestionCliente();
		ArrayList<Cliente> Lista = new ArrayList<>();
		Lista = gc.listar();
		modelo.setRowCount(0);
		for(Cliente c:Lista) {
			Object[] obj={c.getCod_cli(),c.getRsn_cli(),c.getRdn_cli(),c.getDir_cli(),c.getCod_dis(),c.getTel_cli(),c.getEma_cli(),c.getTip_cli()};
			modelo.addRow(obj);
		}		
	}

	private String leerCodigo() {
		
		return txtCodigo.getText();
	}
	private String leerNombre() {
		
		return txtRsNombre.getText();
	}

	private void modificarCliente() {
		
		String cod_tmp=leerCodigo();	
		String nom=leerNombre();
		String tel=leerTelefono();	
		String email=leerEmail();
		String direc=leerDireccion();
		String ruc=leerRuc();
		
		
		if(!cod_tmp.matches("[0-9]{1,3}")){
			JOptionPane.showMessageDialog(this, "Codigo Debe ser numérico mayor que cero");
			return;
		}
		if(!nom.matches("[a-z_A-Z0-9\\s]{3,50}")){
			JOptionPane.showMessageDialog(this, "Nombre debe tener entre 3 y 50 caracteres");
			return;
		}
		if(!tel.matches("[0-9]{11}||[0-9]{8}")){
			JOptionPane.showMessageDialog(this, "RUC o DNI debe ser válido");
			return;
		}
		if(!email.matches("[0-9]+")){
			JOptionPane.showMessageDialog(this, "Stock actual debe ser numérico mayor o igual a cero");
			return;
		}
		if(!direc.matches("[a-z_A-Z0-9\\\\s]{3,50}")){
			JOptionPane.showMessageDialog(this, "Direccion debe ser alfanumerico entre 3 y 50 caracteres");
			return;
		}
		int dis=cboDistrito.getSelectedIndex();
		String tipo=String.valueOf(cboTipo.getSelectedIndex());
		int cod;
		cod=Integer.parseInt(cod_tmp);
		
		Cliente c=new Cliente();
		c.setCod_cli(cod);
		c.setRsn_cli(nom);
		c.setRdn_cli(ruc);
		c.setCod_dis(dis);
		c.setTel_cli(tel);
		c.setTip_cli(tipo);
		c.setEma_cli(email);
		c.setDir_cli(direc);
		
		GestionCliente gc=new GestionCliente();
		int actualizado=gc.actualizar(c);
		ArrayList<Cliente> Lista = new ArrayList<>();
		if(actualizado>0)
			JOptionPane.showMessageDialog(this, "Se actualizó correctamente");		
		Lista = gc.listar();
		for(Cliente cl:Lista) {
			cboTipo.addItem(cl.getTip_cli());
		}
		txtRsNombre.setText("");
		txtDireccion.setText("");
		txtEmail.setText("");
		txtRucDni.setText("");
		txtRsNombre.requestFocus();
		listarCliente();		 		
	}

	private String leerRuc() {
		
		return txtRucDni.getText();
	}

	private String leerDireccion() {
	
		return txtDireccion.getText();
	}

	private String leerEmail() {
		
		return txtEmail.getText();
	}

	private String leerTelefono() {
		
		return txtTelefono.getText();
	}

	private void consultarCliente() {
		// TODO Auto-generated method stub
		
	}

	private void adicionarCliente() {
			
		String nom=leerNombre();
		String tel=leerTelefono();	
		String email=leerEmail();
		String direc=leerDireccion();
		String ruc=leerRuc();
		
		
		if(!nom.matches("[a-z_A-Z0-9\\s]{3,50}")){
			JOptionPane.showMessageDialog(this, "Nombre debe tener entre 3 y 50 caracteres");
			return;
		}
		if(!ruc.matches("[0-9]{11}||[0-9]{8}")){
			JOptionPane.showMessageDialog(this, "RUC o DNI debe ser válido");
			return;
		}
		if(!tel.matches("[0-9]{9}")){
			JOptionPane.showMessageDialog(this, "RUC o DNI debe ser válido");
			return;
		}
		
		//VALIDACION DE CORREO
		if(!email.matches("[a-z0-9]+")){
			JOptionPane.showMessageDialog(this, "Email debe ser valido");
			return;
		}
		if(!direc.matches("[a-z_A-Z0-9\\\\s]{3,50}")){
			JOptionPane.showMessageDialog(this, "Direccion debe ser alfanumerico entre 3 y 50 caracteres");
			return;
		}
		int dis=cboDistrito.getSelectedIndex();
		String tipo=String.valueOf(cboTipo.getSelectedIndex());
		Cliente c=new Cliente();
		c.setRsn_cli(nom);
		c.setRdn_cli(ruc);
		c.setCod_dis(dis);
		c.setTel_cli(tel);
		c.setTip_cli(tipo);
		c.setEma_cli(email);
		c.setDir_cli(direc);
		
		GestionCliente gc=new GestionCliente();
		int actualizado=gc.insertar(c);
		if(actualizado>0)
			JOptionPane.showMessageDialog(this, "Se inserto correctamente");		

		txtRsNombre.setText("");
		txtDireccion.setText("");
		txtEmail.setText("");
		txtRucDni.setText("");
		txtRsNombre.requestFocus();
		listarCliente();		 	
	}

	protected void actionPerformedBtnVolver(ActionEvent e) {
		txtCodigo.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
		txtEmail.setText("");
		txtRucDni.setText("");
		habilitarEntradas(false);
		habilitarBotones(true);
		lblMensaje.setText("Seleccione una acción");
		
	}
	
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == tblClientes) {
			mouseClickedTblClientes(arg0);
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
	protected void mouseClickedTblClientes(MouseEvent arg0) {
		
		int fila=tblClientes.getSelectedRow();
		int cod=(int) modelo.getValueAt(fila, 0);
		String rsn=(String) modelo.getValueAt(fila, 1);
		String ruc=(String) modelo.getValueAt(fila, 2);
		String dir=(String) modelo.getValueAt(fila, 3);
		int dis=(int) modelo.getValueAt(fila, 4);
		String tel=(String) modelo.getValueAt(fila, 5);
		String email=(String) modelo.getValueAt(fila, 6);
		//int tipo=(int) modelo.getValueAt(fila, 7);
		
		txtCodigo.setText(String.valueOf(cod));
		txtRsNombre.setText((rsn));
		txtRucDni.setText((ruc));
		txtDireccion.setText(dir);
		cboDistrito.setSelectedIndex(dis);
		//cboTipo.setSelectedItem(tipo);
		txtTelefono.setText(tel);
		txtEmail.setText(email);
	}
	protected void actionPerformedBtnConsultar(ActionEvent e) {
		tipoOperacion = CONSULTAR;
		lblMensaje.setText("Consultando");
		txtCodigo.setEditable(true);
		habilitarBotones(false);
		txtCodigo.requestFocus();
		
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
