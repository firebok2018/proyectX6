package interfaces;

import java.util.ArrayList;

import model.Distrito;

public interface DistritoInterface {
	// Insertar registro de Distrito
	public int insertar(Distrito d);
	
	// Actualizar registro de Distrito
	public int actualizar(Distrito d);
	
	// Eliminar registro de Distrito
	public int eliminar(int cod);
	
	// Listar registros de Distrito
	ArrayList<Distrito> listar();
}
