package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.UsuarioInterface;
import model.Usuario;
import utils.MySqlConexion;

public class GestionUsuario implements UsuarioInterface {

	@Override
	public int insertar(Usuario u) {
		Connection con=null;
		PreparedStatement pst=null;
		int insertado=-1;
		try {
			con=MySqlConexion.getConexion();
			String sql="{call USP_INSERTAR_USUARIO(?,?,?,?)}";
			pst=con.prepareCall(sql);
			pst.setInt(1, u.getCod_usu());
			pst.setInt(2, u.getCod_emp());
			pst.setString(3, u.getLog_usu());
			pst.setString(4, u.getPas_usu());			
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
	public int actualizar(Usuario u) {
		Connection con=null;
		PreparedStatement pst=null;
		int actualizado=-1;
		try {
			con=MySqlConexion.getConexion();
			String sql="{call USP_ACTUALIZAR_USUARIO(?,?,?,?)}";
			pst=con.prepareCall(sql);
			pst.setInt(1, u.getCod_usu());
			pst.setInt(2, u.getCod_emp());
			pst.setString(3, u.getLog_usu());
			pst.setString(4, u.getPas_usu());			
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
			String sql="{call USP_ELIMINAR_USUARIO(?)}";
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
	public ArrayList<Usuario> listar() {
		Connection con=null;
		PreparedStatement pst=null;
		ArrayList<Usuario> lista= new ArrayList<>();
		ResultSet rs=null; 
		try {
		   con=MySqlConexion.getConexion(); 
		   String sql="{call USP_LISTAR_USUARIO}";
		   pst = con.prepareCall(sql);  
		   rs = pst.executeQuery();
		   Usuario u;
		   while (rs.next()){
			   u= new Usuario();
			   u.setCod_usu(rs.getInt(1));
			   u.setCod_emp(rs.getInt(2));
			   u.setLog_usu(rs.getString(3));
			   u.setPas_usu(rs.getString(4));
			   lista.add(u);
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
