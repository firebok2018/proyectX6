package interfaces;

import java.util.ArrayList;

import model.Proveedor;

public interface ProveedorInterface {
	// Insertar registro de Proveedor
	public int insertar(Proveedor p);
	
	// Actualizar registro de Proveedor
	public int actualizar(Proveedor p);
	
	// Eliminar registro de Proveedor
	public int eliminar(int cod);
	
	// Listar registros de Proveedor
	ArrayList<Proveedor> listar();
	
	// Listar registros de Proveedor
	ArrayList<Proveedor> listarRUC(String ruc);
	
	// Listar registros de Proveedor
	ArrayList<Proveedor> listarRSO(String rso);
		
	// Listar registros de Proveedor
	ArrayList<Proveedor> listarMAR(String mar);
}
