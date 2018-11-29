package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.ClienteInterface;
import model.Cliente;
import utils.MySqlConexion;

public class GestionCliente implements ClienteInterface {

	@Override
	public int insertar(Cliente e) {
		Connection con=null;
		PreparedStatement pst=null;
		int insertado=-1;
		try {
			con=MySqlConexion.getConexion();
			String sql="{call USP_INSERTAR_CLIENTE(?,?,?,?,?,?,?,?)}";
			pst=con.prepareCall(sql);
			pst.setInt(1, e.getCod_cli());
			pst.setString(2, e.getRsn_cli());
			pst.setString(3, e.getRdn_cli());
			pst.setString(4, e.getDir_cli());
			pst.setInt(5, e.getCod_dis());
			pst.setString(6, e.getTel_cli());
			pst.setString(7, e.getEma_cli());
			pst.setString(8, e.getTip_cli());									
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
	public int actualizar(Cliente e) {
		Connection con=null;
		PreparedStatement pst=null;
		int actualizado=-1;
		try {
			con=MySqlConexion.getConexion();
			String sql="{call USP_ACTUALIZAR_CLIENTE(?,?,?,?,?,?,?,?)}";
			pst=con.prepareCall(sql);
			pst.setInt(1, e.getCod_cli());
			pst.setString(2, e.getRsn_cli());
			pst.setString(3, e.getRdn_cli());
			pst.setString(4, e.getDir_cli());
			pst.setInt(5, e.getCod_dis());
			pst.setString(6, e.getTel_cli());
			pst.setString(7, e.getEma_cli());
			pst.setString(8, e.getTip_cli());									
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
			String sql="{call USP_ELIMINAR_CLIENTE(?)}";
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
	public ArrayList<Cliente> listar() {
		Connection con=null;
		PreparedStatement pst=null;
		ArrayList<Cliente> lista= new ArrayList<>();
		ResultSet rs=null; 
		try {
		   con=MySqlConexion.getConexion(); 
		   String sql="{call USP_LISTAR_CLIENTE}";
		   pst = con.prepareCall(sql);  
		   rs = pst.executeQuery();
		   Cliente c;
		   while (rs.next()){
			   c= new Cliente();
			   c.setCod_cli(rs.getInt(1));
			   c.setRsn_cli(rs.getString(2));
			   c.setRdn_cli(rs.getString(3));
			   c.setDir_cli(rs.getString(4));
			   c.setCod_dis(rs.getInt(5));
			   c.setTel_cli(rs.getString(6));
			   c.setEma_cli(rs.getString(7));
			   c.setTip_cli(rs.getString(8));			   			   
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
	public ArrayList<Cliente> listardni(String dni) {
		Connection con=null;
		PreparedStatement pst=null;
		ArrayList<Cliente> lista= new ArrayList<>();
		ResultSet rs=null; 
		try {
		   con=MySqlConexion.getConexion(); 
		   String sql="{call USP_CONSULTA_CLIENTE_POR_RDN(?)}";
		   pst = con.prepareCall(sql); 
		   pst.setString(1, dni);
		   rs = pst.executeQuery();
		   Cliente c;
		   while (rs.next()){
			   c= new Cliente();
			   c.setCod_cli(rs.getInt(1));
			   c.setRsn_cli(rs.getString(2));
			   c.setRdn_cli(rs.getString(3));
			   c.setDir_cli(rs.getString(4));
			   c.setCod_dis(rs.getInt(5));
			   c.setTel_cli(rs.getString(6));
			   c.setEma_cli(rs.getString(7));
			   c.setTip_cli(rs.getString(8));			   			   
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
	public ArrayList<Cliente> listarrso(String rso) {
		Connection con=null;
		PreparedStatement pst=null;
		ArrayList<Cliente> lista= new ArrayList<>();
		ResultSet rs=null; 
		try {
		   con=MySqlConexion.getConexion(); 
		   String sql="{call USP_CONSULTA_CLIENTE_POR_RSN(?)}";
		   pst = con.prepareCall(sql); 
		   pst.setString(1, rso);
		   rs = pst.executeQuery();
		   Cliente c;
		   while (rs.next()){
			   c= new Cliente();
			   c.setCod_cli(rs.getInt(1));
			   c.setRsn_cli(rs.getString(2));
			   c.setRdn_cli(rs.getString(3));
			   c.setDir_cli(rs.getString(4));
			   c.setCod_dis(rs.getInt(5));
			   c.setTel_cli(rs.getString(6));
			   c.setEma_cli(rs.getString(7));
			   c.setTip_cli(rs.getString(8));			   			   
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
