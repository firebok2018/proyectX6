package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Toolkit;

public class DlgPedido extends JDialog {
	private JLabel lblTipoDeBebida;
	private JComboBox cboTipoBebida;
	private JLabel lblNombreBebida;
	private JComboBox cboNombreBebida;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgPedido dialog = new DlgPedido();
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
	public DlgPedido() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgPedido.class.getResource("/imagen/view_details.png")));
		setTitle("Registro /pedido");
		setBounds(100, 100, 629, 366);
		getContentPane().setLayout(null);
		
		lblTipoDeBebida = new JLabel("Tipo de Bebida:");
		lblTipoDeBebida.setBounds(22, 13, 93, 17);
		getContentPane().add(lblTipoDeBebida);
		
		cboTipoBebida = new JComboBox();
		cboTipoBebida.setFont(new Font("Arial", Font.BOLD, 13));
		cboTipoBebida.setBounds(131, 8, 132, 26);
		getContentPane().add(cboTipoBebida);
		listarTipoBebida();
		cboTipoBebida.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				// TODO Auto-generated method stub
				listarNombreBebida((String) cboTipoBebida.getSelectedItem());
			}

		});
		
		
		lblNombreBebida = new JLabel("Nombre Bebida:");
		lblNombreBebida.setBounds(304, 14, 100, 14);
		getContentPane().add(lblNombreBebida);
		
		cboNombreBebida = new JComboBox();
		cboNombreBebida.setFont(new Font("Dialog", Font.BOLD, 13));
		cboNombreBebida.setBounds(414, 8, 104, 26);
		getContentPane().add(cboNombreBebida);
		listarNombreBebida((String) cboTipoBebida.getSelectedItem());

	}

	private void listarTipoBebida() {
		// TODO Auto-generated method stub
		cboTipoBebida.addItem("vino");
		cboTipoBebida.addItem("Cerveza");
	}

	private void listarNombreBebida(String selectedItem) {
		// TODO Auto-generated method stub
		cboNombreBebida.removeAllItems();
		if(selectedItem.equals("vino")){
			cboNombreBebida.addItem("tinto");
			cboNombreBebida.addItem("Blanco");
			cboNombreBebida.addItem("Rosa");
		}
		else if(selectedItem.equals("Cerveza")){
			cboNombreBebida.addItem("pilsen");
			cboNombreBebida.addItem("arequipeña");
			cboNombreBebida.addItem("cuszos");
		}
	}
}
