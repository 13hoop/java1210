package yr.JDBC;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.*;

public class BookDaoWithDM {

    private final String url;
    private final String username;
    private final String password;
    private final String drivename;

    public BookDaoWithDM(String url, String username, String password, String drivename) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.drivename = drivename;
    }

    public Book findBookByISBN(int isbn) {
        Book book = null;
        Statement statement = null;
        Connection connection = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            String sql = "select * from yrbook where isbn=" + isbn + ";";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Book temp = new Book();
                temp.setIsbn(resultSet.getInt("isbn"));
                temp.setName(resultSet.getString("name"));
                temp.setPrice(resultSet.getFloat("price"));
                temp.setAuthor(resultSet.getString("auther"));
                System.out.println(temp.toString());
            }

        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return book;
    }

    private Connection getConnection() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, username, password);
    }

    private Connection getConnectionNewWay() throws SQLException {
        ComboPooledDataSource db = new ComboPooledDataSource();
        db.setJdbcUrl(url);
        db.setCheckoutTimeout(3000);
        db.setUser(username);
        db.setPassword(password);
        db.setMaxPoolSize(40);
        db.setMinPoolSize(2);
        db.setMaxStatements(120);
        return db.getConnection();
    }

    private String getQuerySqlFor(int isbn) {
        return "select * from book where isbn = " + isbn + ";";
    }

    private void infoFun() {
        System.out.println(" >> here is inner infoFun ...");
    }
}
