package tw.org.iii.mountain.labwebmountainhunter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBC_Conn_Test {

	public static void main(String[] args) {
		try {
			Properties prop = new Properties();
			prop.put("user", "ravelai2");
			prop.put("password", "iiiEngineer2021@");
			Connection conn = DriverManager.getConnection(
//					"jdbc:mysql://34.80.240.158/wordpress", prop);
			"jdbc:mysql://162.241.224.215/ravelai2_traveladventurehunter", prop);

			
			System.out.println("ok4");
		}catch (Exception e) {
			System.out.println(e);
		}
	}
}
