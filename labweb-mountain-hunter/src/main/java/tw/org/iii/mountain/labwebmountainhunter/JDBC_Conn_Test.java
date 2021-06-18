package tw.org.iii.mountain.labwebmountainhunter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBC_Conn_Test {

	public static void main(String[] args) {
		try {
			Properties prop = new Properties();
			prop.put("user", "root");
			prop.put("password", "root");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/", prop);
			System.out.println("ok4");
		}catch (Exception e) {
			System.out.println(e);
		}
	}

}
