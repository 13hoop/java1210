package yr.jstl.Domian;

import org.apache.commons.beanutils.BeanUtils;
import yr.jstl.service.UserService;
import yr.jstl.service.UserServiceImp;
import yr.jstl.util.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/editServlet")
public class UserUpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        Map map = req.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        }catch (IllegalAccessException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }

        UserService service = new UserServiceImp();
        if(service.update(user)) {
            resp.sendRedirect(req.getContextPath() + "/querylist");
        }else {
            System.out.println("   ------- error -------   ");
        }
    }
}
