package yr.jstl.service;

import yr.jstl.util.PageBean;
import yr.jstl.util.User;

import java.util.List;

public interface UserService {

    User login(User user);

    List<User> queryAll();
    User queryUser(String id);

    PageBean queryByPage(int page);

    Boolean update(User user);
    Boolean add(User user);
    Boolean delete(String id);
    Boolean deleteSeries(String[] idArr);
}
