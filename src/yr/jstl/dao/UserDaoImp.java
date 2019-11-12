package yr.jstl.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import yr.jstl.util.User;
import yr.jstl.util.YRJDBCTools;

import java.util.List;

public class UserDaoImp implements UserDao {

    private JdbcTemplate template = new JdbcTemplate(YRJDBCTools.getDataSource());
    @Override
    public List findAll() {

        String sql = "select * from user";
        List<User> list = template.query(sql, new BeanPropertyRowMapper<>(User.class));

        for (User obj : list) {
            System.out.println("  [UserDaoImp] >> " + obj.toString());
        }
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
}
