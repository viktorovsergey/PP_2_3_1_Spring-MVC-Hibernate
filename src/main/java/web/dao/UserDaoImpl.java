package web.dao;


import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{
    List<User> usersList = new ArrayList<>();

    public UserDaoImpl (){
        usersList.add(new User(1,"Ivanov","Ivan",26));
        usersList.add(new User(2,"Petrov","Petr",36));
        usersList.add(new User(3,"Sidorov","Ivan",16));
    }


    @Override
    public List<User> usersList() {
        return usersList;
    }

    @Override
    public User show(long id) {
        return usersList.stream().filter(user -> user.getId()==id).findAny().orElse(null);
    }


}
