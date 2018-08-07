package com.lxtx.rpc.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author jackson
 */
public interface HelloService extends Remote {

    String sayHello(String someOne) throws RemoteException;
}
