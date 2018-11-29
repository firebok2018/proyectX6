package guis;

import libreria.*;
import clases.Usuario;
import clases.Especialista;
import clases.Incidencia;
import clases.TipoIncidencia;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;

import java.awt.event.KeyEvent;
import java.awt.Font;

public class DlgIncidenciaActividad extends JDialog implements ActionListener, KeyListener {
	
	private static final long serialVersionUID = 1L;

	private JLabel lblCodigo;
	private JLabel lblCodigoTipoIncidencia;
	private JLabel lblTiempoRealSolucion;	
	private JLabel lblCodigoUsuario;
	private JLabel lblTiempoEstimadoSolucion;
	private JLabel lblCodigoEspecialista;
	private JLabel lblDescripcion;
	private JLabel lblComentario;
	private JLabel lblFechaRegistro;
	private JLabel lblFechaInicioAtencion;
	private JLabel lblFechaFinAtencion;
	private JLabel lblEstado;
	private JTextArea txtDescripcion;
	private JTextArea txtComentario;
	private JTextField txtTiempoEstimadoSolucion;
	private JTextField txtTiempoRealSolucion;
	private JComboBox <String> cboCodigoUsuario;
	private JComboBox <String> cboCodigoEspecialista;
	private JComboBox <String> cboCodigoTipoIncidencia;
	private JComboBox <String> cboRegistroDia;
	private JComboBox <String> cboRegistroMes;
	private JComboBox <String> cboRegistroAño;
	private JComboBox <String> cboInicioAtencionDia;
	private JComboBox <String> cboInicioAtencionMes;
	private JComboBox <String> cboInicioAtencionAño;
	private JComboBox <String> cboFinAtencionDia;
	private JComboBox <String> cboFinAtencionMes;
	private JComboBox <String> cboFinAtencionAño;
	private JComboBox <String> cboEstado;
	private JScrollPane scrollPane;
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
					DlgIncidenciaActividad dialog = new DlgIncidenciaActividad();
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
	public DlgIncidenciaActividad() {
		setResizable(false);
		setBounds(100, 100, 520, 500);
		getContentPane().setLayout(null);
	
		lblCodigo = new JLabel("C\u00D3DIGO");
		lblCodigo.setBounds(10, 11, 102, 23);
		getContentPane().add(lblCodigo);
	
		lblCodigo = new JLabel();
		lblCodigo.setBounds(209, 11, 102, 23);
		getContentPane().add(lblCodigo);
		
		lblCodigoUsuario = new JLabel("CÓDIGO DE USUARIO");
		lblCodigoUsuario.setBounds(10, 41, 180, 23);
		getContentPane().add(lblCodigoUsuario);
		
		cboCodigoUsuario = new JComboBox <String> ();
		colocarUsuarios();
		cboCodigoUsuario.setBounds(205, 41, 126, 23);
		getContentPane().add(cboCodigoUsuario);
		
		lblCodigoEspecialista = new JLabel("CÓDIGO DE ESPECIALISTA");
		lblCodigoEspecialista.setBounds(10, 71, 190, 23);
		getContentPane().add(lblCodigoEspecialista);
		
		cboCodigoEspecialista = new JComboBox <String> ();
		colocarEspecialistas();
		cboCodigoEspecialista.setBounds(205, 71, 126, 23);
		getContentPane().add(cboCodigoEspecialista);
	
		lblCodigoTipoIncidencia = new JLabel("CÓDIGO DE TIPO DE INCIDENCIA");
		lblCodigoTipoIncidencia.setBounds(10, 101, 190, 23);
		getContentPane().add(lblCodigoTipoIncidencia);
		
		cboCodigoTipoIncidencia = new JComboBox <String> ();
		colocarTipoIncidencias();
		cboCodigoTipoIncidencia.setBounds(205, 101, 126, 23);
		getContentPane().add(cboCodigoTipoIncidencia);
		
		lblDescripcion = new JLabel("DESCRIPCIÓN");
		lblDescripcion.setBounds(10, 131, 190, 23);
		getContentPane().add(lblDescripcion);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(205, 131, 300, 43);
		getContentPane().add(scrollPane);
		
		txtDescripcion = new JTextArea();
		txtDescripcion.setFont(new Font("Arial", Font.PLAIN, 11));
		scrollPane.setViewportView(txtDescripcion);
		
		lblComentario = new JLabel("COMENTARIO");
		lblComentario.setBounds(10, 190, 180, 23);
		getContentPane().add(lblComentario);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(205, 180, 300, 43);
		getContentPane().add(scrollPane);
		
		txtComentario = new JTextArea();
		txtComentario.setFont(new Font("Arial", Font.PLAIN, 11));
		scrollPane.setViewportView(txtComentario);

		lblTiempoEstimadoSolucion = new JLabel("TIEMPO ESTIMADO DE SOLUCIÓN");
		lblTiempoEstimadoSolucion.setBounds(10, 230, 190, 23);
		getContentPane().add(lblTiempoEstimadoSolucion);
		
		txtTiempoEstimadoSolucion = new JTextField();
		txtTiempoEstimadoSolucion.addKeyListener(this);
		txtTiempoEstimadoSolucion.addActionListener(this);
		txtTiempoEstimadoSolucion.setColumns(10);
		txtTiempoEstimadoSolucion.setBounds(205, 230, 126, 23);
		getContentPane().add(txtTiempoEstimadoSolucion);		
		
		lblTiempoRealSolucion = new JLabel("TIEMPO REAL DE SOLUCIÓN");
		lblTiempoRealSolucion.setBounds(10, 260, 190, 23);
		getContentPane().add(lblTiempoRealSolucion);
	
		txtTiempoRealSolucion = new JTextField();
		txtTiempoRealSolucion.addKeyListener(this);
		txtTiempoRealSolucion.addActionListener(this);
		txtTiempoRealSolucion.setColumns(10);
		txtTiempoRealSolucion.setBounds(205, 260, 126, 23);
		getContentPane().add(txtTiempoRealSolucion);
		
		lblFechaRegistro = new JLabel("FECHA DE REGISTRO");
		lblFechaRegistro.setBounds(10, 290, 190, 23);
		getContentPane().add(lblFechaRegistro);
		
		cboRegistroDia = new JComboBox <String> ();
		Fecha.colocarItems(cboRegistroDia, 1, 31);
		Fecha.colocarDiaActual(cboRegistroDia);
		cboRegistroDia.addActionListener(this);
		cboRegistroDia.setBounds(205, 290, 40, 23);
		getContentPane().add(cboRegistroDia);
		
		cboRegistroMes = new JComboBox <String> ();
		Fecha.colocarMeses(cboRegistroMes);
		Fecha.colocarMesActual(cboRegistroMes);
		cboRegistroMes.addActionListener(this);
		cboRegistroMes.setBounds(245, 290, 90, 23);
		getContentPane().add(cboRegistroMes);
		
		cboRegistroAño = new JComboBox <String> ();
		Fecha.colocarItems(cboRegistroAño, Fecha.añoActual(), 2000);
		cboRegistroAño.addActionListener(this);
		cboRegistroAño.setBounds(335, 290, 60, 23);
		getContentPane().add(cboRegistroAño);
		
		lblFechaInicioAtencion = new JLabel("FECHA DE INICIO DE ATENCIÓN");
		lblFechaInicioAtencion.setBounds(10, 320, 190, 23);
		getContentPane().add(lblFechaInicioAtencion);
	
		cboInicioAtencionDia = new JComboBox <String> ();
		Fecha.colocarItems(cboInicioAtencionDia, 1, 31);
		Fecha.colocarDiaActual(cboInicioAtencionDia);
		cboInicioAtencionDia.addActionListener(this);
		cboInicioAtencionDia.setBounds(205, 320, 40, 23);
		getContentPane().add(cboInicioAtencionDia);
		
		cboInicioAtencionMes = new JComboBox <String> ();
		Fecha.colocarMeses(cboInicioAtencionMes);
		Fecha.colocarMesActual(cboInicioAtencionMes);
		cboInicioAtencionMes.addActionListener(this);
		cboInicioAtencionMes.setBounds(245, 320, 90, 23);
		getContentPane().add(cboInicioAtencionMes);
		
		cboInicioAtencionAño = new JComboBox <String> ();
		Fecha.colocarItems(cboInicioAtencionAño, Fecha.añoActual(), 2000);
		cboInicioAtencionAño.addActionListener(this);
		cboInicioAtencionAño.setBounds(335, 320, 60, 23);
		getContentPane().add(cboInicioAtencionAño);

		lblFechaFinAtencion = new JLabel("FECHA DE FIN DE ATENCIÓN");
		lblFechaFinAtencion.setBounds(10, 350, 190, 23);
		getContentPane().add(lblFechaFinAtencion);
	
		cboFinAtencionDia = new JComboBox <String> ();
		Fecha.colocarItems(cboFinAtencionDia, 1, 31);
		Fecha.colocarDiaActual(cboFinAtencionDia);
		cboFinAtencionDia.addActionListener(this);
		cboFinAtencionDia.setBounds(205, 350, 40, 23);
		getContentPane().add(cboFinAtencionDia);
		
		cboFinAtencionMes = new JComboBox <String> ();
		Fecha.colocarMeses(cboFinAtencionMes);
		Fecha.colocarMesActual(cboFinAtencionMes);
		cboFinAtencionMes.addActionListener(this);
		cboFinAtencionMes.setBounds(245, 350, 90, 23);
		getContentPane().add(cboFinAtencionMes);
		
		cboFinAtencionAño = new JComboBox <String> ();
		Fecha.colocarItems(cboFinAtencionAño, Fecha.añoActual(), 2000);
		cboFinAtencionAño.addActionListener(this);
		cboFinAtencionAño.setBounds(335, 350, 60, 23);
		getContentPane().add(cboFinAtencionAño);
		
		lblEstado = new JLabel("ESTADO");
		lblEstado.setBounds(10, 380, 55, 23);
		getContentPane().add(lblEstado);
		
		cboEstado = new JComboBox <String> ();
		cboEstado.setModel(new DefaultComboBoxModel <String> (Lib.tiposDeIncidencia));
		cboEstado.setBounds(205, 380, 90, 23);
		getContentPane().add(cboEstado);

		btnAceptar = new JButton("aceptar", new ImageIcon("imagenes/aceptar.png"));
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(275, 420, 109, 45);
		getContentPane().add(btnAceptar);
		
		btnVolver = new JButton("volver", new ImageIcon("imagenes/volver.png"));
		btnVolver.addActionListener(this);
		btnVolver.setBounds(395, 420, 109, 45);
		getContentPane().add(btnVolver);	
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnVolver) {
			actionPerformedBtnVolver(arg0);
		}
		if (arg0.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(arg0);
		}
		if (arg0.getSource() == txtTiempoRealSolucion) {
			actionPerformedTxtTiempoRealSolucion(arg0);
		}
		if (arg0.getSource() == txtTiempoEstimadoSolucion) {
			actionPerformedTxtTiempoEstimadoSolucion(arg0);
		}
	}
	protected void actionPerformedTxtTiempoEstimadoSolucion(ActionEvent arg0) {
		txtTiempoRealSolucion.requestFocus();
	}
	protected void actionPerformedTxtTiempoRealSolucion(ActionEvent arg0) {
		adicionarActualizarIncidencia(true);
	}
	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		switch (tipoOperacion) {
			case 0:		
				adicionarActualizarIncidencia(true);
				break;
			default:
				adicionarActualizarIncidencia(false);
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
		if (arg0.getSource() == txtTiempoEstimadoSolucion) {
			keyTypedTiempoEstimadoSol(arg0);
		}
		if (arg0.getSource() == txtTiempoRealSolucion) {
			keyTypedTiempoRealSol(arg0);
		}
	}
	protected void keyTypedTiempoEstimadoSol(KeyEvent arg0) {
		Lib.soloNumeros(arg0, txtTiempoEstimadoSolucion, 2);
	}
	protected void keyTypedTiempoRealSol(KeyEvent arg0) {
		Lib.soloNumeros(arg0, txtTiempoRealSolucion, 2);
	}
	//  Adicionar o Modifica una nueva incidencia
	void adicionarActualizarIncidencia(boolean adicionar) {
		if (leerDescripcion().length() == 0)
			Lib.mensajeError(this, "Ingrese DESCRIPCIÓN", txtDescripcion);
		else
			if (leerComentario().length() == 0)
				Lib.mensajeError(this, "Ingrese COMENTARIO", txtComentario);
			else
				try {
					int tes = leerTiempoEstimadoSolucion();
					try {
						int trs = leerTiempoRealSol();
						if (adicionar) {
							Incidencia nueva = new Incidencia(leerCodigo(), leerCodigoUsuario(), 
							   	                              leerCodigoEspecialista(), leerCodigoTipoIncidencia(),
			                                                  leerDescripcion(), leerComentario(), tes, trs,
			                                                  leerFechaRegistro(), leerFechaInicioAtencion(),
			                                                  leerFechaFinAtencion(), leerPosEstado());
							ProyectoDemo_AED.ai.adicionar(nueva);
							Lib.mensajeInformacion(this, "La incidencia ha sido adicionada");
						}
						else {
							Incidencia x = ProyectoDemo_AED.ai.buscar(leerCodigo());
							x.setCodigoUsuario(leerCodigoUsuario());
							x.setCodigoEspecialista(leerCodigoEspecialista());
							x.setCodigoTipoIncidencia(leerCodigoTipoIncidencia());
							x.setDescripcion(leerDescripcion());
							x.setComentario(leerComentario());
							x.setTiempoEstimadoSolucion(leerTiempoEstimadoSolucion());
							x.setTiempoRealSolucion(leerTiempoRealSol());
							x.setFechaRegistro(leerFechaRegistro());
							x.setFechaInicioAtencion(leerFechaInicioAtencion());
							x.setFechaFinAtencion(leerFechaFinAtencion());
							x.setEstado(leerPosEstado());
							Lib.mensajeInformacion(this, "El Usuario ha sido modificado");
						}
						dispose();
					}
					catch (Exception e) {
						Lib.mensajeError(this, "Ingrese TIEMPO REAL DE SOLUCIÓN", txtTiempoRealSolucion);
					}
				}
				catch (Exception e) {
					Lib.mensajeError(this, "Ingrese TIEMPO ESTIMADO DE SOLUCIÓN", txtTiempoEstimadoSolucion);
				}				
	}
	//  Establece el tipo de operación a afectuar
	void setTipoOperacion(int tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}	
	//  Carga los datos de una incidencia
	void cargarIncidencia(Incidencia x) {
		lblCodigo.setText("" + x.getCodigo());
		cboCodigoUsuario.setSelectedItem(x.getCodigoUsuario());
		cboCodigoEspecialista.setSelectedItem(x.getCodigoEspecialista());
		cboCodigoTipoIncidencia.setSelectedItem(x.getCodigoTipoIncidencia());
		txtDescripcion.setText(x.getDescripcion());		
		txtComentario.setText(x.getComentario());	
		txtTiempoEstimadoSolucion.setText("" + x.getTiempoEstimadoSolucion());	
		txtTiempoRealSolucion.setText("" + x.getTiempoRealSolucion());
		Fecha.setFecha(cboRegistroDia, cboRegistroMes, cboRegistroAño, x.getFechaRegistro());
		Fecha.setFecha(cboInicioAtencionDia, cboInicioAtencionMes, cboInicioAtencionAño, x.getFechaInicioAtencion());
		Fecha.setFecha(cboFinAtencionDia, cboFinAtencionMes, cboFinAtencionAño, x.getFechaFinAtencion());
		cboEstado.setSelectedIndex(x.getEstado());
	}	
	//  Configura el formulario para la operación a efectuar
	void configurarFormulario() {
		switch (tipoOperacion) {
			case 0:
				lblCodigo.setText("" + ProyectoDemo_AED.ai.generarCodigo());
				habilitarCajasDeTexto(true);
				break;
			default:
				habilitarCajasDeTexto(false);
		}
	}
	//  Habilita o deshabilita las cajas de texto
	void habilitarCajasDeTexto(boolean b) {
		cboRegistroDia.setEnabled(b);
		cboRegistroMes.setEnabled(b);
		cboRegistroAño.setEnabled(b);
	}
	//  Métodos tipo void (sin parámetros)	
	void colocarUsuarios() {
		Usuario x;
		for (int i=0; i<ProyectoDemo_AED.au.tamaño(); i++) {
			x = ProyectoDemo_AED.au.obtener(i);
			cboCodigoUsuario.addItem("" + x.getCodigo());
		}	
	}
	void colocarEspecialistas() {
		Especialista x;
		for (int i=0; i<ProyectoDemo_AED.ae.tamaño(); i++) {
			x = ProyectoDemo_AED.ae.obtener(i);
			cboCodigoEspecialista.addItem("" + x.getCodigo());
		}	
	}
	void colocarTipoIncidencias() {
		TipoIncidencia x;
		for (int i=0; i<ProyectoDemo_AED.ati.tamaño(); i++) {
			x = ProyectoDemo_AED.ati.obtener(i);
			cboCodigoTipoIncidencia.addItem("" + x.getCodigo());
		}	
	}
	//  Métodos que retornan valor (sin parámetros)
	int leerCodigo() {
		return Lib.leerEntero(lblCodigo);
	}
	int leerCodigoUsuario() {
		return Integer.parseInt(cboCodigoUsuario.getSelectedItem().toString());
	}
	int leerCodigoEspecialista() {
		return Integer.parseInt(cboCodigoEspecialista.getSelectedItem().toString());
	}
	int leerCodigoTipoIncidencia() {
		return Integer.parseInt(cboCodigoTipoIncidencia.getSelectedItem().toString());
	}
	String leerDescripcion() {
		return Lib.leerCadenaGrande(txtDescripcion);
	}
	String leerComentario() {
		return Lib.leerCadenaGrande(txtComentario);
	}
	int leerTiempoEstimadoSolucion() {
		return Lib.leerEntero(txtTiempoEstimadoSolucion);
	}
	int leerTiempoRealSol() {
		return Lib.leerEntero(txtTiempoRealSolucion);
	}
	int leerFechaRegistro() {
		return Fecha.getFecha(cboRegistroDia, cboRegistroMes, cboRegistroAño);
	}
	int leerFechaInicioAtencion() {
		return Fecha.getFecha(cboInicioAtencionDia, cboInicioAtencionMes, cboInicioAtencionAño);
	}
	int leerFechaFinAtencion() {
		return Fecha.getFecha(cboFinAtencionDia, cboFinAtencionMes, cboFinAtencionAño);
	}
	int leerPosEstado() {
		return cboEstado.getSelectedIndex();
	}
	
}