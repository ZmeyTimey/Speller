package by.timey.speller.dao.impl;

import by.timey.speller.dao.AbstractDAO;
import by.timey.speller.model.WordTranslation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;


public class DictionaryDAO extends AbstractDAO<WordTranslation, Long> {

  private static final String READ_ALL_QUERY = "SELECT a FROM dictionary a";

  public DictionaryDAO() {
    super(WordTranslation.class);
  }

  public List<WordTranslation> readAll() {
    try (Session session = sessionFactory.openSession()) {
      return session.createQuery(READ_ALL_QUERY, entityClass).getResultList();
    }
  }
}
