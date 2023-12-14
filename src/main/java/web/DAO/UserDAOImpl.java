package web.DAO;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository

public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;


    @Override

    public List<User> getAll() {
        List<User> listUser = entityManager.createQuery("select u from User u", User.class).getResultList();
        return listUser;
    }

//    @Override
//
//    public void delete(User user){
//
////        entityManager.remove(user);
//    }

    //    @Override
//    public void update(User user){
//
////        entityManager.merge(user);
//    }
//    user.setId(++PEOPLE_COUNT);
    @Override
    public void saveUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

}
