package sessions_factory;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HbFactory {
    private static HbFactory factory;
    private static SessionFactory ourSessionFactory;

    private HbFactory() {
    }

    public static HbFactory instance() {
        if (factory == null) {
            try {
                factory = new HbFactory();
                Configuration configuration = new Configuration();
                configuration.configure("/hibernate.cfg.xml");
                ServiceRegistry serviceRegistry =
                        new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
                ourSessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Throwable ex) {
                throw new ExceptionInInitializerError(ex);
            }
        }
        return factory;
    }


    public Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }


}
