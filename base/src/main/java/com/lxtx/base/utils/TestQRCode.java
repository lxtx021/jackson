package com.lxtx.base.utils;

public class TestQRCode {
    public static void main(String[] args) {
        try {
            QRCodeUtil.generateQRCode("D:/test.jpg","sun");
//            String a=QRCodeUtil.parseQRCode("D:/test.jpg");
//            System.out.println(a);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }
}
