package shop.dao;

import shop.entity.Good;
import old.dbaccess.ConnectionToDB;

import java.sql.*;
import java.util.ArrayList;


public class GoodDAOimpl implements GoodDAO {
    ConnectionToDB connectionToDB = ConnectionToDB.getDbCon();
    String sqlUpdate = "INSERT INTO shop.goods (good_name, good_number, barcode, good_type) VALUES (?,?,?,?)";
    String sqlRead = "SELECT * FROM shop.goods";

    @Override
    public void executeUpdate(Good good) throws ClassNotFoundException, SQLException {
        PreparedStatement preparedStatement = connectionToDB.query(sqlUpdate);
        Good goods = good;
        preparedStatement.setString(1, goods.getName());
        preparedStatement.setInt(2, goods.getNumber());
        preparedStatement.setLong(3, goods.getBarcode());
        preparedStatement.setString(4, goods.getType());
        preparedStatement.execute();
    }

    public ArrayList<Good> readFromDB() throws SQLException {
        ResultSet resultSet = connectionToDB.querys(sqlRead);
        ArrayList <Good> goods=new ArrayList<>();
        while (resultSet.next()) {
            Good good = new Good();
            int id = resultSet.getInt("id");
            String name = resultSet.getString("good_name");
            String type = resultSet.getString("good_type");
            long barcode = resultSet.getLong("barcode");
            int number = resultSet.getInt("good_number");
            good.setNumber(number);
            good.setBarcode(barcode);
            good.setType(type);
            good.setName(name);
            goods.add(good);
        }
        return goods;
    }
}


