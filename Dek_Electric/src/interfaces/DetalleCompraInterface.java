package interfaces;

import java.util.ArrayList;

import model.DetalleCompra;

public interface DetalleCompraInterface {
	// Insertar registro de Detalle de Compra
	public int insertar(DetalleCompra dc);
	
	// Actualizar registro de Detalle de Compra
	public int actualizar(DetalleCompra dc);
	
	// Eliminar registro de Detalle de Compra
	public int eliminar(int num, int cod);
	
	// Listar registros de Detalle de Compra
	ArrayList<DetalleCompra> listar();
}
