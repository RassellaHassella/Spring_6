package web.DAO;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.Car;
import web.model.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
public class UserDAOImpl implements UserDAO{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Car> getAll(){
        List<Car> listCar = entityManager.createQuery("select c from Car c", Car.class).getResultList();
        return listCar;
    }


    @Override
    @Transactional
    public void add(){
//        entityManager.persist();
    }
    @Override
    @Transactional
    public void delete(User user){

//        entityManager.remove(user);
    }

    @Override
    @Transactional
    public void update(User user){

//        entityManager.merge(user);
    }

}
