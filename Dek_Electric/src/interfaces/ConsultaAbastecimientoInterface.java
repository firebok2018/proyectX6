package interfaces;

import java.util.ArrayList;


import model.Consulta_Abastecimiento;

public interface ConsultaAbastecimientoInterface {
	// Listar registros de Abastecimiento
		ArrayList<Consulta_Abastecimiento> listarRUC(String ruc);
		
		// Listar registros de Abastecimiento
		ArrayList<Consulta_Abastecimiento> listarRSO(String rso);
			
		// Listar registros de Abastecimiento
		ArrayList<Consulta_Abastecimiento> listarNOM(String nom);
}
