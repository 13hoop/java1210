package yr.jstl.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import yr.jstl.util.PageBean;
import yr.jstl.util.User;
import yr.jstl.util.YRJDBCTools;

import java.util.List;

public class UserDaoImp implements UserDao {

    private JdbcTemplate template = new JdbcTemplate(YRJDBCTools.getDataSource());
    @Override
    public List findAll() {

        String sql = "select * from user";
        List<User> list = template.query(sql, new BeanPropertyRowMapper<>(User.class));

//        for (User obj : list) {
//            System.out.println("  [UserDaoImp] >> " + obj.toString());
//        }
        return list;
    }

    @Override
    public User findUser(String name, String password) {

        String sql = "select * from user where name = ? and password = ?";
        System.out.println(sql + " " + name + " " + password);
        User u = null;

        /**
         *  这里要是不 catch 的化，错误时会报错"org.springframework.dao.EmptyResultDataAccessException: Incorrect result size: expected 1, actual 0"到页面
         *  不清楚是 springframework包的特有问题，还是其他的 ???
         * */
        try {
//            template.queryForObject
            u = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), name, password);
            System.out.println("  [UserDaoImp.findUser] >> SQL: " + sql + "\n result: " + u.toString());
            return u;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User findUser(String id) {
        String sql = "select * from user where id = ?";
        System.out.println(sql + " ---> " + id);
        User u = null;

        try {
            u = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
            System.out.println("  [UserDaoImp.findUser] >> SQL: " + sql + "\n result: " + u.toString());
            return u;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Boolean add(String name, String gender, int age, String address, String qq, String email) {

        String sql = "insert into user VALUES (null, ?, ?, ?, ?, ?, ?, null);";
        int r = 0;

        System.out.println("  [UserDaoImp.add] sql >> " + sql);

        try {
             r = template.update(sql, name, gender, age, address, qq, email);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return r > 0;
    }

    @Override
    public Boolean update(User user) {
        String sql = "update user set name = ?, gender = ?, age = ?, address = ?, qq = ?, email = ? where id = ?";
        int r = 0;
        System.out.println("  [UserDaoImp.add] sql >> " + sql + " \n >> " + user.toString());

        try {
            r = template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail(), user.getId());
        }catch (Exception e) {
            e.printStackTrace();
        }

        return r > 0;
    }

    @Override
    public Boolean delete(Integer id) {
        int r = 0;
        String sql = "delete from user where id = ?";

        System.out.println("  [UserDaoImp.delete] sql >> " + sql);

        try{
            r = template.update(sql, id);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return r > 0;
    }

    @Override
    public Boolean deleteSeries(String[] idArr) {

        Boolean r = idArr.length > 0;
        for (String id: idArr) {
            String sql = "delete from user where id = ?";

            System.out.println("  [UserDaoImp.delete] sql >> " + sql);

            try{
                int rr = template.update(sql, id);
                r = rr > 0 && r;
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return r;
    }

    @Override
    public List<User> findUsers(int start, int end) {
        String sql = "select * from user limit ?, ?";
        System.out.println("  [UserDaoImp.findUsers] sql >> " + sql + " ( " + start + " " + end + " ) ");
        List<User> list = template.query(sql, new BeanPropertyRowMapper<>(User.class), start, end);
        return list;
    }

    @Override
    public int count() {
        String sql = "select count(*) from user";
        System.out.println("  [UserDaoImp.count] sql >> " + sql);
        return template.queryForObject(sql, Integer.class); // 自动拆箱
    }
}
