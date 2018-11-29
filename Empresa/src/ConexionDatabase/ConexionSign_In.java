package ConexionDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import model.Usuarios;
import utils.Conexion;

public class ConexionSign_In extends Conexion {

	
	
	public int Sign_In(String user,String pwd){
		int valor=0;
		Connection con = null;
		Statement st= null;
		ResultSet rs=null;
		
		try {
			String sql="select*from Usuarios where Usuario ='"+user+"'and pwdUser=sha1('"+pwd+"')";
			con= new Conexion().getConexion();
			st=con.createStatement();
			rs=st.executeQuery(sql);
			
			if(rs.next()){
				
				valor=1;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "error de co");
		}finally {
			try {
				con.close();
				st.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return valor;
	}
	


}



