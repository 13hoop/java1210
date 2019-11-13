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
import java.lang.reflect.InvocationTargetException;

import static org.apache.commons.beanutils.BeanUtils.*;

@WebServlet("/addUserServlet")
public class UserAddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        User user = new User();
        try {
            populate(user, req.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        UserService service = new UserServiceImp();
        System.out.println("  [UserAddServlet.doPost] >> " + user.toString());
        if(service.add(user)) {
            resp.sendRedirect(req.getContextPath() + "/querylist");
        }else {

        }

    }
}
