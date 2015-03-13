package sessions_factory;


import org.hibernate.Session;
import shop.goods.Good;

public class GoodHB {

    public void addGood(Good good){
        Session session = HbFactory.instance().getSession();
        session.getTransaction().begin();
        session.save(good);
        session.getTransaction().commit();
        session.close();
    }
}
