package singletones;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HbSessionFactory {
    private static HbSessionFactory factory;
    private static SessionFactory ourSessionFactory;

    private HbSessionFactory() {

    }

    public static HbSessionFactory getInstance() {
        if (factory == null) {
            try {
                factory = new HbSessionFactory();
                Configuration configuration = new Configuration();
                configuration.configure();
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
