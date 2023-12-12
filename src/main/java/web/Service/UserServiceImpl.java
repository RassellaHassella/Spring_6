package web.Service;

import web.DAO.UserDAO;
import web.DAO.UserDAOImpl;
import web.model.User;

public class UserServiceImpl implements UserService{
    private final UserDAO userDAO = new UserDAOImpl();
    @Override
    public void add(){
        userDAO.add();
    }


}
