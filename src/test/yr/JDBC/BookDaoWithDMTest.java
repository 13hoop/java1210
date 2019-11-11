package test.yr.JDBC; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import yr.JDBC.BookDaoWithDM;

import java.sql.Connection;
import java.sql.DriverManager;

/** 
* BookDaoWithDM Tester. 
* 
* @author <Authors name> 
* @since <pre>Nov 11, 2019</pre> 
* @version 1.0 
*/ 
public class BookDaoWithDMTest {

    private String url = "jdbc:mysql://127.0.0.1:3306/db18?useSSL=false&serverTimezone=UTC";
    private String username = "root";
    private String password = "k9881x05";
    private String drivename = "com.mysql.cj.jdbc.Driver";
    private BookDaoWithDM bookDao;

@Before
public void before() throws Exception {
    System.out.println("  --> " + "before");
}

@After
public void after() throws Exception {
    System.out.println("  --> " + "after");
} 

/** 
* 
* Method: findBookByISBN(int isbn) 
* 
*/ 
@Test
public void testFindBookByISBN() throws Exception { 
//TODO: Test goes here...

    bookDao = new BookDaoWithDM(url, username, password, drivename);
    bookDao.findBookByISBN(1111);
}


/** 
* 
* Method: getConnection() 
* 
*/ 
@Test
public void testGetConnection() throws Exception { 
//TODO: Test goes here...

} 

}
