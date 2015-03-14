package singletones;

import org.hibernate.Session;
import person.Person;

public class Test {
    @person.Test
    public void TestSingleTone(Person person){
        Session session = HbSessionFactory.getInstance().getSession();
        session.getTransaction().begin();
        Person personOne = new Person();


    }


}
