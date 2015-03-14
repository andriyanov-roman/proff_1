import hiber.HbFactory;
import hiber.Person;
import org.hibernate.Session;
import org.junit.Test;
import shop.Good;


public class TestAddGoodToDB {
    Session session;

    @Test
    public void executeGood() {
        session = HbFactory.getInstance().getSession();
        try {
            session.getTransaction().begin();
            Good good=new Good();
            good.setNumber(1);
            good.setType("SAasd");
            good.setBarcode(124);
            good.setName("sfasf");
            session.save(good);
            session.getTransaction().commit();
        } finally {
            if (session != null) session.close();
        }
    }
}
