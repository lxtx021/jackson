package com.lxtx.base.date;

import java.util.Calendar;

/**
 * @author jackson
 */
public class DateTest {
    public static void main(String[] args) {

        Thread thread =new Thread();
        thread.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(Calendar.getInstance().getTimeInMillis());
            try {
                thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(thread.isAlive()){
            thread.interrupt();
        }
    }
}
