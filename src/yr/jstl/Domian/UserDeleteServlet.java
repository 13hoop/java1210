package yr.jstl.Domian;

import yr.jstl.service.UserService;
import yr.jstl.service.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/deleteServlet")
public class UserDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String u_id = req.getParameter("id");

        UserService service = new UserServiceImp();
        if(service.delete(u_id)) {
            resp.sendRedirect(req.getContextPath() + "/querylist");
        }else  {

        }
    }
}
