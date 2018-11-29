package arreglos;

import libreria.Lib;
import clases.TipoDocumento;

import java.io.*;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ArregloTipoDocumentos extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;

	//  Atributo privado
	private ArrayList <TipoDocumento> tipoDocumendo;
	//  Operaciones públicas básicas
	public ArregloTipoDocumentos() {				
		tipoDocumendo = new ArrayList <TipoDocumento> ();
		cargarTipoDocumentos();	
	}
	public void adicionar(TipoDocumento i) {	
		tipoDocumendo.add(i);
	}
	public int tamaño () {		
		return tipoDocumendo.size();
	}	
	public TipoDocumento obtener(int i) {		  
	    return tipoDocumendo.get(i);	
	}
	public TipoDocumento buscar(int codigo) {
		TipoDocumento x;
		for (int i=0; i<tamaño(); i++) {
			x = obtener(i);
			if (x.getCodigo() == codigo)
				return x;
		}
		return null;		
	}	
	public void eliminar(TipoDocumento x) {
		tipoDocumendo.remove(x);
		fireTableDataChanged();
	}	
	public void grabarTipoDocumentos() {
		try {
			PrintWriter pw;
			TipoDocumento x;
			pw = new PrintWriter(new FileWriter("tipoDocumentos.txt"));
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
	private void cargarTipoDocumentos() {
		try {			
			BufferedReader br;
			String linea, descripcion, abreviacion;
			String[] s;
			int codigo, estado;
			br = new BufferedReader(new FileReader("tipoDocumentos.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigo = Integer.parseInt(s[0].trim());
				descripcion = s[1].trim();
				abreviacion = s[2].trim();
				estado = Integer.parseInt(s[3].trim());
				adicionar(new TipoDocumento(codigo, descripcion, abreviacion, estado));
			}			
			br.close();
		}		
		catch (Exception e) {
		}			
	}
	//  Operaciones públicas básicas
	public int generarCodigo() {
		if (tamaño() == 0)
			return 40001;
		else
			return obtener(tamaño()-1).getCodigo() + 1;
	}	
	//  Métodos redefinidos de la clase AbstractTableModel
	private String nombreColumnas[] = { "CÓDIGO", "DESCRIPCIÓN", 
										"ABREVIACIÓN", "ESTADO" };
	public int getColumnCount() {
		return nombreColumnas.length;
	}
	public int getRowCount() {		
		return tipoDocumendo.size();
	}	
	public String getColumnName(int columna) {
		return nombreColumnas[columna];
	}	
	public Object getValueAt(int fila, int columna) {
		TipoDocumento x = obtener(fila);
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