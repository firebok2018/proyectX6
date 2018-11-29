package guis;

import clases.Area;
import libreria.Lib;

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

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class DlgAreaActividad extends JDialog implements ActionListener, KeyListener {
	
	private static final long serialVersionUID = 1L;

	private JLabel lblCodigo;
	private JLabel lblNombre;
	private JLabel lblDescripcion;	
	private JLabel lblNombreCorto;
	private JLabel lblNombreLargo;
	private JLabel lblEstado;
	private JTextField txtNombre;
	private JTextField txtNombreCorto;
	private JTextField txtNombreLargo;
	private JTextArea txtDescripcion;
	private JScrollPane scrollPane;
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
					DlgAreaActividad dialog = new DlgAreaActividad();
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
	public DlgAreaActividad() {
		setResizable(false);
		setBounds(100, 100, 395, 350);
		getContentPane().setLayout(null);
	
		lblCodigo = new JLabel("C\u00D3DIGO");
		lblCodigo.setBounds(10, 11, 102, 23);
		getContentPane().add(lblCodigo);
		
		lblCodigo = new JLabel();
		lblCodigo.setBounds(120, 11, 126, 23);
		getContentPane().add(lblCodigo);
		
		lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(10, 41, 94, 23);
		getContentPane().add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.addActionListener(this);
		txtNombre.addKeyListener(this);
		txtNombre.setColumns(10);
		txtNombre.setBounds(120, 41, 126, 23);
		getContentPane().add(txtNombre);
	
		lblDescripcion = new JLabel("DESCRIPCI\u00D3N");
		lblDescripcion.setBounds(10, 71, 94, 23);
		getContentPane().add(lblDescripcion);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(120, 71, 260, 43);
		getContentPane().add(scrollPane);
		
		txtDescripcion = new JTextArea();
		txtDescripcion.setFont(new Font("Arial", Font.PLAIN, 11));
		scrollPane.setViewportView(txtDescripcion);
		
		lblNombreCorto = new JLabel("NOMBRE CORTO");
		lblNombreCorto.setBounds(10, 121, 94, 23);
		getContentPane().add(lblNombreCorto);
		
		txtNombreCorto = new JTextField();
		txtNombreCorto.addActionListener(this);
		txtNombreCorto.addKeyListener(this);
		txtNombreCorto.setColumns(10);
		txtNombreCorto.setBounds(120, 121, 126, 23);
		getContentPane().add(txtNombreCorto);

		lblNombreLargo = new JLabel("NOMBRE LARGO");
		lblNombreLargo.setBounds(10, 151, 94, 23);
		getContentPane().add(lblNombreLargo);
		
		txtNombreLargo = new JTextField();
		txtNombreLargo.addActionListener(this);
		txtNombreLargo.addKeyListener(this);
		txtNombreLargo.setColumns(10);
		txtNombreLargo.setBounds(120, 151, 260, 23);
		getContentPane().add(txtNombreLargo);		

		lblEstado = new JLabel("ESTADO");
		lblEstado.setBounds(10, 181, 49, 23);
		getContentPane().add(lblEstado);
		
		cboEstado = new JComboBox <String> ();
		cboEstado.setModel(new DefaultComboBoxModel <String> (Lib.tiposDeEstado));
		cboEstado.setBounds(120, 181, 80, 23);
		getContentPane().add(cboEstado);

		btnAceptar = new JButton("aceptar", new ImageIcon("imagenes/aceptar.png"));
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(150, 270, 109, 45);
		getContentPane().add(btnAceptar);
		
		btnVolver = new JButton("volver", new ImageIcon("imagenes/volver.png"));
		btnVolver.addActionListener(this);
		btnVolver.setBounds(270, 270, 109, 45);
		getContentPane().add(btnVolver);	
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnVolver) {
			actionPerformedBtnVolver(arg0);
		}
		if (arg0.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(arg0);
		}
		if (arg0.getSource() == txtNombreLargo) {
			actionPerformedTxtNombreLargo(arg0);
		}
		if (arg0.getSource() == txtNombreCorto) {
			actionPerformedTxtNombreCorto(arg0);
		}
		if (arg0.getSource() == txtNombre) {
			actionPerformedTxtNombre(arg0);
		}
	}
	protected void actionPerformedTxtNombre(ActionEvent arg0) {
		txtDescripcion.requestFocus();
	}
	protected void actionPerformedTxtNombreCorto(ActionEvent arg0) {
		txtNombreLargo.requestFocus();
	}
	protected void actionPerformedTxtNombreLargo(ActionEvent arg0) {
		adicionarModificarArea(true);
	}
	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		switch (tipoOperacion) {
			case 0:			
				adicionarModificarArea(true);	
				break;
			case 1:
				consultarArea();
				break;
			case 2:
				adicionarModificarArea(false);
				break;
			default:
				eliminarArea();
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
		if (arg0.getSource() == txtNombreLargo) {
			keyTypedTxtNombreLargo(arg0);
		}
		if (arg0.getSource() == txtNombreCorto) {
			keyTypedTxtNombreCorto(arg0);
		}
		if (arg0.getSource() == txtNombre) {
			keyTypedTxtNombreLargo(arg0);
		}
	}
	protected void keyTypedTxtNombre(KeyEvent arg0) {
		Lib.soloLetras(arg0, txtNombre, 20);
	}
	protected void keyTypedTxtNombreCorto(KeyEvent arg0) {
		Lib.soloLetras(arg0, txtNombreCorto, 20);
	}
	protected void keyTypedTxtNombreLargo(KeyEvent arg0) {
		Lib.soloLetras(arg0, txtNombreLargo, 40);
	}
	//  Adiciona o Modifica una nueva área
	void adicionarModificarArea(boolean adicionar) {
		if (leerNombre().length() == 0)
			Lib.mensajeError(this, "Ingrese NOMBRE", txtNombre);
		else
			if (leerDescripcion().length() == 0)
				Lib.mensajeError(this, "Ingrese DESCRIPCIÓN", txtDescripcion);
			else
				if (leerNombreCorto().length() == 0)
					Lib.mensajeError(this, "Ingrese NOMBRE CORTO", txtNombreCorto);
				else 
					if (leerNombreLargo().length() == 0)
						Lib.mensajeError(this, "Ingrese NOMBRE LARGO", txtNombreLargo);
					else {
						if (adicionar) {
							Area nueva = new Area(leerCodigo(), leerNombre(), 
			                                      leerDescripcion(), leerNombreCorto(),
					                              leerNombreLargo(), leerPosEstado());
							ProyectoDemo_AED.aa.adicionar(nueva);
							Lib.mensajeInformacion(this, "El Área ha sido adicionada");
						}
						else {
							Area x = ProyectoDemo_AED.aa.buscar(leerCodigo());
							x.setNombre(leerNombre());
							x.setDescripcion(leerDescripcion());
							x.setNombreCorto(leerNombreCorto());
							x.setNombreLargo(leerNombreLargo());
							x.setEstado(leerPosEstado());
							Lib.mensajeInformacion(this, "El Área ha sido modificada");
						}
						dispose();
					}
	}
	//  Consulta el área en curso
	void consultarArea() {
		dispose();
	}
	//  Elimina el área en curso
	void eliminarArea() {
		int ok = Lib.mensajeConfirmacion(this, "¿Está seguro de eliminar el Área?");
		if (ok == 0) {
			Area x = ProyectoDemo_AED.aa.buscar(leerCodigo());
			ProyectoDemo_AED.aa.eliminar(x);
			Lib.mensajeInformacion(this, "El Área ha sido eliminada");
			dispose();
		}
	}
	//  Establece el tipo de operación a afectuar
	void setTipoOperacion(int tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}
	//  Carga los datos de un área
	void cargarArea(Area x) {
		lblCodigo.setText("" + x.getCodigo());
		txtNombre.setText(x.getNombre());
		txtNombreCorto.setText(x.getNombreCorto());
		txtNombreLargo.setText(x.getNombreLargo());
		txtDescripcion.setText(x.getDescripcion());			
		cboEstado.setSelectedIndex(x.getEstado());	
	}
	//  Configura el formulario para la operación a efectuar
	void configurarFormulario() {
		switch (tipoOperacion) {
			case 0:
				mostrarCodigoAutogenerado();
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
	//  Muestra el código autogenerado
	void mostrarCodigoAutogenerado() {
		lblCodigo.setText("" + ProyectoDemo_AED.aa.generarCodigo());
	}
	//  Habilita o deshabilita las cajas de texto
	void habilitarCajasDeTexto(boolean sino) {
		txtNombre.setEditable(sino);
		txtDescripcion.setEditable(sino);
		txtNombreCorto.setEditable(sino);
		txtNombreLargo.setEditable(sino);
		cboEstado.setEnabled(sino);
	}
	//  Métodos que retornan valor (sin parámetros)
	int leerCodigo() {
		return Lib.leerEntero(lblCodigo);
	}
	String leerNombre() {
		return Lib.leerCadena(txtNombre);
	}
	String leerDescripcion() {
		return Lib.leerCadenaGrande(txtDescripcion);
	}
	String leerNombreCorto() {
		return Lib.leerCadena(txtNombreCorto);
	}
	String leerNombreLargo() {
		return Lib.leerCadena(txtNombreLargo);
	}
	int leerPosEstado() {
		return cboEstado.getSelectedIndex();
	}
	
}