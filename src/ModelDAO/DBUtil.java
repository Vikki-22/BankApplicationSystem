package ModelDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/bank";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Vikki@2004";
	  
	public static Connection makeConnection()
    {
		Connection con=null;
		try {

			Class.forName(DRIVER);

			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			System.out.println("Connection Success....");

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		return con;
		}
	}
