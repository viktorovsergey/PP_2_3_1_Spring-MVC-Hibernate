package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> usersList();
    public User show (long id);
}
