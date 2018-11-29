package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.CuentaBancariaInterface;
import model.CuentaBancaria;
import utils.MySqlConexion;

public class GestionCuentaBancaria implements CuentaBancariaInterface {

	@Override
	public int insertar(CuentaBancaria c) {
		Connection con=null;
		PreparedStatement pst=null;
		int insertado=-1;
		try {
			con=MySqlConexion.getConexion();
			String sql="{call USP_INSERTAR_CUENTA(?,?,?,?,?)}";
			pst=con.prepareCall(sql);
			pst.setInt(1, c.getCod_cue());
			pst.setInt(2, c.getCod_prv());
			pst.setString(3, c.getNro_cue());
			pst.setString(4, c.getBan_cue());			
			pst.setString(5, c.getTip_cue());
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
	public int actualizar(CuentaBancaria c) {
		Connection con=null;
		PreparedStatement pst=null;
		int actualizado=-1;
		try {
			con=MySqlConexion.getConexion();
			String sql="{call USP_ACTUALIZAR_CUENTA(?,?,?,?,?)}";
			pst=con.prepareCall(sql);
			pst.setInt(1, c.getCod_cue());
			pst.setInt(2, c.getCod_prv());
			pst.setString(3, c.getNro_cue());
			pst.setString(4, c.getBan_cue());			
			pst.setString(5, c.getTip_cue());
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
			String sql="{call USP_ELIMINAR_CUENTA(?)}";
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
	public ArrayList<CuentaBancaria> listar() {
		Connection con=null;
		PreparedStatement pst=null;
		ArrayList<CuentaBancaria> lista= new ArrayList<>();
		ResultSet rs=null; 
		try {
		   con=MySqlConexion.getConexion(); 
		   String sql="{call USP_LISTAR_USUARIO}";
		   pst = con.prepareCall(sql);  
		   rs = pst.executeQuery();
		   CuentaBancaria c;
		   while (rs.next()){
			   c= new CuentaBancaria();
			   c.setCod_cue(rs.getInt(1));
			   c.setCod_prv(rs.getInt(2));
			   c.setNro_cue(rs.getString(3));
			   c.setBan_cue(rs.getString(4));
			   c.setTip_cue(rs.getString(5));
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

	@Override
	public ArrayList<CuentaBancaria> listar1(String ruc) {
		Connection con=null;
		PreparedStatement pst=null;
		ArrayList<CuentaBancaria> lista= new ArrayList<>();
		ResultSet rs=null; 
		try {
		   con=MySqlConexion.getConexion(); 
		   String sql="{call USP_CONSULTA_CUENTA_BANCARIA_POR_RUC(?)}";
		   pst = con.prepareCall(sql);
		   pst.setString(1, ruc);
		   rs = pst.executeQuery();
		   CuentaBancaria c;
		   while (rs.next()){
			   c= new CuentaBancaria();
			   c.setCod_cue(rs.getInt(1));
			   c.setCod_prv(rs.getInt(2));
			   c.setNro_cue(rs.getString(3));
			   c.setBan_cue(rs.getString(4));
			   c.setTip_cue(rs.getString(5));
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

	@Override
	public ArrayList<CuentaBancaria> listar2(String rso) {
		Connection con=null;
		PreparedStatement pst=null;
		ArrayList<CuentaBancaria> lista= new ArrayList<>();
		ResultSet rs=null; 
		try {
		   con=MySqlConexion.getConexion(); 
		   String sql="{call USP_CONSULTA_CUENTA_BANCARIA_POR_RSP(?)}";
		   pst = con.prepareCall(sql);
		   pst.setString(1, rso);
		   rs = pst.executeQuery();
		   CuentaBancaria c;
		   while (rs.next()){
			   c= new CuentaBancaria();
			   c.setCod_cue(rs.getInt(1));
			   c.setCod_prv(rs.getInt(2));
			   c.setNro_cue(rs.getString(3));
			   c.setBan_cue(rs.getString(4));
			   c.setTip_cue(rs.getString(5));
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
		return lista;	}

}
