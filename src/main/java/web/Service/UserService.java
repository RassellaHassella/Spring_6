package web.Service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    void saveUser(User user);
}
