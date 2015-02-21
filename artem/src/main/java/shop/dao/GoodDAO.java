package shop.dao;

import shop.Good;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by artem on 15.02.15.
 */
public interface GoodDAO {
   public void executeUpdate(Good good) throws ClassNotFoundException, SQLException;
}
