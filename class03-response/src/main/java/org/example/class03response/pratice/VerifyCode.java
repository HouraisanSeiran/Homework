package org.example.class03response.pratice;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Random;

@WebServlet("/VerifyCode")
public class VerifyCode extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int width = 160;
        int height = 45;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics g = image.getGraphics();

        g.setColor(new Color(255, 255, 255));

        g.fillRect(0, 0, width, height);

        String str = "2333333333333333";

        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int index = random.nextInt(str.length());
            char c = str.charAt(index);

            Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            g.setColor(color);

            Font font = new Font("Dialog", Font.BOLD, 20);
            g.setFont(font);

            g.drawString(String.valueOf(c),width/4,height/2);
        }

        for (int i = 0; i < 10; i++) {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            g.setColor(color);
            g.drawLine(x1, y1, x2, y2);

        }
        ImageIO.write(image, "JPG", resp.getOutputStream());
    }

}
