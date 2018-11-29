package mantenimiento;

import java.sql.*;
import java.util.ArrayList;

import interfaces.CategoriaInterface;
import model.Categoria;
import utils.MySqlConexion;

public class GestionCategoria implements CategoriaInterface {

	@Override
	public int insertar(Categoria c) {
		Connection con=null;
		PreparedStatement pst=null;
		int insertado=-1;
		try {
			con=MySqlConexion.getConexion();
			String sql="{call USP_INSERTAR_CATEGORIA(?,?)}";
			pst=con.prepareCall(sql);
			pst.setInt(1, c.getCod_cat());
			pst.setString(2, c.getDes_cat());
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
	public int actualizar(Categoria c) {
		Connection con=null;
		PreparedStatement pst=null;
		int actualizado=-1;
		try {
			con=MySqlConexion.getConexion();
			String sql="{call USP_ACTUALIZAR_CATEGORIA(?,?)}";
			pst=con.prepareCall(sql);
			pst.setInt(1, c.getCod_cat());
			pst.setString(2, c.getDes_cat());
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
			String sql="{call USP_ELIMINAR_CATEGORIA(?)}";
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
	public ArrayList<Categoria> listar() {
		Connection con=null;
		PreparedStatement pst=null;
		ArrayList<Categoria> lista= new ArrayList<>();
		ResultSet rs=null; 
		try {
		   con=MySqlConexion.getConexion(); 
		   String sql="{call USP_LISTAR_CATEGORIA}";
		   pst = con.prepareCall(sql);  
		   rs = pst.executeQuery();
		   Categoria c;
		   while (rs.next()){
			   c= new Categoria();
			   c.setCod_cat(rs.getInt(1));
			   c.setDes_cat(rs.getString(2));
			   lista.add(c);
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
