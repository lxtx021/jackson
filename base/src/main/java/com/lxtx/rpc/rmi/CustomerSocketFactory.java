package com.lxtx.rpc.rmi;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.server.RMISocketFactory;

/**
 * @author jackson
 */
public class CustomerSocketFactory extends RMISocketFactory {

    @Override
    public Socket createSocket(String host, int port) throws IOException {
        return new Socket(host,port);
    }

    @Override
    public ServerSocket createServerSocket(int port) throws IOException {
        if(port==0){
            port = 8888;
        }
        System.out.println("rmi notify :"+port);
        return new ServerSocket(port);
    }
}
