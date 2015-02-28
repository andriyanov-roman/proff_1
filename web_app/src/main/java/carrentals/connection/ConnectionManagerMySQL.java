package carrentals.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
public class ConnectionManagerMySQL {
	private static Logger logger=Logger.getLogger(ConnectionManagerMySQL.class);
	
	private static ConnectionManagerMySQL instance;
	private static Connection connection;
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/shop";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "";

	private ConnectionManagerMySQL() {
		logger.info("Create new instance. Resource bundle complete");
	}

	public static synchronized ConnectionManagerMySQL getInstance() {
		if (instance == null) {
			instance = new ConnectionManagerMySQL();
		}
		return instance;
	}

	public  synchronized Connection getConnection() {
		try {
			Class.forName(JDBC_DRIVER);
			logger.info("Registered JDBC driver ");
			connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
			logger.info("Create new coonection");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
