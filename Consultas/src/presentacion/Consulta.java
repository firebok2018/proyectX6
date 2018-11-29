   package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entidad.Agenda;
import modelo.ModelAgenda;

import java.awt.event.KeyListener;
import java.util.List;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.UIManager;

@SuppressWarnings("serial")
public class Consulta extends JFrame implements KeyListener, ActionListener {

	private JPanel contentPane;
	private JLabel lblIngreseApellidosA;
	private JTextField txtQuery;
	private JScrollPane scrollPane;
	private JTable tableQuery;

	ModelAgenda modelo = new ModelAgenda();
	private JLabel lblIngreseId;
	private JTextField txtId;
	private JButton btnEjecutar;
	
	public static void main(String[] args) {
		
		try{
            UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        } catch(Exception e){
            System.out.println(e);
        }

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Consulta frame = new Consulta();
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
	public Consulta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 527, 389);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblIngreseApellidosA = new JLabel("Ingrese Apellidos a buscar:");
		lblIngreseApellidosA.setBounds(21, 11, 208, 14);
		contentPane.add(lblIngreseApellidosA);
		
		txtQuery = new JTextField();
		txtQuery.addKeyListener(this);
		txtQuery.setBounds(21, 30, 470, 20);
		contentPane.add(txtQuery);
		txtQuery.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 124, 470, 203);
		contentPane.add(scrollPane);
		
		tableQuery = new JTable();
		tableQuery.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Apellidos", "Nombres", "Direccion", "Edad", "Fecha de Nac."
			}
		));
		tableQuery.getColumnModel().getColumn(0).setPreferredWidth(28);
		tableQuery.getColumnModel().getColumn(1).setPreferredWidth(140);
		tableQuery.getColumnModel().getColumn(2).setPreferredWidth(120);
		tableQuery.getColumnModel().getColumn(3).setPreferredWidth(170);
		tableQuery.getColumnModel().getColumn(4).setPreferredWidth(40);
		tableQuery.getColumnModel().getColumn(5).setPreferredWidth(120);
			
		scrollPane.setViewportView(tableQuery);
		
		lblIngreseId = new JLabel("Ingrese Id:");
		lblIngreseId.setBounds(21, 61, 86, 14);
		contentPane.add(lblIngreseId);
		
		txtId = new JTextField();
		txtId.setBounds(21, 76, 104, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		btnEjecutar = new JButton("Ejecutar");
		btnEjecutar.addActionListener(this);
		btnEjecutar.setBounds(154, 75, 89, 23);
		contentPane.add(btnEjecutar);
	}
	public void keyPressed(KeyEvent arg0) {
		if (arg0.getSource() == txtQuery) {
			keyPressedTxtQuery(arg0);
		}
	}
	public void keyReleased(KeyEvent arg0) {
		poblarTabla();
	}
	public void keyTyped(KeyEvent arg0) {
	}
	protected void keyPressedTxtQuery(KeyEvent arg0) {
		
	}

	private void poblarTabla() {
		String apellidos = txtQuery.getText().trim();
		List<Agenda> query = modelo.getByApellidos(apellidos);
		DefaultTableModel dtm = (DefaultTableModel) tableQuery.getModel();
		dtm.setRowCount(0);
		
		try {
			for (Agenda a:query) {
				Object[] fila = {
						a.getIdagenda(),
						a.getApellidos(),
						a.getNombres(),
						a.getDireccion(),
						a.getEdad(),
						a.getFechaNacimiento()
				};
				dtm.addRow(fila);
			}
			dtm.fireTableDataChanged();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnEjecutar) {
			actionPerformedBtnEjecutar(arg0);
		}
	}
	protected void actionPerformedBtnEjecutar(ActionEvent arg0) {
		poblarTabla2(tableQuery);
	}

	private void poblarTabla2(JTable tabla) {
		int id = Integer.parseInt(txtId.getText());
		List<Agenda> sp = modelo.getByCod(id);
		DefaultTableModel dtm = (DefaultTableModel) tabla.getModel();
		dtm.setRowCount(0);
		
		try {
			for (Agenda a:sp) {
				Object[] fila = {
					 a.getIdagenda(),
					 a.getApellidos(),
					 a.getNombres(),
					 a.getDireccion(),
					 a.getEdad(),
					 a.getFechaNacimiento()
				};
				dtm.addRow(fila);
			}
			dtm.fireTableDataChanged();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
