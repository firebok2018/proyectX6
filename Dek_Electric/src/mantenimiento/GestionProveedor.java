package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.ProveedorInterface;
import model.Cliente;
import model.Proveedor;
import utils.MySqlConexion;

public class GestionProveedor implements ProveedorInterface {

	@Override
	public int insertar(Proveedor p) {
		Connection con=null;
		PreparedStatement pst=null;
		int insertado=-1;
		try {
			con=MySqlConexion.getConexion();
			String sql="{call USP_INSERTAR_PROVEEDOR(?,?,?,?,?,?,?)}";
			pst=con.prepareCall(sql);
			pst.setInt(1, p.getCod_prv());
			pst.setString(2, p.getRso_prv());
			pst.setString(3, p.getRuc_prv());
			pst.setString(4, p.getDir_prv());
			pst.setString(5, p.getTel_prv());
			pst.setString(6, p.getEma_prv());
			pst.setString(7, p.getRep_prv());												
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
	public int actualizar(Proveedor p) {
		Connection con=null;
		PreparedStatement pst=null;
		int actualizado=-1;
		try {
			con=MySqlConexion.getConexion();
			String sql="{call USP_ACTUALIZAR_PROVEEDOR(?,?,?,?,?,?,?)}";
			pst=con.prepareCall(sql);
			pst.setInt(1, p.getCod_prv());
			pst.setString(2, p.getRso_prv());
			pst.setString(3, p.getRuc_prv());
			pst.setString(4, p.getDir_prv());
			pst.setString(5, p.getTel_prv());
			pst.setString(6, p.getEma_prv());
			pst.setString(7, p.getRep_prv());												
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
			String sql="{call USP_ELIMINAR_PROVEEDOR(?)}";
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
	public ArrayList<Proveedor> listar() {
		Connection con=null;
		PreparedStatement pst=null;
		ArrayList<Proveedor> lista= new ArrayList<>();
		ResultSet rs=null; 
		try {
		   con=MySqlConexion.getConexion(); 
		   String sql="{call USP_LISTAR_PROVEEDOR}";
		   pst = con.prepareCall(sql);  
		   rs = pst.executeQuery();
		   Proveedor p;
		   while (rs.next()){
			   p= new Proveedor();
			   p.setCod_prv(rs.getInt(1));
			   p.setRso_prv(rs.getString(2));
			   p.setRuc_prv(rs.getString(3));
			   p.setDir_prv(rs.getString(4));
			   p.setTel_prv(rs.getString(5));
			   p.setEma_prv(rs.getString(6));
			   p.setRep_prv(rs.getString(7));			   			   
			   lista.add(p);
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
	public ArrayList<Proveedor> listarRUC(String ruc) {
		Connection con=null;
		PreparedStatement pst=null;
		ArrayList<Proveedor> lista= new ArrayList<>();
		ResultSet rs=null; 
		try {
		   con=MySqlConexion.getConexion(); 
		   String sql="{call USP_CONSULTA_PROVEEDOR_POR_RUC(?)}";
		   pst = con.prepareCall(sql);
		   pst.setString(1, ruc);
		   rs = pst.executeQuery();
		   Proveedor p;
		   while (rs.next()){
			   p= new Proveedor();
			   p.setCod_prv(rs.getInt(1));
			   p.setRso_prv(rs.getString(2));
			   p.setRuc_prv(rs.getString(3));
			   p.setDir_prv(rs.getString(4));
			   p.setTel_prv(rs.getString(5));
			   p.setEma_prv(rs.getString(6));
			   p.setRep_prv(rs.getString(7));			   			   
			   lista.add(p);
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
	public ArrayList<Proveedor> listarRSO(String rso) {
		Connection con=null;
		PreparedStatement pst=null;
		ArrayList<Proveedor> lista= new ArrayList<>();
		ResultSet rs=null; 
		try {
		   con=MySqlConexion.getConexion(); 
		   String sql="{call USP_CONSULTA_PROVEEDOR_POR_RSO(?)}";
		   pst = con.prepareCall(sql);
		   pst.setString(1, rso);
		   rs = pst.executeQuery();
		   Proveedor p;
		   while (rs.next()){
			   p= new Proveedor();
			   p.setCod_prv(rs.getInt(1));
			   p.setRso_prv(rs.getString(2));
			   p.setRuc_prv(rs.getString(3));
			   p.setDir_prv(rs.getString(4));
			   p.setTel_prv(rs.getString(5));
			   p.setEma_prv(rs.getString(6));
			   p.setRep_prv(rs.getString(7));			   			   
			   lista.add(p);
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
	public ArrayList<Proveedor> listarMAR(String mar) {
		Connection con=null;
		PreparedStatement pst=null;
		ArrayList<Proveedor> lista= new ArrayList<>();
		ResultSet rs=null; 
		try {
		   con=MySqlConexion.getConexion(); 
		   String sql="{call USP_CONSULTA_PROVEEDORES_POR_MARCA(?)}";
		   pst = con.prepareCall(sql);
		   pst.setString(1, mar);
		   rs = pst.executeQuery();
		   Proveedor p;
		   while (rs.next()){
			   p= new Proveedor();
			   p.setCod_prv(rs.getInt(1));
			   p.setRso_prv(rs.getString(2));
			   p.setRuc_prv(rs.getString(3));
			   p.setDir_prv(rs.getString(4));
			   p.setTel_prv(rs.getString(5));
			   p.setEma_prv(rs.getString(6));
			   p.setRep_prv(rs.getString(7));			   			   
			   lista.add(p);
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
