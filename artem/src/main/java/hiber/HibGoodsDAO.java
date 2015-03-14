package hiber;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import shop.Good;
import shop.User;

import java.util.List;

/**
 * Created by artem on 08.03.15.
 */
public class HibGoodsDAO {
    Session session;

    public void executeGood(Good good) {
        session = HbFactory.getInstance().getSession();
        try {
            session.getTransaction().begin();
            session.save(good);
            session.getTransaction().commit();
        } finally {
            if (session != null) session.close();
        }
    }

    public List<Good> readFromBD() {
        SessionFactory sessions = new Configuration().configure().buildSessionFactory();
        Session session = sessions.openSession();
        session.beginTransaction();
        session.getTransaction().commit();
        List<Good> goods = (List<Good>) session.createCriteria(Good.class).list();
        return goods;
    }
}
