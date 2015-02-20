package shop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrintAll {
    Connection connection = ConnectDB.getConnectoin();

    public void PrintGoods() throws SQLException {
        String sql = "SELECT * FROM  goods";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet result = statement.executeQuery(sql);
        while (result.next()){
            String name = result.getString("good_name");
            int qty = result.getInt("good_qty");
            int barcode = result.getInt("barcode");
            String type = result.getString("good_type");
            Good good = new Good();
            good.setName(name);
            good.setAmount(qty);
            good.setBarcode(barcode);
            good.setType(type);
            System.out.println(good.toString());
        }
    }
}
