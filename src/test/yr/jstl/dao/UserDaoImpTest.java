package test.yr.jstl.dao; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import yr.jstl.dao.UserDaoImp;

import java.util.List;

import yr.jstl.util.User;
/**
* UserDaoImp Tester. 
* 
* @author <Authors name> 
* @since <pre>Nov 11, 2019</pre> 
* @version 1.0 
*/ 
public class UserDaoImpTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: findAll() 
* 
*/ 
@Test
public void testFindAll() throws Exception { 
//TODO: Test goes here... 
    UserDaoImp dao = new UserDaoImp();
    List<User> list = dao.findAll();
    for (User u: list) {
        System.out.println(u.toString());
    }

}

} 
