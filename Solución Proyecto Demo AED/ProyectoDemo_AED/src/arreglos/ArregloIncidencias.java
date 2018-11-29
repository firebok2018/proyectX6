package arreglos;

import libreria.*;
import clases.Incidencia;

import java.io.*;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ArregloIncidencias extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	
	//	Atributo privado
	private ArrayList <Incidencia> incidencia;	
	//  Constructor
	public ArregloIncidencias() {
		incidencia = new ArrayList <Incidencia> ();
		cargarIncidencias();		
	}	
	//  Operaciones públicas básicas
	public void adicionar(Incidencia x) {		  
		incidencia.add(x);	
		fireTableDataChanged();
	}
	public int tamaño() {		  
		return incidencia.size();  
	}
	public Incidencia obtener(int i) {
	  return incidencia.get(i);		 	  
	}	
	public Incidencia buscar(int codigo) {
		Incidencia x;
		for (int i=0; i<tamaño(); i++) {
			x = obtener(i);
			if (x.getCodigo() == codigo)
				return x;
		}
		return null;		
	}	
	public void eliminar(Incidencia x) {
		incidencia.remove(x);
		fireTableDataChanged();
	}	
	public void grabarIncidencias() {
		try {
			PrintWriter pw;
			Incidencia x;
			pw = new PrintWriter(new FileWriter("incidencias.txt"));
			for (int i=0; i<tamaño(); i++) {
				x = obtener(i);
				pw.println(x.getCodigo() + ";" + 
				           x.getCodigoUsuario() + ";" +
						   x.getCodigoEspecialista() + ";" +
				           x.getCodigoTipoIncidencia() + ";" +
				           x.getDescripcion() + ";" +
						   x.getComentario()  + ";" +
				           x.getTiempoEstimadoSolucion()  + ";" +
						   x.getTiempoRealSolucion()  + ";" +
				           x.getFechaRegistro() + ";" +
						   x.getFechaInicioAtencion() + ";" +
				           x.getFechaFinAtencion() + ";" +
						   x.getEstado());
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}	
	private void cargarIncidencias() {
		try {
			BufferedReader br;
			String linea, descripcion, comentario;
			String[] s;
			int codigo, codigoUsuario, codigoEspecialista, codigoTipoIncidencia,
			    tiempoEstimadoSol, tiempoRealSol, fechaRegistro,
			    fechaInicioAtencion, fechaFinAtencion, estado;
			br = new BufferedReader(new FileReader("incidencias.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigo = Integer.parseInt(s[0].trim());
				codigoUsuario = Integer.parseInt(s[1].trim());
				codigoEspecialista = Integer.parseInt(s[2].trim());
				codigoTipoIncidencia = Integer.parseInt(s[3].trim());
				descripcion = s[4].trim();
				comentario = s[5].trim();
				tiempoEstimadoSol = Integer.parseInt(s[6].trim());
				tiempoRealSol = Integer.parseInt(s[7].trim());
				fechaRegistro = Integer.parseInt(s[8].trim());
				fechaInicioAtencion = Integer.parseInt(s[9].trim());
				fechaFinAtencion = Integer.parseInt(s[10].trim());
				estado = Integer.parseInt(s[11].trim());	
				adicionar(new Incidencia(codigo, codigoUsuario, codigoEspecialista, codigoTipoIncidencia,
						                 descripcion, comentario, tiempoEstimadoSol, tiempoRealSol,
						                 fechaRegistro, fechaInicioAtencion, fechaFinAtencion, estado));
			}
			br.close();
		}
		catch (Exception e) {
		}
	}
	//	Operaciones públicas complementarias	
	public int generarCodigo() {
		if (tamaño() == 0)
			return 60001;
		else
			return obtener(tamaño()-1).getCodigo() + 1;
	}	
	//  Métodos redefinidos de la clase AbstractTableModel
	private String nombreColumnas[] = { "Incid", "Usuario", "Espec", "Tipo Inc",
			                            "DESCRIPCIÓN", "COMENTARIO", "TES",
			                            "TRS", "Reg", "Ini Aten", 
			                            "Fin Aten", "Estado" };
	public int getRowCount() {
		return incidencia.size();
	}	
	public int getColumnCount() {
		return nombreColumnas.length;
	}	
	public String getColumnName(int columna) {
		return nombreColumnas[columna];
	}	
	public Object getValueAt(int fila, int columna) {
		Incidencia x = obtener(fila);
		switch (columna) {
			case 0:
				return x.getCodigo();
			case 1:
				return x.getCodigoUsuario();
			case 2:
				return x.getCodigoEspecialista();
			case 3:
				return x.getCodigoTipoIncidencia();
			case 4:
				return x.getDescripcion();
			case 5:
				return x.getComentario();
			case 6:
				return x.getTiempoEstimadoSolucion();
			case 7:
				return x.getTiempoRealSolucion();
			case 8:
				return Fecha.dd_mm_aaaa(x.getFechaRegistro());
			case 9:
				return Fecha.dd_mm_aaaa(x.getFechaInicioAtencion());
			case 10:
				return Fecha.dd_mm_aaaa(x.getFechaFinAtencion());
			default:
				return Lib.tiposDeIncidencia[x.getEstado()];	
		}
	}
	
}