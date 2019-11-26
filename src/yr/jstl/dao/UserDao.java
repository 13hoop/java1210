package yr.jstl.dao;

import yr.jstl.util.User;

public interface UserDao extends Dao{
    User findUser(String name, String password);
    User findUser(String id);
    Boolean add(String name, String gender, int age, String address, String qq, String email);
    Boolean delete(Integer id);
    Boolean deleteSeries(String[] idArr);
    Boolean update(User user);
}
