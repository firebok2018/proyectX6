package guis;

import clases.Especialista;
import libreria.Fecha;
import libreria.Lib;

import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class DlgEspecialistaActividad extends JDialog implements ActionListener, KeyListener {
	
	private static final long serialVersionUID = 1L;

	private JLabel lblCodigo;
	private JLabel lblNombres;
	private JLabel lblApellidos;	
	private JLabel lblEspecialidad;
	private JLabel lblAnexo;
	private JLabel lblFechaIngreso;
	private JLabel lblEstado;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtEspecialidad;
	private JTextField txtAnexo;
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
					DlgEspecialistaActividad dialog = new DlgEspecialistaActividad();
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
	public DlgEspecialistaActividad() {
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
		txtNombres.addActionListener(this);
		txtNombres.addKeyListener(this);
		txtNombres.setColumns(10);
		txtNombres.setBounds(100, 41, 126, 23);
		getContentPane().add(txtNombres);
	
		lblApellidos = new JLabel("APELLIDOS");
		lblApellidos.setBounds(10, 71, 94, 23);
		getContentPane().add(lblApellidos);
	
		txtApellidos = new JTextField();
		txtApellidos.addActionListener(this);
		txtApellidos.addKeyListener(this);
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(100, 71, 126, 23);
		getContentPane().add(txtApellidos);
		
		lblEspecialidad = new JLabel("ESPECIALIDAD");
		lblEspecialidad.setBounds(10, 101, 94, 23);
		getContentPane().add(lblEspecialidad);

		txtEspecialidad = new JTextField();
		txtEspecialidad.addActionListener(this);
		txtEspecialidad.addKeyListener(this);
		txtEspecialidad.setColumns(10);
		txtEspecialidad.setBounds(100, 101, 126, 23);
		getContentPane().add(txtEspecialidad);		

		lblAnexo = new JLabel("ANEXO");
		lblAnexo.setBounds(10, 131, 55, 23);
		getContentPane().add(lblAnexo);	

		txtAnexo = new JTextField();
		txtAnexo.addActionListener(this);
		txtAnexo.addKeyListener(this);
		txtAnexo.setColumns(10);
		txtAnexo.setBounds(100, 131, 126, 23);
		getContentPane().add(txtAnexo);
		
		lblFechaIngreso = new JLabel("INGRESO");
		lblFechaIngreso.setBounds(10, 161, 94, 23);
		getContentPane().add(lblFechaIngreso);

		cboIngresoDia = new JComboBox <String> ();
		Fecha.colocarItems(cboIngresoDia, 1, 31);
		Fecha.colocarDiaActual(cboIngresoDia);
		cboIngresoDia.addActionListener(this);
		cboIngresoDia.setBounds(100, 161, 40, 23);
		getContentPane().add(cboIngresoDia);
		
		cboIngresoMes = new JComboBox <String> ();
		Fecha.colocarMeses(cboIngresoMes);
		Fecha.colocarMesActual(cboIngresoMes);
		cboIngresoMes.addActionListener(this);
		cboIngresoMes.setBounds(140, 161, 90, 23);
		getContentPane().add(cboIngresoMes);
		
		cboIngresoAño = new JComboBox <String> ();
		Fecha.colocarItems(cboIngresoAño, Fecha.añoActual(), 2000);
		cboIngresoAño.addActionListener(this);
		cboIngresoAño.setBounds(230, 161, 60, 23);
		getContentPane().add(cboIngresoAño);
		
		lblEstado = new JLabel("ESTADO");
		lblEstado.setBounds(10, 191, 55, 23);
		getContentPane().add(lblEstado);
		
		cboEstado = new JComboBox <String> ();
		cboEstado.setModel(new DefaultComboBoxModel <String> (Lib.tiposDeEstado));
		cboEstado.setBounds(100, 191, 80, 23);
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
		if (arg0.getSource() == txtAnexo) {
			actionPerformedTxtAnexo(arg0);
		}
		if (arg0.getSource() == txtEspecialidad) {
			actionPerformedTxtEspecialidad(arg0);
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
		txtEspecialidad.requestFocus();
	}
	protected void actionPerformedTxtEspecialidad(ActionEvent arg0) {
		txtAnexo.requestFocus();
	}
	protected void actionPerformedTxtAnexo(ActionEvent arg0) {
		adicionarModificarEspecialista(true);
	}
	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		switch (tipoOperacion) {
			case 0:			
				adicionarModificarEspecialista(true);	
				break;
			case 1:
				consultarEspecialista();
				break;
			case 2:
				adicionarModificarEspecialista(false);	
				break;
			default:
				eliminarEspecialista();
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
		if (arg0.getSource() == txtNombres) {
			keyTypedTxtNombres(arg0);
		}
		if (arg0.getSource() == txtApellidos) {
			keyTypedTxtApellidos(arg0);
		}
		if (arg0.getSource() == txtEspecialidad) {
			keyTypedTxtEspecialidad(arg0);
		}
		if (arg0.getSource() == txtAnexo) {
			keyTypedTxtAnexo(arg0);
		}
	}
	protected void keyTypedTxtNombres(KeyEvent arg0) {
		Lib.soloLetras(arg0, txtNombres, 10);
	}
	protected void keyTypedTxtApellidos(KeyEvent arg0) {
		Lib.soloLetras(arg0, txtApellidos, 10);
	}
	protected void keyTypedTxtEspecialidad(KeyEvent arg0) {
		Lib.soloLetras(arg0, txtEspecialidad, 10);
	}
	protected void keyTypedTxtAnexo(KeyEvent arg0) {
		Lib.soloLetras(arg0, txtAnexo, 20);
	}
	//  Adiciona o Modifica un nuevo especialista
	void adicionarModificarEspecialista(boolean adicionar) {
		if (leerNombres().length() == 0)
			Lib.mensajeError(this, "Ingrese NOMBRES", txtNombres);
		else
			if (leerApellidos().length() == 0)
				Lib.mensajeError(this, "Ingrese APELLIDOS", txtApellidos);
			else
				if (leerEspecialidad().length() == 0)
					Lib.mensajeError(this, "Ingrese ESPECIALIDAD", txtEspecialidad);
				else 
					if (leerAnexo().length() == 0)
						Lib.mensajeError(this, "Ingrese ANEXO", txtAnexo);
					else {
						if (adicionar) {
							Especialista nuevo = new Especialista(leerCodigos(), leerNombres(), leerApellidos(),
			                                                      leerEspecialidad(), leerAnexo(),
			                                                      leerFechaIngreso(), leerPosEstado());
							ProyectoDemo_AED.ae.adicionar(nuevo);
							Lib.mensajeInformacion(this, "El Especialista ha sido adicionado");
						} 
						else {
							Especialista x = ProyectoDemo_AED.ae.buscar(leerCodigos());
							x.setNombres(leerNombres());
							x.setApellidos(leerApellidos());
							x.setEspecialidad(leerEspecialidad());
							x.setAnexo(leerAnexo());
							x.setFechaIngreso(leerFechaIngreso());
							x.setEstado(leerPosEstado());
							Lib.mensajeInformacion(this, "El Especialista ha sido modificado");
						}
						dispose();
					}
	}
	//  Consulta el especialista en curso
	void consultarEspecialista() {
		dispose();
	}
	//  Elimina el especialista en curso
	void eliminarEspecialista() {
		int ok = Lib.mensajeConfirmacion(this, "¿Está seguro de eliminar el Especialista?");
		if (ok == 0) {
			Especialista x = ProyectoDemo_AED.ae.buscar(leerCodigos());
			ProyectoDemo_AED.ae.eliminar(x);
			Lib.mensajeInformacion(this, "El Especialista ha sido eliminado");
			dispose();
		}
	}
	//  Establece el tipo de operación a afectuar
	void setTipoOperacion(int tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}
	//  Carga los datos de un especialista
	void cargarEspecialista(Especialista x) {
		lblCodigo.setText("" + x.getCodigo());
		txtNombres.setText(x.getNombres());
		txtApellidos.setText(x.getApellidos());
		txtEspecialidad.setText(x.getEspecialidad());
		txtAnexo.setText(x.getAnexo());
		Fecha.setFecha(cboIngresoDia, cboIngresoMes, cboIngresoAño, x.getFechaIngreso());	
		cboEstado.setSelectedIndex(x.getEstado());
	}
	//  Configura el formulario para la operación a efectuar
	void configurarFormulario() {
		switch (tipoOperacion) {
			case 0:
				lblCodigo.setText("" + ProyectoDemo_AED.ae.generarCodigo());
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
		txtEspecialidad.setEditable(sino);
		txtAnexo.setEditable(sino);
		cboIngresoDia.setEnabled(sino);
		cboIngresoMes.setEnabled(sino);
		cboIngresoAño.setEnabled(sino);
		cboEstado.setEnabled(sino);
	}
	//  Métodos que retornan valor (sin parámetros)
	int leerCodigos() {
		return Lib.leerEntero(lblCodigo);
	}
	String leerNombres() {
		return Lib.leerCadena(txtNombres);
	}
	String leerApellidos() {
		return Lib.leerCadena(txtApellidos);
	}
	String leerEspecialidad() {
		return Lib.leerCadena(txtEspecialidad);
	}
	String leerAnexo() {
		return Lib.leerCadena(txtAnexo);
	}
	int leerFechaIngreso() {
		return Fecha.getFecha(cboIngresoDia, cboIngresoMes, cboIngresoAño);
	}
	int leerPosEstado() {
		return cboEstado.getSelectedIndex();
	}
	
}