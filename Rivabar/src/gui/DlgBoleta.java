package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgBoleta extends JDialog implements ActionListener {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnConsultarPago;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgBoleta dialog = new DlgBoleta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgBoleta() {
		setTitle("Pago / Boleta");
		setBounds(100, 100, 663, 557);
		getContentPane().setLayout(null);
		{
			JLabel lblDni = new JLabel("DNI:");
			lblDni.setBounds(27, 42, 46, 14);
			getContentPane().add(lblDni);
		}
		{
			textField = new JTextField();
			textField.setBounds(74, 39, 113, 20);
			getContentPane().add(textField);
			textField.setColumns(10);
		}
		{
			JLabel lblNMesa = new JLabel("N\u00AA Mesa");
			lblNMesa.setBounds(250, 42, 46, 14);
			getContentPane().add(lblNMesa);
		}
		{
			textField_1 = new JTextField();
			textField_1.setBounds(306, 39, 86, 20);
			getContentPane().add(textField_1);
			textField_1.setColumns(10);
		}
		{
			JLabel lblNBox = new JLabel("N\u00AA Box");
			lblNBox.setBounds(425, 42, 46, 14);
			getContentPane().add(lblNBox);
		}
		{
			textField_2 = new JTextField();
			textField_2.setBounds(478, 39, 86, 20);
			getContentPane().add(textField_2);
			textField_2.setColumns(10);
		}
		{
			btnConsultarPago = new JButton("Consultar Pago");
			btnConsultarPago.setIcon(new ImageIcon(DlgBoleta.class.getResource("/imagen/view_details.png")));
			btnConsultarPago.addActionListener(this);
			btnConsultarPago.setBounds(466, 114, 171, 48);
			getContentPane().add(btnConsultarPago);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 89, 446, 418);
			getContentPane().add(scrollPane);
			{
				JTextArea textArea = new JTextArea();
				scrollPane.setViewportView(textArea);
			}
		}
		{
			JButton btnGenerarBoleta = new JButton("Generar Boleta");
			btnGenerarBoleta.setIcon(new ImageIcon(DlgBoleta.class.getResource("/imagen/boleta o factura.png")));
			btnGenerarBoleta.setBounds(466, 201, 171, 48);
			getContentPane().add(btnGenerarBoleta);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConsultarPago) {
			actionPerformedBtnConsultarPago(e);
		}
	}
	protected void actionPerformedBtnConsultarPago(ActionEvent e) {
	}
}
