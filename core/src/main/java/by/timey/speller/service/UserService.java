package by.timey.speller.service;

import by.timey.speller.dao.impl.UserDAO;
import by.timey.speller.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private UserDAO userDAO = new UserDAO();

  public void addUser(User user) {
    userDAO.create(user);
  }

  public User getUser(int id) {
    return userDAO.readById(id);
  }
}
