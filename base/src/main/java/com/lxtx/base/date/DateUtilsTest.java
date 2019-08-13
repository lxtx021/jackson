package com.lxtx.base.date;

import java.text.ParseException;

public class DateUtilsTest {

    public static class TestSimpleDateFormatThreadSafe extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    this.join(2000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                try {
                    System.out.println(this.getName() + ":" + DateFormateUtils.parse("2018-06-20 01:18:20"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new TestSimpleDateFormatThreadSafe().start();
        }
    }
}
