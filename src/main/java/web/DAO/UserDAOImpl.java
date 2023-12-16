package web.DAO;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
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

    @Override
    public void saveUser(User user) {
        entityManager.merge(user);
    }

    //Получение данного пользователя по id

    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUser(long id) {
        User user = getUserById(id);
        entityManager.remove(user);
    }

}
