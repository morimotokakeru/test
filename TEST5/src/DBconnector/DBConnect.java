package DBconnector;
import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnect {
	public DBConnect() {}
	
	public static Connection getConnection() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.1.16:1521:orcl";
		String id = "hr";
		String pass = "1234";
		
		Connection con = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,id,pass);
		}catch(Exception e) {
			System.out.println(e);
		}
		return con;
	}
}
