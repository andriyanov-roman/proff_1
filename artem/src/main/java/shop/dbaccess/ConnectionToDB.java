package shop.dbaccess;


import java.sql.*;

public class ConnectionToDB {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/shop";
    static final String USER = "root";
    static final String PASS = "13071995";

    public Connection conn;
    private PreparedStatement preparedStatement;
    public static ConnectionToDB db;
    private Statement statement;
    private ConnectionToDB() {
        try {
            Class.forName(JDBC_DRIVER).newInstance();
            this.conn = (Connection)DriverManager.getConnection(DB_URL,USER,PASS);
        }
        catch (Exception sqle) {
            sqle.printStackTrace();
        }
    }
    public static synchronized ConnectionToDB getDbCon() {
        if ( db == null ) {
            db = new ConnectionToDB();
        }
        return db;

    }

    public PreparedStatement query(String query) throws SQLException{
        preparedStatement = db.conn.prepareStatement(query);
        return preparedStatement;
    }
    public ResultSet querys(String query) throws SQLException{
        statement = db.conn.createStatement();
        ResultSet res = statement.executeQuery(query);
        return res;
    }
}