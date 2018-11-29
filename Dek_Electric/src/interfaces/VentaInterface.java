package interfaces;

import java.util.ArrayList;
import java.util.Date;

import model.Venta;

public interface VentaInterface {
	// Insertar registro de Venta
	public int insertar(Venta v);
	
	// Actualizar registro de Venta
	public int actualizar(Venta v);
	
	// Eliminar registro de Venta
	public int eliminar(int num);
	
	// Listar registros de Venta
	ArrayList<Venta> listar();
		
	// Listar registros de Venta
	ArrayList<Venta> listarNUM(int num);
	
	// Listar registros de Venta
	ArrayList<Venta> listarMAR(String mar);
		
	// Listar registros de Venta
	ArrayList<Venta> listarNOMP(String nomp);
		
	// Listar registros de Venta
	ArrayList<Venta> listarNOMC(String nomc);
	
	// Listar registros de Venta
	ArrayList<Venta> listarNOME(String nome);
	
	// Listar registros de Venta
	ArrayList<Venta> listarEST(String est);
	
	// Listar registros de Venta
	ArrayList<Venta> listarFEC(String fec1, String fec2);
	

}
