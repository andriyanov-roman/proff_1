package hiber;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import shop.Good;

/**
 * Created by artem on 07.03.15.
 */
public class MainForPerson {
    Session session;


    public void executeGood(Good good) {
//        session = HbFactory.getInstance().getSession();
//        try {
//            session.getTransaction().begin();
//            session.
//            session.save(good);
//            System.out.printf("Insert Person: %s\n", good);
//            Long id = good.getId();
//            session.getTransaction().commit();
//            session.close();
//            session = HbFactory.getInstance().getSession();
//            session.getTransaction().begin();
//            Person person2 = (Person) session.get(Person.class, id);
//            System.out.printf("Person select: %s\n", person2);
//            session.getTransaction().commit();
//        } finally {
//            if (session != null) session.close();
//        }

    }

    public static void main(String args[]) {
        new MainForPerson();
    }
}