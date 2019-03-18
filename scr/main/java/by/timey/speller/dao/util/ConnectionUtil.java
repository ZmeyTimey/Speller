package by.timey.speller.dao.util;

import by.timey.speller.model.User;
import by.timey.speller.model.WordTranslation;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectionUtil {

  private ConnectionUtil() {}

  public static SessionFactory getFactory() {
    return new Configuration()
        .addPackage("by.timey.speller.model")
        .addAnnotatedClass(WordTranslation.class)
        .addAnnotatedClass(User.class)
        .configure().buildSessionFactory();
  }
}
