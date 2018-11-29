package interfaces;

import java.util.ArrayList;
import model.Producto;

public interface ProductoInterface {
	// Insertar registro de Producto
	public int insertar(Producto p);
	
	// Actualizar registro de Producto
	public int actualizar(Producto p);
	
	// Eliminar registro de Producto
	public int eliminar(int cod);
	
	// Listar registros de Producto
	ArrayList<Producto> listar();
	
	// Listar registros de Producto
	ArrayList<Producto> listarCOD(int cod);
		
	// Listar registros de Producto
	ArrayList<Producto> listarNOM(String nom);
		
	// Listar registros de Producto
	ArrayList<Producto> listarCAT(String cat);
	
}
