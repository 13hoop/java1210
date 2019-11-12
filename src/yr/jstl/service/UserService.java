package yr.jstl.service;

import yr.jstl.util.User;

import java.util.List;

public interface UserService {
    List<User> queryAll();

    User login(User user);

}
