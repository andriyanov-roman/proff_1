package shop;


import java.sql.SQLException;

public interface GoodDAO {
    public void executeUpdate(Good good) throws SQLException, ClassNotFoundException;
}
