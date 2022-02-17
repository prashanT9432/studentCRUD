package studentManagement.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
	
	private static final String DRIVER_PATH = "com.mysql.cj.jdbc.Driver";
	private static final String jdbcURL = "jdbc:mysql://localhost:3306/student_management";
	private static final String jdbcUSERNAME ="root";
	private static final String jdbcPASSWORD ="root";
	
	public DatabaseUtil() {

		try {
			Class.forName(DRIVER_PATH);

		} catch (Exception e) {
			throw new RuntimeException("Somthing went wrong. " + e);
		}

	}
	
	public Connection getConnection() throws SQLException {
		
		return DriverManager.getConnection(jdbcURL, jdbcUSERNAME, jdbcPASSWORD);
		
	}
}
