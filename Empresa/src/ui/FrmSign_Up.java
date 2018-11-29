  package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ConexionDatabase.ConexionPrevilegio;
import ConexionDatabase.ConexionSign_Up;
import model.Encrypt;
import model.Previlegio;
import model.Usuarios;
import utils.Conexion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JCheckBox;
import java.awt.Checkbox;
import java.awt.Choice;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FrmSign_Up extends JDialog implements ActionListener, KeyListener {
	private JLabel lblUsuario;
	private JLabel lblContrasea;
	private JLabel lblConfirmarContrasea;
	private JLabel lblNombre;
	private JLabel lblCorreo;
	private JLabel lblApellido;
	private JTextField txtUser;
	private JTextField txtCorreo;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JButton btnRegistrar;
	private JPasswordField txtPassword;
	private JPasswordField txtPasswordConfirm;
	
	
	ConexionSign_Up users= new ConexionSign_Up();
	
	private JLabel lblRegistroDeNuevo;
	private JComboBox cboPrivilegio;
	
	private int form;
	public final static int REGISTRAR = 0;
	public final static int NOTREGISTRAR = 1;
	private JButton btnCerrar;
	private JCheckBox chkConfiguracion;
	private JCheckBox chkConsultas;
	private JCheckBox chkActualizacion;
	private JLabel lblPrivilegio;
	ConexionSign_Up SingUp = new ConexionSign_Up();
	private JLabel lblCodUsuario;
	private JTextField txtCoduser;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnBuscar;
	private JButton btnNuevo;
	private JButton btnVolver;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrmSign_Up dialog = new FrmSign_Up();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmSign_Up() {
		//setModal(true);
		setResizable(false);
		setBounds(100, 100, 881, 539);
		getContentPane().setLayout(null);
		
		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(237, 44, 72, 14);
		getContentPane().add(lblUsuario);
		
		lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(28, 81, 89, 14);
		getContentPane().add(lblContrasea);
		
		lblConfirmarContrasea = new JLabel("<html>Confirmar Contrase\u00F1a:</html>");
		lblConfirmarContrasea.setBounds(298, 69, 89, 28);
		getContentPane().add(lblConfirmarContrasea);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(298, 109, 72, 14);
		getContentPane().add(lblNombre);
		
		lblCorreo = new JLabel("Correo:");
		lblCorreo.setBounds(28, 109, 72, 14);
		getContentPane().add(lblCorreo);
		
		lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(28, 139, 72, 14);
		getContentPane().add(lblApellido);
		
		txtUser = new JTextField();
		txtUser.setBounds(317, 41, 97, 20);
		getContentPane().add(txtUser);
		txtUser.setColumns(10);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(110, 106, 178, 20);
		getContentPane().add(txtCorreo);
		txtCorreo.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(376, 108, 171, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(110, 136, 178, 20);
		getContentPane().add(txtApellido);
		txtApellido.setColumns(10);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setIcon(new ImageIcon(FrmSign_Up.class.getResource("/imagen/addUser.png")));
		btnRegistrar.setEnabled(false);
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(383, 199, 116, 33);
		getContentPane().add(btnRegistrar);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(110, 78, 178, 20);
		getContentPane().add(txtPassword);
		
		txtPasswordConfirm = new JPasswordField();
	
		txtPasswordConfirm.addKeyListener(this);
		txtPasswordConfirm.setBounds(376, 78, 171, 20);
		getContentPane().add(txtPasswordConfirm);
		
		lblRegistroDeNuevo = new JLabel("Registro de Nuevo Usuario");
		lblRegistroDeNuevo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRegistroDeNuevo.setBounds(61, 11, 264, 27);
		getContentPane().add(lblRegistroDeNuevo);
		
		cboPrivilegio = new JComboBox();
		cboPrivilegio.setBounds(376, 136, 137, 20);
		getContentPane().add(cboPrivilegio);
		ConexionPrevilegio Cperm = new ConexionPrevilegio();
		Cperm.TipPrev(cboPrivilegio);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setIcon(new ImageIcon(FrmSign_Up.class.getResource("/imagen/cerrar.png")));
		btnCerrar.setBounds(635, 155, 116, 33);
		getContentPane().add(btnCerrar);
		
		chkConfiguracion = new JCheckBox("Configurac\u00F3n");
		chkConfiguracion.setBounds(181, 180, 97, 23);
		getContentPane().add(chkConfiguracion);
		
		chkConsultas = new JCheckBox("Consultas");
		chkConsultas.setBounds(50, 216, 141, 23);
		getContentPane().add(chkConsultas);
		
		chkActualizacion = new JCheckBox("Actualizacion");
		chkActualizacion.setBounds(50, 180, 146, 23);
		getContentPane().add(chkActualizacion);
		
		lblPrivilegio = new JLabel("Privilegio:");
		lblPrivilegio.setBounds(298, 139, 60, 14);
		getContentPane().add(lblPrivilegio);
		
		lblCodUsuario = new JLabel("COD. Usuario:");
		lblCodUsuario.setBounds(28, 49, 89, 14);
		getContentPane().add(lblCodUsuario);
		
		txtCoduser = new JTextField();
		txtCoduser.setBounds(110, 41, 86, 20);
		getContentPane().add(txtCoduser);
		txtCoduser.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 272, 855, 226);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setIcon(new ImageIcon(FrmSign_Up.class.getResource("/imagen/engineering.png")));
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(635, 72, 116, 33);
		getContentPane().add(btnActualizar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(FrmSign_Up.class.getResource("/imagen/delete_database.png")));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(635, 111, 116, 33);
		getContentPane().add(btnEliminar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon(FrmSign_Up.class.getResource("/imagen/search.png")));
		btnBuscar.setBounds(431, 35, 116, 33);
		getContentPane().add(btnBuscar);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setIcon(new ImageIcon(FrmSign_Up.class.getResource("/imagen/plus.png")));
		btnNuevo.setBounds(635, 35, 116, 33);
		getContentPane().add(btnNuevo);
		
		btnVolver = new JButton("Volver");
		btnVolver.setIcon(new ImageIcon(FrmSign_Up.class.getResource("/imagen/previous.png")));
		btnVolver.setBounds(635, 199, 116, 33);
		getContentPane().add(btnVolver);
		
		listar();
		
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnActualizar) {
			actionPerformedBtnActualizar(arg0);
		}
		if (arg0.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(arg0);
		}
		if (arg0.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(arg0);
		}
		
	}
	protected void actionPerformedBtnRegistrar(ActionEvent arg0) {
		
		//String pwd= new String(txtPassword.getPassword());
		//String pwdEncrypt = Encrypt.sha1(pwd);
		Usuarios usr=new Usuarios(idUser(), leerUser(), leerPwd(), leerCorreo(),
				leerNomUser(), leerApeUser(), leerLastSigIn(), leerTimeSignIn(), leerTipo(), Configuracion(), actualizacion(), consulta());
		SingUp.Sign_up(usr);
		
		/*
		
		if (leerPwd().equals(leerPwdCofirm())) {
			if (leerUser().length()==0 || leerPwd().length()==0 ||
					leerPwdCofirm().length()==0 || leerCorreo().length()==0 ||
					leerNomUser().length()==0 || leerApeUser().length()==0  ) {
				System.out.println("rellene todos los campos requeridos");
				JOptionPane.showMessageDialog(null, "Ingrese Todos campos requeridos");
				this.requestFocus();
	
			}else{
				
			}
		}*/
	}
	protected void actionPerformedBtnActualizar(ActionEvent arg0) {
		Usuarios usx=new Usuarios(idUser(), leerUser(), leerPwd(), leerCorreo(),
				leerNomUser(), leerApeUser(), leerLastSigIn(), leerTimeSignIn(), leerTipo(), Configuracion(), actualizacion(), consulta());
		SingUp.update_Sign_up(usx);
		listar();
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		Usuarios x=new Usuarios(idUser());
		SingUp.delte_sign_up(x);
		listar();
	}
	//obtencion de datos del formulario
	String idUser(){return txtCoduser.getText();}
	String leerUser() { return txtUser.getText();}
	String leerPwd(){ String pwd = new String(txtPassword.getPassword()); return pwd;}
	String leerPwdCofirm(){ String pwdC = new String(txtPasswordConfirm.getPassword()); return pwdC;}
	String leerCorreo(){ return txtCorreo.getText();}
	String leerNomUser(){ return txtNombre.getText();}
	String leerApeUser(){ return txtApellido.getText();}
	String leerLastSigIn(){
		Date d = new Date();
		DateFormat f1= DateFormat.getDateInstance();
		String date= f1.format(d);
		return date;
	}
	String leerTimeSignIn(){
		Date t = new Date();		
		DateFormat fh= DateFormat.getTimeInstance();
		String time=fh.format(t);
		return time;
	}
	int leerTipo(){ return cboPrivilegio.getSelectedIndex();}
	boolean Configuracion(){return chkConfiguracion.isSelected();}
	boolean actualizacion(){return chkActualizacion.isSelected();}
	boolean consulta(){return chkConsultas.isSelected();}
	void limpiar(JTextField s){ s.setText(null);}
	void listar(){
		SingUp.ls_user(table);
	}
	public void focusLost(FocusEvent arg0) {
		System.out.println("Fous Lost");
		if (leerPwd().equals(leerPwdCofirm())) {
			System.out.println("Las Contraseñas Coinciden");
			form=REGISTRAR;
			enableBoton(true);
			//btnRegistrar.setEnabled(true);
			
		} else {
			System.out.println("No COINIDEN????????????????");
			//btnRegistrar.setEnabled(false);
			form=NOTREGISTRAR;
			enableBoton(false);
		}
	}

	void enableBoton(boolean yes){
		if(form==REGISTRAR){
			btnRegistrar.setEnabled(yes);
		}
		if(form==NOTREGISTRAR){
			btnRegistrar.setEnabled(yes);
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent arg0) {
		dispose();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}

	
