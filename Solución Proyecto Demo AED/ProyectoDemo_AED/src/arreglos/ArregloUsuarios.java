package arreglos;

import libreria.*;
import clases.Usuario;

import java.io.*;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ArregloUsuarios extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	
	//	Atributo privado
	private ArrayList <Usuario> usuario;
	//	Constructor
	public ArregloUsuarios() {
		usuario = new ArrayList <Usuario> ();	
		cargarUsuarios();
	}
	//	Operaciones públicas básicas	
	public void adicionar(Usuario x) {		  
		usuario.add(x);	
		fireTableDataChanged();
	}	
	public int tamaño() {		  
		return usuario.size();	  
	}	
	public Usuario obtener(int i) {	
		return usuario.get(i);		 	  
	}	
	public Usuario buscar(int codigo) {
		Usuario x;
		for (int i=0; i<tamaño(); i++) {
			x = obtener(i);
			if (x.getCodigo() == codigo)
				return x;
		}
		return null;		
	}
	public void eliminar(Usuario x) {
		usuario.remove(x);
		fireTableDataChanged();
	}	
	public void grabarUsuarios() {
		try {
			PrintWriter pw;
			Usuario x;
			pw = new PrintWriter(new FileWriter("usuarios.txt"));
			for (int i=0; i<tamaño(); i++) {
				x = obtener(i);
				pw.println(x.getCodigo() + ";" + 
				           x.getNombres() + ";" +
						   x.getApellidos() + ";" +
				           x.getTipoID() + ";" +
				           x.getNumeroID() + ";" +
				           x.getArea() + ";" +
				           x.getCorreo() + ";" +
				           x.getTelefono() + ";" +
				           x.getFechaIngreso() + ";" +
				           x.getEstado());				
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}
	private void cargarUsuarios() {
		try {			
			BufferedReader br;
			String linea, nombres, apellidos, 
			       numeroID, correo, telefono;
			String[] s;
			int codigo, tipoID, area, fechaIngreso, estado;
			br = new BufferedReader(new FileReader("usuarios.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigo = Integer.parseInt(s[0].trim());
				nombres = s[1].trim();
				apellidos = s[2].trim();
				tipoID = Integer.parseInt(s[3].trim());
				numeroID = s[4].trim();								
				area = Integer.parseInt(s[5].trim());
				correo = s[6].trim();
				telefono = s[7].trim();
				fechaIngreso = Integer.parseInt(s[8].trim());
				estado = Integer.parseInt(s[9].trim());				
				adicionar(new Usuario(codigo, nombres, apellidos, tipoID, numeroID, area,
						              correo, telefono, fechaIngreso, estado));
			}			
			br.close();
		}		
		catch (Exception e) {
		}
	}
	//	Operaciones públicas complementarias
	public int generarCodigo() {
		if (tamaño() == 0)
			return 10001;
		else
			return obtener(tamaño()-1).getCodigo() + 1;
	}
	//  Métodos redefinidos de la clase AbstractTableModel
	private String nombreColumnas[] = { "CÓDIGO", "NOMBRES", 
			                            "APELLIDOS", "TIPO IDENTIDAD",
			                            "# ID", "ÁREA", "CORREO",
			                            "TLF", "INGRESO", "ESTADO" };
	public int getRowCount() {
		return usuario.size();
	}	
	public int getColumnCount() {
		return nombreColumnas.length;
	}	
	public String getColumnName(int columna) {
		return nombreColumnas[columna];
	}	
	public Object getValueAt(int fila, int columna) {
		Usuario x = obtener(fila);
		switch (columna) {
			case 0:
				return x.getCodigo();
			case 1:
				return x.getNombres();
			case 2:
				return x.getApellidos();
			case 3:
				return Lib.tiposDeID[x.getTipoID()];
			case 4:
				return x.getNumeroID();
			case 5:
				return Lib.tiposDeArea[x.getArea()];
			case 6:
				return x.getCorreo();
			case 7:
				return x.getTelefono();
			case 8:
				return Fecha.dd_mm_aaaa(x.getFechaIngreso());
			default:
				return Lib.tiposDeEstado[x.getEstado()];
		}
	}
	
}