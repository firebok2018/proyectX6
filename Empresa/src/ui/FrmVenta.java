package ui;

import java.awt.EventQueue;
import java.awt.TrayIcon.MessageType;

import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ConexionDatabase.ConexionMesa;
import ConexionDatabase.ConexionProductos;
import ConexionDatabase.ConexionTipo_Menu;
import ConexionDatabase.ConexionTipo_Producto;
import ConexionDatabase.ConexionVentas;
import model.Venta;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

import javax.naming.OperationNotSupportedException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableColumnModel;

public class FrmVenta extends JInternalFrame implements ActionListener {
	private JLabel lblNewLabel;
	private JTextField txtCodigoVenta;
	private JLabel lblDni;
	private JTextField txtDni;
	private JTextField txtNombre;
	private JLabel lblNombre;
	private JLabel lblApllidos;
	private JTextField txtApellidos;
	private JComboBox cboTipo;
	private JLabel lblCategoria;
	private JButton btnNuevo;
	private JButton btnCerrar;
	private JComboBox cboSubTipo;
	private JLabel lblCantidad;
	private JTextField txtCantidadPedido;
	private JButton btnAgregar;
	private JScrollPane scrollPane;

	
	ConexionVentas conVen= new ConexionVentas();
	ConexionTipo_Producto tp= new ConexionTipo_Producto();
	
	private int tipOperacion;
	public final static int NUEVO = 0;
	public final static int MODIFICAR = 1;
	public final static int ELIMINAR= 2;
	public final static int VOLVER=3;
	public final static int BUSCAR=4;
	public final static int AGREGAR=5;
	
	private JTable tblVenta;
	private JButton btnEliminar;
	private JButton btnVolver;
	private JButton btnModificar;
	private JButton btnBuscar;
	private JLabel lblPedido;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmVenta dialog = new FrmVenta();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public FrmVenta() {
		
		
		
		setBorder(null);
		setTitle("Venta | productos");
		setBounds(100, 100, 774, 429);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("N\u00B0 Venta:");
		lblNewLabel.setBounds(26, 22, 62, 14);
		getContentPane().add(lblNewLabel);
		
		txtCodigoVenta = new JTextField();
		txtCodigoVenta.setEnabled(false);
		txtCodigoVenta.setBounds(98, 19, 86, 20);
		getContentPane().add(txtCodigoVenta);
		txtCodigoVenta.setColumns(10);
		
		lblDni = new JLabel("DNI:");
		lblDni.setBounds(206, 22, 46, 14);
		getContentPane().add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setEnabled(false);
		txtDni.setBounds(248, 19, 126, 20);
		getContentPane().add(txtDni);
		txtDni.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setEnabled(false);
		txtNombre.setBounds(98, 50, 276, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(26, 55, 62, 14);
		getContentPane().add(lblNombre);
		
		lblApllidos = new JLabel("Apellidos:");
		lblApllidos.setBounds(26, 87, 73, 14);
		getContentPane().add(lblApllidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setEnabled(false);
		txtApellidos.setBounds(98, 81, 276, 20);
		getContentPane().add(txtApellidos);
		txtApellidos.setColumns(10);
		
		cboTipo = new JComboBox();
		cboTipo.setEnabled(false);
		//cboTipo.setModel(new DefaultComboBoxModel(new String[] {"Menu", "BEbidas", "Extras"}));
		cboTipo.setBounds(98, 120, 91, 20);
		getContentPane().add(cboTipo);
		cboTipo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int x=cboTipo.getSelectedIndex();
			switch (cboTipo.getSelectedIndex()) {
			case 0:
				//conVen.SubtiposM(cboSubTipo,0);
				break;
			case 1:
				conVen.SubtiposB(cboSubTipo,x);
				break;
			case 2:
				conVen.SubtiposE(cboSubTipo,x);
			}
				
			}
		});
		
		
		
		lblCategoria = new JLabel("Tipo:");
		lblCategoria.setBounds(26, 123, 73, 14);
		getContentPane().add(lblCategoria);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setIcon(new ImageIcon(FrmVenta.class.getResource("/imagen/dinero.png")));
		btnNuevo.setBounds(459, 68, 116, 33);
		getContentPane().add(btnNuevo);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setIcon(new ImageIcon(FrmVenta.class.getResource("/imagen/cerrar.png")));
		btnCerrar.setBounds(602, 114, 116, 33);
		getContentPane().add(btnCerrar);
		
