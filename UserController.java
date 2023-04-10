package controller;

import java.util.List;

import dao.UserDAO;
import dto.User;

public class UserController {
    private UserDAO userDao;

    public UserController() {
        userDao = new UserDAO();
    }

    public void insert(User user) throws Exception {
        userDao.insert(user);
    }

    public List<User> getUserList() {
        return userDao.getUserList();
    }

    public void delete(int id) {
        userDao.delete(id);
    }

    public void update(User user) {
        userDao.update(user);
    }

    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    public User getUserByIdAndPassword(int id, String password) {
        return userDao.getUserByIdAndPassword(id, password);
    }
}
