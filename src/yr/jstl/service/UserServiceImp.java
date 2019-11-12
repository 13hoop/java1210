package yr.jstl.service;

import yr.jstl.dao.UserDao;
import yr.jstl.dao.UserDaoImp;
import yr.jstl.util.User;

import java.util.List;

public class UserServiceImp implements UserService{

    private UserDao uDao = new UserDaoImp();
    @Override
    public List<User> queryAll() {
        List<User> list = uDao.findAll();

        for (User obj : list) {
            System.out.println(" [UserServiceImp] >> " + obj.toString());
        }
        return list;
    }

    @Override
    public User login(User user) {
        User u = uDao.findUser(user.getName(), user.getPassword());
        return u;
    }


}