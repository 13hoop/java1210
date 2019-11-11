package com.yongren;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 *  设置cookie等涉及到不同端交互，一个必须考虑的问题就是 编码
 *  否则就会得到 500
 *
 */

@WebServlet(urlPatterns = {"/cookieDemo"})
public class CookieSessionDemo1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");
        System.out.println(" ----> " + req.getRequestURL());

        Cookie[] arrs = req.getCookies();
        if (arrs != null & arrs.length > 0) {

            for (Cookie cookie : arrs) {
                String key = cookie.getName();
                System.out.println(" ----> " + key);
                if ("lastTime".equals(key)) {
                    String val = cookie.getValue();

                    cookie.setValue(this.getDateStringNow());
                    cookie.setMaxAge(5);
                    resp.getWriter().write("<h3>lastTime arrive at + " + URLDecoder.decode(val, "utf-8") + "</h3>");

                }else  {

                    Cookie newCookie = new Cookie("lastTime", this.getDateStringNow());
                    newCookie.setPath("/");
                    newCookie.setMaxAge(5);
                    newCookie.setSecure(false);
                    resp.addCookie(newCookie);
                    resp.getWriter().write("<h4>first arrive here! 002</h4>");

                }
            }
        }else  {
            Cookie newCookie = new Cookie("lastTime", this.getDateStringNow());
            newCookie.setMaxAge(15);
            newCookie.setPath("/");
            newCookie.setSecure(false);
            resp.addCookie(newCookie);
            resp.getWriter().write("<h6>first arrive here! 004</h6>");
            System.out.println(" ----> 004 ");
        }

    }

    private String getDateStringNow() {
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        String str = format.format(now);
        System.out.println(" --[now]--> " + str);
        try {
            str = URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
