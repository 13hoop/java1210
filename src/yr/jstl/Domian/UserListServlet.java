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
import java.util.List;

@WebServlet(urlPatterns={"/queryUsreList"})
public class UserListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserService service = new UserServiceImp();
        List<User> list = service.queryAll();
        req.setAttribute("list", list);
        req.getRequestDispatcher("/yrlist.jsp").forward(req, resp);
    }
}
