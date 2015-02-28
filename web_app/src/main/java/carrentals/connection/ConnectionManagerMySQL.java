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
	private static final String DB_DRIVER = "org.gjt.mm.mysql.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/carrentals";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "yurceh12";

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
			Class.forName(DB_DRIVER);
			logger.info("Registered JDBC driver ");
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			logger.info("Create new coonection");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
