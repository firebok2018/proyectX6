package interfaces;

import java.util.ArrayList;

import model.CuentaBancaria;

public interface CuentaBancariaInterface {
	// Insertar registro de Cuenta
	public int insertar(CuentaBancaria c);
	
	// Actualizar registro de Cuenta
	public int actualizar(CuentaBancaria c);
	
	// Eliminar registro de Cuenta
	public int eliminar(int cod);
	
	// Listar registros de Cuenta
	public ArrayList<CuentaBancaria> listar();
	
	// Listar registros de Cuenta con Parametro
	public ArrayList<CuentaBancaria> listar1(String ruc);
	
	// Listar registros de Cuenta
	public ArrayList<CuentaBancaria> listar2(String rso);
}
