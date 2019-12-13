package yr.jstl.Domian;

import yr.jstl.service.UserService;
import yr.jstl.service.UserServiceImp;
import yr.jstl.util.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/queryUserPage")
public class UserPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageStr = req.getParameter("page");
        int p = Integer.parseInt(pageStr);
        if (p <= 1) {
            p = 1;
        }

        UserService service = new UserServiceImp();
        PageBean data = service.queryByPage(p);
        req.setAttribute("pData", data);

        System.out.println(" >>> " + data.toString());

        req.getRequestDispatcher("/yrListPage.jsp").forward(req, resp);
    }
}
