package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class FrmPrincipal extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenu mnMantenimiento;
	private JMenuItem mntmCategora;
	public static JDesktopPane desktopPane;
	private JMenuItem mntmMarca;
	private JMenuItem mntmProducto;
	private JMenuItem mntmCerrarSesin;
	private JMenuItem mntmSalir;
	private JMenu mnOrdenDeCompra;
	private JMenu mnVenta;
	private JMenu mnConsulta;
	private JMenu mnAyuda;
	private JMenuItem mntmAcercaDe;
	private JMenuItem mntmAbastecimiento;
	private JMenuItem mntmCliente;
	private JMenuItem mntmCuentaBancaria;
	private JMenuItem mntmDistrito;
	private JMenuItem mntmEmpleado;
	private JMenuItem mntmProveedor;
	private JMenuItem mntmTransportista;
	private JMenuItem mntmUsuario;
	private JMenuItem mntmOrdenDeCompra;
	private JMenuItem mntmVenta;
	private JMenuItem mntmAbastecimiento_1;
	private JMenuItem mntmCliente_1;
	private JMenuItem mntmCuentaBancaria_1;
	private JMenuItem mntmOrdenDeCompra_1;
	private JMenuItem mntmProducto_1;
	private JMenuItem mntmProveedor_1;
	private JMenuItem mntmTransportista_1;
	private JMenuItem mntmVenta_1;

	// Tamaño de formulario

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal frame = new FrmPrincipal();
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
	public FrmPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmPrincipal.class.getResource("/img/logo_dek_min.png")));
		setTitle("Dek Electric Solutions 1.0");
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 873, 576);
		
		menuBar = new JMenuBar();
		menuBar.setPreferredSize(new Dimension(0, 50));
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		mnArchivo.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/archivo.png")));
		mnArchivo.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(mnArchivo);
		
		mntmCerrarSesin = new JMenuItem("Cerrar sesi\u00F3n");
		mntmCerrarSesin.addActionListener(this);
		mnArchivo.add(mntmCerrarSesin);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mnArchivo.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/mantenimiento.png")));
		mnMantenimiento.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(mnMantenimiento);
		
		mntmCategora = new JMenuItem("Categor\u00EDa");
		mntmCategora.addActionListener(this);
		
		mntmAbastecimiento = new JMenuItem("Abastecimiento");
		mntmAbastecimiento.addActionListener(this);
		
		mntmCliente = new JMenuItem("Cliente");
		mntmCliente.addActionListener(this);
		mnMantenimiento.add(mntmCliente);
		mnMantenimiento.add(mntmAbastecimiento);
		mnMantenimiento.add(mntmCategora);
		
		mntmMarca = new JMenuItem("Marca");
		mntmMarca.addActionListener(this);
		mnMantenimiento.add(mntmMarca);
		
		mntmProducto = new JMenuItem("Producto");
		mntmProducto.addActionListener(this);
		mnMantenimiento.add(mntmProducto);
		
		mntmCuentaBancaria = new JMenuItem("Cuenta bancaria");
		mntmCuentaBancaria.addActionListener(this);
		mnMantenimiento.add(mntmCuentaBancaria);
		
		mntmDistrito = new JMenuItem("Distrito");
		mntmDistrito.addActionListener(this);
		mnMantenimiento.add(mntmDistrito);
		
		mntmEmpleado = new JMenuItem("Empleado");
		mntmEmpleado.addActionListener(this);
		mnMantenimiento.add(mntmEmpleado);
		
		mntmProveedor = new JMenuItem("Proveedor");
		mntmProveedor.addActionListener(this);
		mnMantenimiento.add(mntmProveedor);
		
		mntmTransportista = new JMenuItem("Transportista");
		mntmTransportista.addActionListener(this);
		mnMantenimiento.add(mntmTransportista);
		
		mntmUsuario = new JMenuItem("Usuario");
		mntmUsuario.addActionListener(this);
		mnMantenimiento.add(mntmUsuario);
		
		mnOrdenDeCompra = new JMenu("Orden de compra");
		mnOrdenDeCompra.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/compra.png")));
		mnOrdenDeCompra.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(mnOrdenDeCompra);
		
		mntmOrdenDeCompra = new JMenuItem("Orden de compra");
		mntmOrdenDeCompra.addActionListener(this);
		mnOrdenDeCompra.add(mntmOrdenDeCompra);
		
		mnVenta = new JMenu("Venta");
		mnVenta.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/venta.png")));
		mnVenta.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(mnVenta);
		
		mntmVenta = new JMenuItem("Venta");
		mntmVenta.addActionListener(this);
		mnVenta.add(mntmVenta);
		
		mnConsulta = new JMenu("Consulta");
		mnConsulta.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/consulta.png")));
		mnConsulta.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(mnConsulta);
		
		mntmAbastecimiento_1 = new JMenuItem("Abastecimiento");
		mntmAbastecimiento_1.addActionListener(this);
		mnConsulta.add(mntmAbastecimiento_1);
		
		mntmCliente_1 = new JMenuItem("Cliente");
		mntmCliente_1.addActionListener(this);
		mnConsulta.add(mntmCliente_1);
		
		mntmCuentaBancaria_1 = new JMenuItem("Cuenta bancaria");
		mntmCuentaBancaria_1.addActionListener(this);
		mnConsulta.add(mntmCuentaBancaria_1);
		
		mntmOrdenDeCompra_1 = new JMenuItem("Orden de compra");
		mntmOrdenDeCompra_1.addActionListener(this);
		mnConsulta.add(mntmOrdenDeCompra_1);
		
		mntmProducto_1 = new JMenuItem("Producto");
		mntmProducto_1.addActionListener(this);
		mnConsulta.add(mntmProducto_1);
		
		mntmProveedor_1 = new JMenuItem("Proveedor");
		mntmProveedor_1.addActionListener(this);
		mnConsulta.add(mntmProveedor_1);
		
		mntmTransportista_1 = new JMenuItem("Transportista");
		mntmTransportista_1.addActionListener(this);
		mnConsulta.add(mntmTransportista_1);
		
		mntmVenta_1 = new JMenuItem("Venta");
		mntmVenta_1.addActionListener(this);
		mnConsulta.add(mntmVenta_1);
		
		mnAyuda = new JMenu("Ayuda");
		mnAyuda.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/ayuda.png")));
		mnAyuda.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(mnAyuda);
		
		mntmAcercaDe = new JMenuItem("Acerca de...");
		mnAyuda.add(mntmAcercaDe);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);
		contentPane.add(desktopPane, BorderLayout.CENTER);
				
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mntmCerrarSesin) {
			actionPerformedMntmCerrarSesin(arg0);
		}
		if (arg0.getSource() == mntmVenta_1) {
			actionPerformedMntmVenta_1(arg0);
		}
		if (arg0.getSource() == mntmTransportista_1) {
			actionPerformedMntmTransportista_1(arg0);
		}
		if (arg0.getSource() == mntmProveedor_1) {
			actionPerformedMntmProveedor_1(arg0);
		}
		if (arg0.getSource() == mntmProducto_1) {
			actionPerformedMntmProducto_1(arg0);
		}
		if (arg0.getSource() == mntmOrdenDeCompra_1) {
			actionPerformedMntmOrdenDeCompra_1(arg0);
		}
		if (arg0.getSource() == mntmCuentaBancaria_1) {
			actionPerformedMntmCuentaBancaria_1(arg0);
		}
		if (arg0.getSource() == mntmCliente_1) {
			actionPerformedMntmCliente_1(arg0);
		}
		if (arg0.getSource() == mntmAbastecimiento_1) {
			actionPerformedMntmAbastecimiento_1(arg0);
		}
		if (arg0.getSource() == mntmVenta) {
			actionPerformedMntmVenta(arg0);
		}
		if (arg0.getSource() == mntmOrdenDeCompra) {
			actionPerformedMntmOrdenDeCompra(arg0);
		}
		if (arg0.getSource() == mntmUsuario) {
			actionPerformedMntmUsuario(arg0);
		}
		if (arg0.getSource() == mntmTransportista) {
			actionPerformedMntmTransportista(arg0);
		}
		if (arg0.getSource() == mntmProveedor) {
			actionPerformedMntmProveedor(arg0);
		}
		if (arg0.getSource() == mntmEmpleado) {
			actionPerformedMntmEmpleado(arg0);
		}
		if (arg0.getSource() == mntmDistrito) {
			actionPerformedMntmDistrito(arg0);
		}
		if (arg0.getSource() == mntmCuentaBancaria) {
			actionPerformedMntmCuentaBancaria(arg0);
		}
		if (arg0.getSource() == mntmCliente) {
			actionPerformedMntmCliente(arg0);
		}
		if (arg0.getSource() == mntmAbastecimiento) {
			actionPerformedMntmAbastecimiento(arg0);
		}
		if (arg0.getSource() == mntmSalir) {
			actionPerformedMntmSalir(arg0);
		}
		if (arg0.getSource() == mntmProducto) {
			actionPerformedMntmProducto(arg0);
		}
		if (arg0.getSource() == mntmMarca) {
			actionPerformedMntmMarca(arg0);
		}
		if (arg0.getSource() == mntmCategora) {
			actionPerformedMntmCategora(arg0);
		}
	}
	protected void actionPerformedMntmCategora(ActionEvent arg0) {
		FrmCategoria fc=new FrmCategoria();				
		desktopPane.add(fc);
		Dimension desktopSize = desktopPane.getSize();
		Dimension FrameSize = fc.getSize();		
		fc.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
		fc.setVisible(true);
	}
	protected void actionPerformedMntmMarca(ActionEvent arg0) {
		FrmMarca fm=new FrmMarca();				
		desktopPane.add(fm);
		Dimension desktopSize = desktopPane.getSize();
		Dimension FrameSize = fm.getSize();
		fm.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
		fm.setVisible(true);
	}
	protected void actionPerformedMntmProducto(ActionEvent arg0) {
		FrmProducto fp=new FrmProducto();				
		desktopPane.add(fp);
		Dimension desktopSize = desktopPane.getSize();
		Dimension FrameSize = fp.getSize();
		fp.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
		fp.setVisible(true);
	}
	protected void actionPerformedMntmSalir(ActionEvent arg0) {
		System.exit(0);
	}
	protected void actionPerformedMntmAbastecimiento(ActionEvent arg0) {
		FrmAbastecimiento fa=new FrmAbastecimiento();
		desktopPane.add(fa);
		Dimension desktopSize = desktopPane.getSize();
        Dimension FrameSize = fa.getSize();
        fa.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
		fa.setVisible(true);		
	}
	protected void actionPerformedMntmCliente(ActionEvent arg0) {
		FrmCliente fc=new FrmCliente();
		desktopPane.add(fc);
		Dimension desktopSize = desktopPane.getSize();
        Dimension FrameSize = fc.getSize();
        fc.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
		fc.setVisible(true);	
	}
	protected void actionPerformedMntmCuentaBancaria(ActionEvent arg0) {
		FrmCuentaBancaria fcb=new FrmCuentaBancaria();
		desktopPane.add(fcb);	
		Dimension desktopSize = desktopPane.getSize();
        Dimension FrameSize = fcb.getSize();
        fcb.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        fcb.setVisible(true);
	}
	protected void actionPerformedMntmDistrito(ActionEvent arg0) {
		FrmDistrito fd=new FrmDistrito();
		desktopPane.add(fd);
		Dimension desktopSize = desktopPane.getSize();
        Dimension FrameSize = fd.getSize();
        fd.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        fd.setVisible(true);
	}
	protected void actionPerformedMntmEmpleado(ActionEvent arg0) {
		FrmEmpleado fe=new FrmEmpleado();
		desktopPane.add(fe);
		Dimension desktopSize = desktopPane.getSize();
        Dimension FrameSize = fe.getSize();
        fe.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        fe.setVisible(true);
	}
	protected void actionPerformedMntmProveedor(ActionEvent arg0) {
		FrmProveedor fp=new FrmProveedor();
		desktopPane.add(fp);
		Dimension desktopSize = desktopPane.getSize();
        Dimension FrameSize = fp.getSize();
        fp.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        fp.setVisible(true);
	}
	protected void actionPerformedMntmTransportista(ActionEvent arg0) {
		FrmTransportista ft=new FrmTransportista();
		desktopPane.add(ft);
		Dimension desktopSize = desktopPane.getSize();
        Dimension FrameSize = ft.getSize();
        ft.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        ft.setVisible(true);
	}
	protected void actionPerformedMntmUsuario(ActionEvent arg0) {
		FrmUsuario fu=new FrmUsuario();
		desktopPane.add(fu);
		Dimension desktopSize = desktopPane.getSize();
        Dimension FrameSize = fu.getSize();
        fu.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        fu.setVisible(true);
	}
	protected void actionPerformedMntmOrdenDeCompra(ActionEvent arg0) {
		FrmOrdenCompra foc=new FrmOrdenCompra();
		desktopPane.add(foc);
		Dimension desktopSize = desktopPane.getSize();
        Dimension FrameSize = foc.getSize();
        foc.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        foc.setVisible(true);
	}
	protected void actionPerformedMntmVenta(ActionEvent arg0) {
		FrmVenta fv=new FrmVenta();
		desktopPane.add(fv);
		Dimension desktopSize = desktopPane.getSize();
        Dimension FrameSize = fv.getSize();
        fv.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        fv.setVisible(true);
	}
	protected void actionPerformedMntmAbastecimiento_1(ActionEvent arg0) {
		FrmConsultaAbastecimiento fca=new FrmConsultaAbastecimiento();
		desktopPane.add(fca);
		Dimension desktopSize = desktopPane.getSize();
        Dimension FrameSize = fca.getSize();
        fca.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        fca.setVisible(true);
	}
	protected void actionPerformedMntmCliente_1(ActionEvent arg0) {
		FrmConsultaCliente fcc=new FrmConsultaCliente();
		desktopPane.add(fcc);
		Dimension desktopSize = desktopPane.getSize();
        Dimension FrameSize = fcc.getSize();
        fcc.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        fcc.setVisible(true);
	}
	protected void actionPerformedMntmCuentaBancaria_1(ActionEvent arg0) {
		FrmConsultaCuentaBancaria fcb=new FrmConsultaCuentaBancaria();
		desktopPane.add(fcb);
		Dimension desktopSize = desktopPane.getSize();
        Dimension FrameSize = fcb.getSize();
        fcb.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        fcb.setVisible(true);
	}
	protected void actionPerformedMntmOrdenDeCompra_1(ActionEvent arg0) {
		FrmConsultaOrdenCompra fco=new FrmConsultaOrdenCompra();
		desktopPane.add(fco);
		Dimension desktopSize = desktopPane.getSize();
        Dimension FrameSize = fco.getSize();
        fco.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        fco.setVisible(true);
	}
	protected void actionPerformedMntmProducto_1(ActionEvent arg0) {
		FrmConsultaProducto fcp=new FrmConsultaProducto();
		desktopPane.add(fcp);
		Dimension desktopSize = desktopPane.getSize();
        Dimension FrameSize = fcp.getSize();
        fcp.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        fcp.setVisible(true);
	}
	protected void actionPerformedMntmProveedor_1(ActionEvent arg0) {
		FrmConsultaProveedor fcpr=new FrmConsultaProveedor();
		desktopPane.add(fcpr);
		Dimension desktopSize = desktopPane.getSize();
        Dimension FrameSize = fcpr.getSize();
        fcpr.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        fcpr.setVisible(true);
	}
	protected void actionPerformedMntmTransportista_1(ActionEvent arg0) {
		FrmConsultaTransportista fct=new FrmConsultaTransportista();
		desktopPane.add(fct);
		Dimension desktopSize = desktopPane.getSize();
        Dimension FrameSize = fct.getSize();
        fct.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        fct.setVisible(true);
	}
	protected void actionPerformedMntmVenta_1(ActionEvent arg0) {
		FrmConsultaVenta fcv=new FrmConsultaVenta();
		desktopPane.add(fcv);
		Dimension desktopSize = desktopPane.getSize();
        Dimension FrameSize = fcv.getSize();
        fcv.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        fcv.setVisible(true);
	}
	protected void actionPerformedMntmCerrarSesin(ActionEvent arg0) {
		
		int input = JOptionPane.showConfirmDialog(null, "Desea cerrar la sesión?");
		if(input==0){
			this.dispose();
			FrmAccesoUsuario fau=new FrmAccesoUsuario();
			fau.setVisible(true);
		}
		
		
	}
}
