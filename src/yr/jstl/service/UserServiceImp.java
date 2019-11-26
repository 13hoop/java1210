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

//        for (User obj : list) {
//            System.out.println(" [UserServiceImp] >> " + obj.toString());
//        }
        return list;
    }

    @Override
    public User login(User user) {
        User u = uDao.findUser(user.getName(), user.getPassword());
        return u;
    }

    @Override
    public Boolean add(User user) {
        return  uDao.add(user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail());
    }

    @Override
    public Boolean update(User user) {
        return uDao.update(user);
    }

    @Override
    public Boolean delete(String id) {
        return uDao.delete(Integer.parseInt(id));
    }

    @Override
    public Boolean deleteSeries(String[] idArr) {
        return uDao.deleteSeries(idArr);
    }

    @Override
    public User queryUser(String id) {
        User user = null;
        user = uDao.findUser(id);
        return user;
    }
}
