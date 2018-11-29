package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class FrmAcercaDe extends JInternalFrame {
	private JLabel lblDekElectricSystem;
	private JLabel lblIntegrantes;
	private JLabel lblZuniCoaguilaDiego;
	private JLabel lblEspinozaPereaJuan;
	private JLabel lblMedranoOrDnillson;
	private JLabel lblPantaHuarachaWaldir;
	private JLabel lblLovatnZegarraEdgar;
	private JLabel lblMendozaTintayaGiancarlo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAcercaDe frame = new FrmAcercaDe();
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
	public FrmAcercaDe() {
		setTitle("Acerca de....");
		setBounds(-8, 0, 450, 300);
		getContentPane().setLayout(null);
		
		lblDekElectricSystem = new JLabel("Dek Electric System 1.0");
		lblDekElectricSystem.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDekElectricSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblDekElectricSystem.setBounds(10, 46, 414, 14);
		getContentPane().add(lblDekElectricSystem);
		
		lblIntegrantes = new JLabel("Integrantes:");
		lblIntegrantes.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntegrantes.setBounds(168, 93, 98, 14);
		getContentPane().add(lblIntegrantes);
		
		lblZuniCoaguilaDiego = new JLabel("Zuni Coaguila, Diego");
		lblZuniCoaguilaDiego.setHorizontalAlignment(SwingConstants.CENTER);
		lblZuniCoaguilaDiego.setBounds(118, 118, 198, 14);
		getContentPane().add(lblZuniCoaguilaDiego);
		
		lblEspinozaPereaJuan = new JLabel("Espinoza Perea, Juan Leony");
		lblEspinozaPereaJuan.setHorizontalAlignment(SwingConstants.CENTER);
		lblEspinozaPereaJuan.setBounds(118, 136, 198, 14);
		getContentPane().add(lblEspinozaPereaJuan);
		
		lblMedranoOrDnillson = new JLabel("Medrano Or\u00E9 D\u2019nillson Jhoao");
		lblMedranoOrDnillson.setHorizontalAlignment(SwingConstants.CENTER);
		lblMedranoOrDnillson.setBounds(118, 154, 198, 14);
		getContentPane().add(lblMedranoOrDnillson);
		
		lblPantaHuarachaWaldir = new JLabel("Panta Huaracha, Waldir Egdar");
		lblPantaHuarachaWaldir.setHorizontalAlignment(SwingConstants.CENTER);
		lblPantaHuarachaWaldir.setBounds(118, 172, 198, 14);
		getContentPane().add(lblPantaHuarachaWaldir);
		
		lblLovatnZegarraEdgar = new JLabel("Lovat\u00F3n Zegarra, Edgar Daniel");
		lblLovatnZegarraEdgar.setHorizontalAlignment(SwingConstants.CENTER);
		lblLovatnZegarraEdgar.setBounds(118, 190, 198, 14);
		getContentPane().add(lblLovatnZegarraEdgar);
		
		lblMendozaTintayaGiancarlo = new JLabel("Mendoza Tintaya, Giancarlo David");
		lblMendozaTintayaGiancarlo.setHorizontalAlignment(SwingConstants.CENTER);
		lblMendozaTintayaGiancarlo.setBounds(118, 208, 198, 14);
		getContentPane().add(lblMendozaTintayaGiancarlo);

	}

}
