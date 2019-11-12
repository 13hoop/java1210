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
}
