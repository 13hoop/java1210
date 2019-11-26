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

@WebServlet("/queryUserById")
public class UserQueryInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");

        String idStr = req.getParameter("id");
        UserService service = new UserServiceImp();

        User user;
        user = service.queryUser(idStr);
        req.setAttribute("user", user);

        System.out.println(" |~~> " + user.getName());
        req.getRequestDispatcher("/update.jsp").forward(req, resp);
    }
}
