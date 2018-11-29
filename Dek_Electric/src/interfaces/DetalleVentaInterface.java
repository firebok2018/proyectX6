package interfaces;

import java.util.ArrayList;

import model.DetalleVenta;

public interface DetalleVentaInterface {
	// Insertar registro de Detalle de Venta
	public int insertar(DetalleVenta dv);
	
	// Actualizar registro de Detalle de Venta
	public int actualizar(DetalleVenta dv);
	
	// Eliminar registro de Detalle de Venta
	public int eliminar(int num, int cod);
	
	// Listar registros de Detalle de Venta
	ArrayList<DetalleVenta> listar();
}
