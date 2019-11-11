package yr.jstl.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class YRJDBCTools {


    String pass = "k9881x05";
    String user = "root";
    String url = "jdbc:mysql://127.0.0.1:3306/db18?useSSL=false&serverTimezone=GMT%2B8";
//    private String driveName = "com.mysql.cj.jdbc.Driver";

    private static DataSource dataSource;

    static {

        String pass = "k9881x05";
        String user = "root";
        String url = "jdbc:mysql://127.0.0.1:3306/db18?useSSL=false&serverTimezone=GMT%2B8";

        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setMinPoolSize(2);
        ds.setMaxStatements(180);
        ds.setUser(user);
        ds.setPassword(pass);
        ds.setJdbcUrl(url);
        dataSource = ds;
    }

    private Connection getConnect() {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setMinPoolSize(2);
        ds.setMaxStatements(180);
        ds.setUser(user);
        ds.setPassword(pass);
        ds.setJdbcUrl(url);
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static DataSource getDataSource() {
        return dataSource;
    }
}
