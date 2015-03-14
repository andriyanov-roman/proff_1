import org.hibernate.*;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import sessions_factory.HbFactory;
import shop.users.User;

import java.util.List;

public class CriteriaTest {
    @Test
    public void get() {
        Session session = HbFactory.instance().getSession();
        Transaction tx = session.beginTransaction();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("login", "Vlad"));
        tx.commit();
        List res = criteria.list();
        System.out.println(res);
        session.close();

    }
}
