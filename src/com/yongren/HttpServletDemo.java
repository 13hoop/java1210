package com.yongren;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/login"})
public class HttpServletDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println(" ~~> doGet methord when login ");

        req.setCharacterEncoding("utf-8");
//        Map param = req.getParameterMap();

        String name = req.getParameter("name");
        String  pwd = req.getParameter("password");
        String code = req.getParameter("validCode");

        String codeInSession = (String) req.getSession().getAttribute("YR_CODE");
        System.out.println("--> " + name + " " + pwd + " " + code);
        System.out.println(" ~> [R] session code : " + code);

        if(codeInSession.equalsIgnoreCase(code)) {
            if(name.equals("111") && pwd.equals("222")) {
                req.getSession().setAttribute("msg", "~~ 登录成功！~~");

                req.getSession().setAttribute("YR_USER", name);

                // 结果重定向
                resp.sendRedirect(req.getContextPath() + "/success.jsp");

            }else {
                System.out.println(" --> fail pwd&name here");
                req.setAttribute("msg", "用户名或密码不匹配");
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            }
        }else  {
            System.out.println(" --> fail code here");
            req.setAttribute("msg", "验证码错误");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
