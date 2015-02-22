package shop;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class GoodDAOImpl implements GoodDAO {
    @Override
    public void executeUpdate(Good good) throws SQLException, ClassNotFoundException {
        try {
            String sqlUpdate = "insert into goods (good_name,good_qty,barcode,good_type) values (?,?,?,?)";
            PreparedStatement preparedStatement = ConnectDB.getConnectoin().prepareStatement(sqlUpdate);
            preparedStatement.setString(1, good.getName());
            preparedStatement.setInt(2, good.getAmount());
            preparedStatement.setLong(3, good.getBarcode());
            preparedStatement.setString(4, good.getType());
            preparedStatement.execute();
        } finally {
            ConnectDB.getConnectoin().close();
        }
    }

    @Override
    public Set<Good> selectGood() throws SQLException {
        try {
            Set<Good> goodSet = new HashSet<>();
            String sql = "SELECT * FROM  goods";
            PreparedStatement statement = ConnectDB.getConnectoin().prepareStatement(sql);
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                String name = result.getString("good_name");
                int qty = result.getInt("good_qty");
                int barcode = result.getInt("barcode");
                String type = result.getString("good_type");
                Good good = new Good();
                good.setName(name);
                good.setAmount(qty);
                good.setBarcode(barcode);
                good.setType(type);
                goodSet.add(good);
            }
            return goodSet;
        } finally {
            ConnectDB.getConnectoin().close();
        }
    }
}