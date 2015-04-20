package spring.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import shop.entity.Good;

import java.util.List;

@Repository
public class GoodsDAO extends AbstractDAO implements IGoodsDAO  {
    @Override
    public void executeGood(Good good) {
        Session session=null;
        session = getSession();
        try {
            session.getTransaction().begin();
            session.save(good);
            session.getTransaction().commit();
        } finally {
            if (session != null) session.close();
        }

    }

    @Override
    public List<Good> findAllGoods() {
        Session session=null;
        session = getSession();
        session.beginTransaction();
        session.getTransaction().commit();
        List<Good> goods = (List<Good>) session.createCriteria(Good.class).list();
        return goods;
    }
}
