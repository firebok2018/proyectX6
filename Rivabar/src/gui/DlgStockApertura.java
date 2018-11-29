package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class DlgStockApertura extends JDialog implements ActionListener {
	private JScrollPane scrollPane;
	private JButton btnReportar;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgStockApertura dialog = new DlgStockApertura();
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
	public DlgStockApertura() {
		setTitle("Reporte / Stock Apertura");
		setBounds(100, 100, 734, 550);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 77, 696, 422);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnReportar = new JButton("Reportar");
		btnReportar.setIcon(new ImageIcon(DlgStockApertura.class.getResource("/imagen/todo_list.png")));
		btnReportar.addActionListener(this);
		btnReportar.setBounds(273, 12, 150, 46);
		getContentPane().add(btnReportar);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnReportar) {
			actionPerformedBtnReportar(e);
		}
	}
	protected void actionPerformedBtnReportar(ActionEvent e) {
	}
}
