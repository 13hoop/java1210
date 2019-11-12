package yr.jstl.dao;

import yr.jstl.util.User;

public interface UserDao extends Dao{
    User findUser(String name, String password);
}
