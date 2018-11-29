package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.DistritoInterface;
import model.Distrito;
import model.Marca;
import utils.MySqlConexion;

public class GestionDistrito implements DistritoInterface {

	@Override
	public int insertar(Distrito d) {
		Connection con=null;
		PreparedStatement pst=null;
		int insertado=-1;
		try {
			con=MySqlConexion.getConexion();
			String sql="{call USP_INSERTAR_DISTRITO(?,?)}";
			pst=con.prepareCall(sql);
			pst.setInt(1, d.getCod_dis());
			pst.setString(2, d.getNom_dis());
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
	public int actualizar(Distrito d) {
		Connection con=null;
		PreparedStatement pst=null;
		int actualizado=-1;
		try {
			con=MySqlConexion.getConexion();
			String sql="{call USP_ACTUALIZAR_DISTRITO(?,?)}";
			pst=con.prepareCall(sql);
			pst.setInt(1, d.getCod_dis());
			pst.setString(2, d.getNom_dis());
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
			String sql="{call USP_ELIMINAR_DISTRITO(?)}";
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
	public ArrayList<Distrito> listar() {
		Connection con=null;
		PreparedStatement pst=null;
		ArrayList<Distrito> lista= new ArrayList<>();
		ResultSet rs=null; 
		try {
		   con=MySqlConexion.getConexion(); 
		   String sql="{call USP_LISTAR_DISTRITO}";
		   pst = con.prepareCall(sql);  
		   rs = pst.executeQuery();
		   Distrito d;
		   while (rs.next()){
			   d= new Distrito();
			   d.setCod_dis(rs.getInt(1));
			   d.setNom_dis(rs.getString(2));
			   lista.add(d);
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
