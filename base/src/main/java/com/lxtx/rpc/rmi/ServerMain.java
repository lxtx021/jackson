package com.lxtx.rpc.rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * @author jackson
 */
public class ServerMain {
    public static void main(String[] args) throws  Exception{
        HelloService helloService =new HelloServiceImpl();
        LocateRegistry.createRegistry(8888);
        Naming.bind("rmi://localhost:8888/helloService",helloService);
        System.out.println("ServerMain provide RPC service now");
    }
}
