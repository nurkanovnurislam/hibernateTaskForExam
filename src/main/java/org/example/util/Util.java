package org.example.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class Util {

    public static SessionFactory getSessionFactory() {
        Properties p = new Properties();
        p.put(Environment.DRIVER,"org.postgresql.Driver");
        p.put(Environment.URL,"jdbc:postgresql://localhost:5432/postgres");
        p.put(Environment.USER,"nurislamnurkanov");
        p.put(Environment.PASS,"");
        p.put(Environment.SHOW_SQL,"true");
        p.put(Environment.HBM2DDL_AUTO,"create");
        p.put(Environment.DIALECT,"org.hibernate.dialect.PostgreSQL9Dialect");

        Configuration c = new Configuration();
        c.addProperties(p);

        return c.buildSessionFactory();
    }
    public static EntityManager getConnection() {
        return Persistence.createEntityManagerFactory("org.example").createEntityManager();
    }
}
