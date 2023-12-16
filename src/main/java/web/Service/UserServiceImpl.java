package web.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.DAO.UserDAO;
import web.model.User;

import java.util.List;
@Service

public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional(readOnly = true)
    public List<User> getAll() {
        return userDAO.getAll();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
    userDAO.saveUser(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(long id) {
        return userDAO.getUserById(id);
    }

    @Override
    @Transactional
    public void deleteUser(long id) {
        userDAO.deleteUser(id);
    }
}