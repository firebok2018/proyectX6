package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.EmpleadoInterface;
import model.Empleado;
import model.Producto;
import utils.MySqlConexion;

public class GestionEmpleado implements EmpleadoInterface {

	@Override
	public int insertar(Empleado e) {
		Connection con=null;
		PreparedStatement pst=null;
		int insertado=-1;
		try {
			con=MySqlConexion.getConexion();
			String sql="{call USP_INSERTAR_EMPLEADO(?,?,?,?,?,?,?,?,?,?)}";
			pst=con.prepareCall(sql);
			pst.setInt(1, e.getCod_emp());
			pst.setString(2, e.getTip_emp());
			pst.setString(3, e.getNom_emp());
			pst.setString(4, e.getApe_emp());
			pst.setString(5, e.getDni_emp());
			pst.setString(6, e.getFna_emp());
			pst.setString(7, e.getTel_emp());
			pst.setString(8, e.getDir_emp());
			pst.setInt(9, e.getCod_dis());
			pst.setString(10, e.getFin_emp());			
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
	public int actualizar(Empleado e) {
		Connection con=null;
		PreparedStatement pst=null;
		int actualizado=-1;
		try {
			con=MySqlConexion.getConexion();
			String sql="{call USP_ACTUALIZAR_EMPLEADO(?,?,?,?,?,?,?,?,?,?)}";
			pst=con.prepareCall(sql);
			pst.setInt(1, e.getCod_emp());
			pst.setString(2, e.getTip_emp());
			pst.setString(3, e.getNom_emp());
			pst.setString(4, e.getApe_emp());
			pst.setString(5, e.getDni_emp());
			pst.setString(6, e.getFna_emp());
			pst.setString(7, e.getTel_emp());
			pst.setString(8, e.getDir_emp());
			pst.setInt(9, e.getCod_dis());
			pst.setString(10, e.getFin_emp());			
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
			String sql="{call USP_ELIMINAR_EMPLEADO(?)}";
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
	public ArrayList<Empleado> listar() {
		Connection con=null;
		PreparedStatement pst=null;
		ArrayList<Empleado> lista= new ArrayList<>();
		ResultSet rs=null; 
		try {
		   con=MySqlConexion.getConexion(); 
		   String sql="{call USP_LISTAR_EMPLEADO}";
		   pst = con.prepareCall(sql);  
		   rs = pst.executeQuery();
		   Empleado e;
		   while (rs.next()){
			   e= new Empleado();
			   e.setCod_emp(rs.getInt(1));
			   e.setTip_emp(rs.getString(2));
			   e.setNom_emp(rs.getString(3));
			   e.setApe_emp(rs.getString(4));
			   e.setDni_emp(rs.getString(5));
			   e.setFna_emp(rs.getString(6));
			   e.setTel_emp(rs.getString(7));
			   e.setDir_emp(rs.getString(8));
			   e.setCod_dis(rs.getInt(9));
			   e.setFin_emp(rs.getString(10));			   
			   lista.add(e);
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
