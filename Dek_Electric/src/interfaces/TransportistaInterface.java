package interfaces;

import java.util.ArrayList;

import model.Transportista;

public interface TransportistaInterface {
	// Insertar registro de Transportista
	public int insertar(Transportista t);
	
	// Actualizar registro de Transportista
	public int actualizar(Transportista t);
	
	// Eliminar registro de Transportista
	public int eliminar(int cod);
	
	// Listar registros de Transportista
	ArrayList<Transportista> listar();
	
	// Listar registros de Transportista
	ArrayList<Transportista> listarRUC(String ruc);
	
	// Listar registros de Transportista
	ArrayList<Transportista> listarRSO(String rso);
}
