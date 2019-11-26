package yr.jstl.Domian;

import yr.jstl.service.UserService;
import yr.jstl.service.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteSeriesServlet")
public class UserDeleteSerialServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String[] idArr = req.getParameterValues("item");

        System.out.println(" >>> [deleteSeriesServlet] " + idArr.toString());

        UserService service = new UserServiceImp();
        if(service.deleteSeries(idArr)) {
            resp.sendRedirect(req.getContextPath() + "/querylist");
        }else  {

        }
    }
}