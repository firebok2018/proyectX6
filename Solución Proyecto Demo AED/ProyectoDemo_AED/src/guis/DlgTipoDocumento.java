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

import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.Font;

public class DlgTipoDocumento extends JDialog implements ActionListener, WindowListener {

	private static final long serialVersionUID = 1L;
	
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnConsultar;
	private JButton btnEliminar;
	private JButton btnSalir;
	private JScrollPane scrollPane;
	private JTable tblTipoDocumento;
	
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
					DlgTipoDocumento dialog = new DlgTipoDocumento();
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
	public DlgTipoDocumento() {
		addWindowListener(this);
		setResizable(false);
		setTitle("Mantenimiento | Tipo documento");
		setBounds(100, 100, 1026, 630);		
		getContentPane().setLayout(null);
		
		btnAdicionar = new JButton("adicionar", new ImageIcon("imagenes/adicionar.png"));
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(10, 10, 200, 50);
		getContentPane().add(btnAdicionar);
		
		btnConsultar = new JButton("consultar", new ImageIcon("imagenes/consultar.png"));		
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(210, 10, 200, 50);
		getContentPane().add(btnConsultar);
		
		btnModificar = new JButton("modificar", new ImageIcon("imagenes/modificar.png"));
		btnModificar.addActionListener(this);
		btnModificar.setBounds(410, 10, 200, 50);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("eliminar", new ImageIcon("imagenes/eliminar.png"));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(610, 10, 200, 50);
		getContentPane().add(btnEliminar);
		
		btnSalir = new JButton("salir", new ImageIcon("imagenes/salir.png"));
		btnSalir.addActionListener(this);
		btnSalir.setBounds(810, 10, 200, 50);
		getContentPane().add(btnSalir);
	
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 70, 1000, 520);
		getContentPane().add(scrollPane);
		
		tblTipoDocumento = new JTable();
		tblTipoDocumento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tblTipoDocumento.setModel(ProyectoDemo_AED.atd);
		tblTipoDocumento.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblTipoDocumento.setFillsViewportHeight(true);
		tblTipoDocumento.getSelectionModel().setSelectionInterval(0, 0);
		
		scrollPane.setViewportView(tblTipoDocumento);
		
		ajustarAnchoColumnas();	
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnSalir) {
			actionPerformedBtnSalir(arg0);
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
		tipoOperacion = 0;
		lanzarFormulario();
	}
	protected void actionPerformedBtnConsultar(ActionEvent arg0) {
		tipoOperacion = 1;
		lanzarFormulario();
	}
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		tipoOperacion = 2;
		lanzarFormulario();
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		tipoOperacion = 3;
		lanzarFormulario();
	}
	protected void actionPerformedBtnSalir(ActionEvent arg0) {
		ProyectoDemo_AED.atd.grabarTipoDocumentos();		
		dispose();
	}
	public void windowActivated(WindowEvent arg0) {
	}
	public void windowClosed(WindowEvent arg0) {
	}
	public void windowClosing(WindowEvent arg0) {
		ProyectoDemo_AED.atd.grabarTipoDocumentos();
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
		DlgTipoDocumentoActividad dtda = new DlgTipoDocumentoActividad();
		dtda.setTipoOperacion(tipoOperacion);
		dtda.setTitle(this.getTitle() + " | " + obtenerTitulo());
		dtda.configurarFormulario();
		dtda.setLocationRelativeTo(this);
		if (tipoOperacion != 0)
			dtda.cargarTipoDocumento(ProyectoDemo_AED.atd.obtener(tblTipoDocumento.getSelectedRow()));
		dtda.setVisible(true);
	}
	void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblTipoDocumento.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(10));  // codigo
		tcm.getColumn(1).setPreferredWidth(anchoColumna(55));  // descripcion
		tcm.getColumn(2).setPreferredWidth(anchoColumna(25));  // abreviacion
		tcm.getColumn(3).setPreferredWidth(anchoColumna(10));  // estado
	}	
	//  Métodos que retornan valor (sin parámetros)
	String obtenerTitulo() {
		String titulo[] = { "Adicionar", "Consultar" ,
				            "Modificar", "Eliminar" };
		return titulo[tipoOperacion];
	}
	//  Métodos que retornan valor (con parámetros)
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}	
	
}