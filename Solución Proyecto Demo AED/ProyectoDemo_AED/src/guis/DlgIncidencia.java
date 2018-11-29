package guis;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.TableColumnModel;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.Font;

public class DlgIncidencia extends JDialog implements ActionListener, WindowListener {

	private static final long serialVersionUID = 1L;
	
	private JButton btnIngresar;
	private JButton btnActualizar;
	private JButton btnSalir;
	private JScrollPane scrollPane;
	private JTable tblIncidencia;
	
	private int tipoOperacion;
		
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
					DlgIncidencia dialog = new DlgIncidencia();
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
	public DlgIncidencia() {
		addWindowListener(this);
		setResizable(false);
		setTitle("Edición | Incidencia");
		setBounds(100, 100, 1026, 630);		
		getContentPane().setLayout(null);
		
		btnIngresar = new JButton("ingresar");		
		btnIngresar.setFont(new Font("Cambria", Font.BOLD, 12));
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(10, 10, 200, 50);
		btnIngresar.setIcon(new ImageIcon("imagenes/adicionar.png"));
		getContentPane().add(btnIngresar);
		
		btnActualizar = new JButton("actualizar");
		btnActualizar.setFont(new Font("Cambria", Font.BOLD, 12));
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(210, 10, 200, 50);
		btnActualizar.setIcon(new ImageIcon("imagenes/modificar.png"));
		getContentPane().add(btnActualizar);
		
		btnSalir = new JButton("salir");
		btnSalir.setFont(new Font("Cambria", Font.BOLD, 12));
		btnSalir.addActionListener(this);
		btnSalir.setBounds(810, 10, 200, 50);
		btnSalir.setIcon(new ImageIcon("imagenes/salir.png"));
		getContentPane().add(btnSalir);
	
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 70, 1000, 520);
		getContentPane().add(scrollPane);
		
		tblIncidencia = new JTable();
		tblIncidencia.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tblIncidencia.setModel(ProyectoDemo_AED.ai);
		tblIncidencia.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblIncidencia.setFillsViewportHeight(true);
		tblIncidencia.getSelectionModel().setSelectionInterval(0, 0);		
		
		scrollPane.setViewportView(tblIncidencia);
		
		ajustarAnchoColumnas();	
	}	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnSalir) {
			actionPerformedBtnSalir(arg0);
		}
		if (arg0.getSource() == btnActualizar) {
			actionPerformedBtnActualizar(arg0);
		}
		if (arg0.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(arg0);
		}
	}
	protected void actionPerformedBtnIngresar(ActionEvent arg0) {
		tipoOperacion = 0;
		lanzarFormulario();
	}
	protected void actionPerformedBtnActualizar(ActionEvent arg0) {
		tipoOperacion = 1;
		lanzarFormulario();
	}
	protected void actionPerformedBtnSalir(ActionEvent arg0) {
		ProyectoDemo_AED.ai.grabarIncidencias();		
		dispose();
	}
	public void windowActivated(WindowEvent arg0) {
	}
	public void windowClosed(WindowEvent arg0) {
	}
	public void windowClosing(WindowEvent arg0) {
		ProyectoDemo_AED.ai.grabarIncidencias();
	}
	public void windowDeactivated(WindowEvent arg0) {
	}
	public void windowDeiconified(WindowEvent arg0) {
	}
	public void windowIconified(WindowEvent arg0) {
	}
	public void windowOpened(WindowEvent arg0) {
	}
	//  Métodos tipo void (sin parámetros)
	void lanzarFormulario() {
		DlgIncidenciaActividad dia = new DlgIncidenciaActividad();
		dia.setTipoOperacion(tipoOperacion);
		dia.setTitle(this.getTitle() + " | " + obtenerTitulo());
		dia.configurarFormulario();
		dia.setLocationRelativeTo(this);
		if (tipoOperacion != 0)
			dia.cargarIncidencia(ProyectoDemo_AED.ai.obtener(tblIncidencia.getSelectedRow()));
		dia.setVisible(true);
	}
	void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblIncidencia.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna( 5));  // codigo
		tcm.getColumn(1).setPreferredWidth(anchoColumna( 5));  // codigoUsuario
		tcm.getColumn(2).setPreferredWidth(anchoColumna( 5));  // codigoEspecialista
		tcm.getColumn(3).setPreferredWidth(anchoColumna( 5));  // codigoTipoIncidencia
		tcm.getColumn(4).setPreferredWidth(anchoColumna(20));  // descripcion
		tcm.getColumn(5).setPreferredWidth(anchoColumna(24));  // comentario
		tcm.getColumn(6).setPreferredWidth(anchoColumna( 4));  // tiempoEstimadoSol
		tcm.getColumn(7).setPreferredWidth(anchoColumna( 4));  // tiempoRealSol
		tcm.getColumn(8).setPreferredWidth(anchoColumna( 7));  // fechaRegistro
		tcm.getColumn(9).setPreferredWidth(anchoColumna( 7));  // fechaInicioAtencion
		tcm.getColumn(10).setPreferredWidth(anchoColumna(7));  // fechaFinAtencion
		tcm.getColumn(11).setPreferredWidth(anchoColumna(7));  // estado
	}
	//  Métodos que retornan valor (sin parámetros)
	String obtenerTitulo() {
		String titulo[] = { "Ingresar", "Actualizar" };
		return titulo[tipoOperacion];
	}
	//  Métodos que retornan valor (con parámetros)
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	
}