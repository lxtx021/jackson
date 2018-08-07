package com.lxtx.rpc.rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.RMISocketFactory;

/**
 * @author jackson
 */
public class ServerMain {
    public static void main(String[] args) throws  Exception{
        HelloService helloService =new HelloServiceImpl();
        LocateRegistry.createRegistry(8888);
        // 指定通信端口，防止被防火墙拦截
        RMISocketFactory.setSocketFactory(new CustomerSocketFactory());
        Naming.bind("rmi://localhost:8888/helloService",helloService);
        System.out.println("ServerMain provide RPC service now");
    }
}
