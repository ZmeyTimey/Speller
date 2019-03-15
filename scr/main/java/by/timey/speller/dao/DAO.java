package by.timey.speller.dao;

import java.util.List;

public interface DAO<E, I extends Number> {

  void create(E entity);
  List<E> readAll();
  E readById(I id);
  void update(E entity);
  void delete(E entity);
}
