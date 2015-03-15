package singletones;


import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

public class SingleTone {
    Configuration conf;

    public static  SingleTone getInstance() {
        Configuration conf = new Configuration().configure("/hibernate.cfg.xml");
        ServiceRegistryBuilder builder = new ServiceRegistryBuilder();


        return null;
    }

    }

