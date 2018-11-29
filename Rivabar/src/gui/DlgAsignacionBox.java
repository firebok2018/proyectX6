package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class DlgAsignacionBox extends JDialog implements ActionListener {
	private JLabel lblNMesa;
	private JTextField textField;
	private JLabel lblNBox;
	private JTextField textField_1;
	private JLabel lblDniCliente;
	private JTextField textField_2;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnConsultar;
	private JButton btnAsignar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgAsignacionBox dialog = new DlgAsignacionBox();
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
	public DlgAsignacionBox() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgAsignacionBox.class.getResource("/imagen/todo_list.png")));
		setTitle("Registro / Asignar Box");
		setBounds(100, 100, 687, 507);
		getContentPane().setLayout(null);
		
		lblNMesa = new JLabel("N\u00AA Mesa:");
		lblNMesa.setBounds(294, 11, 89, 14);
		getContentPane().add(lblNMesa);
		
		textField = new JTextField();
		textField.setBounds(348, 8, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		lblNBox = new JLabel("N\u00AA Box:");
		lblNBox.setBounds(470, 11, 61, 14);
		getContentPane().add(lblNBox);
		
		textField_1 = new JTextField();
		textField_1.setBounds(541, 8, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		lblDniCliente = new JLabel("DNI Cliente:");
		lblDniCliente.setBounds(27, 11, 70, 14);
		getContentPane().add(lblDniCliente);
		
		textField_2 = new JTextField();
		textField_2.setBounds(100, 8, 107, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 100, 651, 357);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setIcon(new ImageIcon(DlgAsignacionBox.class.getResource("/imagen/search.png")));
		btnConsultar.setBounds(165, 49, 145, 35);
		getContentPane().add(btnConsultar);
		
		btnAsignar = new JButton("Asignar");
		btnAsignar.setIcon(new ImageIcon(DlgAsignacionBox.class.getResource("/imagen/process.png")));
		btnAsignar.setBounds(358, 49, 145, 34);
		getContentPane().add(btnAsignar);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(e);
		}
	}
	protected void actionPerformedBtnConsultar(ActionEvent e) {
		
	}
}
