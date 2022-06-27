package com.lxtx.lock;

/**
 * @author Eternity
 * @version 1.0
 * @description
 * @date 2022/3/22
 **/
public class Cabinet {
    /**
     * 柜子中存储的数字
     */
    private int storeNumber;

    public synchronized void setStoreNumber(int storeNumber){
        this.storeNumber = storeNumber;
    }

    public int getStoreNumber(){
        return this.storeNumber;
    }
}
