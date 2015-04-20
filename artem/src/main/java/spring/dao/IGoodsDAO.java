package spring.dao;

import shop.entity.Good;

import java.util.List;

/**
 * Created by artem on 20.04.15.
 */
public interface IGoodsDAO {
    void executeGood(Good good);

    List<Good> findAllGoods();
}
