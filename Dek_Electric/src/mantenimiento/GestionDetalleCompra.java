package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.DetalleCompraInterface;
import model.DetalleCompra;
import model.DetalleVenta;
import utils.MySqlConexion;

public class GestionDetalleCompra implements DetalleCompraInterface {

	@Override
	public int insertar(DetalleCompra dc) {
		Connection con=null;
		PreparedStatement pst=null;
		int insertado=-1;
		try {
			con=MySqlConexion.getConexion();
			String sql="{call USP_INSERTAR_DETALLE_COMPRA(?,?,?,?)}";
			pst=con.prepareCall(sql);
			pst.setInt(1, dc.getNum_oco());
			pst.setInt(2, dc.getCod_pro());
			pst.setInt(3, dc.getCan_ped());
			pst.setDouble(4, dc.getPre_com());
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
	public int actualizar(DetalleCompra dc) {
		Connection con=null;
		PreparedStatement pst=null;
		int actualizado=-1;
		try {
			con=MySqlConexion.getConexion();
			String sql="{call USP_ACTUALIZAR_DETALLE_COMPRA(?,?,?,?)}";
			pst=con.prepareCall(sql);
			pst.setInt(1, dc.getNum_oco());
			pst.setInt(2, dc.getCod_pro());
			pst.setInt(3, dc.getCan_ped());
			pst.setDouble(4, dc.getPre_com());
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
			String sql="{call USP_ELIMINAR_DETALLE_COMPRA(?,?)}";
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
	public ArrayList<DetalleCompra> listar() {
		Connection con=null;
		PreparedStatement pst=null;
		ArrayList<DetalleCompra> lista= new ArrayList<>();
		ResultSet rs=null; 
		try {
		   con=MySqlConexion.getConexion(); 
		   String sql="{call USP_LISTAR_CATEGORIA}";
		   pst = con.prepareCall(sql);  
		   rs = pst.executeQuery();
		   DetalleCompra dc;
		   while (rs.next()){
			   dc= new DetalleCompra();
			   dc.setNum_oco(rs.getInt(1));
			   dc.setCod_pro(rs.getInt(2));
			   dc.setCan_ped(rs.getInt(3));
			   dc.setPre_com(rs.getDouble(4));
			   lista.add(dc);
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
