package person;

import org.h2.engine.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import singletones.HbSessionFactory;

import java.util.List;

public class TestOne {
    Session session = HbSessionFactory.getInstance().getSession();

    @Test
    public void TestCriteria() throws Exception{
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("name" , "Alan"));
        List result = criteria.list();
    }

    public static void main(String[] args) {
        new TestOne();
    }
}
