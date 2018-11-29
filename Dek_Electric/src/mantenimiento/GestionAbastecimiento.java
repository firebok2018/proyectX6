package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.AbastecimientoInterface;
import model.Abastecimiento;
import model.DetalleVenta;
import utils.MySqlConexion;

public class GestionAbastecimiento implements AbastecimientoInterface {

	@Override
	public int insertar(Abastecimiento a) {
		Connection con=null;
		PreparedStatement pst=null;
		int insertado=-1;
		try {
			con=MySqlConexion.getConexion();
			String sql="{call USP_INSERTAR_ABASTECIMIENTO(?,?,?)}";
			pst=con.prepareCall(sql);
			pst.setInt(1, a.getCod_prv());
			pst.setInt(2, a.getCod_pro());
			pst.setDouble(3, a.getPre_aba());
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
	public int actualizar(Abastecimiento a) {
		Connection con=null;
		PreparedStatement pst=null;
		int actualizado=-1;
		try {
			con=MySqlConexion.getConexion();
			String sql="{call USP_ACTUALIZAR_ABASTECIMIENTO(?,?,?)}";
			pst=con.prepareCall(sql);
			pst.setInt(1, a.getCod_prv());
			pst.setInt(2, a.getCod_pro());
			pst.setDouble(3, a.getPre_aba());
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
	public int eliminar(int cod1, int cod2) {
		Connection con=null;
		PreparedStatement pst=null;
		int eliminado=-1;
		try {
			con=MySqlConexion.getConexion();
			String sql="{call USP_ELIMINAR_ABASTECIMIENTO(?,?)}";
			pst=con.prepareCall(sql);			
			pst.setInt(1, cod1);
			pst.setInt(2, cod2);
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
	public ArrayList<Abastecimiento> listar() {
		Connection con=null;
		PreparedStatement pst=null;
		ArrayList<Abastecimiento> lista= new ArrayList<>();
		ResultSet rs=null; 
		try {
		   con=MySqlConexion.getConexion(); 
		   String sql="{call USP_LISTAR_ABASTECIMIENTO}";
		   pst = con.prepareCall(sql);  
		   rs = pst.executeQuery();
		   Abastecimiento a;
		   while (rs.next()){
			   a= new Abastecimiento();
			   a.setCod_prv(rs.getInt(1));
			   a.setCod_pro(rs.getInt(2));
			   a.setPre_aba(rs.getDouble(3));
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
