package guis;

import arreglos.*;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProyectoDemo_AED extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JMenuBar menuProyecto;
	private JMenu mnArchivo;
	private JMenu mnMantenimiento;
	private JMenu mnEdicion;
	private JMenu mnReporte;
	private JMenuItem mntmSalir;
	private JMenuItem mntmUsuario;
	private JMenuItem mntmArea;
	private JMenuItem mntmTipoIncidencia;
	private JMenuItem mntmTipoDocumento;	
	private JMenuItem mntmEspecialista;
	private JMenuItem mntmIncidencia;
	private JMenuItem mntmIncidenciasPorArea;
	private JMenuItem mntmIncidenciasPorTipo;
	private JMenuItem mntmIncidenciasPorFecha;
	private JMenuItem mntmIncidenciasPorSuceso;
	private JLabel lblFondo;

	public static ArregloUsuarios au = new ArregloUsuarios();
	public static ArregloAreas aa = new ArregloAreas();
	public static ArregloTipoIncidencias ati = new ArregloTipoIncidencias();
	public static ArregloTipoDocumentos atd = new ArregloTipoDocumentos();
	public static ArregloEspecialistas ae = new ArregloEspecialistas();
	public static ArregloIncidencias ai = new ArregloIncidencias();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProyectoDemo_AED frame = new ProyectoDemo_AED();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public ProyectoDemo_AED() {
		int ANCHO = 1078, ALTO = 720,
		    DX = 6, DY = 52;
		
		setResizable(false);
		setTitle("MN-Global ® >>> PrimaTaxi ® >>> Proyecto Demo AED - 15/01/2018");
		setIconImage(new ImageIcon("imagenes/PrimaTaxi.png").getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, ANCHO + DX, ALTO + DY);
		this.setLocationRelativeTo(null);
		
		menuProyecto = new JMenuBar();
		setJMenuBar(menuProyecto);
	
		mnArchivo = new JMenu("Archivo");
		menuProyecto.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mntmSalir.setIcon(new ImageIcon("imagenes/salir.png"));
		mnArchivo.add(mntmSalir);
			
		mnMantenimiento = new JMenu("Mantenimiento");
		menuProyecto.add(mnMantenimiento);
		
		mntmUsuario = new JMenuItem("Usuario");
		mntmUsuario.addActionListener(this);
		mntmUsuario.setIcon(new ImageIcon("imagenes/usuario.png"));
		mnMantenimiento.add(mntmUsuario);
		
		mntmArea = new JMenuItem("\u00C1rea");		
		mntmArea.addActionListener(this);
		mntmArea.setIcon(new ImageIcon("imagenes/area.png"));
		mnMantenimiento.add(mntmArea);
		
		mntmTipoIncidencia = new JMenuItem("Tipo Incidencia");
		mntmTipoIncidencia.setIcon(new ImageIcon("imagenes/tipoIncidencia.png"));
		mntmTipoIncidencia.addActionListener(this);		
		mnMantenimiento.add(mntmTipoIncidencia);
		
		mntmTipoDocumento = new JMenuItem("Tipo Documento");
		mntmTipoDocumento.addActionListener(this);
		mntmTipoDocumento.setIcon(new ImageIcon("imagenes/tipoDocumento.png"));
		mnMantenimiento.add(mntmTipoDocumento);
		
		mntmEspecialista = new JMenuItem("Especialista");
		mntmEspecialista.addActionListener(this);
		mntmEspecialista.setIcon(new ImageIcon("imagenes/especialista.png"));
		mnMantenimiento.add(mntmEspecialista);
		
		mnEdicion = new JMenu("Edici\u00F3n");
		menuProyecto.add(mnEdicion);
		
		mntmIncidencia = new JMenuItem("Incidencia");
		mntmIncidencia.setIcon(new ImageIcon("imagenes/incidencia.png"));
		mntmIncidencia.addActionListener(this);
		mnEdicion.add(mntmIncidencia);
		
		mnReporte = new JMenu("Reporte");
		menuProyecto.add(mnReporte);
		
		mntmIncidenciasPorArea = new JMenuItem("Incidencias por área");
		mntmIncidenciasPorArea.setIcon(new ImageIcon("imagenes/listado.png"));
		mntmIncidenciasPorArea.addActionListener(this);
		mnReporte.add(mntmIncidenciasPorArea);
		
		mntmIncidenciasPorTipo = new JMenuItem("Incidencias por tipo");
		mntmIncidenciasPorTipo.setIcon(new ImageIcon("imagenes/listado.png"));
		mntmIncidenciasPorTipo.addActionListener(this);
		mnReporte.add(mntmIncidenciasPorTipo);		
		
		mntmIncidenciasPorFecha = new JMenuItem("Incidencias por fecha");	
		mntmIncidenciasPorFecha.setIcon(new ImageIcon("imagenes/listado.png"));
		mntmIncidenciasPorFecha.addActionListener(this);
		mnReporte.add(mntmIncidenciasPorFecha);
		
		mntmIncidenciasPorSuceso = new JMenuItem("Incidencias por suceso");
		mntmIncidenciasPorSuceso.setIcon(new ImageIcon("imagenes/listado.png"));
		mntmIncidenciasPorSuceso.addActionListener(this);
		mnReporte.add(mntmIncidenciasPorSuceso);
		
		lblFondo = new JLabel(new ImageIcon("imagenes/MN-Global.jpg"));
		lblFondo.setBounds(0, 0, ANCHO, ALTO);
		getContentPane().add(lblFondo);			
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mntmIncidenciasPorSuceso) {
			actionPerformedMntmIncidenciasPorSuceso(arg0);
		}
		if (arg0.getSource() == mntmIncidenciasPorFecha) {
			actionPerformedMntmIncidenciasPorFecha(arg0);
		}
		if (arg0.getSource() == mntmIncidenciasPorTipo) {
			actionPerformedMntmIncidenciasPorTipo(arg0);
		}
		if (arg0.getSource() == mntmIncidenciasPorArea) {
			actionPerformedMntmIncidenciasPorArea(arg0);
		}
		if (arg0.getSource() == mntmIncidencia) {
			actionPerformedMntmIngreso(arg0);
		}		
		if (arg0.getSource() == mntmEspecialista) {
			actionPerformedMntmEspecialista(arg0);
		}	
		if (arg0.getSource() == mntmTipoDocumento) {
			actionPerformedMntmTipoDocumento(arg0);
		}	
		if (arg0.getSource() == mntmTipoIncidencia) {
			actionPerformedMntmTipoIncidencia(arg0);
		}
		if (arg0.getSource() == mntmArea) {
			actionPerformedMntmArea(arg0);
		}
		if (arg0.getSource() == mntmUsuario) {
			actionPerformedMntmUsuario(arg0);
		}
		if (arg0.getSource() == mntmSalir) {
			actionPerformedMntmSalir(arg0);
		}
	}
	protected void actionPerformedMntmIncidenciasPorSuceso(ActionEvent arg0) {
		DlgIncidenciasPorSuceso MnGlobal = new DlgIncidenciasPorSuceso();
		MnGlobal.setLocationRelativeTo(this);
		MnGlobal.setVisible(true);
	}
	protected void actionPerformedMntmIncidenciasPorFecha(ActionEvent arg0) {
	    DlgIncidenciasPorFecha MnGlobal = new DlgIncidenciasPorFecha();
	    MnGlobal.setLocationRelativeTo(this);
	    MnGlobal.setVisible(true);
	}
	protected void actionPerformedMntmIncidenciasPorTipo(ActionEvent arg0) {
		DlgIncidenciasPorTipo MnGlobal = new DlgIncidenciasPorTipo();
		MnGlobal.setLocationRelativeTo(this);
		MnGlobal.setVisible(true);
	}
	protected void actionPerformedMntmIncidenciasPorArea(ActionEvent arg0) {		
		DlgIncidenciasPorArea MnGlobal = new DlgIncidenciasPorArea();
		MnGlobal.setLocationRelativeTo(this);
		MnGlobal.setVisible(true);
	}
	protected void actionPerformedMntmIngreso(ActionEvent arg0) {
		DlgIncidencia di = new DlgIncidencia();
		di.setLocationRelativeTo(this);
		di.setVisible(true);
	}
	protected void actionPerformedMntmEspecialista(ActionEvent arg0) {		
		DlgEspecialista MnGlobal = new DlgEspecialista();
		MnGlobal.setLocationRelativeTo(this);
		MnGlobal.setVisible(true);
	}
	protected void actionPerformedMntmTipoDocumento(ActionEvent arg0) {		
		DlgTipoDocumento MnGlobal = new DlgTipoDocumento();
		MnGlobal.setLocationRelativeTo(this);
		MnGlobal.setVisible(true);
	}	
	protected void actionPerformedMntmTipoIncidencia(ActionEvent arg0) {
		DlgTipoIncidencia MnGlobal = new DlgTipoIncidencia();
		MnGlobal.setLocationRelativeTo(this);
		MnGlobal.setVisible(true);
	}	
	protected void actionPerformedMntmArea(ActionEvent arg0) {	
		DlgArea MnGlobal = new DlgArea();
		MnGlobal.setLocationRelativeTo(this);
		MnGlobal.setVisible(true);
	}	
	protected void actionPerformedMntmUsuario(ActionEvent arg0) {		
		DlgUsuario MnGlobal = new DlgUsuario();
		MnGlobal.setLocationRelativeTo(this);
		MnGlobal.setVisible(true);
	}
	protected void actionPerformedMntmSalir(ActionEvent arg0) {
		int ok = confirmacionDeSalida();	
		if (ok == 0)
			System.exit(0);			
	}
	//  Métodos que retornan valor (sin parámetros)
	int confirmacionDeSalida() {
		return JOptionPane.showConfirmDialog(this,
			   "¿ Desea salir del Sistema ?",
			   "MN-Global ® >>> PrimaTaxi ®", 0, -1, new ImageIcon("imagenes/addUser.png"));
	}
	
}