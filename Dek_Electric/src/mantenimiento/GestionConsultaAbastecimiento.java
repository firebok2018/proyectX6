package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.ConsultaAbastecimientoInterface;
import model.Abastecimiento;
import model.Consulta_Abastecimiento;
import utils.MySqlConexion;

public class GestionConsultaAbastecimiento implements ConsultaAbastecimientoInterface{

	@Override
	public ArrayList<Consulta_Abastecimiento> listarRUC(String ruc) {
		Connection con=null;
		PreparedStatement pst=null;
		ArrayList<Consulta_Abastecimiento> lista= new ArrayList<>();
		ResultSet rs=null; 
		try {
		   con=MySqlConexion.getConexion(); 
		   String sql="{call USP_CONSULTA_ABASTECIMIENTO_POR_RUC(?)}";
		   pst = con.prepareCall(sql);
		   pst.setString(1, ruc);
		   rs = pst.executeQuery();
		   Consulta_Abastecimiento a;
		   while (rs.next()){
			   a= new Consulta_Abastecimiento();
			   a.setRuc_prv(rs.getString(1));
			   a.setRso_prv(rs.getString(2));
			   a.setDes_pro(rs.getString(3));
			   a.setPre_aba(rs.getInt(4));
			   
			   lista.add(a);
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
	public ArrayList<Consulta_Abastecimiento> listarRSO(String rso) {
		Connection con=null;
		PreparedStatement pst=null;
		ArrayList<Consulta_Abastecimiento> lista= new ArrayList<>();
		ResultSet rs=null; 
		try {
		   con=MySqlConexion.getConexion(); 
		   String sql="{call USP_CONSULTA_ABASTECIMIENTO_POR_RSO(?)}";
		   pst = con.prepareCall(sql);
		   pst.setString(1, rso);
		   rs = pst.executeQuery();
		   Consulta_Abastecimiento a;
		   while (rs.next()){
			   a= new Consulta_Abastecimiento();
			   a.setRuc_prv(rs.getString(1));
			   a.setRso_prv(rs.getString(2));
			   a.setDes_pro(rs.getString(3));
			   a.setPre_aba(rs.getInt(4));
			   lista.add(a);
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
	public ArrayList<Consulta_Abastecimiento> listarNOM(String nom) {
		Connection con=null;
		PreparedStatement pst=null;
		ArrayList<Consulta_Abastecimiento> lista= new ArrayList<>();
		ResultSet rs=null; 
		try {
		   con=MySqlConexion.getConexion(); 
		   String sql="{call USP_CONSULTA_ABASTECIMIENTO_POR_PRODUCTO(?)}";
		   pst = con.prepareCall(sql); 
		   pst.setString(1, nom);
		   rs = pst.executeQuery();
		   Consulta_Abastecimiento a;
		   while (rs.next()){
			   a= new Consulta_Abastecimiento();
			   a.setRuc_prv(rs.getString(1));
			   a.setRso_prv(rs.getString(2));
			   a.setDes_pro(rs.getString(3));
			   a.setPre_aba(rs.getInt(4));
			   lista.add(a);
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
