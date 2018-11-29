package interfaces;

import java.util.ArrayList;

import model.OrdenCompra;

public interface OrdenCompraInterface {
	// Insertar registro de Orden de Compra
	public int insertar(OrdenCompra oc);
	
	// Actualizar registro de Orden de Compra
	public int actualizar(OrdenCompra oc);
	
	// Eliminar registro de Orden de Compra
	public int eliminar(int num);
	
	// Listar registros de Orden de Compra
	ArrayList<OrdenCompra> listar();
}
