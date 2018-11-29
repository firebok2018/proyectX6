package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mantenimiento.GestionAccesoUsuario;
import model.AccesoUsuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.SwingConstants;

public class FrmAccesoUsuario extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtClave;
	private JButton btnSalir;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAccesoUsuario frame = new FrmAccesoUsuario();
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
	public FrmAccesoUsuario() {
		setResizable(false);
		setUndecorated(true);
		setTitle("Dek Electric System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-8, 141, 333, 446);
		contentPane = new JPanel();
		contentPane.setVerifyInputWhenFocusTarget(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario: ");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsuario.setBounds(54, 277, 91, 27);
		contentPane.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(135, 282, 142, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblClave = new JLabel("Clave:");
		lblClave.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblClave.setBounds(54, 315, 91, 27);
		contentPane.add(lblClave);
		
		txtClave = new JPasswordField();
		txtClave.setBounds(135, 320, 142, 20);
		contentPane.add(txtClave);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				String log=leerUsuario();
				String pas=leerClave();
				AccesoUsuario au =new AccesoUsuario();
				GestionAccesoUsuario gau=new GestionAccesoUsuario();
				au=gau.validar(log, pas);
				if(au.getLog_usu()!=null){
					aviso("Bienvenido");
					FrmAccesoUsuario.this.dispose();
					FrmPrincipal fp=new FrmPrincipal();
					fp.setVisible(true);					
					fp.setLocationRelativeTo(null);
					
				}
				else{
					aviso("Usuario no registrado");
					txtClave.setText("");
					txtUsuario.selectAll();
					txtUsuario.requestFocus();
				}
			}
		});
		btnIngresar.setBounds(54, 369, 98, 42);
		contentPane.add(btnIngresar);
		
		btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalir.addActionListener(this);
		btnSalir.setBounds(177, 369, 100, 42);
		contentPane.add(btnSalir);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrmAccesoUsuario.class.getResource("/img/logo_dek.png")));
		lblNewLabel.setBounds(64, 54, 198, 182);
		contentPane.add(lblNewLabel);
		
		this.setLocationRelativeTo(null);

	}
	

	private void aviso(String msg) {
		JOptionPane.showMessageDialog(null, msg);		
	}

	private String leerClave() {		
		return String.valueOf(txtClave.getPassword());
	}

	private String leerUsuario() {
		return txtUsuario.getText().trim();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnSalir) {
			actionPerformedBtnSalir(arg0);
		}
	}
	protected void actionPerformedBtnSalir(ActionEvent arg0) {
		System.exit(0);
	}
}
