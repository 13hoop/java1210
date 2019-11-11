package yr.jstl.service;

import yr.jstl.dao.UserDao;
import yr.jstl.dao.UserDaoImp;
import yr.jstl.util.User;

import java.util.List;

public class UserServiceImp implements UserService{

    private UserDao uDao = new UserDaoImp();
    @Override
    public List<User> queryAll() {
        List list = uDao.findAll();
        return list;
    }
}
