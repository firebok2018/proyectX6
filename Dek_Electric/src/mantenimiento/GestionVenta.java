package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import interfaces.VentaInterface;
import model.Venta;
import utils.MySqlConexion;

public class GestionVenta implements VentaInterface {

	@Override
	public int insertar(Venta v) {
		Connection con=null;
		PreparedStatement pst=null;
		int insertado=-1;
		try {
			con=MySqlConexion.getConexion();
			String sql="{call USP_INSERTAR_VENTA(?,?,?,?,?)}";
			pst=con.prepareCall(sql);
			pst.setInt(1, v.getNum_ven());
			pst.setString(2, v.getFec_ven());
			pst.setInt(3, v.getCod_cli());
			pst.setString(4, v.getEst_ven());			
			pst.setInt(5, v.getCod_emp());
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
	public int actualizar(Venta v) {
		Connection con=null;
		PreparedStatement pst=null;
		int actualizado=-1;
		try {
			con=MySqlConexion.getConexion();
			String sql="{call USP_ACTUALIZAR_VENTA(?,?,?,?,?)}";
			pst=con.prepareCall(sql);
			pst.setInt(1, v.getNum_ven());
			pst.setString(2, v.getFec_ven());
			pst.setInt(3, v.getCod_cli());
			pst.setString(4, v.getEst_ven());			
			pst.setInt(5, v.getCod_emp());
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
	public ArrayList<Venta> listar() {
		Connection con=null;
		PreparedStatement pst=null;
		ArrayList<Venta> lista= new ArrayList<>();
		ResultSet rs=null; 
		try {
		   con=MySqlConexion.getConexion(); 
		   String sql="{call USP_LISTAR_USUARIO}";
		   pst = con.prepareCall(sql);  
		   rs = pst.executeQuery();
		   Venta v;
		   while (rs.next()){
			   v= new Venta();
			   v.setNum_ven(rs.getInt(1));
			   v.setFec_ven(rs.getString(2));
			   v.setCod_cli(rs.getInt(3));
			   v.setEst_ven(rs.getString(4));
			   v.setCod_emp(rs.getInt(5));
			   lista.add(v);
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
	public ArrayList<Venta> listarNUM(int num) {
		Connection con=null;
		PreparedStatement pst=null;
		ArrayList<Venta> lista= new ArrayList<>();
		ResultSet rs=null; 
		try {
		   con=MySqlConexion.getConexion(); 
		   String sql="{call USP_CONSULTA_VENTA_POR_NUMERO(?)}";
		   pst = con.prepareCall(sql); 
		   pst.setInt(1, num);
		   rs = pst.executeQuery();
		   Venta v;
		   while (rs.next()){
			   v= new Venta();
			   v.setNum_ven(rs.getInt(1));
			   v.setCantidad(rs.getString(2));
			   v.setTotal(rs.getString(3));
			   lista.add(v);
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
	public ArrayList<Venta> listarMAR(String mar) {
		Connection con=null;
		PreparedStatement pst=null;
		ArrayList<Venta> lista= new ArrayList<>();
		ResultSet rs=null; 
		try {
		   con=MySqlConexion.getConexion(); 
		   String sql="{call USP_CONSULTA_VENTA_PRODUCTO_POR_MARCA(?)}";
		   pst = con.prepareCall(sql); 
		   pst.setString(1, mar);
		   rs = pst.executeQuery();
		   Venta v;
		   while (rs.next()){
			   v= new Venta();
			   v.setDes_mar(rs.getString(1));
			   v.setCantidad(rs.getString(2));
			   v.setTotal(rs.getString(3));
			   lista.add(v);
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
	public ArrayList<Venta> listarNOMP(String nomp) {
		Connection con=null;
		PreparedStatement pst=null;
		ArrayList<Venta> lista= new ArrayList<>();
		ResultSet rs=null; 
		try {
		   con=MySqlConexion.getConexion(); 
		   String sql="{call USP_CONSULTA_VENTA_PRODUCTO_POR_NOMBRE(?)}";
		   pst = con.prepareCall(sql); 
		   pst.setString(1, nomp);
		   rs = pst.executeQuery();
		   Venta v;
		   while (rs.next()){
			   v= new Venta();
			   v.setDes_pro(rs.getString(1));
			   v.setCantidad(rs.getString(2));
			   v.setTotal(rs.getString(3));
			   lista.add(v);
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
	public ArrayList<Venta> listarNOMC(String nomc) {
		Connection con=null;
		PreparedStatement pst=null;
		ArrayList<Venta> lista= new ArrayList<>();
		ResultSet rs=null; 
		try {
		   con=MySqlConexion.getConexion(); 
		   String sql="{call USP_CONSULTA_VENTA_POR_CLIENTE(?)}";
		   pst = con.prepareCall(sql); 
		   pst.setString(1, nomc);
		   rs = pst.executeQuery();
		   Venta v;
		   while (rs.next()){
			   v= new Venta();
			   v.setNum_ven(rs.getInt(1));
			   v.setRso_cli(rs.getString(2));
			   v.setCantidad(rs.getString(3));
			   v.setTotal(rs.getString(4));
			   lista.add(v);
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
	public ArrayList<Venta> listarNOME(String nome) {
		Connection con=null;
		PreparedStatement pst=null;
		ArrayList<Venta> lista= new ArrayList<>();
		ResultSet rs=null; 
		try {
		   con=MySqlConexion.getConexion(); 
		   String sql="{call USP_CONSULTA_VENTA_POR_EMPLEADO(?)}";
		   pst = con.prepareCall(sql); 
		   pst.setString(1, nome);
		   rs = pst.executeQuery();
		   Venta v;
		   while (rs.next()){
			   v= new Venta();
			   v.setNum_ven(rs.getInt(1));
			   v.setApe_emp(rs.getString(2));
			   v.setNom_emp(rs.getString(3));
			   v.setCantidad(rs.getString(4));
			   v.setTotal(rs.getString(5));
			   lista.add(v);
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
	public ArrayList<Venta> listarEST(String est) {
		Connection con=null;
		PreparedStatement pst=null;
		ArrayList<Venta> lista= new ArrayList<>();
		ResultSet rs=null; 
		try {
		   con=MySqlConexion.getConexion(); 
		   String sql="{call USP_CONSULTA_VENTA_POR_ESTADO(?)}";
		   pst = con.prepareCall(sql); 
		   pst.setString(1, est);
		   rs = pst.executeQuery();
		   Venta v;
		   while (rs.next()){
			   v= new Venta();
			   v.setNum_ven(rs.getInt(1));
			   v.setEst_ven(rs.getString(2));
			   v.setCantidad(rs.getString(3));
			   v.setTotal(rs.getString(4));
			   lista.add(v);
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
	public ArrayList<Venta> listarFEC(String fec1,String fec2) {
		Connection con=null;
		PreparedStatement pst=null;
		ArrayList<Venta> lista= new ArrayList<>();
		ResultSet rs=null; 
		try {
		   con=MySqlConexion.getConexion(); 
		   String sql="{call USP_CONSULTA_VENTA_POR_RANGO_FECHAS(?,?)}";
		   pst = con.prepareCall(sql); 
		   pst.setString(1, fec1);
		   pst.setString(2, fec2);
		   rs = pst.executeQuery();
		   Venta v;
		   while (rs.next()){
			   v= new Venta();
			   v.setNum_ven(rs.getInt(1));
			   v.setCantidad(rs.getString(2));
			   v.setTotal(rs.getString(3));
			   lista.add(v);
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
