package yr.jstl.service;

import yr.jstl.util.User;

import java.util.List;

public interface UserService {

    User login(User user);

    List<User> queryAll();
    User queryUser(String id);

    Boolean add(User user);
    Boolean delete(String id);
}
