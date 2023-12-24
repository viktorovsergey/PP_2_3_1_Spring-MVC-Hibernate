package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {


    List<User> getAllUsers();
    public  User show (long id);
    public void create  (User user);
    public void update (User user);
    public void delUser(long id);
}
