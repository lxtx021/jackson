package com.lxtx.rpc.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author jackson
 */
public class HelloServiceImpl extends UnicastRemoteObject implements HelloService {
    public HelloServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public String sayHello(String someOne) throws RemoteException {
        return "hello,"+someOne;
    }
}
