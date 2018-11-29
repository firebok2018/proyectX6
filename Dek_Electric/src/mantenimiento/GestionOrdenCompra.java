package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.OrdenCompraInterface;
import model.OrdenCompra;
import model.Venta;
import utils.MySqlConexion;

public class GestionOrdenCompra implements OrdenCompraInterface {

	@Override
	public int insertar(OrdenCompra oc) {
		Connection con=null;
		PreparedStatement pst=null;
		int insertado=-1;
		try {
			con=MySqlConexion.getConexion();
			String sql="{call USP_INSERTAR_ORDEN_COMPRA(?,?,?,?,?)}";
			pst=con.prepareCall(sql);
			pst.setInt(1, oc.getNum_oco());
			pst.setString(2, oc.getFec_oco());
			pst.setInt(3, oc.getCod_prv());
			pst.setInt(4, oc.getCod_tra());			
			pst.setInt(5, oc.getCod_emp());
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
	public int actualizar(OrdenCompra oc) {
		Connection con=null;
		PreparedStatement pst=null;
		int actualizado=-1;
		try {
			con=MySqlConexion.getConexion();
			String sql="{call USP_ACTUALIZAR_ORDEN_COMPRA(?,?,?,?,?)}";
			pst=con.prepareCall(sql);
			pst.setInt(1, oc.getNum_oco());
			pst.setString(2, oc.getFec_oco());
			pst.setInt(3, oc.getCod_prv());
			pst.setInt(4, oc.getCod_tra());			
			pst.setInt(5, oc.getCod_emp());
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
	public int eliminar(int num) {
		Connection con=null;
		PreparedStatement pst=null;
		int eliminado=-1;
		try {
			con=MySqlConexion.getConexion();
			String sql="{call USP_ELIMINAR_ORDEN_COMPRA(?)}";
			pst=con.prepareCall(sql);
			pst.setInt(1, num);
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
	public ArrayList<OrdenCompra> listar() {
		Connection con=null;
		PreparedStatement pst=null;
		ArrayList<OrdenCompra> lista= new ArrayList<>();
		ResultSet rs=null; 
		try {
		   con=MySqlConexion.getConexion(); 
		   String sql="{call USP_LISTAR_ORDEN_COMPRA}";
		   pst = con.prepareCall(sql);  
		   rs = pst.executeQuery();
		   OrdenCompra oc;
		   while (rs.next()){
			   oc= new OrdenCompra();
			   oc.setNum_oco(rs.getInt(1));
			   oc.setFec_oco(rs.getString(2));
			   oc.setCod_prv(rs.getInt(3));
			   oc.setCod_tra(rs.getInt(4));
			   oc.setCod_emp(rs.getInt(5));
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