		cboSubTipo = new JComboBox();
		cboSubTipo.setEnabled(false);
		cboSubTipo.setBounds(237, 120, 167, 20);
		getContentPane().add(cboSubTipo);
	
		
		
		lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(26, 162, 62, 14);
		getContentPane().add(lblCantidad);
		
		txtCantidadPedido = new JTextField();
		txtCantidadPedido.setEnabled(false);
		txtCantidadPedido.setBounds(117, 159, 45, 20);
		getContentPane().add(txtCantidadPedido);
		txtCantidadPedido.setColumns(10);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setVisible(false);
		btnAgregar.addActionListener(this);
		btnAgregar.setIcon(new ImageIcon(FrmVenta.class.getResource("/imagen/plus.png")));
		btnAgregar.setBounds(248, 151, 116, 33);
		getContentPane().add(btnAgregar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 190, 754, 201);
		getContentPane().add(scrollPane);
		
		tblVenta = new JTable();
		tblVenta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblVenta.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblVenta);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setIcon(new ImageIcon(FrmVenta.class.getResource("/imagen/delete_database.png")));
		btnEliminar.setBounds(605, 68, 116, 33);
		getContentPane().add(btnEliminar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setVisible(false);
		btnVolver.addActionListener(this);
		btnVolver.setIcon(new ImageIcon(FrmVenta.class.getResource("/imagen/previous.png")));
		btnVolver.setBounds(459, 114, 116, 33);
		getContentPane().add(btnVolver);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setIcon(new ImageIcon(FrmVenta.class.getResource("/imagen/engineering.png")));
		btnModificar.setBounds(602, 22, 116, 33);
		getContentPane().add(btnModificar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setVisible(false);
		btnBuscar.setIcon(new ImageIcon(FrmVenta.class.getResource("/imagen/search.png")));
		btnBuscar.setBounds(459, 24, 116, 33);
		getContentPane().add(btnBuscar);
		
		lblPedido = new JLabel("Pedido:");
		lblPedido.setBounds(194, 123, 62, 14);
		getContentPane().add(lblPedido);
		
		listar();
		
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnVolver) {
			actionPerformedBtnVolver(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(arg0);
		}
		if (arg0.getSource() == btnNuevo) {
			actionPerformedBtnVender(arg0);
		}
		if (arg0.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(arg0);
		}
	}
	
	protected void actionPerformedBtnAgregar(ActionEvent arg0) {
		switch (tipOperacion){
		case NUEVO:
			agregarVenta();
			break;
		case MODIFICAR:
			modificarVenta();
			break;
		case ELIMINAR:
			eliminarVenta();
		}
	}
	String CodVenta(){return txtCodigoVenta.getText();}
	String codCli(){return txtDni.getText();}
	String nombre(){return txtNombre.getText();}
	String apellido(){return txtApellidos.getText();}
	String tipo(){return cboTipo.getSelectedItem().toString();}
	String subTipo(){return cboSubTipo.getSelectedItem().toString();}
	//String otros(){return txtOtros.getText();} 
	int Cantidad(){return Integer.parseInt(txtCantidadPedido.getText());}
	
	void listar(){
			tp.subtipo(cboTipo);
			conVen.listarVenta(tblVenta);
			ajustarAnchoColumnas();
			//conVen.subtipo(cboSubTipo);
	}
	
	void agregarVenta(){
		
		try {
			String c=CodVenta();
			if(c.length()>5||c.length()<5){
				error("Codigo venta es 5 caracteres", txtCodigoVenta);
			}else{
				try {
					String cc=codCli();
					if (cc.length()>5||cc.length()<5) {
						error("El Cliente no se encuentra registrado", txtDni);
					}else{
						try {
							String n=nombre();
							
							if (n.length()<3||n.length()>20) {
								error("N� caracteres permitido 3 y un maximo de 20 !",txtNombre);
							}else{
								try {
									String a= apellido();
									if (a.length()<5||a.length()>30) {
										error("N� caracteres permitido 5 y un maximo de 30 !",txtApellidos);
									}else{
										try {
											String t=tipo();
											if (t.length()!=0) {
												//mensaje("Coorecto");
												try {
													String p=subTipo();
													if(p.length()!=0){
														//mensaje("pedido correcto");
														try {
															int nc=Cantidad();
															if(nc<1){
																mensaje("N� Minimo de pedido 1 !");	
															}else if (nc>20) {
																mensaje("N� Maximo de pedido 20 !");
															}else{
																try{
																	//que recibe el nombre de usuario que inicio sesion
																	String usr="U0001";
																	if(usr.length()!=0){
																		Venta x= new Venta(c, cc,n+" "+a,t,p,nc,usr);
																		conVen.add_venta(x);
																		listar();
																	}else{
																		mensaje("Error al Insertar Registro");
																	}
																}catch(Exception e){
																	mensaje("Por favor inicie Sesion !");
																}
															}
														} catch (NumberFormatException e) {
															// TODO: handle exception
															error("Ingrese una Cantidad valida", txtCantidadPedido);
														}
													}else{
														mensaje("por favor selecione un pedido !");
													}
												} catch (Exception e) {
													System.out.println(e.getMessage()+e.getLocalizedMessage());
													mensaje("Error al ingresar el pedido");
												}
											}else{
												mensaje("Por favor seleccione un Tipo !");
											}
										} catch (Exception e) {
											mensaje("Error al ingresar tipo !");
										}				
									}
								} catch (Exception e) {
									mensaje("Ingrese datos en el campo apellido");
									System.out.println(e.getMessage()+e.getLocalizedMessage());
								}
							}
						} catch (Exception e) {						
							mensaje("Ingres datos en el Campo Nombre!");
							System.out.println(e.getMessage()+e.getLocalizedMessage());
						}
					}
				} catch (Exception e) {
					System.out.println(e.getMessage()+e.getLocalizedMessage());
					mensaje("Ingrese el codigo del Cliente");
				}
			}
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			mensaje("Ingrese datos en Codigo de Venta");
		}
		
		//buscar por dni del cliente del ultimo registro

		
		
	}
	void modificarVenta(){
		
		try {
			String cm=CodVenta();
			if(cm.length()>5||cm.length()<5){
				error("Codigo venta es 5 caracteres", txtCodigoVenta);
			}else{
				try {
					String ccm=codCli();
					if (ccm.length()>5||ccm.length()<5) {
						error("El Cliente no se encuentra registrado", txtDni);
					}else{
						try {
							String nm=nombre();
							
							if (nm.length()<3||nm.length()>20) {
								error("N� caracteres permitido 3 y un maximo de 20 !",txtNombre);
							}else{
								try {
									String am= apellido();
									if (am.length()<5||am.length()>30) {
										error("N� caracteres permitido 5 y un maximo de 30 !",txtApellidos);
									}else{
										try {
											String tm=tipo();
											if (tm.length()!=0) {
												//mensaje("Coorecto");
												try {
													String pm=subTipo();
													if(pm.length()!=0){
														//mensaje("pedido correcto");
														try {
															int ncm=Cantidad();
															if(ncm<1){
																mensaje("N� Minimo de pedido 1 !");	
															}else if (ncm>20) {
																mensaje("N� Maximo de pedido 20 !");
															}else{
																try{
																	//que recibe el nombre de usuario que inicio sesion
																	String usr="U0001";
																	if(usr.length()!=0){
																		Venta u= new Venta(cm, ccm,nm+" "+am,tm,pm,ncm,usr);
																		conVen.update_venta(u);
																		listar();
																	}else{
																		mensaje("Error al Modificar Venta");
																	}
																}catch(Exception e){
																	mensaje("Por favor inicie Sesion !");
																}
															}
														} catch (NumberFormatException e) {
															// TODO: handle exception
															error("Ingrese una Cantidad valida", txtCantidadPedido);
														}
													}else{
														mensaje("por favor selecione un pedido !");
													}
												} catch (Exception e) {
													System.out.println(e.getMessage()+e.getLocalizedMessage());
													mensaje("Error al ingresar el pedido");
												}
											}else{
												mensaje("Por favor seleccione un Tipo !");
											}
										} catch (Exception e) {
											mensaje("Error al ingresar tipo !");
										}				
									}
								} catch (Exception e) {
									mensaje("Ingrese datos en el campo apellido");
									System.out.println(e.getMessage()+e.getLocalizedMessage());
								}
							}
						} catch (Exception e) {						
							mensaje("Ingres datos en el Campo Nombre!");
							System.out.println(e.getMessage()+e.getLocalizedMessage());
						}
					}
				} catch (Exception e) {
					System.out.println(e.getMessage()+e.getLocalizedMessage());
					mensaje("Ingrese el codigo del Cliente");
				}
			}
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			mensaje("Ingrese datos en Codigo de Venta");
		}
	}
	void eliminarVenta(){
		System.out.println("Eliminado");
		
				Venta dx=new Venta(CodVenta(),"U0001");
				conVen.delete_venta(dx);
				listar();
		
	}
	void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblVenta.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(10)); 
		tcm.getColumn(1).setPreferredWidth(anchoColumna(10));
		tcm.getColumn(2).setPreferredWidth(anchoColumna(10)); 
		tcm.getColumn(3).setPreferredWidth(anchoColumna(25));
		tcm.getColumn(4).setPreferredWidth(anchoColumna(25));
		tcm.getColumn(5).setPreferredWidth(anchoColumna(5));
		tcm.getColumn(6).setPreferredWidth(anchoColumna(10));
	}
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	void limpiar(){
		txtDni.setText(null);
		txtNombre.setText(null);
		txtApellidos.setText(null);
		txtCantidadPedido.setText(null);
		cboTipo.setSelectedIndex(0);
	}
	void error(String s,JTextField txt){mensaje(s);txt.setText("");txt.requestFocus();}
	void mensaje(String s) {JOptionPane.showMessageDialog(this, s,"Error de Formato",0);}
	protected void actionPerformedBtnCerrar(ActionEvent arg0) {
		dispose();
	}
	protected void actionPerformedBtnVender(ActionEvent arg0) {
		tipOperacion=NUEVO;
		habilitarBoton(false);
		habilitarEntrada(true);	
	}
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		tipOperacion=MODIFICAR;
		habilitarBoton(false);
		habilitarEntrada(true);
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		tipOperacion=ELIMINAR;
		habilitarBoton(true);
		habilitarEntrada(true);
	}
	protected void actionPerformedBtnVolver(ActionEvent arg0) {
		tipOperacion=VOLVER;
		habilitarBoton(true);
		habilitarEntrada(true);
	}
	void habilitarBoton(Boolean not){
		if(tipOperacion==NUEVO){
			btnAgregar.setVisible(!not);
			btnNuevo.setEnabled(not);
			btnModificar.setEnabled(not);
			btnEliminar.setEnabled(not);
			btnVolver.setVisible(!not);
		}
		if(tipOperacion==VOLVER){
			btnAgregar.setVisible(!not);
			btnVolver.setVisible(!not);
			btnBuscar.setVisible(!not);
			btnNuevo.setEnabled(not);
			btnModificar.setEnabled(not);
			btnEliminar.setEnabled(not);
			
		}if(tipOperacion==MODIFICAR){
			btnModificar.setEnabled(not);
			btnEliminar.setEnabled(not);
			btnNuevo.setEnabled(not);
			btnAgregar.setVisible(!not);
			btnVolver.setVisible(!not);
			btnBuscar.setVisible(!not);
		}if(tipOperacion==ELIMINAR){
			btnEliminar.setEnabled(!not);
			btnModificar.setEnabled(!not);
			btnNuevo.setEnabled(!not);
			btnVolver.setVisible(not);
			btnBuscar.setVisible(not);
			btnAgregar.setVisible(not);
		}
	}
	void habilitarEntrada(Boolean yes){
		if(tipOperacion==NUEVO){
			txtCodigoVenta.setEnabled(yes);
			txtDni.setEnabled(yes);
			txtNombre.setEnabled(yes);
			txtApellidos.setEnabled(yes);
			txtCantidadPedido.setEnabled(yes);
			cboTipo.setEnabled(yes);
			cboSubTipo.setEnabled(yes);
			listar();
			focus(txtCodigoVenta);
			
		}
		if(tipOperacion==MODIFICAR){
			txtCodigoVenta.setEnabled(yes);
			txtDni.setEnabled(yes);
			txtNombre.setEnabled(yes);
			txtApellidos.setEnabled(yes);
			txtCantidadPedido.setEnabled(yes);
			cboTipo.setEnabled(yes);
			cboSubTipo.setEnabled(yes);
			listar();
			focus(txtCodigoVenta);
		}
		if(tipOperacion==VOLVER){
			txtCodigoVenta.setEnabled(!yes);
			txtDni.setEnabled(!yes);
			txtNombre.setEnabled(!yes);
			txtApellidos.setEnabled(!yes);
			txtCantidadPedido.setEnabled(!yes);
			cboTipo.setEnabled(!yes);
			cboSubTipo.setEnabled(!yes);
			
			limpiar();
			listar();
		}
		if(tipOperacion==ELIMINAR){
			txtCodigoVenta.setEnabled(yes);
			focus(txtCodigoVenta);
		}
	}
	void focus(JTextField x){
		x.requestFocus();
	}
	//JOptionPane.showConfirmDialog(null, "Do you want to proceed?", "Select an Option...",JOptionPane.YES_NO_OPTION);
}
