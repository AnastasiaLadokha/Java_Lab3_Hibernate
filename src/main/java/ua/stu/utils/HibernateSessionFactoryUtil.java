package ua.stu.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import ua.stu.entity.*;

import java.util.Properties;

public class HibernateSessionFactoryUtil {

    private static SessionFactory sessionFactory;
    private static PropertiesReader propertiesReader;

    public HibernateSessionFactoryUtil(PropertiesReader propertiesReader) {
        this.propertiesReader = propertiesReader;
    }

    private HibernateSessionFactoryUtil() {

    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                Properties settings = new PropertiesReader().getProperties("src/main/resources/db.properties");
                settings.put(Environment.DRIVER, settings.getProperty("db.driver"));
                settings.put(Environment.URL, settings.getProperty("db.url"));
                settings.put(Environment.USER, settings.getProperty("db.username"));
                settings.put(Environment.PASS, settings.getProperty("db.password"));
                settings.put(Environment.DIALECT, settings.getProperty("db.dialect"));
                settings.put(Environment.SHOW_SQL, "true");

                configuration.setProperties(settings);

                configuration.addAnnotatedClass(Card.class);
                configuration.addAnnotatedClass(Department.class);
                configuration.addAnnotatedClass(Disease.class);
                configuration.addAnnotatedClass(Doctor.class);
                configuration.addAnnotatedClass(Patient.class);

                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                        applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
