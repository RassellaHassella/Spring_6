package web.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.DAO.UserDAO;
import web.model.Car;
import java.util.List;


@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private UserDAO userDAO;
    @Override
    @Transactional
    public List<Car> getAll(){
       return userDAO.getAll();
    }
}
