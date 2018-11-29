package interfaces;

import java.util.ArrayList;

import model.ConsultaOrdenCompra;


public interface ConsultaOrdenCompraInterface {
	ArrayList<ConsultaOrdenCompra> listarNUM(int num);	
	ArrayList<ConsultaOrdenCompra> listarRUC(String ruc);
	ArrayList<ConsultaOrdenCompra> listarRSO(String rso);
	ArrayList<ConsultaOrdenCompra> listarNOM(String nom);
}
