package com.yongren;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet(urlPatterns = {"/download"})
public class downloadPage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 1 get file name
        String fileName = req.getParameter("name");


        // 2 find file & read
        ServletContext ctx = getServletContext();
        String realPathStr = ctx.getRealPath("/Resources/" + fileName);
        FileInputStream fInput = new FileInputStream(realPathStr);

        // 3 set attachment content type
        String mimeType = ctx.getMimeType(fileName);
        resp.setContentType(mimeType);
        resp.setHeader("content-disposition", "attachment;filename=" + fileName);


        System.out.println(" ~~> " + req.getRequestURL() + " { " + mimeType +" } ==> " + fileName );

        // 4 write file
        ServletOutputStream outPut = resp.getOutputStream();
        byte[] buff = new byte[1024 * 8];
        int length = 0;
        while ((length = fInput.read(buff)) != -1) {
            outPut.write(buff, 0, length);
        }

        fInput.close();
    }
}
