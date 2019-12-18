package test.test.yr.protocol; 

import junit.framework.Test; 
import junit.framework.TestSuite; 
import junit.framework.TestCase;
import test.yr.protocol.Box;
import test.yr.protocol.Boxer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/** 
* Boxer Tester. 
* 
* @author <Authors name> 
* @since <pre>12/18/2019</pre> 
* @version 1.0 
*/ 
public class BoxerTest extends TestCase { 
public BoxerTest(String name) { 
super(name); 
} 

public void setUp() throws Exception { 
super.setUp(); 
} 

public void tearDown() throws Exception { 
super.tearDown(); 
} 

/** 
* 
* Method: fight() 
* 
*/ 
public void testFight() throws Exception { 

    Boxer ts = new Boxer();

    Box tsAgent = (Box)Proxy.newProxyInstance(ts.getClass().getClassLoader(), ts.getClass().getInterfaces(), new InvocationHandler() {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            if(method.getName().equals("fight")) {
                System.out.println(" training ...");
                System.out.println(" money ...");

                Object obj = method.invoke(ts, args);

                System.out.println("champion!!!");

                return obj;
            }else {
                return method.invoke(proxy, args);
            }
        }
    });

    tsAgent.fight();
    tsAgent.toString();

}




public static Test suite() { 
return new TestSuite(BoxerTest.class); 
} 
} 
