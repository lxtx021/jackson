package com.lxtx.rpc.rmi;

import java.rmi.Naming;

/**
 * @author jackson
 */
public class ClientMain {
    public static void main(String[] args) throws Exception{
        HelloService helloService = (HelloService) Naming.lookup("rmi://localhost:8888/helloService");
        System.out.println("RMI 服务器返回的结果是："+helloService.sayHello("shabi"));
    }
}
