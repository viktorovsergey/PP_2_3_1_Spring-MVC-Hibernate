package web.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    public UserDaoImpl() {
    }
    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public User show(long id) {
        return entityManager.find(User.class,id);
    }

    @Override
    public void create (User user) {
        entityManager.persist(user);
    }


    @Override
    public void update(long id, User updateUser) {
        User user = entityManager.find(User.class,id);
        if (user!=null){
            user.setLastName(updateUser.getLastName());
            user.setFirstName(updateUser.getFirstName());
            user.setEmail(updateUser.getEmail());
            entityManager.merge(user);
        }

    }

    @Override
    public void delUser(long id) {
        entityManager.remove(entityManager.find(User.class,id));
    }

}
