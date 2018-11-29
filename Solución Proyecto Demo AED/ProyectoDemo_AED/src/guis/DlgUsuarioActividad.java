package guis;

import libreria.*;
import clases.Usuario;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class DlgUsuarioActividad extends JDialog implements ActionListener, KeyListener {
	
	private static final long serialVersionUID = 1L;

	private JLabel lblCodigo;
	private JLabel lblNombres;
	private JLabel lblApellidos;	
	private JLabel lblTipoID;
	private JLabel lblNumeroID;
	private JLabel lblArea;
	private JLabel lblCorreo;
	private JLabel lblTelefono;
	private JLabel lblFechaIngreso;
	private JLabel lblEstado;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtNumeroID;
	private JTextField txtCorreo;
	private JTextField txtTelefono;
	private JComboBox <String> cboTipoID;
	private JComboBox <String> cboArea;
	private JComboBox <String> cboIngresoDia;
	private JComboBox <String> cboIngresoMes;
	private JComboBox <String> cboIngresoAño;
	private JComboBox <String> cboEstado;
	private JButton btnAceptar;
	private JButton btnVolver;
	
	private int tipoOperacion;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgUsuarioActividad dialog = new DlgUsuarioActividad();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public DlgUsuarioActividad() {
		setResizable(false);
		setBounds(100, 100, 375, 430);
		getContentPane().setLayout(null);
		
		lblCodigo = new JLabel("C\u00D3DIGO");
		lblCodigo.setBounds(10, 11, 102, 23);
		getContentPane().add(lblCodigo);
		
		lblCodigo = new JLabel();
		lblCodigo.setBounds(102, 11, 126, 23);
		getContentPane().add(lblCodigo);
		
		lblNombres = new JLabel("NOMBRES");
		lblNombres.setBounds(10, 41, 94, 23);
		getContentPane().add(lblNombres);
		
		txtNombres = new JTextField();
		txtNombres.addKeyListener(this);
		txtNombres.addActionListener(this);
		txtNombres.setColumns(10);
		txtNombres.setBounds(100, 41, 150, 23);
		getContentPane().add(txtNombres);
	
		lblApellidos = new JLabel("APELLIDOS");
		lblApellidos.setBounds(10, 71, 94, 23);
		getContentPane().add(lblApellidos);
	
		txtApellidos = new JTextField();
		txtApellidos.addKeyListener(this);
		txtApellidos.addActionListener(this);
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(100, 71, 150, 23);
		getContentPane().add(txtApellidos);
		
		lblTipoID = new JLabel("TIPO ID");
		lblTipoID.setBounds(10, 101, 94, 23);
		getContentPane().add(lblTipoID);

		cboTipoID = new JComboBox <String> ();
		cboTipoID.setModel(new DefaultComboBoxModel <String> (Lib.tiposDeID));
		cboTipoID.setBounds(100, 101, 150, 23);
		getContentPane().add(cboTipoID);
		
		lblNumeroID = new JLabel("NÚMERO ID");
		lblNumeroID.setBounds(10, 131, 126, 19);
		getContentPane().add(lblNumeroID);
		
		txtNumeroID = new JTextField();
		txtNumeroID.addKeyListener(this);
		txtNumeroID.addActionListener(this);
		txtNumeroID.setColumns(10);
		txtNumeroID.setBounds(100, 131, 150, 23);
		getContentPane().add(txtNumeroID);		

		lblArea = new JLabel("ÁREA");
		lblArea.setBounds(10, 161, 55, 23);
		getContentPane().add(lblArea);	

		cboArea = new JComboBox <String> ();
		cboArea.setModel(new DefaultComboBoxModel <String> (Lib.tiposDeArea));
		
		cboArea.setBounds(100, 161, 150, 23);
		getContentPane().add(cboArea);
		
		lblCorreo = new JLabel("CORREO");
		lblCorreo.setBounds(10, 191, 55, 23);
		getContentPane().add(lblCorreo);

		txtCorreo = new JTextField();
		txtCorreo.addKeyListener(this);
		txtCorreo.addActionListener(this);
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(100, 191, 150, 23);
		getContentPane().add(txtCorreo);	
		
		lblTelefono = new JLabel("TELÉFONO");
		lblTelefono.setBounds(10, 221, 126, 23);
		getContentPane().add(lblTelefono);

		txtTelefono = new JTextField();
		txtTelefono.addKeyListener(this);
		txtTelefono.addActionListener(this);
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(100, 221, 150, 23);
		getContentPane().add(txtTelefono);	
		
		lblFechaIngreso = new JLabel("INGRESO");
		lblFechaIngreso.setBounds(10, 251, 94, 23);
		getContentPane().add(lblFechaIngreso);
		
		lblEstado = new JLabel("ESTADO");
		lblEstado.setBounds(10, 281, 55, 23);
		getContentPane().add(lblEstado);

		cboIngresoDia = new JComboBox <String> ();
		Fecha.colocarItems(cboIngresoDia, 1, 31);
		Fecha.colocarDiaActual(cboIngresoDia);
		cboIngresoDia.addActionListener(this);
		cboIngresoDia.setBounds(100, 251, 40, 23);
		getContentPane().add(cboIngresoDia);
		
		cboIngresoMes = new JComboBox <String> ();
		Fecha.colocarMeses(cboIngresoMes);
		Fecha.colocarMesActual(cboIngresoMes);
		cboIngresoMes.addActionListener(this);
		cboIngresoMes.setBounds(140, 251, 90, 23);
		getContentPane().add(cboIngresoMes);
		
		cboIngresoAño = new JComboBox <String> ();
		Fecha.colocarItems(cboIngresoAño, Fecha.añoActual(), 2000);
		cboIngresoAño.addActionListener(this);
		cboIngresoAño.setBounds(230, 251, 60, 23);
		getContentPane().add(cboIngresoAño);
		
		cboEstado = new JComboBox <String> ();
		cboEstado.setModel(new DefaultComboBoxModel <String> (Lib.tiposDeEstado));
		cboEstado.setBounds(100, 281, 80, 23);
		getContentPane().add(cboEstado);

		btnAceptar = new JButton("aceptar", new ImageIcon("imagenes/aceptar.png"));
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(130, 350, 109, 45);
		getContentPane().add(btnAceptar);
		
		btnVolver = new JButton("volver", new ImageIcon("imagenes/volver.png"));
		btnVolver.addActionListener(this);
		btnVolver.setBounds(250, 350, 109, 45);
		getContentPane().add(btnVolver);	
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnVolver) {
			actionPerformedBtnVolver(arg0);
		}
		if (arg0.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(arg0);
		}
		if (arg0.getSource() == txtTelefono) {
			actionPerformedTxtTelefono(arg0);
		}
		if (arg0.getSource() == txtCorreo) {
			actionPerformedTxtCorreo(arg0);
		}
		if (arg0.getSource() == txtNumeroID) {
			actionPerformedTxtNumeroID(arg0);
		}
		if (arg0.getSource() == txtApellidos) {
			actionPerformedTxtApellidos(arg0);
		}
		if (arg0.getSource() == txtNombres) {
			actionPerformedTxtNombres(arg0);
		}
	}
	protected void actionPerformedTxtNombres(ActionEvent arg0) {
		txtApellidos.requestFocus();
	}
	protected void actionPerformedTxtApellidos(ActionEvent arg0) {
		txtNumeroID.requestFocus();
	}
	protected void actionPerformedTxtNumeroID(ActionEvent arg0) {
		txtCorreo.requestFocus();
	}
	protected void actionPerformedTxtCorreo(ActionEvent arg0) {
		txtTelefono.requestFocus();
	}
	protected void actionPerformedTxtTelefono(ActionEvent arg0) {
		adicionarModificarUsuario(true);
	}
	protected void actionPerformedBtnAceptar(ActionEvent earg0) {
		switch (tipoOperacion) {
			case 0:			
				adicionarModificarUsuario(true);	
				break;
			case 1:
				consultarUsuario();
				break;
			case 2:
				adicionarModificarUsuario(false);
				break;
			default:
				eliminarUsuario();
		}
	}
	protected void actionPerformedBtnVolver(ActionEvent arg0) {
		dispose();	
	}
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
	}
	public void keyTyped(KeyEvent arg0) {
		if (arg0.getSource() == txtTelefono) {
			keyTypedTxtTelefono(arg0);
		}
		if (arg0.getSource() == txtCorreo) {
			keyTypedTxtCorreo(arg0);
		}
		if (arg0.getSource() == txtNumeroID) {
			keyTypedTxtNumeroID(arg0);
		}
		if (arg0.getSource() == txtApellidos) {
			keyTypedTxtApellidos(arg0);
		}
		if (arg0.getSource() == txtNombres) {
			keyTypedTxtNombres(arg0);
		}
	}
	protected void keyTypedTxtNombres(KeyEvent arg0) {
		Lib.soloLetras(arg0, txtNombres, 25);
	}
	protected void keyTypedTxtApellidos(KeyEvent arg0) {
		Lib.soloLetras(arg0, txtApellidos, 25);
	}
	protected void keyTypedTxtNumeroID(KeyEvent arg0) {
		Lib.soloNumeros(arg0, txtApellidos, 8);
	}
	protected void keyTypedTxtCorreo(KeyEvent arg0) {
		Lib.soloLetras(arg0, txtCorreo, 25);
	}
	protected void keyTypedTxtTelefono(KeyEvent arg0) {
		Lib.soloNumeros(arg0, txtTelefono, 9);
	}
	//  Adiciona o Modifica un nuevo usuario
	void adicionarModificarUsuario(boolean adicionar) {		
		if (leerNombres().length() == 0)
			Lib.mensajeError(this, "Ingrese NOMBRES", txtNombres);
		else
			if (leerApellidos().length() == 0)
				Lib.mensajeError(this, "Ingrese APELLIDOS", txtApellidos);
			else
				if (leerNumeroID().length() == 0)
					Lib.mensajeError(this, "Ingrese NÚMERO DE ID", txtNumeroID);
				else 
					if (leerCorreo().length() == 0)
						Lib.mensajeError(this, "Ingrese CORREO", txtCorreo);
					else 
						if (leerTelefono().length() == 0)
							Lib.mensajeError(this, "Ingrese TELEFONO", txtTelefono);
						else {
							if (adicionar) {
								Usuario nuevo = new Usuario(leerCodigo(), leerNombres(), 
			                                                leerApellidos(), leerPosTipoID(),
			                                                leerNumeroID(), leerPosArea(),
			                                                leerCorreo(), leerTelefono(),
			                                                leerFechaIngreso(), leerPosEstado());
								ProyectoDemo_AED.au.adicionar(nuevo);
								Lib.mensajeInformacion(this, "El Usuario ha sido adicionado");
							}
							else {
								Usuario x = ProyectoDemo_AED.au.buscar(leerCodigo());
								x.setNombres(leerNombres());
								x.setApellidos(leerApellidos());
								x.setTipoID(leerPosTipoID());
								x.setNumeroID(leerNumeroID());
								x.setArea(leerPosArea());
								x.setCorreo(leerCorreo());
								x.setTelefono(leerTelefono());	
								x.setFechaIngreso(leerFechaIngreso());
								x.setEstado(leerPosEstado());
								Lib.mensajeInformacion(this, "El Usuario ha sido modificado");		
							}
							dispose();
						}
	}
	//  Consulta el usuario en curso
	void consultarUsuario() {
		dispose();
	}
	//  Elimina el área en curso
	void eliminarUsuario() {
		int ok = Lib.mensajeConfirmacion(this, "¿Está seguro de eliminar el Usuario?");
		if (ok == 0) {
			Usuario x = ProyectoDemo_AED.au.buscar(leerCodigo());
			ProyectoDemo_AED.au.eliminar(x);
			Lib.mensajeInformacion(this, "El Usuario ha sido eliminado");
			dispose();
		}
	}
	//  Establece el tipo de operación a afectuar
	void setTipoOperacion(int tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}
	//  Carga los datos de un usuario
	void cargarUsuario(Usuario x) {
		lblCodigo.setText("" + x.getCodigo());
		txtNombres.setText(x.getNombres());
		txtApellidos.setText(x.getApellidos());
		cboTipoID.setSelectedIndex(x.getTipoID());
		txtNumeroID.setText(x.getNumeroID());
		cboArea.setSelectedIndex(x.getArea());
		txtCorreo.setText(x.getCorreo());
		txtTelefono.setText(x.getTelefono());
		Fecha.setFecha(cboIngresoDia, cboIngresoMes, cboIngresoAño, x.getFechaIngreso());
		cboEstado.setSelectedIndex(x.getEstado());
	}
	//  Configura el formulario para la operación a efectuar
	void configurarFormulario() {
		switch (tipoOperacion) {
			case 0:
				lblCodigo.setText("" + ProyectoDemo_AED.au.generarCodigo());
				habilitarCajasDeTexto(true);
				break;
			case 1:
				btnVolver.setVisible(false);
				habilitarCajasDeTexto(false);
				break;
			case 2:				
				habilitarCajasDeTexto(true);
				break;
			default:
				habilitarCajasDeTexto(false);
		}
	}
	//  Habilita o deshabilita las cajas de texto
	void habilitarCajasDeTexto(boolean sino) {
		txtNombres.setEditable(sino);
		txtApellidos.setEditable(sino);
		cboTipoID.setEnabled(sino);
		txtNumeroID.setEditable(sino);
		cboArea.setEnabled(sino);
		txtCorreo.setEditable(sino);
		txtTelefono.setEditable(sino);
		cboIngresoDia.setEnabled(sino);
		cboIngresoMes.setEnabled(sino);
		cboIngresoAño.setEnabled(sino);
		cboEstado.setEnabled(sino);
	}
	//  Métodos que retornan valor (sin parámetros)
	int leerCodigo() {
		return Lib.leerEntero(lblCodigo);
	}
	String leerNombres() {
		return Lib.leerCadena(txtNombres);
	}
	String leerApellidos() {
		return Lib.leerCadena(txtApellidos);
	}
	int leerPosTipoID() {
		return cboTipoID.getSelectedIndex();
	}
	String leerNumeroID() {
		return Lib.leerCadena(txtNumeroID);
	}
	int leerPosArea() {
		return cboArea.getSelectedIndex();
	}
	String leerCorreo() {
		return Lib.leerCadena(txtCorreo);
	}
	String leerTelefono() {
		return Lib.leerCadena(txtTelefono);
	}
	int leerFechaIngreso() {
		return Fecha.getFecha(cboIngresoDia, cboIngresoMes, cboIngresoAño);
	}
	int leerPosEstado() {
		return cboEstado.getSelectedIndex();
	}	
	
}