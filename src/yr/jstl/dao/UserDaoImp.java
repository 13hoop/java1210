package yr.jstl.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import yr.jstl.util.JDBCUtils;
import yr.jstl.util.User;
import yr.jstl.util.YRJDBCTools;

import java.util.List;

public class UserDaoImp implements UserDao {

    private JdbcTemplate template = new JdbcTemplate(YRJDBCTools.getDataSource());
    @Override
    public List findAll() {

        String sql = "select * from user";
        List<User> list = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return list;
    }
}
