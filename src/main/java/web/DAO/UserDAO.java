package web.DAO;

import org.springframework.transaction.annotation.Transactional;
import web.model.Car;
import web.model.User;

import java.util.List;

public interface UserDAO {
    @Transactional
    List<Car> getAll();

    @Transactional
    void add ();

    @Transactional
    void delete(User user);

    @Transactional
    void update(User user);
}
