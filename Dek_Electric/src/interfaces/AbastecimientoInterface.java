package interfaces;

import java.util.ArrayList;

import model.Abastecimiento;

public interface AbastecimientoInterface {
	// Insertar registro de Abastecimiento
	public int insertar(Abastecimiento a);
	
	// Actualizar registro de Abastecimiento
	public int actualizar(Abastecimiento a);
	
	// Eliminar registro de Abastecimiento
	public int eliminar(int cod1, int cod2);
	
	// Listar registros de Abastecimiento
	ArrayList<Abastecimiento> listar();
}
