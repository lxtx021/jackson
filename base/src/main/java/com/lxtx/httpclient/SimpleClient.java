package com.lxtx.httpclient;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;

import java.io.IOException;

/**
 * @author jackson
 * @version 1.0  2018/6/4
 */
public class SimpleClient {
    public static void main(String[] args) {
        HttpClient client = new HttpClient();
        // 设置代理服务器地址和端口
        //client.getHostConfiguration().setProxy("proxy_host_addr",proxy_port);
        // 使用 GET 方法 ，如果服务器需要通过 HTTPS 连接，那只需要将下面 URL 中的 http 换成 https

        //使用POST方法
        //HttpMethod method = new PostMethod("https://java.sun.com");
        HttpMethod method=new GetMethod("https://www.baidu.com");
        try {
            client.executeMethod(method);
            //打印服务器返回的状态
            System.out.println(method.getStatusLine());
            //打印返回的信息
            System.out.println(method.getResponseBodyAsString());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //释放连接
            method.releaseConnection();
        }
    }
}
