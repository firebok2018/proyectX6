package interfaces;

import java.util.ArrayList;

import model.Categoria;

public interface CategoriaInterface {
	// Insertar registro de Categoría
	public int insertar(Categoria c);
	
	// Actualizar registro de Categoría
	public int actualizar(Categoria c);
	
	// Eliminar registro de Categoría
	public int eliminar(int cod);
	
	// Listar registros de Categoría
	ArrayList<Categoria> listar();
}
