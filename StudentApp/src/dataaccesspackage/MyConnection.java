package dataaccesspackage;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.jdbc.Connection;

public class MyConnection {
	
	public static Connection getConnection()
	{
		Connection con= null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/studentdb", "root", "");
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		return con;
	}
}
