package by.timey.speller.dao;

import by.timey.speller.dao.DAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.NoResultException;
import java.util.List;


public abstract class AbstractDAO<E, I extends Number> implements DAO<E, I> {

  protected final SessionFactory sessionFactory;
  protected Class<E> entityClass;

  public AbstractDAO(SessionFactory sessionFactory,
                     Class<E> entityClass) {
    this.sessionFactory = sessionFactory;
    this.entityClass = entityClass;
  }

  public void create(E entity) {

    try (Session session = sessionFactory.openSession()) {
      session.beginTransaction();
      session.save(entity);
      session.getTransaction().commit();
    }
  }

  public abstract List<E> readAll();

  public E readById(I id) {
    E result;

    try (Session session = sessionFactory.openSession()) {
      result = session.get(entityClass, id);
    }

    if (result != null) {
      return result;
    } else {
      throw new NoResultException();
    }
  }

  public void update(E entity) {

    try (Session session = sessionFactory.openSession()) {
      session.beginTransaction();
      session.update(entity);
      session.getTransaction().commit();
    }
  }

  public void delete(E entity) {

    try (Session session = sessionFactory.openSession()) {
      session.beginTransaction();
      session.delete(entity);
      session.getTransaction().commit();
    }
  }
}
