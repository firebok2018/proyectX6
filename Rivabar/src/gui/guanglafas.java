package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class guanglafas extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guanglafas frame = new guanglafas();
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
	public guanglafas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btn1 = new JButton("New button");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btn1.setBackground(Color.green);
			}
		});
		btn1.setBackground(Color.RED);
		btn1.setForeground(Color.RED);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("New button");
		btn2.setBackground(Color.RED);
		contentPane.add(btn2);
		
		JButton btn3 = new JButton("New button");
		btn3.setBackground(Color.RED);
		contentPane.add(btn3);
		
		JButton bn3 = new JButton("New button");
		bn3.setBackground(Color.RED);
		contentPane.add(bn3);
	}
}
