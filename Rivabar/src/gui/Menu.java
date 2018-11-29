   package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Dimension;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.border.LineBorder;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;
import java.awt.Window.Type;

public class Menu extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnInformes;
	private JMenu mnPrecio;
	private JMenu mnProductos;
	private JMenu mnA;
	private JMenu mnArchivo;
	private JMenuItem mntmSalir;
	private JMenuItem mntmBoxYoMesa;
	private JMenuItem mntmProducto;
	private JMenuItem mntmCliente;
	private JMenuItem mntmPedido;
	private JMenuItem mntmAsignacinDeBox;
	private JMenuItem mntmConsulta;
	private JMenuItem mntmBoletaOFactura;
	private JMenuItem mntmCuentasPendientes;
	private JMenuItem mntmCuotasPagadas;
	private JMenuItem mntmStockApertura;
	private JMenuItem mntmStockCierre;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setType(Type.POPUP);
		setResizable(false);
		setForeground(Color.WHITE);
		setBackground(Color.BLACK);
		setFont(new Font("Bahnschrift", Font.BOLD, 13));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/imagen/logo.jpg")));
		setTitle("RIVABAR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 441);
		
		menuBar = new JMenuBar();
		menuBar.setBorder(null);
		menuBar.setFont(new Font("Dialog", Font.BOLD, 14));
		menuBar.setBackground(new Color(0, 0, 0));
		menuBar.setForeground(new Color(0, 0, 51));
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		mnArchivo.setIcon(new ImageIcon(Menu.class.getResource("/imagen/folder.png")));
		mnArchivo.setForeground(Color.WHITE);
		mnArchivo.setFont(new Font("Arial", Font.BOLD, 14));
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.setFont(new Font("Dialog", Font.BOLD, 13));
		mntmSalir.setIcon(new ImageIcon(Menu.class.getResource("/imagen/cancel.png")));
		mntmSalir.setBorder(null);
		mntmSalir.setBackground(Color.BLACK);
		mntmSalir.setForeground(Color.WHITE);
		mntmSalir.addActionListener(this);
		mnArchivo.add(mntmSalir);
		
		mnInformes = new JMenu("Actualizaci\u00F3n");
		mnInformes.setIcon(new ImageIcon(Menu.class.getResource("/imagen/process.png")));
		mnInformes.setForeground(Color.WHITE);
		mnInformes.setFont(new Font("Dialog", Font.BOLD, 14));
		menuBar.add(mnInformes);
		
		mntmBoxYoMesa = new JMenuItem("Box y/o Mesa");
		mntmBoxYoMesa.addActionListener(this);
		mntmBoxYoMesa.setIcon(new ImageIcon(Menu.class.getResource("/imagen/mesa.png")));
		mntmBoxYoMesa.setAlignmentY(Component.TOP_ALIGNMENT);
		mntmBoxYoMesa.setAlignmentX(Component.LEFT_ALIGNMENT);
		mntmBoxYoMesa.setBorder(null);
		mntmBoxYoMesa.setForeground(Color.WHITE);
		mntmBoxYoMesa.setFont(new Font("Dialog", Font.BOLD, 13));
		mntmBoxYoMesa.setBackground(Color.BLACK);
		mnInformes.add(mntmBoxYoMesa);
		
		mntmProducto = new JMenuItem("Producto");
		mntmProducto.addActionListener(this);
		mntmProducto.setIcon(new ImageIcon(Menu.class.getResource("/imagen/shop.png")));
		mntmProducto.setAlignmentY(Component.TOP_ALIGNMENT);
		mntmProducto.setAlignmentX(Component.LEFT_ALIGNMENT);
		mntmProducto.setBorder(null);
		mntmProducto.setForeground(Color.WHITE);
		mntmProducto.setFont(new Font("Dialog", Font.BOLD, 13));
		mntmProducto.setBackground(Color.BLACK);
		mnInformes.add(mntmProducto);
		
		mnPrecio = new JMenu("Registro");
		mnPrecio.setIcon(new ImageIcon(Menu.class.getResource("/imagen/database.png")));
		mnPrecio.setForeground(Color.WHITE);
		mnPrecio.setFont(new Font("Dialog", Font.BOLD, 14));
		menuBar.add(mnPrecio);
		
		mntmPedido = new JMenuItem("Pedido");
		mntmPedido.addActionListener(this);
		
		mntmCliente = new JMenuItem("Cliente");
		mnPrecio.add(mntmCliente);
		mntmCliente.addActionListener(this);
		mntmCliente.setIcon(new ImageIcon(Menu.class.getResource("/imagen/manager.png")));
		mntmCliente.setBorder(null);
		mntmCliente.setForeground(Color.WHITE);
		mntmCliente.setFont(new Font("Dialog", Font.BOLD, 13));
		mntmCliente.setBackground(Color.BLACK);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{menuBar, mnArchivo, mntmSalir, mnInformes, mntmBoxYoMesa, mntmProducto, mntmCliente, mnPrecio, mntmPedido, mntmAsignacinDeBox, mnProductos, mntmConsulta, mntmBoletaOFactura, mnA, mntmCuentasPendientes, mntmCuotasPagadas, mntmStockApertura, mntmStockCierre, contentPane, lblNewLabel}));
		mntmPedido.setIcon(new ImageIcon(Menu.class.getResource("/imagen/survey.png")));
		mntmPedido.setBorder(null);
		mntmPedido.setBackground(Color.BLACK);
		mntmPedido.setForeground(Color.WHITE);
		mntmPedido.setFont(new Font("Dialog", Font.BOLD, 13));
		mnPrecio.add(mntmPedido);
		
		mntmAsignacinDeBox = new JMenuItem("Asignaci\u00F3n de box");
		mntmAsignacinDeBox.addActionListener(this);
		mntmAsignacinDeBox.setIcon(new ImageIcon(Menu.class.getResource("/imagen/mesa.png")));
		mntmAsignacinDeBox.setBorder(null);
		mntmAsignacinDeBox.setBackground(Color.BLACK);
		mntmAsignacinDeBox.setForeground(Color.WHITE);
		mntmAsignacinDeBox.setFont(new Font("Dialog", Font.BOLD, 13));
		mnPrecio.add(mntmAsignacinDeBox);
		
		mnProductos = new JMenu("Pago");
		mnProductos.setIcon(new ImageIcon(Menu.class.getResource("/imagen/sales_performance.png")));
		mnProductos.setForeground(Color.WHITE);
		mnProductos.setFont(new Font("Dialog", Font.BOLD, 14));
		menuBar.add(mnProductos);
		
		mntmConsulta = new JMenuItem("Consulta");
		mntmConsulta.addActionListener(this);
		mntmConsulta.setIcon(new ImageIcon(Menu.class.getResource("/imagen/services.png")));
		mntmConsulta.setBorder(null);
		mntmConsulta.setForeground(Color.WHITE);
		mntmConsulta.setFont(new Font("Dialog", Font.BOLD, 13));
		mntmConsulta.setBackground(Color.BLACK);
		mnProductos.add(mntmConsulta);
		
		mntmBoletaOFactura = new JMenuItem("Boleta");
		mntmBoletaOFactura.addActionListener(this);
		mntmBoletaOFactura.setIcon(new ImageIcon(Menu.class.getResource("/imagen/boleta o factura.png")));
		mntmBoletaOFactura.setBorder(null);
		mntmBoletaOFactura.setForeground(Color.WHITE);
		mntmBoletaOFactura.setFont(new Font("Dialog", Font.BOLD, 13));
		mntmBoletaOFactura.setBackground(Color.BLACK);
		mnProductos.add(mntmBoletaOFactura);
		
		mnA = new JMenu("Reporte");
		mnA.setIcon(new ImageIcon(Menu.class.getResource("/imagen/statistics.png")));
		mnA.setBackground(Color.BLACK);
		mnA.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		mnA.setForeground(Color.WHITE);
		mnA.setFont(new Font("Arial", Font.BOLD, 13));
		menuBar.add(mnA);
		
		mntmCuentasPendientes = new JMenuItem("Cuentas pendientes");
		mntmCuentasPendientes.addActionListener(this);
		mntmCuentasPendientes.setIcon(new ImageIcon(Menu.class.getResource("/imagen/view_details.png")));
		mntmCuentasPendientes.setBackground(Color.BLACK);
		mntmCuentasPendientes.setForeground(Color.WHITE);
		mntmCuentasPendientes.setFont(new Font("Arial", Font.BOLD, 13));
		mntmCuentasPendientes.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		mnA.add(mntmCuentasPendientes);
		
		mntmCuotasPagadas = new JMenuItem("Cuentas pagadas");
		mntmCuotasPagadas.addActionListener(this);
		mntmCuotasPagadas.setIcon(new ImageIcon(Menu.class.getResource("/imagen/dinero.png")));
		mntmCuotasPagadas.setBackground(Color.BLACK);
		mntmCuotasPagadas.setForeground(Color.WHITE);
		mntmCuotasPagadas.setFont(new Font("Arial", Font.BOLD, 13));
		mntmCuotasPagadas.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		mnA.add(mntmCuotasPagadas);
		
		mntmStockApertura = new JMenuItem("Stock apertura");
		mntmStockApertura.addActionListener(this);
		mntmStockApertura.setIcon(new ImageIcon(Menu.class.getResource("/imagen/view_details.png")));
		mntmStockApertura.setBackground(Color.BLACK);
		mntmStockApertura.setForeground(Color.WHITE);
		mntmStockApertura.setFont(new Font("Arial", Font.BOLD, 13));
		mntmStockApertura.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		mnA.add(mntmStockApertura);
		
		mntmStockCierre = new JMenuItem("Stock cierre");
		mntmStockCierre.addActionListener(this);
		mntmStockCierre.setIcon(new ImageIcon(Menu.class.getResource("/imagen/todo_list.png")));
		mntmStockCierre.setBackground(Color.BLACK);
		mntmStockCierre.setForeground(Color.WHITE);
		mntmStockCierre.setFont(new Font("Arial", Font.BOLD, 13));
		mntmStockCierre.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		mnA.add(mntmStockCierre);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Menu.class.getResource("/imagen/rivabar.jpg")));
		lblNewLabel.setBounds(0, 0, 723, 383);
		contentPane.add(lblNewLabel);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mntmStockCierre) {
			actionPerformedMntmStockCierre(arg0);
		}
		if (arg0.getSource() == mntmStockApertura) {
			actionPerformedMntmStockApertura(arg0);
		}
		if (arg0.getSource() == mntmCuotasPagadas) {
			actionPerformedMntmCuotasPagadas(arg0);
		}
		if (arg0.getSource() == mntmCuentasPendientes) {
			actionPerformedMntmCuentasPendientes(arg0);
		}
		if (arg0.getSource() == mntmBoletaOFactura) {
			actionPerformedMntmBoletaOFactura(arg0);
		}
		if (arg0.getSource() == mntmAsignacinDeBox) {
			actionPerformedMntmAsignacinDeBox(arg0);
		}
		if (arg0.getSource() == mntmConsulta) {
			actionPerformedMntmConsulta(arg0);
		}
		if (arg0.getSource() == mntmPedido) {
			actionPerformedMntmPedido(arg0);
		}
		if (arg0.getSource() == mntmCliente) {
			actionPerformedMntmCliente(arg0);
		}
		if (arg0.getSource() == mntmProducto) {
			actionPerformedMntmProducto(arg0);
		}
		if (arg0.getSource() == mntmBoxYoMesa) {
			actionPerformedMntmBoxYoMesa(arg0);
		}
		if (arg0.getSource() == mntmSalir) {
			actionPerformedMntmSalir(arg0);
		}
	}
	protected void actionPerformedMntmSalir(ActionEvent arg0) {
		System.exit(0);
	}
	protected void actionPerformedMntmBoxYoMesa(ActionEvent arg0) {
		DlgBoxMesa bm=new DlgBoxMesa();
		bm.setLocationRelativeTo(bm);
		bm.setVisible(true);
		
	}
	protected void actionPerformedMntmProducto(ActionEvent arg0) {
		DlgProducto produc=new DlgProducto();
		produc.setLocationRelativeTo(produc);
		produc.setVisible(true);
	}
	protected void actionPerformedMntmCliente(ActionEvent arg0) {
		DlgCliente cli=new DlgCliente();
		cli.setLocationRelativeTo(cli);
		cli.setVisible(true);
	}
	protected void actionPerformedMntmPedido(ActionEvent arg0) {
		DlgPedido pedido = new DlgPedido();
		pedido.setLocationRelativeTo(pedido);
		pedido.setVisible(true);
	}
	protected void actionPerformedMntmConsulta(ActionEvent arg0) {
		DlgConsulta consulta=new DlgConsulta();
		consulta.setLocationRelativeTo(consulta);
		consulta.setVisible(true);
	}
	protected void actionPerformedMntmAsignacinDeBox(ActionEvent arg0) {
		DlgAsignacionBox asignacion=new DlgAsignacionBox();
		asignacion.setLocationRelativeTo(asignacion);
		asignacion.setVisible(true);
	}
	protected void actionPerformedMntmBoletaOFactura(ActionEvent arg0) {
		DlgBoleta boleta=new DlgBoleta();
		boleta.setLocationRelativeTo(boleta);
		boleta.setVisible(true);
	}
	protected void actionPerformedMntmCuentasPendientes(ActionEvent arg0) {
		DlgcuentasPendientes pendiente=new DlgcuentasPendientes();
		pendiente.setLocationRelativeTo(pendiente);
		pendiente.setVisible(true);
	}
	protected void actionPerformedMntmCuotasPagadas(ActionEvent arg0) {
		DlgCuentasPagadas cancelado = new DlgCuentasPagadas();
		cancelado.setLocationRelativeTo(cancelado);
		cancelado.setVisible(true);
	}
	protected void actionPerformedMntmStockApertura(ActionEvent arg0) {
		DlgStockApertura apertura = new DlgStockApertura();
		apertura.setLocationRelativeTo(apertura);
		apertura.setVisible(true);
	}
	protected void actionPerformedMntmStockCierre(ActionEvent arg0) {
		DlgStockCierre cierre=new DlgStockCierre();
		cierre.setLocationRelativeTo(cierre);
		cierre.setVisible(true);
	}
}
