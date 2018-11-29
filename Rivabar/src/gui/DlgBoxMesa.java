package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import Arreglos.ArregloBoxMesa;
import clases.BoxMesa;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalityType;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class DlgBoxMesa extends JDialog {
	private JScrollPane scrollPane;
	private JTable tblTabla;
	private DefaultTableModel modelo;
	private JLabel lblNumeroDeMesa;
	private JTextField txtNmesa;
	private JLabel lblNumeroDeBox;
	private JTextField txtNbox;
	private JLabel lblZona;
	private JComboBox <String> cmbZona;
	private JLabel lblEstado;
	private JComboBox <String> cmbEstado;
	private JButton btnAdicionar;
	private JButton btnEliminar;
	private JButton btnGrabar;
	private JButton btnReservar;
	
	
	private int tipoOperacion;
	
	public final static int ADICIONAR = 0;
	public final static int RESERVAR = 1;
	public final static int ELIMINAR= 2;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgBoxMesa dialog = new DlgBoxMesa();
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

	public DlgBoxMesa() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgBoxMesa.class.getResource("/imagen/mesa.png")));
		setTitle("Actualizacion / Box o Mesa");
		setResizable(false);
		setBounds(100, 100, 502, 500);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 202, 476, 258);
		getContentPane().add(scrollPane);
		
		tblTabla = new JTable();
		tblTabla.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblTabla);
		
		modelo = new DefaultTableModel();
		 modelo.addColumn("Numero de mesa");
		 modelo.addColumn("Numero de box");
		 modelo.addColumn("Estado");
		 modelo.addColumn("Zona");
		 tblTabla.setModel(modelo);
		 
		 lblNumeroDeMesa = new JLabel("Numero de mesa:\r\n");
		 lblNumeroDeMesa.setBounds(10, 11, 107, 14);
		 getContentPane().add(lblNumeroDeMesa);
		 
		 txtNmesa = new JTextField();
		 txtNmesa.setEditable(false);
		 txtNmesa.setBounds(127, 8, 86, 20);
		 getContentPane().add(txtNmesa);
		 txtNmesa.setColumns(10);
		 
		 lblNumeroDeBox = new JLabel("Numero de Box:");
		 lblNumeroDeBox.setBounds(257, 11, 107, 14);
		 getContentPane().add(lblNumeroDeBox);
		 
		 txtNbox = new JTextField();
		 txtNbox.setEditable(false);
		 txtNbox.setBounds(374, 8, 86, 20);
		 getContentPane().add(txtNbox);
		 txtNbox.setColumns(10);
		 
		 lblZona = new JLabel("zona:");
		 lblZona.setBounds(67, 42, 50, 14);
		 getContentPane().add(lblZona);
		 
		 cmbZona = new JComboBox <String>();
		 cmbZona.setEnabled(false);
		 cmbZona.setModel	(new DefaultComboBoxModel(new String[] {"General", "Vip"}));
		 cmbZona.setBounds(127, 39, 86, 20);
		 getContentPane().add(cmbZona);
		 
		 lblEstado = new JLabel("Estado:");
		 lblEstado.setBounds(302, 36, 62, 14);
		 getContentPane().add(lblEstado);
		 
		 cmbEstado = new JComboBox  <String>();
		 cmbEstado.setModel	(new DefaultComboBoxModel(new String[] {"Libre", "Ocupado", "Reservado"}));
		 cmbEstado.setBounds(374, 39, 86, 20);
		 getContentPane().add(cmbEstado);
		 cmbEstado.setEnabled(false);
		 
		 btnAdicionar = new JButton("ADICIONAR");
		 btnAdicionar.setIcon(new ImageIcon(DlgBoxMesa.class.getResource("/imagen/plus.png")));
		 btnAdicionar.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		actionPerformedBtnAdicionar(arg0);
		 	}
		 });
		 btnAdicionar.setBounds(360, 70, 126, 33);
		 getContentPane().add(btnAdicionar);
		 
		 btnEliminar = new JButton("ELIMINAR");
		 btnEliminar.setIcon(new ImageIcon(DlgBoxMesa.class.getResource("/imagen/cancel.png")));
		 btnEliminar.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		actionPerformedBtnEliminar(e);
		 	}
		 });
		 btnEliminar.setBounds(360, 114, 126, 33);
		 getContentPane().add(btnEliminar);
		 
		 btnGrabar = new JButton("GRABAR");
		 btnGrabar.setIcon(new ImageIcon(DlgBoxMesa.class.getResource("/imagen/ok.png")));
		 btnGrabar.setEnabled(false);
		 btnGrabar.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		actionPerformedBtnGrabar(e);
		 	}
		 });
		 btnGrabar.setBounds(177, 131, 119, 33);
		 getContentPane().add(btnGrabar);
		 
		 btnReservar = new JButton("RESERVAR");
		 btnReservar.setIcon(new ImageIcon(DlgBoxMesa.class.getResource("/imagen/survey.png")));
		 btnReservar.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		actionPerformedBtnReservar(e);
		 	}
		 });
		 btnReservar.setBounds(360, 158, 126, 33);
		 getContentPane().add(btnReservar);
		 
		 btnVolver = new JButton("VOLVER");
		 btnVolver.setIcon(new ImageIcon(DlgBoxMesa.class.getResource("/imagen/previous.png")));
		 btnVolver.setEnabled(false);
		 btnVolver.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		actionPerformedBtnVolver(e);
		 	}
		 });
		 btnVolver.setBounds(33, 131, 119, 33);
		 getContentPane().add(btnVolver);
		 
		 
		 
		 ajustarAnchoColumnas();
		 listar();


	}
	//Declaracion Global
	ArregloBoxMesa bm= new ArregloBoxMesa();
	
	private JButton btnVolver;
	
	void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblTabla.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(25));  // numero de mesa
		tcm.getColumn(1).setPreferredWidth(anchoColumna(25));  // numero de box
		tcm.getColumn(2).setPreferredWidth(anchoColumna(25));  // estado
		tcm.getColumn(3).setPreferredWidth(anchoColumna(25));  // sona
	}
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		tipoOperacion=ADICIONAR;
		txtNmesa.setEditable(true);
		txtNbox.setEditable(true);
		cmbZona.setEnabled(true);
		cmbEstado.setEnabled(true);
		btnAdicionar.setEnabled(false);
		btnEliminar.setEnabled(false);
		btnReservar.setEnabled(false);
		btnGrabar.setEnabled(true);
		btnVolver.setEnabled(true);
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		tipoOperacion=ELIMINAR;
		txtNmesa.setEditable(true);
		txtNbox.setEditable(false);
		cmbZona.setEnabled(false);
		cmbEstado.setEnabled(false);
		btnAdicionar.setEnabled(false);
		btnEliminar.setEnabled(false);
		btnReservar.setEnabled(false);
		btnGrabar.setEnabled(true);
		btnVolver.setEnabled(true);
	}
	protected void actionPerformedBtnGrabar(ActionEvent e) 
	{
		switch (tipoOperacion){
		case ADICIONAR:
			adicionarMesa();
			break;
		case RESERVAR:
			reservarMesa();
			break;
		case ELIMINAR:
			eliminarMesa();
		}
	}
	protected void actionPerformedBtnReservar(ActionEvent e) 
	{
		tipoOperacion=RESERVAR;
		txtNmesa.setEditable(true);
		txtNbox.setEditable(true);
		cmbZona.setEnabled(true);
		cmbEstado.setEnabled(true);
		btnAdicionar.setEnabled(false);
		btnEliminar.setEnabled(false);
		btnReservar.setEnabled(false);
		btnGrabar.setEnabled(true);
		btnVolver.setEnabled(true);		
	}
	protected void actionPerformedBtnVolver(ActionEvent e) 
	{
		txtNmesa.setEditable(false);
		txtNbox.setEditable(false);
		cmbZona.setEnabled(false);
		cmbEstado.setEnabled(false);
		btnAdicionar.setEnabled(true);
		btnEliminar.setEnabled(true);
		btnReservar.setEnabled(true);
		btnGrabar.setEnabled(false);
		btnVolver.setEnabled(false);
	}
	void listar(){
		BoxMesa b;
		modelo.setRowCount(0);
		for(int i=0;i<bm.tamaño();i++)
		{
			b=bm.obtener(i);
			Object fila[]={	b.getNumeroMesa(),
							b.getNumeroBox(),
							enTextoSona(b.getSona()),
							enTextoEstado(b.getEstado())};
			modelo.addRow(fila);
		}
	}
	void adicionarMesa(){
		int mesa=leerMesa();
		if(mesa>0&&mesa<50)
			try{
				int box=leerBox();
				if(box>0&&box<5)
					try{
						int estado=leerPosEstado();
						int zona=leerPosSona();
						BoxMesa nuevo=new BoxMesa(mesa,box,estado,zona);
						bm.adicionar(nuevo);
						bm.grabarbm();
						listar();
						txtNmesa.setText("");
						txtNbox.setText("");
					}
				catch(Exception e){
					error("el box "+box+"existe en el sistema",txtNbox);
				}
			}
		catch(Exception e){
			error("la mesa "+mesa+"existe en el sistema",txtNmesa);
		}
	}
	void reservarMesa(){
		int mesa=leerMesa();
		if(mesa>0&&mesa<50)
			try{
				int box=leerBox();
				if(box>0&&box<5)
					try{
						int estado=leerPosEstado();
						int zona=leerPosSona();
						BoxMesa nuevo=new BoxMesa(mesa,box,estado,zona);
						bm.adicionar(nuevo);
						bm.grabarbm();
						listar();
						txtNmesa.setText("");
						txtNbox.setText("");
					}
				catch(Exception e){
					error("el box "+box+" no existe en el sistema",txtNbox);
				}
			}
		catch(Exception e){
			error("la mesa "+mesa+" no existe en el sistema",txtNmesa);
		}
	}
	void eliminarMesa(){
		try{
			int mesa=leerMesa();
			BoxMesa b= bm.buscarMesa(mesa);
			if(b!=null){
				bm.eliminar(b);
				bm.grabarbm();
				listar();
				txtNmesa.setText("");
				txtNbox.setText("");
				txtNmesa.requestFocus();
			}
		}
		catch(Exception e){
			error("el numero de mesa ingresado no existe",txtNmesa);
		}
	}
	int leerMesa(){
		return Integer.parseInt(txtNmesa.getText().trim());
	}
	int leerBox(){
		return Integer.parseInt(txtNbox.getText().trim());
	}
	int leerPosEstado(){
		return cmbEstado.getSelectedIndex();
	}
	int leerPosSona(){
		return cmbZona.getSelectedIndex();
	}
	String enTextoSona(int i){
		return cmbZona.getItemAt(i);
	}
	String enTextoEstado(int i){
		return cmbEstado.getItemAt(i);
	}
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}
}
