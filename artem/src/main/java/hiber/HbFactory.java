package hiber;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.Map;

/**
 * Created by artem on 08.03.15.
 */
public class HbFactory {
    private static HbFactory factory;
    private static SessionFactory ourSessionFactory;
    private static ServiceRegistry serviceRegistry;


    private HbFactory() {

    }

    public static HbFactory getInstance() {
        if(factory == null) {
            try {
                factory = new HbFactory();
                Configuration configuration = new Configuration();
                configuration.configure();
                serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
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
