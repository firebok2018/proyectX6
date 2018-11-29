package modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import entidad.Agenda;
import util.MiConexion;

public class ModelAgenda {

	public List<Agenda> listaAgenda() {
		List<Agenda> datos = new ArrayList<Agenda>();
		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			
			con = new MiConexion().getConnection();
			String sql = "select * from tb_agenda";
			pstm=con.prepareStatement(sql);
			rs=pstm.executeQuery();
			
			Agenda a = null;
			
			while (rs.next()) {
				a = new Agenda();
				a.setIdagenda(rs.getInt("idagenda"));
				a.setApellidos(rs.getString("apellidos"));
				a.setNombres(rs.getString("nombres"));
				a.setDireccion(rs.getString("direccion"));
				a.setEdad(rs.getInt("edad"));
				a.setFechaNacimiento(rs.getDate("fechadenacimiento").toString());
				datos.add(a);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
				con.close();
				rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return datos;
	}
	
	public int insertarAgenda(Agenda obj) throws ParseException {
		int insertados=-1;
		String fecha = obj.getFechaNacimiento();
		
		java.util.Date fnac = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
		java.sql.Date sqlDate = new java.sql.Date(fnac.getTime());
		
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			con = new MiConexion().getConnection();
			String sql = "insert into tb_agenda values(null,?,?,?,?,?)";
			pstm=con.prepareStatement(sql);
			
			pstm.setString(1, obj.getApellidos());
			pstm.setString(2, obj.getNombres());
			pstm.setString(3, obj.getDireccion());
			pstm.setInt(4, obj.getEdad());
			pstm.setDate(5, sqlDate);
			
			insertados=pstm.executeUpdate();
			JOptionPane.showMessageDialog(null, "Registros insertados: "+insertados);		
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
				con.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}	
		
		return insertados;
	}
	
	public List<Agenda> getActual(int id) {
		List<Agenda> actual = new ArrayList<>();
		
		Connection cn = null;
		PreparedStatement pstm=null;
		ResultSet rs = null;
		
		try {
			cn = new MiConexion().getConnection();
			String sql = "select * from tb_agenda WHERE idagenda=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			Agenda a = null;
			if (rs.next()) {
				a = new Agenda();
				a.setIdagenda(rs.getInt("idagenda"));
				a.setApellidos(rs.getString("apellidos"));
				a.setNombres(rs.getString("nombres"));
				a.setDireccion(rs.getString("direccion"));
				a.setEdad(rs.getInt("edad"));
				a.setFechaNacimiento(rs.getDate("fechadenacimiento").toString());
				actual.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstm.close();
				cn.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
		
		return actual;
		
	}

	public int actualizarAgenda(Agenda obj) throws ParseException {
		int actualizados=-1;
		
		String fecha = obj.getFechaNacimiento();
		
		Date fnac = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
		java.sql.Date sqlDate = new java.sql.Date(fnac.getTime());		
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			con = new MiConexion().getConnection();
			String sql="update tb_agenda set apellidos=?,"
					+ "nombres=?,"
					+ "direccion=?,"
					+ "edad=?,"
					+ "fechadenacimiento=?"
					+ " where idagenda=?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, obj.getApellidos());
			pstm.setString(2, obj.getNombres());
			pstm.setString(3, obj.getDireccion());
			pstm.setInt(4, obj.getEdad());
			pstm.setDate(5, sqlDate);
			pstm.setInt(6, obj.getIdagenda());
			
			actualizados=pstm.executeUpdate();
			JOptionPane.showMessageDialog(null, "Registros actualizados: "+actualizados);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm!=null) pstm.close();
				if (con!=null) con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}		
		return actualizados;	
	}

	public int eliminaContacto(int idagenda) {
		int eliminados=-1;
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			con = new MiConexion().getConnection();
			String sql = "delete from tb_agenda where idagenda=?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, idagenda);
			eliminados=pstm.executeUpdate();
			JOptionPane.showMessageDialog(null, "Registros eliminados: "+eliminados);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}		
		return eliminados;
	}

	public List<Agenda> getByApellidos(String apellidos) {
		List<Agenda> registros = new ArrayList<>();
		Connection cn = null;
		PreparedStatement pstm= null;
		ResultSet rs= null;
		
		try {
			cn = new MiConexion().getConnection();
			String sql= "select * from tb_agenda where apellidos LIKE ? order by apellidos";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, "%"+apellidos+"%");
			rs=pstm.executeQuery();
			Agenda x;
			while (rs.next()) {
				x=new Agenda();
				x.setIdagenda(rs.getInt("idagenda"));
				x.setApellidos(rs.getString("apellidos"));
				x.setNombres(rs.getString("nombres"));
				x.setDireccion(rs.getString("direccion"));
				x.setEdad(rs.getInt("edad"));
				x.setFechaNacimiento(rs.getDate("fechadenacimiento").toString());
				registros.add(x);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm!=null) pstm.close();
				if (cn!=null) cn.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
		
		return registros;
		
	}

	public List<Agenda> getByCod(int id) {
		Connection cn = null;
		CallableStatement cstm = null;
		ResultSet rs = null;
		List<Agenda> registro = new ArrayList<>();
		
		try {
			cn = new MiConexion().getConnection();
			String sp = "{call consulta_contacto(?)}";
			cstm = cn.prepareCall(sp);
			cstm.setInt(1, id);
			rs = cstm.executeQuery();
			Agenda x;
			if (rs.next()) {
				x=new Agenda();
				x.setIdagenda(rs.getInt("idagenda"));
				x.setApellidos(rs.getString("apellidos"));
				x.setNombres(rs.getString("nombres"));
				x.setDireccion(rs.getString("direccion"));
				x.setEdad(rs.getInt("edad"));
				x.setFechaNacimiento(rs.getDate("fechadenacimiento").toString());
				registro.add(x);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs!=null) rs.close();
				if (cstm!=null) cstm.close();
				if (cn!=null) cn.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}		
		return registro;
	}
	
}

