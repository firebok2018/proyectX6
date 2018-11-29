package guis;

import libreria.Lib;
import clases.TipoDocumento;

import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Font;

public class DlgTipoDocumentoActividad extends JDialog implements ActionListener, KeyListener {
	
	private static final long serialVersionUID = 1L;

	private JLabel lblCodigo;
	private JLabel lblDescripcion;	
	private JLabel lblAbreviacion;
	private JLabel lblEstado;
	private JTextArea txtDescripcion;
	private JScrollPane scrollPane;
	private JTextField txtAbreviacion;
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
					DlgTipoDocumentoActividad dialog = new DlgTipoDocumentoActividad();
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
	public DlgTipoDocumentoActividad() {
		setResizable(false);
		setBounds(100, 100, 415, 350);
		getContentPane().setLayout(null);
	
		lblCodigo = new JLabel("C\u00D3DIGO");
		lblCodigo.setBounds(10, 11, 102, 23);
		getContentPane().add(lblCodigo);
		
		lblCodigo = new JLabel();
		lblCodigo.setBounds(102, 11, 126, 23);
		getContentPane().add(lblCodigo);
	
		lblDescripcion = new JLabel("DESCRIPCI\u00D3N");
		lblDescripcion.setBounds(10, 41, 94, 23);
		getContentPane().add(lblDescripcion);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(100, 41, 300, 43);
		getContentPane().add(scrollPane);
		
		txtDescripcion = new JTextArea();
		txtDescripcion.setFont(new Font("Arial", Font.PLAIN, 11));
		scrollPane.setViewportView(txtDescripcion);
		
		lblAbreviacion = new JLabel("ABREVIACI\u00D3N");
		lblAbreviacion.setBounds(10, 91, 94, 23);
		getContentPane().add(lblAbreviacion);
		
		txtAbreviacion = new JTextField();
		txtAbreviacion.addActionListener(this);
		txtAbreviacion.addKeyListener(this);
		txtAbreviacion.setColumns(10);
		txtAbreviacion.setBounds(100, 91, 126, 23);
		getContentPane().add(txtAbreviacion);

		lblEstado = new JLabel("ESTADO");
		lblEstado.setBounds(10, 121, 49, 23);
		getContentPane().add(lblEstado);
		
		cboEstado = new JComboBox <String> ();
		cboEstado.setModel(new DefaultComboBoxModel <String> (Lib.tiposDeEstado));
		cboEstado.setBounds(100, 121, 80, 23);
		getContentPane().add(cboEstado);

		btnAceptar = new JButton("aceptar", new ImageIcon("imagenes/aceptar.png"));
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(170, 270, 109, 45);
		getContentPane().add(btnAceptar);
		
		btnVolver = new JButton("volver", new ImageIcon("imagenes/volver.png"));
		btnVolver.addActionListener(this);
		btnVolver.setBounds(290, 270, 109, 45);
		getContentPane().add(btnVolver);	
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnVolver) {
			actionPerformedBtnVolver(arg0);
		}
		if (arg0.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(arg0);
		}
		if (arg0.getSource() == txtAbreviacion) {
			actionPerformedTxtAbreviacion(arg0);
		}
	}
	protected void actionPerformedTxtAbreviacion(ActionEvent arg0) {
		adicionarModificarTipoDocumento(true);
	}
	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		switch (tipoOperacion) {
			case 0:			
				adicionarModificarTipoDocumento(true);	
				break;
			case 1:
				consultarTipoDocumento();
				break;
			case 2:
				adicionarModificarTipoDocumento(false);
				break;
			default:
				eliminarTipoDocumento();
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
		if (arg0.getSource() == txtAbreviacion) {
			keyTypedTxtAbreviacion(arg0);
		}
	}
	protected void keyTypedTxtAbreviacion(KeyEvent arg0) {
		Lib.soloLetras(arg0, txtAbreviacion, 10);
	}
	//  Adiciona o Modifica un nuevo tipo de documento
	void adicionarModificarTipoDocumento(boolean adicionar) {
		if (leerDescripcion().length() == 0)
			Lib.mensajeError(this, "Ingrese DESCRIPCIÓN", txtDescripcion);
		else
			if (leerAbreviacion().length() == 0)
				Lib.mensajeError(this, "Ingrese ABREVIACIÓN", txtAbreviacion);
			else {
				if (adicionar) {
					TipoDocumento nuevo = new TipoDocumento(leerCodigo(), leerDescripcion(), 
					     			                        leerAbreviacion(), leerPosEstado());
					ProyectoDemo_AED.atd.adicionar(nuevo);
					Lib.mensajeInformacion(this, "El Documento ha sido adicionada");
				}
				else {
					TipoDocumento x = ProyectoDemo_AED.atd.buscar(leerCodigo());
					x.setDescripcion(leerDescripcion());
					x.setAbreviacion(leerAbreviacion());
					x.setEstado(leerPosEstado());
					Lib.mensajeInformacion(this, "El Tipo de documento ha sido modificado");
				}
				dispose();
			}
	}
	//  Consulta el tipo de documento en curso
	void consultarTipoDocumento() {
		dispose();
	}
	//  Elimina el tipo de documento en curso
	void eliminarTipoDocumento() {
		int ok = Lib.mensajeConfirmacion(this, "¿Está seguro de eliminar el Documento?");
		if (ok == 0) {
			TipoDocumento x = ProyectoDemo_AED.atd.buscar(leerCodigo());
			ProyectoDemo_AED.atd.eliminar(x);
			Lib.mensajeInformacion(this, "El Tipo de documento ha sido eliminado");
			dispose();
		}
	}
	//  Establece el tipo de operación a afectuar
	void setTipoOperacion(int tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}
	//  Carga los datos de un tipo de documento
	void cargarTipoDocumento(TipoDocumento x) {
		lblCodigo.setText("" + x.getCodigo());
		txtDescripcion.setText(x.getDescripcion());
		txtAbreviacion.setText(x.getAbreviacion());	
		cboEstado.setSelectedIndex(x.getEstado());	
	}
	//  Configura el formulario para la operación a efectuar
	void configurarFormulario() {
		switch (tipoOperacion) {
			case 0:
				lblCodigo.setText("" + ProyectoDemo_AED.atd.generarCodigo());
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
		txtDescripcion.setEditable(sino);
		txtAbreviacion.setEditable(sino);
		cboEstado.setEnabled(sino);
	}
	//  Métodos que retornan valor (sin parámetros)
	int leerCodigo() {
		return Lib.leerEntero(lblCodigo);
	}
	String leerDescripcion() {
		return Lib.leerCadenaGrande(txtDescripcion);
	}
	String leerAbreviacion() {
		return Lib.leerCadena(txtAbreviacion);
	}
	int leerPosEstado() {
		return cboEstado.getSelectedIndex();
	}
	
}