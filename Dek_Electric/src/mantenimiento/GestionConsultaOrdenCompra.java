package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.ConsultaOrdenCompraInterface;
import model.ConsultaOrdenCompra;
import model.OrdenCompra;
import utils.MySqlConexion;

public class GestionConsultaOrdenCompra implements ConsultaOrdenCompraInterface{

	@Override
	public ArrayList<ConsultaOrdenCompra> listarNUM(int num) {
		Connection con=null;
		PreparedStatement pst=null;
		ArrayList<ConsultaOrdenCompra> lista= new ArrayList<>();
		ResultSet rs=null; 
		try {
		   con=MySqlConexion.getConexion(); 
		   String sql="{call USP_CONSULTA_ORDEN_COMPRA_POR_NUMERO(?)}";
		   pst = con.prepareCall(sql); 
		   pst.setInt(1, num);
		   rs = pst.executeQuery();
		   ConsultaOrdenCompra oc;
		   while (rs.next()){
			   oc= new ConsultaOrdenCompra();
			   oc.setNum_oco(rs.getInt(1));
			   oc.setFec_oco(rs.getString(2));
			   oc.setRuc_prv(rs.getString(3));
			   oc.setRso_prv(rs.getString(4));
			   oc.setCod_emp(rs.getString(5));
			   lista.add(oc);
		   }
		} catch (Exception e) {
		   System.out.println("Error en la sentencia " + e.getMessage());
		} finally {
		  try {
		      if (pst != null) pst.close();
		      if (con != null) con.close();
		   } catch (SQLException e) {
		      System.out.println("Error al cerrar ");
		   }
		}
		return lista;
	}

	@Override
	public ArrayList<ConsultaOrdenCompra> listarRUC(String ruc) {
		Connection con=null;
		PreparedStatement pst=null;
		ArrayList<ConsultaOrdenCompra> lista= new ArrayList<>();
		ResultSet rs=null; 
		try {
		   con=MySqlConexion.getConexion(); 
		   String sql="{call USP_CONSULTA_ORDEN_COMPRA_POR_RUC(?)}";
		   pst = con.prepareCall(sql); 
		   pst.setString(1, ruc);
		   rs = pst.executeQuery();
		   ConsultaOrdenCompra oc;
		   while (rs.next()){
			   oc= new ConsultaOrdenCompra();
			   oc.setNum_oco(rs.getInt(1));
			   oc.setFec_oco(rs.getString(2));
			   oc.setRuc_prv(rs.getString(3));
			   oc.setRso_prv(rs.getString(4));
			   lista.add(oc);
		   }
		} catch (Exception e) {
		   System.out.println("Error en la sentencia " + e.getMessage());
		} finally {
		  try {
		      if (pst != null) pst.close();
		      if (con != null) con.close();
		   } catch (SQLException e) {
		      System.out.println("Error al cerrar ");
		   }
		}
		return lista;
	}

	@Override
	public ArrayList<ConsultaOrdenCompra> listarRSO(String rso) {
		Connection con=null;
		PreparedStatement pst=null;
		ArrayList<ConsultaOrdenCompra> lista= new ArrayList<>();
		ResultSet rs=null; 
		try {
		   con=MySqlConexion.getConexion(); 
		   String sql="{call USP_CONSULTA_ORDEN_COMPRA_POR_RSO(?)}";
		   pst = con.prepareCall(sql); 
		   pst.setString(1, rso);
		   rs = pst.executeQuery();
		   ConsultaOrdenCompra oc;
		   while (rs.next()){
			   oc= new ConsultaOrdenCompra();
			   oc.setNum_oco(rs.getInt(1));
			   oc.setFec_oco(rs.getString(2));
			   oc.setRuc_prv(rs.getString(3));
			   oc.setRso_prv(rs.getString(4));
			   lista.add(oc);
		   }
		} catch (Exception e) {
		   System.out.println("Error en la sentencia " + e.getMessage());
		} finally {
		  try {
		      if (pst != null) pst.close();
		      if (con != null) con.close();
		   } catch (SQLException e) {
		      System.out.println("Error al cerrar ");
		   }
		}
		return lista;
	}

	@Override
	public ArrayList<ConsultaOrdenCompra> listarNOM(String nom) {
		Connection con=null;
		PreparedStatement pst=null;
		ArrayList<ConsultaOrdenCompra> lista= new ArrayList<>();
		ResultSet rs=null; 
		try {
		   con=MySqlConexion.getConexion(); 
		   String sql="{call USP_CONSULTA_ORDEN_COMPRA_POR_PRODUCTO(?)}";
		   pst = con.prepareCall(sql); 
		   pst.setString(1, nom);
		   rs = pst.executeQuery();
		   ConsultaOrdenCompra oc;
		   while (rs.next()){
			   oc= new ConsultaOrdenCompra();
			   oc.setNum_oco(rs.getInt(1));
			   oc.setFec_oco(rs.getString(2));
			   oc.setRuc_prv(rs.getString(3));
			   oc.setRso_prv(rs.getString(4));
			   lista.add(oc);
		   }
		} catch (Exception e) {
		   System.out.println("Error en la sentencia " + e.getMessage());
		} finally {
		  try {
		      if (pst != null) pst.close();
		      if (con != null) con.close();
		   } catch (SQLException e) {
		      System.out.println("Error al cerrar ");
		   }
		}
		return lista;
	}

}
