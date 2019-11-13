package yr.jstl.Domian;

import yr.jstl.service.UserService;
import yr.jstl.service.UserServiceImp;
import yr.jstl.util.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns={"/querylist"})
public class UserListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserService service = new UserServiceImp();
        List<User> list = service.queryAll();

//        User u1 = new User(1, "KOBE", "男", 42, "LA-US", "248222", "kobe@24.com");
//        User u2 = new User(2, "LBJ", "男", 42, "LA-US", "248222", "kobe@24.com");
//        User u3 = new User(3, "KWJI", "男", 42, "LA-US", "248222", "kobe@24.com");
//        User u4 = new User(4, "BP", "男", 42, "LA-US", "248222", "kobe@24.com");
//        List<User> list = new ArrayList<User>(){{
//            add(u1);
//            add(u2);
//            add(u3);
//            add(u4);
//        }};


//        for (User obj : list) {
//            System.out.println(" [UserListServlet] >> " + obj.toString());
//        }
        req.setAttribute("list", list);
        req.getRequestDispatcher("/yrlist.jsp").forward(req, resp);
    }
}
