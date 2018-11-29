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

public class DlgArea extends JDialog implements ActionListener, WindowListener {

	private static final long serialVersionUID = 1L;
	
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnConsultar;
	private JButton btnEliminar;
	private JButton btnSalir;
	private JScrollPane scrollPane;
	private JTable tblArea;
	
	int tipoOperacion;
		
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
					DlgArea dialog = new DlgArea();
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
	public DlgArea() {
		addWindowListener(this);
		setResizable(false);
		setTitle("Mantenimiento | Área");
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
		
		tblArea = new JTable();
		tblArea.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tblArea.setModel(ProyectoDemo_AED.aa);
		tblArea.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblArea.setFillsViewportHeight(true);
		tblArea.getSelectionModel().setSelectionInterval(0, 0);
		
		scrollPane.setViewportView(tblArea);
		
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
		ProyectoDemo_AED.aa.grabarAreas();		
		dispose();
	}
	public void windowActivated(WindowEvent arg0) {
	}
	public void windowClosed(WindowEvent arg0) {
	}
	public void windowClosing(WindowEvent arg0) {
		ProyectoDemo_AED.aa.grabarAreas();
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
		DlgAreaActividad daa = new DlgAreaActividad();
		daa.setTipoOperacion(tipoOperacion);
		daa.setTitle(this.getTitle() + " | " + obtenerTitulo());
		daa.configurarFormulario();
		daa.setLocationRelativeTo(this);
		if (tipoOperacion != 0)
			daa.cargarArea(ProyectoDemo_AED.aa.obtener(tblArea.getSelectedRow()));
		daa.setVisible(true);
	}
	void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblArea.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna( 8));  // codigo
		tcm.getColumn(1).setPreferredWidth(anchoColumna(15));  // nombre
		tcm.getColumn(2).setPreferredWidth(anchoColumna(35));  // descripcion
		tcm.getColumn(3).setPreferredWidth(anchoColumna(14));  // nombreCorto
		tcm.getColumn(4).setPreferredWidth(anchoColumna(20));  // nombreLargo
		tcm.getColumn(5).setPreferredWidth(anchoColumna( 8));  // estado
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