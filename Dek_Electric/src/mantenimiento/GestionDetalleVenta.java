package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.DetalleVentaInterface;
import model.Categoria;
import model.DetalleVenta;
import utils.MySqlConexion;

public class GestionDetalleVenta implements DetalleVentaInterface {

	@Override
	public int insertar(DetalleVenta dv) {
		Connection con=null;
		PreparedStatement pst=null;
		int insertado=-1;
		try {
			con=MySqlConexion.getConexion();
			String sql="{call USP_INSERTAR_DETALLE_VENTA(?,?,?)}";
			pst=con.prepareCall(sql);
			pst.setInt(1, dv.getNum_ven());
			pst.setInt(2, dv.getCod_pro());
			pst.setInt(3, dv.getCan_ven());
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
	public int actualizar(DetalleVenta dv) {
		Connection con=null;
		PreparedStatement pst=null;
		int actualizado=-1;
		try {
			con=MySqlConexion.getConexion();
			String sql="{call USP_ACTUALIZAR_DETALLE_VENTA(?,?,?)}";
			pst=con.prepareCall(sql);
			pst.setInt(1, dv.getNum_ven());
			pst.setInt(2, dv.getCod_pro());
			pst.setInt(3, dv.getCan_ven());
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
	public int eliminar(int num, int cod) {
		Connection con=null;
		PreparedStatement pst=null;
		int eliminado=-1;
		try {
			con=MySqlConexion.getConexion();
			String sql="{call USP_ELIMINAR_DETALLE_VENTA(?,?)}";
			pst=con.prepareCall(sql);			
			pst.setInt(1, num);
			pst.setInt(2, cod);
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
	public ArrayList<DetalleVenta> listar() {
		Connection con=null;
		PreparedStatement pst=null;
		ArrayList<DetalleVenta> lista= new ArrayList<>();
		ResultSet rs=null; 
		try {
		   con=MySqlConexion.getConexion(); 
		   String sql="{call USP_LISTAR_CATEGORIA}";
		   pst = con.prepareCall(sql);  
		   rs = pst.executeQuery();
		   DetalleVenta dv;
		   while (rs.next()){
			   dv= new DetalleVenta();
			   dv.setNum_ven(rs.getInt(1));
			   dv.setCod_pro(rs.getInt(2));
			   dv.setCan_ven(rs.getInt(3));
			   lista.add(dv);
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
