package com.yongren;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/getValidCode")
public class ValidCode extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // a. create a img
        int width = 120;
        int height = 50;
        BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);


        // b. decorate
        Graphics g = buffImg.getGraphics();
        g.setColor(Color.lightGray);
        g.fillRect(0, 0, buffImg.getWidth(), buffImg.getHeight());

        g.setColor(Color.red);
        g.drawRect(0,0,buffImg.getWidth() - 1, buffImg.getHeight() - 1);

        g.setColor(Color.cyan);
        for (int i = 0; i < 6; i++) {
            Random ran = new Random();
            int a = ran.nextInt(buffImg.getWidth() + 10);
            int b = ran.nextInt(buffImg.getHeight() + 8);
            int c = ran.nextInt(buffImg.getWidth() - 8);
            int d = ran.nextInt(buffImg.getWidth() - 8);
            g.drawLine(a,b,c,d);
        }

        g.setColor(Color.BLUE);
        StringBuffer buff = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            String str = this.randomStr();
            buff.append(str);
            g.drawString(str, 25 + 20 * i, 30);
        }

        req.getSession().setAttribute("YR_CODE", buff.toString());
        System.out.println(" ~> [W] session code : " + buff.toString());

        // c. output
        if(ImageIO.write(buffImg, "jpg", resp.getOutputStream())) {
            System.out.println("image rander done !");
        }

    }

    private String randomStr() {
        int min = 64;
        int max = 90;
        int r = min + (int)(Math.random() * ((max - min) + 1));
        char ch = (char)r;
        return Character.toString(ch);
    }
}
