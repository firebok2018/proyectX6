package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;

public class DlgStockCierre extends JDialog {
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgStockCierre dialog = new DlgStockCierre();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgStockCierre() {
		setTitle("Reporte / Stock Cierre");
		setBounds(100, 100, 757, 528);
		getContentPane().setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 87, 721, 391);
			getContentPane().add(scrollPane);
			{
				table = new JTable();
				scrollPane.setViewportView(table);
			}
		}
		{
			JButton btnGenerarStockDe = new JButton("Generar Stock  de Cierre");
			btnGenerarStockDe.setIcon(new ImageIcon(DlgStockCierre.class.getResource("/imagen/statistics.png")));
			btnGenerarStockDe.setBounds(264, 22, 221, 41);
			getContentPane().add(btnGenerarStockDe);
		}
	}

}
