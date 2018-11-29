package arreglos;

import libreria.Lib;
import clases.Area;

import java.io.*;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ArregloAreas extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	
	//	Atributo privado
	private ArrayList <Area> area;
	//	Constructor
	public ArregloAreas() {
		area = new ArrayList <Area> ();	
		cargarAreas();
	}
	//	Operaciones públicas básicas	
	public void adicionar(Area x) {		  
		area.add(x);	 	
		fireTableDataChanged();
	}
	public int tamaño() {		  
		 return area.size();	  
	}
	public Area obtener(int i) {	
	  return area.get(i);		 	  
	}
	public Area buscar(int codigo) {
		Area x;
		for (int i=0; i<tamaño(); i++) {
			x = obtener(i);
			if (x.getCodigo() == codigo)
				return x;
		}
		return null;		
	}
	public void eliminar(Area x) {
		area.remove(x);
		fireTableDataChanged();
	}
	public void grabarAreas() {
		try {
			PrintWriter pw;
			Area x;
			pw = new PrintWriter(new FileWriter("areas.txt"));
			for (int i=0; i<tamaño(); i++) {
				x = obtener(i);
				pw.println(x.getCodigo() + ";" + 
				           x.getNombre() + ";" +
						   x.getDescripcion() + ";" +
				           x.getNombreCorto() + ";" +
				           x.getNombreLargo() + ";" +
						   x.getEstado());
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}
	private void cargarAreas() {
		try {
			BufferedReader br;
			String linea, nombre, descripcion, nombreCorto, nombreLargo;
			String[] s;
			int codigo, estado;
			br = new BufferedReader(new FileReader("areas.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigo = Integer.parseInt(s[0].trim());
				nombre = s[1].trim();
				descripcion = s[2].trim();
				nombreCorto = s[3].trim();
				nombreLargo = s[4].trim();
				estado = Integer.parseInt(s[5].trim());
				adicionar(new Area(codigo, nombre, descripcion, nombreCorto, nombreLargo, estado));
			}
			br.close();
		}
		catch (Exception e) {
		}
	}
	//	Operaciones públicas complementarias	
	public int generarCodigo() {
		if (tamaño() == 0)
			return 20001;
		else
			return obtener(tamaño()-1).getCodigo() + 1;
	}
	//  Métodos redefinidos de la clase AbstractTableModel
	private String nombreColumnas[] = { "CÓDIGO", "NOMBRE", 
			                            "DESCRIPCIÓN", "NOMBRE CORTO",
			                            "NOMBRE LARGO", "ESTADO" };
	public int getRowCount() {
		return area.size();
	}
	public int getColumnCount() {
		return nombreColumnas.length;
	}
	public String getColumnName(int columna) {
		return nombreColumnas[columna];
	}
	public Object getValueAt(int fila, int columna) {
		Area x = obtener(fila);
		switch (columna) {
			case 0:
				return x.getCodigo();
			case 1:
				return x.getNombre();
			case 2:
				return x.getDescripcion();
			case 3:
				return x.getNombreCorto();
			case 4:
				return x.getNombreLargo();
			default:
				return Lib.tiposDeEstado[x.getEstado()];
		}
	}
	
}