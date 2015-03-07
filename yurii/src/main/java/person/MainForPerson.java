package person;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainForPerson {
    private SessionFactory sessionFactory;

    public MainForPerson() {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            Session session = null;
            try {
                session = sessionFactory.openSession();
                session.getTransaction().begin();
                Person person = new Person();
                person.setFirstName("Yury");
                person.setSecondName("Hav1111");
                session.save(person);
                System.out.printf("Insert Person: %s\n", person);
                Long id = person.getId();
                session.getTransaction().commit();
                session.close();
                session = sessionFactory.openSession();
                session.getTransaction().begin();
                Person person2 = (Person) session.get(Person.class, id);
                System.out.printf("Person select: %s\n", person2);
                session.getTransaction().commit();
            } finally {
                if (session != null) session.close();
            }

        } finally {
            if (sessionFactory != null) sessionFactory.close();
        }
    }
    public static void main(String args[]) {
        new MainForPerson();
    }
}
