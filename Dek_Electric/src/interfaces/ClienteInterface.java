package interfaces;

import java.util.ArrayList;

import model.Cliente;

public interface ClienteInterface {
	// Insertar registro de Cliente
	public int insertar(Cliente e);
	
	// Actualizar registro de Cliente
	public int actualizar(Cliente e);
	
	// Eliminar registro de Cliente
	public int eliminar(int cod);
	
	// Listar registros de Cliente
	ArrayList<Cliente> listar();
	
	// Listar registros de Cliente
		ArrayList<Cliente> listardni(String dni);
		
	// Listar registros de Cliente
	ArrayList<Cliente> listarrso(String rso);
}
