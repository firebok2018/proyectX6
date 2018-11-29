package ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.Console;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ConexionDatabase.ConexionMesa;
import model.Mesa;
import utils.Conexion;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JButton;

public class FrmElegirMesa extends JInternalFrame implements ActionListener {
	
	ConexionMesa con= new ConexionMesa();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmElegirMesa frame = new FrmElegirMesa();
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
	public FrmElegirMesa() {
		setTitle("Registrar | Mesa");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JInternalFrame.EXIT_ON_CLOSE);
		

	}

	public void actionPerformed(ActionEvent e) {
	}
}
