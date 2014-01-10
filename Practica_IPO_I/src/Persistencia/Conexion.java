package persistencia;
import java.sql.*;
import javax.swing.JOptionPane;


public class Conexion {
	
	Connection conn = null;
	String accessFilePath = "Usuarios";
	
	public Conexion(){
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			conn = DriverManager.getConnection("jdbc:odbc:"+accessFilePath+"");
			if (conn != null){
				JOptionPane.showMessageDialog(null, "Conexión a BD Usuarios lista");
			}			
		}catch(SQLException e){
			System.out.println(e);
		}catch(ClassNotFoundException e){
			System.out.println(e);
		}
	}
	
	public Connection getConnection(){
		return conn;
	}
	
	public void desconectar(){
		conn = null;
	}
	
}
