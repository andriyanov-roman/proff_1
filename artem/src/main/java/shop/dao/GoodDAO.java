package shop.dao;

import shop.entity.Good;

import java.sql.SQLException;

/**
 * Created by artem on 15.02.15.
 */
public interface GoodDAO {
   public void executeUpdate(Good good) throws ClassNotFoundException, SQLException;
}
