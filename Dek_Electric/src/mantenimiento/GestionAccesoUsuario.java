package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import interfaces.AccesoUsuarioInterface;
import model.AccesoUsuario;
import utils.MySqlConexion;

public class GestionAccesoUsuario implements AccesoUsuarioInterface {

	@Override
	public AccesoUsuario validar(String log, String pas) {
		Connection con=null;
		PreparedStatement pst=null;
		AccesoUsuario au=null;
		ResultSet rs=null;
		try {
			con=MySqlConexion.getConexion();
			String sql="{ call USP_VALIDAR_ACCESO(?,?)}";
			pst=con.prepareCall(sql);
			pst.setString(1, log);
			pst.setString(2, pas);
			rs=pst.executeQuery();			
			rs.next();
			//if(rs!=null){
			au=new AccesoUsuario();
			au.setApe_emp(rs.getString(1));
			au.setNom_emp(rs.getString(2));
			au.setLog_usu(rs.getString(3));
			//}					
		} catch (Exception e) {
			System.out.println("Error en la sentencia: "+e.getMessage());
		}finally {
			try {
				if(pst!=null)
					pst.close();
				if(con!=null)
					con.close();
			} catch (Exception e2) {
				System.out.println("Error al cerrar");
			}
		}
		
		return au;
	}
	
}
