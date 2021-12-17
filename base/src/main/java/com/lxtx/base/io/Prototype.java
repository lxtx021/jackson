package com.lxtx.base.io;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
/**
 * @author 孙洪波
 * @version 1.0
 * @description:
 * @date 2020/12/29 9:16
 */


public class Prototype {
    public static void main(String[] args) {

        String content = "民航局航安办信息处-王爽";
        Font font = new Font("SimHei", Font.BOLD, 18);


        BufferedImage image = new BufferedImage(1, 1, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D graphics = image.createGraphics();
        graphics.setFont(font);
        int length = graphics.getFontMetrics().stringWidth(content);
        graphics.dispose();

        int width = (int) Math.sqrt(Math.pow(length, 2)) + 60;
//		int height = (int) Math.sqrt(Math.pow(length, 2)) + 20;
        int height = 128;


        image = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
        graphics = image.createGraphics();
        graphics.setFont(font);
        graphics.rotate(Math.toRadians(15), width / 2, height / 2);
        graphics.setBackground(new Color(255, 255, 255, 0));
        graphics.setColor(Color.LIGHT_GRAY);
//		graphics.drawRect(0, 0, width - 1, height - 1);
//		graphics.drawLine(width / 2, 0, width / 2, height);
//		graphics.drawLine(0, height / 4, width, height / 4);
//		graphics.drawLine(0, height / 2, width, height / 2);
//		graphics.drawLine(0, (height / 4) * 3, width, (height / 4) * 3);
        graphics.drawString(content, (width - length) / 2, ((height - font.getSize()) / 2) + 16);
//
//		int baseline = (int) Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));
//
//		System.out.println("Content Length: " + baseline);
//
//		graphics.drawString(content, (width - length) / 2, 6);
//		graphics.drawString(content, (width - length) / 2, height + 6);
//
//		graphics.drawString(content, 0 - (length / 2), ((height / 4) - 10) + 16);
//		graphics.drawString(content, (width / 2) + 10, ((height / 4) - 10) + 16);
//		graphics.drawString(content, 0 - (length / 2), ((height / 4) * 3 - 10) + 16);
//		graphics.drawString(content, (width / 2) + 10, ((height / 4) * 3 - 10) + 16);




        try {
            ImageIO.write(image, "png", new File("D:/usr/test.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
