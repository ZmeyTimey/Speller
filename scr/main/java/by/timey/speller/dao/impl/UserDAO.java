package by.timey.speller.dao.impl;

import by.timey.speller.dao.AbstractDAO;
import by.timey.speller.model.User;
import by.timey.speller.model.WordTranslation;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Set;


public class UserDAO extends AbstractDAO<User, Integer> {

  private static final String READ_ALL_QUERY = "SELECT a FROM \"user\" a";

  public UserDAO() {
    super(User.class);
  }

  public List<User> readAll() {
    try (Session session = sessionFactory.openSession()) {
      return session.createQuery(READ_ALL_QUERY, entityClass).getResultList();
    }
  }

  public void addUserWord(int userId, WordTranslation wordTranslation) {

    try (Session session = sessionFactory.openSession()) {

      session.beginTransaction();
      User user = session.get(entityClass, userId);

      Hibernate.initialize(user.getUserWords());
      Set<WordTranslation> userWords = user.getUserWords();

      userWords.add(wordTranslation);
      session.update(user);

      session.getTransaction().commit();
    }
  }

  public void deleteUserWord(int userId, WordTranslation wordTranslation) {

    try (Session session = sessionFactory.openSession()) {

      session.beginTransaction();
      User user = session.get(entityClass, userId);

      Hibernate.initialize(user.getUserWords());
      Set<WordTranslation> userWords = user.getUserWords();

      userWords.remove(wordTranslation);
      session.update(user);

      session.getTransaction().commit();
    }
  }
}
