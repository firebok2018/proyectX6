package arreglos;

import libreria.Lib;
import clases.TipoIncidencia;

import java.io.*;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ArregloTipoIncidencias extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	
	//	Atributo privado
	private ArrayList <TipoIncidencia> tipoIncidencia;	
	//	Constructor
	public ArregloTipoIncidencias() {
		tipoIncidencia = new ArrayList <TipoIncidencia> ();	
		cargarTipoIncidencias();
	}
	//	Operaciones públicas básicas
	public void adicionar(TipoIncidencia x) {		  
		tipoIncidencia.add(x);	 	
		fireTableDataChanged();
	}
	public int tamaño() {		  
		 return tipoIncidencia.size();	  
	}
	public TipoIncidencia obtener(int i) {	
		return tipoIncidencia.get(i);		 	  
	}
	public TipoIncidencia buscar(int codigo) {
		TipoIncidencia x;
		for (int i=0; i<tamaño(); i++) {
			x = obtener(i);
			if (x.getCodigo() == codigo)
				return x;
		}
		return null;		
	}
	public void eliminar(TipoIncidencia x)  {
		tipoIncidencia.remove(x);
		fireTableDataChanged();
	}
	public void grabarTipoIncidencias() {
		try {
			PrintWriter pw;
			TipoIncidencia x;
			pw = new PrintWriter(new FileWriter("tipoIncidencias.txt"));
			for (int i=0; i<tamaño(); i++) {
				x = obtener(i);
				pw.println(x.getCodigo() + ";" + 
				           x.getDescripcion() + ";" +
						   x.getAbreviacion() + ";" +
						   x.getEstado());
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}
	private void cargarTipoIncidencias() {
		try {
			BufferedReader br;
			String linea, descripcion, abreviacion;
			String[] s;
			int codigo, estado;
			br = new BufferedReader(new FileReader("tipoIncidencias.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigo = Integer.parseInt(s[0].trim());
				descripcion = s[1].trim();
				abreviacion = s[2].trim();
				estado =  Integer.parseInt(s[3].trim());
				adicionar(new TipoIncidencia(codigo, descripcion,abreviacion, estado));
			}
			br.close();
		}
		catch (Exception e) {
		}
	}	
	//	Operaciones públicas complementarias
	public int generarCodigo() {
		if (tamaño() == 0)
			return 30001;
		else
			return obtener(tamaño()-1).getCodigo() + 1;
	}
	//  Métodos redefinidos de la clase AbstractTableModel
	private String nombreColumnas[] = { "CÓDIGO", "DESCRIPCIÓN", 
			                            "ABREVIACIÓN", "ESTADO" };
	public int getRowCount() {
		return tipoIncidencia.size();
	}
	public int getColumnCount() {
		return nombreColumnas.length;
	}
	public String getColumnName(int columna) {
		return nombreColumnas[columna];
	}
	public Object getValueAt(int fila, int columna) {
		TipoIncidencia x = obtener(fila);
		switch (columna) {
			case 0:
				return x.getCodigo();
			case 1:
				return x.getDescripcion();
			case 2:
				return x.getAbreviacion();
			default:
				return Lib.tiposDeEstado[x.getEstado()];
		}
	}
	
}