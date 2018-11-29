package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.TransportistaInterface;
import model.Proveedor;
import model.Transportista;
import utils.MySqlConexion;

public class GestionTransportista implements TransportistaInterface {

	@Override
	public int insertar(Transportista t) {
		Connection con=null;
		PreparedStatement pst=null;
		int insertado=-1;
		try {
			con=MySqlConexion.getConexion();
			String sql="{call USP_INSERTAR_TRANSPORTISTA(?,?,?,?,?)}";
			pst=con.prepareCall(sql);
			pst.setInt(1, t.getCod_tra());
			pst.setString(2, t.getRso_tra());
			pst.setString(3, t.getRuc_tra());
			pst.setString(4, t.getCon_tra());
			pst.setString(5, t.getTel_tra());												
			insertado=pst.executeUpdate();			
		} catch (Exception e1) {
			System.out.println("Error en la sentencia " + e1.getMessage());
		} finally {
			try {
				if (pst != null) pst.close();
			    if (con != null) con.close();
			} catch (Exception e2) {
				System.out.println("Error al cerrar ");
			}
		}		
		return insertado;
	}

	@Override
	public int actualizar(Transportista t) {
		Connection con=null;
		PreparedStatement pst=null;
		int actualizado=-1;
		try {
			con=MySqlConexion.getConexion();
			String sql="{call USP_ACTUALIZAR_TRANSPORTISTA(?,?,?,?,?)}";
			pst=con.prepareCall(sql);
			pst.setInt(1, t.getCod_tra());
			pst.setString(2, t.getRso_tra());
			pst.setString(3, t.getRuc_tra());
			pst.setString(4, t.getCon_tra());
			pst.setString(5, t.getTel_tra());												
			actualizado=pst.executeUpdate();			
		} catch (Exception e1) {
			System.out.println("Error en la sentencia " + e1.getMessage());
		} finally {
			try {
				if (pst != null) pst.close();
			    if (con != null) con.close();
			} catch (Exception e2) {
				System.out.println("Error al cerrar ");
			}
		}		
		return actualizado;
	}

	@Override
	public int eliminar(int cod) {
		Connection con=null;
		PreparedStatement pst=null;
		int eliminado=-1;
		try {
			con=MySqlConexion.getConexion();
			String sql="{call USP_ELIMINAR_TRANSPORTISTA(?)}";
			pst=con.prepareCall(sql);
			pst.setInt(1, cod);
			eliminado=pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error en la sentencia " + e.getMessage());
		} finally {
			try {
				if (pst != null) pst.close();
			    if (con != null) con.close();
			} catch (Exception e2) {
				System.out.println("Error al cerrar ");
			}
		}		
		return eliminado;
	}

	@Override
	public ArrayList<Transportista> listar() {
		Connection con=null;
		PreparedStatement pst=null;
		ArrayList<Transportista> lista= new ArrayList<>();
		ResultSet rs=null; 
		try {
		   con=MySqlConexion.getConexion(); 
		   String sql="{call USP_LISTAR_TRANSPORTISTA}";
		   pst = con.prepareCall(sql);  
		   rs = pst.executeQuery();
		   Transportista t;
		   while (rs.next()){
			   t= new Transportista();
			   t.setCod_tra(rs.getInt(1));
			   t.setRso_tra(rs.getString(2));
			   t.setRuc_tra(rs.getString(3));
			   t.setCon_tra(rs.getString(4));
			   t.setTel_tra(rs.getString(5));			   			   
			   lista.add(t);
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
	public ArrayList<Transportista> listarRUC(String ruc) {
		Connection con=null;
		PreparedStatement pst=null;
		ArrayList<Transportista> lista= new ArrayList<>();
		ResultSet rs=null; 
		try {
		   con=MySqlConexion.getConexion(); 
		   String sql="{call USP_CONSULTA_TRANSPORTISTA_POR_RUC(?)}";
		   pst = con.prepareCall(sql);  
		   pst.setString(1, ruc);
		   rs = pst.executeQuery();
		   Transportista t;
		   while (rs.next()){
			   t= new Transportista();
			   t.setCod_tra(rs.getInt(1));
			   t.setRso_tra(rs.getString(2));
			   t.setRuc_tra(rs.getString(3));
			   t.setCon_tra(rs.getString(4));
			   t.setTel_tra(rs.getString(5));			   			   
			   lista.add(t);
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
	public ArrayList<Transportista> listarRSO(String rso) {
		Connection con=null;
		PreparedStatement pst=null;
		ArrayList<Transportista> lista= new ArrayList<>();
		ResultSet rs=null; 
		try {
		   con=MySqlConexion.getConexion(); 
		   String sql="{call USP_CONSULTA_TRANSPORTISTA_POR_RSO(?)}";
		   pst = con.prepareCall(sql);  
		   pst.setString(1, rso);
		   rs = pst.executeQuery();
		   Transportista t;
		   while (rs.next()){
			   t= new Transportista();
			   t.setCod_tra(rs.getInt(1));
			   t.setRso_tra(rs.getString(2));
			   t.setRuc_tra(rs.getString(3));
			   t.setCon_tra(rs.getString(4));
			   t.setTel_tra(rs.getString(5));			   			   
			   lista.add(t);
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
