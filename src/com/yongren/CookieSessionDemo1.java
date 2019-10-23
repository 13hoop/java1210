package com.yongren;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(urlPatterns = {"cookieDemo"})
public class CookieSessionDemo1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");

        Cookie[] arrs = req.getCookies();
        if (arrs != null & arrs.length > 0) {
            for (Cookie cookie : arrs) {
                String key = cookie.getName();
                if ("lastTime".equals(key)) {
                    String val = cookie.getValue();
                    resp.getWriter().write("<h6>lastTime arrive at + " + val + "</h6>");

                    cookie.setValue(this.getDateStringNow());
                }else  {
                    resp.getWriter().write("<h6>first arrive here!</h6>");
                    Cookie newCookie = new Cookie("lastTime", this.getDateStringNow());
                    resp.addCookie(newCookie);
                }
            }
        }else  {
            resp.getWriter().write("<h6>first arrive here!</h6>");
            Cookie newCookie = new Cookie("lastTime", this.getDateStringNow());
            resp.addCookie(newCookie);
        }

    }

    private String getDateStringNow() {
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        return format.format(now);
    }
}
