package com.lxtx.util;
/*
import com.arronlong.httpclientutil.HttpClientUtil;
import com.arronlong.httpclientutil.builder.HCB;
import com.arronlong.httpclientutil.common.HttpConfig;
import com.arronlong.httpclientutil.common.HttpResult;
import com.arronlong.httpclientutil.common.SSLs;
import com.arronlong.httpclientutil.exception.HttpProcessException;*/
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * httpclient 工具类
 * @author jackson
 */
public class HttpClientUtils {

   /* public static String post(String url,Map<String,Object> map){
        String result="";
        String json = GsonUtil.mapToJson(map);
        //插件式配置生成HttpClient时所需参数（超时、连接池、ssl、重试）
        try {
            HCB hcb = HCB.custom().timeout(1000) //超时
                    .pool(100, 10) //启用连接池，每个路由最大创建10个链接，总连接数限制为100个
                    .sslpv(SSLs.SSLProtocolVersion.TLSv1_2) 	//设置ssl版本号，默认SSLv3，也可以调用sslpv("TLSv1.2")
                    .ssl()  	  	//https，支持自定义ssl证书路径和密码，ssl(String keyStorePath, String keyStorepass)
                    .retry(5);		//重试5次
            org.apache.http.client.HttpClient client = hcb.build();
            //插件式配置请求参数（网址、请求参数、编码、client）
            HttpConfig config = HttpConfig.custom()
                    .url(url)	          //设置请求的url
//                    .map(map)	          //设置请求参数，没有则无需设置
                    .encoding("utf-8") //设置请求和返回编码，默认就是Charset.defaultCharset()
                    .client(client)    //如果只是简单使用，无需设置，会自动获取默认的一个client对象
                    //.inenc("utf-8")  //设置请求编码，如果请求返回一直，不需要再单独设置
                    //.inenc("utf-8")	//设置返回编码，如果请求返回一直，不需要再单独设置
                    .json(json)                          //json方式请求的话，就不用设置map方法，当然二者可以共用。
                    //.context(HttpCookies.custom().getContext()) //设置cookie，用于完成携带cookie的操作
                    //.out(new FileOutputStream("保存地址"))       //下载的话，设置这个方法,否则不要设置
                    //.files(new String[]{"d:/1.txt","d:/2.txt"}) //上传的话，传递文件路径，一般还需map配置，设置服务器保存路径
                    ;
            result = HttpClientUtil.post(config);    //post请求
        } catch (HttpProcessException e) {
            e.printStackTrace();
        }finally {
            return result;
        }
    }


    *//**
     * 获取HttpResult 对象
     * @param url
     * @param map
     * @return
     *//*
    public static HttpResult sendAndGetResp(String url,Map<String,Object> map){
        HttpResult result=null;
        String json = GsonUtil.mapToJson(map);
        //插件式配置生成HttpClient时所需参数（超时、连接池、ssl、重试）
        try {
            HCB hcb = HCB.custom().timeout(1000) //超时
                    .pool(100, 10) //启用连接池，每个路由最大创建10个链接，总连接数限制为100个
                    .sslpv(SSLs.SSLProtocolVersion.TLSv1_2) 	//设置ssl版本号，默认SSLv3，也可以调用sslpv("TLSv1.2")
                    .ssl()  	  	//https，支持自定义ssl证书路径和密码，ssl(String keyStorePath, String keyStorepass)
                    .retry(5);		//重试5次
            org.apache.http.client.HttpClient client = hcb.build();
            //插件式配置请求参数（网址、请求参数、编码、client）
            HttpConfig config = HttpConfig.custom()
                    .url(url)	          //设置请求的url
//                    .map(map)	          //设置请求参数，没有则无需设置
                    .encoding("utf-8") //设置请求和返回编码，默认就是Charset.defaultCharset()
                    .client(client)    //如果只是简单使用，无需设置，会自动获取默认的一个client对象
                    //.inenc("utf-8")  //设置请求编码，如果请求返回一直，不需要再单独设置
                    //.inenc("utf-8")	//设置返回编码，如果请求返回一直，不需要再单独设置
                    .json(json)                          //json方式请求的话，就不用设置map方法，当然二者可以共用。
                    //.context(HttpCookies.custom().getContext()) //设置cookie，用于完成携带cookie的操作
                    //.out(new FileOutputStream("保存地址"))       //下载的话，设置这个方法,否则不要设置
                    //.files(new String[]{"d:/1.txt","d:/2.txt"}) //上传的话，传递文件路径，一般还需map配置，设置服务器保存路径
                    ;
            result = HttpClientUtil.sendAndGetResp(config);    //post请求
        } catch (HttpProcessException e) {
            e.printStackTrace();
        }finally {
            return result;
        }
    }


    *//**
     * get 方式访问页面数据
     * @param url
     * @return
     *//*
    public static String get(String url){
        String result = null;
        try {
            result = HttpClientUtil.get(HttpConfig.custom().url(url));
            System.out.println(result);
        } catch (HttpProcessException e) {
            e.printStackTrace();
        }finally {
            return result;
        }
    }*/

    /**
     * 解析url 参数
     * @param url
     * @return
     */
    public static Map<String,String> getQueryParams(String url){
        try {
            Map<String, String> params = new HashMap<String, String>();
            for (String param : url.split("&")) {

                String[] pair= StringUtils.split(param,"=",2);
                String key = URLDecoder.decode(pair[0], "UTF-8");
                String value= URLDecoder.decode(pair[1], "UTF-8");
                params.put(key, value);
            }
            return params;
        } catch (UnsupportedEncodingException ex) {
            throw new AssertionError(ex);
        }
    }
}
