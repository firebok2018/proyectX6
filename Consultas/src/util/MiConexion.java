package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MiConexion {
	
	private final String URL="jdbc:mysql://localhost:3306/bd_agenda?useSSL=false";
	private final String USER="root";
	private final String PASS="mysql";
	
	public MiConexion() {}
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(URL,USER,PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	

}
