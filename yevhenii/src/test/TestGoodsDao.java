import exceptions.Good;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by eugene on 21.02.15.
 */
public class TestGoodsDao extends TestDBAccess{
   static final String sqlUpdate = "insert into shop.goods (good_name,good_quantity,barcode,good_type) values (?,?,?,?)";
    static final
    @Test
    public void testGoodDao() throws SQLException {
        Good good = new Good("le",1,1213,"lele");

        System.out.println("added to base");

            PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate);
            preparedStatement.setString(1, good.getName());
            preparedStatement.setInt(2, good.getQuantity());
            preparedStatement.setLong(3, good.getCode());
            preparedStatement.setString(4, good.getType());
            preparedStatement.execute();

        }

    }

