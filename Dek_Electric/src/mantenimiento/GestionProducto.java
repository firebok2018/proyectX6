package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.ProductoInterface;
import model.Categoria;
import model.Producto;
import utils.MySqlConexion;

public class GestionProducto implements ProductoInterface {

	@Override
	public int insertar(Producto p) {
		Connection con=null;
		PreparedStatement pst=null;
		int insertado=-1;
		try {
			con=MySqlConexion.getConexion();
			String sql="{call USP_INSERTAR_PRODUCTO(?,?,?,?,?,?,?,?,?,?)}";
			pst=con.prepareCall(sql);
			pst.setInt(1, p.getCod_pro());
			pst.setInt(2, p.getCod_cat());
			pst.setString(3, p.getDes_pro());
			pst.setInt(4, p.getCod_mar());
			pst.setDouble(5, p.getPre_pro());
			pst.setInt(6, p.getSta_pro());
			pst.setInt(7, p.getStm_pro());
			pst.setString(8, p.getUnm_pro());
			pst.setString(9, p.getImp_pro());
			pst.setString(10, p.getEst_pro());			
			insertado=pst.executeUpdate();			
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
		return insertado;
	}

	@Override
	public int actualizar(Producto p) {
		Connection con=null;
		PreparedStatement pst=null;
		int actualizado=-1;
		try {
			con=MySqlConexion.getConexion();
			String sql="{call USP_ACTUALIZAR_PRODUCTO(?,?,?,?,?,?,?,?,?,?)}";
			pst=con.prepareCall(sql);
			pst.setInt(1, p.getCod_pro());
			pst.setInt(2, p.getCod_cat());
			pst.setString(3, p.getDes_pro());
			pst.setInt(4, p.getCod_mar());
			pst.setDouble(5, p.getPre_pro());
			pst.setInt(6, p.getSta_pro());
			pst.setInt(7, p.getStm_pro());
			pst.setString(8, p.getUnm_pro());
			pst.setString(9, p.getImp_pro());
			pst.setString(10, p.getEst_pro());			
			actualizado=pst.executeUpdate();			
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
		return actualizado;
	}

	@Override
	public int eliminar(int cod) {
		Connection con=null;
		PreparedStatement pst=null;
		int eliminado=-1;
		try {
			con=MySqlConexion.getConexion();
			String sql="{call USP_ELIMINAR_PRODUCTO(?)}";
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
	public ArrayList<Producto> listar() {
		Connection con=null;
		PreparedStatement pst=null;
		ArrayList<Producto> lista= new ArrayList<>();
		ResultSet rs=null; 
		try {
		   con=MySqlConexion.getConexion(); 
		   String sql="{call USP_LISTAR_PRODUCTO}";
		   pst = con.prepareCall(sql);  
		   rs = pst.executeQuery();
		   Producto p;
		   while (rs.next()){
			   p= new Producto();
			   p.setCod_pro(rs.getInt(1));
			   p.setCod_cat(rs.getInt(2));
			   p.setDes_pro(rs.getString(3));
			   p.setCod_mar(rs.getInt(4));
			   p.setPre_pro(rs.getDouble(5));
			   p.setSta_pro(rs.getInt(6));
			   p.setStm_pro(rs.getInt(7));
			   p.setUnm_pro(rs.getString(8));
			   p.setImp_pro(rs.getString(9));
			   p.setEst_pro(rs.getString(10));			   
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
	public ArrayList<Producto> listarCOD(int cod) {
		Connection con=null;
		PreparedStatement pst=null;
		ArrayList<Producto> lista= new ArrayList<>();
		ResultSet rs=null; 
		try {
		   con=MySqlConexion.getConexion(); 
		   String sql="{call USP_CONSULTA_PRODUCTO_POR_CODIGO(?)}";
		   pst = con.prepareCall(sql);
		   pst.setInt(1, cod);
		   rs = pst.executeQuery();
		   Producto p;
		   while (rs.next()){
			   p= new Producto();
			   p.setCod_pro(rs.getInt(1));
			   p.setCod_cat(rs.getInt(2));
			   p.setDes_pro(rs.getString(3));
			   p.setCod_mar(rs.getInt(4));
			   p.setPre_pro(rs.getDouble(5));
			   p.setSta_pro(rs.getInt(6));
			   p.setStm_pro(rs.getInt(7));
			   p.setUnm_pro(rs.getString(8));
			   p.setImp_pro(rs.getString(9));
			   p.setEst_pro(rs.getString(10));			   
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
	public ArrayList<Producto> listarNOM(String nom) {
		Connection con=null;
		PreparedStatement pst=null;
		ArrayList<Producto> lista= new ArrayList<>();
		ResultSet rs=null; 
		try {
		   con=MySqlConexion.getConexion(); 
		   String sql="{call USP_CONSULTA_PRODUCTO_POR_NOMBRE(?)}";
		   pst = con.prepareCall(sql);
		   pst.setString(1, nom);
		   rs = pst.executeQuery();
		   Producto p;
		   while (rs.next()){
			   p= new Producto();
			   p.setCod_pro(rs.getInt(1));
			   p.setCod_cat(rs.getInt(2));
			   p.setDes_pro(rs.getString(3));
			   p.setCod_mar(rs.getInt(4));
			   p.setPre_pro(rs.getDouble(5));
			   p.setSta_pro(rs.getInt(6));
			   p.setStm_pro(rs.getInt(7));
			   p.setUnm_pro(rs.getString(8));
			   p.setImp_pro(rs.getString(9));
			   p.setEst_pro(rs.getString(10));			   
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
	public ArrayList<Producto> listarCAT(String cat) {
		Connection con=null;
		PreparedStatement pst=null;
		ArrayList<Producto> lista= new ArrayList<>();
		ResultSet rs=null; 
		try {
		   con=MySqlConexion.getConexion(); 
		   String sql="{call USP_CONSULTA_PRODUCTO_POR_CATEGORIA(?)}";
		   pst = con.prepareCall(sql);
		   pst.setString(1, cat);
		   rs = pst.executeQuery();
		   Producto p;
		   while (rs.next()){
			   p= new Producto();
			   p.setCod_pro(rs.getInt(1));
			   p.setCod_cat(rs.getInt(2));
			   p.setDes_pro(rs.getString(3));
			   p.setCod_mar(rs.getInt(4));
			   p.setPre_pro(rs.getDouble(5));
			   p.setSta_pro(rs.getInt(6));
			   p.setStm_pro(rs.getInt(7));
			   p.setUnm_pro(rs.getString(8));
			   p.setImp_pro(rs.getString(9));
			   p.setEst_pro(rs.getString(10));			   
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
