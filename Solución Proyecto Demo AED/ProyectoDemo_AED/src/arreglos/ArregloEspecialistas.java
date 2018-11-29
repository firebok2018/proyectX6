package arreglos;

import libreria.*;
import clases.Especialista;

import java.io.*;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ArregloEspecialistas extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	
	//	Atributo privado
	private ArrayList <Especialista> especialista;	
	//	Constructor
	public ArregloEspecialistas() {
		especialista = new ArrayList <Especialista> ();	
		cargarEspecialistas();
	}
	//	Operaciones públicas básicas	
	public void adicionar(Especialista x) {		  
		especialista.add(x);	 	
		fireTableDataChanged();
	}
	public int tamaño() {		  
		 return especialista.size();	  
	}
	public Especialista obtener(int i) {	
	  return especialista.get(i);		 	  
	}
	public Especialista buscar(int codigo) {
		Especialista x;
		for (int i=0; i<tamaño(); i++) {
			x = obtener(i);
			if (x.getCodigo() == codigo)
				return x;
		}
		return null;		
	}
	public void eliminar(Especialista x) {
		especialista.remove(x);
		fireTableDataChanged();
	}
	public void grabarEspecialistas() {
		try {
			PrintWriter pw;
			Especialista x;
			pw = new PrintWriter(new FileWriter("especialistas.txt"));
			for (int i=0; i<tamaño(); i++) {
				x = obtener(i);
				pw.println(x.getCodigo() + ";" + 
				           x.getNombres() + ";" +
						   x.getApellidos() + ";" +
				           x.getEspecialidad() + ";" +
				           x.getAnexo() + ";" +
				           x.getFechaIngreso() + ";" +
						   x.getEstado());
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}
	private void cargarEspecialistas() {
		try {
			BufferedReader br;
			String linea, nombres, apellidos, especialidad, anexo;
			String[] s;
			int codigo, estado, fechaIngreso;		
			br = new BufferedReader(new FileReader("especialistas.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigo = Integer.parseInt(s[0].trim());
				nombres = s[1].trim();
				apellidos = s[2].trim();
				especialidad = s[3].trim();
				anexo = s[4].trim();
				fechaIngreso = Integer.parseInt(s[5].trim());
				estado = Integer.parseInt(s[6].trim());
				adicionar(new Especialista(codigo, nombres, apellidos, especialidad, anexo, fechaIngreso, estado));
			}
			br.close();
		}
		catch (Exception e) {
		}
	}
	//	Operaciones públicas complementarias
	public int generarCodigo() {
		if (tamaño() == 0)
			return 50001;
		else
			return obtener(tamaño()-1).getCodigo() + 1;
	}
	//  Métodos redefinidos de la clase AbstractTableModel
	private String nombreColumnas[] = { "CÓDIGO", "NOMBRES", 
			                            "APELLIDOS", "ESPECIALIDAD",
			                            "ANEXO", "INGRESO", "ESTADO" };
	public int getRowCount() {
		return especialista.size();
	}
	public int getColumnCount() {
		return nombreColumnas.length;
	}
	public String getColumnName(int columna) {
		return nombreColumnas[columna];
	}
	public Object getValueAt(int fila, int columna) {
		Especialista x = obtener(fila);
		switch (columna) {
			case 0:
				return x.getCodigo();
			case 1:
				return x.getNombres();
			case 2:
				return x.getApellidos();
			case 3:
				return x.getEspecialidad();
			case 4:
				return x.getAnexo();
			case 5:
				return Fecha.dd_mm_aaaa(x.getFechaIngreso());
			default:
				return Lib.tiposDeEstado[x.getEstado()];
		}
	}
	
}