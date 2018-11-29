package ConexionDatabase;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import model.Venta;
import utils.Conexion;

public class ConexionVentas {
	public void add_venta(Venta v){
		Connection con= null;
		CallableStatement sp= null;
		try {
			con= new Conexion().getConexion();
			con.setAutoCommit(false);
			String u_sp="{call add_Platillos(?,?,?,?,?,?,?)}";
			sp=con.prepareCall(u_sp);
			//call add_Platillos('V0001','C0001','Extras','nombre apellido','dss',4,'U0001');
			sp.setString(1, v.getCodigoVenta());
			sp.setString(2, v.getCodigoCliente());
			sp.setString(3, v.getTipoPedido());
			sp.setString(4, v.getNombreCliente());
			sp.setString(5, v.getPedido());
			sp.setInt(6, v.getCantidad());
			sp.setString(7,v.getUserV());
			sp.executeQuery();
			con.commit();
		} catch (SQLException e) {
			// TODO: handle exception
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getSQLState()+e1.getErrorCode()+e1.getLocalizedMessage());
			}
			System.out.println(e.getSQLState()+e.getErrorCode()+e.getLocalizedMessage());
		}finally {
			try {
				con.close();
				sp.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getSQLState()+e.getErrorCode()+e.getLocalizedMessage());
			}
		}
	}
	public void update_venta(Venta u){
		Connection con= null;
		CallableStatement sp= null;
		try {
			con= new Conexion().getConexion();
			con.setAutoCommit(false);
			String u_sp="{call update_Venta(?,?,?,?,?,?,?)}";
			sp=con.prepareCall(u_sp);
			//call update_Venta('V0005','C0001','Menu','arroz conpato','bebidasdas',4,'U0001');
			sp.setString(1, u.getCodigoVenta());
			sp.setString(2, u.getCodigoCliente());
			sp.setString(3, u.getTipoPedido());
			sp.setString(4, u.getNombreCliente());
			sp.setString(5, u.getPedido());
			sp.setInt(6, u.getCantidad());
			sp.setString(7,u.getUserV());
			sp.executeQuery();
			con.commit();
			
		} catch (SQLException e) {
			// TODO: handle exception
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getSQLState()+e1.getErrorCode()+e1.getLocalizedMessage());
			}
			System.out.println(e.getSQLState()+e.getErrorCode()+e.getLocalizedMessage());
		}finally {
			try {
				con.close();
				sp.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getSQLState()+e.getErrorCode()+e.getLocalizedMessage());
			}
		}
	}
	public void delete_venta(Venta d){
		Connection con = null;
		CallableStatement sp= null;
		try {
			con= new Conexion().getConexion();
			con.setAutoCommit(false);
			String u_sp="{delete_venta(?,?)}";
			sp= con.prepareCall(u_sp);
			sp.setString(1, d.getCodigoVenta());
			sp.setString(2, d.getUserV());
			sp.executeQuery();
			con.commit();
			
		} catch (SQLException e) {
			// TODO: handle exception
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println(e.getSQLState()+e.getErrorCode()+e.getLocalizedMessage());
				
			}
			System.out.println(e.getSQLState()+e.getErrorCode()+e.getLocalizedMessage());
		}finally {
			try {
				con.close();
				sp.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getSQLState()+e.getErrorCode()+e.getLocalizedMessage());
			}
		}
		
	}
	public void SubtiposM(JComboBox t,int x){
		DefaultComboBoxModel<Venta> model;
		Connection con= null;
		CallableStatement sp= null;
		ResultSet rs= null;
		try {
			con= new Conexion().getConexion();
			sp=con.prepareCall("{call ls_MTipoPro()}");
			sp.setInt(1, x);
			rs=sp.executeQuery();
			model = new DefaultComboBoxModel<>();
			t.setModel(model);
			while (rs.next()) {
				model.addElement(new Venta(rs.getString(2)));
				
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getSQLState()+e.getErrorCode()+e.getLocalizedMessage());
		}finally {
			try {
				con.close();
				sp.close();
				//rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getSQLState()+e.getErrorCode()+e.getLocalizedMessage());
			}
			
		}	
	}
	public void SubtiposB(JComboBox t,int x){
		DefaultComboBoxModel<Venta> model;
		Connection con= null;
		CallableStatement sp= null;
		ResultSet rs= null;
		try {
			con= new Conexion().getConexion();
			sp=con.prepareCall("{call ls_BTipoPro(?)}");
			sp.setInt(1, x);
			rs=sp.executeQuery();
			model = new DefaultComboBoxModel<>();
			t.setModel(model);
			while (rs.next()) {
				model.addElement(new Venta(rs.getString(2)));
				
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getSQLState()+e.getErrorCode()+e.getLocalizedMessage());
		}finally {
			try {
				con.close();
				sp.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getSQLState()+e.getErrorCode()+e.getLocalizedMessage());
			}
			
		}	
	}
	public void SubtiposE(JComboBox t,int x){
		DefaultComboBoxModel<Venta> model;
		Connection con= null;
		CallableStatement sp= null;
		ResultSet rs= null;
		try {
			con= new Conexion().getConexion();
			sp=con.prepareCall("{call ls_ETipoPro(?)}");
			sp.setInt(1, x);
			rs=sp.executeQuery();
			model = new DefaultComboBoxModel<>();
			t.setModel(model);
			while (rs.next()) {
				model.addElement(new Venta(rs.getString(2)));
				
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getSQLState()+e.getErrorCode()+e.getLocalizedMessage());
		}finally {
			try {
				con.close();
				sp.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getSQLState()+e.getErrorCode()+e.getLocalizedMessage());
			}
			
		}	
	}
	public void listarVenta(JTable l){
		DefaultTableModel modelo= new DefaultTableModel();
		modelo.addColumn("Codigo");
		modelo.addColumn("C. Cliente");
		modelo.addColumn("T. Pedido");
		modelo.addColumn("Nombre Cliente");
		modelo.addColumn("Descripci�n");
		modelo.addColumn("Cantidad");
		modelo.addColumn("Nom Ven.");
		Connection con= null;
		CallableStatement sp=null;
		ResultSet rs= null;
		l.setModel(modelo);
		try {
			con=new Conexion().getConexion();
			con.setAutoCommit(false);
			sp=con.prepareCall("{ call ls_venta()}");
			rs=sp.executeQuery();
			String[]a=new String[7];
			con.commit();
			while (rs.next()) {
				a[0]=rs.getString(1);
				a[1]=rs.getString(2);
				a[2]=rs.getString(3);
				a[3]=rs.getString(4);
				a[4]=rs.getString(5);
				a[5]=rs.getInt(6)+"";
				a[6]=rs.getString(7);
				modelo.addRow(a);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getSQLState()+e1.getErrorCode()+e1.getLocalizedMessage());
			}
			System.out.println(e.getSQLState()+e.getErrorCode()+e.getLocalizedMessage());
		}finally {
			try {
				con.close();
				rs.close();
				sp.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getSQLState()+e.getErrorCode()+e.getLocalizedMessage());
			}
			
		}
	}
	
	
		
	
}
