package yr.jstl.Domian;

import org.apache.commons.beanutils.BeanUtils;
import yr.jstl.dao.UserDao;
import yr.jstl.dao.UserDaoImp;
import yr.jstl.service.UserService;
import yr.jstl.service.UserServiceImp;
import yr.jstl.util.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(urlPatterns = {"/loginServlet"})
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");

        // 验证码检测
        String vcode = req.getParameter("verifycode");
        HttpSession session = req.getSession();
        String sessionCodeStr = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("verifycode");
        if(!sessionCodeStr.equalsIgnoreCase(vcode)) {
            req.setAttribute("login_msg", "验证码不正确");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            return;
        }

//        // 查询user dao
//        UserDao dao = new UserDaoImp();
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//        dao.findUser(username, password);

        User user = new User();
        try {
            BeanUtils.populate(user, req.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        UserService service = new UserServiceImp();
        User r = service.login(user);
        if(r != null) {
            session.setAttribute("user", r);
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
        }else  {
            req.setAttribute("login_msg", "账户名或密码不正确");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
