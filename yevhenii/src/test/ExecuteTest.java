import exceptions.Good;
import org.junit.Test;
import shop.db_access.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by eugene on 21.02.15.
 */
public class ExecuteTest {
    @Test
    public void execTest() throws SQLException {
        Connection connection = DBConnection.createConnection();
        String sqlUpdate = "insert into shop.goods (good_name,good_quantity,barcode,good_type) values (?,?,?,?)";
        System.out.println("added to base");
        try {
            Good good = new Good("le",1,123123,"le");
            PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate);
            preparedStatement.setString(1, good.getName());
            preparedStatement.setInt(2, good.getQuantity());
            preparedStatement.setLong(3, good.getCode());
            preparedStatement.setString(4, good.getType());
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            connection.close();
        }

    }
    }

