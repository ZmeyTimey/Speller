package by.timey.speller.service;

import by.timey.speller.dao.impl.DictionaryDAO;
import by.timey.speller.dao.impl.UserDAO;
import by.timey.speller.model.User;
import by.timey.speller.model.WordTranslation;
import org.hibernate.Hibernate;

import java.util.Set;

public class UserDictionaryService {

  private final UserDAO userDAO = new UserDAO();
  private final DictionaryDAO dictionaryDAO = new DictionaryDAO();

  public void addUserWord(int userId, long pairId) {
    WordTranslation wordTranslation = dictionaryDAO.readById(pairId);

    userDAO.addUserWord(userId, wordTranslation);
  }

  public void deleteUserWord(int userId, long pairId) {
    WordTranslation wordTranslation = dictionaryDAO.readById(pairId);

    userDAO.deleteUserWord(userId, wordTranslation);
  }
}
