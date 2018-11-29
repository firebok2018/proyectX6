package interfaces;

import java.util.ArrayList;

import model.Empleado;

public interface EmpleadoInterface {
	// Insertar registro de Empleado
	public int insertar(Empleado e);
	
	// Actualizar registro de Empleado
	public int actualizar(Empleado e);
	
	// Eliminar registro de Empleado
	public int eliminar(int cod);
	
	// Listar registros de Empleado
	ArrayList<Empleado> listar();
}
