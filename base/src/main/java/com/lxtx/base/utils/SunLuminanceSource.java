package com.lxtx.base.utils;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import com.google.zxing.LuminanceSource;
import org.apache.commons.lang3.ArrayUtils;


/**
 * @author jackson
 */
public class SunLuminanceSource extends LuminanceSource {
    /** 二维码缓冲区图像对象 */
    private BufferedImage image = null;
    /** 二维码图像Y轴起始坐标 */
    private int top = 0;
    /** 二维码图像X轴起始坐标 */
    private int left = 0;

    /**
     * 二维码图像资源类构造方法
     * @param image 二维码缓冲区图像对象
     */
    public SunLuminanceSource(BufferedImage image) {

        // 调用构造方法
        this(image, 0, 0, image.getWidth(), image.getHeight());
    }

    /**
     * 二维码图像资源类构造方法
     * @param image 二维码缓冲区图像对象
     * @param top 二维码图像Y轴起始坐标
     * @param left 二维码图像X轴起始坐标
     * @param width 二维码图像宽度
     * @param height 二维码图像高度
     */
    public SunLuminanceSource(BufferedImage image, int top, int left, int width, int height) {

        // 初始化父类构造方法
        super(width, height);

        // 声明剪裁的二维码图像宽度
        int cropWidth = left + width;
        // 声明剪裁的二维码图像高度
        int cropHeight = top + height;

        // 循环处理所有Y轴坐标像素
        for (int y = top; y < cropHeight; y++) {

            // 循环处理所有X轴坐标像素
            for (int x = left; x < cropWidth; x++) {

                // 如果二维码图像像素点为白色
                if ((image.getRGB(x, y) & CommonConstants.QR_CODE_LOW_LIGHT_COLOR) == 0x0) {

                    // 设置二维码图像为白色
                    image.setRGB(x, y, CommonConstants.QR_CODE_HIGH_LIGHT_COLOR);
                }
            }
        }

        // 设置二维码缓冲区图像对象
        this.image = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        // 重画二维码缓冲区图像对象
        this.image.getGraphics().drawImage(image, 0, 0, null);
        // 设置二维码图像Y轴起始坐标
        this.top = top;
        // 设置二维码图像X轴起始坐标
        this.left = left;
    }

    /**
     * 取得二维码图像矩阵数据
     * @return 二维码图像矩阵数据
     */
    @Override
    public byte[] getMatrix() {

        // 取得二维码图像宽度
        int width = getWidth();
        // 取得二维码图像高度
        int height = getHeight();
        // 计算二维码图像区域
        int area = width * height;
        // 创建二维码矩阵数据数组
        byte[] matrix = new byte[area];

        // 取得图像数据
        image.getRaster().getDataElements(left, top, width, height, matrix);

        // 返回二维码图像矩阵数据
        return matrix;
    }

    /**
     * 取得二维码图像每一行的数据
     * @param y 二维码图像Y轴坐标
     * @param row 二维码图像行数据
     */
    @Override
    public byte[] getRow(int y, byte[] row) {

        // 取得二维码图像宽度
        int width = getWidth();

        // 如果行数据为空或者行数据小于二维码宽度
        if (ArrayUtils.isEmpty(row) || row.length < width) {

            // 创建二维码行数据数组
            row = new byte[width];
        }

        // 取得图像数据
        image.getRaster().getDataElements(left, top + y, width, 1, row);

        // 返回二维码图像行数据
        return row;
    }

    /**
     * 判断二维码图像是否支持剪裁
     * @return 判断结果（TRUE：二维码图像支持剪裁；FALSE：二维码图像不支持剪裁）
     */
    @Override
    public boolean isCropSupported() {

        // 返回TRUE
        return true;
    }

    /**
     * 剪裁二维码图像
     * @param top 二维码图像Y轴起始坐标
     * @param left 二维码图像X轴起始坐标
     * @param width 二维码图像宽度
     * @param height 二维码图像高度
     */
    @Override
    public SunLuminanceSource crop(int top, int left, int width, int height) {

        // 返回剪裁后的二维码图像
        return new SunLuminanceSource(image, this.top + top, this.left + left, width, height);
    }

    /**
     * 判断二维码图像是否支持旋转
     * @return 判断结果（TRUE：二维码图像支持旋转；FALSE：二维码图像不支持旋转）
     */
    @Override
    public boolean isRotateSupported() {

        // 返回TRUE
        return true;
    }

    /**
     * 旋转二维码图像
     * @return 旋转后的二维码图像
     */
    @Override
    public SunLuminanceSource rotateCounterClockwise() {

        // 取得二维码图像原始宽度
        int originalWidth = image.getWidth();
        // 取得二维码图像原始高度
        int originalHeight = image.getHeight();

        // 创建变形工具对象
        AffineTransform transform = new AffineTransform(0.0, -1.0, 1.0, 0.0, 0.0, originalWidth);
        // 创建旋转后的二维码图像
        BufferedImage rotatedImage = new BufferedImage(originalHeight, originalWidth, BufferedImage.TYPE_BYTE_GRAY);

        // 取得旋转后的二维码图像二维图像模型
        Graphics2D g = rotatedImage.createGraphics();
        // 重画二维码图像
        g.drawImage(image, transform, null);
        // 释放二维码图像资源
        g.dispose();

        // 取得二维码图像宽度
        int width = getWidth();

        // 返回旋转后的二维码图像
        return new SunLuminanceSource(rotatedImage, top, originalWidth - (left + width), getHeight(), width);
    }
}
