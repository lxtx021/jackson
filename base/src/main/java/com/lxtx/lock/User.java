package com.lxtx.lock;

/**
 * @author 孙洪波
 * @version 1.0
 * @description
 * @date 2022/3/22
 **/
public class User {
    //柜子
    private Cabinet cabinet;
    //存储的数字
    private int storeNumber;

    public User(Cabinet cabinet,int storeNumber){
        this.cabinet = cabinet;
        this.storeNumber = storeNumber;
    }

    //使用柜子
    public void useCabinet(){
        cabinet.setStoreNumber(storeNumber);
    }
}
