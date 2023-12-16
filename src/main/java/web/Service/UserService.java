package web.Service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    void saveUser(User user);
    User getUserById(long id);

    void deleteUser(long id);
}
