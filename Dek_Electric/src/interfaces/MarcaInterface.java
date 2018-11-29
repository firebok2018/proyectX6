package interfaces;

import java.util.ArrayList;
import model.Marca;

public interface MarcaInterface {
	// Insertar registro de Marca
	public int insertar(Marca m);
	
	// Actualizar registro de Marca
	public int actualizar(Marca m);
	
	// Eliminar registro de Marca
	public int eliminar(int cod);
	
	// Listar registros de Marca
	ArrayList<Marca> listar();
}
