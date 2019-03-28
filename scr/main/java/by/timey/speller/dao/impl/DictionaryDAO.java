package by.timey.speller.dao.impl;

import by.timey.speller.dao.AbstractDAO;
import by.timey.speller.model.WordTranslation;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class DictionaryDAO extends AbstractDAO<WordTranslation, Long> {

  private static final String READ_ALL_QUERY = "SELECT d FROM WordTranslation d ORDER BY RANDOM()";
  private static final String READ_WITH_LIMIT_QUERY
      = "SELECT * FROM dictionary ORDER BY RANDOM() LIMIT ";

  public DictionaryDAO() {
    super(WordTranslation.class);
  }

  public List<WordTranslation> readAll() {
    try (Session session = sessionFactory.openSession()) {
      return session.createQuery(READ_ALL_QUERY, entityClass).getResultList();
    }
  }

  public List<WordTranslation> readWithLimit(int limit) {
    try (Session session = sessionFactory.openSession()) {
      return session.createNativeQuery(
          READ_WITH_LIMIT_QUERY + limit, entityClass).getResultList();
    }
  }
}
