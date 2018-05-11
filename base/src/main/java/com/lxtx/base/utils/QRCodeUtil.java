package com.lxtx.base.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Binarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
/**
 * @author jackson
 */
public class QRCodeUtil {
    /**
     * 生成二维码图片文件
     * @param path 二维码图像文件路径
     * @param content 二维码内容
     * @throws Exception 应用程序异常
     */
    public static void generateQRCode(String path, String content) throws Exception {

        // 生成二维码图片文件
        QRCodeUtil.generateQRCode(path, CommonConstants.QR_CODE_WIDTH, CommonConstants.QR_CODE_HEIGHT, content);
    }

    /**
     * 生成二维码图片文件
     * @param path 二维码图像文件路径
     * @param width 二维码图像文件宽度
     * @param height 二维码文件图像文件高度
     * @param content 二维码内容
     * @throws Exception 应用程序异常
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void generateQRCode(String path, int width, int height, String content) throws Exception {

        // 如果文件路径不为空
        if (StringUtils.isNotBlank(path)) {

            // 取得二维码图像文件的扩展名
            String extension = StringUtils.lowerCase(StringUtils.substringAfterLast(path, "."));
            // 设置生成二维码图像文件参数

            try {

                // 创建二维码提示类型散列表
                Map hints = new HashMap();
                // 设置二维码默认字符集
                hints.put(EncodeHintType.CHARACTER_SET, CommonConstants.DEFAULT_CHAR_CODEC);

                // 对二维码内容进行加密
                BitMatrix bitMatrix = new MultiFormatWriter()
                        .encode(new Base64().encodeToString(content.getBytes(CommonConstants.DEFAULT_CHAR_CODEC)), BarcodeFormat.QR_CODE, width, height, hints);
                // 创建二维码文件对象
                File file = new File(path);

                // 如果二维码文件已经存在
                if (file.exists()) {

                    // 删除二维码文件
                    file.delete();
                }

                // 创建二维码文件
                file.createNewFile();

                // 创建缓冲区图像对象
                BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

                // 循环处理所有X轴坐标像素
                for (int x = 0; x < width; x++) {

                    // 循环处理所有Y轴坐标像素
                    for (int y = 0; y < height; y++) {

                        // 设置缓冲区图像对象RGB内容
                        image.setRGB(x, y, bitMatrix.get(x, y) ? CommonConstants.QR_CODE_LOW_LIGHT_COLOR : CommonConstants.QR_CODE_HIGH_LIGHT_COLOR);
                    }
                }

                // 将二维码信息写入二维码图像文件
                ImageIO.write(image, extension, file);
            }
            // 发生异常
            catch (Exception e) {

                // 抛出应用程序异常
                throw new Exception("ERR_CANNOT_GENERATE_QR_CODE");
            }

        }
    }

    /**
     * 分析二维码图像文件
     * @param path 二维码图像文件路径
     * @return 二维码内容
     * @throws Exception 应用程序异常
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static String parseQRCode(String path) throws Exception {

        // 声明二维码内容
        String content = null;

        // 如果二维码图像文件路径不为空
        if (StringUtils.isNotBlank(path)) {

            // 创建二维码图像文件对象
            File file = new File(path);

            // 如果二维码图像文件对象存在
            if (file.exists()) {

                try {

                    // 加载二维码图像文件
                    BufferedImage image  = ImageIO.read(file);
                    // 创建二维码图像资源
                    LuminanceSource source = new SunLuminanceSource(image);
                    // 创建混合二进制加载器
                    Binarizer binarizer = new HybridBinarizer(source);
                    // 创建二进制位图对象
                    BinaryBitmap bitmap = new BinaryBitmap(binarizer);

                    // 创建二维码提示类型散列表
                    Map hints = new HashMap();
                    // 设置二维码默认字符集
                    hints.put(EncodeHintType.CHARACTER_SET, CommonConstants.DEFAULT_CHAR_CODEC);

                    // 创建多格式读取器
                    MultiFormatReader reader = new MultiFormatReader();
                    // 解码二维码图像
                    Result result = reader.decode(bitmap, hints);
                    // 设置二维码内容
                    content = result.getText();

                    // 如果二维码内容不为空
                    if (StringUtils.isNotBlank(content)) {

                        // 解码二维码内容
                        content = new String(new Base64().decode(content), CommonConstants.DEFAULT_CHAR_CODEC);
                    }
                }
                // 发生异常
                catch (Exception e) {

                    // 抛出应用程序异常
                    throw new Exception("ERR_CANNT_PARSE_QR_CODE");
                }
            }
        }

        // 返回二维码内容
        return content;
    }
}
