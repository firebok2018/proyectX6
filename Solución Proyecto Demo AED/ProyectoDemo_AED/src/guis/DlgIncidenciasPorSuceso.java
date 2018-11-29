package guis;

import libreria.Lib;
import clases.Incidencia;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class DlgIncidenciasPorSuceso extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JLabel lblEstado;
	private JComboBox <String> cboSuceso;
	private JButton btnVolver;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			DlgIncidenciasPorSuceso dialog = new DlgIncidenciasPorSuceso();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgIncidenciasPorSuceso() {
		getContentPane().setLayout(null);
		setResizable(false);
		setTitle("Reporte | Incidencias por suceso");
		setBounds(100, 100, 595, 520);
		
		lblEstado = new JLabel("ESTADO:");
		lblEstado.setBounds(10, 10, 69, 23);
		getContentPane().add(lblEstado);
		
		cboSuceso = new JComboBox <String> ();
		cboSuceso.addActionListener(this);
		cboSuceso.setModel(new DefaultComboBoxModel <String>
				          (new String[] {"Incidencia que m\u00E1s demor\u00F3",
				        		         "Incidencia que menos demor\u00F3",
				        		         "Cantidad de Incidencias canceladas",
				        		         "Cantidad de Incidencias cerradas"}));
		cboSuceso.setBounds(65, 10, 232, 23);
		getContentPane().add(cboSuceso);

		btnVolver = new JButton("volver", new ImageIcon("imagenes/volver.png"));
		btnVolver.addActionListener(this);
		btnVolver.setBounds(470, 11, 109, 45);
		getContentPane().add(btnVolver);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 70, 569, 402);
		getContentPane().add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 11));
		scrollPane.setViewportView(txtS);	
		
		incidenciaQueMasDemoro();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnVolver) {
			actionPerformedBtnVolver(arg0);
		}
		if (arg0.getSource() == cboSuceso) {
			actionPerformedCboSuceso(arg0);
		}		
	}
	protected void actionPerformedCboSuceso(ActionEvent arg0) {
		txtS.setText("");
		switch (leerPosSuceso()) {				
			case 0:
				incidenciaQueMasDemoro();
				break;
			case 1:
				incidenciaQueMenosDemoro();
				break;
			case 2:
				cantidadDeIncidenciasCanceladas();
				break;
			default:
				cantidadDeIncidenciasCerradas();
				break;
		}
	}
	protected void actionPerformedBtnVolver(ActionEvent arg0) {
		dispose();
	}
	//  Métodos tipo void (sin parámetros)
	void incidenciaQueMasDemoro() {
		Incidencia x;
		int mayorTiempo = ProyectoDemo_AED.ai.obtener(0).getTiempoRealSolucion();	
		for (int i=1; i<ProyectoDemo_AED.ai.tamaño(); i++) {
			x = ProyectoDemo_AED.ai.obtener(i);
			if (mayorTiempo < x.getTiempoRealSolucion())
				mayorTiempo = x.getTiempoRealSolucion();
		}
		for (int i=0; i<ProyectoDemo_AED.ai.tamaño(); i++) {
			x = ProyectoDemo_AED.ai.obtener(i);
			if (mayorTiempo == x.getTiempoRealSolucion()) {
				imprimir("Código de usuario                    :  " + x.getCodigoUsuario());
				imprimir("Código de especialista               :  " + x.getCodigoEspecialista());
				imprimir("Código de incidencia                 :  " + x.getCodigo());
				imprimir("Descripción                          :  " + x.getDescripcion());
				imprimir("Comentario                           :  " + x.getComentario());
				imprimir("Tiempo estimado de solución en horas :  " + x.getTiempoEstimadoSolucion());
				imprimir("Tiempo real de solución en horas     :  " + x.getTiempoRealSolucion());
				imprimir("Fecha de registro                    :  " + Lib.formatoFecha(x.getFechaRegistro()));
				imprimir("Fecha de inicio de atención          :  " + Lib.formatoFecha(x.getFechaInicioAtencion()));
				imprimir("Fecha de fin de atención             :  " + Lib.formatoFecha(x.getFechaFinAtencion()));
				imprimir("Estado                               :  " + Lib.tiposDeIncidencia[x.getEstado()]);
				imprimir("----------------------------------------------------");
			}
		}
	}
	void incidenciaQueMenosDemoro() {
		Incidencia x;
		int menorTiempo = ProyectoDemo_AED.ai.obtener(0).getTiempoRealSolucion();	
		for (int i=1; i<ProyectoDemo_AED.ai.tamaño(); i++) {
			x = ProyectoDemo_AED.ai.obtener(i);
			if (menorTiempo > x.getTiempoRealSolucion())
				menorTiempo = x.getTiempoRealSolucion();
		}
		for (int i=0; i<ProyectoDemo_AED.ai.tamaño(); i++) {
			x = ProyectoDemo_AED.ai.obtener(i);
			if (menorTiempo == x.getTiempoRealSolucion()) {
				imprimir("Código de usuario                    :  " + x.getCodigoUsuario());
				imprimir("Código de especialista               :  " + x.getCodigoEspecialista());
				imprimir("Código de incidencia                 :  " + x.getCodigo());
				imprimir("Descripción                          :  " + x.getDescripcion());
				imprimir("Comentario                           :  " + x.getComentario());
				imprimir("Tiempo estimado de solución en horas :  " + x.getTiempoEstimadoSolucion());
				imprimir("Tiempo real de solución en horas     :  " + x.getTiempoRealSolucion());
				imprimir("Fecha de registro                    :  " + Lib.formatoFecha(x.getFechaRegistro()));
				imprimir("Fecha de inicio de atención          :  " + Lib.formatoFecha(x.getFechaInicioAtencion()));
				imprimir("Fecha de fin de atención             :  " + Lib.formatoFecha(x.getFechaFinAtencion()));
				imprimir("Estado                               :  " + Lib.tiposDeIncidencia[x.getEstado()]);
				imprimir("----------------------------------------------------");
			}
		}
	}
	void cantidadDeIncidenciasCanceladas() {
		int c = 0;
		Incidencia x;
		for (int i=0; i<ProyectoDemo_AED.ai.tamaño(); i++) {
			x = ProyectoDemo_AED.ai.obtener(i);
			if (x.getEstado() == 3)
				c ++;
		}
		imprimir("Cantidad de incidencias canceladas : " + c);
	}
	void cantidadDeIncidenciasCerradas() {
		int c = 0;
		Incidencia x;
		for (int i=0; i<ProyectoDemo_AED.ai.tamaño(); i++) {
			x = ProyectoDemo_AED.ai.obtener(i);
			if (x.getEstado() == 4)
				c ++;
		}
		imprimir("Cantidad de incidencias cerradas : " + c);
	}
	//  Métodos tipo void (sin parámetros)
	void imprimir(String s) {
		txtS.append(s + "\n");
	}
	//  Métodos que retornan valor (sin parámetros)
	int leerPosSuceso() {
		return cboSuceso.getSelectedIndex();		
	}
	
}