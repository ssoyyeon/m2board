package commons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public Connection getconection() throws ClassNotFoundException, SQLException {
		String driver = "org.mariadb.jdbc.Driver";
		String url = "jdbc:mariadb://localhost:3306/m2";
		String dbUser = "root";
		String dbpw = "1234";

		// DB 연결
		Class.forName(driver);
		// 디버깅
	    System.out.println("드라이버 로딩 성공");
		Connection conn = DriverManager.getConnection(url, dbUser, dbpw);
		// 디버깅
		System.out.println("DB가 연결되었습니다.");

		return conn;
	}
}
